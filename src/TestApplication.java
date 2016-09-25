import dao.MembersDAO;
import model.Boat;
import model.Member;
import model.MemberList;
import model.Boat.Boatstype;

public class TestApplication {

	public static void main(String[] args) {
		Member md = new Member();
		md.setId("1");
		md.setName("Tester");
		md.setPersonal_number("12312");
		Boat boat = new Boat();
		boat.setLength(10);
		boat.setType(Boatstype.Kayak);
		md.addBoat(boat);
		
		Member md2 = new Member();
		md2.setId("2");
		md2.setName("Peter");
		md2.setPersonal_number("3212");
		
		MemberList md_list = MembersDAO.jaxbXMLToObject();
		md_list.addMember(md);
		md_list.addMember(md2);
		
		dao.MembersDAO.jaxbObjectToXML(md_list);
	}

}
