
import javafx.application.Application;
import javafx.stage.Stage;

public class Aufgabe1 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Browser b1 = Browser.load(primaryStage);
	}

	public static void main(String[] args) {
		launch(args);
	}

}
