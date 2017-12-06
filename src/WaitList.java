import java.util.PriorityQueue;

public class WaitList implements Observer {
    /**Instance of WaitList*/
    private static WaitList list;

    /**Instance of RoachMotel*/
    private static RoachMotel m;

    /**Queue holding RoachColonies in WaitList*/
    private PriorityQueue<RoachColony> waitlist;

    /**
     * Private constructor to prevent multiple WaitLists
     */
    private WaitList() {
        waitlist = new PriorityQueue<>();
        m = RoachMotel.getMotel();
    }

    /**
     * Create and/or return singleton instance of WaitList
     * @return singleton instance of WaitList
     */
    public static synchronized WaitList getList() {
        if (list == null) list = new WaitList();
        return list;
    }

    /**
     * Adds a RoachColony to the WaitList
     * @param in the RoachColony being added to the WaitList
     */
    public void add(RoachColony in) {
        waitlist.add(in);
    }

    /**
     * Receives update from RoachMotel and checks in a RoachColony if there is vacancy
     */
    @Override
    public void update() {
        if (m.getVacancy()) m.admitRoom(waitlist.remove());
    }
}
