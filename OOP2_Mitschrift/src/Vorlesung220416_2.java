import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//PlatformDrag&Drop
public class Vorlesung220416_2 extends Application {
	Text t1;
	Text t2;

	public void init() {
		t1 = new Text("Please drag me");
		t2 = new Text("You can drop text here");

		t1.setOnDragDetected(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				Dragboard db = t1.startDragAndDrop(TransferMode.COPY_OR_MOVE);
				ClipboardContent content = new ClipboardContent();
				content.putString(t1.getText());
				db.setContent(content);
			}
		});
		t2.setOnDragEntered(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				t2.setFont(Font.font("Verdana", FontPosture.ITALIC, 14));
				t2.setFill(Color.ORANGE);
			}
		});
		
		t2.setOnDragExited(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				t2.setFont(Font.getDefault());
				t2.setFill(Color.BLACK);
			}
		});
		
		t2.setOnDragOver(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				if (event.getDragboard().hasString()){
					event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
				}
			}
		});
		t2.setOnDragDropped(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				t2.setText(event.getDragboard().getString());
				event.setDropCompleted(true);
			}
		});
		
		t1.setOnDragDone(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				if (event.getTransferMode() == TransferMode.MOVE){
					t1.setText("Text has moved.");
					t1.setOnDragDetected(null);
				}
			}
		});
	}

	public void start(Stage primStage) {

		BorderPane root = new BorderPane();
		root.setLeft(t1);
		root.setRight(t2);
		BorderPane.setAlignment(t1, Pos.CENTER);
		BorderPane.setAlignment(t2, Pos.CENTER);
		Scene scene = new Scene(root, 500, 300);
		primStage.setScene(scene);
		primStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
