import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

//Window Observer
public class Vorlesung290416_4 extends Application {

	@Override
	public void start(Stage prim) throws Exception {
		SimpleDoubleProperty pos1, pos2;
		pos1 = new SimpleDoubleProperty();
		pos2 = new SimpleDoubleProperty();

		NumberBinding sum = Bindings.add(pos1, pos2).add(pos1);

		System.out.println(sum.getValue());
		pos1.set(100);
		System.out.println(sum.getValue());
		pos2.set(200);
		System.out.println(sum.getValue());

	}

	public static void main(String[] args) {
		launch(args);
	}

}
