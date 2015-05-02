package utils;

import model.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by mrunalnargunde on 4/21/15.
 */
public class Scheduler {
    int steps;
    public PriorityQueue<QueueItem> queue;
    public PriorityQueue<QueueItem> pip_queue;
    public Comparator<QueueItem> pip_comparator;
    Comparator<QueueItem> comparator;
    List<OutputSchedule> outputScheduleList;

    public Scheduler(int steps){
        this.steps = steps;
        outputScheduleList = new ArrayList<OutputSchedule>(steps);
        comparator = new JobDeadlineComparator();
        pip_comparator = new JobPriorityComparator();
        queue = new PriorityQueue<QueueItem>(steps, comparator);
        pip_queue = new PriorityQueue<QueueItem>(steps, pip_comparator);
    }
    public List<OutputSchedule> getSchedule(List<Task> allTasks)
    {
        //System.out.println("Get Schedule!");
        ResourceManager rm = new ResourceManager();
        EventHandler ev = new EventHandler();

        QueueItem singleItem = new QueueItem(1, allTasks.get(2));
        queue.add(singleItem);
        QueueItem execute_this_task;
        System.out.println("Time \t Task \t Job \t Resource Req");
        String outputScheduleAction;
        for (int time_interval =0; time_interval< steps; time_interval++)
        {
            System.out.print(time_interval + " \t\t ");
            execute_this_task = queue.poll();

            boolean isDeadlineMissed = ev.handle_Missed_Deadlines(time_interval, execute_this_task.getJob_number(), execute_this_task.getTask());
            if(isDeadlineMissed){
                System.out.println("Deadline Missed by task "+ execute_this_task.getTask().getTaskName());
                continue;
            }
             execute_this_task = updateExecutionTime(execute_this_task);

             System.out.print(execute_this_task.getTask().getTaskName() + " \t\t ");
             System.out.print(execute_this_task.getJob_number() + " \t\t ");

            String resourceMessage = rm.handle_Resource_Release(time_interval,execute_this_task.getTask());
            outputScheduleAction = resourceMessage;
            System.out.print(resourceMessage);

            queue = rm.handle_Resource_Request(time_interval+1, execute_this_task.getTask(), allTasks, queue, pip_queue);
            updateResourceRemainingTime(execute_this_task);
            String message = ev.handle_Job_Release(time_interval+1, allTasks, queue);
            if(!message.isEmpty()){
                outputScheduleAction = message;
            }

            System.out.println("  ");
            System.out.println("  ");
            outputScheduleList.add(
                    new OutputSchedule( time_interval,
                    execute_this_task.getTask().getTaskName() + execute_this_task.getJob_number(),
                    outputScheduleAction));
            //outputScheduleAction = ""; // resetting action;
        }
        return outputScheduleList;
    }

    private QueueItem updateExecutionTime(QueueItem execute_this_task) {
        int exec_time = execute_this_task.getTask().getExec_time();
        if(exec_time - 1 > 0 ){
             execute_this_task.getTask().setExec_time(exec_time - 1 );
             queue.add(execute_this_task);
         }else{
             // Poll removes the element from the queue
             execute_this_task = queue.poll();
             //System.out.println("Execution of task is over");
         }
        return execute_this_task;
    }

    private void updateResourceRemainingTime(QueueItem execute_this_task) {
        List<Resource_Region> resource_regions = execute_this_task.getTask().getResource_regions();
        for(Resource_Region one_region : resource_regions){
            if (one_region.isCurrent_allocated_resource()){
                one_region.setRemaining_execution_time(one_region.getRemaining_execution_time() - 1 );
            }
        }
    }
}
