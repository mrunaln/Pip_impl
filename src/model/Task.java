package model; /**
 * Created by mrunalnargunde on 4/12/15.
 */
import java.util.ArrayList;
import java.util.List;

public class Task {
    int priority;
    String taskName;
    int phase, period, exec_time, deadline;
    List<Resource_Region> resource_regions = new ArrayList<Resource_Region>(5);



    public Task(String taskName, int phi, int p, int e, int d){

        this.taskName = taskName;
        this.phase = phi;
        this.period = p;
        this.exec_time = e;
        this.deadline = d;
    }

    public List<Resource_Region> getResource_regions() {
        return resource_regions;
    }

    public void setResource_regions(List<Resource_Region> resource_regions) {
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

    /* finds requested resource in list of res regions and updated current_task res_req flag */
    public void updateResourceRegion(String resourceRequested) {
        Resource_Region rr ;
        for (int i = 0 ;i < getResource_regions().size() ; i++){
            rr = getResource_regions().get(i);
            if (rr.getResource_name().equals(resourceRequested)){
                rr.current_requested_resource_region = true;
            }
        }
    }
}
