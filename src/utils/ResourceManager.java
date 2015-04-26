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
    public void handle_Resource_Request(int current_time_instant,Task current_released_Task,  List<Task> allTasks) {
        /*This method is used for checking if currently released task requests for a resource immediately.*/
        //System.out.println("-----------------------------------");
        //System.out.println("Handle resource Request!");

        List<Resource_Region> resource_regions = current_released_Task.getResource_regions();
        //int start_time_of_Task = current_Task.getPhase();
        for (Resource_Region resource_region : resource_regions) {

            // THIS condition not sure of working correctly
            if (current_time_instant == current_released_Task.getPhase() + resource_region.getFrom_time())
            {
                // Job is requesting a resource at current time instant
                //System.out.println("Yes job is released at curr time instant");
                //System.out.println("Now checking res - " +resource_region.getResource_name() +" availability for task" + current_released_Task );
                boolean available = checkResourceAvailability(resource_region.getResource_name(), allTasks);
                if (available) {
                    //System.out.println("Yes available . Allocating resource");
                    allocateResource(resource_region.getResource_name(), current_released_Task);
                    // FIXME Check priority and execution correct job
                } else {
                    // FIXME
                    //System.out.println("Res NOT available now");
                    // Compare priority of currently res holding task
                    // update the assigned priority in output-schedule
                }
            } else {
                // NO Request
                //System.out.println("No resource req at curr time");
            }
        }
        //System.out.println("-----------------------------------");
    }
    // Checks if resource is free
    public boolean checkResourceAvailability(String res_name,  List<Task> allTasks)
    {
        /*FIXME check in all task res regions if the res is available */
        //System.out.println("Checking" + res_name + "resource Availability !");
        for(int i=0; i < allTasks.size() ; i++)
        {
            List<Resource_Region> currResRegionList = allTasks.get(i).getResource_regions();
            for(int j=0;j< currResRegionList.size() ; j++) {
                /* if the resource is already allocated to some other task then
                 * return false */
                if (currResRegionList.get(j).getResource_name().equals(res_name)
                        && currResRegionList.get(j).isCurrent_allocated_resource()) {

                    /* FIXME
                       Maybe need to check the priority
                    *  Maybe need to update current priority in output schedule
                    *  */
                    System.out.println("Resource is already allocated to task -" + allTasks.get(i).getTaskName());
                    return false;
                }
            }
        }
       // System.out.println("Resource is currently available ");
        return true;
    }

    public void allocateResource(String resourceRequested, Task current_task){
        current_task.updateResourceRegion(resourceRequested);
        System.out.println("Allocated resource!");
    }
}
