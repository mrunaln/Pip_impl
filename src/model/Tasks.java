package model; /**
 * Created by mrunalnargunde on 4/12/15.
 */
import java.util.ArrayList;
import java.util.List;

public class Tasks {

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

    @Override
    public String toString() {
        return super.toString();
    }
}
