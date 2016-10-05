package model.search;

import model.MemberList;
import model.Member;

public class ByNamePrefixCriteria implements SearchCriteria {
	
		private String namePrefix;
		
		public ByNamePrefixCriteria(String namePrefix){
			this.namePrefix = namePrefix;
		}
	
		@Override
	   public MemberList meetCriteria(MemberList members) {
	      MemberList filter_result = new MemberList(); 
	      
	      for (Member m : members.getMemberList()) {
	    	  if (m.getName().startsWith(namePrefix)){
	            filter_result.addMember(m);
	         }
	      }
	      return filter_result;
	   }

}
