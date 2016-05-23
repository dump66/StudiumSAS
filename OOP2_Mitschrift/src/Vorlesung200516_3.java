

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

// Vielen Dank an Simon K. für den Code
// Canvas
public class Vorlesung200516_3 extends Application {
	GraphicsContext gc;
	
	@Override
	public void start(Stage primaryStage) {
		Canvas canvas = new Canvas(300,250);
		gc = canvas.getGraphicsContext2D();
		
		
		StackPane root = new StackPane(canvas);
		final Scene scene = new Scene(root,300,250);

		EventHandler<MouseEvent> dragHandler = new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
			
				if(event.getEventType() == MouseEvent.MOUSE_PRESSED)
				{
					gc.beginPath();
					gc.moveTo(event.getX(), event.getY());
				}
				else if(event.getEventType() == MouseEvent.MOUSE_DRAGGED)
				{
					gc.lineTo(event.getX(),event.getY());
					gc.stroke();
				}
				else if(event.getEventType() == MouseEvent.MOUSE_RELEASED)
				{
					gc.closePath();
					
				}
				else if(event.getEventType() == MouseEvent.MOUSE_CLICKED)
				{
					gc.fillOval(event.getX(), event.getY(), 2, 2);
				}
			}
		};
		
		
		scene.addEventHandler(MouseEvent.ANY, dragHandler);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

//Canvas = Zeichenfläche
//new Canvas(..); immer Größen angeben, da Objekt sonst unsichtbar 
//GraphicsContext = Zeichenobjekt
//gc.fill<Primitiv>() 
//	Primitive:  Rectangle
//				Polygon
//				Oval
//gc.stroke<Primitive>(); // zeichnet nur umrandet
//Typische Einstellungen:
//	Stiftfarbe
//	Stiftbreite
//	Füllfarbe
//Zeichnen von Pfaden:
//	begin Path
//	movtTo,lineTO,arcTo,....closePath
//	Stroke();


