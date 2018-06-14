package it.polito.tdp.bar;

public class Tavolo {
	
	private int idTavolo;
	private int numeroPosti;
	private boolean isBusy;
	
	
	public Tavolo(int idTavolo, int numeroPosti, boolean isBusy) {
		this.idTavolo = idTavolo;
		this.numeroPosti = numeroPosti;
		this.isBusy = false;
	}


	public int getIdTavolo() {
		return idTavolo;
	}


	public void setIdTavolo(int idTavolo) {
		this.idTavolo = idTavolo;
	}


	public int getNumeroPosti() {
		return numeroPosti;
	}


	public void setNumeroPosti(int numeroPosti) {
		this.numeroPosti = numeroPosti;
	}


	public boolean isBusy() {
		return isBusy;
	}


	public void setBusy(boolean isBusy) {
		this.isBusy = isBusy;
	}


	@Override
	public String toString() {
		return "Tavolo [idTavolo=" + idTavolo + ", numeroPosti=" + numeroPosti + ", isBusy=" + isBusy + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTavolo;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tavolo other = (Tavolo) obj;
		if (idTavolo != other.idTavolo)
			return false;
		return true;
	}

	
	
}
