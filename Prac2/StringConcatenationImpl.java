import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StringConcatenationImpl extends UnicastRemoteObject implements StringConcatenation {

    // Constructor
    protected StringConcatenationImpl() throws RemoteException {
        super();
    }

    // Implementing the concatenate method
    @Override
    public String concatenate(String str1, String str2) throws RemoteException {
        return str1 + str2;
    }
}
