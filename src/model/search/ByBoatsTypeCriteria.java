package model.search;



import model.MemberRegistry;
import model.Boat;
import model.Member;

public class ByBoatsTypeCriteria implements SearchCriteria {
	
	private Boat.Boatstype boatstype;
	
	public ByBoatsTypeCriteria(Boat.Boatstype boatstype){
		this.boatstype = boatstype;
	}

	@Override
	public MemberRegistry meetCriteria(MemberRegistry members) {
		MemberRegistry filter_result = new MemberRegistry();
	      
	      for (Member m : members.getMemberList()){ 
	    	  for (Boat b : m.getBoats()){
	    		  if (b.getType().equals(boatstype))filter_result.addMember(m);
	    	  }
	      }
	   return filter_result;
	}

}
