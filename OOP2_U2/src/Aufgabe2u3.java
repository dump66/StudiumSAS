import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Aufgabe2u3 extends Application {

	public static final Color rtColor = Color.RED;
	public static final Color circColor = Color.BLUE;
	public static final Color elColor = Color.BLACK;

	Scene scene;

	Rectangle rt;
	Circle circle;
	Ellipse el;

	double objX;
	double objY;
	double mouseX;
	double mouseY;

	public void start(Stage primStage) {
		rt = new Rectangle(0, 0, 50, 40);
		circle = new Circle(100, 100, 50);
		el = new Ellipse(200, 200, 50, 25);

		rt.setFill(Color.RED);
		circle.setFill(Color.BLUE);
		el.setFill(Color.BLACK);

		EventHandler<MouseEvent> onClickHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
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

		EventHandler<ScrollEvent> myScrollHandler = new EventHandler<ScrollEvent>() {
			public void handle(ScrollEvent event) {
				if (event.getTarget() instanceof Rectangle) {
					rt.setFill(getRandomColor());
				} else if (event.getTarget() instanceof Circle) {
					circle.setFill(getRandomColor());
				} else if (event.getTarget() instanceof Ellipse) {
					el.setFill(getRandomColor());
				}
			}
		};

		EventHandler<MouseEvent> myDragHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				if (event.getButton() == MouseButton.PRIMARY) {
					Node tgt = (Node) event.getTarget();
					if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
						objX = tgt.getTranslateX();
						objY = tgt.getTranslateY();
						mouseX = event.getSceneX();
						mouseY = event.getSceneY();
					} else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
						double maxNegX = 0;
						double maxNegY = 0;
						double maxX = 0;
						double maxY = 0;

						if (tgt instanceof Rectangle) {
							Rectangle r = (Rectangle) tgt;
							maxNegX = -r.getX();
							maxNegY = -r.getY();
							maxX = scene.getWidth() - maxNegX - r.getWidth();
							maxY = scene.getHeight() - maxNegY - r.getHeight();
						} else if (tgt instanceof Circle) {
							Circle c = (Circle) tgt;
							maxNegX = -c.getCenterX() + c.getRadius();
							maxNegY = -c.getCenterY() + c.getRadius();
							maxX = scene.getWidth() - c.getCenterX() - c.getRadius();
							maxY = scene.getHeight() - c.getCenterY() - c.getRadius();
						} else if (tgt instanceof Ellipse) {
							Ellipse e = (Ellipse) tgt;
							maxNegX = -e.getCenterX() + e.getRadiusX();
							maxNegY = -e.getCenterY() + e.getRadiusY();
							maxX = scene.getWidth() - e.getCenterX() - e.getRadiusX();
							maxY = scene.getHeight() - e.getCenterY() - e.getRadiusY();
						}

						double mausAbstandX = mouseX - objX;
						double mausAbstandY = mouseY - objY;
						double x = event.getSceneX() - mausAbstandX;
						double y = event.getSceneY() - mausAbstandY;

						x = x < maxNegX ? maxNegX : x;
						y = y < maxNegY ? maxNegY : y;
						x = x > maxX ? maxX : x;
						y = y > maxY ? maxY : y;

						tgt.setTranslateX(x);
						tgt.setTranslateY(y);
					}
				}
			}
		};

		rt.setOnMouseClicked(onClickHandler);
		circle.setOnMouseClicked(onClickHandler);
		el.setOnMouseClicked(onClickHandler);
		rt.setOnScroll(myScrollHandler);
		circle.setOnScroll(myScrollHandler);
		el.setOnScroll(myScrollHandler);
		rt.setOnMousePressed(myDragHandler);
		circle.setOnMousePressed(myDragHandler);
		el.setOnMousePressed(myDragHandler);
		rt.setOnMouseDragged(myDragHandler);
		circle.setOnMouseDragged(myDragHandler);
		el.setOnMouseDragged(myDragHandler);

		Pane pane = new Pane();
		pane.getChildren().addAll(rt, circle, el);
		scene = new Scene(pane, 500, 400);

		primStage.setScene(scene);
		primStage.show();
	}

	private Color getRandomColor() {
		Color[] paintList = new Color[5];
		paintList[0] = Color.AQUA;
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
