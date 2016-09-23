package view;

import java.util.ArrayList;

import model.Boat;
import model.Member;
import model.MemberList;

public interface IView {
	
	void showWelcomeMessage();
	int showInstructions();					// 1)create, 2)delete or 3) edit
	int selectListType();
	void ListMembers(MemberList md_list);
	String selectMember();
	void showSelectedMember(Member md);
	
	void showDeleteConfirmation(Member md);
	Member CreateMemberForm();
	Member EditMemberForm(Member md);
	
	void showBoats(ArrayList<Boat> boats);
	Boat addBoatToMember();
	
	boolean wantsToManage();

}
