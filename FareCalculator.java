import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FareCalculator extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		// name label
		Label namaLabel = new Label("Airport Ride Calculator ");

		// hours label
		Label FromLabel = new Label("From: ");

		// Location Textbox
		TextField location = new TextField();

		// Label to show messege
		Label messege = new Label();

		/// checkboxes for showing further options
		CheckBox checkBox1 = new CheckBox("Extra Luggage?");
		CheckBox checkBox2 = new CheckBox("Pets");
		CheckBox checkBox3 = new CheckBox("Use 407 ETR");
		CheckBox checkBox4 = new CheckBox("Add Tip?");
		// Adding Button
		Button goButton = new Button();
		// adding text on button
		goButton.setText("CALCULATE");
		// adding a new label to display result
		Label result = new Label("");

		// making objects of vertical and horizontal box
		VBox root = new VBox();
		HBox root1 = new HBox();

		// setting the space between the elements of form to 10 units
		root.setSpacing(10);

		// adding controls to layout Manager
		root.getChildren().add(namaLabel);
		root1.getChildren().addAll(FromLabel, location);
		root.getChildren().add(root1);
		root.getChildren().add(messege);
		root.getChildren().add(checkBox1);
		root.getChildren().add(checkBox2);
		root.getChildren().add(checkBox3);
		root.getChildren().add(checkBox4);
		root.getChildren().add(goButton);
		root.getChildren().add(result);

		// adding functionality to the button
		goButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// Logic for what should happen when you push button
				String place = location.getText();

				double base_fare = 0.0, final_fare = 0.0;

				// checking the place entered by the user in textbox
				if (place.equalsIgnoreCase("Cestar College")) {
					// adding tax to the base fare
					base_fare = 51.0 + (0.13 * 51.0);
					messege.setText("");
				} else if (place.equalsIgnoreCase("Brampton")) {
					// adding tax to the base fare
					base_fare = 38.0 + (0.13 * 38.0);
					messege.setText("");
				} else
					messege.setText("* Please enter the value of location as Cestar College or Brampton");

				// adding a static distance for highway 407
				double distanceCestar = 25.9, distaceBrampton = 23.4;
				double additional_Charges = 0.0;

				// checking the options selected by the user
				if (checkBox1.isSelected())
					additional_Charges += 10.0;
				if (checkBox2.isSelected())
					additional_Charges += 6.0;
				if (checkBox3.isSelected()) {
					if (place.equalsIgnoreCase("Cestar College"))
						additional_Charges += distanceCestar * 0.25;
					;
					if (place.equalsIgnoreCase("Brampton"))
						additional_Charges += distaceBrampton * 0.25;
				}

				// calculating the final fare from base fare and additional charges
				final_fare = base_fare + additional_Charges;

				// checking if the tip is added by the user or not?
				if (checkBox4.isSelected())
					final_fare += 0.15 * final_fare;

				// setting the text of label as result
				result.setText("The total fare is: $" + final_fare);
			}
		});

		// setting the height and width of the window
		primaryStage.setScene(new Scene(root, 400, 300));

		// setting title
		primaryStage.setTitle("Fare CalCulator");

		// showing application
		primaryStage.show();

	}

}
