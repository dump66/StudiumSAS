package Textspiel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SpielStart extends Application {

	TextArea inhaltZentrum = new TextArea();

	@Override
	public void start(Stage primaryStage) throws Exception {
		inhaltZentrum.setEditable(false);
		inhaltZentrum.setPrefSize(500, 500);
		inhaltZentrum.setTranslateX(100);
		inhaltZentrum.setTranslateY(100);
		inhaltZentrum.setWrapText(true);
		Pane root = new Pane();

		root.getChildren().add(inhaltZentrum);

		Scene scene = new Scene(root, 700, 700);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
