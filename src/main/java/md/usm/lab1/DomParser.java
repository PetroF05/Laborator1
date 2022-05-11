package md.usm.lab1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DomParser {
    public static void main(String[] args) {
        try{
            File inputFile = new File("departments.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root element : "+doc.getFirstChild().getNodeName());

            NodeList departments = doc.getElementsByTagName("department");

            System.out.println();
            for(int i = 0; i < departments.getLength(); i++){
                Node department = departments.item(i);
                if(department.getNodeType() == Node.ELEMENT_NODE){
                    Element e = (Element) department;

                    System.out.println("-----------------------------------------");
                    System.out.println("Department name: "+e.getAttribute("name"));
                    System.out.println("Department id: "+e.getAttribute("depId"));
                    System.out.println("-----------List of employees-------------\n");
                    NodeList employees = e.getElementsByTagName("employee");
                    for(int j = 0; j < employees.getLength(); j++){
                        Node employee = employees.item(j);
                        System.out.println("Current element : "+employee.getNodeName()+(j+1));

                        if(employee.getNodeType() == Node.ELEMENT_NODE) {
                            Element e2 = (Element) employee;
                            System.out.println("Employee id = "+e2.getAttribute("empId"));
                            System.out.println("Last Name : "
                                    +e2
                                    .getElementsByTagName("lastName")
                                    .item(0)
                                    .getTextContent());
                            System.out.println("First Name : "
                                    +e2
                                    .getElementsByTagName("firstName")
                                    .item(0)
                                    .getTextContent());
                            System.out.println("Birth Date : "
                                    +e2
                                    .getElementsByTagName("birthDate")
                                    .item(0)
                                    .getTextContent());
                            System.out.println("Position : "
                                    +e2
                                    .getElementsByTagName("position")
                                    .item(0)
                                    .getTextContent());

                            Node skills = e2.getElementsByTagName("skills").item(0);
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
                                    +e2
                                    .getElementsByTagName("managerId")
                                    .item(0)
                                    .getTextContent());
                        }
                        System.out.println();
                    }
                    System.out.println();
                }
            }

            /*NodeList tag2List = doc.getElementsByTagName("employee");

            for(int i = 0; i < tag2List.getLength(); i++){
                Node nodeTag2 = tag2List.item(i);
                System.out.println("Current element : "+nodeTag2.getNodeName());

                if(nodeTag2.getNodeType() == Node.ELEMENT_NODE){
                    Element eTag2 = (Element) nodeTag2;

                    System.out.println("tag2Id : "+eTag2.getAttribute("tag2Id"));

                    System.out.println("t1 : "
                            +eTag2
                            .getElementsByTagName("t1")
                            .item(0)
                            .getTextContent());

                    System.out.println("t2 : "
                            +eTag2
                            .getElementsByTagName("t2")
                            .item(0)
                            .getTextContent());

                    System.out.println("t3 : "
                            +eTag2
                            .getElementsByTagName("t3")
                            .item(0)
                            .getTextContent());

                    System.out.println("t4 : "
                            +eTag2
                            .getElementsByTagName("t4")
                            .item(0)
                            .getTextContent());

                    NodeList listElements = doc.getElementsByTagName("listElements");

                    System.out.println("List of elements");

                    Node nodeElement = listElements.item(i);

                    if (nodeElement.getNodeType() == Node.ELEMENT_NODE) {
                        Element eList = (Element) nodeElement;
                        NodeList listOfElementsFromTag2 = eList.getElementsByTagName("listElement");
                        for(int count = 0; count < listOfElementsFromTag2.getLength(); count++){
                            Node node1 = listOfElementsFromTag2.item(count);

                            if(node1.getNodeType() == Node.ELEMENT_NODE){
                                Element elementList = (Element) node1;
                                System.out.println("  " + (count + 1) +". "+ elementList.getTextContent());
                            }
                        }

                    }


                    System.out.println("t5 : "
                            +eTag2
                            .getElementsByTagName("t5")
                            .item(0)
                            .getTextContent());
                }

                System.out.println();
            }*/

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
