package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestInputData {
	
	String [] splitted;
	String [] hardcodedSingleRowData = {"Name Lastname", "score1" ,"score2", "score3", "score4", "score5", "score6", "Score7", "Score8", "Score9", "Score10"};

	public void testSingleRow(String singleRowData) {

	// split single row data to array
	splitted = singleRowData.split(";");
	
	checkData();	
	}
	
	@Test
	public void checkData(){
		
		//will check if every row has all scores
		assertTrue (splitted.length == hardcodedSingleRowData.length);
	}

}
