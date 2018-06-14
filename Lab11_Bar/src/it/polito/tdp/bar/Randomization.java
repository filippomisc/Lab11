package it.polito.tdp.bar;

import java.util.Random;

public class Randomization {
	
	Random random = new Random();
	
	

	public Randomization() {

		random = new Random();
	}



	/**
	 * genera un numero intero da 1 a 10
	 * @return numero intero da 1 a 10
	 */
	public int GeneraNumeroDa1a10() {
		
		int num = (int) (random.nextFloat()*10)+1;
//		int num = (int) (Math.random()*10)+1;
		
		return num;
	}
	
	/**
	 * genera un numero intero da 60 a 120
	 * @return num int da 60 a 120
	 */
	public int GeneraNumeroTraIntervallo() {
		int min = 60;
		int max = 120;
		int num = ((max-min)+1);
		
		int result = random.nextInt(num) + min;
		
		return result;
	}
	
	/**
	 * genera un numero tra un intervallo scelto (estremi inclusi) 
	 * @param min valore minimo
	 * @param max valore massimo
	 * @return valore casuale tra min e max
	 */
	public int GeneraNumeroTraIntervallo(int min, int max) {

		int num = ((max-min)+1);
		
		int result = random.nextInt(num) + min;
		
		
		return result;
	}
	
	public float GeneraTolleranza() {
		int min = 1;
		int max = 9;
		
		int num = ((max-min)+1);
		
		float result= (float) ((random.nextInt(num)+ min)*0.1);
		
		return result;
		
		
		
		
				
		
	}
}
