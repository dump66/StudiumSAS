
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Aufgabe4Neu extends Application {
	HBox root;
	Scene scene;

	SimpleBooleanProperty returnProperty;

	@Override
	public void start(Stage prim) throws Exception {

		root = new HBox(15);
		root.setPadding(new Insets(15));
		scene = new Scene(root, 300, 300);
		returnProperty = new SimpleBooleanProperty(false);

		TreeMap<KeyCode, KeyNeu> map = new TreeMap<>();
		map.put(KeyCode.A, new KeyNeu(KeyCode.A));
		map.put(KeyCode.S, new KeyNeu(KeyCode.S));
		map.put(KeyCode.D, new KeyNeu(KeyCode.D));
		map.put(KeyCode.F, new KeyNeu(KeyCode.F));
		map.firstEntry().getValue().requestFocus();

		EventHandler<KeyEvent> keyHandler = new EventHandler<KeyEvent>() {

			public void handle(KeyEvent event) {
				if (event.getEventType() == KeyEvent.KEY_PRESSED) {
					if (map.containsKey(event.getCode())) {
						map.get(event.getCode()).keyProperty.set(true);
					}
					if (event.getCode() == KeyCode.ENTER) {
						returnProperty.set(true);
					}
				} else if (event.getEventType() == KeyEvent.KEY_RELEASED) {
					if (map.containsKey(event.getCode())) {
						map.get(event.getCode()).keyProperty.set(false);
					}
					if (event.getCode() == KeyCode.ENTER) {
						returnProperty.set(false);
					}
				}
			}
		};

		for (KeyNeu key : map.values()) {
			key.fillProperty().bind(Bindings.when(key.keyProperty).then(Color.RED)
					.otherwise(Bindings.when(key.focusedProperty()).then(Bindings.when(returnProperty).then(Color.RED).otherwise(Color.GRAY)).otherwise(Color.WHITE)));
			root.getChildren().add(new StackPane(key, key.getLetter()));
		}
		scene.addEventFilter(KeyEvent.ANY, keyHandler);

		prim.setScene(scene);
		prim.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
