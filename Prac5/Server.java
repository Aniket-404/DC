package Prac5;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            // Create remote object
            HotelBookingImpl obj = new HotelBookingImpl();

            // Create RMI registry on port 5000
            Registry registry = LocateRegistry.createRegistry(5000);
            
            // Bind the remote object to registry
            registry.rebind("HotelBookingService", obj);

            System.out.println("Hotel Booking Server is running on port 5000...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

