import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Aufgabe2 extends Application{
	
	public void start(Stage primStage){
		Rectangle rt = new Rectangle(50, 40);
		Circle circle = new Circle(50);
		Ellipse el = new Ellipse(50, 25);
		
		rt.setFill(Color.RED);
		circle.setFill(Color.BLUE);
		el.setFill(Color.BLACK);
		
		Color[] paintList = new Color[5];
		paintList[0] = Color.AZURE;
		paintList[1] = Color.BLUEVIOLET;
		paintList[2] = Color.DEEPPINK;
		paintList[3] = Color.LIGHTSEAGREEN;
		paintList[4] = Color.BROWN;
		
		HBox pane = new HBox();
		Scene scene = new Scene(pane, 500, 400);
		
		scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event){
				if (event.isMiddleButtonDown()){
				}
			}
		});
		
		primStage.setScene(scene);
		primStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
