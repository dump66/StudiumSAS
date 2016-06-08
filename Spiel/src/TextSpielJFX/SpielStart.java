package TextSpielJFX;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SpielStart extends Application {

	static Button button1;
	static Button button2;
	static Button button3;
	static Button button4;

	Scene scene;
	BorderPane root;
	static TextArea text = new TextArea();

	@Override
	public void start(Stage primaryStage) throws Exception {
		text.setEditable(false);
		text.setPrefSize(500, 500);
		text.setMaxSize(500, 500);
		text.setWrapText(true);
		root = new BorderPane();
		button1 = new Button();
		button2 = new Button();
		button3 = new Button();
		button4 = new Button();
		button1.setTranslateX(text.getTranslateX() + text.getWidth() + 20);
		button1.setTranslateX(text.getTranslateY());
		button2.setTranslateX(button1.getTranslateX());
		button2.setTranslateY(button1.getTranslateY() + 50);
		button3.setVisible(false);
		button4.setVisible(false);

		root.setCenter(text);
		root.setRight(new VBox(button1, button2, button3, button4));

		scene = new Scene(root, 700, 700);
		primaryStage.setScene(scene);
		primaryStage.show();

		initGame(primaryStage);

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void initGame(Stage primaryStage) {
		Held held1 = new Held("Stephan", 3, 3, 1);
		Abenteuer1 abenteuer = new Abenteuer1();

		text.setText("Moechtest du einen alten Spielstand laden?");
		button1.setText("Ja");
		button2.setText("Nein");
		button1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					FileChooser fc = new FileChooser();
					File alterHeld = fc.showOpenDialog(primaryStage);
					if (alterHeld != null) {
						BufferedReader bf = new BufferedReader(new FileReader(alterHeld));
						held1.setnameH(bf.readLine());
						held1.setGesundheit(Integer.parseInt(bf.readLine()));
						abenteuer.setZeile(Integer.parseInt(bf.readLine()));
						abenteuer.setSpalte(Integer.parseInt(bf.readLine()));
						held1.setproviant(Integer.parseInt(bf.readLine()));
						held1.setwasser(Integer.parseInt(bf.readLine()));
						held1.setstaerkeH(Integer.parseInt(bf.readLine()));
						held1.setwiderstandH(Integer.parseInt(bf.readLine()));
						held1.setgeschickH(Integer.parseInt(bf.readLine()));
						held1.setErfahrung(Integer.parseInt(bf.readLine()));
						held1.setGeld(Integer.parseInt(bf.readLine()));
						held1.setfell(Integer.parseInt(bf.readLine()));
						held1.setheilkraut(Integer.parseInt(bf.readLine()));
						bf.close();
						button2.fireEvent(new ActionEvent());
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		button2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				button1.setVisible(false);
				button2.setVisible(false);
				try {
					abenteuer.intro();
					SpielStart.button1.setText("SCHÖN!");
					SpielStart.button1.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(5), null)));
					SpielStart.button1.setVisible(true);
					SpielStart.button1.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							button1.setVisible(false);
							abenteuer.erstelleKarte();
						}
					});

					// abenteuer.reisen(held1);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

	}

}
