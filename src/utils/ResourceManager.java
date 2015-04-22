package utils;

import model.Resource_Regions;
import model.Resources;
import model.Tasks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrunalnargunde on 4/21/15.
 */
public class ResourceManager {
    List<Resources> all_resources = new ArrayList<Resources>(5);


    public void handle_Resource_Release(int current_time_instant, List<Tasks> allTasks)
    {
        System.out.println("Handle resource Release!");
    }

    public void handle_Resource_Request(int current_time_instant, Tasks current_Task)
    {
        System.out.println("-----------------------------------");
        System.out.println("Handle resource Request!");
        List<Resource_Regions> resource_regions = current_Task.getResource_regions();
        int start_time_of_Task = current_Task.getPhase();
        for (int i = 0 ; i < resource_regions.size() ; i++){

            if (current_time_instant ==  resource_regions.get(i).getFrom_time() + start_time_of_Task ) {
                // Job is requesting a resource at current time instant
                System.out.println("Yes job is released at curr time instant");
                System.out.println("Now checking res availability");
                boolean available = checkResourceAvailability(resource_regions.get(i).getResource_name());
                if(available){
                    System.out.println("Yes available . Allocating resource");
                    allocateResource();
                    // FIXME Check priority and execution correct job
                }else{
                    // FIXME
                    System.out.println("Res NOT available now");
                    // Compare priority of currently res holding task
                }
            }else{
                // NO Request
                System.out.println("No resource req at curr time");
            }
        }

        System.out.println("-----------------------------------");
    }
    // Checks if resource is free
    public boolean checkResourceAvailability(String res_nam)
    {
        //Resources res = new Resources();
        System.out.println("Checking resource Availability !");
        return true;
    }

    public void allocateResource(){
        System.out.println("Allocate resource!");
    }
}
