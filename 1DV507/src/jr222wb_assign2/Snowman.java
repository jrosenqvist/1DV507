package jr222wb_assign2;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Snowman extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();

		Circle head = new Circle(250,150,30); //Create head
		head.setFill(Color.WHITE); 		

		Circle leftEye = new Circle(240, 145, 3); //Create left eye
		leftEye.setFill(Color.BLACK);

		Circle rightEye = new Circle(260, 145, 3); //Create right eye
		rightEye.setFill(Color.BLACK);

		CubicCurve mouth = new CubicCurve(240,160,245,165,255,165,260,160); //Create mouth
		mouth.setStroke(Color.BLACK);
		mouth.setStrokeWidth(4);

		Circle torso = new Circle(250,210,40); //Create 'torso'
		torso.setFill(Color.WHITE);

		Circle legs = new Circle(250,290,60); //Create legs
		legs.setFill(Color.WHITE);
		
		//Create buttons
		Circle topButton = new Circle(250,190,5);
		topButton.setFill(Color.BLACK);
		Circle midButton = new Circle(250,210,5);
		midButton.setFill(Color.BLACK);
		Circle botButton = new Circle(250,230,5);
		botButton.setFill(Color.BLACK);		

		Rectangle ground = new Rectangle(0,335,640,200); //Snow on ground
		ground.setFill(Color.WHITE);

		Circle sun = new Circle(560,75,50); //Sun
		sun.setFill(Color.YELLOW);		

		root.getChildren().addAll(head, torso, legs, leftEye, rightEye, mouth, topButton, midButton, botButton, ground, sun);

		Scene scene = new Scene(root,640,480,Color.LIGHTSKYBLUE);

		primaryStage.setTitle("Snowman");
		primaryStage.setScene(scene);
		primaryStage.show();		
	}	
	
	public static void main(String[] args) {
		launch(args);
	}
}
