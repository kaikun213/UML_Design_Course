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
		md_list = new MemberList();
	}
	
	public void manage(){
		
		a_view.showWelcomeMessage();
		
		while (a_view.wantsToManage()){
			
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
		}
	}	
	
	
	
	private void deleteMember(){
		String selectedMember = a_view.selectMember();
		Member md = md_list.getMember(selectedMember);
		a_view.showSelectedMember(md.getId(),md.getName(),md.getPersonal_number(), md.getBoats());
		a_view.showDeleteMemberConfirmation(selectedMember);
	}
	
	private void editMember(){
		String selectedMember = a_view.selectMember();
		Member md = md_list.getMember(selectedMember);
		a_view.showSelectedMember(md.getId(),md.getName(),md.getPersonal_number(), md.getBoats());
		md_list.editMember(a_view.EditMemberForm(md_list.getMember(selectedMember)));
	}
	
	private void showList(){
		i = a_view.selectListType();
		if (i == 1) a_view.showCompactList(md_list.getIterator());
		else if (i == 2) a_view.showVerboseList(md_list.getIterator());

	}

}
