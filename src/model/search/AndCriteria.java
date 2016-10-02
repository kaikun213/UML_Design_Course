package model.search;

import java.util.List;

import model.Member;

public class AndCriteria implements SearchCriteria {

		   private SearchCriteria criteria;
		   private SearchCriteria otherCriteria;

		   public AndCriteria(SearchCriteria criteria, SearchCriteria otherCriteria) {
		      this.criteria = criteria;
		      this.otherCriteria = otherCriteria; 
		   }

		   @Override
		   public List<Member> meetCriteria(List<Member> members) {
		   
		      List<Member> firstCriteriaPersons = criteria.meetCriteria(members);		
		      return otherCriteria.meetCriteria(firstCriteriaPersons);
		   }
}
