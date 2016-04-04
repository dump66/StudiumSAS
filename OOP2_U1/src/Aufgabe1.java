import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// Test1
public class Aufgabe1 extends Application {
	private int counter = 0;

	@Override
	public void start(final Stage primaryStage) {
		Button btn = new Button();
		btn.setText("Lösung");
		Label lbl = new Label();
		lbl.setText("Klick #");
		final Text txt = new Text();
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				counter++;
				txt.setText("" + counter);
				primaryStage.sizeToScene();
			}
		});
		HBox root = new HBox();
		root.getChildren().add(btn);
		root.getChildren().add(lbl);
		root.getChildren().add(txt);
		Scene scene = new Scene(root);
		primaryStage.setTitle("Aufgabe 1");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
