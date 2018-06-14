package it.polito.tdp.bar;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import com.sun.xml.internal.fastinfoset.stax.events.ProcessingInstructionEvent;

public class Simulatore {
	
	//parametri
	private int N_gruppi = 2000;
	private int T_ARRIVAL = (int)(Math.random()*10);//intervallod i tempo di arrivo da 1 a 10 minuti
	private int numTavoli;
	private LocalTime T_inizio = LocalTime.of(9, 0);
	private LocalTime T_fine = LocalTime.of(24, 0);
	
	//modello del mondo
	List<Gruppo> gruppi;
	
	//valori in output
	private int numero_totale_clienti;
	private int numero_clienti_soddisfatti;
	private int numero_clienti_insoddisfatti;
	
	
	//coda degli eventi
	PriorityQueue<Event> queque = new PriorityQueue<>();
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
		
		numero_clienti_insoddisfatti = 0;
		numero_clienti_soddisfatti = 0;
		numero_totale_clienti = 0;
	}
	
	
	public void run() {
		
		Event event;
		while ((event=queque.poll()) != null) {
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
		case ASSEGNAZIONE:
			break;
		case USCITA:
			break;
		case USCITA_INSODDISFATTI:
			break;
		}
		
	}

}

