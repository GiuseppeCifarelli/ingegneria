package controllore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Date;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Eventi;

/**
 * Servlet implementation class ListaEventi2
 */
@WebServlet("/ListaEventi2")
public class ListaEventi2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaEventi2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//connessione al server
				InetAddress addr;
				addr = InetAddress.getByName(null);
				Socket socket=null;
				BufferedReader in=null;
				PrintWriter outServer=null; //comunicare con il server
				String categoria = "null", titoloEvento = null, codice = null, pathImage = null, descrizione = null, citta = null, data = null, prezzo = null, biglietti = null;
				LinkedList<Eventi> listaSport = new LinkedList<>(), 
						listaMusica = new LinkedList<>(), 
						listaSpettacolo = new LinkedList<>();
				
				try {
					 // creazione socket
					 socket = new Socket(addr, 8081); //connessione al server java
					 // creazione stream di input da socket
					 InputStreamReader isr = new InputStreamReader( socket.getInputStream());
					 in = new BufferedReader(isr); //canale di comunicazione con il server in lettura
					 // creazione stream di output su socket
					 OutputStreamWriter osw = new OutputStreamWriter( socket.getOutputStream());
					 BufferedWriter bw = new BufferedWriter(osw);
					 outServer = new PrintWriter(bw, true); //canale di comunicazione in scrittura con il server	 		
					 //specifico sito
					outServer.println("Sito");
					while(!(in.readLine().equals("ok")));
						//scelta operazione
						//quindi scegliamo la ricerca degli eventi nella categoria sport
						outServer.println("5");
						while(!(in.readLine().equals("ok")));
						//stampo la tabella con i risultati
						//il server mi manda 'si' perchè sta ad indicare che ci sono eventi da ricevere ancora
						
						Eventi temp = null;
						while(in.readLine().equals("si")){
							temp = new Eventi();
							categoria = in.readLine();//categoria dell'evento
							codice = in.readLine(); //codice dello spettacolo
							titoloEvento = in.readLine(); //titolo spettacolo
							descrizione = in.readLine(); //descrizione
							citta = in.readLine(); //citta
							data = in.readLine(); //data
							prezzo = in.readLine(); //prezzo
							biglietti = in.readLine(); //biglietti
							pathImage = in.readLine(); //locandina spettacolo
							System.out.println("Nome evento : " + titoloEvento);
							temp.setCodice(Integer.parseInt(codice));
							temp.setNome(titoloEvento);
							temp.setDescr(descrizione);
							temp.setCitta(citta);
							temp.setData(Date.valueOf(data));
							temp.setPrezzo(Double.parseDouble(prezzo));
							temp.setBiglietti(Integer.parseInt(biglietti));
							temp.setNomeImmagine(pathImage);
							switch(categoria) {
							case "Sport": listaSport.add(temp);
								break;
							case "Musica": listaMusica.add(temp);
								break;
							case "Spettacolo": listaSpettacolo.add(temp);
								break;
						}
						}
					 }catch (UnknownHostException e) {
					 	System.err.println("Don’t know about host "+ addr);
					 	System.exit(1);
					 }catch (IOException e) {
					 	System.err.println("Couldn’t get I/O for the connection to: " + addr);
					 	System.exit(1);
					 }
					outServer.close();//chiudo la connessione con il server in scrittura
					in.close();//chiudo la connessione con il servet in lettura
					socket.close();//chiudo la socket
					System.out.println("Dimensione lista sport : " + listaSport.size());
					System.out.println("Dimensione lista musica : " + listaMusica.size());
					System.out.println("Dimensione lista spettacoli : " + listaSpettacolo.size());
					HttpSession session = request.getSession();
				 	session.setAttribute("eventiSportivi", listaSport);
				 	session.setAttribute("eventiMusica", listaMusica);
				 	session.setAttribute("eventiSpettacoli", listaSpettacolo);
				 	RequestDispatcher rd = request.getRequestDispatcher("catalog-page.jsp");
			 		rd.forward(request, response);
			 		}

}


