package view;

import java.util.Iterator;

import model.Boat;
import model.Member;

public interface IView {
	
	void showWelcomeMessage();
	int showInstructions();					// 1)create, 2)delete or 3) edit
	int selectListType();					// 1) compact , 2) verbose
	void ListMembers(Iterator<Member> m_it);
	String selectMember();					// returns unique member-ID as String
	void showSelectedMember(Member md);
	
	boolean showDeleteConfirmation(Member md);	// true = deletion 
	Member CreateMemberForm();
	Member EditMemberForm(Member md);
	
	void showBoats(Iterator<Boat> b_it);
	Boat addBoatToMember();
	
	boolean wantsToManage();

}
