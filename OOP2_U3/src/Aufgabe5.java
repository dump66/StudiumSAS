import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Aufgabe5 extends Application {
	private FileChooser fc;
	private File f;
	private Person p;

	@Override
	public void start(final Stage primaryStage) throws IOException, ClassNotFoundException {
		fc = new FileChooser();
		fc.setTitle("Suche die gespeicherte Datei");
		f = fc.showOpenDialog(primaryStage);

		final TextField fName = new TextField();
		fName.setPromptText("Vornamen eingeben");
		final TextField sName = new TextField();
		sName.setPromptText("Nachnamen eingeben");
		final Slider age = new Slider();
		age.setMax(100);
		age.setMin(0);
		age.setTooltip(new Tooltip("Alter einstellen"));
		final ChoiceBox<String> gender = new ChoiceBox<>(FXCollections.observableArrayList("Männlich", "Weiblich"));
		gender.setTooltip(new Tooltip("Geschlecht auswählen"));
		final TextField street = new TextField();
		street.setPromptText("Straße eingeben");
		final TextField city = new TextField();
		city.setPromptText("Ort eingeben");
		final TextField zip = new TextField();
		zip.setPromptText("Postleitzahl eingeben");
		Button btnOK = new Button();
		btnOK.setText("OK");
		Button btnCancel = new Button();
		btnCancel.setText("Löschen");

		p = Person.loadData(f);
		fName.textProperty().bindBidirectional(p.fName);
		sName.textProperty().bindBidirectional(p.sName);
		age.valueProperty().bindBidirectional(p.age);
		gender.valueProperty().bindBidirectional(p.gender);
		street.textProperty().bindBidirectional(p.street);
		city.textProperty().bindBidirectional(p.city);
		zip.textProperty().bindBidirectional(p.zip);

		Label ageValue = new Label();
		ageValue.textProperty().bind(Bindings.format("%.0f", age.valueProperty()));

		btnOK.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				fc.setTitle("Speichere in eine Datei");
				f = fc.showSaveDialog(primaryStage);
				try {
					p.writeData(f);
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		});

		btnCancel.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				fName.setText(null);
				sName.setText(null);
				age.setValue(0);
				gender.getSelectionModel().select(0);
				street.setText(null);
				city.setText(null);
				zip.setText(null);
			}
		});

		Button close = new Button("X");
		close.setLayoutX(20);
		close.setLayoutY(20);
		close.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});

		zip.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				Tooltip tp = new Tooltip("Eine PLZ hat nur 5 Ziffern!");
				if (newValue.length() > 5) {
					tp.show(primaryStage);
					zip.setText(oldValue);
				}
				try {
					Integer.parseInt(newValue);
				} catch (NumberFormatException nfe) {
					tp.show(primaryStage);
					zip.setText(oldValue);
				}
			}
		});

		GridPane root = new GridPane();

		root.add(fName, 1, 0);
		root.add(sName, 1, 1);
		root.add(new Label("Alter"), 0, 2);
		root.add(age, 1, 2);
		root.add(ageValue, 2, 2);
		root.add(new Label("Geschlecht"), 0, 3);
		root.add(gender, 1, 3);
		root.add(street, 1, 4);
		root.add(city, 1, 5);
		root.add(zip, 1, 6);
		root.add(btnOK, 0, 7);
		root.add(btnCancel, 1, 7);
		root.add(close, 2, 0);

		Scene scene = new Scene(root, 400, 400);
		close.requestFocus();
		primaryStage.sizeToScene();
		primaryStage.setTitle("Aufgabe 5");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
