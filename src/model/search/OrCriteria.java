package model.search;


import model.MemberList;
import model.Member;

public class OrCriteria implements SearchCriteria{
	
	 private SearchCriteria criteria;
	   private SearchCriteria otherCriteria;

	   public OrCriteria(SearchCriteria criteria, SearchCriteria otherCriteria) {
	      this.criteria = criteria;
	      this.otherCriteria = otherCriteria; 
	   }

	   @Override
	   public MemberList meetCriteria(MemberList members) {
		  MemberList firstCriteriaItems = criteria.meetCriteria(members);
		      MemberList otherCriteriaItems = otherCriteria.meetCriteria(members);

		      for (Member m : otherCriteriaItems.getMemberList()) {
		         if(!firstCriteriaItems.containsMember(m.getId())){
		            firstCriteriaItems.addMember(m);
		         }
		      }	
		      return firstCriteriaItems;
	   }

}
