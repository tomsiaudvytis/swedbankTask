package controller;

import exporter.FileExporter;


public class StartProgram {

	public static void main(String args[]) {
		String inputFile = args[0];
		String outputFile = args[1];
		
		FileExporter fileExporter = new FileExporter(new exportTxtToXml());
		fileExporter.FireSelectedExport(inputFile, outputFile);
		
		
	}

}
