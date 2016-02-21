package countpoints;

public class ContestParticipant {

	private double timeInSeconds;
	private SingleRowData data = new SingleRowData();

	// Constants used to calculate scores for each competition
	double[] A = new double[] { 25.4347, 0.14354, 51.39, 0.8465, 1.53775,5.74352, 12.91, 0.2797, 10.14, 0.03768 };
	double[] B = new double[] { 18, 220, 1.5, 75, 82, 28.5, 4, 100, 7, 480 };
	double[] C = new double[] { 1.81, 1.4, 1.05, 1.42, 1.81, 1.92, 1.1, 1.35,1.08, 1.85 };

	public ContestParticipant(String participantScores) {
		data.setParticipantScores(participantScores);
		String[] participantScoreSplited = participantScores.split(";");
		data.setFullName(participantScoreSplited[0]);
		calculateScores(participantScoreSplited);

	}

	// Counts points for every single competition and sums them for final score.
	public SingleRowData calculateScores(String[] participantsData) {
		
		//comments!
		data.setHundredMeters(A[0]* Math.pow((B[0] - Double.parseDouble(participantsData[1])),C[0]));
		data.setLongJump(A[1]* Math.pow((Double.parseDouble(participantsData[2]) * 100)- B[1], C[1]));
		data.setShot(A[2]* Math.pow((Double.parseDouble(participantsData[3])) - B[2],C[2]));
		data.setHight(A[3]* Math.pow((Double.parseDouble(participantsData[4]) * 100)- B[3], C[3]));
		data.setFourHundred(A[4]* Math.pow((B[4] - Double.parseDouble(participantsData[5])),C[4]));
		data.setHurdles(A[5]* Math.pow((B[5] - Double.parseDouble(participantsData[6])),C[5]));
		data.setDiscus(A[6]* Math.pow((Double.parseDouble(participantsData[7]) - B[6]),C[6]));
		data.setPole(A[7]* Math.pow(((Double.parseDouble(participantsData[8]) * 100) - B[7]),C[7]));
		data.setJavelin(A[8]* Math.pow((Double.parseDouble(participantsData[9]) - B[8]),C[8]));

		this.timeInSeconds = convertTimeToSeconds(participantsData[10]);
		data.setTousandFiveHunRun(A[9]* Math.pow((B[9] - timeInSeconds),C[9]));
		
		data.setFinalScore((int) (data.getHundredMeters() + data.getLongJump() + data.getShot() + data.getHight() 
						 + data.getFourHundred() + data.getHurdles() + data.getDiscus() + data.getPole() + data.getJavelin() 
						 + data.getTousandFiveHunRun()));
		return data;
		
	}

	private Double convertTimeToSeconds(String participantsData) {
		// converting time to seconds
		String[] units = participantsData.split("\\.");
		Integer minutes = Integer.parseInt(units[0]);
		Integer seconds = Integer.parseInt(units[1]);
		Integer miliseconds = Integer.parseInt(units[2]);
		Double duration = (double) ((60 * minutes) + seconds + (0.01 * miliseconds));
		return duration;

	}


	public double getTimeInSeconds() {
		return timeInSeconds;
	}

	public SingleRowData getData() {
		return data;
	}
}
