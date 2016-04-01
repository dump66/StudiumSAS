import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Aufgabe2u3 extends Application {

	@Override
	public void start(final Stage primaryStage) {
		final Text tf = new Text();
		final Button btnTop = new Button();
		btnTop.setText("Top");
		btnTop.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				tf.setText(btnTop.getText());
			}
		});
		final Button btnBot = new Button();
		btnBot.setText("Bottom");
		btnBot.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				tf.setText(btnBot.getText());
			}
		});
		final Button btnRight = new Button();
		btnRight.setText("Right");
		btnRight.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				tf.setText(btnRight.getText());
			}
		});
		final Button btnLeft = new Button();
		btnLeft.setText("Left");
		btnLeft.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				tf.setText(btnLeft.getText());
			}
		});

		BorderPane root = new BorderPane();
		root.setTop(btnTop);
		root.setBottom(btnBot);
		root.setRight(btnRight);
		root.setLeft(btnLeft);
		root.setCenter(tf);
		root.setAlignment(root.getTop(), Pos.CENTER);

		Scene scene = new Scene(root, 300, 250);
		primaryStage.setTitle("Aufgabe 3");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
