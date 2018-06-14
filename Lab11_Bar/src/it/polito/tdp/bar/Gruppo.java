package it.polito.tdp.bar;

import java.time.LocalTime;

public class Gruppo {
	
	private int id;
	private StatoGruppo stato;
	private int numPersone;
	private double tolleranza;
	private int permanenza;
	Randomization random = new Randomization();
	
	
	public Gruppo(int id, StatoGruppo stato) {
		this.id = id;
		this.stato = stato;
		this.numPersone = random.GeneraNumeroDa1a10();//random.GeneraNumeroTraIntervallo(1, 10);
		this.tolleranza = random.GeneraTolleranza();
		this.permanenza = random.GeneraNumeroTraIntervallo(60, 120);
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public StatoGruppo getStato() {
		return stato;
	}


	public void setStato(StatoGruppo stato) {
		this.stato = stato;
	}


	public int getNumPersone() {
		return numPersone;
	}


	public void setNumPersone(int numPersone) {
		this.numPersone = numPersone;
	}


	public double getTolleranza() {
		return tolleranza;
	}


	public void setTolleranza(double tolleranza) {
		this.tolleranza = tolleranza;
	}


	public int getPermanenza() {
		return permanenza;
	}


	public void setPermanenza(int permanenza) {
		this.permanenza = permanenza;
	}

	
	
	
	
	

}
