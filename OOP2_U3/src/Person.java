import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Person implements Serializable {

	public SimpleStringProperty fName;
	public SimpleStringProperty sName;
	public SimpleDoubleProperty age;
	public SimpleStringProperty gender;
	public SimpleStringProperty street;
	public SimpleStringProperty city;
	public SimpleStringProperty zip;

	public Person() {
		this.fName = new SimpleStringProperty();
		this.sName = new SimpleStringProperty();
		this.age = new SimpleDoubleProperty();
		this.gender = new SimpleStringProperty();
		this.street = new SimpleStringProperty();
		this.city = new SimpleStringProperty();
		this.zip = new SimpleStringProperty();
	}

	public static Person loadData(File f) throws FileNotFoundException, IOException, ClassNotFoundException {
		Person p = new Person();
		if (f != null) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			p.fName.set((String) ois.readObject());
			p.sName.set((String) ois.readObject());
			p.age.set((Double) ois.readObject());
			p.gender.set((String) ois.readObject());
			p.street.set((String) ois.readObject());
			p.city.set((String) ois.readObject());
			p.zip.set((String) ois.readObject());
			ois.close();
		}
		return p;
	}

	public void writeData(File f) throws IOException {
		if (f != null) {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(fName.get());
			oos.writeObject(sName.get());
			oos.writeObject(age.get());
			oos.writeObject(gender.get());
			oos.writeObject(street.get());
			oos.writeObject(city.get());
			oos.writeObject(zip.get());
			oos.flush();
			oos.close();
		}
	}
}
