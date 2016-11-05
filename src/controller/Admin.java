package controller;

import model.MemberRegistry;
import model.Authentification;
import model.Boat.Boatstype;
import model.search.*;
import view.IView;

public class Admin {
	
	private IView a_view;
	private MemberRegistry md_list;
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
					a_view.showSuccessfulCreatedMessage();
				}
			}
			else if (i == 2) {		// delete member
				if (auth.isLogged() || login()){
					showList(md_list);
					if (md_list.getMemberList().iterator().hasNext()){
						int m_id = selectMember(md_list);
						showMember(m_id);
						deleteMember(m_id);
					}
				}
			}
			else if (i == 3) {		// edit member/boats
				if (auth.isLogged() || login()){
					showList(md_list);
					if (md_list.getMemberList().iterator().hasNext()){
						int m_id = selectMember(md_list);
						showMember(m_id);
						editMember(m_id);
					}
				}
			}
			else if (i == 4){		// list members
				showList(md_list);
				if (md_list.getMemberList().iterator().hasNext()){
					int m_id = selectMember(md_list);
					showMember(m_id);
				}				
			}
			else if (i == 5){		// search members
				MemberRegistry search_result = searchMembers();
				showList(search_result);
				if (search_result.getMemberList().iterator().hasNext()){
					int m_id = selectMember(md_list);
					showMember(m_id);
				}
			}
		} while (a_view.wantsToManage());
									
		dao.MembersDAO.jaxbObjectToXML(md_list);	// save data in XML
		a_view.closeScanner(); 						// close scanner for good practice
	}	
	
	private boolean login(){
		a_view.showAuthentification();
		String username = a_view.authentificateUsername();
		String password = a_view.authentificatePassword();
		if (auth.authentificate(username, password)) a_view.showSuccessfulLogin();
		else a_view.showInvalidLogin();
		return auth.isLogged();
	}
	
	private void deleteMember(int member_id){
		if (a_view.deleteMemberConfirmation(member_id)) {
			if (md_list.deleteMember(member_id)) a_view.showSuccessfulDeletedMessage();
			else a_view.showErrorInvalidChoice();

		}
	}
	
	private void editMember(int member_id){
		do{
			i = a_view.selectMemberEdit();
			if (i==1) md_list.editMember(a_view.editMemberName(md_list.getMember(member_id)));
			else if (i==2) md_list.editMember(a_view.editMemberPersonalNumber(md_list.getMember(member_id)));
			else if (i==3) editMembersBoats(member_id);
		} while (i != 4);
	}
	
	private void showList(MemberRegistry list){
		i = a_view.selectListType();
		if (i == 1) a_view.showCompactList(list.getMemberList());
		else if (i == 2) a_view.showVerboseList(list.getMemberList());

	}
	
	private int selectMember(MemberRegistry list){
		int a_member;
		do {
		a_member = a_view.selectMember();
		} while (!list.containsMember(a_member));
		return a_member;
	}
	
	private void showMember(int member_id){
		a_view.showMember(md_list.getMember(member_id).getId(),md_list.getMember(member_id).getName(),md_list.getMember(member_id).getPersonal_number(), md_list.getMember(member_id).getBoats());
	}
	
	private void editMembersBoats(int editMember_id){
		do{
			i = a_view.selectBoatsEdit();
			if (i == 1) {																// create boat
					md_list.getMember(editMember_id).addBoat(a_view.createBoat());						
					a_view.showSuccessfulCreatedMessage();	 	
			}
			if (i == 2 ){																// delete boat
				if (!md_list.getMember(editMember_id).getBoats().iterator().hasNext()) a_view.showErrorInvalidChoice();
				else {
					a_view.showBoats(md_list.getMember(editMember_id).getBoats());
					int b_id = selectBoat(editMember_id);
					if (a_view.deleteBoatConfirmation(b_id)) {
						if (md_list.getMember(editMember_id).deleteBoat(b_id)) a_view.showSuccessfulDeletedMessage();
						else a_view.showErrorInvalidChoice();
					}
				}
			}
			if (i == 3){																// edit boat
				if (!md_list.getMember(editMember_id).getBoats().iterator().hasNext()) a_view.showErrorInvalidChoice();
				else {
					a_view.showBoats(md_list.getMember(editMember_id).getBoats());
					int b_id = selectBoat(editMember_id);
					md_list.getMember(editMember_id).editBoat(a_view.editBoat(md_list.getMember(editMember_id).getBoat(b_id)));
					a_view.showSuccessfulEditedMessage();	 	
				}
			}
		} while(i!=4);
	}
	
	private int selectBoat(int editMember_id){
		int a_boat;
		do {
			a_boat = a_view.selectBoat();
		} while (!md_list.getMember(editMember_id).existBoat(a_boat));
		return a_boat;
	}
	
	private MemberRegistry searchMembers(){
		i = a_view.selectSearch();
		MemberRegistry search_list = new MemberRegistry();
		
				switch (i){
				case 1: {		//by name
					SearchCriteria byName = new ByNamePrefixCriteria(a_view.getSearchParam(ValidationType.String));
					search_list = byName.meetCriteria(md_list);
				}
					break;
				case 2: {		//by age
					SearchCriteria byAge = new ByMinimumAgeCriteria(Integer.parseInt(a_view.getSearchParam(ValidationType.Integer)));
					search_list = byAge.meetCriteria(md_list);
				}
					break;
				case 3:	{		//by birth month
					SearchCriteria byBirthMonth = new ByBirthMonthCriteria(a_view.selectMonth());
					search_list = byBirthMonth.meetCriteria(md_list);
					break;
				}
				case 4: {		//by boatstype
					SearchCriteria byBoatsType = new ByBoatsTypeCriteria(Boatstype.values()[a_view.selectBoatsType()]);
					search_list = byBoatsType.meetCriteria(md_list);
					break;
				}
				case 5: {     	// NestedSearch: (month||(name & minimumAge)
					SearchCriteria byBirthMonth = new ByBirthMonthCriteria(a_view.selectMonth());
					SearchCriteria byName = new ByNamePrefixCriteria(a_view.getSearchParam(ValidationType.String));
					SearchCriteria byAge = new ByMinimumAgeCriteria(Integer.parseInt(a_view.getSearchParam(ValidationType.Integer)));
					SearchCriteria byNameAndAge = new AndCriteria(byName,byAge);
					SearchCriteria byBirthMonthOrNestedNameAndAge = new OrCriteria(byBirthMonth, byNameAndAge);
					search_list = byBirthMonthOrNestedNameAndAge.meetCriteria(md_list);
				}
				}	
				
		return search_list;
	}	
	
}
