package view;

import java.util.Iterator;
import java.util.Scanner;

import model.Boat;
import model.Member;
import model.Boat.Boatstype;

public class Console implements IView {
	
	// input errors: scan name (e.g. put more than 2 strings) & scanner in general
	// format personal number + not more than 12month etc..
	
	private Scanner scan;
	
	private enum ValidationType {
			SwedishID,
			Double,
			yesNo,
			Integer,
			None
	}
	
	public Console(){
		scan = new Scanner(System.in);
	}
	
	@Override
	public void showWelcomeMessage() {
		  System.out.println("__________________________________");
		  System.out.println("|                                 |");
		  System.out.println("| Hello, Welcome to the Boat Club |") ; 
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
		
		new_Member.setName(getInput(ValidationType.None)); //"^[a-zA-Z ]*$"));
		
		System.out.println("Please enter the personal number in this form YYMMDD-XXXX");
		new_Member.setPersonal_number(getInput(ValidationType.SwedishID));	//("^[\\d]{6}-{1}[\\d]{4}$"));
		 	
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
		return getInput(ValidationType.None); 	//("^[a-zA-Z ]*$");
		
	}
	public String editMemberPersonalNumber(){
		System.out.println("Please enter the new personal number in this form YYMMDD-XXXX");
		return getInput(ValidationType.SwedishID);		// ("^[\\d]{6}-{1}[\\d]{4}$");
	}
	
	@Override
	public boolean deleteMemberConfirmation(int id) {
		System.out.println("Are you sure to delete the member with the member-ID:" + id + "? y/N");
		char c = getInput(ValidationType.yesNo).charAt(0);
	
		return (Character.compare(c, 'y') == 0);
	}

	@Override
	public boolean deleteBoatConfirmation(int id) {
		System.out.println("Are you sure to delete the boat with the Boat-ID:" + id + "? y/N");
		char c = getInput(ValidationType.yesNo).charAt(0);
	
		return (Character.compare(c, 'y') == 0);
	}

	@Override
	public boolean wantsToManage() {
		System.out.println("Press any char to contine or 'q' to quit");
		return (Character.compare(getInput(ValidationType.None).charAt(0), 'q') != 0);
	}
	
	@Override
	public void showBoats(Iterator<Boat> boats) {
		int boat_counter = 1;
		System.out.println("\tboats:");
		while (boats.hasNext()){
			Boat b = boats.next();
			System.out.println("\t\t" + boat_counter++ + ".) " + "Boat-ID: "  + b.getId());
			System.out.println("\t\t    " + b.getType() + " : " + b.getLength() + "m\n");
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
		new_Boat.setLength(Double.parseDouble(getInput(ValidationType.Double)));
		 	
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
		b.setLength(Double.parseDouble(getInput(ValidationType.Double)));
		
		return b;
	}
	
	
	private int getChoice(int min,int max){
		int choice;
		do {
			choice = Integer.parseInt(getInput(ValidationType.Integer));
		} while (choice<min || choice>max);
		return choice;
	}
	
	private String getInput(ValidationType type){		// validation true = personalNumber
		String result = "";
		do {
			result = scan.nextLine();
			if (type!=ValidationType.None) {
				if ((type==ValidationType.Double && !validateDouble(result)) ||
				    (type==ValidationType.SwedishID && !validateSwedishID(result)) ||
					((type==ValidationType.yesNo) && !validateYesNo(result)) ||
					((type==ValidationType.Integer) && !validateInteger(result))
				   ) {									// validation not passed -> repeat
						System.out.println("Please enter a valid input");
						result="";
					}
			}
		}while (result.isEmpty() && scan.hasNext());
		return result;
	}
	
	private boolean validateInteger(String s){
		try {
			@SuppressWarnings("unused")
			int i = Integer.parseInt(s);
			return true;
		}
		catch(NumberFormatException e){
			return false;
		}
	}
	
	private boolean validateDouble(String s){
		try {
			@SuppressWarnings("unused")
			Double d = Double.parseDouble(s);
			return true;
		}
		catch(NumberFormatException e){
			return false;
		}
	}
	
	private boolean validateYesNo(String s){
		if (s.length() == 1){
			if ((Character.compare(s.charAt(0), 'y') == 0) || (Character.compare(s.charAt(0), 'N') == 0)) return true;
		}
		return false;
	}
	
	private boolean validateSwedishID(String s) {
		String n = s.substring(0, 6) + s.substring(7, s.length());			// deleting the dash to have a clear number
		
		for (int i=0;i<n.length();i++){										// check the birth date is just out of numbers , temporary numbers are out!
			if ((Character.isDigit(n.charAt(i)) == false)) 	return showErrorMessage("The personal-nr. consists only digits!");
		}
		int year = Integer.parseInt(n.substring(0, 2));						// for later use for February-days per year 
		
		int month = Integer.parseInt(n.substring(2,4));
		//System.out.println("The month is: " + month);
		if ( month > 12 || month < 1) return showErrorMessage("Invalid month!");
		
		int day = Integer.parseInt(n.substring(4, 6));
		//System.out.println("The day is: " + day);
																			// check if the whole date is possible
		if (month == 2) {													// February extra case
			if (year%4 == 0) {
				if (day > 29 || day < 1) return showErrorMessage("Invalid day!");						// every 4 years February has 29 days
			}
			else if (day > 28 || day < 1) return showErrorMessage("Invalid day!");
		}
		else {
			if (month>7) {														// for the month after July , even month have up to 31 days
				if  (month%2 == 0) {
					if (day > 31 || day < 1) return showErrorMessage("Invalid day!");
				}
				else if  (day > 30 || day < 1) return showErrorMessage("Invalid day!");
			}
			if (month<8) {														// for the month before August, odd month have up to 31 days , except the February
				if  (month%2 == 0) {
					if (day > 30 || day < 1) return showErrorMessage("Invalid day!");
				}
				else if  (day > 31 || day < 1) return showErrorMessage("Invalid day!");
			}
		}
		
		int checksum = 0;
		int nextDigit = 0;
		for (int i=0;i<n.length()-1;i++){												// Checksum calculation
				nextDigit = Character.getNumericValue(n.charAt(i))*(2- (i%2));			// multiply the numbers by the right factorial (212121-212)
				if (nextDigit > 9) {													// if it's out of 2 digits , add both of them to one
					nextDigit = (nextDigit/10) + (nextDigit%10);
				}
				checksum += nextDigit;													// add all the 8 numbers to the sum
		}
		
		
		checksum = checksum%10;														// take the last digit
		checksum = 10 - checksum;													// subtract it from 10
		checksum = checksum%10;														// take the last digit again
		
		if (Character.getNumericValue(n.charAt(n.length()-1)) != checksum) return showErrorMessage("Invalid checksum!");
		
		return true;																//  if all the conditions are untrue and never returned false, it is a correct number
		
	}
	
	private boolean showErrorMessage(String s){
		System.err.println(s);
		return false;
	}

	
}
	