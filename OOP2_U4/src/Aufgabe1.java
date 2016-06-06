import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Separator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Aufgabe1 extends Application {

	WebView wv = new WebView();

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();

		ToolBar workBar = new ToolBar();
		TextField tf = new TextField();
		Button go = new Button("Go");
		Button newTab = new Button("Tab");
		workBar.getItems().addAll(tf, new Separator(), go, new Separator(), newTab);
		
		ToolBar statusBar = new ToolBar();
		ProgressBar pBar = new ProgressBar();
		pBar.progressProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if (newValue.doubleValue() == 1){
					pBar.setVisible(false);
				} else {
					pBar.setVisible(true);
				}
			}
		});
		statusBar.getItems().addAll(pBar);

		TabPane tabBar = new TabPane();

		root.setTop(workBar);
		root.setCenter(tabBar);
		root.setBottom(statusBar);
		Scene scene = new Scene(root, 1000, 700);
		primaryStage.setScene(scene);
		primaryStage.show();

		newTab.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				WebView neu = new WebView();
				neu.getEngine().locationProperty().addListener(new ChangeListener<String>() {

					@Override
					public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
						tf.setText(newValue);
					}
				});
				neu.getEngine().load("http://www.google.de");
				Tab neuerTab = new Tab("Neu", neu);
				neuerTab.textProperty().bind(neu.getEngine().titleProperty());
				tabBar.getTabs().add(neuerTab);
				tabBar.getSelectionModel().select(neuerTab);
			}
		});

		tabBar.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {

			@Override
			public void changed(ObservableValue<? extends Tab> observable, Tab oldValue, Tab newValue) {
				pBar.progressProperty().unbind();
				if (newValue != null) {
					wv = (WebView) newValue.getContent();
					tf.setText(wv.getEngine().getLocation());
					pBar.progressProperty().bind(wv.getEngine().getLoadWorker().progressProperty());
				} else {
					wv = null;
				}
			}
		});

		EventHandler<ActionEvent> action = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (wv != null) {
					wv.getEngine().load(tf.getText());
				}
			}
		};

		tf.setOnAction(action);

		go.setOnAction(action);

		newTab.fire();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
