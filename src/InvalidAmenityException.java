/* Authors: Ricardo Alcaraz, Jacob Olsøn, Elizabeth Him
   Purpose: this Exception prevents invalid RoomAmenities
 */

public class InvalidAmenityException extends java.lang.Exception {
    public InvalidAmenityException(String type) {
        super("Amenity type: " + type + " does not exist.");
    }
}
