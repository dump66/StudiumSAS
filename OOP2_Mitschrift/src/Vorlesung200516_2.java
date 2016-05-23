

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


// Vielen Dank an Simon K. für den Code
// Accordion
public class Vorlesung200516_2 extends Application {

	@Override
	public void start(Stage primaryStage) {
		Accordion accordion = new Accordion();
		
		TitledPane power = new TitledPane("Power Control", new FlowPane(new Button("Stop"),new Button("Restart"),new Button("Suspend")));
		
		TitledPane devices = new TitledPane("Device Control", new FlowPane(new Button("Network Enable"),new Button("Printer Enable")));
		
		accordion.getPanes().addAll(power,devices);
		
		Scene scene = new Scene(accordion,300,250);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

//Accordion:
//	Gruppe von TitledPanes, wobei nur eine TitledPane geöffnet werden kann