/* Authors: Ricardo Alcaraz, Jacob Olsøn, Elizabeth Him
   Purpose: this class represents a spa,
            which is a room amenity available for purchase
 */

public class Spa extends RoomAmenities {
    /**type of room*/
    protected MotelRoom roomType;

    /**cost of a spa*/
    public static final double COST = 20;

    /**add a spa to a room
     * @param roomType the room to add a spa to
     */
    public Spa(MotelRoom roomType) {
        this.roomType = roomType;
    }

    /** return description of room with a spa
     * @return description of room with a spa
     */
    public String getDescription() {
        return roomType.getDescription() + " with a spa";
    }

    /** return cost of room with a spa
     * @return cost of room with a spa
     */
    public double cost() {
        return roomType.cost() + COST;
    }
}
