package model;

/**
 * Created by mrunalnargunde on 4/21/15.
 */
public class Resource_Regions {
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

        public Resource_Regions(String rn, int f_time, int len_time){
            this.resource_name = rn;
            this.from_time = f_time;
            this.len_of_region = len_time;
        }
    }
