/* Authors: Ricardo Alcaraz, Jacob Olsøn, Elizabeth Him
   Purpose: this class uses the factory design pattern to
            to create RoomAmenities
 */

public class AmenitiesFactory {
    private AmenitiesFactory() {}

    /**
     * Creates and returns RoomAmenities
     * @param type the RoomAmenities type being created
     * @param roomType the room which the RoomAmenities applies to
     * @return the requested RoomAmenities
     * @throws InvalidAmenityException prevents invalid RoomAmenities type
     */
    public static RoomAmenities getAmenity(String type, MotelRoom roomType) throws InvalidAmenityException {
        if (type.equalsIgnoreCase("shower")) return new Shower(roomType);
        else if (type.equalsIgnoreCase("spa")) return new Spa(roomType);
        else if (type.equalsIgnoreCase("food bar")) return new FoodBar(roomType);
        else if (type.equalsIgnoreCase("auto refill")) return new AutoRefill(roomType);
        else throw new InvalidAmenityException(type);
    }
}
