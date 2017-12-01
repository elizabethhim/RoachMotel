/* Authors: Ricardo Alcaraz, Jacob Olsøn, Elizabeth Him
   Purpose: this class represents a spray-resistant shower,
            which is a room amenity available for purchase
 */

public class Shower extends RoomAmenities {
    /**cost of a spray-resistant shower*/
    public static final double COST = 25;

    /**add a spray-resistant shower to a room
     * @param roomType the room to add a spray-resistant shower to
     */
    public Shower(MotelRoom roomType) {
        this.roomType = roomType;
    }

    /** return description of room with a spray-resistant shower
     * @return description of room with a spray-resistant shower
     */
    public String getDescription() {
        return roomType.getDescription() + " with a spray-resistant shower";
    }

    /** return cost of room with a spray-resistant shower
     * @return cost of room with a spray-resistant shower
     */
    public double cost() {
        return roomType.cost() + COST;
    }
}
