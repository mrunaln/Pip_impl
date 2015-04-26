package utils;

import model.QueueItem;

import java.util.Comparator;

/**
 * Created by mrunalnargunde on 4/26/15.
 */
public class JobPriorityComparator implements Comparator<QueueItem> {
    @Override
    public int compare(QueueItem x, QueueItem y)
    {
        /*
        Changed comparator for keeping the queue ascending depending on the deadline i.e EDF
        */
        if (x.getTask().getDeadline() == y.getTask().getDeadline()){
            return 0;
        }else if (x.getTask().getDeadline() > y.getTask().getDeadline()){
            return 1;
        }else
            return -1;
    }
}
