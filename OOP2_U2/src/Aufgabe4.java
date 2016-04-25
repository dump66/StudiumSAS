
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

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
					try {
						s.setFill(getRandomColor());
					} catch (ClassNotFoundException | IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
						try {
							((Shape) n).setFill(getRandomColor());
						} catch (ClassNotFoundException | IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
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

	private Color getRandomColor() throws ClassNotFoundException, IllegalAccessException {
		List<Color> paintList = allColors();
		int length = paintList.size();
		int i = (int) Math.floor(Math.random() * length);
		return paintList.get(i);
	}
	
	private List<Color> allColors() throws ClassNotFoundException, IllegalAccessException {
	    List<Color> colors = new ArrayList<>();
	    Class clazz = Class.forName("javafx.scene.paint.Color");
	    if (clazz != null) {
	        Field[] field = clazz.getFields();
	        for (int i = 0; i < field.length; i++) {
	            Field f = field[i];                
	            Object obj = f.get(null);
	            if(obj instanceof Color){
	                colors.add((Color) obj);
	            }

	        }
	    }
	    return colors;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
