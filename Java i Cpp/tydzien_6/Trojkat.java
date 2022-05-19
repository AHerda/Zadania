import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Translate;

//Nowa klasa trojkata
public class Trojkat extends Polygon {
    Circle kolko1, kolko2, kolko3;
    //srodek trojkata
    double x0, y0;

    public Trojkat(double x1, double y1, double x2, double y2, double x3, double y3, Pane pane) {
        super();

        //ustalenie wzglednego srodka trojkata
        x0 = (x1+x2+x3)/3;
        y0 = (y1+y2+y3)/3;

        //tworzenie trojkata
        this.getPoints().addAll(x1, y1, x2, y2, x3, y3);

        setOnMouseClicked(new TrojkatEventHandler());
        setOnMouseDragged(new TrojkatEventHandler());
        setOnScroll(new TrojkatScrollHandler());

        //Tworzenie kolek zmeiniajacych ksztalt
        kolko1 = new Circle(x1, y1, 4);
        pane.getChildren().add(kolko1);
        kolko1.setOnMouseClicked(new KolkoEventHandler());
        kolko1.setOnMouseDragged(new KolkoEventHandler());

        kolko2 = new Circle(x2, y2, 4);
        pane.getChildren().add(kolko2);
        kolko2.setOnMouseClicked(new KolkoEventHandler());
        kolko2.setOnMouseDragged(new KolkoEventHandler());

        kolko3 = new Circle(x3, y3, 4);
        pane.getChildren().add(kolko3);
        kolko3.setOnMouseClicked(new KolkoEventHandler());
        kolko3.setOnMouseDragged(new KolkoEventHandler());
        
        setFill(Color.PINK);
    }

    //Funkcja sprawdza czy kursor najechal na figure
    private boolean IsHit(double x, double y) {
        return getBoundsInLocal().contains(x,y);
    }




    //Implementacja przesuwania figury
    class TrojkatEventHandler implements EventHandler<MouseEvent> {
        Trojkat trojkat;
        double x, y;
        

        //Funkcja przesuwa trojkat
        private void Move(MouseEvent event) {
            double dx = event.getX() - x;
            double dy = event.getY() - y;

            ObservableList<Double> punkty = trojkat.getPoints();

            //Sprawdza czy kursor jest na kole i przesuwa go jesli tak
            if(trojkat.IsHit(x, y)) {
                //ustawianie wspolrzednych x wierzcholkow i srodka
                punkty.set(0, punkty.get(0) + dx);
                punkty.set(2, punkty.get(2) + dx);
                punkty.set(4, punkty.get(4) + dx);
                x0 = (punkty.get(0) + punkty.get(2) + punkty.get(4)) / 3;

                //ustawianie wspolrzednych y wierzcholkow i srodka
                punkty.set(1, punkty.get(1) + dy);
                punkty.set(3, punkty.get(3) + dy);
                punkty.set(5, punkty.get(5) + dy);
                y0 = (punkty.get(1) + punkty.get(3) + punkty.get(5)) / 3;               
                
                //przesuwanie kolek razem z trojkatem
                trojkat.kolko1.setCenterX(trojkat.kolko1.getCenterX() + dx);
                trojkat.kolko1.setCenterY(trojkat.kolko1.getCenterY() + dy);
                trojkat.kolko2.setCenterX(trojkat.kolko2.getCenterX() + dx);
                trojkat.kolko2.setCenterY(trojkat.kolko2.getCenterY() + dy);
                trojkat.kolko3.setCenterX(trojkat.kolko3.getCenterX() + dx);
                trojkat.kolko3.setCenterY(trojkat.kolko3.getCenterY() + dy);
            }
            //Update pozycji kursora
            x = x + dx;
            y = y + dy;
        }

        @Override
        public void handle(MouseEvent event) {
            trojkat = (Trojkat) event.getSource();
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
    class TrojkatScrollHandler implements EventHandler<ScrollEvent> {
        Trojkat trojkat;
        double x0, y0;

        //Funkcja zmienia rozmiar trojkata
        private void Scale(ScrollEvent event) {
            double x = event.getX();
            double y = event.getY();

            ObservableList<Double> punkty = trojkat.getPoints();

            //Sprawdza CZy kursor jest na prostokacie i zmienia rozmiar jesli tak
            if(trojkat.IsHit(x, y)) {
                //Obliczanie i ustawianie wspolrzednych x wierzcholkow po sklaowaniu wzgledem jego srodka x0
                x0 = (punkty.get(0) + punkty.get(2) + punkty.get(4)) / 3;
                punkty.set(0, punkty.get(0) + event.getDeltaY() * 0.01 * (punkty.get(0) - x0));
                punkty.set(2, punkty.get(2) + event.getDeltaY() * 0.01 * (punkty.get(2) - x0));
                punkty.set(4, punkty.get(4) + event.getDeltaY() * 0.01 * (punkty.get(4) - x0));
                

                //Obliczanie i ustawianie wspolrzednych y wierzcholkow  po sklaowaniu wzgledem jego srodka y0
                y0 = (punkty.get(1) + punkty.get(3) + punkty.get(5)) / 3;
                punkty.set(1, punkty.get(1) + event.getDeltaY() * 0.01 * (punkty.get(1) - y0));
                punkty.set(3, punkty.get(3) + event.getDeltaY() * 0.01 * (punkty.get(3) - y0));
                punkty.set(5, punkty.get(5) + event.getDeltaY() * 0.01 * (punkty.get(5) - y0));
                

                //Zmiana miejsca kolek
                kolko1.setCenterX(punkty.get(0));
                kolko2.setCenterX(punkty.get(2));
                kolko3.setCenterX(punkty.get(4));

                kolko1.setCenterY(punkty.get(1));
                kolko2.setCenterY(punkty.get(3));
                kolko3.setCenterY(punkty.get(5));
            }
        }

        @Override
        public void handle(ScrollEvent event) {
            trojkat = (Trojkat) event.getSource();
            if(event.getEventType() == ScrollEvent.SCROLL) {
                Scale(event);
            }
        }
    }



    //Implementacja przesuwania kolka
    class KolkoEventHandler implements EventHandler<MouseEvent> {
        Circle kolko;
        double x, y;
        double x0, y0;

        ObservableList<Double> punkty = getPoints();

        //Funkcja przesuwa kolko
        private void Move(MouseEvent event) {
            double dx = event.getX() - x;
            double dy = event.getY() - y;

            //Sprawdza czy kursor jest na kolko i zmienia trojkat
            if(kolko.getBoundsInLocal().contains(x, y)) {
               if(kolko.equals(kolko1)) {
                    kolko.setCenterX(kolko.getCenterX() + dx);
                    kolko.setCenterY(kolko.getCenterY() + dy);
                    punkty.set(0, punkty.get(0) + dx);
                    punkty.set(1, punkty.get(1) + dy);
                }
                else if(kolko.equals(kolko2)) {
                    kolko.setCenterX(kolko.getCenterX() + dx);
                    kolko.setCenterY(kolko.getCenterY() + dy);
                    punkty.set(2, punkty.get(2) + dx);
                    punkty.set(3, punkty.get(3) + dy);
                }
                else if(kolko.equals(kolko3)) {
                    kolko.setCenterX(kolko.getCenterX() + dx);
                    kolko.setCenterY(kolko.getCenterY() + dy);
                    punkty.set(4, punkty.get(4) + dx);
                    punkty.set(5, punkty.get(5) + dy);
                }
                x0 = (punkty.get(0) + punkty.get(2) + punkty.get(4)) / 3;
                y0 = (punkty.get(1) + punkty.get(3) + punkty.get(5)) / 3;
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
