package model.search;

import model.Member;
import model.MemberRegistry;

public class ByBirthMonthCriteria implements SearchCriteria{
	
	private int month;
	
	public ByBirthMonthCriteria(int month){
		this.month=month;
	}

	@Override
	public MemberRegistry meetCriteria(MemberRegistry members) {
		MemberRegistry filter_result = new MemberRegistry(); 
	      
	      for (Member m : members.getMemberList()) {
	    	  if (Integer.parseInt(m.getPersonal_number().substring(2, 4)) == month){
	            filter_result.addMember(m);
	         }
	      }
	      return filter_result;
	}

}
