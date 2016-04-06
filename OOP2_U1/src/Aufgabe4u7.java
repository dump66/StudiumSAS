import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Aufgabe4u7 extends Application {
	@Override
	public void start(final Stage primaryStage) {
		final TextField fName = new TextField("Vorname");
		fName.setPromptText("Vornamen eingeben");
		final TextField sName = new TextField();
		sName.setPromptText("Nachnamen eingeben");
		final TextField age = new TextField();
		age.setPromptText("Alter eingeben");
		final TextField gender = new TextField();
		gender.setPromptText("Geschlecht eingeben");
		final TextField street = new TextField();
		street.setPromptText("Straﬂe eingeben");
		final TextField city = new TextField();
		city.setPromptText("Ort eingeben");
		final TextField zip = new TextField();
		zip.setPromptText("Postleitzahl eingeben");
		Button btnOK = new Button();
		btnOK.setText("OK");
		Button btnCancel = new Button();
		btnCancel.setText("Abbrechen");
		
		btnOK.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Vorname: " + fName.getText());
				System.out.println("Nachname: " + sName.getText());
				System.out.println("Alter: " + age.getText());
				System.out.println("Geschlecht: " + gender.getText());
				System.out.println("Straﬂe: " + street.getText());
				System.out.println("Ort: " + city.getText());
				System.out.println("PLZ: " + zip.getText());
			}
		});
		
		btnCancel.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event){
				fName.setText(null);
				sName.setText(null);
				age.setText(null);
				gender.setText(null);
				street.setText(null);
				city.setText(null);
				zip.setText(null);
			}
		});

		GridPane root = new GridPane();

		root.add(fName, 0, 0);
		root.add(sName, 0, 1);
		root.add(age, 0, 2);
		root.add(gender, 0, 3);
		root.add(street, 0, 4);
		root.add(city, 0, 5);
		root.add(zip, 0, 6);
		root.add(btnOK, 0, 7);
		root.add(btnCancel, 1, 7);

		Scene scene = new Scene(root, 300, 250);
		primaryStage.setTitle("Aufgabe 4");
		primaryStage.setScene(scene);
		primaryStage.show();
//		fName.setFocusTraversable(false);
//		sName.setFocusTraversable(false);
//		age.setFocusTraversable(false);
//		gender.setFocusTraversable(false);
//		street.setFocusTraversable(false);
//		city.setFocusTraversable(false);
//		zip.setFocusTraversable(false);
//		btnOK.setFocusTraversable(false);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
