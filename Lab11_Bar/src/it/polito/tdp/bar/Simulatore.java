package it.polito.tdp.bar;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


public class Simulatore {
	
	//parametri
	private int N_gruppi = 2000;
	private int T_ARRIVAL = (int)(Math.random()*10);//intervallod i tempo di arrivo da 1 a 10 minuti
	private LocalTime T_inizio = LocalTime.of(9, 0);
	private LocalTime T_fine = LocalTime.of(24, 0);
	
	
	//modello del mondo
	List<Gruppo> gruppi;
	Map<Integer, Tavolo> tavoli = new HashMap<>();
	
	
	//valori in output
	private int numero_totale_clienti;
	private int numero_clienti_soddisfatti;
	private int numero_clienti_insoddisfatti;
	
	
	//coda degli eventi
	PriorityQueue<Event> eventList = new PriorityQueue<>();
	LocalTime ora = T_inizio;
	
	
	
	/**
	 * metodo che prepara la coda degli eventi 
	 * generando la lista di gruppi
	 */
	public void init() {
		
//		Randomization random = new Randomization();
		this.gruppi = new ArrayList<>();
		
		for(int i=0; i<N_gruppi; i++) {
			
			Gruppo g = new Gruppo(i+1, StatoGruppo.NEW);
			Event event = new Event(ora, EventType.ARRIVO_GRUPPO_CLIENTI, g);
			ora.plusMinutes(T_ARRIVAL);
//			queque.add(e);
		
		}	
		
		preparaTavoli();
		
		numero_clienti_insoddisfatti = 0;
		numero_clienti_soddisfatti = 0;
		numero_totale_clienti = 0;
	}
	
	
	public void run() {
		
		Event event;
		while ((event=eventList.poll()) != null) {
			if(event.getTime().isAfter(T_fine)) {
				break;
			}
			processEvent(event);
			
		}
		
	}
	
	public void processEvent(Event event) {
		
		switch (event.getTipo()) {
		case ARRIVO_GRUPPO_CLIENTI:
			
			
			
			
			break;
		case USCITA_GRUPPO_CLIENTI:
			break;
		}
		
	}
	
	public void preparaTavoli() {
		
		tavoli.put(1, new Tavolo(1, 10, false));
		tavoli.put(2, new Tavolo(2, 10, false));
		tavoli.put(3, new Tavolo(3, 8, false));
		tavoli.put(4, new Tavolo(4, 8, false));
		tavoli.put(5, new Tavolo(5, 8, false));
		tavoli.put(6, new Tavolo(6, 8, false));
		tavoli.put(7, new Tavolo(7, 6, false));
		tavoli.put(8, new Tavolo(8, 6, false));
		tavoli.put(9, new Tavolo(9, 6, false));
		tavoli.put(10, new Tavolo(10, 6, false));
		tavoli.put(11, new Tavolo(11, 4, false));
		tavoli.put(12, new Tavolo(12, 4, false));
		tavoli.put(13, new Tavolo(13, 4, false));
		tavoli.put(14, new Tavolo(14, 4, false));
		tavoli.put(15, new Tavolo(15, 4, false));
		
		
		
	}

}

