import java.rmi.Remote;

public class Calculateur implements ServiceCalcul {

    public Image calculer(Scene s, int x1, int x2, int y1, int y2){
        return s.compute(x1,x2,y1,y2);
    }

}