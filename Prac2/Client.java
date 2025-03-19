import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            // Locate the registry on port 5000
            Registry registry = LocateRegistry.getRegistry("localhost", 5000);

            // Lookup the remote object
            StringConcatenation stub = (StringConcatenation) registry.lookup("StringConcatenationService");

            // Call the remote method
            String result = stub.concatenate("Hello, ", "World!");

            // Print the result
            System.out.println("Concatenated String: " + result);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
