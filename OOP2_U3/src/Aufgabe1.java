
import javafx.application.Application;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Aufgabe1 extends Application {

	Scene scene;

	Rectangle rt;
	Circle circle;
	Ellipse el;

	@Override
	public void start(Stage prim) throws Exception {
		rt = new Rectangle(0, 0, 50, 40);
		circle = new Circle(100, 100, 50);
		el = new Ellipse(200, 200, 50, 25);

		rt.setFill(Color.RED);
		circle.setFill(Color.BLUE);
		el.setFill(Color.GREEN);

		DropShadow ds = new DropShadow(20, Color.BLACK);
		ds.setOffsetX(5);
		ds.setOffsetY(5);

		Pane pane = new Pane();
		pane.getChildren().addAll(rt, circle, el);
		scene = new Scene(pane, 500, 400);
		

//		EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {
//			public void handle(MouseEvent event) {
//				if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
//					if (event.getTarget() instanceof Shape) {
//						((Shape) event.getTarget()).setEffect(ds);
//					}
//				} else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
//					if (event.getTarget() instanceof Shape) {
//						((Shape) event.getTarget()).setEffect(null);
//					}
//				}
//			}
//		};

		
		
		for (Node shape : pane.getChildren()) {
			if (shape instanceof Shape) {
				// shape.addEventHandler(MouseEvent.ANY, mouseHandler);
				ReadOnlyBooleanProperty hover = shape.hoverProperty();
				hover.addListener(new ChangeListener<Boolean>() {

					Shape s1 = (Shape) shape;
					@Override
					public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
						if (newValue){
							s1.setEffect(ds);
						} else {
							s1.setEffect(null);
						}
					}
				});
			}

		}

		prim.setScene(scene);
		prim.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
