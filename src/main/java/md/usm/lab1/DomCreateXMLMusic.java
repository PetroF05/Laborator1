package md.usm.lab1;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DomCreateXMLMusic {
    public static void main(String[] args) {
        try{
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            Document doc = dbBuilder.newDocument();

            Element root = doc.createElement("music");
            doc.appendChild(root);

            Element typesOfMusic = doc.createElement("types-of-music");
            root.appendChild(typesOfMusic);

            Element ambient = doc.createElement("type");
            ambient.appendChild(doc.createTextNode("Ambient"));
            typesOfMusic.appendChild(ambient);

            Element classical = doc.createElement("type");
            classical.appendChild(doc.createTextNode("Baroque/Classical"));
            typesOfMusic.appendChild(classical);

            Element classicRock = doc.createElement("type");
            classicRock.appendChild(doc.createTextNode("Classic Rock"));
            typesOfMusic.appendChild(classicRock);

            Element dubstep = doc.createElement("type");
            dubstep.appendChild(doc.createTextNode("Dubstep"));
            typesOfMusic.appendChild(dubstep);

            Element heavyMetal = doc.createElement("type");
            heavyMetal.appendChild(doc.createTextNode("Heavy Metal"));
            typesOfMusic.appendChild(heavyMetal);

            Element jazz = doc.createElement("type");
            jazz.appendChild(doc.createTextNode("Jazz"));
            typesOfMusic.appendChild(jazz);

            Element oldies = doc.createElement("type");
            oldies.appendChild(doc.createTextNode("Oldies"));
            typesOfMusic.appendChild(oldies);

            Element polka = doc.createElement("type");
            polka.appendChild(doc.createTextNode("Polka"));
            typesOfMusic.appendChild(polka);

            Element pop = doc.createElement("type");
            pop.appendChild(doc.createTextNode("Pop"));
            typesOfMusic.appendChild(pop);

            Element punk = doc.createElement("type");
            punk.appendChild(doc.createTextNode("Punk"));
            typesOfMusic.appendChild(punk);

            Element reggae = doc.createElement("type");
            reggae.appendChild(doc.createTextNode("Reggae"));
            typesOfMusic.appendChild(reggae);

            Element rock = doc.createElement("type");
            rock.appendChild(doc.createTextNode("Rock"));
            typesOfMusic.appendChild(rock);

            Element smoothJazz = doc.createElement("type");
            smoothJazz.appendChild(doc.createTextNode("Smooth Jazz"));
            typesOfMusic.appendChild(smoothJazz);

            Element songStructure = doc.createElement("song-structure");
            root.appendChild(songStructure);

            Element intro = doc.createElement("layer");
            Attr attrIntro = doc.createAttribute("name");
            attrIntro.setValue("Intro");
            intro.setAttributeNode(attrIntro);
            intro.appendChild(doc.createTextNode("Attract listener's attention and introduce them to the song"));
            songStructure.appendChild(intro);

            Element verse = doc.createElement("layer");
            Attr attrVerse = doc.createAttribute("name");
            attrVerse.setValue("Verse");
            verse.setAttributeNode(attrVerse);
            verse.appendChild(doc.createTextNode("Tell the story, give the details"));
            songStructure.appendChild(verse);

            Element preChorus = doc.createElement("layer");
            Attr attrPreChorus = doc.createAttribute("name");
            attrPreChorus.setValue("Pre-Chorus");
            preChorus.setAttributeNode(attrPreChorus);
            preChorus.appendChild(doc.createTextNode("Build anticipation for the chorus"));
            songStructure.appendChild(preChorus);

            Element chorus = doc.createElement("layer");
            Attr attrChorus = doc.createAttribute("name");
            attrChorus.setValue("Chorus");
            chorus.setAttributeNode(attrChorus);
            chorus.appendChild(doc.createTextNode("Main theme or message"));
            songStructure.appendChild(chorus);

            Element bridge = doc.createElement("layer");
            Attr attrBridge = doc.createAttribute("name");
            attrBridge.setValue("Bridge");
            bridge.setAttributeNode(attrBridge);
            bridge.appendChild(doc.createTextNode("Create a break away from or variation to rest of song"));
            songStructure.appendChild(bridge);

            Element outro = doc.createElement("layer");
            Attr attrOutro = doc.createAttribute("name");
            attrOutro.setValue("Outro");
            outro.setAttributeNode(attrOutro);
            outro.appendChild(doc.createTextNode("Conclusion. End of the song with variation or fade out"));
            songStructure.appendChild(outro);



            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("music.xml"));
            transformer.transform(source, result);



        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
