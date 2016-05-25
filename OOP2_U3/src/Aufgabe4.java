
import java.util.ArrayList;
import java.util.HashMap;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
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

	SimpleBooleanProperty returnProperty;

	@Override
	public void start(Stage prim) throws Exception {

		root = new HBox(10);
		scene = new Scene(root);
		returnProperty = new SimpleBooleanProperty(false);

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

			public void handle(KeyEvent event) {
				Key k = map.get(event.getCode());
				if (event.getEventType() == KeyEvent.KEY_PRESSED) {
					if (event.getCode() == KeyCode.ENTER) {
						returnProperty.set(true);
					}
					if (k != null) {
						k.getKeyProperty().set(true);
					}
				} else if (event.getEventType() == KeyEvent.KEY_RELEASED) {
					if (event.getCode() == KeyCode.ENTER) {
						returnProperty.set(false);
					}
					if (k != null) {
						k.getKeyProperty().set(false);
					}
				}
			}
		};

		for (Key k : keyboard) {
			k.setFocusTraversable(true);
			// Hat den Fokus und wird grau
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
			// Taste wird gedrückt
			k.getKeyProperty().addListener(new ChangeListener<Boolean>() {

				Background background;

				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					if (newValue) {
						background = k.getBackground();
						k.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), null)));
					} else {
						k.setBackground(background);
					}
				}
			});

			// Fokus und Enter
			Bindings.and(returnProperty, k.focusedProperty()).addListener(new ChangeListener<Boolean>() {

				Background background;

				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					if (newValue) {
						background = k.getBackground();
						k.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), null)));
					} else {
						k.setBackground(background);
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
