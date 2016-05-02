
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Aufgabe7u8 extends Application {

	private ImageView[] pDresses;
	private ImageView[] eDresses;
	private ImageView headIv;
	private ImageView dollIv;
	private HBox hbox;
	private StackPane sPane;
	private FlowPane fPane;
	private VBox vbox;
	private Scene scene;
	private Image selectedIm;
	private double mX;
	private double mY;
	private double oX;
	private double oY;

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

			public void handle(MouseEvent event) {
				if (!event.isAltDown()) {
					if (event.getTarget() instanceof ImageView) {
						ImageView cloth = (ImageView) event.getTarget();
						selectedIm = cloth.getImage();
						ClipboardContent content = new ClipboardContent();
						Dragboard db = cloth.startDragAndDrop(TransferMode.COPY);
						content.putImage(cloth.getImage());
						db.setContent(content);
					}
				}
			}
		};

		EventHandler<DragEvent> dragOverHandler = new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				if (event.getDragboard().hasImage()) {
					event.acceptTransferModes(TransferMode.COPY);
				}
			}
		};

		EventHandler<DragEvent> newDragOverHandler = new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				if (!event.getDragboard().hasImage()) {
					event.acceptTransferModes(TransferMode.MOVE);
				}
			}
		};

		EventHandler<DragEvent> dragDroppedHandler = new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				if (event.getTarget() instanceof ImageView) {
					for (Node n : sPane.getChildren()) {
						if (n != dollIv) {
							sPane.getChildren().remove(n);
							break;
						}
					}
					Image im = event.getDragboard().getImage();
					for (int i = 0; i < pDresses.length; i++) {
						if (selectedIm == pDresses[i].getImage()) {
							sPane.getChildren().add(eDresses[i]);
							switch (i) {
							case 0:
								scene.setFill(Color.GRAY);
								break;
							case 1:
								scene.setFill(Color.CHARTREUSE);
								break;
							case 2:
								scene.setFill(Color.YELLOW);
								break;
							case 3:
								scene.setFill(Color.AQUAMARINE);
								break;
							default:
								scene.setFill(Color.WHITE);
								break;
							}
							break;
						} else {
							scene.setFill(Color.WHITE);
						}
					}
					event.setDropCompleted(true);
				}
			}
		};

		EventHandler<MouseEvent> mouseDraggedHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				if (event.isAltDown()) {
					primStage.setX(event.getScreenX() - (mX - oX));
					primStage.setY(event.getScreenY() - (mY - oY));
				}
			}
		};

		EventHandler<MouseEvent> mousePressedHandler = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				mX = event.getScreenX();
				mY = event.getScreenY();
				oX = primStage.getX();
				oY = primStage.getY();
			}
		};

		// for (ImageView iv : pDresses) {
		// iv.setOnDragDetected(dragDetectedHandler);
		// }
		scene = new Scene(vbox);
		sPane.setOnDragOver(dragOverHandler);
		sPane.setOnDragDropped(dragDroppedHandler);
		scene.setOnDragDetected(dragDetectedHandler);
		// scene.setOnDragOver(newDragOverHandler);
		scene.setOnMouseDragged(mouseDraggedHandler);
		scene.setOnMousePressed(mousePressedHandler);

		sPane.getChildren().add(dollIv);
		fPane.getChildren().addAll(pDresses);
		vbox.getChildren().addAll(headIv, hbox);
		hbox.getChildren().addAll(fPane, sPane);

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
