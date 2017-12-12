/* Authors: Ricardo Alcaraz, Jacob Olsøn, Elizabeth Him
   Purpose: this abstract superclass represents room amenities
            available for purchase at our Roach Motel,
            which extends Motel Room
 */

public abstract class RoomAmenities extends MotelRoom{
    /**return description of Motel Room*/
    public abstract String getDescription();

    /**room held by the Amenity*/
    protected MotelRoom roomType;

    /**return Roach Colony guest
     * @return Roach Colony gust
     */
    public RoachColony getGuest() {
        return roomType.getGuest();
    }
}
