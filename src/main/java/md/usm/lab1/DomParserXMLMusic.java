package md.usm.lab1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DomParserXMLMusic {
    public static void main(String[] args) {
        try{
            File inputFile = new File("music.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            Document doc = dbBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Node rootElement = doc.getFirstChild();
            System.out.println("Root element : " + rootElement.getNodeName());

            NodeList typesOfMusic = doc.getElementsByTagName("types-of-music");
            System.out.println("\nFirst child of root element: "+typesOfMusic.item(0).getNodeName());

            NodeList songStructure = doc.getElementsByTagName("song-structure");
            System.out.println("Second child of root element: "+songStructure.item(0).getNodeName());

            NodeList types = doc.getElementsByTagName("type");
            System.out.println("\n Children of <types-of-music> tag");
            for(int i = 0; i < types.getLength(); i++){
                Node type = types.item(i);

                if(type.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) type;
                    System.out.println((i+1)+". "+element.getTextContent());
                }
            }
            System.out.println();


            NodeList songsStructure = doc.getElementsByTagName("layer");
            System.out.println("\n Children of <song-structure> tag");
            for(int i = 0; i < songsStructure.getLength(); i++){
                Node layer = songsStructure.item(i);

                if(layer.getNodeType() == Node.ELEMENT_NODE){
                    Element element1 = (Element) layer;
                    System.out.println((i+1)+". Attribute: "+element1.getAttribute("name"));
                    System.out.println("   Description: "+element1.getTextContent());
                }
            }
            System.out.println();

        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
