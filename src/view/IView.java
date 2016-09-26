package view;

import java.util.Iterator;

import model.Boat;
import model.Member;

public interface IView {
	
	void showWelcomeMessage();
	int showInstructions();						// 1)create, 2)delete or 3) edit
	int selectListType();						// 1) compact , 2) verbose
	void showCompactList(Iterator<Member> m_it); // “Compact List”; name, member id and number of boats
	void showVerboseList(Iterator<Member> m_it); // “Verbose List”; name, personal number, member id and boats with boat information
	String selectMember();						// returns unique member-ID as String
	void showMember(String id, String name, String personal_number, Iterator<Boat> boats);
	
	boolean showDeleteMemberConfirmation(String id);	// true = deletion , id = unique id of selected member
	Member CreateMemberForm();					// gets unique ID from system
	Member EditMemberForm(Member md);			// just name, personal-id, boats
	
	boolean showDeleteBoatConfirmation(String id);	// true = deletion , id = member-id (owner of boat) identifier boat?
	Boat addBoatToMember();
	
	boolean wantsToManage();

}
