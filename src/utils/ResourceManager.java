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

    public void check_any_resource_request(int current_time, List<Tasks> allTasks){
        /*this method finds out if any task from the list requests res at curr instant*/
        List<Resource_Regions> resource_regions;
        for(int i = 0 ; i < allTasks.size(); i++){
            resource_regions = allTasks.get(i).getResource_regions();
            for(int j = 0 ; j < resource_regions.size() ; j++){
                Resource_Regions single_region = resource_regions.get(j);
                if(single_region.getFrom_time() == current_time){
                    System.out.println("Task "+ allTasks.get(i).getTaskName() + " requests Resource - " + resource_regions.get(j).getResource_name() + " requested resource at time = " + current_time);
                    /*FIXME HANDLE this condition ahead*/
                }
            }
        }
    }
    public void handle_Resource_Request(int current_time_instant, Tasks current_Task)
    {
        /*This method is used for checking if currently released task requests for a resource immediately.*/
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
