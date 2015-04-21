/**
 * Created by mrunalnargunde on 4/12/15.
 */
import java.util.ArrayList;
import java.util.List;

public class Tasks {

    String taskName;
    int phase, period, exec_time, deadline;
    List<Resource_Regions> resource_regions = new ArrayList<Resource_Regions>(5);

    Tasks(String taskName, int phi , int p , int e , int d){
        this.taskName = taskName;
        this.phase = phi;
        this.period = p;
        this.exec_time = e;
        this.deadline = d;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
