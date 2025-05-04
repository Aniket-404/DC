import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            // Locate the registry on port 5000
            Registry registry = LocateRegistry.getRegistry("localhost", 5000);

            // Lookup the remote object
            StringConcatenation stub = (StringConcatenation) registry.lookup("StringConcatenationService");

            // Take input from the user
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter first string: ");
            String str1 = scanner.nextLine();
            System.out.print("Enter second string: ");
            String str2 = scanner.nextLine();

            // Call the remote method
            String result = stub.concatenate(str1, str2);

            // Print the result
            System.out.println("Concatenated String: " + result);
            scanner.close();

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
