import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocationManager manager = new LocationManager();

        while (true) {
            System.out.println("\n--- Smart City Route Planner ---");
            System.out.println("1. Add a new location");
            System.out.println("2. Remove a location");
            System.out.println("3. Add a road between locations");
            System.out.println("4. Remove a road");
            System.out.println("5. Display all connections");
            System.out.println("6. Display all locations (from AVL Tree)");
            System.out.println("7. Find path between locations (BFS)");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = -1;

            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
                continue;
            }
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter location name: ");
                    manager.addLocation(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Enter location name to remove: ");
                    manager.removeLocation(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Enter first location: ");
                    String from = sc.nextLine();
                    System.out.print("Enter second location: ");
                    String to = sc.nextLine();
                    manager.addRoad(from, to);
                    break;
                case 4:
                    System.out.print("Enter first location: ");
                    from = sc.nextLine();
                    System.out.print("Enter second location: ");
                    to = sc.nextLine();
                    manager.removeRoad(from, to);
                    break;
                case 5:
                    manager.showConnections();
                    break;
                case 6:
                    manager.showAllLocations();
                    break;
                case 7:
                    System.out.print("Enter start location: ");
                    from = sc.nextLine();
                    System.out.print("Enter end location: ");
                    to = sc.nextLine();
                    manager.findPath(from, to);
                    break;
                case 8:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}