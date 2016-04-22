import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Vorlesung220416_1 extends Application {

	Rectangle r1, r2;
	Line line;

	public void init() {
		r1 = new Rectangle(10, 20, 50, 50);
		r1.setFill(Color.WHITE);
		r1.setStroke(Color.BLACK);
		r2 = new Rectangle(240, 20, 50, 50);
		r2.setFill(Color.WHITE);
		r2.setStroke(Color.BLACK);
		line = new Line();
	}

	public void start(Stage primStage) {

		r1.setOnDragDetected(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				r1.startFullDrag();
				line.setStartX(event.getSceneX());
				line.setStartY(event.getSceneY());
				line.setEndX(event.getSceneX());
				line.setEndY(event.getSceneY());
			}
		});
		
		r1.setOnMouseDragEntered(new EventHandler<MouseDragEvent>() {

			@Override
			public void handle(MouseDragEvent event) {
				r1.setFill(Color.WHEAT);
			}
		});

		r1.setOnMouseDragExited(new EventHandler<MouseDragEvent>() {

			@Override
			public void handle(MouseDragEvent event) {
				r1.setFill(Color.WHITE);
			}
		});

		r2.setOnMouseDragEntered(new EventHandler<MouseDragEvent>() {

			@Override
			public void handle(MouseDragEvent event) {
				r2.setFill(Color.WHEAT);
			}
		});

		r2.setOnMouseDragExited(new EventHandler<MouseDragEvent>() {

			@Override
			public void handle(MouseDragEvent event) {
				r2.setFill(Color.WHITE);
			}
		});
		r2.setOnMouseDragReleased(new EventHandler<MouseDragEvent>() {

			@Override
			public void handle(MouseDragEvent event) {
				line.setEndX(event.getSceneX());
				line.setEndY(event.getSceneY());
			}
			
		});

		Pane root = new Pane();
		root.getChildren().addAll(r1, r2, line);
		Scene scene = new Scene(root, 300, 250);
		primStage.setScene(scene);
		primStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
