package view;

import java.util.Iterator;
import java.util.Scanner;

import model.Boat;
import model.Member;
import model.Boat.Boatstype;

public class Console implements IView {
	
	private Scanner scan;
	
	public Console(){
		scan = new Scanner(System.in);
	}
	
	@Override
	public void showWelcomeMessage() {
		  System.out.println("__________________________________");
		  System.out.println("|                                 |");
		System.out.println("| Hello, Welcome to the Boat Club |")  ; 
		  System.out.println("|_________________________________|\n");
		
	}

	@Override
	public int selectInstruction() { 
		System.out.println("----------- Instructions -----------");
		System.out.println("1.) Create a new member");
		System.out.println("2.) Delete a member");
		System.out.println("3.) Edit a members/boats");
		System.out.println("4.) Show members\n");
		System.out.println("Please type a number to choose your action.");
		
		return getChoice(1,4);
	}

	@Override
	public int selectListType() {
		System.out.println("Please select a type of a list");
		System.out.println("Press '1' to have the compact list or\n Pres '2' to have the verbose list");

		return getChoice(1,2);
	}


	@Override
	public void showCompactList(Iterator<Member> m_it) {
		int counter = 1;
		while (m_it.hasNext()){
			Member m = m_it.next();
			System.out.println(counter++ +".) \t member-ID: " + m.getId());
			System.out.println("\t name: " + m.getName());
			
			// sub Iteration to count the number of boats.
			int boat_counter = 0;
			Iterator<Boat> b_it = m.getBoats();
			while (b_it.hasNext()){
				boat_counter++;
				b_it.next();
			}
			
			System.out.println("\t boat number: " + boat_counter);
		}
		
	}

	@Override
	public void showVerboseList(Iterator<Member> m_it) {
		int counter = 1;
		while (m_it.hasNext()){
			Member m = m_it.next();
			System.out.print("\n" + counter++ + ".)");
			showMember(m.getId(),m.getName(),m.getPersonal_number(),m.getBoats());
		}
		
	}

	@Override
	public int selectMember() {
		System.out.println("Please type the member-id of the member you want to show "); 
		return scan.nextInt();
	}

	@Override
	public void showMember(int id, String name, String personal_number, Iterator<Boat> b_it) {
		System.out.println("\tmember-ID: " + id);
		System.out.println("\tname: " + name);
		System.out.println("\tpersonal-number: " + personal_number + "");
		// sub Iteration to count the number of boats.
		showBoats(b_it);
		
	}

	@Override
	public Member createMember() {
		Member new_Member = new Member () ; 
		System.out.println("***** Create a new member *****") ; 
		
		System.out.println("Please enter the first name and last name"); 
		String name = scan.next();
		name += " " + scan.next();
		new_Member.setName(name);
		
		System.out.println("Please enter the personal number in this form YYMMDD-XXXX");
		new_Member.setPersonal_number(scan.next());
		 	
		return new_Member;
	}

	@Override
	public int selectMemberEdit() {
		System.out.println("----------- Edit Member -----------");
		System.out.println("1.) Edit name");
		System.out.println("2.) Edit personal number");
		System.out.println("3.) Edit members boats");
		System.out.println("4.) Cancel editing\n");
		System.out.println("Please type a number to choose your action.");
		return getChoice(1,4);
	}
	
	public String editMemberName(){
		System.out.println("Please enter the new first name and last name");
		String name = scan.next();
		name += " " + scan.next();
		return name;
		
	}
	public String editMemberPersonalNumber(){
		System.out.println("Please enter the new personal number in this form YYMMDD-XXXX");
		return scan.next();
	}
	
	@Override
	public boolean deleteMemberConfirmation(int id) {
		int c;
		do {
			System.out.println("Are you sure to delete the member with the member-ID:" + id + "? y/N");
			c = scan.next().charAt(0);
		} while (c!='y' || c!='N');
		
		return (c =='y');
	}

	@Override
	public boolean deleteBoatConfirmation(int id) {
		int c;
		do {
			System.out.println("Are you sure to delete the boat with the Boat-ID:" + id + "? y/N");
			c = scan.next().charAt(0);
		} while (c!='y' || c!='N');
		
		return (c =='y');
	}

	@Override
	public boolean wantsToManage() {
		System.out.println("Press any char to contine or 'q' to quit");
		return (scan.next().charAt(0) != 'q');
	}
	
	@Override
	public void showBoats(Iterator<Boat> boats) {
		int boat_counter = 1;
		System.out.println("\tboats:");
		while (boats.hasNext()){
			Boat b = boats.next();
			System.out.println("\tBoat-ID: "+ b.getId());
			System.out.println("\t\t" +  boat_counter++ + ".) " + b.getType() + " : " + b.getLength() + "m");
		}
	}

	@Override
	public Boat createBoat() {
		Boat new_Boat = new Boat() ; 
		System.out.println("***** Create a new boat *****") ; 
		
		System.out.println("Please select a boatstype:");
		for (int i=0;i<Boatstype.values().length;i++ ){
			System.out.println("\t" + i + ".) " + Boatstype.values()[i]);
		}
		
		Boatstype t = Boatstype.values()[getChoice(0,Boatstype.values().length-1)];
		new_Boat.setType(t);
		
		System.out.println("Please enter the length"); 
		new_Boat.setLength(Double.parseDouble(scan.next()));
		 	
		return new_Boat;
	}
	
	@Override
	public int selectBoatsEdit() {
		System.out.println("----------- Edit Boats  -----------");
		System.out.println("1.) Create a boat");
		System.out.println("2.) Delete a boat");
		System.out.println("3.) Edit a boat");
		System.out.println("4.) Cancel editing\n");
		System.out.println("Please type a number to choose your action.");
		return getChoice(1,4);
	}

	@Override
	public void showEmptyBoatsListWarning() {
		System.out.println("----------- WARNING: Unfortunatelly this member has no registered boats to edit/delete!  -----------");		
	}

	@Override
	public int selectBoat() {
		System.out.println("Please type the boat-ID of the boat you want to select "); 
		return scan.nextInt();
	}

	@Override
	public Boat editBoat(Boat b) {
		System.out.println("Boats-ID: " + b.getId());
		System.out.println("Current boatstype:" + b.getType());
		System.out.println("Please select a new boatstype:");
		for (int i=0;i<Boatstype.values().length;i++ ){
			System.out.println("\t" + i + ".) " + Boatstype.values()[i]);
		}
		
		Boatstype t = Boatstype.values()[getChoice(0,Boatstype.values().length-1)];
		b.setType(t);
		
		System.out.println("Current length:" + b.getLength());
		System.out.println("Please enter the new length"); 
		b.setLength(Double.parseDouble(scan.next()));
		
		return b;
	}
	
	
	private int getChoice(int min,int max){
		int choice;
		do {
			choice = scan.nextInt();
		} while (choice<min || choice>max);
		return choice;
	}
	
}
	