import java.lang.Math;

public class pieciokat extends figura {
    public double LiczObwod () {
        return 5 * dana;
    }

    public double LiczPole () {
        return 0.25 * dana * dana * Math.sqrt(25 + 10 * Math.sqrt(5));
    }
    
    pieciokat (double bok) {
        dana = bok;
        pole = LiczPole();
        obwod = LiczObwod();
    }
}