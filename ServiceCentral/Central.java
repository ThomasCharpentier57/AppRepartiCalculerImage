import java.util.ArrayList;
import java.rmi.RemoteException;
import java.lang.Thread;

public class Central extends Thread implements ServiceCentral {
    private ArrayList<ServiceCalcul> listService;
    private int nbImage;

    private Image imgActuel;
    private ServiceClient servCli;
    private int ServiceActu;
    private Scene scene;
    private int width;
    private int height;
    private int xx;
    private int yy;

    Central(int n) {
        this.listService = new ArrayList<ServiceCalcul>();
        this.nbImage = n;
    }

    public void enregistrerServiceCalcul(ServiceCalcul s) throws RemoteException{
        synchronized(listService){
            this.listService.add(s);
        }
    }

    public void run(){
        try {
            this.servCli.afficherImage(listService.get(ServiceActu).calculer(scene, this.xx * this.width, this.yy * this.height, this.width, this.height), this.xx * this.width, this.yy * this.height);
        } catch(RemoteException e){
            this.listService.remove(listService.get(ServiceActu));
            if(ServiceActu+1<this.listService.size()){
                ServiceActu++;
            } else {
                ServiceActu = 0;
            }
            try {
                this.servCli.afficherImage(listService.get(ServiceActu).calculer(scene, this.xx * this.width, this.yy * this.height, this.width, this.height), this.xx * this.width, this.yy * this.height);
        } catch(RemoteException b){
            System.out.println("erreur");    
        }
        }
    }


    public void traiterImage(ServiceClient c, Scene s, int w, int h) throws RemoteException{
        this.servCli = c;
        this.scene = s;
        int w2 = w / this.nbImage;
        int h2 = h / this.nbImage;
        int iService = 0;

        for (int x = 0; x < this.nbImage; x++) {
            for (int y = 0; y < this.nbImage; y++) {
                    this.width = w2;
                    this.height = h2;
                    this.ServiceActu = iService;
                    this.xx = x;
                    this.yy = y;
                    this.run();
                    iService = this.ServiceActu;

                    if(iService+1<this.listService.size()){
                        iService++;
                    } else {
                        iService = 0;
                    }
            }
                
        }

    }




}