import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

//Bindings
public class Vorlesung160429_5 extends Application {
	
	SimpleStringProperty text;

	
	public void init(){
		text = new SimpleStringProperty("ButtonText");
	}
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
		
		btn.textProperty().bind(text);
		prim.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent event){
				text.set("Dou you really wanna close?");
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
