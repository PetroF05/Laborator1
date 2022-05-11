package md.usm.lab1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;

public class XPath {
    public static void main(String[] args) {
        try{
            String nodeName = "department";
            String path = "departments.xml";

            File inputFile = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();


            NodeList node = doc.getElementsByTagName(nodeName);
            int i = 1;

            Boolean aBoolean = checkTagPresence(nodeName, path);
            if(aBoolean == true){
                System.out.println("Tag "+nodeName+" exist in the file - "+path);
            }else if(aBoolean == false){
                System.out.println("Tag "+nodeName+" doesn't exist in the file - "+path);
            }

            System.out.println();

            Boolean bBoolean = checkChildrenOfaTag(node, path, i);
            if(bBoolean == true){
                System.out.println("Tag "+node.item(i).getNodeName()+" have children in the file - "+path);
            }else if(bBoolean == false){
                System.out.println("Tag "+node.item(i).getNodeName()+" doesn't have children in the file - "+path);
            }

            System.out.println();

            getListOfValues(node, path, i);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static boolean checkTagPresence(String nodeName, String path){
        boolean bool = false;
        try{

            File inputFile = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            javax.xml.xpath.XPath xPath = XPathFactory.newInstance().newXPath();
            String expression = "//"+nodeName;
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
            int length = nodeList.getLength();
            if(length == 0){
                bool = false;
            }else if(length != 0){
                bool = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return bool;
    }

    public static boolean checkChildrenOfaTag(NodeList nodeName, String path, int i){
        boolean bool = false;
        try{

            File inputFile = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            //XPath xPath = XPathFactory.newInstance().newXPath();
            Node parentNode = nodeName.item(i);
            NodeList childrenList = parentNode.getChildNodes();
            if(parentNode == null){
                bool = false;
                System.out.println("Tag "+parentNode+" doesn't exist");
            }else if(parentNode != null){
                int child = childrenList.getLength();
                if(child == 0){
                    bool = false;
                }else if(child != 0){
                    bool = true;
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return bool;
    }

    public static void getListOfValues(NodeList nodeName, String path, int index){
        try{

            File inputFile = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            //XPath xPath = XPathFactory.newInstance().newXPath();
            Node node = nodeName.item(index);
            NodeList childrenOfNode = node.getChildNodes();
            for(int i = 0; i < childrenOfNode.getLength(); i++){
                Node node1 = childrenOfNode.item(i);
                if(node1.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node1;
                    System.out.println(element.getNodeName()+" - "+element.getTextContent());
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
