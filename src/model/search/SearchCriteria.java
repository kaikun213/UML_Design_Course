package model.search;

import java.util.List;

import model.Member;

/* Filter design pattern */
public interface SearchCriteria {
	   public List<Member> meetCriteria(List<Member> members);
}
