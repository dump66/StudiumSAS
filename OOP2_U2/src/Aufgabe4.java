
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Aufgabe4 extends Application {

	public static final Color rtColor = Color.RED;
	public static final Color circColor = Color.BLUE;
	public static final Color elColor = Color.BLACK;

	Scene scene;

	Group group;
	Rectangle rt;
	Circle circle;
	Ellipse el;
	ToggleButton tb;

	double objX;
	double objY;
	double mouseX;
	double mouseY;

	public void start(Stage primStage) {
		rt = new Rectangle(5, 5, 50, 40);
		circle = new Circle(100, 100, 50);
		el = new Ellipse(200, 200, 50, 25);
		tb = new ToggleButton("Gruppe");
		group = new Group(rt, circle, el);

		tb.setTranslateX(350);
		tb.setTranslateY(0);

		rt.setFill(Color.RED);
		circle.setFill(Color.BLUE);
		el.setFill(Color.BLACK);

		EventHandler<ScrollEvent> myScrollHandler = new EventHandler<ScrollEvent>() {
			public void handle(ScrollEvent event) {
				if (event.getTarget() instanceof Shape) {
					Shape s = (Shape) event.getTarget();
					s.setFill(getRandomColor());
				}
			}
		};

		EventHandler<MouseEvent> myMouseHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				if (event.getButton() == MouseButton.PRIMARY) {
					if (event.getClickCount() == 2) {
						if (event.getSource() instanceof Rectangle) {
							rt.setFill(Color.RED);
						} else if (event.getSource() instanceof Circle) {
							circle.setFill(Color.BLUE);
						} else if (event.getSource() instanceof Ellipse) {
							el.setFill(Color.BLACK);
						}
					}
					Node tgt = (Node) event.getTarget();
					if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
						objX = tgt.getTranslateX();
						objY = tgt.getTranslateY();
						mouseX = event.getSceneX();
						mouseY = event.getSceneY();
					} else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {

						double mausAbstandX = mouseX - objX;
						double mausAbstandY = mouseY - objY;
						double x = event.getSceneX() - mausAbstandX;
						double y = event.getSceneY() - mausAbstandY;

						tgt.setTranslateX(x);
						tgt.setTranslateY(y);
					}
				}
			}
		};

		EventHandler<ScrollEvent> myGroupScrollHandler = new EventHandler<ScrollEvent>() {
			public void handle(ScrollEvent event) {
				for (Node n : group.getChildren()) {
					if (n instanceof Shape) {
						((Shape) n).setFill(getRandomColor());
					}
				}
			}
		};

		EventHandler<MouseEvent> myGroupMouseHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				if (event.getButton() == MouseButton.PRIMARY) {
					if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
						objX = group.getTranslateX();
						objY = group.getTranslateY();
						mouseX = event.getSceneX();
						mouseY = event.getSceneY();
					} else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
						double mausAbstandX = mouseX - objX;
						double mausAbstandY = mouseY - objY;
						double x = event.getSceneX() - mausAbstandX;
						double y = event.getSceneY() - mausAbstandY;

						group.setTranslateX(x);
						group.setTranslateY(y);
					}
				}
			}
		};

		EventHandler<ActionEvent> myButtonHandler = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (event.getTarget() instanceof ToggleButton) {
					ToggleButton button = (ToggleButton) event.getTarget();
					if (button.isSelected()) {
						button.setText("Einzel");
						for(Node n : group.getChildren()){
							if (n instanceof Shape){
								Shape s = (Shape) n;
								s.addEventHandler(MouseEvent.MOUSE_CLICKED, myMouseHandler);
								s.addEventHandler(ScrollEvent.SCROLL, myScrollHandler);
								s.addEventHandler(MouseEvent.MOUSE_PRESSED, myMouseHandler);
								s.addEventHandler(MouseEvent.MOUSE_DRAGGED, myMouseHandler);
							}
						}
						group.removeEventHandler(ScrollEvent.SCROLL, myGroupScrollHandler);
						group.removeEventHandler(MouseEvent.MOUSE_PRESSED, myGroupMouseHandler);
						group.removeEventHandler(MouseEvent.MOUSE_DRAGGED, myGroupMouseHandler);
					} else {
						button.setText("Gruppe");
						for(Node n : group.getChildren()){
							if (n instanceof Shape){
								Shape s = (Shape) n;
								s.removeEventHandler(MouseEvent.MOUSE_CLICKED, myMouseHandler);
								s.removeEventHandler(ScrollEvent.SCROLL, myScrollHandler);
								s.removeEventHandler(MouseEvent.MOUSE_PRESSED, myMouseHandler);
								s.removeEventHandler(MouseEvent.MOUSE_DRAGGED, myMouseHandler);
							}
						}
						group.addEventHandler(ScrollEvent.SCROLL, myGroupScrollHandler);
						group.addEventHandler(MouseEvent.MOUSE_PRESSED, myGroupMouseHandler);
						group.addEventHandler(MouseEvent.MOUSE_DRAGGED, myGroupMouseHandler);
					}
				}
			}
		};

		group.addEventHandler(ScrollEvent.SCROLL, myGroupScrollHandler);
		group.addEventHandler(MouseEvent.MOUSE_PRESSED, myGroupMouseHandler);
		group.addEventHandler(MouseEvent.MOUSE_DRAGGED, myGroupMouseHandler);

		tb.addEventHandler(ActionEvent.ACTION, myButtonHandler);

		Pane pane = new Pane();
		pane.getChildren().addAll(group, tb);
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
