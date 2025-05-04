import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.*;

interface HotelService extends Remote {
    String bookRoom(String guestName) throws RemoteException;
    String cancelBooking(String guestName) throws RemoteException;
}

class HotelServiceImpl extends UnicastRemoteObject implements HotelService {
    Map<Integer, String> roomBookings = new HashMap<>();
    final int TOTAL_ROOMS = 5;

    HotelServiceImpl() throws RemoteException {
        super();
        // Initialize rooms (room numbers 101–105)
        for (int i = 101; i < 101 + TOTAL_ROOMS; i++) {
            roomBookings.put(i, null);
        }
    }

    public synchronized String bookRoom(String guestName) throws RemoteException {
        for (Map.Entry<Integer, String> entry : roomBookings.entrySet()) {
            if (entry.getValue() == null) {
                roomBookings.put(entry.getKey(), guestName);
                return "Room " + entry.getKey() + " booked for " + guestName;
            }
        }
        return "Sorry, no rooms available.";
    }

    public synchronized String cancelBooking(String guestName) throws RemoteException {
        for (Map.Entry<Integer, String> entry : roomBookings.entrySet()) {
            if (guestName.equals(entry.getValue())) {
                roomBookings.put(entry.getKey(), null);
                return "Booking for " + guestName + " (Room " + entry.getKey() + ") cancelled.";
            }
        }
        return "No booking found for " + guestName;
    }
}

public class Server {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(5000);
            HotelService service = new HotelServiceImpl();
            Naming.rebind("rmi://localhost:5000/HotelService", service);
            System.out.println("Hotel Booking Server is running...");
        } catch (Exception e) {
            System.out.println("Server error: " + e);
        }
    }
}
