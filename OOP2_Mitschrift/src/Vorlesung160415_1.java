import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Vorlesung160415_1 extends Application{
	
	public void start(Stage primStage){
		BorderPane root = new BorderPane();
		Group group;
		
		Rectangle rect = new Rectangle(200, 100, Color.BLUEVIOLET);
		
		root.setCenter(group = new Group(rect));
		
		EventHandler<MouseEvent> filter = new EventHandler<MouseEvent>() {
			
			public void handle(MouseEvent event){
				System.out.println("Filter: Quelle:" + event.getSource().getClass().getSimpleName()
						+ " Ziel: " + event.getTarget().getClass().getSimpleName());
			}
		};
		
		EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {
			
			public void handle(MouseEvent event){
				System.out.println("Handler: Quelle:" + event.getSource().getClass().getSimpleName()
						+ " Ziel: " + event.getTarget().getClass().getSimpleName());
			}
		};
		
		EventHandler<MouseEvent> consumer = new EventHandler<MouseEvent>() {
			
			public void handle(MouseEvent event){
				System.out.println("Handler: Quelle:" + event.getSource().getClass().getSimpleName()
						+ " Ziel: " + event.getTarget().getClass().getSimpleName());
				event.consume();
			}
		};
		
		rect.addEventFilter(MouseEvent.MOUSE_PRESSED, filter);
		group.addEventFilter(MouseEvent.MOUSE_PRESSED, filter);
		root.addEventFilter(MouseEvent.MOUSE_PRESSED, filter);
		
		rect.addEventHandler(MouseEvent.MOUSE_PRESSED, handler);
		group.addEventHandler(MouseEvent.MOUSE_PRESSED, consumer);
		root.addEventHandler(MouseEvent.MOUSE_PRESSED, handler);
		
		Scene scene = new Scene(root, 400, 400);
		primStage.setScene(scene);
		primStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
