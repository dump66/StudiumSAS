import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class KeyNeu extends Rectangle {

	KeyCode code;
	Label letter;
	SimpleBooleanProperty keyProperty;

	public KeyNeu(KeyCode code) {
		super(50, 50, Color.WHITE);
		this.code = code;
		this.keyProperty = new SimpleBooleanProperty(false);
		this.letter = new Label(code.toString());
		createBox();
	}

	public KeyCode getCode(){
		return this.code;
	}
	
	public Label getLetter(){
		return this.letter;
	}
	public SimpleBooleanProperty getKeyProperty() {
		return this.keyProperty;
	}

	private void createBox() {
		this.setArcHeight(20);
		this.setArcWidth(20);
		this.setStroke(Color.BLACK);
		this.setFocusTraversable(true);
		this.letter.setFont(Font.font(20));
	}
}
