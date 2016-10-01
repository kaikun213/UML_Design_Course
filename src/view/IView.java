package view;

import java.util.Iterator;

import controller.Admin.ValidationType;
import model.Boat;
import model.Member;

public interface IView {
	// show, select, edit, delete, create
	
	void showWelcomeMessage();
	int selectInstruction();						// 1)create, 2)delete or 3) edit member/boats 4) list members 5) search
	int selectListType();						// 1) compact , 2) verbose
	void showCompactList(Iterator<Member> m_it); // “Compact List”; name, member id and number of boats
	void showVerboseList(Iterator<Member> m_it); // “Verbose List”; name, personal number, member id and boats with boat information
	
	int selectMember();							// returns unique member-ID as String
	void showMember(int id, String name, String personal_number, Iterator<Boat> b_it);
	Member createMember();						// gets unique ID from system
	boolean deleteMemberConfirmation(int id);	// true = deletion , id = unique id of selected member
	int selectMemberEdit();						// 1) edit name, 2) edit personal-number, 3) edit boats or 4) to quit editing
	String editMemberName();
	String editMemberPersonalNumber();

	int selectBoatsEdit();						// 1) add boat  2) delete a boat 3) edit a boat 4) quit editing 
	void showEmptyBoatsListWarning();				// show warning if member has no boats to edit/delete
	void showBoats(Iterator<Boat> b_it);		// show a list of all boats of the member
	int selectBoat();							// returns unique boat-id
	Boat createBoat();
	Boat editBoat(Boat b);							// edit boats type and length, not ID!
	boolean deleteBoatConfirmation(int id);		// true = deletion , id = member-id (owner of boat)
	
	int selectSearch();							// 1) name 2) age 3) birth-month 4) boat-type
	String getSearchParam(ValidationType t);
	int selectMonth();							// selection from constant enum Calendar.Month
	int selectBoatsType();						// selection from constant enum Boat.BoatType
	
	void showSuccessMessage(String s);
	void showErrorMessage(String s);
	
	boolean wantsToManage();

}
