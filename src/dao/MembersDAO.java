package dao;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import model.MemberRegistry;

public class MembersDAO {
	
	private static final String File = "./resources/members.xml";			// in eclipse
	//private static final String File = "resources/members.xml";				// as .jar
	
    public static MemberRegistry jaxbXMLToObject() {
        try {
            JAXBContext context = JAXBContext.newInstance(MemberRegistry.class);
            Unmarshaller un = context.createUnmarshaller();
            MemberRegistry md_list = (MemberRegistry) un.unmarshal(new File(File));
            return md_list;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void jaxbObjectToXML(MemberRegistry md_list) {

        try {
            JAXBContext context = JAXBContext.newInstance(MemberRegistry.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(md_list, new File(File));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
