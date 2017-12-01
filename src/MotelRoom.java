/* Authors: Ricardo Alcaraz, Jacob Olsøn, Elizabeth Him
   Purpose: this abstract superclass represents a Motel Room in our Roach Motel
 */

public abstract class MotelRoom {
    /**a description of the room*/
    protected String description;

    /**Guest staying in the room*/
    protected RoachColony guest;

    /**return description of room
     * @return description of room
     */
    public String getDescription() {
        return description;
    }

    /**Return guest staying in the room
     * @return guest object
     */
    public Object getGuest() {
        return guest;
    }

    /**return total cost of the room*/
    public abstract double cost();
}
