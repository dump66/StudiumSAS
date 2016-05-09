

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Aufgabe2 extends Application {
	Pane pane;
	Scene scene;

	@Override
	public void start(Stage prim) throws Exception {
		pane = new Pane();
		pane.setPrefWidth(1280);
		pane.setPrefHeight(500);
		
		EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event){
				if (event.getEventType() == MouseEvent.MOUSE_CLICKED){
				((PianoButton) event.getTarget()).getTon().getClip().play();
				} else if (event.getEventType() == MouseEvent.MOUSE_PRESSED){
					DropShadow ds = new DropShadow(20, 5, 5, Color.BLACK);
					((PianoButton) event.getTarget()).setEffect(ds);
				} else if (event.getEventType() == MouseEvent.MOUSE_RELEASED){
					((PianoButton) event.getTarget()).setEffect(null);
				}
			}
		};
		
		EventHandler<KeyEvent> keyHandler = new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				PianoButton button;
				if (event.getEventType() == KeyEvent.KEY_PRESSED){
					for (Node n : pane.getChildren()) {
						if (n instanceof PianoButton){
							button = (PianoButton) n;
							if (event.getCode().equals(button.getTon().getCode())){
								button.getTon().getClip().play();
								DropShadow ds = new DropShadow(20, 5, 5, Color.BLACK);
								button.setEffect(ds);
							}
						}
					}
				} else if (event.getEventType() == KeyEvent.KEY_RELEASED){
					for (Node n : pane.getChildren()) {
						if (n instanceof PianoButton){
							button = (PianoButton) n;
							if (event.getCode().equals(button.getTon().getCode())){
								button.setEffect(null);
							}
						}
					}
				}
				
			}
			
		};
		PianoButton pb = null;
		Text txt = null;
		for (int i = 0; i < 24; i++) {
			txt = new Text("");
			if (i < 14) {
				double x = i*85+5;
				switch (i) {
				case 0:
					pb = new PianoButton(x, 0, 80, 400, Toene.C);
					txt = new Text(x+35, 350, pb.getTon().getCode().toString());
					break;
				case 1:
					pb = new PianoButton(x, 0, 80, 400, Toene.D);
					txt = new Text(x+35, 350, pb.getTon().getCode().toString());
					break;
				case 2:
					pb = new PianoButton(x, 0, 80, 400, Toene.E);
					txt = new Text(x+35, 350, pb.getTon().getCode().toString());
					break;
				case 3:
					pb = new PianoButton(x, 0, 80, 400, Toene.F);
					txt = new Text(x+35, 350, pb.getTon().getCode().toString());
					break;
				case 4:
					pb = new PianoButton(x, 0, 80, 400, Toene.G);
					txt = new Text(x+35, 350, pb.getTon().getCode().toString());
					break;
				case 5:
					pb = new PianoButton(x, 0, 80, 400, Toene.A);
					txt = new Text(x+35, 350, pb.getTon().getCode().toString());
					break;
				case 6:
					pb = new PianoButton(x, 0, 80, 400, Toene.H);
					txt = new Text(x+35, 350, pb.getTon().getCode().toString());
					break;
				case 7:
					pb = new PianoButton(x, 0, 80, 400, Toene.C1);
					txt = new Text(x+35, 350, pb.getTon().getCode().toString());
					break;
				case 8:
					pb = new PianoButton(x, 0, 80, 400, Toene.D1);
					txt = new Text(x+35, 350, pb.getTon().getCode().toString());
					break;
				case 9:
					pb = new PianoButton(x, 0, 80, 400, Toene.E1);
					txt = new Text(x+35, 350, pb.getTon().getCode().toString());
					break;
				case 10:
					pb = new PianoButton(x, 0, 80, 400, Toene.F1);
					txt = new Text(x+35, 350, pb.getTon().getCode().toString());
					break;
				case 11:
					pb = new PianoButton(x, 0, 80, 400, Toene.G1);
					txt = new Text(x+35, 350, pb.getTon().getCode().toString());
					break;
				case 12:
					pb = new PianoButton(x, 0, 80, 400, Toene.A1);
					txt = new Text(x+35, 350, pb.getTon().getCode().toString());
					break;
				case 13:
					pb = new PianoButton(x, 0, 80, 400, Toene.H1);
					txt = new Text(x+35, 350, pb.getTon().getCode().toString());
					break;
				default:
					pb = new PianoButton(0, 0, 0, 0, Toene.A);

				}
				pb.setStroke(Color.BLACK);
				pb.setFill(Color.WHITE);

			} else if (i >= 14) {
				switch (i) {
				case 14:
					pb = new PianoButton(1 * 85 - 30, 0, 60, 200, Toene.CIS);
					txt = new Text(1*85-30+25, 150, pb.getTon().getCode().toString());
					break;
				case 15:
					pb = new PianoButton(2 * 85 - 30, 0, 60, 200, Toene.ES);
					txt = new Text(2*85-30+25, 150, pb.getTon().getCode().toString());
					break;
				case 16:
					pb = new PianoButton(4 * 85 - 30, 0, 60, 200, Toene.FIS);
					txt = new Text(4*85-30+25, 150, pb.getTon().getCode().toString());
					break;
				case 17:
					pb = new PianoButton(5 * 85 - 30, 0, 60, 200, Toene.GIS);
					txt = new Text(5*85-30+25, 150, pb.getTon().getCode().toString());
					break;
				case 18:
					pb = new PianoButton(6 * 85 - 30, 0, 60, 200, Toene.B);
					txt = new Text(6*85-30+25, 150, pb.getTon().getCode().toString());
					break;
				case 19:
					pb = new PianoButton(8 * 85 - 30, 0, 60, 200, Toene.CIS1);
					txt = new Text(8*85-30+25, 150, pb.getTon().getCode().getName());
					break;
				case 20:
					pb = new PianoButton(9 * 85 - 30, 0, 60, 200, Toene.ES1);
					txt = new Text(9*85-30+25, 150, pb.getTon().getCode().getName());
					break;
				case 21:
					pb = new PianoButton(11 * 85 - 30, 0, 60, 200, Toene.FIS1);
					txt = new Text(11*85-30+25, 150, pb.getTon().getCode().getName());
					break;
				case 22:
					pb = new PianoButton(12 * 85 - 30, 0, 60, 200, Toene.GIS1);
					txt = new Text(12*85-30+25, 150, pb.getTon().getCode().getName());
					break;
				case 23:
					pb = new PianoButton(13 * 85 - 30, 0, 60, 200, Toene.B1);
					txt = new Text(13*85-30+25, 150, pb.getTon().getCode().getName());
					break;
				default:
					pb = new PianoButton(0, 0, 0, 0, Toene.A);
				}
				pb.setFill(Color.BLACK);
				txt.setFill(Color.WHITE);
			}
			pane.getChildren().addAll(pb, txt);
			pb.addEventHandler(MouseEvent.ANY, mouseHandler);
		}

		scene = new Scene(pane);
		scene.addEventHandler(KeyEvent.ANY, keyHandler);
		prim.setScene(scene);
		prim.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
