package utils;

import model.JobExection;
import model.Tasks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrunalnargunde on 4/21/15.
 */
public class Scheduler {


    public List<Tasks> getSchedule(List<Tasks> allTasks)
    {
        List<JobExection> schedule = new ArrayList<JobExection>(12); // FIXME 12 is randomly taken number
        ResourceManager rm = new ResourceManager();
        EventHandler ev = new EventHandler();

        for (int time_interval =0; time_interval<12; time_interval++) // FIXME 12 is randomly taken number
        {
            JobExection job = new JobExection();
            job.setTime_unit(time_interval);

            rm.handle_Resource_Release(time_interval,allTasks);

            rm.handle_Resource_Request(time_interval, allTasks);

            ev.handle_Job_Release(time_interval, allTasks);

            ev.handle_Missed_Deadlines(time_interval, allTasks);
            schedule.add(job);


        }
        return allTasks;
    }


}
