import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Separator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Browser {
	WebView wv = new WebView();
	boolean isTFFocused = false;
	Stage s;
	TextField tField;
	String startPage = "http://www.google.de";

	private Browser(Stage primaryStage) {
		s = primaryStage;
		BorderPane root = new BorderPane();

		MenuBar mBar = new MenuBar();
		Menu datei = new Menu("Datei");
		Menu extras = new Menu("Extras");
		Menu hilfe = new Menu("Hilfe");
		MenuItem mNeuTab = new MenuItem("Neuer Tab");
		mNeuTab.setId("mNeuTab");
		MenuItem mNeuFenster = new MenuItem("Neues Fenster");
		mNeuFenster.setId("mNeuFenster");
		MenuItem mSettings = new MenuItem("Einstellungen");
		mSettings.setId("mSettings");
		MenuItem mAbout = new MenuItem("Über");
		mAbout.setId("mAbout");
		datei.getItems().addAll(mNeuTab, mNeuFenster);
		extras.getItems().add(mSettings);
		hilfe.getItems().add(mAbout);
		mBar.getMenus().addAll(datei, extras, hilfe);

		ImageView goImg = new ImageView("file:files/go.png");
		goImg.setPreserveRatio(true);
		goImg.setFitHeight(30);
		ImageView homeImg = new ImageView("file:files/home.png");
		homeImg.setPreserveRatio(true);
		homeImg.setFitHeight(30);
		ImageView refreshImg = new ImageView("file:files/refresh.png");
		refreshImg.setPreserveRatio(true);
		refreshImg.setFitHeight(30);
		ImageView tabImg = new ImageView("file:files/tab.png");
		tabImg.setPreserveRatio(true);
		tabImg.setFitHeight(30);

		ToolBar workBar = new ToolBar();
		Button home = new Button("", homeImg);
		Button refresh = new Button("", refreshImg);
		TextField tf = new TextField();
		this.tField = tf;
		tf.setPrefWidth(300);
		Button go = new Button("", goImg);
		Button newTab = new Button("", tabImg);
		workBar.getItems().addAll(home, new Separator(), refresh, new Separator(), tf, new Separator(), go, new Separator(), newTab);

		ToolBar statusBar = new ToolBar();
		ProgressBar pBar = new ProgressBar();

		Text infoText = new Text();
		statusBar.getItems().addAll(pBar, new Separator(), infoText);

		TabPane tabBar = new TabPane();

		root.setTop(new VBox(mBar, workBar));
		root.setCenter(tabBar);
		root.setBottom(statusBar);
		Scene scene = new Scene(root, 1000, 700);
		primaryStage.setScene(scene);
		primaryStage.show();

		refresh.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				wv.getEngine().reload();
			}
		});

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
				neu.getEngine().load(startPage);
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
				infoText.textProperty().unbind();
				wv.getEngine().setOnAlert(null);
				wv.getEngine().setOnError(null);
				if (newValue != null) {
					wv = (WebView) newValue.getContent();
					tf.setText(wv.getEngine().getLocation());
					pBar.progressProperty().bind(wv.getEngine().getLoadWorker().progressProperty());
					infoText.textProperty().bind(wv.getEngine().getLoadWorker().messageProperty());

					wv.getEngine().getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {

						@Override
						public void changed(ObservableValue<? extends State> observable, State oldValue, State newValue) {
							if (newValue == State.FAILED) {
								wv.getEngine().loadContent("<body>Fehler: Diese Seite ist nicht bekannt!</body>");
							}
						}
					});
				} else {
					wv = null;
				}
			}
		});

		EventHandler<ActionEvent> action = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (wv != null) {
					String url = tf.getText();
					if (!url.startsWith("http://www.")) {
						url = "http://www.".concat(url);
					}
					wv.getEngine().load(url);
					tf.setText(url);
				}
			}
		};

		home.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				wv.getEngine().load(startPage);
			}
		});

		pBar.progressProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				if (newValue.doubleValue() == 1) {
					infoText.setVisible(false);
					pBar.setVisible(false);
				} else {
					pBar.setVisible(true);
					infoText.setVisible(true);
				}
			}
		});

		tf.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (isTFFocused) {
					tf.selectAll();
				}
				isTFFocused = false;
			}
		});

		tf.focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (!oldValue && newValue) {
					isTFFocused = true;
				}
			}
		});
		
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				save();
			}
		});

		EventHandler<ActionEvent> menuEvents = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				switch (((MenuItem) event.getTarget()).getId()) {
				case "mNeuTab":
					newTab.fire();
					break;
				case "mNeuFenster":
					new Browser(new Stage());
					break;
				case "mSettings":
					createSettingsPage();
					break;
				case "mAbout":
					createAboutPage();
					break;
				}
			}
		};

		mNeuTab.setOnAction(menuEvents);
		mNeuFenster.setOnAction(menuEvents);
		mSettings.setOnAction(menuEvents);
		mAbout.setOnAction(menuEvents);
		tf.setOnAction(action);
		go.setOnAction(action);
		newTab.fire();
	}

	protected void createAboutPage() {
		Stage about = new Stage();
		about.initOwner(s);
		about.initModality(Modality.WINDOW_MODAL);

		VBox box = new VBox(10);
		box.getChildren().addAll(new Text("HorstBrowser"), new Text("Andreas Schultze-20151027"), new Text("Übung 4 - VL Objektorientierte Programmierung 2"), new Text("VInf-SS2016"));
		Scene s = new Scene(box);
		about.setScene(s);
		about.show();
	}

	protected void createSettingsPage() {
		Stage settings = new Stage();
		settings.initOwner(s);
		settings.initModality(Modality.WINDOW_MODAL);

		BorderPane bp = new BorderPane();
		Label label = new Label("Startseite:");
		TextField field = new TextField(startPage);
		bp.setTop(new HBox(label, field));
		Button ok = new Button("Ok");
		Button cancel = new Button("Cancel");
		Button current = new Button("Aktuelle Seite übernehmen");
		bp.setCenter(current);
		bp.setBottom(new HBox(ok, cancel));
		settings.setScene(new Scene(bp));
		settings.show();
		ok.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				startPage = field.getText();
				settings.close();
			}
		});
		cancel.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				settings.close();
			}
		});
		current.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				field.setText(wv.getEngine().getLocation());
			}
		});
	}

	public void save() {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("browser.txt"));
			oos.writeUTF(startPage);
			oos.flush();
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static Browser load(Stage stage) {
		Browser b = new Browser(stage);
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("browser.txt"));
			if (ois != null) {
				if (ois.available() > 0) {
					b.startPage = ois.readUTF();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return b;
	}
}
