package model.search;



import model.MemberList;
import model.Boat;
import model.Member;

public class ByBoatsTypeCriteria implements SearchCriteria {
	
	private Boat.Boatstype boatstype;
	
	public ByBoatsTypeCriteria(Boat.Boatstype boatstype){
		this.boatstype = boatstype;
	}

	@Override
	public MemberList meetCriteria(MemberList members) {
		MemberList filter_result = new MemberList();
	      
	      for (Member m : members.getMemberList()){ 
	    	  for (Boat b : m.getBoats()){
	    		  if (b.getType().equals(boatstype))filter_result.addMember(m);
	    	  }
	      }
	   return filter_result;
	}

}
