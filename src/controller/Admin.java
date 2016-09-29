package controller;

import model.Member;
import model.MemberList;
import view.IView;

public class Admin {
	
	private IView a_view;
	private MemberList md_list;
	private int i;					// users choice saved as int
	
	public Admin(IView a_view){
		this.a_view = a_view;
		md_list = dao.MembersDAO.jaxbXMLToObject();		//  read out of XML
	}
	
	public void showWelcomeMessage(){
		a_view.showWelcomeMessage();
	}
	public void manage(){
		a_view.showWelcomeMessage();
		do {
			i = a_view.selectInstruction();
			if (i == 1) {			// create member
				md_list.addMember(a_view.createMember());
			}
			else if (i == 2) {		// delete member
				showList();
				int m_id = selectMember();
				showMember(m_id);
				deleteMember(m_id);
			}
			else if (i == 3) {		// edit member/boats
				showList();
				int m_id = selectMember();
				showMember(m_id);
				editMember(m_id);
			}
			else if (i == 4){		// list members
				showList();
				int m_id = selectMember();
				showMember(m_id);
			}
		} while (a_view.wantsToManage());
									
		dao.MembersDAO.jaxbObjectToXML(md_list);	// save data in XML
	}	
	
	
	
	private void deleteMember(int member_id){
		if (a_view.deleteMemberConfirmation(member_id)) md_list.deleteMember(member_id);
	}
	
	private void editMember(int member_id){
		Member editMember = md_list.getMember(member_id);
		do{
			i = a_view.selectMemberEdit();
			if (i==1) editMember.setName(a_view.editMemberName());
			else if (i==2) editMember.setPersonal_number(a_view.editMemberPersonalNumber());
			else if (i==3) editMembersBoats(editMember);
		} while (i != 4);
		md_list.editMember(editMember);
	}
	
	private void showList(){
		i = a_view.selectListType();
		if (i == 1) a_view.showCompactList(md_list.getIterator());
		else if (i == 2) a_view.showVerboseList(md_list.getIterator());

	}
	
	private int selectMember(){
		int a_member;
		do {
		a_member = a_view.selectMember();
		} while (!md_list.existMember(a_member));
		return a_member;
	}
	
	private void showMember(int member_id){
		Member md = md_list.getMember(member_id);
		a_view.showMember(md.getId(),md.getName(),md.getPersonal_number(), md.getBoats());
	}
	
	private void editMembersBoats(Member editMember){
		do{
			i = a_view.selectBoatsEdit();
			if (i == 1) editMember.addBoat(a_view.createBoat());						// create boat
			if (i == 2 ){																// delete boat
				if (!editMember.getBoats().hasNext()) a_view.showEmptyBoatsListWarning();
				else {
					a_view.showBoats(editMember.getBoats());
					int b_id = selectBoat(editMember);
					if (a_view.deleteBoatConfirmation(b_id)) editMember.deleteBoat(b_id);
				}
			}
			if (i == 3){																// edit boat
				if (!editMember.getBoats().hasNext()) a_view.showEmptyBoatsListWarning();
				else {
					a_view.showBoats(editMember.getBoats());
					int b_id = selectBoat(editMember);
					editMember.editBoat(a_view.editBoat(editMember.getBoat(b_id)));
				}
			}
		} while(i!=4);
	}
	
	private int selectBoat(Member editMember){
		int a_boat;
		do {
			a_boat = a_view.selectBoat();
		} while (!editMember.existBoat(a_boat));
		return a_boat;
	}
	
}
