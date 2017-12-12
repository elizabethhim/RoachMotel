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
            System.out.println("Motel currently has " + motel.getOccupancy() + " guests");
            System.out.println("Day " + motel.getDays());
            System.out.println(motel.getWaitList());
            System.out.println(motel.getWaitList().size());
            motel.incrementDays();

        }

    }

    /**Takes in a list of RoachColonies ready to be admitted to the motel
     * Displays in console who left as well
     * @param num
     */
    public static void admitAtRandom(int num) {
        if(num == 0){
            System.out.println("No one checked in today");
        } else {
            for(int i = 0; i < num; i++) {
                try {
                    Thread.sleep(1000);
                    MotelRoom tempRoom = randomizer.getRandomRoom();
                    if(motel.isVacant()){
                        System.out.println(tempRoom.getGuest() + " has checked in to the hotel");
                        System.out.println(tempRoom.getGuest().getName() + " has " + tempRoom.getDescription());
                        System.out.println("Staying for " + tempRoom.getDays() + " days");
                    } else {
                        System.out.println("No rooms left " + tempRoom.getGuest().getName() + " has been added to waitlist");
                    }
                    motel.checkIn(tempRoom);
                } catch (InterruptedException ie)
                {
                    System.out.println("Scanning...");
                }
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

