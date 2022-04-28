public class WierszTrojkataPascala {
    int liczby[];

    int Silnia(int n) {
        if(n == 0 || n ==1) {
            return 1;
        }
        return n * Silnia(n - 1);
    }

    public WierszTrojkataPascala (int n) {
        liczby = new int[n + 1];
        int chwilowe = Silnia(n);
        for(int indeks = 0; indeks <= n; indeks +=1) {
            liczby[indeks] = chwilowe / (Silnia(indeks) * Silnia(n - indeks));
        }
    }

    public int Liczba(int indeks) {
        return liczby[indeks];
    }
}