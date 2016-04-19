import com.sun.javafx.geom.Shape;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Aufgabe2 extends Application {

	public static final Color rtColor = Color.RED;
	public static final Color circColor = Color.BLUE;
	public static final Color elColor = Color.BLACK;
	Rectangle rt;
	Circle circle;
	Ellipse el;

	public void start(Stage primStage) {
		rt = new Rectangle(50, 40);
		circle = new Circle(50);
		el = new Ellipse(50, 25);

		rt.setFill(Color.RED);
		circle.setFill(Color.BLUE);
		el.setFill(Color.BLACK);

		EventHandler<MouseEvent> eh = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				if (event.getButton() == MouseButton.SECONDARY) {
					if (event.getSource() instanceof Rectangle) {
						rt.setFill(getRandomColor());
					} else if (event.getSource() instanceof Circle) {
						circle.setFill(getRandomColor());
					} else if (event.getSource() instanceof Ellipse) {
						el.setFill(getRandomColor());
					}
				} else if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
					if (event.getSource() instanceof Rectangle) {
						rt.setFill(Color.RED);
					} else if (event.getSource() instanceof Circle) {
						circle.setFill(Color.BLUE);
					} else if (event.getSource() instanceof Ellipse) {
						el.setFill(Color.BLACK);
					}
				}
			}
		};

		rt.setOnMouseClicked(eh);
		circle.setOnMouseClicked(eh);
		el.setOnMouseClicked(eh);

		HBox pane = new HBox();
		pane.getChildren().addAll(rt, circle, el);
		Scene scene = new Scene(pane, 500, 400);

		scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				if (event.isMiddleButtonDown()) {
				}
			}
		});

		primStage.setScene(scene);
		primStage.show();
	}

	private Color getRandomColor() {
		Color[] paintList = new Color[5];
		paintList[0] = Color.AZURE;
		paintList[1] = Color.BLUEVIOLET;
		paintList[2] = Color.DEEPPINK;
		paintList[3] = Color.DIMGREY;
		paintList[4] = Color.BROWN;
		int i = (int) Math.floor(Math.random() * 5);
		return paintList[i];
	}

	public static void main(String[] args) {
		launch(args);
	}

}
