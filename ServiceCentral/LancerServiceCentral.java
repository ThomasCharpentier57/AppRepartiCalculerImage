import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class LancerServiceCentral{
	public static void main(String[] args) {
		try{
			Central c = new Central(1000);
			ServiceCentral sd = (ServiceCentral) UnicastRemoteObject.exportObject(c, 0);
			Registry reg = LocateRegistry.getRegistry("localhost"); /* Création de l'annuaire peut être fait par une commande systeme*/
			reg.rebind("serviceCalculImage", sd);
		} catch (RemoteException e){
			System.out.println("Annuaire non-trouvé : "+ e.getMessage());
		}

	}
}