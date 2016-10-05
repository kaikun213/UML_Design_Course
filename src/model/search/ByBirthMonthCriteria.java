package model.search;

import model.Member;
import model.MemberList;

public class ByBirthMonthCriteria implements SearchCriteria{
	
	private int month;
	
	public ByBirthMonthCriteria(int month){
		this.month=month;
	}

	@Override
	public MemberList meetCriteria(MemberList members) {
		MemberList filter_result = new MemberList(); 
	      
	      for (Member m : members.getMemberList()) {
	    	  if (Integer.parseInt(m.getPersonal_number().substring(2, 4)) == month){
	            filter_result.addMember(m);
	         }
	      }
	      return filter_result;
	}

}
