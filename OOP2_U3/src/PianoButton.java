import javafx.scene.shape.Rectangle;

public class PianoButton extends Rectangle {
	private final Toene ton;

	public PianoButton(double x, double y, double w, double h, Toene ton) {
		super(x, y, w, h);
		this.ton = ton;
	}

	public Toene getTon() {
		return this.ton;
	}

}
