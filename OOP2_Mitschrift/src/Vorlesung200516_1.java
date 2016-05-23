

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

// Vielen Dank an Simon K. für den Code
// NodeID
public class Vorlesung200516_1 extends Application {

	@Override
	public void start(Stage primaryStage) {
		Button btn = new Button("Klick mich! :-D");
		btn.setId("MyButtonID");
	
		
		//man braucht natürlich ein feder.png im richtigen Ordner
		btn.setCursor(Cursor.HAND);
		StackPane root = new StackPane(btn);
		final Scene scene = new Scene(root,300,250);
		
		scene.setOnScroll(new EventHandler<ScrollEvent>(){

			@Override
			public void handle(ScrollEvent event) {
				
				Button btn = (Button)scene.lookup("#MyButtonID");
				Color color = Color.rgb((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
				btn.setBackground(new Background(new BackgroundFill(color,new CornerRadii(Math.random()*5), new Insets(5))));
				btn.setTextFill(color.invert());
			}
			
		});
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}


//Node:
//	jeder Node kann eine ID haben (ID: identifyer)
//	Methode:
//		void set Id(String);
//		Node lookup(String);
//		//"#identifyer"
//		

		