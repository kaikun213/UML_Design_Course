package controller;

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
		a_view.showSelectedMember(md_list.getMember(selectedMember));
		a_view.showDeleteConfirmation(md_list.getMember(selectedMember));
	}
	
	private void editMember(){
		String selectedMember = a_view.selectMember();
		a_view.showSelectedMember(md_list.getMember(selectedMember));
		md_list.editMember(a_view.EditMemberForm(md_list.getMember(selectedMember)));
	}
	
	private void showList(){
		i = a_view.selectListType();
		if (i == 1) md_list.getCompactList();
		else if (i == 2) md_list.getVerboseList();
		a_view.ListMembers(md_list.getIterator());
	}

}
