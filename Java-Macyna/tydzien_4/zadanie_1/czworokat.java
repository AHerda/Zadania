abstract public class czworokat extends figura{
    double bok1, bok2, bok3, bok4;
    double kat;

    czworokat (double bok1_pom, double bok2_pom, double bok3_pom, double bok4_pom, double kat_pom) {
        bok1 = bok1_pom;
        bok2 = bok2_pom;
        bok3 = bok3_pom;
        bok4 = bok4_pom;
        kat = (kat_pom / 360) * Math.PI;
    }
    
    public double LiczObwod () {
        return bok1 + bok2 + bok3 + bok4;
    }
}