package model;

/**
 * Created by mrunalnargunde on 4/26/15.
 */
public class OutputSchedule {
    //This class is the output that I am going to write to the output file.

    String TaskName;
    int time_unit;            // {0, 1, 2, 3 , 4 , 5}
    int job_number;           //1 , 2 ,3 . . .
    String Action;          // LOCK UNLOCK
    String resourceUsed;    // R1, R2, R3
    String current_priority;

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
