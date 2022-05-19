import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

//Nowa klasa prostokata
public class Prostokat extends Rectangle {
    Circle kolko;
    public Prostokat(double x, double y, double width, double height, Pane pane) {
        super(x, y, width, height);
        setFill(Color.AQUA);
        setOnMouseClicked(new ProstokatEventHandler());
        setOnMouseDragged(new ProstokatEventHandler());
        setOnScroll(new ProstokatScrollHandler());

        //Tworzenie kolka do zmiany prostokata
        kolko = new Circle(x + width, y + height, 4);
        kolko.setFill(Color.BLACK);
        kolko.setOnMouseDragged(new KolkoEventHandler());
        
        pane.getChildren().add(kolko);
    }

    //Funkcja sprawdza czy kursor najechal na figure
    private boolean IsHit(double x, double y) {
        return getBoundsInLocal().contains(x,y);
    }




    //Implementacja przesuwania figury
    class ProstokatEventHandler implements EventHandler<MouseEvent> {
        Prostokat prostokat;
        double x, y;

        //Funkcja przesuwa prostokat
        private void Move(MouseEvent event) {
            double dx = event.getX() - x;
            double dy = event.getY() - y;

            //Sprawdza czy kursor jest na prostokacie i przesuwa go jesli tak
            if(prostokat.IsHit(x, y)) {
                prostokat.setX(prostokat.getX() + dx);
                prostokat.setY(prostokat.getY() + dy);

                //zmiana pozycji kolka
                kolko.setCenterX(kolko.getCenterX() + dx);
                kolko.setCenterY(kolko.getCenterY() + dy);
            }
            //Update pozycji kursora
            x = x + dx;
            y = y + dy;
        }

        @Override
        public void handle(MouseEvent event) {
            prostokat = (Prostokat) event.getSource();

            if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
                x = event.getX();
                y = event.getY();
            }
            if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                Move(event);
            }   
        }
    }




    //Implementacja zmieniania rozmiaru figury
    class ProstokatScrollHandler implements EventHandler<ScrollEvent> {
        Prostokat prostokat;

        //Funkcja zmienia rozmiar prostokat
        private void Scale(ScrollEvent event) {
            double x = event.getX();
            double y = event.getY();

            //Sprawdza CZy kursor jest na prostokacie i zmienia rozmiar jesli tak
            if(prostokat.IsHit(x, y)) {
                prostokat.setWidth(prostokat.getWidth() + prostokat.getWidth() * event.getDeltaY() * 0.01);
                prostokat.setHeight(prostokat.getHeight() + prostokat.getHeight() * event.getDeltaY() * 0.01);

                //zmiana pozycji kolka
                prostokat.kolko.setCenterX(prostokat.getX() + prostokat.getWidth());
                prostokat.kolko.setCenterY(prostokat.getY() + prostokat.getHeight());
            }
        }

        @Override
        public void handle(ScrollEvent event) {
            prostokat = (Prostokat) event.getSource();
            if(event.getEventType() == ScrollEvent.SCROLL) {
                Scale(event);
            }
        }
    }


    

    //Implementacja przesuwania kolka
    class KolkoEventHandler implements EventHandler<MouseEvent> {
        Circle kolko;
        double x, y;

        //Funkcja przesuwa kolko
        private void Move(MouseEvent event) {
            double dx = event.getX() - x;
            double dy = event.getY() - y;
            
            //Jesli kursor jest na kolko to zmienia jego miejsce oraz zmienia wymiary prostokat
            if(kolko.getBoundsInLocal().contains(x, y)) {
                if(getWidth() + dx  > 5 && getHeight() + dy > 5) {
                    setWidth(getWidth() + dx);
                    setHeight(getHeight() + dy);
    
                    kolko.setCenterX(kolko.getCenterX() + dx);
                    kolko.setCenterY(kolko.getCenterY() + dy);
                }
            }
            //Update pozycji kursora
            x = x + dx;
            y = y + dy;
        }

        @Override
        public void handle(MouseEvent event) {
            kolko = (Circle) event.getSource();

            if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
                x = event.getX();
                y = event.getY();
            }
            if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                Move(event);
            }   
        }
    }
}