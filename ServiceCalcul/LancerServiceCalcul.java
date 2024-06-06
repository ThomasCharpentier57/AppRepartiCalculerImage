import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class LancerServiceCalcul {
 
 
    public static void main (String[] args) throws NotBoundException {
        try{
            Registry reg = LocateRegistry.getRegistry(args[0]); /* Récupérer l'annuaire de la machine */
            ServiceCentral d = (ServiceCentral) reg.lookup("serviceCalculImage");
            Calculateur serviceCalcul = new Calculateur();
            ServiceCalcul calcul = (ServiceCalcul) UnicastRemoteObject.exportObject(serviceCalcul, 0);
            d.enregistrerServiceCalcul(calcul);
        } catch (RemoteException e){
            System.out.println("Annuaire non-trouvé" +e.getMessage());
        } catch (NotBoundException e1){
            System.out.println("Service non-trouvé");
        }
    }
}

