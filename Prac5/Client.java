import java.rmi.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            HotelService service = (HotelService) Naming.lookup("rmi://localhost:5000/HotelService");
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\n--- Hotel Booking Menu ---");
                System.out.println("1. Book Room");
                System.out.println("2. Cancel Booking");
                System.out.println("3. Exit");
                System.out.print("Choose option: ");
                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                if (choice == 1) {
                    System.out.print("Enter guest name: ");
                    String name = sc.nextLine();
                    String response = service.bookRoom(name);
                    System.out.println(response);
                } else if (choice == 2) {
                    System.out.print("Enter guest name: ");
                    String name = sc.nextLine();
                    String response = service.cancelBooking(name);
                    System.out.println(response);
                } else if (choice == 3) {
                    System.out.println("Exiting...");
                    break;
                } else {
                    System.out.println("Invalid choice.");
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Client error: " + e);
        }
    }
}
