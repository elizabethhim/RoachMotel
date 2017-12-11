/*
    Goal: To create a program that will randomly generate inputs into our roach motel so we can watch from the console
    TODO: list of 50 or so names so we can generate roach colonies and corresponding random inputs for population and growthRate
    TODO: decision maker of how long the roaches are gonna stay in there room and when they're gonna throw parties
    TODO: Day counter and some way to generate delays so it'll happen in ticks of one second
    TODO: menu that has a start program and quit program,(and maybe some way for the user to but in and enter their own stuff?)

 */

public class main {

    public static void main(String[] args) {
        RoachMotelRandomizer randomizer = new RoachMotelRandomizer();
        for( int i = 0; i < 5; i++) {
            System.out.println( randomizer.getRandomRoachColony() );
        }
        for(int i = 0; i < 10; i++) {
            System.out.println(randomizer.getRandomRoom().getDescription());
        }
        RoachMotel motel = RoachMotel.getMotel();
        RoachMotelMenu.initialMenu();
        int user_input = RoachMotelMenu.mainMenu();
        while(user_input == 1) {
            user_input = RoachMotelMenu.mainMenu();
            motel.admitRoom(randomizer.getRandomRoom());
            System.out.println(motel.getOccupancy());
        }

    }





}

