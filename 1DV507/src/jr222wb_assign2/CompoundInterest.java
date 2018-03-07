package jr222wb_assign2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CompoundInterest extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {		
		VBox root = new VBox();
		root.setPadding(new Insets(10));
				
		GridPane pane = new GridPane();	
		pane.setPadding(new Insets(5, 0, 5, 0));
		pane.setHgap(5);
		pane.setVgap(5);

		pane.add(new Label("Start amount:"), 0, 0);
		final TextField start = new TextField();
		pane.add(start, 1, 0);

		pane.add(new Label("Interest:"), 0, 1);
		final TextField interest = new TextField();
		pane.add(interest, 1, 1);

		pane.add(new Label("Number of years:"), 0, 2);
		final TextField years = new TextField();
		pane.add(years, 1, 2);

		Button btnCalc = new Button("Calculate");
		pane.add(btnCalc, 0, 3);
		
		Label heading = new Label("Compound Interest");
		heading.setFont(new Font(30));
		final Label total = new Label();		
		root.getChildren().addAll(heading, pane, total);

		btnCalc.setOnAction(e -> {
			try {
				int calcStart = Integer.parseInt(start.getText()); //Get start value as integer
				double calcInterest = 1 + Float.parseFloat(interest.getText()) / 100; //Get interest as double and set right format
				int calcYears = Integer.parseInt(years.getText()); //Get years value as integer
				double sum = calcStart * (Math.pow(calcInterest, calcYears)); //Calculate
				total.setText("In total that will be " + Math.round(sum)); //Round result and present
			}
			catch (Exception ex) { total.setText("Make sure to enter valid numbers"); } //Catch exception
		});

		primaryStage.setTitle("Compound Interest");
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
