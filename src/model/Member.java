package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Member {
	
	private String id;
	private String name;
	private String personal_number;
	
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
	

}
