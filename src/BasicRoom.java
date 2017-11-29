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
