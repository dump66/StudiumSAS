
import java.util.ArrayList;
import java.util.HashMap;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Aufgabe4 extends Application {
	HBox root;
	Scene scene;
	ArrayList<Key> keyboard;

	@Override
	public void start(Stage prim) throws Exception {

		root = new HBox(10);
		scene = new Scene(root);

		keyboard = new ArrayList<>();
		keyboard.add(new Key(KeyCode.A));
		keyboard.add(new Key(KeyCode.S));
		keyboard.add(new Key(KeyCode.D));
		keyboard.add(new Key(KeyCode.F));
		HashMap<KeyCode, Key> map = new HashMap<>();
		map.put(KeyCode.A, keyboard.get(0));
		map.put(KeyCode.S, keyboard.get(1));
		map.put(KeyCode.D, keyboard.get(2));
		map.put(KeyCode.F, keyboard.get(3));
		keyboard.get(0).requestFocus();
		
		EventHandler<KeyEvent> keyHandler = new EventHandler<KeyEvent>() {
			Background background;
			public void handle(KeyEvent event) {
				if (map.containsKey(event.getCode())){
					Key k = map.get(event.getCode());
					if (event.getEventType() == KeyEvent.KEY_PRESSED){
						background = k.getBackground();
						k.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), null)));
					} else if (event.getEventType() == KeyEvent.KEY_RELEASED){
						k.setBackground(background);
					}
				} else if (event.getCode() == KeyCode.ENTER){
					for (Key key : keyboard) {
						if (key.isFocused()){
							if (event.getEventType() == KeyEvent.KEY_PRESSED){
								background = key.getBackground();
								key.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), null)));
							} else if (event.getEventType() == KeyEvent.KEY_RELEASED){
								key.setBackground(background);
							}
						}
					}
				}
			}
		};
		// TODO: Ein ActiveProperty<Boolean> erstellen, das auf mein Return hört, ob gedrückt oder nicht. ActiveP und focusedP binden an neues BooleanBinding
		// TODO: Einen Listener an neuen BooleanBinding und abprüfen, welchen Wert es hat. Je nachdem Farbe ändern.
		for (Key k : keyboard) {
			k.setFocusTraversable(true);
			k.focusedProperty().addListener(new ChangeListener<Boolean>() {
				
				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					if (newValue) {
						k.setBackground(new Background(new BackgroundFill(Color.GREY, new CornerRadii(5), null)));
					} else {
						k.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(5), null)));
					}
				}
			});
		}

		root.getChildren().addAll(keyboard);
		scene.addEventFilter(KeyEvent.ANY, keyHandler);

		prim.setScene(scene);
		prim.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
