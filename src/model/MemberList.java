package model;

import java.util.ArrayList;
import java.util.Iterator;

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
		md.setId(Integer.toString(memberList.size()));	// unique ID = incremental counter
		memberList.add(md);
	}
	
	public void deleteMember(Member md){
		if (!memberList.remove(md)) System.err.println("Member not found!");; 
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
		return null;							// existMember before
	}
	
	public Iterator<Member> getIterator(){
		return memberList.iterator();
	}
	
	public boolean existMember(String id){
		for (Member m : memberList) {
			if (m.getId().equals(id)){
				return true;
			}
		}
		return false;
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
