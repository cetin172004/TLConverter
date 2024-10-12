import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        
        // TL Label
        Label tl_label = new Label("37.495513₺");
        
        Scene scene = new Scene(tl_label,600, 500);
        
        primaryStage.setTitle("Turkish Lira Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
