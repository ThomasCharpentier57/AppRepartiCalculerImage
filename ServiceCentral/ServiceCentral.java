import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceCentral extends Remote {
    public void enregistrerServiceCalcul(ServiceCalcul s)throws RemoteException;
    public void traiterImage(ServiceClient c,Scene s, int w, int h)throws RemoteException;
}