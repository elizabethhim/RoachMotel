public class AutoRefill extends RoomAmenities {
    //type of room
    protected MotelRoom roomType;

    //cost of a automatically refilled food bar
    public static final double COST = 5;

    /**add a food bar to a room
     * @param roomType the room to add a food bar to
     */
    public AutoRefill(MotelRoom roomType) {
        this.roomType = roomType;
    }

    /** return description of room with an automatically refilled food bar
     * @return description of room with an automatically refilled food bar
     */
    public String getDescription() {
        return roomType.getDescription() + "with an automatically refilled food bar";
    }

    /** return cost of room with food bar
     * @return cost of room with food bar
     */
    public double cost() {
        return roomType.cost() + COST;
    }
}
