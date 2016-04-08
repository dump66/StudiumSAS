import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class Vorlesung080416 extends Application {

	public void start(final Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Button open = new Button("open");
			open.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent action) {
					FileChooser chooser = new FileChooser();
					chooser.setTitle("Datei öffnen");
					chooser.setInitialDirectory(new File("C:\\"));
					chooser.getExtensionFilters().addAll(new ExtensionFilter("Text", "*.txt", "*.doc"));
					File datei = chooser.showOpenDialog(null);
					if (datei == null) {
						System.out.println("Keine Datei gewählt");
					} else {

					}
				}
			});
			root.setCenter(open);
			Scene scene = new Scene(root, 400, 400);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Vorlesung010416.launch(args);
	}
}
