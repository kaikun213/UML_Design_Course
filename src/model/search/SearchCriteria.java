package model.search;

import model.MemberRegistry;

/* Filter design pattern */
public interface SearchCriteria {
	   public MemberRegistry meetCriteria(MemberRegistry members);
}
