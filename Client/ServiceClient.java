import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceClient extends Remote {
    public void afficherImage(Image i, int x, int y) throws RemoteException;
 
}