import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StringConcatenation extends Remote {
    String concatenate(String str1, String str2) throws RemoteException;
}
