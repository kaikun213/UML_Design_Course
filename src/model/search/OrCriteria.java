package model.search;

import java.util.List;

import model.Member;

public class OrCriteria implements SearchCriteria{
	
	 private SearchCriteria criteria;
	   private SearchCriteria otherCriteria;

	   public OrCriteria(SearchCriteria criteria, SearchCriteria otherCriteria) {
	      this.criteria = criteria;
	      this.otherCriteria = otherCriteria; 
	   }

	   @Override
	   public List<Member> meetCriteria(List<Member> members) {
		   List<Member> firstCriteriaItems = criteria.meetCriteria(members);
		      List<Member> otherCriteriaItems = otherCriteria.meetCriteria(members);

		      for (Member m : otherCriteriaItems) {
		         if(!firstCriteriaItems.contains(m)){
		            firstCriteriaItems.add(m);
		         }
		      }	
		      return firstCriteriaItems;
	   }

}
