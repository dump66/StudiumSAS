import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// Slider Bindings
public class Vorlesung060516_1 extends Application {

	@Override
	public void start(Stage prim) throws Exception {

		Text t1 = new Text();

		Slider vert, hori;

		vert = new Slider(0, 300, 50);
		vert.setOrientation(Orientation.VERTICAL);
		vert.setBlockIncrement(2);
		vert.setMajorTickUnit(5);
		vert.setShowTickLabels(true);
		vert.setShowTickMarks(true);
		vert.setSnapToTicks(true);

		hori = new Slider(0, 200, 50);
		// hori.setBlockIncrement(2);
		// hori.setMajorTickUnit(5);
		// hori.setShowTickLabels(true);
		// hori.setShowTickMarks(true);
		t1.textProperty().bind(hori.valueProperty().asString());

		// Bidirektional immer 1:1
		// vert.valueProperty().bindBidirectional(hori.valueProperty());

		vert.valueProperty().bind(Bindings.divide(hori.valueProperty(), Bindings.subtract(hori.maxProperty(), hori.minProperty())).multiply(Bindings.subtract(vert.maxProperty(), vert.minProperty())));

		BorderPane root = new BorderPane();

		root.setRight(vert);
		root.setBottom(hori);
		root.setCenter(t1);
		Scene scene = new Scene(root);
		prim.setScene(scene);
		prim.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
