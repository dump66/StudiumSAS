import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
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

public class Aufgabe7u8Alternative extends Application {
	private ImageView head;
	private ImageView doll;
	private ImageView[] pDresses;
	private ImageView[] eDresses;
	private VBox vBox;
	private HBox hBox;
	private FlowPane fPane;
	private StackPane sPane;
	Scene scene;
	private double ox;
	private double oy;
	private double mx;
	private double my;

	public void init() {
		pDresses = getDresses(false);
		eDresses = getDresses(true);
		head = new ImageView(new Image("file:images/ui/flowers.jpg"));
		doll = new ImageView(new Image("file:images/body.png"));
		vBox = new VBox();
		hBox = new HBox();
		fPane = new FlowPane();
		sPane = new StackPane();
		sPane.getChildren().add(doll);
		fPane.getChildren().addAll(pDresses);
		hBox.getChildren().addAll(fPane, sPane);
		vBox.getChildren().addAll(head, hBox);
	}

	@Override
	public void start(Stage prim) throws Exception {
		scene = new Scene(vBox);
		scene.setOnDragDetected(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (!event.isAltDown()) {
					if (event.getTarget() instanceof ImageView) {
						ImageView iv = (ImageView) event.getTarget();
						Image img;
						ClipboardContent content = new ClipboardContent();
						for (ImageView pDress : pDresses) {
							if (iv == pDress) {
								for (ImageView eDress : eDresses) {
									if (eDress.getId().equals(pDress.getId())) {
										img = eDress.getImage();
										content.putImage(img);
									}
								}
							}
						}
						Dragboard db = fPane.startDragAndDrop(TransferMode.COPY);
						db.setContent(content);
					}
				} else {
					Dragboard db = scene.startDragAndDrop(TransferMode.MOVE);
					ClipboardContent content = new ClipboardContent();
					content.putString("");
					db.setContent(content);
				}
			}
		});

		sPane.setOnDragDropped(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				if (event.getDragboard().hasImage()) {
					Object[] list = sPane.getChildren().toArray();
					for (Object iv : list) {
						if (iv != doll) {
							sPane.getChildren().remove(iv);
						}
					}
					sPane.getChildren().add(new ImageView(event.getDragboard().getImage()));
					event.setDropCompleted(true);
				}
			}
		});

		EventHandler<DragEvent> dragOverHandler = new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				if (event.getDragboard().hasImage()) {
					if (event.getTarget() instanceof ImageView) {
						if (((ImageView) event.getTarget()).getParent() instanceof StackPane) {
							event.acceptTransferModes(TransferMode.COPY);
						}
					}
				} else {
					prim.setX(event.getScreenX() - (mx - ox));
					prim.setY(event.getScreenY() - (my - oy));
					event.acceptTransferModes(TransferMode.MOVE);
				}
			}
		};
		scene.setOnDragOver(dragOverHandler);

		scene.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				ox = prim.getX();
				oy = prim.getY();
				mx = event.getScreenX();
				my = event.getScreenY();
			}
		});

		prim.setScene(scene);
		prim.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	private ImageView[] getDresses(boolean isEquipped) {
		ArrayList<ImageView> al = new ArrayList<>();
		if (isEquipped) {
			al.add(new ImageView(new Image("file:images/clothes/equipped/dress1.png")));
			al.add(new ImageView(new Image("file:images/clothes/equipped/dress2.png")));
			al.add(new ImageView(new Image("file:images/clothes/equipped/dress3.png")));
			al.add(new ImageView(new Image("file:images/clothes/equipped/dress4.png")));
		} else {
			al.add(new ImageView(new Image("file:images/clothes/preview/dress1.png")));
			al.add(new ImageView(new Image("file:images/clothes/preview/dress2.png")));
			al.add(new ImageView(new Image("file:images/clothes/preview/dress3.png")));
			al.add(new ImageView(new Image("file:images/clothes/preview/dress4.png")));
		}
		for (int i = 0; i < al.size(); i++) {
			al.get(i).setId("k" + i);
		}
		return al.toArray(new ImageView[al.size()]);
	}

}
