package it.polito.tdp.bar;

public class TestRandomization {

	public static void main(String[] args) {

		Randomization r = new Randomization();
		
		int numRandom = r.GeneraNumeroDa1a10();
		
		System.out.println(String.format("numero  generato tra 1 a 10: %d\n", numRandom));
		
		
		
	int numRandom1 = r.GeneraNumeroTraIntervallo();
		
	System.out.println(String.format("numero random generato tra 60 a 120: %d\n", numRandom1));
	
	
	int min = 30;
	int max = 40;
	int numRandom2 = r.GeneraNumeroTraIntervallo(min, max);
	
	System.out.println(String.format("numero random generato tra %d e %d: %d\n", min, max, numRandom2));
	
	
	float numRandom3 = r.GeneraTolleranza();
	System.out.println(String.format("numero random generato tra 0.1 e 0.9: %g \n", numRandom3));
	
	}
	
	

}
