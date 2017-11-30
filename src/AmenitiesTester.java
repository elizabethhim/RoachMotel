public class AmenitiesTester {
    public static void main(String[] args) {
        MotelRoom room1 = new BasicRoom();
        System.out.println(room1.getDescription());
        System.out.println("$" + room1.cost());

        try {
            room1 = AmenitiesFactory.getAmenity("food bar", room1);
            room1 = AmenitiesFactory.getAmenity("auto refill", room1);
            System.out.println(room1.getDescription());
            System.out.println("$" + room1.cost() + "\n\n");
        } catch (InvalidAmenityException ex) {
            ex.printStackTrace();
        }

        MotelRoom room2 = new BasicRoom();
        System.out.println(room2.getDescription());
        System.out.println("$" + room2.cost());

        try {
            room2 = AmenitiesFactory.getAmenity("shower", room2);
            room2 = AmenitiesFactory.getAmenity("spa", room2);
            System.out.println(room2.getDescription());
            System.out.println("$" + room2.cost() + "\n\n");
        } catch (InvalidAmenityException ex) {
            ex.printStackTrace();
        }
    }
}
