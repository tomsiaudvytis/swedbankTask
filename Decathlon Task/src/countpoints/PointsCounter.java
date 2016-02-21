package countpoints;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import test.TestInputData;
import comparators.ContestListComparator;

public class PointsCounter {

	private ArrayList<ContestParticipant> contestData = new ArrayList<ContestParticipant>();

	private ParticipantsPlaceCounter placeCounter = new ParticipantsPlaceCounter();
	
	private TestInputData testInputData = new TestInputData();

	public ArrayList<ContestParticipant> countScore(List<String> fileContent) {

		//does all the points counting in ContestParticipant class
		for (int i = 0; i < fileContent.size(); i++) {
			//test will to check if list contains all  scores we need for calculation.
			testInputData.testSingleRow(fileContent.get(i).trim());
			
			
			contestData.add(new ContestParticipant(fileContent.get(i).trim()));
		}
		// Sorted list by FinalScores,  highest on top.
		Collections.sort(contestData, new ContestListComparator());
		// counts place by finalScore
		placeCounter.countPlace(contestData);
		
		//make complete list for data we need.
		List<String> sortedContestLis = new ArrayList<String>();
		for(int i = 0; i < contestData.size(); i++){
			sortedContestLis.add(contestData.get(i).getData().getParticipantScores() + 
								" |Final Score: "+contestData.get(i).getData().getFinalScore()+ 
								" |Place: " + contestData.get(i).getData().getPlace());
		}
		
		return contestData;

	}
	

	public ArrayList<ContestParticipant> getContestData() {
		return contestData;
	}
}
