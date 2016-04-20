import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
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

		EventHandler<MouseEvent> myDragHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				if (event.getButton() == MouseButton.PRIMARY) {
					Node tgt = (Node) event.getTarget();
					if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
						objX = tgt.getTranslateX();
						objY = tgt.getTranslateY();
						mouseX = event.getSceneX();
						mouseY = event.getSceneY();
					} else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED){
						double x = event.getSceneX()-(mouseX-objX);
						double y = event.getSceneY()-(mouseY-objY);
						x = x>scene.getWidth()?scene.getWidth():x;
						x = x<0?0:x;
						y = y>scene.getHeight()?scene.getHeight():y;
						y = y<0?0:y;
						tgt.setTranslateX(x);
						tgt.setTranslateY(y);
					}
				}
			}
		};

		rt.setOnMouseClicked(onClickHandler);
		circle.setOnMouseClicked(onClickHandler);
		el.setOnMouseClicked(onClickHandler);
		rt.setOnMousePressed(myDragHandler);
		circle.setOnMousePressed(myDragHandler);
		el.setOnMousePressed(myDragHandler);
		rt.setOnMouseDragged(myDragHandler);
		circle.setOnMouseDragged(myDragHandler);
		el.setOnMouseDragged(myDragHandler);

		Pane pane = new Pane();
		pane.getChildren().addAll(rt, circle, el);
		scene = new Scene(pane, 500, 400);

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
