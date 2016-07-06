package fxml;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxmlTester extends Application {

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		URL location = getClass().getResource("MyGui.fxml");
		FXMLLoader fxmlLoader = new FXMLLoader(location);
		
		VBox root = fxmlLoader.load();
		MyController mc = (MyController) fxmlLoader.getController();
		mc.label.setText("Neuer Text");
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
