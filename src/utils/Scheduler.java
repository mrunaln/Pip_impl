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
     public static final Resources resources = new Resources();

    public PriorityQueue<QueueItem> queue;
    public PriorityQueue<QueueItem> pip_queue;
    public Comparator<QueueItem> pip_comparator = new JobPriorityComparator();

    public List<Task> getSchedule(List<Task> allTasks)
    {
        //System.out.println("Get Schedule!");
        Comparator<QueueItem> comparator = new JobDeadlineComparator();
        queue = new PriorityQueue<QueueItem>(20, comparator);

        pip_queue = new PriorityQueue<QueueItem>(20, pip_comparator);

        List<OutputSchedule> outputSchedule = new ArrayList<OutputSchedule>(12); // FIXME 12 is randomly taken number
        ResourceManager rm = new ResourceManager();
        EventHandler ev = new EventHandler();
        Resources.initStatus();

        /*FIXME Harding for now */
        QueueItem singleItem = new QueueItem(1, allTasks.get(2));
        queue.add(singleItem);
        System.out.println("Time \t Task \t Job \t Resource Req");
        for (int time_interval =0; time_interval<8; time_interval++) // FIXME 12 is randomly taken number
        {
            System.out.print(time_interval + " \t\t ");
            QueueItem execute_this_task;

            // Peek does not remove element from the queue
             execute_this_task = queue.poll();
             execute_this_task = updateExecutionTime(execute_this_task);

            System.out.print(execute_this_task.getTask().getTaskName() + " \t\t ");
             System.out.print(execute_this_task.getJob_number() + " \t\t ");

            // FIXME add current time to output schedule -> queue.setTime_unit(time_interval);

            String resourceUnlockMessage = rm.handle_Resource_Release(time_interval,execute_this_task.getTask());
            System.out.print(resourceUnlockMessage);

            //rm.handle_Resource_Request(time_interval, allTasks);
            // Checked if released job is asking for resource

            queue = rm.handle_Resource_Request(time_interval+1, execute_this_task.getTask(), allTasks, queue, pip_queue);
            updateResourceRemainingTime(execute_this_task);
            ev.handle_Job_Release(time_interval+1, allTasks, queue);

            //rm.check_any_resource_request(time_interval, allTasks);
            //ev.handle_Missed_Deadlines(time_interval, allTasks);
            //FIXME outputSchedule.add();


            System.out.println("  ");
            System.out.println("  ");

        }
        return allTasks;
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
