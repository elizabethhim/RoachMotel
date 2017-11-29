/* Authors: Ricardo Alcaraz, Jacob Olson, Elizabeth Him
   Purpose: this class represents a BasicRoom in our RoachMotel,
            which is a type of MotelRoom
 */

public class BasicRoom extends MotelRoom{
    //cost of a basic room
    public static final double COST = 50;

    /**default constructor of a basic room*/
    public BasicRoom() {
        description = "Basic Room";
    }

    /**return cost of a room
     * @return cost of a room
     */
    public double cost() {
        return COST;
    }
}
