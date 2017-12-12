/* Authors: Ricardo Alcaraz, Jacob Olsøn, Elizabeth Him
   Purpose: this class represents a Basic Room in our Roach Motel,
            which is a type of Motel Room
 */

public class BasicRoom extends MotelRoom{
    /**cost of a basic room*/
    public static final double COST = 50;

    /**default constructor for a basic room*/
    public BasicRoom() {
        this.guest = null;
        description = "Room";
    }

    /**constructor: places a Roach Colony in a basic room
     * @param guest the Roach Colony
     */
    public BasicRoom(RoachColony guest) {
        this.guest = guest;
        description = "Room";
    }

    /**return cost of a room
     * @return cost of a room
     */
    public double cost() {
        return COST;
    }


}
