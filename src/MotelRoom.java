/* Authors: Ricardo Alcaraz, Jacob Olsøn, Elizabeth Him
   Purpose: this abstract superclass represents a Motel Room in our Roach Motel
 */

public abstract class MotelRoom {
    /**a description of the room*/
    protected String description;

    /**return description of room
     * @return description of room
     */
    public String getDescription() {
        return description;
    }

    /**return total cost of the room*/
    public abstract double cost();
}
