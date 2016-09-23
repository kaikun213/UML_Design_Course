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
	
	public void addMember(Member md){
		memberList.add(md);
	}
	
	public void deleteMember(Member md){
		memberList.remove(md);
	}
	
	public void editMember(Member md){			// cant change unique ID
		memberList.set(getIndexOf(md), md);
	}
	
	public Member getMember(String id){
		for (Member m : memberList) {
			if (m.getId().equals(id)){
				return m;
			}
		}
		return null;							// no error handling (in view)
	}
	
	
	/* not implemented yet */
	public ArrayList<Member> getCompactList(){	// “Compact List”; name, member id and number of boats
		return memberList;
	}
	public ArrayList<Member> getVerboseList(){ // “Verbose List”; name, personal number, member id and boats with boat information
		return memberList;
	}
	
	
	/* ***************************** private functions ************************* */
	private int getIndexOf(Member md){
		for (int i=0;i<memberList.size();i++) {
			if (memberList.get(i).getId().equals(md.getId())){
				return i;
			}
		}
		return -99;							// not existing member
	}
	
}
