public class kwadrat extends czworokat{
    public double LiczPole () {
        return bok1 * bok2;
    }
    
    kwadrat (double bok1_pom, double bok2_pom, double bok3_pom, double bok4_pom, double kat_pom) {
        super(bok1_pom, bok2_pom, bok3_pom, bok4_pom, kat_pom);
        pole = LiczPole();
        obwod = LiczObwod();
    }
}