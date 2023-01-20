import java.util.Random;

public class zad_1a {
    public static void main(String[] args) {
        //Słaby generator LCG
        Random random = new Random();
        random.setSeed(68374278);

        int liczba;
        for(int i = 0; i <= 1000000; i += 1) {
            liczba = Math.abs(random.nextInt() % 2);
            System.out.print(liczba);
        }
    }
}