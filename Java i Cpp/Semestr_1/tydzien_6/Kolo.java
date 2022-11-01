import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

//Nowa klasa kola
public class Kolo extends Circle {
    public Kolo(double x, double y, double r) {
        super(x, y, r);
        setFill(Color.YELLOWGREEN);
        setOnMouseClicked(new KoloEventHandler());
        setOnMouseDragged(new KoloEventHandler());
        setOnScroll(new KoloScrollHandler());
    }

    //Funkcja sprawdza czy kursor najechal na figure
    private boolean IsHit(double x, double y) {
        return getBoundsInLocal().contains(x,y);
    }




    //Implementacja przesuwania figury
    class KoloEventHandler implements EventHandler<MouseEvent> {
        Kolo kolo;
        double x, y;

        //Funkcja przesuwa kolo
        private void Move(MouseEvent event) {
            double dx = event.getX() - x;
            double dy = event.getY() - y;

            //Sprawdza czy kursor jest na kole i przesuwa go jesli tak
            if(kolo.IsHit(x, y)) {
                kolo.setCenterX(kolo.getCenterX() + dx);
                kolo.setCenterY(kolo.getCenterY() + dy);
            }
            //Update pozycji kursora
            x = x + dx;
            y = y + dy;
        }

        @Override
        public void handle(MouseEvent event) {
            kolo = (Kolo) event.getSource();
            if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
                x = event.getX();
                y = event.getY();
            }
            if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                Move(event);
            }   
        }
    }




    //Implementacja zmiany rozmiaru figury
    class KoloScrollHandler implements EventHandler<ScrollEvent> {
        Kolo kolo;

        //Funkcja zmienia rozmiar kolo
        private void Scale(ScrollEvent event) {
            double x = event.getX();
            double y = event.getY();

            //Sprawdza CZy kursor jest na prostokacie i zmienia rozmiar jesli tak
            if(kolo.IsHit(x, y)) {
                kolo.setRadius(kolo.getRadius() + kolo.getRadius() * event.getDeltaY() * 0.01);
            }
        }

        @Override
        public void handle(ScrollEvent event) {
            kolo = (Kolo) event.getSource();
            if(event.getEventType() == ScrollEvent.SCROLL) {
                Scale(event);
            }
        }
    }
}