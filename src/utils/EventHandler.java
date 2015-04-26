package utils;

import model.Task;

import java.util.List;

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
    public void handle_Job_Release(int current_time_instant, List<Task> allTasks)
    {
        System.out.println("-----------------------------------");
        System.out.println(" Handle job release");
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

        int releasedJobPosition = checkIfJobRelease(current_time_instant, allTasks);
        if(releasedJobPosition != -1)
        {
            System.out.println(" Task release now is = " + allTasks.get(releasedJobPosition).getTaskName());

            if(allTasks.get(releasedJobPosition).getPhase() == 0){
                System.out.println(" Job number = 1 " );
            }else{
                System.out.println(" Job number = " + current_time_instant /  allTasks.get(releasedJobPosition).getPhase());
            }
            // Checked if released job is asking for resource
            ResourceManager rm = new ResourceManager();
            rm.handle_Resource_Request(current_time_instant, allTasks.get(releasedJobPosition));


        }else{
            // No currently released job found
            System.out.println("NO job release now");


        }
        // FIXME WHO GETS TO Execute now ?
        // Job released at current time instant is found (location is releasedJobPosition )
        // Go on updating the job execution pojo so that you will have a track of who is currently executing etc
        // Print who is executing now.
        System.out.println("-----------------------------------");

    }
    public void handle_Missed_Deadlines(int current_time_instant, List<Task> allTasks)
    {

    }
}
