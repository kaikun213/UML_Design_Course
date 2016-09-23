package view;

import java.util.ArrayList;

import model.Boat;
import model.Member;
import model.MemberList;

public interface IView {
	
	void showWelcomeMessage();
	int showInstructions();					// 1)create, 2)delete or 3) edit
	int selectListType();					// 1) compact , 2) verbose
	void ListMembers(MemberList md_list);
	String selectMember();					// returns unique member-ID as String
	void showSelectedMember(Member md);
	
	boolean showDeleteConfirmation(Member md);	// true = deletion 
	Member CreateMemberForm();
	Member EditMemberForm(Member md);
	
	void showBoats(ArrayList<Boat> boats);
	Boat addBoatToMember();
	
	boolean wantsToManage();

}
