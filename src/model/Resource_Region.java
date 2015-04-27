package model;

/**
 * Created by mrunalnargunde on 4/21/15.
 */
public class Resource_Region {

    String resource_name;
    int from_time;
    int len_of_region;
    int resource_release_time;

    public Resource_Region(String rn, int f_time, int len_time){
        this.resource_name = rn;
        this.from_time = f_time;
        this.len_of_region = len_time;
        this.current_allocated_resource = false;
        this.remaining_execution_time = len_time;
        this.resource_release_time = -1;
    }
    public String getResource_name() {
        return resource_name;
    }

    public int getFrom_time() {
        return from_time;
    }


    public int getResource_release_time() {
        return resource_release_time;
    }

    public void setResource_release_time(int resource_release_time) {
        this.resource_release_time = resource_release_time;
    }

    public int getRemaining_execution_time() {
        return remaining_execution_time;
    }

    public void setRemaining_execution_time(int remaining_execution_time) {
        this.remaining_execution_time = remaining_execution_time;
    }

    int remaining_execution_time;
    boolean current_allocated_resource;

    public boolean isCurrent_allocated_resource() {
        return current_allocated_resource;
    }

    public void setCurrent_allocated_resource(boolean current_allocated_resource) {
        this.current_allocated_resource = current_allocated_resource;
    }
}
