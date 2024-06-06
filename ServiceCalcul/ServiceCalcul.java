import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceCalcul extends Remote {
    public Image calculer(Scene s, int x1, int x2, int y1, int y2) throws RemoteException;
}