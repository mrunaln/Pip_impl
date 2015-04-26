package utils;

import model.QueueItem;
import model.Task;

import java.util.Comparator;

/**
 * Created by mrunalnargunde on 4/26/15.
 */
public class JobPriorityComparator implements Comparator<QueueItem> {
    @Override
    public int compare(QueueItem x, QueueItem y)
    {
      if(x.getTask().getPriority() > y.getTask().getPriority()) return 1;
      else return 0;
    }
}
