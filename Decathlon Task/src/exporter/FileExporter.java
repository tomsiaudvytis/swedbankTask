package exporter;

public class FileExporter {
	
	IExportable export;

	public void FireSelectedExport(String inputPath, String outputPath){
		export.doExport(inputPath, outputPath);
	}
	
	public FileExporter(IExportable exportType){
		
		export = exportType;
	}
}
