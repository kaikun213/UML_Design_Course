package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class Member {
	
	private String id;
	private String name;
	private String personal_number;
	@XmlElement(name="boat")
	private ArrayList<Boat> boats;
	
	public Member(){
		boats = new ArrayList<Boat>();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPersonal_number() {
		return personal_number;
	}
	public void setPersonal_number(String personal_number) {
		this.personal_number = personal_number;
	}
	public ArrayList<Boat> getBoats() {
		return boats;
	}
	public void setBoats(ArrayList<Boat> boats) {
		this.boats = boats;
	}
	

}
