package model.search;

import java.util.ArrayList;
import java.util.List;
import model.Member;

public class ByBirthMonthCriteria implements SearchCriteria{
	
	private int month;
	
	public ByBirthMonthCriteria(int month){
		this.month=month;
	}

	@Override
	public List<Member> meetCriteria(List<Member> members) {
		List<Member> filter_result = new ArrayList<Member>(); 
	      
	      for (Member m : members) {
	    	  if (Integer.parseInt(m.getPersonal_number().substring(2, 4)) == month){
	            filter_result.add(m);
	         }
	      }
	      return filter_result;
	}

}
