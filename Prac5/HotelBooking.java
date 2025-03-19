package Prac5;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface HotelBooking extends Remote {
    String bookRoom(String guestName) throws RemoteException;
    String cancelBooking(String guestName) throws RemoteException;
    List<String> getBookedRooms() throws RemoteException;
}