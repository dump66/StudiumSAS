import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Aufgabe5 extends Application {

	Pane root;

	public void start(Stage primStage) {
		root = new Pane();
		Scene scene = new Scene(root);
		scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				if (event.getButton() == MouseButton.PRIMARY) {
					makeDot(event);
				} else if (event.getButton() == MouseButton.SECONDARY) {
					removeDot(event);
				}
			}

		});

		primStage.setScene(scene);
		primStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	private void makeDot(MouseEvent event) {
		Circle circle = new Circle(5);
		circle.setFill(Color.RED);
		root.getChildren().add(circle);
		circle.setCenterX(event.getSceneX());
		circle.setCenterY(event.getSceneY());
	}

	private void removeDot(MouseEvent event) {
		if (root.getChildren().contains(event.getTarget())) {
			root.getChildren().remove(event.getTarget());
		}
	}

}
