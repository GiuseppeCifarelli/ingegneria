package Model;

public class Acquisto {
	private Eventi evento;
	private int numeroTickets;
	private double prezzo;
	
	public Acquisto() {
		evento = null;
		numeroTickets = 0;
		prezzo = 0;
	}
	
	public Eventi getEvento() {
		return evento;
	}
	public void setEvento(Eventi evento) {
		this.evento = evento;
	}
	public int getNumeroTickets() {
		return numeroTickets;
	}
	public void setNumeroTickets(int numeroTickets) {
		this.numeroTickets = numeroTickets;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo() {
		this.prezzo = this.getNumeroTickets()*this.getEvento().getPrezzo();
	}
}
