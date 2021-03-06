/* Authors: Ricardo Alcaraz, Jacob Olsøn, Elizabeth Him
   Purpose: this class represents a auto-refillable food bar,
            which is a room amenity available for purchase
 */

//TODO: ensure AutoRefill can only be purchased if FoodBar has been purchased

public class AutoRefill extends RoomAmenities {
    /**cost of a automatically refilled food bar*/
    public static final double COST = 5;

    /**add a food bar to a room
     * @param roomType the room to add a food bar to
     */
    public AutoRefill(MotelRoom roomType) {
        this.roomType = roomType;
    }

    /**return description of room with an automatically refilled food bar
     * @return description of room with an automatically refilled food bar
     */
    public String getDescription() {
        return roomType.getDescription() + " that is automatically refilled";
    }

    /** return cost of room with food bar
     * @return cost of room with food bar
     */
    public double cost() {
        return roomType.cost() + COST;
    }
}
