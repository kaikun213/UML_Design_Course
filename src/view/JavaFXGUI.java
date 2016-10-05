package view;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Admin.ValidationType;
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
	public int selectInstruction() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int selectListType() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int selectMember() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int selectMemberEdit() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int selectBoatsEdit() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int selectBoat() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int selectSearch() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int selectMonth() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int selectBoatsType() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void showWelcomeMessage() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void showCompactList(Iterable<Member> m_it) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void showVerboseList(Iterable<Member> m_it) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void showMember(int id, String name, String personal_number,
			Iterable<Boat> b_it) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void showBoats(Iterable<Boat> b_it) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void showSuccessMessage(String s) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void showErrorMessage(String s) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void showAuthentification() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Member createMember() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean deleteMemberConfirmation(int id) {
		// TODO Auto-generated method stub
		return false;
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
	public String getSearchParam(ValidationType t) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String authentificateUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String authentificatePassword() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean wantsToManage() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}


}