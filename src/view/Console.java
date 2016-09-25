package view;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import model.Boat;
import model.Member;

public class Console implements IView {
	Scanner scan = new Scanner(System.in); 
	@Override
	public void showWelcomeMessage() {
		System.out.println("Hello, Welcome to Boat Club")  ; 
		
	}

	@Override
	public int showInstructions() {
		int c=0 ; 
		System.out.println("Type '1' to create a new member");
		System.out.println("Type '2' to create a new member");
		System.out.println("Type '3' to create a new member");
		int choice = 0;
		while (choice<1 || choice>3 ) {
			System.out.println("Please enter a valid choice");
			choice = scan.nextInt() ; 
			c=choice;
		}
		 
		return c ;
	}

	@Override
	public int selectListType() {
		System.out.println("Please select a type of a list");
		int i = 0 ; 
		while (i<1 || i>2 ) {
			System.out.println("Please type '1' to have the verbose list or '2' to have the compact list");
			i=scan.nextInt();
		}
		return i;
	}


	@Override
	public void showCompactList(Iterator<Member> m_it) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showVerboseList(Iterator<Member> m_it) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String selectMember() {
		System.out.println("Please type the id of the member you want to show ");
		String Sid = scan.nextLine() ; 
		return Sid;
	}

	@Override
	public void showSelectedMember(String id, String name, String personal_number, Iterator<Boat> boats) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean showDeleteMemberConfirmation(String id) {
		char choice='i' ; 
		System.out.println("Are you sure y/n ?");
		char c = 'i';
		while (c!='y' || c!='n' ) {
			System.out.println("Please enter a valid choice");
			c =scan.next().charAt(0) ;
		choice =c ; 
		}
		
		  
		if (choice=='y') {
			return true ; 
		}
		else if (choice=='n') {
			return false ; 
		}
		return false;
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
		Random rand = new Random();

		int  n = rand.nextInt(100000);
		String n1 = String.valueOf(n) ; 
		
		m.setId(n1);
		 
		
		
		
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
	public void showBoats(Iterator<Boat> boats) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean showDeleteBoatConfirmation(String id) {
		char choice='i' ; 
		System.out.println("Are you sure y/n ?");
		char c = 'i';
		while (c!='y' || c!='n' ) {
			System.out.println("Please enter a valid choice");
			c =scan.next().charAt(0) ;
		choice =c ; 
		}
		
		  
		if (choice=='y') {
			return true ; 
		}
		else if (choice=='n') {
			return false ; 
		}
		return false;
	}


	@Override
	public Boat addBoatToMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean wantsToManage() {
		char c =scan.next().charAt(0) ; 
		if (c=='q'||c=='Q') {
			return false ; 
		}
		else {
			return true ; 
		}
	}}
	