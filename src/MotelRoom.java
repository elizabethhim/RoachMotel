public abstract class MotelRoom {
    //a description of the room
    protected String description;

    /** return description of room
     * @return description of room
     */
    public String getDescription() {
        return description;
    }

    //returns total cost of the room
    public abstract double cost();
}
