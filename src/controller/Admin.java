package controller;

import model.Member;
import model.MemberList;
import model.Authentification;
import model.Boat.Boatstype;
import model.search.*;
import view.IView;

public class Admin {
	
	private IView a_view;
	private MemberList md_list;
	private Authentification auth = new Authentification();
	private int i;					// users choice saved as int
	
	public enum ValidationType {
		SwedishID,
		PositiveDouble,
		Character,
		Integer,
		String
}
	
	public Admin(IView a_view){
		this.a_view = a_view;
		md_list = dao.MembersDAO.jaxbXMLToObject();		//  read out of XML
	}

	public void manage(){
		a_view.showWelcomeMessage();
		do {
			i = a_view.selectInstruction();
			if (i == 1) {			// create member
				if (auth.isLogged() || login()){
					md_list.addMember(a_view.createMember());
					a_view.showSuccessMessage("SUCCESSFUL CREATED A NEW MEMBER");
				}
			}
			else if (i == 2) {		// delete member
				if (auth.isLogged() || login()){
					showList(md_list);
					if (!md_list.getMemberList().isEmpty()){
						int m_id = selectMember(md_list);
						showMember(m_id);
						deleteMember(m_id);
					}
				}
			}
			else if (i == 3) {		// edit member/boats
				if (auth.isLogged() || login()){
					showList(md_list);
					if (!md_list.getMemberList().isEmpty()){
						int m_id = selectMember(md_list);
						showMember(m_id);
						editMember(m_id);
					}
				}
			}
			else if (i == 4){		// list members
				showList(md_list);
				if (!md_list.getMemberList().isEmpty()){
					int m_id = selectMember(md_list);
					showMember(m_id);
				}				
			}
			else if (i == 5){		// search members
				MemberList search_result = searchMembers();
				showList(search_result);
				if (!search_result.getMemberList().isEmpty()){
					int m_id = selectMember(md_list);
					showMember(m_id);
				}
			}
		} while (a_view.wantsToManage());
									
		dao.MembersDAO.jaxbObjectToXML(md_list);	// save data in XML
	}	
	
	private boolean login(){
		a_view.showAuthentification();
		String username = a_view.authentificateUsername();
		String password = a_view.authentificatePassword();
		if (auth.authentificate(username, password)) {
			auth.setLogged(true);
			a_view.showSuccessMessage("SUCCESSFUL LOGGED IN");
		}
		else a_view.showErrorMessage("Wrong username or password");
		return auth.isLogged();
	}
	
	private void deleteMember(int member_id){
		if (a_view.deleteMemberConfirmation(member_id)) {
			md_list.deleteMember(member_id);
			a_view.showSuccessMessage("SUCCESSFUL DELETED MEMBER ");
		}
	}
	
	private void editMember(int member_id){
		Member editMember = md_list.getMember(member_id);
		do{
			i = a_view.selectMemberEdit();
			if (i==1) editMember.setName(a_view.editMemberName());
			else if (i==2) editMember.setPersonal_number(a_view.editMemberPersonalNumber());
			else if (i==3) editMembersBoats(editMember);
		} while (i != 4);
		md_list.editMember(editMember);
	}
	
	private void showList(MemberList list){
		i = a_view.selectListType();
		if (i == 1) a_view.showCompactList(list.getIterator());
		else if (i == 2) a_view.showVerboseList(list.getIterator());

	}
	
	private int selectMember(MemberList list){
		int a_member;
		do {
		a_member = a_view.selectMember();
		} while (!list.existMember(a_member));
		return a_member;
	}
	
	private void showMember(int member_id){
		Member md = md_list.getMember(member_id);
		a_view.showMember(md.getId(),md.getName(),md.getPersonal_number(), md.getBoats());
	}
	
	private void editMembersBoats(Member editMember){
		do{
			i = a_view.selectBoatsEdit();
			if (i == 1) {																// create boat
					editMember.addBoat(a_view.createBoat());						
					a_view.showSuccessMessage("***** SUCCESSFUL CREATED NEW BOAT *****");		 	
			}
			if (i == 2 ){																// delete boat
				if (!editMember.getBoats().hasNext()) a_view.showErrorMessage("WARNING: Unfortunatelly this member has no registered boats to edit/delete!");
				else {
					a_view.showBoats(editMember.getBoats());
					int b_id = selectBoat(editMember);
					if (a_view.deleteBoatConfirmation(b_id)) {
						editMember.deleteBoat(b_id);
						a_view.showSuccessMessage("SUCCESSFUL DELETED BOAT " + b_id);
					}
				}
			}
			if (i == 3){																// edit boat
				if (!editMember.getBoats().hasNext()) a_view.showErrorMessage("WARNING: Unfortunatelly this member has no registered boats to edit/delete!");
				else {
					a_view.showBoats(editMember.getBoats());
					int b_id = selectBoat(editMember);
					editMember.editBoat(a_view.editBoat(editMember.getBoat(b_id)));
					a_view.showSuccessMessage("***** SUCCESSFUL EDITED BOAT " + b_id + " *****");		 	
				}
			}
		} while(i!=4);
	}
	
	private int selectBoat(Member editMember){
		int a_boat;
		do {
			a_boat = a_view.selectBoat();
		} while (!editMember.existBoat(a_boat));
		return a_boat;
	}
	
	private MemberList searchMembers(){
		i = a_view.selectSearch();
		MemberList search_list = new MemberList();
		
				switch (i){
				case 1: {		//by name
					SearchCriteria byName = new ByNamePrefixCriteria(a_view.getSearchParam(ValidationType.String));
					search_list.setMemberList(byName.meetCriteria(md_list.getMemberList()));
				}
					break;
				case 2: {		//by age
					SearchCriteria byAge = new ByMinimumAgeCriteria(Integer.parseInt(a_view.getSearchParam(ValidationType.Integer)));
					search_list.setMemberList(byAge.meetCriteria(md_list.getMemberList()));
				}
					break;
				case 3:	{		//by birth month
					SearchCriteria byBirthMonth = new ByBirthMonthCriteria(a_view.selectMonth());
					search_list.setMemberList(byBirthMonth.meetCriteria(md_list.getMemberList()));
					break;
				}
				case 4: {		//by boatstype
					SearchCriteria byBoatsType = new ByBoatsTypeCriteria(Boatstype.values()[a_view.selectBoatsType()]);
					search_list.setMemberList(byBoatsType.meetCriteria(md_list.getMemberList()));
					break;
				}
				case 5: {     	// NestedSearch: (month||(name & minimumAge)
					SearchCriteria byBirthMonth = new ByBirthMonthCriteria(a_view.selectMonth());
					SearchCriteria byName = new ByNamePrefixCriteria(a_view.getSearchParam(ValidationType.String));
					SearchCriteria byAge = new ByMinimumAgeCriteria(Integer.parseInt(a_view.getSearchParam(ValidationType.Integer)));
					SearchCriteria byNameAndAge = new AndCriteria(byName,byAge);
					SearchCriteria byBirthMonthOrNestedNameAndAge = new OrCriteria(byBirthMonth, byNameAndAge);
					search_list.setMemberList(byBirthMonthOrNestedNameAndAge.meetCriteria(md_list.getMemberList()));
				}
				}	
				
		return search_list;
	}	
	
}
