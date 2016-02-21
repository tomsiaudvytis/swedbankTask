package readfile;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReadFromInputFile {

	private List<String> inputContent;
	
	public List<String> getInputContent(String filePath) {
		
		inputContent = new ArrayList<String>();
		try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {

			inputContent = br.lines().collect(Collectors.toList());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputContent;
	}

}
