/* Authors: Ricardo Alcaraz, Jacob Olsøn, Elizabeth Him
   Purpose: this class represents a food bar,
            which is a room amenity available for purchase
 */

public class FoodBar extends RoomAmenities {
    /**type of room*/
    protected MotelRoom roomType;

    /**cost of a food bar*/
    public static final double COST = 10;

    /**add a food bar to a room
     * @param roomType the room to add a food bar to
     */
    public FoodBar(MotelRoom roomType) {
        this.roomType = roomType;
    }

    /** return description of room with food bar
     * @return description of room with food bar
     */
    public String getDescription() {
        return roomType.getDescription() + " with a food bar";
    }

    /** return cost of room with food bar
     * @return cost of room with food bar
     */
    public double cost() {
        return roomType.cost() + COST;
    }
}
