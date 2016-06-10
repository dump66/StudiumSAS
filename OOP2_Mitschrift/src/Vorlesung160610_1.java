import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Vorlesung160610_1 extends Application {

	ObservableList<String> namesList;
	
	@Override
	public void init(){
		String[] names = new String[] {"Jaqueline", "Maria", "Joseph", "Jesus", "Jonathan", "Markus", "Mike", "Michaela"};
		namesList = FXCollections.observableArrayList(names);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		ListView<String> list = new ListView<String>();
		list.setItems(namesList);
		list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		TextField input = new TextField();
		input.setOnAction((event)-> {
			TextField field = (TextField) event.getTarget();
			namesList.add(field.getText());
			FXCollections.sort(namesList);
			field.clear();
		});
		
		Scene scene = new Scene(new VBox(input, list));
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
