package it.polito.tdp.bar;

public class TestSimulation {

	public static void main(String[] args) {

		Simulatore simulatore = new Simulatore();
		
		simulatore.init();
		simulatore.run();
		
		System.out.println("clienti totali: " + simulatore.getNumero_totale_clienti());
		System.out.println("clienti soddisfatti: " + simulatore.getNumero_clienti_soddisfatti());
		System.out.println("clienti insoddisfatti : "+simulatore.getNumero_clienti_insoddisfatti());

	}

}
