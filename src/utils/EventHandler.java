package utils;

import model.QueueItem;
import model.Task;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by mrunalnargunde on 4/11/15.
 */
public class EventHandler {

    /*
    Resource Release
    Job Released
    Resource Request
    Resource Acquired
    Job Aborted
    Job Running
    Job Completed
    */



    public int checkIfJobRelease(int current_time_instant, List<Task> allTasks){
        for (int i = 0 ; i < allTasks.size() ; i++){
            if ( current_time_instant == allTasks.get(i).getPhase())
            {
                 // Yes i-th position task is released.
                // job number  = current_time_instant /  allTasks.get(i).getPhase()
                return i;
            }
        }

        //no currently released job found.
        return -1;

    }
    public void handle_Job_Release(int current_time_instant, List<Task> allTasks, PriorityQueue<QueueItem> queue)
    {
        //System.out.println("-----------------------------------");
        //System.out.println(" Handle job release");
        /*
        Find job released at the curr instant
        if yes,
            Check if it requests res
            if yes,
                find out if the res is free
                then can we allocate it
            else no
                just see if any other job is executing now.
                if yes then EDF
                else no then this curr job executes.
        * */
        ResourceManager rm = new ResourceManager();
        int releasedJobPosition = checkIfJobRelease(current_time_instant, allTasks);
        int job_number;
        if(releasedJobPosition != -1)
        {
            //System.out.println(" Task release now is = " + allTasks.get(releasedJobPosition).getTaskName());

            job_number = getJobNumberofTask(current_time_instant, allTasks, releasedJobPosition);
            // This condition is not happening in the current example at any point.
            /* i.e use case : Job is released and immediately askes for resource. */
            //rm.handle_Resource_Request(current_time_instant, allTasks.get(releasedJobPosition), allTasks);

            System.out.println(" Task " + allTasks.get(releasedJobPosition).getTaskName()+ " " + job_number + " adding to queue");
            QueueItem singleItem = new QueueItem(job_number, allTasks.get(releasedJobPosition));
            queue.offer(singleItem);
        }else{
            // No currently released job found
            //System.out.println("NO job release now");
        }
        // FIXME WHO GETS TO Execute now ?
        // Job released at current time instant is found (location is releasedJobPosition )
        // Go on updating the job execution pojo so that you will have a track of who is currently executing etc
        // Print who is executing now.
        //System.out.println("-----------------------------------");

    }

    private int getJobNumberofTask(int current_time_instant, List<Task> allTasks, int releasedJobPosition) {
        int job_number;
        if(allTasks.get(releasedJobPosition).getPhase() == 0){
            job_number = 1;
            //System.out.println(" Job number = 1 " );
        }else{
            job_number = current_time_instant /  allTasks.get(releasedJobPosition).getPhase();
            //System.out.println(" Job number = " + current_time_instant /  allTasks.get(releasedJobPosition).getPhase());
        }
        return job_number;
    }

    public void handle_Missed_Deadlines(int current_time_instant, List<Task> allTasks)
    {

    }
}
