/* Authors: Ricardo Alcaraz, Jacob Olsøn, Elizabeth Him
   Purpose: this class represents a Basic Room in our Roach Motel,
            which is a type of Motel Room
 */

public class BasicRoom extends MotelRoom{
    /**cost of a basic room*/
    public static final double COST = 50;

    /**default constructor of a basic room*/
    public BasicRoom() {
        description = "Room";
    }

    /**return cost of a room
     * @return cost of a room
     */
    public double cost() {
        return COST;
    }
}
