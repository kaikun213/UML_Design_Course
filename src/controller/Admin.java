package controller;

import model.MemberList;
import view.IView;

public class Admin {
	
	private IView a_view;
	private MemberList md_list;
	
	public Admin(IView v){
		a_view = v;
		md_list = new MemberList();
	}
	
	public void manage(){
		a_view.showWelcomeMessage();
		if (a_view.showInstructions() == 1) {			// compact list
			md_list.getCompactList();
			a_view.ListMembers(md_list);
		}
		else if (a_view.showInstructions() == 2) {		// verbose list
			md_list.getVerboseList();
			a_view.ListMembers(md_list);
		}
		else if (a_view.showInstructions() == 3) {		// create new member
			md_list.addMember(a_view.CreateMemberForm());
		}
	
		
	}

}
