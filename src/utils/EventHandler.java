package utils;

import model.Tasks;

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

    public void handle_Job_Release(int current_time_instant, List<Tasks> allTasks)
    {
        //checkIfResourceRequest();

    }
    public void handle_Missed_Deadlines(int current_time_instant, List<Tasks> allTasks)
    {

    }
}
