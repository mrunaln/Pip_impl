package model;

/**
 * Created by mrunalnargunde on 4/21/15.
 */
public class Resource_Region {
    public String getResource_name() {
        return resource_name;
    }

    public void setResource_name(String resource_name) {
        this.resource_name = resource_name;
    }

    public int getFrom_time() {
        return from_time;
    }

    public void setFrom_time(int from_time) {
        this.from_time = from_time;
    }

    public int getLen_of_region() {
        return len_of_region;
    }

    public void setLen_of_region(int len_of_region) {
        this.len_of_region = len_of_region;
    }

    String resource_name;
    int from_time, len_of_region;
    boolean current_allocated_resource;

    public boolean isCurrent_allocated_resource() {
        return current_allocated_resource;
    }

    public void setCurrent_allocated_resource(boolean current_allocated_resource) {
        this.current_allocated_resource = current_allocated_resource;
    }

    public Resource_Region(String rn, int f_time, int len_time){
        this.resource_name = rn;
        this.from_time = f_time;
        this.len_of_region = len_time;
        this.current_allocated_resource = false;
    }
}
