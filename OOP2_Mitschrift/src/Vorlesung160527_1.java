
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.control.SplitPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// Controls
public class Vorlesung160527_1 extends Application {
	Text text;

	@Override
	public void start(Stage prim) throws Exception {
		MenuBar mbar = new MenuBar();
		Menu datei = new Menu("Datei");
		MenuItem neu = new MenuItem("Neu");

		EventHandler action = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				text.setText(((MenuItem) event.getTarget()).getText());
			}
		};
		datei.setOnAction(action);
		datei.getItems().addAll(neu, new MenuItem("Öffnen"), new MenuItem("Schließen"));
		mbar.getMenus().add(datei);

		ChoiceBox choices = new ChoiceBox(FXCollections.observableArrayList("Rot", "Grün", "Blau"));
		choices.getSelectionModel().select(0);
		choices.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				text.setText(choices.getSelectionModel().getSelectedItem().toString());
			}
		});

		ComboBox combo = new ComboBox<>(FXCollections.observableArrayList("Groß", "Mittel", "Klein"));
		combo.setEditable(true);
		combo.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				text.setText(combo.getSelectionModel().getSelectedItem().toString());
			}
		});

		CheckBox checkBox = new CheckBox("Ich höre in der Vorlesung aufmerksam zu...");
		checkBox.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (checkBox.isSelected()) {
					text.setText("...und verstehe wovon gesprochen wird.");
				}
			}
		});

		ToggleGroup group = new ToggleGroup();
		ToggleButton button1 = new ToggleButton("An");
		ToggleButton button2 = new ToggleButton("Aus");
		RadioButton radio = new RadioButton("Undefined");
		group.getToggles().addAll(button1, button2, radio);

		ToolBar tools = new ToolBar(mbar, new Separator(), choices, new Separator(), combo, button1, button2, radio);

		ProgressBar pBar = new ProgressBar(-1);
		ProgressIndicator pInd = new ProgressIndicator(-1);
		pInd.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

		Slider slider = new Slider(0, 100, 50);

		NumberBinding value = Bindings.divide(slider.valueProperty(), slider.getMax());

		pBar.progressProperty().bind(value);
		pInd.progressProperty().bind(value);

		SplitPane split = new SplitPane();
		split.setOrientation(Orientation.VERTICAL);
		split.getItems().addAll(pBar, pInd, slider);

		text = new Text();
		BorderPane root = new BorderPane();
		root.setTop(tools);
		root.setCenter(checkBox);
		root.setRight(new ScrollPane(split));
		root.setBottom(text);

		Scene scene = new Scene(root);
		prim.setScene(scene);
		prim.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
