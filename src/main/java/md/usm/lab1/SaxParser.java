package md.usm.lab1;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SaxParser {

    public static void main(String[] args) {
        try{
            File inputFile = new File("departments.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandlerLab1 userHandlerLab1 = new UserHandlerLab1();
            saxParser.parse(inputFile, userHandlerLab1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

class UserHandlerLab1 extends DefaultHandler {
    boolean lastName = false;
    boolean firstName = false;
    boolean birthDate = false;
    boolean position = false;
    boolean skills = false;
    boolean managerId = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("employee")){
            String id = attributes.getValue("empId");
            System.out.println("Employee id = "+id);
        }else if(qName.equalsIgnoreCase("lastName")){
            lastName = true;
        }else if(qName.equalsIgnoreCase("firstName")){
            firstName = true;
        }else if(qName.equalsIgnoreCase("birthDate")){
            birthDate = true;
        }else if(qName.equalsIgnoreCase("position")){
            position = true;
        }else if(qName.equalsIgnoreCase("skill")){
            skills = true;
        }else if(qName.equalsIgnoreCase("managerId")){
            managerId = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equalsIgnoreCase("employee")){
            System.out.println("End element : "+qName);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(lastName){
            System.out.println("Last name : "+new String(ch, start, length));
            lastName = false;
        }else if(firstName){
            System.out.println("First name : "+new String(ch, start, length));
            firstName = false;
        }else if(birthDate){
            System.out.println("Birth date : "+new String(ch, start, length));
            birthDate = false;
        }else if(position){
            System.out.println("Position : "+new String(ch, start, length));
            position = false;
        }else if(skills){
            System.out.println("Skill : "+new String(ch, start, length));
            skills = false;
        }else if(managerId){
            System.out.println("Manager id : "+new String(ch, start, length)+"\n");
            managerId = false;
        }
    }
}
