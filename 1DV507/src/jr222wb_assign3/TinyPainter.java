package jr222wb_assign3;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TinyPainter extends Application {


	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Tiny Painter");

		Group root = new Group();

		ComboBox<String> shape = new ComboBox<>();
		shape.getItems().addAll("Line", "Dot", "Rectangle", "Circle"); //Add drop down with possible shapes
		shape.getSelectionModel().select(0); //Default to line

		ComboBox<Double> size = new ComboBox<>();
		size.getItems().addAll(1.0, 2.0, 3.0, 4.0, 5.0, 10.0, 15.0, 20.0, 30.0, 40.0); //Add drop down with possible sizes
		size.getSelectionModel().select(4); //Default to 5

		ColorPicker colour = new ColorPicker();
		colour.setValue(Color.BLACK); //Default to black

		HBox options = new HBox();
		options.getChildren().addAll(shape, size, colour); //Line up drop downs in a box

		root.getChildren().add(options); //Add menus to root

		Scene scene = new Scene(root, 1024, 768, Color.WHITE); //Create scene

		primaryStage.setScene(scene);
		primaryStage.show();		
		
		scene.setOnMousePressed(e -> {
			/* On mouse press, choose what to do based on selected shape. If necessary, read size.
			 * Colour value is read when creating shape.
			 */
			
			//Line
			if (shape.getSelectionModel().getSelectedIndex() == 0) {				
				double startX = e.getSceneX();
				double startY = e.getSceneY();
				scene.setOnMouseReleased(r -> {
					double endX = r.getSceneX();
					double endY = r.getSceneY();
					Line l = new Line(startX, startY, endX, endY);
					l.setStrokeWidth(size.getValue());
					l.setStroke(colour.getValue());
					root.getChildren().add(l);
				});
			}

			//Dot
			if (shape.getSelectionModel().getSelectedIndex() == 1) {
				Rectangle s = new Rectangle(e.getSceneX(), e.getSceneY(), size.getValue(), size.getValue());
				s.setFill(colour.getValue());
				root.getChildren().add(s);
				scene.setOnMouseReleased(r -> {}); //Problem with lambda from previous shape interfering without this line
			}

			//Rectangle
			if (shape.getSelectionModel().getSelectedIndex() == 2) {
				double startX = e.getSceneX();
				double startY = e.getSceneY();
				scene.setOnMouseReleased(r -> {
					double width = r.getSceneX() - startX;
					double height = r.getSceneY() - startY;
					Rectangle rect = new Rectangle(startX, startY, width, height);					
					rect.setFill(colour.getValue());
					root.getChildren().add(rect);
				});
			}

			//Circle
			if (shape.getSelectionModel().getSelectedIndex() == 3) {				
				double startX = e.getSceneX();
				double startY = e.getSceneY();
				scene.setOnMouseReleased(r -> {
					double endX = r.getSceneX();
					double endY = r.getSceneY();
					double radius = Math.sqrt(Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2)); //Pythagora's theorem to calculate radius
					Circle c = new Circle(startX, startY, radius, colour.getValue());					
					root.getChildren().add(c);
				});
			}
		});		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
