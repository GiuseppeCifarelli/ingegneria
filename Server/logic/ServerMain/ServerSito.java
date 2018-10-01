package ServerMain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.LinkedList;
import javax.servlet.http.HttpServlet;

import DAO.AcquistoBigliettiDAO;
import DAO.ClientiDAO;
import DAO.EventiDAO;
import DAO.ImplementazioneDAO.AcquistoBigliettiDaoImplementazione;
import DAO.ImplementazioneDAO.ClientiDaoImplementazione;
import DAO.ImplementazioneDAO.EventiDaoImplementazione;
import entita.Clienti;
import entita.Eventi;
/*
 * In questa classe verranno gestite tutte le operazioni richieste dai client collegati al sito web
 */

/*
 * FORMATO MESSAGGI:
 * Il formato dei messaggi in arrivo devono rispettare rigorosamente l'ordine dei parametri 
 */

public class ServerSito extends HttpServlet {
	/**
	 *  server per gestire il sito web
	 */
	private static final long serialVersionUID = -4627644751992782518L;
	protected ServerSocket serverSocket = null;
	protected Socket clientSocket = null;
	protected Connection connessioneDB = null;
	protected AcquistoBigliettiDAO buy = new AcquistoBigliettiDaoImplementazione();
	protected ClientiDAO clientiStore = new ClientiDaoImplementazione();
	protected EventiDAO eventiStore = new EventiDaoImplementazione();
	protected BufferedReader in=null;
	protected PrintWriter out=null;
	
	
	public ServerSito(ServerSocket server, Socket client, Connection db) {
		serverSocket = server;
		clientSocket = client;
		connessioneDB = db;
	}
	
