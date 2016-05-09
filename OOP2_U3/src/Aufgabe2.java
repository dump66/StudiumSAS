
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Aufgabe2 extends Application {
	Pane pane;
	Scene scene;

	@Override
	public void start(Stage prim) throws Exception {
		pane = new Pane();
		pane.setPrefWidth(1280);
		pane.setPrefHeight(500);
		
		EventHandler<MouseEvent> mouseClickedEvent = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event){
				((PianoButton) event.getTarget()).getTon().getClip().play();
			}
		};

		for (int i = 0; i < 24; i++) {
			PianoButton pb;
			if (i < 14) {
				switch (i) {
				case 0:
					pb = new PianoButton(i * 85 + 5, 0, 80, 400, Toene.C);
					break;
				case 1:
					pb = new PianoButton(i * 85 + 5, 0, 80, 400, Toene.D);
					break;
				case 2:
					pb = new PianoButton(i * 85 + 5, 0, 80, 400, Toene.E);
					break;
				case 3:
					pb = new PianoButton(i * 85 + 5, 0, 80, 400, Toene.F);
					break;
				case 4:
					pb = new PianoButton(i * 85 + 5, 0, 80, 400, Toene.G);
					break;
				case 5:
					pb = new PianoButton(i * 85 + 5, 0, 80, 400, Toene.A);
					break;
				case 6:
					pb = new PianoButton(i * 85 + 5, 0, 80, 400, Toene.H);
					break;
				case 7:
					pb = new PianoButton(i * 85 + 5, 0, 80, 400, Toene.C1);
					break;
				case 8:
					pb = new PianoButton(i * 85 + 5, 0, 80, 400, Toene.D1);
					break;
				case 9:
					pb = new PianoButton(i * 85 + 5, 0, 80, 400, Toene.E1);
					break;
				case 10:
					pb = new PianoButton(i * 85 + 5, 0, 80, 400, Toene.F1);
					break;
				case 11:
					pb = new PianoButton(i * 85 + 5, 0, 80, 400, Toene.G1);
					break;
				case 12:
					pb = new PianoButton(i * 85 + 5, 0, 80, 400, Toene.A1);
					break;
				case 13:
					pb = new PianoButton(i * 85 + 5, 0, 80, 400, Toene.H1);
					break;
				default:
					pb = new PianoButton(0, 0, 0, 0, Toene.A);

				}
				pb.setStroke(Color.BLACK);
				pb.setFill(Color.WHITE);
				pane.getChildren().add(pb);
				pb.setOnMouseClicked(mouseClickedEvent);
			} else if (i >= 14) {
				switch (i) {
				case 14:
					pb = new PianoButton(1 * 80 + 1 * 5 - 30, 0, 60, 200, Toene.CIS);
					break;
				case 15:
					pb = new PianoButton(2 * 80 + 2 * 5 - 30, 0, 60, 200, Toene.ES);
					break;
				case 16:
					pb = new PianoButton(4 * 80 + 4 * 5 - 30, 0, 60, 200, Toene.FIS);
					break;
				case 17:
					pb = new PianoButton(5 * 80 + 5 * 5 - 30, 0, 60, 200, Toene.GIS);
					break;
				case 18:
					pb = new PianoButton(6 * 80 + 6 * 5 - 30, 0, 60, 200, Toene.B);
					break;
				case 19:
					pb = new PianoButton(8 * 80 + 8 * 5 - 30, 0, 60, 200, Toene.CIS1);
					break;
				case 20:
					pb = new PianoButton(9 * 80 + 9 * 5 - 30, 0, 60, 200, Toene.ES1);
					break;
				case 21:
					pb = new PianoButton(11 * 80 + 11 * 5 - 30, 0, 60, 200, Toene.FIS1);
					break;
				case 22:
					pb = new PianoButton(12 * 80 + 12 * 5 - 30, 0, 60, 200, Toene.GIS1);
					break;
				case 23:
					pb = new PianoButton(13 * 80 + 13 * 5 - 30, 0, 60, 200, Toene.B1);
					break;
				default:
					pb = new PianoButton(0, 0, 0, 0, Toene.A);
				}
				pb.setFill(Color.BLACK);
				pane.getChildren().add(pb);
				pb.setOnMouseClicked(mouseClickedEvent);
			}
		}

		scene = new Scene(pane);
		prim.setScene(scene);
		prim.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
