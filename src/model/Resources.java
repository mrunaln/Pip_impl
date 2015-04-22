package model;

/**
 * Created by mrunalnargunde on 4/21/15.
 */

// FIXME Not sure if I will need this class. Currently I think so.

public class Resources {

    String resource_name;
    String resource_status; // LOCKED = 0 / UNLOCKED = 1
    int time_instant;

    public static void initStatus(){
        System.out.println("Initializing resource status!");
        // Set all resource status = unlocked
    }
}
