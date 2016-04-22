
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Vorlesung080416_3 extends Application {

	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Button open = new Button("open");
			
			root.setTop(open);
			Scene scene = new Scene(root, 400, 400);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			Rectangle rect = new Rectangle(200, 100, Color.BLUEVIOLET);
			root.setCenter(rect);
			EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {
				public void handle(MouseEvent event){
					System.out.println(event);
				}
			};
			open.addEventFilter(MouseEvent.MOUSE_ENTERED, handler);
			open.addEventFilter(MouseEvent.MOUSE_EXITED, handler);
			root.addEventFilter(MouseEvent.MOUSE_ENTERED, handler);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Vorlesung010416_1.launch(args);
	}
}
