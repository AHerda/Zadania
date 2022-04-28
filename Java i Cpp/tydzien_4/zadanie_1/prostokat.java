public class prostokat extends czworokat{
    
    public double LiczPole () {
        if(bok1 != bok2) {
            return bok1 * bok2;
        }
        else {
            return bok1 * bok3;
        }
    }
    
    prostokat (double bok1_pom, double bok2_pom, double bok3_pom, double bok4_pom, double kat_pom) {
        super(bok1_pom, bok2_pom, bok3_pom, bok4_pom, kat_pom);
        pole = LiczPole();
        obwod = LiczObwod();
    }
}
