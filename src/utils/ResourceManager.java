package utils;

import model.QueueItem;
import model.Resource_Region;
import model.Resources;
import model.Task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by mrunalnargunde on 4/21/15.
 */
public class ResourceManager {
    List<Resources> all_resources = new ArrayList<Resources>(5);



    public String handle_Resource_Release(int current_time_instant, Task currentTask)
    {
       // System.out.println("Handle resource Release!");
        List<Resource_Region> resource_regions;
        String returnMsg;
        returnMsg = "";
            resource_regions = currentTask.getResource_regions();
            for (Resource_Region single_region : resource_regions) {
                if (single_region.getRemaining_execution_time() == 0 &&
                        single_region.isCurrent_allocated_resource()) {
                    //System.out.println("Task " + currentTask.getTaskName() + " releases Resource - " + single_region.getResource_name() + "at time = " + current_time_instant);
                    single_region.setCurrent_allocated_resource(false);
                    single_region.setResource_release_time(current_time_instant);
                    returnMsg += " Unlocks" + " " + single_region.getResource_name();
                }
            }
        return returnMsg;
    }

    public void check_any_resource_request(int current_time, List<Task> allTasks){
        /*this method finds out if any task from the list requests res at curr instant*/
        List<Resource_Region> resource_regions;
        for (Task allTask : allTasks) {
            resource_regions = allTask.getResource_regions();
            for (Resource_Region single_region : resource_regions) {
                if (single_region.getFrom_time() == current_time) {
                   // System.out.println("Task " + allTask.getTaskName() + " requests Resource - " + single_region.getResource_name() + " requested resource at time = " + current_time);
                    /*FIXME HANDLE this condition ahead*/
                }
            }
        }
    }
    public PriorityQueue<QueueItem> handle_Resource_Request(int current_time_instant,Task current_released_Task,  List<Task> allTasks,
                                        PriorityQueue<QueueItem> queue, PriorityQueue<QueueItem> pip_queue) {
        /*This method is used for checking if currently released task requests for a resource immediately.*/
        //System.out.println("-----------------------------------");
        //System.out.println("Handle resource Request!");

        List<Resource_Region> resource_regions = current_released_Task.getResource_regions();
        //int start_time_of_Task = current_Task.getPhase();
        for (Resource_Region resource_region : resource_regions) {

            // THIS condition not sure of working correctly
            if (  resource_region.getResource_release_time() != (current_time_instant - 1) /*this condition mean the task did not just rel the res and asking it again*/
                    &&
                    current_time_instant >= current_released_Task.getPhase() + resource_region.getFrom_time())
            {
                // Job is requesting a resource at current time instant
                //System.out.println("Yes job is released at curr time instant");
                //System.out.println("Now checking res - " +resource_region.getResource_name() +" availability for task" + current_released_Task );
                int availableOrBlockedByTaskIndex = checkResourceAvailability(resource_region.getResource_name(), allTasks);
                if (availableOrBlockedByTaskIndex == -1) {
                    //System.out.println("Yes available . Allocating resource");
                    allocateResource(resource_region.getResource_name(), current_released_Task);
                    // FIXME Check priority and execution correct job
                } else {
                    // FIXME
                    Task res_owning_task = allTasks.get(availableOrBlockedByTaskIndex);
                   // System.out.println("Res NOT available now. Blocked by " + res_owning_task.getTaskName());
                    // current_released_Task is blocked due to allTasks.get(availableOrBlockedByTaskIndex)

                    // Below if intended only if C blocks B. as B high prio than C
                    // Not executed when C blocks D.  As C high prio than D
                    if(res_owning_task.getCurrent_priority() > current_released_Task.getCurrent_priority())
                    {
                        res_owning_task.setAssigned_priority(current_released_Task.getCurrent_priority() );
                        while(!queue.isEmpty())
                        {
                            pip_queue.add(queue.poll());
                        }
                        return pip_queue;
                    }
                    //
                    // Compare priority of currently res holding task
                    // update the assigned priority in output-schedule

                }
            } else {
                // NO Request
               // System.out.println("No resource req at curr time");
            }
        }
        //System.out.println("-----------------------------------");
        return queue;
    }
    // Checks if resource is free
    // returns -1 if the resource is free
    // Else returns index of task which blocked it.
    public int checkResourceAvailability(String res_name,  List<Task> allTasks)
    {
       // System.out.println("Checking" + res_name + "resource Availability !");
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

                    //System.out.println("Resource is already allocated to task -" + allTasks.get(i).getTaskName());
                    return i;
                }
            }
        }
       // System.out.println("Resource is currently available ");
        return -1;
    }

    public void allocateResource(String resourceRequested, Task current_task){
        current_task.updateResourceRegion(resourceRequested);
        System.out.println("Allocated resource " + resourceRequested );
    }
}
