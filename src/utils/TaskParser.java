package utils;

import model.Resource_Region;
import model.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrunalnargunde on 4/21/15.
 */
public class TaskParser {

    final static List<Task> ALL_TASKs = new ArrayList<Task>(10);

    public  List<Task> parseLinesToTasks(List<String> lines){
        int i;
        for (i=0; i < lines.size() ; i++){
            String oneTask[] = lines.get(i).split(" ");
            Task current_Task = new Task(oneTask[0].trim(),Integer.parseInt(oneTask[1].trim()), Integer.parseInt(oneTask[2].trim()),
                    Integer.parseInt(oneTask[3].trim()), Integer.parseInt(oneTask[4].trim()));


            int no_of_resource_requests = Integer.parseInt(oneTask[5]);
            List<Resource_Region> resource_regions = new ArrayList<Resource_Region>( no_of_resource_requests);
            Resource_Region current_region = null;

            int resource_counter = 6;
            while (no_of_resource_requests > 0 ){
                current_region = new Resource_Region(
                        oneTask[resource_counter++],
                        Integer.parseInt(oneTask[resource_counter++]),
                        Integer.parseInt(oneTask[resource_counter++])
                );
                resource_regions.add(current_region);
                no_of_resource_requests--;
            }
            //current_Task.resource_regions = resource_regions;
            current_Task.setResource_regions(resource_regions);
            ALL_TASKs.add(i, current_Task);
        }
        return ALL_TASKs;
    }
}
