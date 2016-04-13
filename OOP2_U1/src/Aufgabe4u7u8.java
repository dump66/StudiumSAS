import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Aufgabe4u7u8 extends Application {
	private FileChooser fc;
	private File f;

	@Override
	public void start(final Stage primaryStage) throws IOException {
		fc = new FileChooser();
		fc.setTitle("Suche die gespeicherte Datei");
		f = fc.showOpenDialog(primaryStage);
		DataInputStream dis = new DataInputStream(new FileInputStream(f));
		int c;
		String s = "";
		while ((c = dis.read()) != -1) {
			s = s + (char) c;
		}
		dis.close();
		String[] values = s.split("\\r\\n");

		final TextField fName = new TextField("Vorname");
		fName.setPromptText("Vornamen eingeben");
		final TextField sName = new TextField();
		sName.setPromptText("Nachnamen eingeben");
		final TextField age = new TextField();
		age.setPromptText("Alter eingeben");
		final TextField gender = new TextField();
		gender.setPromptText("Geschlecht eingeben");
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
		double d = 3.64328;
		d *= 100;
		d = Math.round(d);
		d /= 100;
		System.out.println(d);

		for (int i = 0; i < values.length; i++) {
			switch (i) {
			case 0:
				fName.setText(values[0]);
				break;
			case 1:
				sName.setText(values[1]);
				break;
			case 2:
				age.setText(values[2]);
				break;
			case 3:
				gender.setText(values[3]);
				break;
			case 4:
				street.setText(values[4]);
				break;
			case 5:
				city.setText(values[5]);
				break;
			case 6:
				zip.setText(values[6]);
				break;
			default:
				break;

			}
		}

		btnOK.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				writeData();

			}

			private void writeData() {
				fc.setTitle("Speichere in eine Datei");
				f = fc.showSaveDialog(primaryStage);
				if (f != null) {
					// try {
					// FileWriter fw = new FileWriter(f);
					// fw.write(fName.getText()+System.lineSeparator());
					// fw.write(sName.getText()+System.lineSeparator());
					// fw.write(age.getText()+System.lineSeparator());
					// fw.write(gender.getText()+System.lineSeparator());
					// fw.write(street.getText()+System.lineSeparator());
					// fw.write(city.getText()+System.lineSeparator());
					// fw.write(zip.getText()+System.lineSeparator());
					// fw.flush();
					// fw.close();
					// } catch (IOException e) {
					// e.printStackTrace();
					// }
					try {
						DataOutputStream dos = new DataOutputStream(new FileOutputStream(f));
						dos.writeBytes(fName.getText() + System.lineSeparator());
						dos.writeBytes(sName.getText() + System.lineSeparator());
						dos.writeBytes(age.getText() + System.lineSeparator());
						dos.writeBytes(gender.getText() + System.lineSeparator());
						dos.writeBytes(street.getText() + System.lineSeparator());
						dos.writeBytes(city.getText() + System.lineSeparator());
						dos.writeBytes(zip.getText() + System.lineSeparator());
						dos.flush();
						dos.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					// System.out.println("Vorname: " + fName.getText());
					// System.out.println("Nachname: " + sName.getText());
					// System.out.println("Alter: " + age.getText());
					// System.out.println("Geschlecht: " + gender.getText());
					// System.out.println("Straße: " + street.getText());
					// System.out.println("Ort: " + city.getText());
					// System.out.println("PLZ: " + zip.getText());
				} else {
					System.out.println("Vorgang abgebrochen!");
				}
			}
		});

		btnCancel.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				fName.setText(null);
				sName.setText(null);
				age.setText(null);
				gender.setText(null);
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
		root.add(close, 2, 0);

		Scene scene = new Scene(root);
		// primaryStage.sizeToScene();
		primaryStage.setTitle("Aufgabe 8");
		primaryStage.setScene(scene);
		primaryStage.show();
		// fName.setFocusTraversable(false);
		// sName.setFocusTraversable(false);
		// age.setFocusTraversable(false);
		// gender.setFocusTraversable(false);
		// street.setFocusTraversable(false);
		// city.setFocusTraversable(false);
		// zip.setFocusTraversable(false);
		// btnOK.setFocusTraversable(false);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
