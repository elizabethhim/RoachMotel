/* Authors: Ricardo Alcaraz, Jacob Olsøn, Elizabeth Him
   Purpose: this class represents a Roach Motel
            and uses the Singleton Design Pattern to limit motel creation
 */
import java.util.ArrayList;
import java.util.HashMap;
public class RoachMotel implements Subject {

    /**an instance of Roach Motel*/
    private static RoachMotel motel;

    /**room capacity of Roach Motel*/
    private int capacity;

    /**vacancy condition of Roach Motel*/
    private boolean vacancy;

    /**HashMap linking a room key to a Roach Colony value*/
    private HashMap<Integer, MotelRoom> rooms;

    /**number of days since motel opened*/
    private int days = 1;

    /**motel's waitlist*/
    private static WaitList list;

    /**list of observers*/
    private ArrayList<Observer> observers;

    /**true if state of subject has changed*/
    private boolean changed;

    /**mutex for synchronization*/
    private final Object MUTEX = new Object();

    /**private constructor of a motel to prevent new motel creation
     * initial capacity set at five rooms
     * initial vacancy set at true*/
    private RoachMotel() {
        capacity = 5;
        vacancy = true;
        rooms = new HashMap<>();
        list = WaitList.getList();
        observers = new ArrayList<>();
        register(list);
        list.setSubject(this);
    }

    /**create new motel, if none have been created
     * otherwise, return a singleton instance of the motel
     * @return an instance of the Roach Motel
     */
    public static synchronized RoachMotel getMotel() {
        if (motel == null) {
            motel = new RoachMotel();
        }
        return motel;
    }

    /**place a RoachColony into the next available room or adds to WaitList if no room is available
     * @param in the RoachColony being admitted to the room or added to WaitList
     */
    public void admitRoom(MotelRoom in) {
        if (vacancy) rooms.put(rooms.size(), in);
        else list.add(in);
        setVacancy(rooms.size() != capacity);
    }

    /**return room at given key
     * @param key the key of the room to return
     * @return room at given key
     */
    public MotelRoom getRoom(int key) {
        return rooms.get(key);
    }

    /**return capacity of Roach Motel
     * @return capacity of Roach Motel
     */
    public int getCapacity() {
        return capacity;
    }

    /**set capacity of Roach Motel
     * @param capacity new capacity of Roach Motel
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**return vacancy condition of Roach Motel
     * @return vacancy condition of Roach Motel
     */
    public boolean isVacant() {
        return vacancy;
    }

    /**set vacancy condition of Roach Motel
     * @param vacancy new vacancy condition of Roach Motel
     */
    public void setVacancy(boolean vacancy) {
        this.vacancy = vacancy;
        this.changed = true;
        notifyObservers();
    }

    /**return number of occupants currently staying
     * @return number of occupants
     */
    public int getOccupancy() {
        return rooms.size();
    }

    /**register observers to the subject
     * @param obj observer to be registered
     */
    @Override
    public void register(Observer obj) {
        if (obj == null) throw new NullPointerException("Null Observer");
        synchronized (MUTEX) {
            if (!observers.contains(obj)) observers.add(obj);
        }
    }

    /**unregister observers from the subject
     * @param obj observer to be unregistered
     */
    @Override
    public void unregister(Observer obj) {
        synchronized (MUTEX) {
            observers.remove(obj);
        }
    }


    /**notify all observers of change in subject's state*/
    @Override
    public void notifyObservers() {
        ArrayList<Observer> localObservers = null;
        synchronized (MUTEX) {
            if (!changed) return;
            localObservers = new ArrayList<>(observers);
            this.changed = false;
        }
        for (Observer e : localObservers) {
            e.update();
        }
    }

    /**check out a room
     * @param roomNum room number to check out
     */
    public void checkOut(int roomNum) {
        System.out.println("Checking out Room " + roomNum + "! Bill: $" + (rooms.get(roomNum).cost() * rooms.get(roomNum).getDays()));
        rooms.remove(roomNum);
        if (rooms.size() != capacity) {
            setVacancy(true);
        } else {
            setVacancy(false);
        }
    }

    /**increment the days the motel has been operating
     * decrement the days left for each guest
     */
    public void incrementDays() {
        this.days += 1;
        for (int i = 1; i <= capacity; i++) {
            if (rooms.containsKey(i)) {
                MotelRoom room = rooms.get(i);
                room.decrementDays();
            }
        }
    }
}
