package model.search;

import model.MemberList;

public class AndCriteria implements SearchCriteria {

		   private SearchCriteria criteria;
		   private SearchCriteria otherCriteria;

		   public AndCriteria(SearchCriteria criteria, SearchCriteria otherCriteria) {
		      this.criteria = criteria;
		      this.otherCriteria = otherCriteria; 
		   }

		   @Override
		   public MemberList meetCriteria(MemberList members) {
		   
		      MemberList firstCriteriaPersons = criteria.meetCriteria(members);		
		      return otherCriteria.meetCriteria(firstCriteriaPersons);
		   }
}
