/* Authors: Ricardo Alcaraz, Jacob Olsøn, Elizabeth Him
   Purpose: this class represents a Roach Motel
            and uses the Singleton Design Pattern to limit motel creation
 */
import java.util.ArrayList;
import java.util.HashMap;
//TODO: add methods, if necessary
public class RoachMotel implements Subject {

    /**an instance of Roach Motel*/
    private static RoachMotel motel;

    /**room capacity of Roach Motel*/
    private int capacity;

    /**vacancy condition of Roach Motel*/
    private boolean vacancy;

    /**List of Roach colonies*/
    private HashMap<Integer, MotelRoom> rooms;

    /**WaitList if no vacancy*/
    private static WaitList list;

    /**List of observers*/
    private ArrayList<Observer> observers;

    /**True if state of subject has changed*/
    private boolean changed;

    /**Mutex for synchronization*/
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

    /**creates new instances of a Roach Motel
     * @return an instance of a Roach Motel
     */
    public static synchronized RoachMotel getMotel() {
        if (motel == null) {
            motel = new RoachMotel();
        }
        return motel;
    }

    /**
     * Places a RoachColony into the next available room or adds to WaitList if no room is available
     * @param in the RoachColony being admitted to the room or added to WaitList
     */
    public void admitRoom(MotelRoom in) {
        if (vacancy) rooms.put(rooms.size(), in);
        else list.add(in);
        setVacancy(rooms.size() != capacity);
    }

    /*TEMPORARY METHOD FOR TESTING OBSERVER*/
    public void removeRoom() {
        rooms.remove(4);
        setVacancy(rooms.size() != capacity);
    } // END TEMP

    /**
     * Returns room at given key
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
    public boolean getVacancy() {
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

    /**
     * Registers observers to the subject
     * @param obj observer to be registered
     */
    @Override
    public void register(Observer obj) {
        if (obj == null) throw new NullPointerException("Null Observer");
        synchronized (MUTEX) {
            if (!observers.contains(obj)) observers.add(obj);
        }
    }

    /**
     * Unregisters observers from the subject
     * @param obj observer to be unregistered
     */
    @Override
    public void unregister(Observer obj) {
        synchronized (MUTEX) {
            observers.remove(obj);
        }
    }


    /**
     * Notifies all observers of change in subject's state
     */
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
}
