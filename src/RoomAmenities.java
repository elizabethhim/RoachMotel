/* Authors: Ricardo Alcaraz, Jacob Olsøn, Elizabeth Him
   Purpose: this abstract superclass represents room amenities
            available for purchase at our Roach Motel,
            which extends Motel Room
 */

public abstract class RoomAmenities extends MotelRoom{
    /**return description of Motel Room*/
    public abstract String getDescription();

    /**Room held by the Amenity*/
    protected MotelRoom roomType;

    public RoachColony getGuest() {
        return roomType.getGuest();
    }

    /**return number of days stayed*/
    public int getDays() { return roomType.getDays(); }

    /**decrement days left*/
    public void decrementDays() { roomType.decrementDays(); }

    public int getDaysLeft() {
        return roomType.getDaysLeft();
    }
}
