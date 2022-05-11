package md.usm.lab1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DomQuery {
    public static void main(String[] args) {
        try{
            File inputFile = new File("departments.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            System.out.print("Root element : ");
            System.out.println(doc.getDocumentElement().getNodeName());

            System.out.println("--------[ Employee ]---------");
            NodeList employees = doc.getElementsByTagName("employee");

            for(int i = 0; i < employees.getLength(); i++){
                Node employee = employees.item(i);

                if(employee.getNodeType() == Node.ELEMENT_NODE){
                    Element e = (Element) employee;

                    String tagId = e.getAttribute("empId");
                    if(tagId.equals("001")){
                        System.out.println("Employee id = "+tagId);
                        System.out.println("Last Name : "
                                +e
                                .getElementsByTagName("lastName")
                                .item(0)
                                .getTextContent());
                        System.out.println("First Name : "
                                +e
                                .getElementsByTagName("firstName")
                                .item(0)
                                .getTextContent());
                        System.out.println("Birth Date : "
                                +e
                                .getElementsByTagName("birthDate")
                                .item(0)
                                .getTextContent());
                        System.out.println("Position : "
                                +e
                                .getElementsByTagName("position")
                                .item(0)
                                .getTextContent());

                        Node skills = e.getElementsByTagName("skills").item(0);
                        System.out.println("List of skills: ");
                        if(skills.getNodeType() == Node.ELEMENT_NODE){
                            Element e3 = (Element) skills;
                            NodeList skill = e3.getElementsByTagName("skill");

                            for(int k = 0; k < skill.getLength(); k++){
                                Node skill1 = skill.item(k);

                                if(skill1.getNodeType() == Node.ELEMENT_NODE){
                                    Element e4 = (Element) skill1;
                                    System.out.println((k+1)+". " +e4.getTextContent());
                                }
                            }
                        }

                        System.out.println("Manager id : "
                                +e
                                .getElementsByTagName("managerId")
                                .item(0)
                                .getTextContent());
                    }
                    System.out.println();

                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
