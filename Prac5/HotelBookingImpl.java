package Prac5;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class HotelBookingImpl extends UnicastRemoteObject implements HotelBooking {
    private List<String> bookedRooms;

    // Constructor
    protected HotelBookingImpl() throws RemoteException {
        super();
        bookedRooms = new ArrayList<>();
    }

    // Book a room
    @Override
    public synchronized String bookRoom(String guestName) throws RemoteException {
        if (bookedRooms.contains(guestName)) {
            return "Booking failed: " + guestName + " already has a room.";
        }
        bookedRooms.add(guestName);
        return "Room booked successfully for " + guestName;
    }

    // Cancel a booking
    @Override
    public synchronized String cancelBooking(String guestName) throws RemoteException {
        if (bookedRooms.remove(guestName)) {
            return "Booking canceled for " + guestName;
        }
        return "Cancellation failed: No booking found for " + guestName;
    }

    // Get the list of booked rooms
    @Override
    public synchronized List<String> getBookedRooms() throws RemoteException {
        return bookedRooms;
    }
}
