import java.io.IOException;
import java.util.List;

import model.OutputSchedule;
import model.Task;
import utils.FileHandler;
import utils.Scheduler;
import utils.TaskParser;

/**
 * Created by mrunalnargunde on 4/21/15.
 */
public class Pip_impl {
    public static void main(String... aArgs) throws IOException {
        FileHandler f = new FileHandler();
        List<String> lines = f.getInputTasks();

        TaskParser parser = new TaskParser();

        List<Task> allTasks = parser.parseLinesToTasks(lines);
        assign_priorities(allTasks);

        Scheduler scheduleMe = new Scheduler();
        List<OutputSchedule> output = scheduleMe.getSchedule(allTasks);

        f.printOutputSchedule(output);
    }

    public static void assign_priorities(List<Task> allTasks){
        /* According to the requirement in the document
        * If two jobs have the same absolute deadline, assign higher priority to the job that was released earlier
        * */
        for (int i = 0 ; i < allTasks.size(); i++){
            allTasks.get(i).setCurrent_priority(i + 1);
            allTasks.get(i).setAssigned_priority(i + 1); // Initially assigned priority = current_ priority
        }
    }
}