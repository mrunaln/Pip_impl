package model;

import java.util.List;

/**
 * Created by mrunalnargunde on 4/21/15.
 */
public class QueueItem {

    public int getJob_number() {
        return job_number;
    }

    public void setJob_number(int job_number) {
        this.job_number = job_number;
    }

    int job_number;
    Task task;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public QueueItem(int job_number, Task t){
        this.job_number = job_number;
        this.task = t;
    }


}