	/*
	 * Questo metodo gestisce il server per il sito
	 */
	public void EseguiServerSito() {
		InputStreamReader isr;
		String comandiSito;
		int comando;
		String avanzaRichiesta = "ok"; //variabile di servizio che mi serve per far continuare la comunicazione
		try {
			isr = new InputStreamReader(clientSocket.getInputStream());
			in = new BufferedReader(isr);
			// creazione stream di output su clientSocket
			OutputStreamWriter osw = new OutputStreamWriter(clientSocket.getOutputStream());
			BufferedWriter bw = new BufferedWriter(osw);
			out = new PrintWriter(bw, true);
			//ciclo di ricezione dal client e invio di risposta
			Clienti client = null;
				comandiSito = in.readLine();
				System.out.println("Comando richiesto dal sito: " + comandiSito);
				out.println(avanzaRichiesta);
				comando = Integer.parseInt(comandiSito);
				switch(comando) {
				case 1: RegistrazioneNuovoCliente();//ok
					break;
				case 2: AcquistoBigliettiEvento(client);
					break;
				case 3: client = LoginCliente();//ok
						if (client != null)  {
							out.println("true"); //trovata corrispondenza
							out.println(client.getCodice()); //mando il codice al client per operazioni possibili di acquisto
						}
						if(client == null) out.println( "false"); //non trovata corrispondenza, credenziali passate sono errate
					break;
				case 4: RicercaEventi();
					break;
				case 5: MostraTuttiEventi();
					break;
				case 6: RicercaEventiCategoria();
					break;
				}
				out.println(avanzaRichiesta);
			out.close();
			in.close();
			clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void RegistrazioneNuovoCliente() {
		System.out.println("Registrazione nuovo utente in corso...");
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
			LocalDate date = LocalDate.parse(in.readLine());
		System.out.println("Data ricevuta : " + date);
			//convert String to LocalDate
			clientiStore.Create(connessioneDB, in.readLine(), in.readLine(), in.readLine(), in.readLine(), date, in.readLine(), in.readLine(),in.readLine(),in.readLine(),in.readLine());
		} catch (IOException e) {
			//invio messaggio di errore al sito per mancata registrazione
			out.println("Errore");
			System.out.println("Errore invio/ricezione dati : " + e.getMessage());
		}
		//invio messaggio di conferma al sito di avvenuta registrazione con successo
		out.println("ok");
	}
	
	public Clienti LoginCliente() {
		System.out.println("Login in corso...");
		Clienti client = null; 
		try {
			String user = in.readLine();
			String paswd = in.readLine();
			if( (client = clientiStore.Research(connessioneDB, user, paswd)) != null) client.setLoggato(true);
		} catch (IOException e) {
			out.println("Errore");
			System.out.println("Errore passaggio parametri : " + e.getMessage());
		}
		return client;
	}

	public void MostraTuttiEventi() {
		LinkedList<Eventi> lista = new LinkedList<>();
		lista = eventiStore.Research(connessioneDB, "null", "null", "null", "null", null, null, 0, 0); //ritorna l'elenco completo degli eventi
		//invio al sito l'elenco completo di tutti gli eventi disponibili
		Iterator<Eventi> itr = lista.iterator();
		while(itr.hasNext()) {
			Eventi temp = itr.next();
			//mettere tutti i campi
			out.println(temp.getNome());
			out.println(temp.getDescr());
			out.println(temp.getCategoria());
			out.println(temp.getCitta());
			out.print(temp.getData());
			out.println(temp.getBiglietti());
			out.println(temp.getPrezzo());
			out.println(temp.getNomeImmagine());
		}
	}

	
	public void AcquistoBigliettiEvento(Clienti client) {
		if (client == null ) return;
		try {
			//prima lettura � il codice dell'evento che si ricaver� il sito facendo una chiamata opportuna
			String temp;
			temp = in.readLine();
			int codiceEv = Integer.parseInt(temp);
			//la seconda lettura � il numero di biglietti da prendere
			temp = in.readLine();
			int numBiglietti = Integer.parseInt(temp);
			buy.Create(connessioneDB, client.getCodice(), codiceEv, numBiglietti);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//invio messaggio di errore al sito per mancanza acquisto biglietti
			out.println("Errore");
		}
		//invio al sito di avvenuta transizione per l'acquisto dei biglietti
	}
	
	public void RicercaEventi() {
		LinkedList<Eventi> lista = new LinkedList<>();
		try {
			lista = eventiStore.Research(connessioneDB, in.readLine(), "null", "null", "null", null, null, 0, 0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			out.println("Errore");
			//e.printStackTrace();
		}
		//invio lista al sito
		Iterator<Eventi> itr = lista.iterator();
		while(itr.hasNext()) {
			Eventi temp = itr.next();
			//mettere tutti i campi
			out.println(temp.getNome());
			out.println(temp.getDescr());
			out.println(temp.getCategoria());
			out.println(temp.getCitta());
			out.print(temp.getData());
			out.println(temp.getBiglietti());
			out.println(temp.getPrezzo());
			out.println(temp.getNomeImmagine());
		}
	}
	
	public void RicercaEventiCategoria() {
		LinkedList<Eventi> lista = new LinkedList<>();
		try {
			lista = eventiStore.Research(connessioneDB, "null", "null", "null", in.readLine(), null, null, 0, 0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			out.println("Errore");
			//e.printStackTrace();
		}
		//invio lista al sito
		Iterator<Eventi> itr = lista.iterator();
		//mando solo i campi del titolo e del prezzo soltanto per effettuare delle prove
		//in seguito aggiunger� anche gli altri campi
		while(itr.hasNext()) {
			out.println("si"); //indico al client che ci sono eventi da ricevere
			Eventi temp = itr.next();
			out.println(temp.getCodice()); //mando il codice dello spettacolo
			out.println(temp.getNome()); //mando il titolo dello spettacolo
			out.println(temp.getDescr()); //mando la descrizione dello spettacolo
			out.println(temp.getCitta()); //mando la citta dove si terr� lo spettacolo
			out.println(temp.getData()); //mando la data dello spettacolo
			out.println(temp.getPrezzo()); //mando il prezzo del biglietto per lo spettacolo
			out.println(temp.getBiglietti()); //mando i biglietti ancora disponibili per lo spettacolo
			out.println(temp.getNomeImmagine()); //mando il path dell'immagine
		}
	}
	
}
