package model; /**
 * Created by mrunalnargunde on 4/12/15.
 */
import java.util.ArrayList;
import java.util.List;

public class Tasks {
    int priority;
    String taskName;
    int phase, period, exec_time, deadline;
    List<Resource_Regions> resource_regions = new ArrayList<Resource_Regions>(5);

    public Tasks(String taskName, int phi , int p , int e , int d){

        this.taskName = taskName;
        this.phase = phi;
        this.period = p;
        this.exec_time = e;
        this.deadline = d;
    }

    public List<Resource_Regions> getResource_regions() {
        return resource_regions;
    }

    public void setResource_regions(List<Resource_Regions> resource_regions) {
        this.resource_regions = resource_regions;
    }


    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getPhase() {

        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }

    @Override
    public String toString() {
        return super.toString();
    }


    /* According to the requirement in the document
        * If two jobs have the same absolute deadline, assign higher priority to the job that was released earlier
        * */

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
 }
