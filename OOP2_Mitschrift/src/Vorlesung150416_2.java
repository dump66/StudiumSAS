import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Vorlesung150416_2 extends Application{
	
	public void start(Stage primStage){
		Pane root = new Pane();
		
		Circle circ = new Circle(30, 45, 10);
		
		circ.setOnMouseEntered(new MyEventHandler150416("MouseEntered"));
		
		root.getChildren().add(circ);
		Scene scene = new Scene(root, 400, 400);
		primStage.setScene(scene);
		primStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
