import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Aufgabe7 extends Application {

	private ImageView[] pDresses;
	private ImageView[] eDresses;
	private ImageView headIv;
	private ImageView dollIv;
	private HBox hbox;
	private StackPane sPane;
	private FlowPane fPane;
	private VBox vbox;
	private Scene scene;

	public void init() {
		vbox = new VBox();
		hbox = new HBox();
		fPane = new FlowPane();
		sPane = new StackPane();

		Image head = new Image("file:images/ui/flowers.jpg");
		Image doll = new Image("file:images/body.png");

		pDresses = getDresses(true);
		eDresses = getDresses(false);
		headIv = new ImageView(head);
		dollIv = new ImageView(doll);
	}

	public void start(Stage primStage) {
		EventHandler<MouseEvent> dragDetectedHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event){
				//TODO: Handle Methode schreiben
			}
		};
		for (ImageView iv : pDresses) {
			iv.setOnDragDetected(dragDetectedHandler);
		}

		sPane.getChildren().add(dollIv);
		fPane.getChildren().addAll(pDresses);
		vbox.getChildren().addAll(headIv, hbox);
		hbox.getChildren().addAll(fPane, sPane);

		scene = new Scene(vbox);
		primStage.setScene(scene);
		primStage.show();
	}

	private ImageView[] getDresses(boolean isPreview) {
		ImageView[] dresses = new ImageView[4];
		String path;
		if (isPreview) {
			path = "file:images/clothes/preview/";
		} else {
			path = "file:images/clothes/equipped/";
		}
		for (int i = 0; i < dresses.length; i++) {
			Image im = new Image(path + "dress" + (i + 1) + ".png");
			dresses[i] = new ImageView(im);
		}
		return dresses;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
