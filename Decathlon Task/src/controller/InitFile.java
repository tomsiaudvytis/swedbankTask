package controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.TransformerException;

import readfile.ReadFromInputFile;
import countpoints.ContestParticipant;
import countpoints.PointsCounter;
import fileconverter.GenerateXmlFile;

public class InitFile {
	
	PointsCounter countPoints = new PointsCounter();
	
	GenerateXmlFile generateXml = new GenerateXmlFile();

	public void ReadFileAndCountPoints(String inputPath, String outputPath ) throws FileNotFoundException, TransformerException {

		//String filePath = "C:/decathlon.txt";

		// Get file content to a List
		ReadFromInputFile readInputFile = new ReadFromInputFile();
		List<String> fileContent = readInputFile.getInputContent(inputPath);
		
		ArrayList<ContestParticipant> countedPoints = countPoints(fileContent);
		
		generateXml.generateFile(countedPoints, outputPath);
		
	}

	public ArrayList<ContestParticipant> countPoints(List<String> fileContent) {
				return countPoints.countScore(fileContent);

	}

}
