package view;

import java.util.Iterator;
import java.util.Scanner;

import model.Boat;
import model.Member;

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
	public int showInstructions() { 
		System.out.println("----------- Instructions -----------");
		System.out.println("1.) Create a new member");
		System.out.println("2.) Delete a member");
		System.out.println("3.) Edit a member\n");
		System.out.println("Please type a number to choose your action.");
		
		return getChoice(1,3);
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
	public String selectMember() {
		System.out.println("Please type the member-id of the member you want to show "); 
		return scan.next();
	}

	@Override
	public void showMember(String id, String name, String personal_number, Iterator<Boat> boats) {
		System.out.println("\tmember-ID: " + id);
		System.out.println("\tname: " + name);
		System.out.println("\tpersonal- number: " + personal_number + "");
		// sub Iteration to count the number of boats.
		showBoats(boats);
		
	}

	@Override
	public Member CreateMemberForm() {
		Member m = new Member () ; 
		System.out.println("Please fill in this form to create a new memeber") ; 
		
		System.out.println("Please enter the first name and last name");
		String name=scan.nextLine(); 
		m.setName(name);
		
		System.out.println("Please enter the personal number in this form YYMMDD-XXXX");
		String PersonalNum=scan.nextLine() ; 
		m.setPersonal_number(PersonalNum);
		 	
		return m;
	}

	@Override
	public Member EditMemberForm(Member md) {
		System.out.println("Please fill in this form to edit a new memeber") ; 
		
		System.out.println("Please enter the new first name and last name");
		String name=scan.nextLine(); 
		md.setName(name);
		
		System.out.println("Please enter the new personal number in this form YYMMDD-XXXX");
		String PersonalNum=scan.nextLine() ; 
		md.setPersonal_number(PersonalNum);
		
		return md;
	}
	
	@Override
	public boolean showDeleteMemberConfirmation(String id) {
		System.out.println("Are you sure to delete the member with the member-ID:" + id + "? y/N");
		char c;
		do {
			System.out.println("Please enter a valid choice");
			c =scan.next().charAt(0) ;
		} while (Character.compare(c, 'y')!=0 || Character.compare(c, 'N')!=0 );
		
		return (Character.compare(c, 'y') == 0);
	}

	@Override
	public boolean showDeleteBoatConfirmation(String id) {
		char c;
		do {
			System.out.println("Are you sure to delete the boat from the member-ID:" + id + "? y/N");
			c =scan.next().charAt(0) ;
		} while (Character.compare(c, 'y')!=0 || Character.compare(c, 'N')!=0 );
		
		return (Character.compare(c, 'y') == 0);
	}


	@Override
	public Boat addBoatToMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean wantsToManage() {
		System.out.println("Press any char to contine or 'q' to quit");
		return (getInputChar() != 'q');
	}
	
	private int getChoice(int min,int max){
		int choice;
		do {
			choice = scan.nextInt() ; 
		} while (choice<min || choice>max);
		return choice;
	}
	
	private int getInputChar() {
	    try {
	      int c = System.in.read();
	      while (c == '\r' || c =='\n') {
	        c = System.in.read();
	      }
	      return c;
	    } catch (java.io.IOException e) {
	      System.out.println("" + e);
	      return 0;
	    }
	}
	
	private void showBoats(Iterator<Boat> boats) {
		int boat_counter = 1;
		System.out.println("\tboats:");
		while (boats.hasNext()){
			Boat b = boats.next();
			System.out.println("\t\t" +  boat_counter++ + ".) " + b.getType() + " : " + b.getLength() + "m");
		}
		
	}

}
	