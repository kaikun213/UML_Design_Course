package controller;

import model.Member;
import model.MemberList;
import view.IView;

public class Admin {
	
	private IView a_view;
	private MemberList md_list;
	private int i;					// users choice saved as int
	
	public Admin(IView v){
		a_view = v;
		md_list = dao.MembersDAO.jaxbXMLToObject();		//  read out of XML
	}
	
	public void manage(){
		
		a_view.showWelcomeMessage();
		
		do {
			
			i = a_view.showInstructions();
			
			if (i == 1) {			// create
				md_list.addMember(a_view.CreateMemberForm());
			}
			else if (i == 2) {		// delete
				showList();
				deleteMember();
			}
			else if (i == 3) {		// edit
				showList();
				editMember();
			}
		} while (a_view.wantsToManage());
									
		dao.MembersDAO.jaxbObjectToXML(md_list);	// save data in XML
	}	
	
	
	
	private void deleteMember(){
		String selectedMember = selectMember();
		Member md = md_list.getMember(selectedMember);
		a_view.showMember(md.getId(),md.getName(),md.getPersonal_number(), md.getBoats());
		a_view.showDeleteMemberConfirmation(selectedMember);
	}
	
	private void editMember(){
		String selectedMember = selectMember();
		Member md = md_list.getMember(selectedMember);
		a_view.showMember(md.getId(),md.getName(),md.getPersonal_number(), md.getBoats());
		md_list.editMember(a_view.EditMemberForm(md_list.getMember(selectedMember)));
	}
	
	private void showList(){
		i = a_view.selectListType();
		if (i == 1) a_view.showCompactList(md_list.getIterator());
		else if (i == 2) a_view.showVerboseList(md_list.getIterator());

	}
	
	private String selectMember(){
		String a_member;
		do {
		a_member = a_view.selectMember();
		} while (!md_list.existMember(a_member));
		return a_member;
	}

}
