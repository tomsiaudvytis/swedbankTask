package test;

import static org.junit.Assert.*;

import java.io.StringWriter;
import java.util.ArrayList;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.Document;

import countpoints.ContestParticipant;

public class TestGeneratedXml {
	
	String object1;
	
	String object2;
	
	public void checkXmlStructure(Document doc,ArrayList<ContestParticipant> dataList) {
		
		object1 = generatedXmlFile(doc).replaceAll("(\r\n|\n)", "").trim();
		object2 = hardcodedTestXmlFile(dataList).replaceAll("(\r\n|\n)", "").trim();
		
	}
	
	@Test
	public void testEquality(){
		//Test if both files hardcoded and generated one are equals
		 assertEquals(object1, object2);
	}
	
	public String generatedXmlFile(Document doc){
		// will transform generated xml Document to String
		StringWriter sw = new StringWriter();
				try {
					
					TransformerFactory tf = TransformerFactory.newInstance();
					Transformer transformer = tf.newTransformer();
					transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
					transformer.setOutputProperty(OutputKeys.METHOD, "xml");
					transformer.setOutputProperty(OutputKeys.INDENT, "yes");
					transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

					transformer.transform(new DOMSource(doc), new StreamResult(sw));
					
					
				} catch (Exception ex) {
					throw new RuntimeException("Error converting to String", ex);
				}
				return sw.toString();
	}

	public String hardcodedTestXmlFile(ArrayList<ContestParticipant> data) {
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n");
		sb.append("<competition>\n");
		for (int i = 0; i < data.size(); i++) {
			sb.append("<singlerow>\n");
			sb.append("<participant>");
			sb.append(data.get(i).getData().getParticipantScores());
			sb.append("</participant>\n");
			sb.append("<score>").append(data.get(i).getData().getFinalScore()).append("</score>\n");
			sb.append("<place>").append(data.get(i).getData().getPlace()).append("</place>\n");
			sb.append("</singlerow>\n");
		}
		sb.append("</competition>\n");
		
		return sb.toString();
	}
}
