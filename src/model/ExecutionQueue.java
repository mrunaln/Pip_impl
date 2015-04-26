package model;

import java.util.List;

/**
 * Created by mrunalnargunde on 4/21/15.
 */
public class ExecutionQueue {
    // LIST OF ACTIONS = { LOCK , UNLOCK }
    //This class is the output that I am going to write to the output file.

    List<Task> task;
    Resource_Region resourceRegion;
    int time_unit;            // {0, 1, 2, 3 , 4 , 5}
    int job_number;           //1 , 2 ,3 . . .
    String Action;
    String current_priority;

    ExecutionQueue(){

        // New task
        // New resource region
    }

    public int getTime_unit() {
        return time_unit;
    }

    public void setTime_unit(int time_unit) {
        this.time_unit = time_unit;
    }

    public int getJob_number() {
        return job_number;
    }

    public void setJob_number(int job_number) {
        this.job_number = job_number;
    }

    public String getAction() {
        return Action;
    }

    public void setAction(String action) {
        Action = action;
    }

    public String getCurrent_priority() {
        return current_priority;
    }

    public void setCurrent_priority(String current_priority) {
        this.current_priority = current_priority;
    }


}
