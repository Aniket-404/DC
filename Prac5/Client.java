package Prac5;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            // Connect to the registry
            Registry registry = LocateRegistry.getRegistry("localhost", 5000);

            // Lookup the remote object
            HotelBooking stub = (HotelBooking) registry.lookup("HotelBookingService");

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\n---- Hotel Booking System ----");
                System.out.println("1. Book a Room");
                System.out.println("2. Cancel Booking");
                System.out.println("3. View Booked Rooms");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter guest name to book a room: ");
                        String bookName = scanner.nextLine();
                        System.out.println(stub.bookRoom(bookName));
                        break;
                    case 2:
                        System.out.print("Enter guest name to cancel booking: ");
                        String cancelName = scanner.nextLine();
                        System.out.println(stub.cancelBooking(cancelName));
                        break;
                    case 3:
                        List<String> bookedRooms = stub.getBookedRooms();
                        System.out.println("Currently Booked Rooms: " + (bookedRooms.isEmpty() ? "None" : bookedRooms));
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
