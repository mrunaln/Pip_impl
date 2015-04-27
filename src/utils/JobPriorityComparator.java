package utils;

import model.QueueItem;

import java.util.Comparator;

/**
 * Created by mrunalnargunde on 4/26/15.
 */
public class JobPriorityComparator implements Comparator<QueueItem> {
    @Override
    public int compare(QueueItem x, QueueItem y) {
        /*
           when = I want x to be inserted first as x will execute bcuz it owns a resource.
        */
        if (x.getTask().getAssigned_priority() == y.getTask().getAssigned_priority()) {
            return -1;
        } else if (x.getTask().getAssigned_priority() > y.getTask().getAssigned_priority()) {
            return 1;
        }
        return 1;
    }

}
