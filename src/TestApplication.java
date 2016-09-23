import model.Member;
import model.MemberList;

public class TestApplication {

	public static void main(String[] args) {
		Member md = new Member();
		md.setId("1");
		md.setName("Tester");
		md.setPersonal_number("12312");
		
		
		Member md2 = new Member();
		md2.setId("2");
		md2.setName("Peter");
		md2.setPersonal_number("3212");
		
		MemberList md_list = new MemberList();
		md_list.addMember(md);
		md_list.addMember(md2);
		
		dao.MembersDAO.jaxbObjectToXML(md_list);
	}

}
