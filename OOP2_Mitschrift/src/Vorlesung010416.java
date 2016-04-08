import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

// Vom 01.04.16
public class Vorlesung010416 extends Application{
	
	Button button, button2;
	Stage stage;
	
	
	public Vorlesung010416(){
		System.out.println("1. Code der beim Erstellen des Objekts ausgeführt wird");
	}
	
	public void init(){
		
		
		Platform.setImplicitExit(false);
		
		System.out.println("2. Do initialisation here.");
		button = new Button("open");
		button.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				stage.show();
			}
		});
		button2 = new Button("Schliessen");
		button2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.close();
			}
		});
	}
	
	public void start(Stage primaryStage){
		try{
			stage = new Stage(StageStyle.UNDECORATED);
			StackPane stackPane = new StackPane();
			Text text = new Text("Kindfenster");
			stackPane.getChildren().add(text);
			Scene scene2 = new Scene(stackPane);
			stage.setScene(scene2);
			
			BorderPane root = new BorderPane();
			root.setCenter(button);
			root.setRight(button2);
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
		Vorlesung010416.launch(args);
	}
}
