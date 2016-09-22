package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.FIELD)
public class Boat {
	
	public enum Boatstype{
		Sailboat,
		Motorboat,
		Kayak,
		Other
	}
	
	private Boatstype type;
	private float length;
	
	public Boatstype getType() {
		return type;
	}
	public void setType(Boatstype type) {
		this.type = type;
	}
	public float getLength() {
		return length;
	}
	public void setLength(float length) {
		this.length = length;
	}

}
