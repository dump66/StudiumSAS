import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

//Window Property
public class Vorlesung160429_3 extends Application {

	@Override
	public void start(Stage prim) throws Exception {
//		prim.xProperty().addListener(new ChangeListener() {
//
//			@Override
//			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
//				System.out.println("changed from " + oldValue + " to " + newValue);
//			}
//		});
		
		prim.xProperty().addListener(new InvalidationListener() {
			
			@Override
			public void invalidated(Observable observable) {
				System.out.println(observable);
			}
		});

		
		
		
		
		
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
				Platform.exit();
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
