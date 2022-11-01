import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Paint extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Tworzenie wszystkich czesci menu
        MenuItem prostokat = new MenuItem("Prostokat");
        MenuItem trojkat = new MenuItem("Trojkat");
        MenuItem kolo = new MenuItem("Kolo");
        MenuItem info = new MenuItem("Info");
        MenuItem exit = new MenuItem("Exit");
        MenuItem instrukcja = new MenuItem("Instrukcja");
        Menu menu1 = new Menu("Figury");
        Menu menu2 = new Menu("Opcje");
        MenuBar my_menu = new MenuBar();

        //Skladanie menu w jedna calosc
        menu1.getItems().addAll(prostokat, trojkat, kolo);
        menu2.getItems().addAll(instrukcja, info, exit);

        //Tworzenie dialogu dla menuItem - "info"
        Dialog<String> dialog1 = new Dialog<String>();
        dialog1.setTitle("Info");
        ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
        dialog1.setContentText("Pain JavaFX - Edytor do tworzenia i edycji figur\nAdrian Herda");
        dialog1.getDialogPane().getButtonTypes().add(type);

        //Tworzenie dialogu dla MenuItem - "instrikcja"
        Dialog<String> dialog2 = new Dialog<String>();
        dialog2.setTitle("Instrukcja");
        dialog2.setContentText("INSTRUKCJA\n\n1. Wybierz figure z menu a automatycznie sie narysuje\n2. Za pomoca czarnego" +
" kolka mozesz zmienic wyglad figury (jej wymiary)\n3. Za pomoca scrolla mozesz zmieniac rozmiar figury\n4. Nacisnij na figure, " + 
"przytrzymaj i przesun kursor a figura rowniez sie przesunie");
        dialog2.getDialogPane().getButtonTypes().add(type);

        //Tworzenie glownej czesci progrmau
        BorderPane root = new BorderPane();
        Pane pane = new Pane();
        root.setCenter(pane);

        //Ustawianie funkcjonalalnosci przyciskow menu
        EventHandler<ActionEvent> event_handler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final double srodekPaneX = pane.getLayoutBounds().getWidth() / 2;
                final double srodekPaneY = pane.getLayoutBounds().getWidth() / 2;


                MenuItem m = (MenuItem) event.getSource();
                if(m.getText() == "Exit") {
                    System.exit(0);
                }
                else if(m.getText() == "Info") {
                    dialog1.showAndWait();
                }
                else if (m.getText() == "Instrukcja") {
                    dialog2.showAndWait();
                }
                else if(m.getText() == "Prostokat") {
                    pane.getChildren().add(new Prostokat(srodekPaneX, srodekPaneY, 60, 50, pane));
                }
                else if(m.getText() == "Kolo") {
                    pane.getChildren().add(new Kolo(srodekPaneX, srodekPaneY, 40));
                }
                else if(m.getText() == "Trojkat") {
                    pane.getChildren().add(new Trojkat(srodekPaneX, srodekPaneY + 40 , srodekPaneX - 40, srodekPaneY - 40, srodekPaneX + 40, srodekPaneY - 40, pane));
                }
            }
        };

        //Przypisywanie funkcjonalnosci menu
        trojkat.setOnAction(event_handler);
        prostokat.setOnAction(event_handler);
        kolo.setOnAction(event_handler);
        instrukcja.setOnAction(event_handler);
        info.setOnAction(event_handler);
        exit.setOnAction(event_handler);
        my_menu.getMenus().addAll(menu1, menu2);

        root.setTop(my_menu);

        Scene scene = new Scene(root, 500, 500, Color.WHITESMOKE);

        stage.setTitle("Paint JavaFX");
        stage.setScene(scene);
        stage.show();
    }
}
