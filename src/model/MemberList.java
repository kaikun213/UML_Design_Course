package model;

import java.util.ArrayList;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MemberList {
	
	@XmlElement(name="member")
	ArrayList<Member> memberList;

	public MemberList(){
		memberList = new ArrayList<Member>();
	}
	
	public ArrayList<Member> getMemberList() {
		return memberList;
	}
	public void setMemberList(ArrayList<Member> memberList) {
		this.memberList = memberList;
	}
	
	/* not implemented yet */
	
	public void addMember(Member md){
		memberList.add(md);
	}
	
	public void deleteMember(Member md){
		
	}
	
	public void editMember(Member md){
		
	}
	
	public Member getMember(String id){
		return null;
	}
	
	public ArrayList<Member> getCompactList(){	// “Compact List”; name, member id and number of boats
		return memberList;
	}
	public ArrayList<Member> getVerboseList(){ // “Verbose List”; name, personal number, member id and boats with boat information
		return memberList;
	}
	
}
