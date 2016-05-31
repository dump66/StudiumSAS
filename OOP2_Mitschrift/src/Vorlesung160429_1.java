import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

//WindowEvents
public class Vorlesung160429_1 extends Application {

	@Override
	public void start(Stage prim) throws Exception {
		StackPane root = new StackPane();
		Button btn = new Button("Close");
		root.getChildren().add(btn);
		Scene scene = new Scene(root,400,300);
		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				WindowEvent windowEvent = new WindowEvent(prim, WindowEvent.WINDOW_CLOSE_REQUEST);
				windowEvent.fireEvent(prim, windowEvent);
			}
		});
		
		prim.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent event){
				System.out.println("Do you really want to close?");
				event.consume();
			}
		});
		
		prim.setScene(scene);
		prim.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
