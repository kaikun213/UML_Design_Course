package model.search;

import model.MemberRegistry;
import model.Member;

public class ByNamePrefixCriteria implements SearchCriteria {
	
		private String namePrefix;
		
		public ByNamePrefixCriteria(String namePrefix){
			this.namePrefix = namePrefix;
		}
	
		@Override
	   public MemberRegistry meetCriteria(MemberRegistry members) {
	      MemberRegistry filter_result = new MemberRegistry(); 
	      
	      for (Member m : members.getMemberList()) {
	    	  if (m.getName().startsWith(namePrefix)){
	            filter_result.addMember(m);
	         }
	      }
	      return filter_result;
	   }

}
