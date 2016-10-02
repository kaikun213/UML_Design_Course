package model.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Boat;
import model.Member;

public class ByBoatsTypeCriteria implements SearchCriteria {
	
	private Boat.Boatstype boatstype;
	
	public ByBoatsTypeCriteria(Boat.Boatstype boatstype){
		this.boatstype = boatstype;
	}

	@Override
	public List<Member> meetCriteria(List<Member> members) {
		List<Member> filter_result = new ArrayList<Member>(); 
	      
	      for (Member m : members) {
	    	  Iterator<Boat> b_it = m.getBoats();
	    	  while (b_it.hasNext()){
	    		  if (b_it.next().getType().equals(boatstype)){
	  	            filter_result.add(m);
	  	         }
	    	  }
	      }
	      return filter_result;
	}

}
