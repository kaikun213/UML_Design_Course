package model.search;

import model.MemberList;

/* Filter design pattern */
public interface SearchCriteria {
	   public MemberList meetCriteria(MemberList members);
}
