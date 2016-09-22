package view;

import java.util.ArrayList;

import model.Boat;
import model.Member;
import model.MemberList;

public interface IView {
	
	void showWelcomeMessage();
	int showInstructions();					// 1)compact, 2)verbose list or 3) create new Member
	void ListMembers(MemberList md_list);
	Member CreateMemberForm();
	void showSelectedMember(Member md);
	void showDeleteConfirmation(Member md);
	void showBoats(ArrayList<Boat> boats);
	Boat addBoatToMember();
	Member EditMemberForm(Member md);
	
	

}
