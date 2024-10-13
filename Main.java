import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        // sources
        Font font1 = Font.loadFont(getClass().getResourceAsStream("fonts/Play-Regular.ttf"), 30);
        Font font2 = Font.loadFont(getClass().getResourceAsStream("fonts/Play-Regular.ttf"), 40);
        Font font3 = Font.loadFont(getClass().getResourceAsStream("fonts/Play-Regular.ttf"), 15);
        Font font4 = Font.loadFont(getClass().getResourceAsStream("fonts/Play-Bold.ttf"), 30);
        Font font5 = Font.loadFont(getClass().getResourceAsStream("fonts/Play-Regular.ttf"), 20);
        Font font6 = Font.loadFont(getClass().getResourceAsStream("fonts/Play-Bold.ttf"), 15);
        Image lira_image = new Image(getClass().getResourceAsStream("src/lira2.png"));
        
        // ------------------------------------------------------------
        // Info Labels
        Label program_label = new Label("Turkish Lira Converter");
        program_label.setFont(font4);
        
        Label data_source_label = new Label("XE.com Currency");
        data_source_label.setFont(font5);
        
        VBox info_box = new VBox(10);
        info_box.getChildren().addAll(program_label, data_source_label);
        info_box.setAlignment(javafx.geometry.Pos.CENTER);
        
        // TL Image
        ImageView image_view = new ImageView(lira_image);
        image_view.setFitWidth(150);
        image_view.setPreserveRatio(true);
        
        // TL Label
        Label tl_label = new Label("37.495513");
        tl_label.setFont(font2);
        
        HBox tl_label_box = new HBox(tl_label);
        tl_label_box.setAlignment(javafx.geometry.Pos.CENTER);
        
        // ------------------------------------------------------------
        // Other Currencies
		/* buttons */
		Button usd_button = new Button("$");
		Button eur_button = new Button("€");
		Button gbp_button = new Button("£");
		Button jpy_button = new Button("¥");

		/* labels */
		Label usd_label = new Label("USD");
		usd_label.setFont(font6);
		Label eur_label = new Label("EUR");
		eur_label.setFont(font6);
		Label gbp_label = new Label("GBP");
		gbp_label.setFont(font6);
		Label jpy_label = new Label("JPY");
		jpy_label.setFont(font6);
		
		/* buttons styles */
		usd_button.setShape(new Circle(50));
		usd_button.setFont(font1);
		usd_button.setStyle("-fx-faint-focus-color: rgba(0, 0, 0, 0.5);");
		eur_button.setShape(new Circle(50));
		eur_button.setFont(font1);
		eur_button.setStyle("-fx-faint-focus-color: rgba(0, 0, 0, 0.5);");
		gbp_button.setShape(new Circle(50));
		gbp_button.setFont(font1);
		gbp_button.setStyle("-fx-faint-focus-color: rgba(0, 0, 0, 0.5);");
		jpy_button.setShape(new Circle(50));
		jpy_button.setFont(font1);
		jpy_button.setStyle("-fx-faint-focus-color: rgba(0, 0, 0, 0.5);");

		/* vertical boxes */
		VBox usd_box = new VBox(10);
		usd_box.getChildren().addAll(usd_button, usd_label);
		usd_box.setAlignment(javafx.geometry.Pos.CENTER);
		
		VBox eur_box = new VBox(10);
		eur_box.getChildren().addAll(eur_button, eur_label);
		eur_box.setAlignment(javafx.geometry.Pos.CENTER);
		
		VBox gbp_box = new VBox(10);
		gbp_box.getChildren().addAll(gbp_button, gbp_label);
		gbp_box.setAlignment(javafx.geometry.Pos.CENTER);
		
		VBox jpy_box = new VBox(10);
		jpy_box.getChildren().addAll(jpy_button, jpy_label);
		jpy_box.setAlignment(javafx.geometry.Pos.CENTER);
		
		/* button actions */
		usd_button.setOnAction(event -> {
            try {
				FileWriter writer = new FileWriter("currency_data");
				writer.write("usd");
				writer.close();
				ProcessBuilder processBuilder = new ProcessBuilder("python3", "get_values.py");
				Process process = processBuilder.start();
				process.waitFor();
			
				BufferedReader br = new BufferedReader(new FileReader("value_data"));
				System.out.println(br.readLine());
			
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
        });
        
        eur_button.setOnAction(event -> {
            try {
				FileWriter writer = new FileWriter("currency_data");
				writer.write("eur");
				writer.close();
				ProcessBuilder processBuilder = new ProcessBuilder("python3", "get_values.py");
				Process process = processBuilder.start();
				process.waitFor();
				
				BufferedReader br = new BufferedReader(new FileReader("value_data"));
				System.out.println(br.readLine());
			
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
        });
        
        gbp_button.setOnAction(event -> {
            try {
				FileWriter writer = new FileWriter("currency_data");
				writer.write("gbp");
				writer.close();
				ProcessBuilder processBuilder = new ProcessBuilder("python3", "get_values.py");
				Process process = processBuilder.start();
				process.waitFor();

				BufferedReader br = new BufferedReader(new FileReader("value_data"));
				System.out.println(br.readLine());
				
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
        });
        
        jpy_button.setOnAction(event -> {
            try {
				FileWriter writer = new FileWriter("currency_data");
				writer.write("jpy");
				writer.close();
				ProcessBuilder processBuilder = new ProcessBuilder("python3", "get_values.py");
				Process process = processBuilder.start();
				process.waitFor();

				BufferedReader br = new BufferedReader(new FileReader("value_data"));
				System.out.println(br.readLine());
				
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
        });
        
        
		
		/* currencies box */
        HBox currencies_box = new HBox(30);
        currencies_box.getChildren().addAll(usd_box, eur_box, gbp_box, jpy_box);
        currencies_box.setAlignment(javafx.geometry.Pos.CENTER);
        
        // ------------------------------------------------------------
        
        // mainbox
        VBox mainbox = new VBox(50);
        mainbox.getChildren().addAll(info_box, image_view, tl_label_box, currencies_box);
        mainbox.setAlignment(javafx.geometry.Pos.CENTER);
        
        // root Properties
        root.getChildren().addAll(mainbox);
        root.setStyle("-fx-background-color: white;");
        
        Scene scene = new Scene(root,400, 600);
        primaryStage.setTitle("Turkish Lira Converter");
        primaryStage.getIcons().add(new Image("src/lira.png"));
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}





