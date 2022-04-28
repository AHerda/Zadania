import java.lang.Math;

public class kolo extends figura{
    public double LiczObwod () {
        return 2 * Math.PI * dana;
    }

    public double LiczPole () {
        return dana * dana * Math.PI;
    }
    
    kolo (double promien) {
        dana = promien;
        
        pole = LiczPole();
        obwod = LiczObwod();
    }
}
