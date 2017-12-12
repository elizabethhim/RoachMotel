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
        names = textReaderNoSpace("names.txt");
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
        int totalAnemities = (int) (Math.random() * 4);
        HashSet<String> amenities = new HashSet<String>();
        for( int i = 0; i < totalAnemities; i++ ) {
            int amenNum = (int) (Math.random() * 3);
            amenities.add(this.amenities.get(amenNum));
            if (amenNum == 0) {
                int randNum = (int)(Math.random() * 2);
                if (randNum == 0) {
                    amenities.add("auto refill");
                }
            }
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

    /**Create a list of Roach Colonies with a random size
     * @return roach colony list
     */
    public ArrayList<RoachColony> getRandomGuests() {
        int randomNumberGuests = (int) (Math.random() * RoachMotel.getMotel().getCapacity());
        ArrayList<RoachColony> colonyList = new ArrayList<>();
        for(int i = 0; i < randomNumberGuests; i++) {
            colonyList.add(getRandomRoachColony());
        }
        return colonyList;
    }

    /**Create a list of random numbers
     * May return an empty list occasionally
     * @return list
     */
    public HashSet<Integer> getRandNumArray() {
        HashSet<Integer> list = new HashSet<>();
        int randomGuestsLeaving = (int) (Math.random() * RoachMotel.getMotel().getOccupancy() );
        for(int i = 0; i < RoachMotel.getMotel().getCapacity(); i++){
            list.add(getRandNum(RoachMotel.getMotel().getCapacity()));
        }
        return list;
    }

    /**Generate a random int from 0 to an upper limit
     * @param high upper limit to return
     * @return random int within the range specified
     */
    public int getRandNum(int high) {
        return (int) (Math.random() * high);
    }

    /**Function to return a random motel room with random amenities
     * @return motelroom
     */
    public MotelRoom getRandomRoom() {
        int randNum = getRandNum(4) + 1;
        MotelRoom guest = new BasicRoom(getRandomRoachColony(), randNum );
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

    /**Function to read in text from a file
     * @param fileName
     * @return ArrayList of Strings of each line of the text document
     */
    private ArrayList<String> textReaderNoSpace(String fileName) {
        ArrayList<String> list = new ArrayList<String>();
        try {
            Scanner fileRead = new Scanner( new File(fileName) );
            while(fileRead.hasNextLine()){
                String temp = fileRead.nextLine();
                list.add(temp.replaceAll("\\s+",""));
            }
        } catch(FileNotFoundException fnf) {
            System.out.println( fnf.getStackTrace() );
        }
        return list;
    }


}
