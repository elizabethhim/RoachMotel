/* Authors: Ricardo Alcaraz, Jacob Olsøn, Elizabeth Him
   Purpose: this class represents a Wait List for the
            Roach Motel and observes the vacancy status
            to fill in empty rooms
 */
import java.util.concurrent.LinkedBlockingQueue;

public class WaitList implements Observer {
    /**Instance of WaitList*/
    private static WaitList list;

    /**Instance of RoachMotel*/
    private static RoachMotel m;

    /**Queue holding RoachColonies in WaitList*/
    private LinkedBlockingQueue<MotelRoom> waitlist;

    /**
     * Private constructor to prevent multiple WaitLists
     */
    private WaitList() {
        waitlist = new LinkedBlockingQueue<>();
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
    public void add(MotelRoom in) {
        waitlist.add(in);
    }

    /**
     * Returns the WaitList's physical list
     * @return the WaitList's Queue
     */
    public LinkedBlockingQueue getPhysicalList() {
        return waitlist;
    }

    /**
     * Receives update from RoachMotel and checks in a RoachColony if there is vacancy
     */
    @Override
    public void update() {
        if (m.isVacant() && waitlist.size() > 0) m.checkIn(waitlist.remove());
    }

    /**
     * Get instance of the observer's subject
     * @param sub the subject of the observer
     */
    @Override
    public void setSubject(Subject sub) {
        this.m = (RoachMotel)sub;
    }
}
