import java.lang.Math;

public class szesciokat extends figura{
    public double LiczObwod () {
        return 6 * dana;
    }

    public double LiczPole () {
        return 0.25 * 6 * dana * dana * Math.sqrt(3);
    }
    
    szesciokat (double bok) {
        dana = bok;
        pole = LiczPole();
        obwod = LiczObwod();
    }
}
