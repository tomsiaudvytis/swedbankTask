package fileconverter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import test.TestGeneratedXml;
import countpoints.ContestParticipant;

public class GenerateXmlFile {
	
	List<String> testList = new ArrayList<String>();
	
	TestGeneratedXml testXml = new TestGeneratedXml();

	public void generateFile(ArrayList<ContestParticipant> dataList, String outputPath){

		try{
			
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			// root elements
			Document doc = docBuilder.newDocument();
			
			Element rootElement = doc.createElement("competition");
			doc.appendChild(rootElement);
			
			for(int i = 0; i < dataList.size(); i++){
				
			// singleuser elements
			Element singleuser = doc.createElement("singlerow");
			rootElement.appendChild(singleuser);
			
			// participant elements
			Element participant = doc.createElement("participant");
			participant.appendChild(doc.createTextNode(dataList.get(i).getData().getParticipantScores()));
			singleuser.appendChild(participant);
			
			// score elements
			Element score = doc.createElement("score");
			score.appendChild(doc.createTextNode(dataList.get(i).getData().getFinalScore().toString()));
			singleuser.appendChild(score);
			
			// score elements
			Element place = doc.createElement("place");
			place.appendChild(doc.createTextNode(dataList.get(i).getData().getPlace()));
			singleuser.appendChild(place);
			}
			
			// Will test if xml file generated above is correct
			testXml.checkXmlStructure(doc, dataList);
			
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			
			StreamResult result = new StreamResult(new File(outputPath));
			//StreamResult result = new StreamResult(new File("C:/Users/Tomas/Desktop/testXml.xml"));
			transformer.transform(source, result);
			
		
			
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
		  }
		
	}

}
