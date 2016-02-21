package controller;

import java.io.FileNotFoundException;

import javax.xml.transform.TransformerException;

import exporter.IExportable;

public class exportTxtToXml implements IExportable {

	@Override
	public void doExport(String inputFile, String outputFile) {
		
		InitFile initFile = new InitFile();
		try {
			initFile.ReadFileAndCountPoints(inputFile, outputFile);
		} catch (FileNotFoundException | TransformerException e) {
			e.printStackTrace();
		}
	
	}

}
