import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Aufgabe1 extends Application {

	public void start(Stage primStage) {
		final Pane root = new Pane();
		Scene scene = new Scene(root);
		scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				makeDot(root, event);
			}


		});

		primStage.setScene(scene);
		primStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	private void makeDot(final Pane root, MouseEvent event) {
		Circle circle = new Circle(5);
		circle.setFill(Color.RED);
		root.getChildren().add(circle);
		circle.setCenterX(event.getSceneX());
		circle.setCenterY(event.getSceneY());
	}

}
