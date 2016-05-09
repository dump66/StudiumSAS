import javafx.scene.input.KeyCode;
import javafx.scene.media.AudioClip;

public enum Toene {
	C(KeyCode.Y, new AudioClip("file:mp3/c.mp3")),
	D(KeyCode.X, new AudioClip("file:mp3/d.mp3")),
	E(KeyCode.C, new AudioClip("file:mp3/e.mp3")),
	F(KeyCode.V, new AudioClip("file:mp3/f.mp3")),
	G(KeyCode.B, new AudioClip("file:mp3/g.mp3")),
	A(KeyCode.N, new AudioClip("file:mp3/a.mp3")),
	H(KeyCode.M, new AudioClip("file:mp3/h.mp3")),
	C1(KeyCode.W, new AudioClip("file:mp3/c1.mp3")),
	D1(KeyCode.E, new AudioClip("file:mp3/d1.mp3")),
	E1(KeyCode.R, new AudioClip("file:mp3/e1.mp3")),
	F1(KeyCode.T, new AudioClip("file:mp3/f1.mp3")),
	G1(KeyCode.Z, new AudioClip("file:mp3/g1.mp3")),
	A1(KeyCode.U, new AudioClip("file:mp3/a1.mp3")),
	H1(KeyCode.I, new AudioClip("file:mp3/h1.mp3")),
	CIS(KeyCode.S, new AudioClip("file:mp3/cis.mp3")),
	ES(KeyCode.D, new AudioClip("file:mp3/es.mp3")),
	FIS(KeyCode.G, new AudioClip("file:mp3/fis.mp3")),
	GIS(KeyCode.H, new AudioClip("file:mp3/gis.mp3")),
	B(KeyCode.J, new AudioClip("file:mp3/b.mp3")),
	CIS1(KeyCode.DIGIT3, new AudioClip("file:mp3/cis1.mp3")),
	ES1(KeyCode.DIGIT4, new AudioClip("file:mp3/es1.mp3")),
	FIS1(KeyCode.DIGIT6, new AudioClip("file:mp3/fis1.mp3")),
	GIS1(KeyCode.DIGIT7, new AudioClip("file:mp3/gis1.mp3")),
	B1(KeyCode.DIGIT8, new AudioClip("file:mp3/b1.mp3"));
	
	private final KeyCode code;
	private final AudioClip clip;
	
	private Toene(KeyCode code, AudioClip clip){
		this.code = code;
		this.clip = clip;
	}
	
	public AudioClip getClip(){
		return this.clip;
	}
	
	public KeyCode getCode(){
		return this.code;
	}
}
