import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;

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
		Button usd_button = new Button("$");
		Button eur_button = new Button("€");
		Button gbp_button = new Button("£");
		Button jpy_button = new Button("¥");

        HBox currencies_box = new HBox(30);
        currencies_box.getChildren().addAll(usd_button, eur_button, gbp_button, jpy_button);
        currencies_box.setAlignment(javafx.geometry.Pos.CENTER);
        
        // ------------------------------------------------------------
        
        // mainbox
        VBox mainbox = new VBox(200);
        mainbox.getChildren().addAll(tl_label_box, currencies_box);
        mainbox.setAlignment(javafx.geometry.Pos.CENTER);
        
        // root Properties
        root.getChildren().addAll(mainbox);
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





