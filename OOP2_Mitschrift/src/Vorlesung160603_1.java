
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DisplacementMap;
import javafx.scene.effect.Effect;
import javafx.scene.effect.FloatMap;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.MotionBlur;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

// Effekte
public class Vorlesung160603_1 extends Application {

	final int MAX = 7;
	Effect effects[];

	public void init() {
		effects = new Effect[MAX];
		effects[0] = new Blend(BlendMode.COLOR_BURN);
		effects[1] = new Bloom(0.5);
		effects[2] = new BoxBlur();
		effects[3] = new MotionBlur();
		effects[4] = new GaussianBlur();
		effects[5] = new DisplacementMap();
		effects[6] = new SepiaTone(0.5);

		FloatMap map = new FloatMap(200, 100);
		for (int i = 0; i < map.getWidth(); i++) {
			float value = (float) (Math.sin(i / 20.0 * Math.PI) / 40.0);
			for (int j = 0; j < map.getHeight(); j++) {
				map.setSamples(i, j, 0, value);
			}
		}

		((DisplacementMap) effects[5]).setMapData(map);
	}

	@Override
	public void start(Stage prim) throws Exception {
		Text text = new Text();
		text.setFont(Font.font("Arial", FontWeight.BLACK, FontPosture.ITALIC, 20.0));
		text.setUnderline(true);
		Rectangle rect = new Rectangle(200, 100);
		Stop[] stops = new Stop[] { new Stop(0, Color.BLACK), new Stop(0.5, Color.BLANCHEDALMOND), new Stop(1, Color.RED) };
		rect.setFill(new LinearGradient(0, 0, rect.getWidth(), rect.getHeight(), false, CycleMethod.NO_CYCLE, stops));

		ImageView image = new ImageView(new Image("file:Anhang\\still.jpg"));
		image.setFitWidth(200);
		image.setPreserveRatio(true);

		Slider slider = new Slider(0, 6, 0);
		slider.valueProperty().addListener(new ChangeListener() {

			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				double tmp = (double) newValue;
				rect.setEffect(effects[(int) tmp]);
				image.setEffect(effects[(int) tmp]);
				text.setText(effects[(int) tmp].getClass().getSimpleName());
			}
		});

		BorderPane root = new BorderPane();
		root.setTop(text);
		VBox box = new VBox(rect, image);
		box.setAlignment(Pos.CENTER);
		box.setSpacing(10);
		box.setPadding(new Insets(10));
		root.setCenter(box);
		root.setBottom(slider);

		Scene scene = new Scene(root);
		prim.setScene(scene);
		prim.show();

		root.getTransforms().addAll(new Rotate(30, scene.getWidth() / 2, scene.getHeight() / 2), 
				new Scale(0.5, 0.5), 
				new Translate(scene.getWidth() / 4, scene.getHeight() / 4));
		WebView web = new WebView();
		web.getEngine().load("http://www.google.de");
		web.setContextMenuEnabled(false);
		root.setRight(web);
	}

	public static void main(String[] args) {
		launch(args);
	}

}
