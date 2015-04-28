package model;

/**
 * Created by mrunalnargunde on 4/26/15.
 */
public class OutputSchedule {

    int time_unit;            // {0, 1, 2, 3 , 4 , 5}
    String TaskJobNumber;           //1 , 2 ,3 . . .
    String Action;          // LOCK UNLOCK
    String current_priority;

    public OutputSchedule(int time, String taskJobNo, String Action){
        this.time_unit = time;
        this.TaskJobNumber = taskJobNo;
        this.Action = Action;
    }
    public int getTime_unit() {
        return time_unit;
    }

    public void setTime_unit(int time_unit) {
        this.time_unit = time_unit;
    }

    public String getTaskJobNumber() { return TaskJobNumber; }

    public void setTaskJobNumber(String TaskJobNumber) {
        this.TaskJobNumber = TaskJobNumber;
    }

    public String getAction() {
        if(Action != null)
            return Action;
        else
           return "";
    }

    public void setAction(String action) {
        Action = action;
    }

    public String getCurrent_priority() {
        if (current_priority != null)
            return current_priority;
        else
            return "";
    }

    public void setCurrent_priority(String current_priority) {
        this.current_priority = current_priority;
    }

    @Override
    public String toString(){
        return getTime_unit() + "\t" +  getTaskJobNumber() + "\t" + getAction() + "\t" + getCurrent_priority();
    }
}
