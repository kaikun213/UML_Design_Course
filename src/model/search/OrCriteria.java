package model.search;


import model.MemberRegistry;
import model.Member;

public class OrCriteria implements SearchCriteria{
	
	 private SearchCriteria criteria;
	   private SearchCriteria otherCriteria;

	   public OrCriteria(SearchCriteria criteria, SearchCriteria otherCriteria) {
	      this.criteria = criteria;
	      this.otherCriteria = otherCriteria; 
	   }

	   @Override
	   public MemberRegistry meetCriteria(MemberRegistry members) {
		  MemberRegistry firstCriteriaItems = criteria.meetCriteria(members);
		      MemberRegistry otherCriteriaItems = otherCriteria.meetCriteria(members);

		      for (Member m : otherCriteriaItems.getMemberList()) {
		         if(!firstCriteriaItems.containsMember(m.getId())){
		            firstCriteriaItems.addMember(m);
		         }
		      }	
		      return firstCriteriaItems;
	   }

}
