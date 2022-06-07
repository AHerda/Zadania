import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * Główna klasa programu
 * @author Adrian Herda
 * @version 1.0
 * @param x liczba kolumn w gridzie
 * @param y liczba wierszy w gridzie
 * @param k opóźnienie z jakim działa wątek
 * @param p prawdopodobienstwo zmiany koloru komórki na losowy kolor
 * @param r generator liczb losowych
 */
public class Symulacja extends Application{
    public static int x, y;
    public static double k, p;
    public static Random r = new Random();

    /**
     * Metoda main programu
     * @param args użytkownik podaje wymiary tabeli kafelków, opóźnienie wątków oraz prawdopodobieństwo
     */
    public static void main(String[] args) {
        try {
            x = Integer.parseInt(args[0]);
            y = Integer.parseInt(args[1]);
            k = Double.parseDouble(args[2]);
            p = Double.parseDouble(args[3]);
            if(x <= 0 || y <= 0 || k <= 0 || p < 0 || p > 1) {
                throw new NumberFormatException();
            }
        }
        catch(NumberFormatException e) {
            System.out.println("Nieprawidlowy format liczb!");
            System.exit(0);
        }

        launch(args);
    }

    /**
     * Metoda inicjująca działanie programu
     * @param stage główny panel interfejsu
     */
    @Override
    public void start(Stage stage) throws Exception {
        MyGrid grid = new MyGrid(x, y, k, p);
        Scene symulacja = new Scene(grid, 30 * x, 30 * y, Color.WHITESMOKE);
        stage.setTitle("Symulacja");
        stage.setScene(symulacja);
        stage.show();
    }
}
