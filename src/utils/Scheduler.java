package utils;

import model.JobExecution;
import model.Resources;
import model.Tasks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrunalnargunde on 4/21/15.
 */
public class Scheduler {
     public static final Resources resources = new Resources();


    public List<Tasks> getSchedule(List<Tasks> allTasks)
    {
        System.out.println("Get Schedule!");

        List<JobExecution> schedule = new ArrayList<JobExecution>(12); // FIXME 12 is randomly taken number
        ResourceManager rm = new ResourceManager();
        EventHandler ev = new EventHandler();
        Resources.initStatus();

        for (int time_interval =0; time_interval<12; time_interval++) // FIXME 12 is randomly taken number
        {
            System.out.println("Time instant = " + time_interval);
            JobExecution job = new JobExecution();
            job.setTime_unit(time_interval);

            //rm.handle_Resource_Release(time_interval,allTasks);

            //rm.handle_Resource_Request(time_interval, allTasks);

            ev.handle_Job_Release(time_interval, allTasks);
            rm.check_any_resource_request(time_interval, allTasks);

            //ev.handle_Missed_Deadlines(time_interval, allTasks);
            schedule.add(job);
        }
        return allTasks;
    }


}
