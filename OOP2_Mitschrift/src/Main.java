import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// Vom 01.04.16
public class Main extends Application{
	
	Button button;
	
	public Main(){
		System.out.println("1. Code der beim Erstellen des Objekts ausgeführt wird");
	}
	
	public void init(){
		Platform.setImplicitExit(false);
		System.out.println("2. Do initialisation here.");
		button = new Button("Close");
		button.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});
	}
	
	public void start(Stage primaryStage){
		try{
			BorderPane root = new BorderPane();
			root.setCenter(button);
			Scene scene = new Scene(root, 400,400);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (Exception e){
			e.printStackTrace();
		}
		
		System.out.println("3. Starten der Anwendung und Öffnen des Fenster.");
		System.out.println("4. Schließen der Anwendung durch Fenster " + Platform.isImplicitExit());
	}
	
	public void stop(){
		System.out.println("5. Code der beim Beenden der Anwendung ausgeführt wird.");
	}
	
	public static void main(String[] args){
		Main.launch(args);
	}
}
