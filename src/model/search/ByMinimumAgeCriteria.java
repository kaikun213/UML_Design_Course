package model.search;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import model.MemberList;

import model.Member;

public class ByMinimumAgeCriteria implements SearchCriteria{
	
	private int age;
	
	public ByMinimumAgeCriteria(int age){
		this.age = age;
	}

	@Override
   public MemberList meetCriteria(MemberList members) {
      MemberList filter_result = new MemberList(); 
      LocalDate today = LocalDate.now();
      
      for (Member m : members.getMemberList()) {
			LocalDate memberDate = LocalDate.of(Integer.parseInt(19+ m.getPersonal_number().substring(0, 2)),	// milleniumsproblem
												 Integer.parseInt(m.getPersonal_number().substring(2, 4)),
												 Integer.parseInt(m.getPersonal_number().substring(4, 6)) );
			if (ChronoUnit.YEARS.between(memberDate, today) >= age){
				System.err.println(memberDate + " : " + today);
				System.err.println(ChronoUnit.YEARS.between(memberDate, today));
	            filter_result.addMember(m);
	         }
      }
      return filter_result;
   }


}
