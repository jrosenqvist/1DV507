package jr222wb_assign3;

import java.io.FileInputStream;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RunningSanta extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();

		//Load all images
		ImageView background = new ImageView(new Image(new FileInputStream("src/jr222wb_assign3/images/bg.png")));		
		Image run1 = new Image(new FileInputStream("src/jr222wb_assign3/images/run1.png"));
		Image run2 = new Image(new FileInputStream("src/jr222wb_assign3/images/run2.png"));
		Image run3 = new Image(new FileInputStream("src/jr222wb_assign3/images/run3.png"));
		Image run4 = new Image(new FileInputStream("src/jr222wb_assign3/images/run4.png"));
		Image run5 = new Image(new FileInputStream("src/jr222wb_assign3/images/run5.png"));
		Image run6 = new Image(new FileInputStream("src/jr222wb_assign3/images/run6.png"));
		Image run7 = new Image(new FileInputStream("src/jr222wb_assign3/images/run7.png"));
		Image run8 = new Image(new FileInputStream("src/jr222wb_assign3/images/run8.png"));
		Image run9 = new Image(new FileInputStream("src/jr222wb_assign3/images/run9.png"));
		Image run10 = new Image(new FileInputStream("src/jr222wb_assign3/images/run10.png"));
		Image run11 = new Image(new FileInputStream("src/jr222wb_assign3/images/run11.png"));

		//Set properties for displaying Santa
		ImageView santa = new ImageView(run1); 

		santa.setSmooth(true);
		santa.setFitHeight(150);
		santa.setPreserveRatio(true);
		santa.setY(300);
		santa.setX(20);
		santa.setRotationAxis(Rotate.Y_AXIS);

		//Add everything to scene and stage
		root.getChildren().addAll(background, santa);
		Scene scene = new Scene(root, 1024, 537);
		primaryStage.setTitle("Deserted Santa!");
		primaryStage.setScene(scene);
		primaryStage.show();		

		//Array for keeping track of images
		Image[] frames = {run1, run2, run3, run4, run5, run6, run7, run8, run9, run10, run11};
		
		Count count = new Count();
		Speed speed = new Speed();
		KeyFrame k = new KeyFrame(Duration.millis(100), e -> {			
			santa.setImage(frames[count.get()]); //Set new frame based on count value
			if (count.get() < frames.length - 1) //Each time run, increment count if last value of array is not reached				
				count.inc();			
			else 
				count.set(0); //Else start over

			santa.setX(santa.getX() + speed.get()); //Move santa 20 or -20 based on speed setting

			if (santa.getX() > 800) {
				santa.setRotate(180); //Rotate when reaching end
				speed.set(-speed.get()); //Change move direction
			}

			else if (santa.getX() < 20) {
				santa.setRotate(0); //Rotate back when reaching beginning
				speed.set(-speed.get()); //Restore move direction
			}
		});		

		//Create timeline and set number of cycles
		Timeline t = new Timeline(k);
		t.setCycleCount(Timeline.INDEFINITE);
		t.play();

	}
	//Container classes to set data from anonymous method
	private static class Count {
		private int count = 0;			
		public void set(int n) { count = n; }
		public void inc() { count++; }
		public int get() { return count; }
	}

	private static class Speed {
		private int speed = 20;
		public int get() { return speed; }
		public void set(int n) { speed = n; } 
	}

	public static void main(String[] args) {
		launch(args);
	}



}
