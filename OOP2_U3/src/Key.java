import javafx.geometry.Pos;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Key extends HBox {

	KeyCode code;
	
	public Key(KeyCode code){
		super();
		this.code = code;
		createBox();
	}
	public KeyCode getCode(){
		return this.code;
	}

	private void createBox(){
		this.setPrefSize(50, 50);
		this.setMinSize(50, 50);
		this.setMaxSize(50, 50);
		this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderStroke.MEDIUM)));
		this.getChildren().add(new Text(this.code.getName()));
		this.setAlignment(Pos.CENTER);
	}
}
