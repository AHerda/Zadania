public class LiczbyPierwsze {
    private int pierwsze[];

    public LiczbyPierwsze (int n) {
        pierwsze = new int[n];
        int miejsce = 0;

        for(int i = 2; i <= n; i += 1) {
            int licznik = 0;
            for(int j = 1; j * j <= i; j += 1) {
                if(i % j == 0){
                    licznik += 1;
                    if(licznik == 2) {
                        break;
                    }
                }
            }
            if(licznik < 2) {
                    pierwsze[miejsce] = i;
                    miejsce += 1;
            }
        }
    }

    public int liczba(int m) {
        return pierwsze[m];
    }
}