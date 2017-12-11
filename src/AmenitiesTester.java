public class AmenitiesTester {
    public static void main(String[] args) {
        MotelRoom room1 = new BasicRoom(new RoachColony("Bob", 100, 1.10));
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

        MotelRoom room2 = new BasicRoom(new RoachColony("Lannister", 1200, 1.7));
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
        motel.admitRoom(room1);
        motel.admitRoom(room2);
        motel.admitRoom(room3);
        motel.admitRoom(room4);
        motel.admitRoom(room5);
        motel.admitRoom(room6);
        for (int i = 0; i < motel.getCapacity(); i++) {
            System.out.println(motel.getRoom(i).getDescription());
        }
        motel.removeRoom();
        for (int i = 0; i < motel.getCapacity(); i++) {
            System.out.println(motel.getRoom(i).getDescription());
        }
    }
}
