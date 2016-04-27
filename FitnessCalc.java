package simpleGA;

public class FitnessCalc{

	/* The FitnessGram™ Pacer Test is a multistage 
	 * aerobic capacity test that progressively gets 
	 * more difficult as it continues. The 20 meter 
	 * pacer test will begin in 30 seconds. Line up 
	 * at the start. The running speed starts slowly, 
	 * but gets faster each minute after you hear this 
	 * signal. [beep] A single lap should be completed 
	 * each time you hear this sound. [ding] Remember 
	 * to run in a straight line, and run as long as 
	 * possible. The second time you fail to complete 
	 * a lap before the sound, your test is over. The 
	 * test will begin on the word start. 
	 * On your mark, get ready, start.
	 */

	static byte[] solution = new byte[64];

	/* Public methods */
	//Set a candidate solution as a byte array
	public static void setSolution(byte[] newSolution) {
		solution = newSolution;
	}

	//To make it easier we can use this method to set out candidate solution
	//with string of 0's and 1's
	static void setSolution(String newSolution) {
		solution = new byte[newSolution.length()];
		//Loop through each character of our string and save it in our
		//byte array
		for (int i = 0; i < newSolution.length(); i++) {
			String character = newSolution.substring(i, i+1);
			if (character.contains("0") || character.contains("1")) {
				solution[i] = Byte.parseByte(character);
			} else {
				solution[i] = 0;
			}
		}
	}

	//Calculate individuals fittness by comparing it to our candidate solution
	static int getFitness(Individual individual) {
		int fitness = 0;
		//Loop through our individuals genes and compare them to our candidates
		for (int i = 0; i < individual.size() && i < solution.length; i++) {
			if(individual.getGene(i) == solution[i]) {
				fitness++;
			}
		}
		return fitness;
	}

	//Get optimum fitness
	static int getMaxFitness() {
		int maxFitness = solution.length;
		return maxFitness;
	}
}