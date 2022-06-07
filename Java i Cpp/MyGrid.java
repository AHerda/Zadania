import javafx.scene.layout.GridPane;


/**
 * Klasa tworzaca grid prgramu
 * @param kwadraty dwuwymiarowa tablica kwadratow na gridzie
 * @param r generator liczb losowych
 */
public class MyGrid extends GridPane {
    public static Square[][] kwadraty;

    /**
     * Metoda tworzaca MyGrid
     * Tworzy tablice kwadraty oraz startuje watek kazdego kwadratu w tej tablicy
     * @param x liczba kolumn w gridzie
     * @param y liczba wierszy w gridzie
     * @param k opóźnienie z jakim kwadrat zmienia kolor
     * @param p prawdopodobienstwo zmiany koloru kwadratu na losowy kolor
     */
    MyGrid(int x, int y, double k, double p) {
        super();
        //really needed?

        kwadraty = new Square[x][y];
        for(int i = 0; i < x; i += 1) {
            for(int j = 0; j < y; j += 1) {
                kwadraty[i][j] = new Square(30, 30, i, j, k, p);

                kwadraty[i][j].widthProperty().bind(this.widthProperty().divide(Symulacja.x));
                kwadraty[i][j].heightProperty().bind(this.heightProperty().divide(Symulacja.y));

                add(kwadraty[i][j], i, j);
            }
        }

        for(int i = 0; i < x; i += 1) {
            for(int j = 0; j < y; j += 1) {
                kwadraty[i][j].znajdzSasiadow();
                kwadraty[i][j].grid = this;
                
                Thread w = new Thread(kwadraty[i][j]);
                w.start();
            }
        }
        setGridLinesVisible(true);
    }
}
