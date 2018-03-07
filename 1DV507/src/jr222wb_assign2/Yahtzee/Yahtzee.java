package jr222wb_assign2.Yahtzee;

import java.io.FileInputStream;
import java.util.Random;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Yahtzee extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox();
		root.setPadding(new Insets(10));
		Label header = new Label("Yahtzee");
		header.setFont(new Font(40));
		root.getChildren().add(header);

		//Load dice images
		Image imgD1 = new Image(new FileInputStream("src/jr222wb_assign2/Yahtzee/dice1.png"),96,96,true,true);
		Image imgD2 = new Image(new FileInputStream("src/jr222wb_assign2/Yahtzee/dice2.png"),96,96,true,true);		
		Image imgD3 = new Image(new FileInputStream("src/jr222wb_assign2/Yahtzee/dice3.png"),96,96,true,true);
		Image imgD4 = new Image(new FileInputStream("src/jr222wb_assign2/Yahtzee/dice4.png"),96,96,true,true);
		Image imgD5 = new Image(new FileInputStream("src/jr222wb_assign2/Yahtzee/dice5.png"),96,96,true,true);
		Image imgD6 = new Image(new FileInputStream("src/jr222wb_assign2/Yahtzee/dice6.png"),96,96,true,true);

		//Present dice and checkboxes
		GridPane pane = new GridPane();
		pane.setPadding(new Insets(10,0,10,0));
		pane.setVgap(5);
		pane.setHgap(10);
		pane.setAlignment(Pos.CENTER);

		//Add dice
		ImageView d1 = new ImageView(imgD1); 
		pane.add(d1, 0, 0);
		ImageView d2 = new ImageView(imgD2); 
		pane.add(d2, 1, 0);
		ImageView d3 = new ImageView(imgD3); 
		pane.add(d3, 2, 0);
		ImageView d4 = new ImageView(imgD4); 
		pane.add(d4, 3, 0);
		ImageView d5 = new ImageView(imgD5); 
		pane.add(d5, 4, 0);

		//Add checkboxes
		CheckBox d1Check = new CheckBox();
		d1Check.setDisable(true);
		GridPane.setConstraints(d1Check, 0, 1, 1, 1, HPos.CENTER, null);
		CheckBox d2Check = new CheckBox();
		d2Check.setDisable(true);
		GridPane.setConstraints(d2Check, 1, 1, 1, 1, HPos.CENTER, null);
		CheckBox d3Check = new CheckBox();
		d3Check.setDisable(true);
		GridPane.setConstraints(d3Check, 2, 1, 1, 1, HPos.CENTER, null);
		CheckBox d4Check = new CheckBox();
		d4Check.setDisable(true);
		GridPane.setConstraints(d4Check, 3, 1, 1, 1, HPos.CENTER, null);
		CheckBox d5Check = new CheckBox();
		d5Check.setDisable(true);
		GridPane.setConstraints(d5Check, 4, 1, 1, 1, HPos.CENTER, null);
		pane.getChildren().addAll(d1Check, d2Check, d3Check, d4Check, d5Check);

		//Add gridpane to VBox
		root.getChildren().add(pane);
		
		//Make a second gridpane for button and result
		GridPane botpane = new GridPane();
		botpane.setHgap(10);
		Button roll = new Button("Roll the dice!");
		botpane.add(roll, 0, 0);
		Label result = new Label("You have 3 rolls left.");
		botpane.add(result, 1, 0);

		root.getChildren().add(botpane);

		//Game logic
		//Keep all relevant information and nodes
		int[] rollResult = new int[6]; //Stores the final dice rolls
		ImageView[] dice = {d1, d2, d3, d4, d5}; //Array for image viewers of dice
		Image[] images = {imgD1, imgD2, imgD3, imgD4, imgD5, imgD6}; //Array for images of dice
		CheckBox[] boxes = {d1Check, d2Check, d3Check, d4Check, d5Check}; //Array for checkboxes

		roll.setOnAction(e -> {
			rollResult[5]++; //Increase roll count			
			for (int i = 0; i < 5; i++) {				
				int rollValue = rollDie();
				if (!boxes[i].isSelected()) { //If corresponding checkbox is not selected					
					dice[i].setImage(images[rollValue]); //Change image to match roll value
					boxes[i].setDisable(false); //Enable checkboxes after first roll
					rollResult[i] = rollValue + 1; //Store in values 1-6 instead of 0-5 for further use
				}				
			}				
			result.setText("You have " + (3 - rollResult[5]) + " roll(s) left.");			
			if (rollResult[5] == 3) {
				roll.setDisable(true); //Disable roll button after 3 rolls
				result.setText(checkEndResult(rollResult));
				// TEST ARRAYS TO CHECK GAME LOGIC
				//int[] mock = {1,1,1,1,1}; //Yahtzee
				//int[] mock = {1,1,1,1,2}; //Four of a kind
				//int[] mock = {1,1,1,2,2}; //Full house
				//int[] mock = {1,1,1,2,3}; //Three of a kind
				//int[] mock = {1,2,3,4,5}; //Large straight
				//int[] mock = {1,1,2,3,4}; //Small straight
				//int[] mock = {1,2,3,1,5}; //Pair
				//result.setText(checkEndResult(mock));
			}
		});

		//Set scene and show stage
		Scene scene = new Scene(root);
		primaryStage.setTitle("Yahtzee");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private static int rollDie() { //Return a random value between 0 - 5
		Random r = new Random(); 
		return r.nextInt(6);
	}
	
	private static String checkEndResult(int[] rolls) {		
		int[] count = countDice(rolls);	//Count number of each dice
		int highest = countLargest(count); //Check largest amount of any die
		
		//Apply checks				
		
		if (highest == 5) //Check for yahtzee
			return "Yahtzee!";		
		if (highest == 4) //Check for four of a kind 
			return "Four of a kind!";

		//Check for full house
		if (checkFullHouse(count)) //I put this before three of a kind since it would never show otherwise
			return "Full house!";

		//Check for three of a kind
		if (highest == 3)
			return "Three of a kind!"; 		

		//Check for large straight
		if (checkLargeStraight(rolls))
			return "Large straight!";

		//Check for small straight
		if (checkSmallStraight(rolls))
			return "Small straight!";

		//Check for pair
		if (highest == 2)
			return "Pair!";
		
		//Nothing valuable found
		return "No luck!";
	}
	
	private static int[] countDice(int[] rolls) {
		int[] count = new int[6];
		for (int i = 0; i < 5; i++) {
			int n = rolls[i];
			count[n - 1]++;			
		}		
		return count;
	}
	
	private static int countLargest(int[] count) {
		int highest = 0;		
		for (int c : count) { //Count maximum of any die
			if (c > highest)
				highest = c;			
		}
		return highest;
	}
	
	private static boolean checkFullHouse(int[] count) {
		for (int c : count) //See if there's 3 of a die, then see if there's 2 of a die
			if (c == 3)				
				for (int c2 : count)
					if (c2 == 2)
						return true;
		return false;
	}
	
	private static boolean checkLargeStraight(int[] rolls) { //Check if first die is 1 or 2, and following dice are previous + 1
		if ((rolls[0] == 1 && rolls[1] == 2 && rolls[2] == 3 && rolls[3] == 4 && rolls[4] == 5) ||
				(rolls[0] == 2 && rolls[1] == 3 && rolls[2] == 4 && rolls[3] == 5 && rolls[4] == 6))
			return true;
		return false;
	}
	
	private static boolean checkSmallStraight(int[] rolls) {
		for (int i = 0; i < 2; i++)
			if (rolls[i] == 1 || rolls[i] == 2 || rolls[i] == 3) //If one of the first two dies are 1, 2 or 3 
				for (int j = i + 1; j < i + 4; j++) { //Check next three dies
					if (rolls[j] != rolls[i] + j - i) //If current die is not +1 of the one before, break						
						break;
					else if (j == i + 3) //If last checked die gets here, it's success
						return true;
				}
		return false;
	}

	public static void main(String[] args) {
		launch(args);
	}
}

