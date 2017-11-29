public class AmenitiesTester {
    public static void main(String[] args) {
        MotelRoom room1 = new BasicRoom();
        System.out.println(room1.getDescription());
        System.out.println("$" + room1.cost());

        room1 = new FoodBar(room1);
        room1 = new AutoRefill(room1);
        System.out.println(room1.getDescription());
        System.out.println("$" + room1.cost() + "\n\n");

        MotelRoom room2 = new BasicRoom();
        System.out.println(room2.getDescription());
        System.out.println("$" + room2.cost());

        room2 = new Shower(room2);
        room2 = new Spa(room2);
        System.out.println(room2.getDescription());
        System.out.println("$" + room2.cost() + "\n\n");
    }
}
