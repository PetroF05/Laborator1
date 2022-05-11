package md.usm.lab1;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SaxQuery {
    public static void main(String[] args) {
        try{
            File inputFile = new File("departments.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandlerLab1_2 userHandlerLab1_2 = new UserHandlerLab1_2();
            saxParser.parse(inputFile, userHandlerLab1_2);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class UserHandlerLab1_2 extends DefaultHandler {
    boolean lastName = false;
    boolean firstName = false;
    boolean birthDate = false;
    boolean position = false;
    boolean skills = false;
    boolean managerId = false;
    String id = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("employee")) {
            id = attributes.getValue("empId");

        }

        if("002".equals(id) && qName.equalsIgnoreCase("employee")){
            System.out.println("Start element : "+qName);
            System.out.println("Employee id = " + id);
        }

        if (qName.equalsIgnoreCase("lastName")) {
            lastName = true;
        } else if (qName.equalsIgnoreCase("firstName")) {
            firstName = true;
        } else if (qName.equalsIgnoreCase("birthDate")) {
            birthDate = true;
        } else if (qName.equalsIgnoreCase("position")) {
            position = true;
        } else if (qName.equalsIgnoreCase("skill")) {
            skills = true;
        } else if (qName.equalsIgnoreCase("managerId")) {
            managerId = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equalsIgnoreCase("employee")){
            if(("002").equals(id) && qName.equalsIgnoreCase("employee")){
                System.out.println("End element : "+qName);
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(lastName && ("002").equals(id)){
            System.out.println("Last name : "+new String(ch, start, length));
            lastName = false;
        }else if(firstName && ("002").equals(id)){
            System.out.println("First name : "+new String(ch, start, length));
            firstName = false;
        }else if(birthDate && ("002").equals(id)){
            System.out.println("Birth date : "+new String(ch, start, length));
            birthDate = false;
        }else if(position && ("002").equals(id)){
            System.out.println("Position : "+new String(ch, start, length));
            position = false;
        }else if(skills && ("002").equals(id)){
            System.out.println("Skill : "+new String(ch, start, length));
            skills = false;
        }else if(managerId && ("002").equals(id)){
            System.out.println("Manager id : "+new String(ch, start, length));
            managerId = false;
        }
    }
}
