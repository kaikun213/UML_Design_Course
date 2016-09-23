package view;

import java.util.ArrayList;

import model.Boat;
import model.Member;
import model.MemberList;

public class Console implements IView {

	@Override
	public void showWelcomeMessage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int showInstructions() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectListType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void ListMembers(MemberList md_list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String selectMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showSelectedMember(Member md) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean showDeleteConfirmation(Member md) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Member CreateMemberForm() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member EditMemberForm(Member md) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showBoats(ArrayList<Boat> boats) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boat addBoatToMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean wantsToManage() {
		// TODO Auto-generated method stub
		return false;
	}

}
