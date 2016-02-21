package comparators;

import java.util.Comparator;

import countpoints.ContestParticipant;

public class ContestListComparator implements Comparator<ContestParticipant>{

	@Override
	public int compare(ContestParticipant o1, ContestParticipant o2) {
		return o2.getData().getFinalScore().compareTo(o1.getData().getFinalScore());
	}

	
	
	

}
