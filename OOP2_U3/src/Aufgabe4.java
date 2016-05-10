import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Aufgabe4 extends Application {
	HBox root;
	Scene scene;

	@Override
	public void start(Stage prim) throws Exception {
		root = new HBox(10);
		scene = new Scene(root);

		Key a, b;
		a =new Key(KeyCode.A);
		b = new Key(KeyCode.B);
		
		a.focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (newValue){
					a.setBackground(new Background(new BackgroundFill(Color.GREY, new CornerRadii(5), null)));
				} else {
					a.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), null)));
				}
			}
		});
		a.setFocusTraversable(true);
		
		root.getChildren().addAll(a, b);
		
		prim.setScene(scene);
		prim.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
