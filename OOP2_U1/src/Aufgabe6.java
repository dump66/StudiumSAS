

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Aufgabe6 extends Application{
	
	Stage confirmStage = new Stage();
	
	public void start(final Stage primaryStage){
		BorderPane root = new BorderPane();
		BorderPane cnfPane = new BorderPane();
		Button btn = new Button("Close");
		Button ok = new Button("OK");
		Button cancel = new Button("Cancel");
		Label label = new Label("Wollen sie dieses Fenster vernichten?");
		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
//				Alert alert = new Alert(AlertType.CONFIRMATION);
//				alert.setTitle("Spinnst du?");
//				alert.setContentText("Willst du mich wirklich beenden?");
//				Optional<ButtonType> result = alert.showAndWait();
//				if (result.get() == ButtonType.OK){
//					Platform.exit();
//				}
				confirmStage.show();
			}
		});
		
		ok.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});
		
		cancel.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event){
				confirmStage.close();
			}
		});
		
		cnfPane.setTop(label);
		BorderPane.setAlignment(cnfPane.getTop(), Pos.CENTER);
		cnfPane.setLeft(ok);
		cnfPane.setRight(cancel);
		root.setCenter(btn);
		Scene cnfScene = new Scene(cnfPane, 200, 200);
		Scene scene = new Scene(root, 400, 400);
		confirmStage.setScene(cnfScene);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args){
		launch(args);
	}
}
