package model;

/**
 * Created by mrunalnargunde on 4/21/15.
 */
public class JobExection {
    // LIST OF ACTIONS = { LOCK , UNLOCK }
    //This class is the output that I am going to write to the output file.

    int time_unit;            // {0, 1, 2, 3 , 4 , 5}

    String Task_name;         // A ,B , C , D
    int job_number;           //1 , 2 ,3 . . .

    String Action;
    String resource_name;     // R1 , R2 , R3

    String current_priority;

    public int getTime_unit() {
        return time_unit;
    }

    public void setTime_unit(int time_unit) {
        this.time_unit = time_unit;
    }

    public String getTask_name() {
        return Task_name;
    }

    public void setTask_name(String task_name) {
        Task_name = task_name;
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

    public String getResource_name() {
        return resource_name;
    }

    public void setResource_name(String resource_name) {
        this.resource_name = resource_name;
    }

    public String getCurrent_priority() {
        return current_priority;
    }

    public void setCurrent_priority(String current_priority) {
        this.current_priority = current_priority;
    }


}
