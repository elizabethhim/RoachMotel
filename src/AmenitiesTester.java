public class AmenitiesTester {
    public static void main(String[] args) {
        MotelRoom room1 = new BasicRoom(new RoachColony("Bob", 100, 1.10), 5);
        System.out.println(room1.getDescription());
        System.out.println("$" + room1.cost());
        System.out.println(room1.getGuest());

        try {
            room1 = AmenitiesFactory.getAmenity("food bar", room1);
            room1 = AmenitiesFactory.getAmenity("auto refill", room1);
            System.out.println(room1.getDescription());
            System.out.println("$" + room1.cost() + "\n\n");
        } catch (InvalidAmenityException ex) {
            ex.printStackTrace();
        }

        MotelRoom room2 = new BasicRoom(new RoachColony("Lannister", 1200, 1.7), 5);
        System.out.println(room2.getDescription());
        System.out.println("$" + room2.cost());

        try {
            room2 = AmenitiesFactory.getAmenity("shower", room2);
            room2 = AmenitiesFactory.getAmenity("spa", room2);
            System.out.println(room2.getDescription());
            System.out.println(room2.getGuest());
            System.out.println("$" + room2.cost() + "\n\n");
        } catch (InvalidAmenityException ex) {
            ex.printStackTrace();
        }

        /*OBSERVER TEST*/
        RoachMotel motel = RoachMotel.getMotel();
        MotelRoom room3 = room2;
        MotelRoom room4 = room2;
        MotelRoom room5 = room2;
        MotelRoom room6 = room1;
        MotelRoom room7 = room2;
        motel.checkIn(room1);
        motel.checkIn(room2);
        motel.checkIn(room3);
        motel.checkIn(room4);
        motel.checkIn(room5);
        motel.checkIn(room6);
        motel.checkIn(room7);
        for (int i = 1; i <= motel.getCapacity(); i++) {
            System.out.println(motel.getRoom(i).getDescription());
        }
        System.out.println("\n" + motel.getWaitList() + "\n");
        motel.checkOut(4);
        for (int i = 1; i <= motel.getCapacity(); i++) {
            System.out.println(motel.getRoom(i).getDescription());
        }
        System.out.println("\n" + motel.getWaitList());
    }
}
