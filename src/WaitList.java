/* Authors: Ricardo Alcaraz, Jacob Olsøn, Elizabeth Him
   Purpose: this class represents a waitlist for the Roach Motel
            and observes the vacancy status to fill empty rooms
 */

import java.util.AbstractQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class WaitList implements Observer {
    /**instance of waitlist*/
    private static WaitList list;

    /**instance of Roach Motel*/
    private static RoachMotel m;

    /**queue holding RoachColonies in WaitList*/
    private LinkedBlockingQueue<MotelRoom> waitlist;

    /**private constructor of a motel to prevent new waitlist creation*/
    private WaitList() {
        waitlist = new LinkedBlockingQueue<>();
    }

    /**create new waitlist, if none have been created
     * otherwise, return a singleton instance of the waitlist
     * @return an instance of the waitlist
     */
    public static synchronized WaitList getList() {
        if (list == null) list = new WaitList();
        return list;
    }

    /**add a RoachColony to the WaitList
     * @param in the RoachColony being added to the WaitList
     */
    public void add(MotelRoom in) {
        waitlist.add(in);
    }

    /**receive update from RoachMotel and check in a RoachColony if there is vacancy
     */
    @Override
    public void update() {
        if (m.isVacant() && waitlist.size() > 0) m.admitRoom(waitlist.remove());
    }

    /**get instance of the observer's subject
     * @param sub the subject of the observer
     */
    @Override
    public void setSubject(Subject sub) {
        this.m = (RoachMotel)sub;
    }
}
