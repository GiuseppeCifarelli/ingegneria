package Model;

public class AcquistoStorico {
	private int codiceEvento, numeroTickets;
	private double spesaTotale;
	private String pathQRCode, Titolo;
	public int getNumeroTickets() {
		return numeroTickets;
	}
	public void setNumeroTickets(int numeroTickets) {
		this.numeroTickets = numeroTickets;
	}
	public int getCodiceEvento() {
		return codiceEvento;
	}
	public void setCodiceEvento(int codiceEvento) {
		this.codiceEvento = codiceEvento;
	}
	public double getSpesaTotale() {
		return spesaTotale;
	}
	public void setSpesaTotale(double spesaTotale) {
		this.spesaTotale = spesaTotale;
	}
	public String getPathQRCode() {
		return pathQRCode;
	}
	public void setPathQRCode(String pathQRCode) {
		this.pathQRCode = pathQRCode;
	}
	public String getTitolo() {
		return Titolo;
	}
	public void setTitolo(String titolo) {
		Titolo = titolo;
	}
	
	
}
