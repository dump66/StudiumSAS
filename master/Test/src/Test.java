import java.util.GregorianCalendar;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Test extends Application{
	public void start(Stage primaryStage){
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root,400,400);
		Button btn = new Button();
		btn.setText("Drück mich");
		root.setCenter(btn);
		TextField tf = new TextField();
		tf.setText("Stephan ist ja komisch");
		root.setCenter(btn);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Stefan ist ein komisch Mensch");
		primaryStage.show();
	}
	
	public static void main(String[] args){
		launch(args);
	}
}
