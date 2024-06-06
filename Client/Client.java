import java.rmi.RemoteException;


public class Client implements ServiceClient{
    Disp disp;

    public Client(Disp d){
        this.disp=d;
    }

    public void afficherImage(Image i, int x, int y) throws RemoteException{
        this.disp.setImage(i, x, y);
    }
}