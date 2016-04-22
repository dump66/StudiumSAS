
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Aufgabe6 extends Application {

	Stage confirmStage;
	boolean isClosable;

	public void start(final Stage primaryStage) {
		confirmStage = new Stage();
		isClosable = false;
		
		Button btnClose = new Button("Close");
		Button ok = new Button("OK");
		Button cancel = new Button("Cancel");
		Label label = new Label("Wollen sie dieses Fenster vernichten?");

		BorderPane root = new BorderPane();
		BorderPane cnfPane = new BorderPane();
		Scene scene = new Scene(root, 400, 400);
		Scene cnfScene = new Scene(cnfPane, 200, 200);

		confirmStage.initModality(Modality.APPLICATION_MODAL);
		confirmStage.setScene(cnfScene);
		confirmStage.initOwner(primaryStage);
		primaryStage.setScene(scene);
		cnfPane.setTop(label);
		BorderPane.setAlignment(cnfPane.getTop(), Pos.CENTER);
		cnfPane.setLeft(ok);
		cnfPane.setRight(cancel);
		root.setCenter(btnClose);

		primaryStage.show();

		btnClose.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// Alert alert = new Alert(AlertType.CONFIRMATION);
				// alert.setTitle("Spinnst du?");
				// alert.setContentText("Willst du mich wirklich beenden?");
				// Optional<ButtonType> result = alert.showAndWait();
				// if (result.get() == ButtonType.OK){
				// Platform.exit();
				// }
				confirmStage.show();
			}
		});

		ok.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				isClosable = !isClosable;
			}
		});

		cancel.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				confirmStage.close();
			}
		});
	}

	public static void main(String[] args) {
		launch(args);
	}
}