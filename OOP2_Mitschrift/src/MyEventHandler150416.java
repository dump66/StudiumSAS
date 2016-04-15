import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MyEventHandler150416 implements EventHandler<MouseEvent>{

	String info;
	
	public MyEventHandler150416(String info){
		this.info = info;
	}
	
	public void handle(MouseEvent event){
		System.out.println(info + " Button: " + event.getButton() + " Koordinaten: " + event.getSceneX() + ";" + event.getSceneY());
	}
}
