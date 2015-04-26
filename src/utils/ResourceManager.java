package utils;

import model.Resource_Region;
import model.Resources;
import model.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrunalnargunde on 4/21/15.
 */
public class ResourceManager {
    List<Resources> all_resources = new ArrayList<Resources>(5);


    public void handle_Resource_Release(int current_time_instant, List<Task> allTasks)
    {
        System.out.println("Handle resource Release!");
    }

    public void check_any_resource_request(int current_time, List<Task> allTasks){
        /*this method finds out if any task from the list requests res at curr instant*/
        List<Resource_Region> resource_regions;
        for (Task allTask : allTasks) {
            resource_regions = allTask.getResource_regions();
            for (Resource_Region single_region : resource_regions) {
                if (single_region.getFrom_time() == current_time) {
                    System.out.println("Task " + allTask.getTaskName() + " requests Resource - " + single_region.getResource_name() + " requested resource at time = " + current_time);
                    /*FIXME HANDLE this condition ahead*/
                }
            }
        }
    }
    public void handle_Resource_Request(int current_time_instant, Task current_Task)
    {
        /*This method is used for checking if currently released task requests for a resource immediately.*/
        System.out.println("-----------------------------------");
        System.out.println("Handle resource Request!");
        List<Resource_Region> resource_regions = current_Task.getResource_regions();
        int start_time_of_Task = current_Task.getPhase();
        for (Resource_Region resource_region : resource_regions) {

            if (current_time_instant == resource_region.getFrom_time() + start_time_of_Task) {
                // Job is requesting a resource at current time instant
                System.out.println("Yes job is released at curr time instant");
                System.out.println("Now checking res availability");
                boolean available = checkResourceAvailability(resource_region.getResource_name());
                if (available) {
                    System.out.println("Yes available . Allocating resource");
                    allocateResource(resource_region.getResource_name(), current_Task);
                    // FIXME Check priority and execution correct job
                } else {
                    // FIXME
                    System.out.println("Res NOT available now");
                    // Compare priority of currently res holding task
                }
            } else {
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

    public void allocateResource(String resourceRequested, Task current_task){
        current_task.updateResourceRegion(resourceRequested);
        System.out.println("Allocate resource!");
    }
}
