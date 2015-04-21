package model;

/**
 * Created by mrunalnargunde on 4/21/15.
 */
public class Resource_Regions {
        String resource_name;
        int from_time, len_of_region;

        public Resource_Regions(String rn, int f_time, int len_time){
            this.resource_name = rn;
            this.from_time = f_time;
            this.len_of_region = len_time;
        }
    }
