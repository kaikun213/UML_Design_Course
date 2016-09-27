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
		md.setId(memberList.size());	// unique ID = incremental counter
		memberList.add(md);
	}
	
	public void deleteMember(int member_id){
		if (!memberList.remove(getMember(member_id))) System.err.println("Member not found!");; 
	}
	
	public void editMember(Member md){			// replace member with same unique id
		memberList.set(getIndexOf(md), md);
	}
	
	public Member getMember(int id){
		for (Member m : memberList) {
			if (m.getId() == id){
				return m;
			}
		}
		return null;							// existMember before
	}
	
	public Iterator<Member> getIterator(){
		return memberList.iterator();
	}
	
	public boolean existMember(int id){
		for (Member m : memberList) {
			if (m.getId() == id){
				return true;
			}
		}
		return false;
	}
	
	
	/* ***************************** private functions ************************* */
	private int getIndexOf(Member md){
		for (int i=0;i<memberList.size();i++) {
			if (memberList.get(i).getId() == md.getId()){
				return i;
			}
		}
		return -99;							// not existing member
	}
	
}
