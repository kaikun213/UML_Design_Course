package model;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MemberList {
	
	ArrayList<Member> memberList;
	
	public ArrayList<Member> getMemberList() {
		return memberList;
	}
	public void setMemberList(ArrayList<Member> memberList) {
		this.memberList = memberList;
	}



	public MemberList(){
		memberList = new ArrayList<Member>();
	}
	
	
	
	public void addMember(Member md){
		memberList.add(md);
	}

}
