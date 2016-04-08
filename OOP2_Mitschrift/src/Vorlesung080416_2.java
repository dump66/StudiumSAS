import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

// Vom 01.04.16
public class Vorlesung080416_2 extends Application{
	
	public void start(Stage primaryStage){
		try{
			BorderPane root = new BorderPane();
			Button open = new Button("open");
			open.setOnAction(new EventHandler<ActionEvent>() {
				
				public void handle(ActionEvent action){
					Stage newStage = new Stage();
					newStage.initModality(Modality.APPLICATION_MODAL);
					newStage.show();
					
				}
			});
			root.setCenter(open);
			Scene scene = new Scene(root, 400,400);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args){
		Vorlesung010416.launch(args);
	}
}
