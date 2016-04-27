package simpleGA;

public class GA {

	public static void main(String[] args){
		//Set the desired solution
		FitnessCalc.setSolution("1111000000000000000000000000000000000000000000000000000000001111");

		//Create an inidial population
		Population myPop = new Population(50, true);

		//Evolve population to desired solution
		int generationCount = 0;
		while(myPop.getFittest().getFitness() < FitnessCalc.getMaxFitness()) {
			generationCount++;
			System.out.println("Generation: "+generationCount+" Fittest: "+myPop.getFittest().getFitness());
			myPop = Algorithm.evolvePopulation(myPop);
		}
		System.out.println("Solution found!");
		System.out.println("Generation: "+generationCount);
		System.out.println("Genes:");
		System.out.println(myPop.getFittest());
	}
}