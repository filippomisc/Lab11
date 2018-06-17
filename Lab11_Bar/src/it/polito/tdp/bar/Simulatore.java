package it.polito.tdp.bar;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


public class Simulatore {
	
	//parametri
	private int N_gruppi = 10;//2000
	private int T_ARRIVAL = (int)(Math.random()*10);//intervallod i tempo di arrivo da 1 a 10 minuti
	private LocalTime T_inizio = LocalTime.of(9, 0);
	private LocalTime T_fine = LocalTime.of(23, 59);
	
	
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
			eventList.add(event);
		
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
	
	
	
	public int getNumero_totale_clienti() {
		return numero_totale_clienti;
	}


	public int getNumero_clienti_soddisfatti() {
		return numero_clienti_soddisfatti;
	}


	public int getNumero_clienti_insoddisfatti() {
		return numero_clienti_insoddisfatti;
	}


	public void processEvent(Event event) {
		
//		Tavolo tavolo = null;
		Gruppo gruppo = event.getGruppo();
		
		numero_totale_clienti+=gruppo.getNumPersone();
		
		switch (event.getTipo()) {
		case ARRIVO_GRUPPO_CLIENTI:
			Tavolo tavolo = this.controllaTavolo(gruppo.getNumPersone());
			if(tavolo!=null) {//se il tavolo è vuoto
				
				gruppo.setStato(StatoGruppo.SITTING);
				tavolo.setBusy(true);
				
				Event event2 = new Event(event.getTime().plusMinutes(gruppo.getPermanenza()), EventType.USCITA_GRUPPO_CLIENTI, gruppo);
				eventList.add(event2);
				
//				this.numero_clienti_soddisfatti+=gruppo.getNumPersone();
				
				
			}else if(gruppo.getTolleranza()>=0.5) {
				
				gruppo.setStato(StatoGruppo.STANDING);
				
				Event event3 = new Event(event.getTime().plusMinutes(gruppo.getPermanenza()), EventType.USCITA_GRUPPO_CLIENTI, gruppo);
				eventList.add(event3);
				
				this.numero_clienti_soddisfatti+=gruppo.getNumPersone(); 
				
				

				
			}else if(gruppo.getTolleranza()<0.5) {
				
				gruppo.setStato(StatoGruppo.OUT);

				Event event4 =  new Event(event.getTime(), EventType.USCITA_GRUPPO_CLIENTI, gruppo);
				eventList.add(event4);
				
				this.numero_clienti_insoddisfatti+=gruppo.getNumPersone();
			}
			break;
			
		case USCITA_GRUPPO_CLIENTI:
			
			switch (gruppo.getStato()) {
			case SITTING:
//				tavolo.setBusy(false);
				this.numero_clienti_soddisfatti+=gruppo.getNumPersone();
				break;

			case STANDING:
				this.numero_clienti_soddisfatti+=gruppo.getNumPersone(); 
				break;
			
			case OUT:
				this.numero_clienti_insoddisfatti+=gruppo.getNumPersone();
				break;
			}
			break;
		}
		
	}
	
	public void preparaTavoli() {
		tavoli.put(1, new Tavolo(1, 4, false));
		tavoli.put(2, new Tavolo(2, 4, false));
		tavoli.put(3, new Tavolo(3, 4, false));
		tavoli.put(4, new Tavolo(4, 4, false));
		tavoli.put(5, new Tavolo(5, 4, false));
		tavoli.put(6, new Tavolo(6, 6, false));
		tavoli.put(7, new Tavolo(7, 6, false));
		tavoli.put(8, new Tavolo(8, 6, false));
		tavoli.put(9, new Tavolo(9, 6, false));
		tavoli.put(10, new Tavolo(10, 8, false));
		tavoli.put(11, new Tavolo(11, 8, false));
		tavoli.put(12, new Tavolo(12, 8, false));
		tavoli.put(13, new Tavolo(13, 8, false));
		tavoli.put(14, new Tavolo(14, 10, false));	
		tavoli.put(15, new Tavolo(15, 10, false));
		
	}

	public Tavolo controllaTavolo(int numPersone) {

		for(Tavolo tavolo: tavoli.values()) {
			//controlla la disponibiltà di tutti i tavoli
			if(numPersone > (int) (0.5*tavolo.getNumeroPosti()) && numPersone < tavolo.getNumeroPosti() && tavolo.isBusy()==false) {
				return tavolo;
				
			}	
		}
		return null;
		
	}
}

