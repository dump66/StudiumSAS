import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

public class MyEventHandler150416 implements EventHandler<MouseEvent> {

	String info;
	double mouseX, mouseY; // Ausgangsposition Mouse
	double objectX, objectY; // Ausgangsposition Objekt

	public MyEventHandler150416(String info) {
		this.info = info;
	}

	public void handle(MouseEvent event) {
		Node target = (Node) event.getTarget();
		if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
			objectX = target.getTranslateX();
			objectY = target.getTranslateY();
			mouseX = event.getSceneX();
			mouseY = event.getSceneY();
		} else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
			target.setTranslateX(event.getSceneX() - mouseX + objectX);
			target.setTranslateY(event.getSceneY() - mouseY + objectY);
		}
	}
}
