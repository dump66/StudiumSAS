import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.stage.Stage;

// Properties
public class Vorlesung290416_2 extends Application {

	@Override
	public void start(Stage prim) throws Exception {
		SimpleDoubleProperty a, b;
		a = new SimpleDoubleProperty(1.0);
		a.addListener(new InvalidationListener() {
			
			@Override
			public void invalidated(Observable observable) {
				System.out.println(observable);
			}
		});
		
//		a.addListener(new ChangeListener() {
//
//			@Override
//			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
//				System.out.println(oldValue + " " + newValue);
//			}
//			
//		});
		for (int i = 0; i < 10;a.set(i++));
	}

	public static void main(String[] args) {
		launch(args);
	}

}
