/*
    Goal: To create a program that will randomly generate inputs into our roach motel so we can watch from the console
    TODO: list of 50 or so names so we can generate roach colonies and corresponding random inputs for population and growthRate
    TODO: decision maker of how long the roaches are gonna stay in there room and when they're gonna throw parties
    TODO: Day counter and some way to generate delays so it'll happen in ticks of one second
    TODO: menu that has a start program and quit program,(and maybe some way for the user to but in and enter their own stuff?)

 */

import java.util.ArrayList;
import java.util.HashSet;

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
            randParties();
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


    /**Chooses random rooms to throw parties*/
    public static void randParties() {
        int num = randomizer.getRandNum(5) + 1;
        HashSet<Integer> numArray = new HashSet<Integer>();
        for(int i = 0; i < num; i++) {
            int temp = randomizer.getRandNum(5)+1;
            numArray.add(temp);
        }
        for(int index: numArray) {
            if(!motel.isRoomVacant(index)) {
                int tempPop = motel.getRoom(index).getGuest().getPopulation();
                MotelRoom room = motel.getRoom(index);
                motel.getRoom(index).getGuest().throwParty();
                System.out.println(motel.getRoom(index).getGuest().getName() + " has threw a party population grew from " + tempPop + " to " + motel.getRoom(index).getGuest().getPopulation());
                tempPop = room.getGuest().getPopulation();
                if(room.getDescription().contains("shower")){
                    tempPop = (int) ((double) tempPop * .75);
                    System.out.println("has shower");
                } else {
                    tempPop = (int) ((double) tempPop * .5);
                    System.out.println("no shower");
                }
                room.getGuest().setPopulation(tempPop);
                System.out.println("Motel has sprayed room " + index + motel.getRoom(index).getGuest().getName() + " population has fallen to " + motel.getRoom(index).getGuest().getPopulation());
            }
        }

    }

}

