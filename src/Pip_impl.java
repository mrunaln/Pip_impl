import java.io.IOException;
import java.util.List;

import model.Tasks;
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
        List<Tasks> allTasks = parser.parseLinesToTasks(lines);
        System.out.println ( allTasks.toString());
        Scheduler scheduleMe = new Scheduler();
        scheduleMe.getSchedule(allTasks);
    }
}