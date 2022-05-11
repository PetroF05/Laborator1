package md.usm.lab1;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DomModify {
    public static void main(String[] args) {
        try{
            File inputFile = new File("departments1.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(inputFile);
            Node company = doc.getFirstChild();
            System.out.println("Root element - "+company.getNodeName());

            Element department3 = doc.createElement("department");
            Attr name = doc.createAttribute("name");
            name.setValue("Testing");
            Attr depId = doc.createAttribute("depId");
            depId.setValue("3");
            department3.setAttributeNode(name);
            department3.setAttributeNode(depId);
            company.appendChild(department3);

            Element employee5 = doc.createElement("employee");
            Attr empId = doc.createAttribute("empId");
            empId.setValue("005");
            department3.appendChild(employee5);

            Element lastName = doc.createElement("lastName");
            lastName.appendChild(doc.createTextNode("Banks"));
            employee5.appendChild(lastName);

            Element firstName = doc.createElement("firstName");
            firstName.appendChild(doc.createTextNode("Joseph"));
            employee5.appendChild(firstName);

            Element birthDate = doc.createElement("birthDate");
            birthDate.appendChild(doc.createTextNode("02.10.1980"));
            employee5.appendChild(birthDate);

            Element position = doc.createElement("position");
            position.appendChild(doc.createTextNode("Manager"));
            employee5.appendChild(position);

            Element skills = doc.createElement("skills");
            employee5.appendChild(skills);

            Element skill1 = doc.createElement("skill");
            skill1.appendChild(doc.createTextNode("Java"));
            skills.appendChild(skill1);

            Element skill2 = doc.createElement("skill");
            skill2.appendChild(doc.createTextNode("QA Testing"));
            skills.appendChild(skill2);

            Element managerId = doc.createElement("managerId");
            managerId.appendChild(doc.createTextNode("0"));
            employee5.appendChild(managerId);


            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult fileResult = new StreamResult(inputFile);
            transformer.transform(source, fileResult);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
