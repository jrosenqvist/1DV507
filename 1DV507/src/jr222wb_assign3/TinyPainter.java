package jr222wb_assign3;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TinyPainter extends Application {

	
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Tiny Painter");
		
		Group root = new Group();
		
		ComboBox<String> shape = new ComboBox<String>();
		shape.getItems().addAll("Line", "Dot", "Rectangle", "Circle");
		shape.getSelectionModel().select(0);
		
		ComboBox<String> size = new ComboBox<String>();
		size.getItems().addAll("1", "2", "3", "4", "5", "10", "15", "20", "30", "40");
		size.getSelectionModel().select(0);
		
		ColorPicker colour = new ColorPicker();
		
		HBox options = new HBox();
		options.getChildren().addAll(shape, size, colour);
		
		root.getChildren().add(options);
		
		Scene scene = new Scene(root, 1024, 768, Color.WHITE);
		
		primaryStage.setScene(scene);
		primaryStage.show();		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
