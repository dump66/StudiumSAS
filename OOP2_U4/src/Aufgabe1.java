import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Aufgabe1 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		WebView wv = new WebView();
		WebEngine we = wv.getEngine();
		we.load("http://www.google.de");
		Scene scene = new Scene(wv);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
