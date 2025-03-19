import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            // Create an instance of the remote object
            StringConcatenationImpl obj = new StringConcatenationImpl();

            // Create RMI registry on port 5000
            Registry registry = LocateRegistry.createRegistry(5000);
            
            // Bind the remote object in the registry
            registry.rebind("StringConcatenationService", obj);

            System.out.println("Server is running on port 5000...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
