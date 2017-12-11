import java.util.*;
import java.io.*;

/* Authors: Ricardo Alcaraz, Jacob Olsøn, Elizabeth Him
   Purpose: This class creates random inputs for our roach motel main program
 */
public class RoachMotelRandomizer {

    /**Holds a list of names to use in our randomizer*/
    private ArrayList<String> names;

    /**Holds the anemities available to the roach colony*/
    private ArrayList<String> amenities;

    /**Class constructor
     * When initialized it will read in the names from a text file called names.txt
     */
    public RoachMotelRandomizer() {
        names = textReader("names.txt");
        Collections.shuffle(names);
        amenities = textReader("amenities.txt");
    }

    /**Returns a randomly generated RoachColony
     * @return RoachColony
     */
    public RoachColony getRandomRoachColony() {
        String randName = names.get((int) ((Math.random() * 100)));
        double randGrowth = 1.00 + Math.random();
        int randPopulation = (int) (Math.random() * 100000) + 1;
        return new RoachColony(randName, randPopulation, randGrowth);
    }

    /**Function to generate return a room with random amenities
     * @param guest MotelRoom to modify
     * @return MotelRoom with new amenities
     */
    public MotelRoom getRandomAmenities(MotelRoom guest) {
        int totalAnemities = (int) (Math.random() * 5);
        HashSet<String> amenities = new HashSet<String>();
        for( int i = 0; i < totalAnemities; i++ ) {
            amenities.add(this.amenities.get((int) (Math.random() * 4)) );
        }
        for( String extra: amenities){
            try {
                guest = AmenitiesFactory.getAmenity(extra, guest);
            }
            catch (InvalidAmenityException iae) {
                System.out.println( iae.getStackTrace() );
            }
        }
        return guest;
    }

    /**Function to return a random motel room with random amenities
     * @return motelroom
     */
    public MotelRoom getRandomRoom() {
        MotelRoom guest = new BasicRoom(getRandomRoachColony());
        return getRandomAmenities( guest );
    }

    /**Function to read in text from a file
     * @param fileName
     * @return ArrayList of Strings of each line of the text document
     */
    private ArrayList<String> textReader(String fileName) {
        ArrayList<String> list = new ArrayList<String>();
        try {
            Scanner fileRead = new Scanner( new File(fileName) );
            while(fileRead.hasNextLine()){
                String temp = fileRead.nextLine();
                list.add(temp);
            }
        } catch(FileNotFoundException fnf) {
            System.out.println( fnf.getStackTrace() );
        }
        return list;
    }



}
