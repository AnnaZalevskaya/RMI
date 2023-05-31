import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Replacement extends Remote {
    String replaceAllVowelsOnStars(String str) throws RemoteException;
}