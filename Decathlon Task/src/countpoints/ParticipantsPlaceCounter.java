package countpoints;

import java.util.ArrayList;

public class ParticipantsPlaceCounter {
	
	public void countPlace(ArrayList<ContestParticipant> contestData){
		boolean participantHasSameScore = checkForSamePlace(contestData);
		// the messy part :)
		//if after check there is participants who has same finalScore.
		if(participantHasSameScore){
				for (int i = 0; i < contestData.size(); i++) {
					int counter = i+1;
					if(i == contestData.size() -1){
						counter = contestData.size() -1;
					}
					// if current row finalScore is equal to next row score.
					if(contestData.get(i).getData().getFinalScore().equals(contestData.get(counter).getData().getFinalScore())){
						// Set place for current row, and for the row we share score with.
						contestData.get(i).getData().setPlace(String.valueOf(i+1) + "-" + String.valueOf(i+2));
						
						//check if it's not the last row of the list, and if it shares scores with other row, 
						// if it is last row which  share score so we set score  like    'place: position - position'
						if(i != contestData.size() -1 && contestData.get(i).getData().getFinalScore().equals(contestData.get(counter).getData().getFinalScore())){
							contestData.get(counter).getData().setPlace(String.valueOf(i+1) + "-" + String.valueOf(i+2));
							// if it is last row which isn't sharing any score with the previuos row, so we set score  like    'place: position'
						}else{
							//regular, if not sharing same score with other rows
							contestData.get(counter).getData().setPlace(String.valueOf(i+1));	
						}
						i++;
						}else{
							
							contestData.get(i).getData().setPlace(String.valueOf(i+1));
					}
				}
		} else{
			//regular if all list has no rows that share same score.
			for (int i = 0; i < contestData.size(); i++) {
				contestData.get(i).getData().setPlace(String.valueOf(i+1));
				}
			}
		}
	
	//check if any participant share same place
	public boolean checkForSamePlace(ArrayList<ContestParticipant> contestData){
		 for (int i = 0; i < contestData.size(); i++) {
	            for (int j = 0; j < contestData.size(); j++) {
	                if (contestData.get(i).getData().getFinalScore().equals(contestData.get(j).getData().getFinalScore()) && i != j) {
	                    return true;
	                }
	            }
	        }
	        return false;
	}

}
