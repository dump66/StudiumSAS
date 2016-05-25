import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Key extends HBox {

	KeyCode code;
	SimpleBooleanProperty keyProperty;

	public Key(KeyCode code) {
		super();
		this.code = code;
		this.keyProperty = new SimpleBooleanProperty(false);
		createBox();
	}

	public KeyCode getCode() {
		return this.code;
	}

	public SimpleBooleanProperty getKeyProperty() {
		return this.keyProperty;
	}

	private void createBox() {
		this.setPrefSize(50, 50);
		this.setMinSize(50, 50);
		this.setMaxSize(50, 50);
		this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderStroke.MEDIUM)));
		this.getChildren().add(new Text(this.code.getName()));
		this.setAlignment(Pos.CENTER);
	}
}
