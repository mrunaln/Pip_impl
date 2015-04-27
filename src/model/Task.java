package model; /**
 * Created by mrunalnargunde on 4/12/15.
 */
import java.util.ArrayList;
import java.util.List;

public class Task {
    int current_priority;
    int assigned_priority;
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


    public int getExec_time() { return exec_time; }


    public void setExec_time( int exec_time) { this.exec_time = exec_time; }


    public int getDeadline() { return deadline; }


    public int getAssigned_priority() { return assigned_priority; }


    public void setAssigned_priority(int assigned_priority) {
        this.assigned_priority = assigned_priority;
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


    public int getPhase() { return phase; }


    @Override
    public String toString() {
        return super.toString();
    }


    /* According to the requirement in the document
        * If two jobs have the same absolute deadline, assign higher current_priority to the job that was released earlier
        * */
    public int getCurrent_priority() {
        return current_priority;
    }


    public void setCurrent_priority(int current_priority) {
        this.current_priority = current_priority;
    }


    /* finds requested resource in list of res regions and updated current_task res_req flag */
    public void updateResourceRegion(String resourceRequested) {
        Resource_Region rr ;
        for (int i = 0 ;i < getResource_regions().size() ; i++){
            rr = getResource_regions().get(i);
            if (rr.getResource_name().equals(resourceRequested)){
                rr.current_allocated_resource = true;
            }
        }
    }
}
