package view;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Boat;
import model.Member;

public class JavaFXGUI implements Initializable,IView{
	
	
	@FXML private VBox InstructionPane;
	@FXML private Button createMember;
	@FXML private Button deleteMember;
	@FXML private Button editMember;
	@FXML private Button showMembers;
	@FXML private Text WelcomeText;
	@FXML private Text Instructions;
	
	private int instruction = 0;
	
	private void setInstruction(int i){
		instruction = i;
	}
	private int getInstruction(){
		return instruction;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	@Override
	public void showWelcomeMessage() {
		WelcomeText.setVisible(true);
	}


	@Override
	public int selectInstruction() {
		InstructionPane.setVisible(true);
		//while (!createMember.isPressed() || !deleteMember.isPressed() || !editMember.isPressed() || !showMembers.isPressed()){
			createMember.setOnAction(e -> setInstruction(1));
			deleteMember.setOnAction(e -> setInstruction(2));
			editMember.setOnAction(e -> setInstruction(3));
			showMembers.setOnAction(e -> setInstruction(4));
		//}
		System.out.println("InstructionPane unvisible after click");
		return getInstruction();
	}

	@Override
	public int selectListType() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void showCompactList(Iterator<Member> m_it) {
		
		
	}


	@Override
	public void showVerboseList(Iterator<Member> m_it) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int selectMember() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void showMember(int id, String name, String personal_number, Iterator<Boat> b_it) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Member createMember() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean deleteMemberConfirmation(int id) {
		
		return false;
	}


	@Override
	public int selectMemberEdit() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public String editMemberName() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String editMemberPersonalNumber() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int selectBoatsEdit() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void showEmptyBoatsListWarning() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void showBoats(Iterator<Boat> b_it) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int selectBoat() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Boat createBoat() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Boat editBoat(Boat b) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean deleteBoatConfirmation(int id) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean wantsToManage() {
		// TODO Auto-generated method stub
		return false;
	}

}
