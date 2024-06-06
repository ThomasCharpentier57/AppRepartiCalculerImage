import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class LancerClient {
    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.getRegistry("localhost"); /* Récupérer l'annuaire de la machine */
            ServiceCentral d = (ServiceCentral) reg.lookup("serviceCalculImage");
            Scene s = new Scene(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
            Disp disp = new Disp("Raytracer", Integer.parseInt(args[1]), Integer.parseInt(args[2]));
            Client c = new Client(disp);
            try{
                            ServiceClient sc = (ServiceClient) UnicastRemoteObject.exportObject(c, 0);
            d.traiterImage(sc, s, Integer.parseInt(args[1]), Integer.parseInt(args[2]));

            }catch(RemoteException e){
                System.out.println(e.getMessage());
            }



        } catch (RemoteException e) {
            System.out.println("Annuaire non-trouvé");
        } catch (NotBoundException e2) {
            System.out.println("Service non-trouvé");
        }

    }
}