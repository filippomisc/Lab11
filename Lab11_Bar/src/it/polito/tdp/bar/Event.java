package it.polito.tdp.bar;

import java.time.LocalTime;

public class Event implements Comparable<Event>{//immutabile, quindi solo con GET
	
	 private LocalTime time;
	 private EventType tipo;
	
	 private Gruppo gruppo;

	public Event(LocalTime ora, EventType tipo, Gruppo gruppo) {
		this.time = ora;
		this.tipo = tipo;
		this.gruppo = gruppo;
	}

	public LocalTime getTime() {
		return time;
	}

	public EventType getTipo() {
		return tipo;
	}

	public Gruppo getGruppo() {
		return gruppo;
	}

	@Override
	public int compareTo(Event o) {
		//i tempi sono ordinati per tempo crescente
		return this.time.compareTo(o.getTime());
	}
	
	


}
