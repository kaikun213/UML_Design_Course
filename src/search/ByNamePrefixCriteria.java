package search;

import java.util.ArrayList;
import java.util.List;

import model.Member;

public class ByNamePrefixCriteria implements SearchCriteria {
	
		private String namePrefix;
		
		public ByNamePrefixCriteria(String namePrefix){
			this.namePrefix = namePrefix;
		}
	
		@Override
	   public List<Member> meetCriteria(List<Member> members) {
	      List<Member> filter_result = new ArrayList<Member>(); 
	      
	      for (Member m : members) {
	    	  if (m.getName().startsWith(namePrefix)){
	            filter_result.add(m);
	         }
	      }
	      return filter_result;
	   }

}
