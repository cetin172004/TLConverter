import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        
        
        // ------------------------------------------------------------
        // TL Label
        Label tl_label = new Label("37.495513₺");
        tl_label.setStyle("-fx-font-size: 32px; -fx-text-fill: #146C94;");
        
        HBox tl_label_box = new HBox(tl_label);
        tl_label_box.setAlignment(javafx.geometry.Pos.CENTER);
        
        // ------------------------------------------------------------
        // Other Currencies
        HBox currencies_box = new HBox(10);
        
        // ------------------------------------------------------------
        
        
        // root Properties
        root.getChildren().addAll(tl_label_box, currencies_box);
        root.setStyle("-fx-background-color: #F6F1F1;");
        
        Scene scene = new Scene(root,600, 500);
        primaryStage.setTitle("Turkish Lira Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
