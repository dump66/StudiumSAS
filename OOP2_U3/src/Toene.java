import javafx.scene.media.AudioClip;

public enum Toene {
	C("C", new AudioClip("file:mp3/c.mp3")),
	D("D", new AudioClip("file:mp3/d.mp3")),
	E("E", new AudioClip("file:mp3/e.mp3")),
	F("F", new AudioClip("file:mp3/f.mp3")),
	G("G", new AudioClip("file:mp3/g.mp3")),
	A("A", new AudioClip("file:mp3/a.mp3")),
	H("H", new AudioClip("file:mp3/h.mp3")),
	C1("C1", new AudioClip("file:mp3/c1.mp3")),
	D1("D1", new AudioClip("file:mp3/d1.mp3")),
	E1("E1", new AudioClip("file:mp3/e1.mp3")),
	F1("F1", new AudioClip("file:mp3/f1.mp3")),
	G1("G1", new AudioClip("file:mp3/g1.mp3")),
	A1("A1", new AudioClip("file:mp3/a1.mp3")),
	H1("H1", new AudioClip("file:mp3/h1.mp3")),
	CIS("CIS", new AudioClip("file:mp3/cis.mp3")),
	ES("ES", new AudioClip("file:mp3/es.mp3")),
	FIS("FIS", new AudioClip("file:mp3/fis.mp3")),
	GIS("GIS", new AudioClip("file:mp3/gis.mp3")),
	B("B", new AudioClip("file:mp3/b.mp3")),
	CIS1("CIS1", new AudioClip("file:mp3/cis1.mp3")),
	ES1("ES1", new AudioClip("file:mp3/es1.mp3")),
	FIS1("FIS1", new AudioClip("file:mp3/fis1.mp3")),
	GIS1("GIS1", new AudioClip("file:mp3/gis1.mp3")),
	B1("B1", new AudioClip("file:mp3/b1.mp3"));
	
	private final String sign;
	private final AudioClip clip;
	
	private Toene(String sign, AudioClip clip){
		this.sign = sign;
		this.clip = clip;
	}
	
	public AudioClip getClip(){
		return this.clip;
	}
	
	public String getCode(){
		return this.sign;
	}
}
