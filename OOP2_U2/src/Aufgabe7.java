
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
	Image selectedIm;

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
				ImageView cloth = (ImageView) event.getTarget();
				selectedIm = cloth.getImage();
				ClipboardContent content = new ClipboardContent();
				Dragboard db = cloth.startDragAndDrop(TransferMode.COPY);
				content.putImage(cloth.getImage());
				db.setContent(content);
			}
		};
		
		EventHandler<DragEvent> dragOverHandler = new EventHandler<DragEvent>() {
			public void handle(DragEvent event){
				if (event.getDragboard().hasImage()){
					event.acceptTransferModes(TransferMode.COPY);
				}
			}
		};
		
		EventHandler<DragEvent> dragDroppedHandler = new EventHandler<DragEvent>() {
			public void handle(DragEvent event){
				for (Node n : sPane.getChildren()) {
					if (n != dollIv){
						sPane.getChildren().remove(n);
						break;
					}
				}
				Image im = event.getDragboard().getImage();
				for (int i = 0; i<pDresses.length; i++){
					if (selectedIm == pDresses[i].getImage()){
						sPane.getChildren().add(eDresses[i]);
						break;
					}
				}
				event.setDropCompleted(true);
			}
		};
		for (ImageView iv : pDresses) {
			iv.setOnDragDetected(dragDetectedHandler);
		}
		sPane.setOnDragOver(dragOverHandler);
		sPane.setOnDragDropped(dragDroppedHandler);

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
