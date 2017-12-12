/*
    Goal: To create a program that will randomly generate inputs into our roach motel so we can watch from the console
    TODO: list of 50 or so names so we can generate roach colonies and corresponding random inputs for population and growthRate
    TODO: decision maker of how long the roaches are gonna stay in there room and when they're gonna throw parties
    TODO: Day counter and some way to generate delays so it'll happen in ticks of one second
    TODO: menu that has a start program and quit program,(and maybe some way for the user to but in and enter their own stuff?)

 */

import java.util.ArrayList;

public class main {

    private static RoachMotelRandomizer randomizer = new RoachMotelRandomizer();
    private static RoachMotel motel = RoachMotel.getMotel();

    public static void main(String[] args) {


        //Starting initial run of program
        int user_input = RoachMotelMenu.initialMenu();


        while(user_input != 2) {
            user_input = RoachMotelMenu.mainMenu();
            admitAtRandom(randomizer.getRandNum(5));
            System.out.println(motel.getOccupancy());
            motel.incrementDays(1);
        }

    }

    /**Takes in a list of RoachColonies ready to be admitted to the motel
     * Displays in console who left as well
     * @param guests
     */
    public static void admitAtRandom(int num) {
        for(int i = 0; i < num; i++) {
            try {
                Thread.sleep(1);
                MotelRoom tempRoom = randomizer.getRandomRoom();
                motel.checkIn(tempRoom);
                System.out.println(tempRoom.getGuest().getName() + " has checked in to the hotel");
            } catch (InterruptedException ie)
            {
                System.out.println("Scanning...");
            }
        }
    }

    /**Takes in an integer list of guests that have decided to leave and checks them out from the motel
     * Displays in console who has checked out
     * @param guests
     */
    public static void checkoutAtRandom(ArrayList<Integer> guests) {

    }

}

