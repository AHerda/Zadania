import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


/**
 * Klasa pojedynczego kwadratu na gridzie
 * Rozszerza klase Rectancgle
 * Implementuje interface Runable
 * @param sasiedzi lista sasiadujacych kafelkow
 * @param aktywny zawiera informacje o tym czy watek jest aktywny
 * @param grid MyGrid do w ktorym znajduje sie dany kwadrat
 * @param r wartosc koloru czerwonego w kwadracie
 * @param g wartosc koloru zielonego w kwadracie
 * @param b wartosc koloru niebieskiego w kwadracie
 */
public class Square extends Rectangle implements Runnable{
    private int wiersz, kolumna;
    public int r, g, b;
    double k, p;
    public boolean aktywny = true;

    public MyGrid grid;

    private List<Square> sasiedzi = new ArrayList<Square>();


    /**
     * Metoda tworzaca kwadrat
     * @param width poczatkowa szerokosc kwadratu
     * @param height poczatkowa wysokosc kwadratu
     * @param kolumna kolumna w ktorej znajduje sie kwadrat
     * @param wiersz wiersz w ktorym znajduje sie kwadrat
     * @param k opóźnienie z jakim kwadrat zmienia kolor
     * @param p prawdopodobienstwo zmiany koloru kwadratu na losowy kolor
     */
    Square(int width, int height, int kolumna, int wiersz, double k, double p)
    {
        super(width, height);

        this.wiersz = wiersz;
        this.kolumna = kolumna;
        this.k = k;
        this.p = p;

        zmienKolor();

        super.setOnMouseClicked(new KwadratEventHandler());
    }

    /**
     * Metoda incjujaca dzialanie watku
     */
    @Override
    public void run() {
        try {
            while(aktywny) {
                synchronized(this) {
                    double czas = Symulacja.r.nextDouble(k) + (0.5 * k);
                    
                    if(Symulacja.r.nextDouble(1) < p) {
                        Platform.runLater(() -> zmienKolor());
                    }
                    else {
                        Platform.runLater(() -> zmienKolorSasiady());
                    }
                    try {wait((long) (czas));} catch(InterruptedException ie) {
                    }
                }
            }
        } catch(Exception e) {}
    }

    /**
     * Metoda zmieniajaca kolor kwadratu na losowy
     */
    void zmienKolor() {
        r = Symulacja.r.nextInt(256);
        g = Symulacja.r.nextInt(256);
        b = Symulacja.r.nextInt(256);

        super.setFill(Color.rgb(r, g, b));
    }

    /**
     * Metoda zmieniajaca kolor kwadratu na srednia kolorow sasiadujacych kwadratow
     */
    void zmienKolorSasiady() {
        int red = 0;
        int green = 0;
        int blue = 0;
        int iterator = 0;
        for(Square kwadrat : sasiedzi) {
            if(kwadrat.aktywny) {
                red += kwadrat.r;
                green += kwadrat.g;
                blue += kwadrat.b;
                iterator += 1;
            }
        }
        if(iterator != 0) {
            r = Math.round(red / iterator);
            g = Math.round(green / iterator);
            b = Math.round(blue / iterator);

            super.setFill(Color.rgb(r, g, b));
        }
        else {
            zmienKolor();
        }
    }

    /**
     * Metoda znajdujaca sasiadow kwadratu
     */
    void znajdzSasiadow() {
        sasiedzi.add(MyGrid.kwadraty[(kolumna + 1) % Symulacja.x][wiersz]);
        sasiedzi.add(MyGrid.kwadraty[(kolumna - 1 + Symulacja.x) % Symulacja.x][wiersz]);
        sasiedzi.add(MyGrid.kwadraty[kolumna][(wiersz + 1) % Symulacja.y]);
        sasiedzi.add(MyGrid.kwadraty[kolumna][(wiersz - 1 + Symulacja.y) % Symulacja.y]);
    }

    //-------------------
    //czesc programu na 5
    //-------------------

    /**
     * Metoda zmienia aktywnosc kwadratu, przerywa dzialanie watku
     */
    synchronized void zmienAktywnosc() {
        try {
            if(aktywny) {
                aktywny = false;


                Platform.runLater(() -> super.setFill(Color.rgb(0, 0, 0)));

                Thread.currentThread().interrupt();
            }
            else {
                aktywny = true;

                Thread w = new Thread(this);
                w.start();
            }
        } catch(Exception e) {}
    }

    /**
     * Klasa obserwujaca czy kwadrat zostal klikniety
     * W razie klikniecia zmienia aktywnosc kwadraru
     */
    class KwadratEventHandler implements EventHandler<MouseEvent> {
        Square kwadrat;

        /**
         * Glowna metoda KwadratEventHandler wywoalywana podczas kazdego uzycia myszki na kwadracie
         * @param event zawiera dowolne uzycie myszki na kwadracie
         * Jesli event to klikniecie myszka, metoda zmienia aktywnosc kwadratu
         */
        @Override
        public void handle(MouseEvent event) {
            kwadrat = (Square) event.getSource();
            if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
                kwadrat.zmienAktywnosc();
            }
        }
    }
}