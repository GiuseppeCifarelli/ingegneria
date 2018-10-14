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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Eventi;

/**
 * Servlet implementation class RicercaEvento
 */
@WebServlet("/RicercaEvento")
public class RicercaEvento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RicercaEvento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ricerca = request.getParameter("search");
		Eventi evento = new Eventi();
		//connessione al server
			InetAddress addr;
			//String jspFile = null;
			addr = InetAddress.getByName(null);
			Socket socket=null;
			BufferedReader in=null, stdIn=null;
			PrintWriter outServer=null; //comunicare con il server
			int count = 0;
			String titoloEvento = null, codice = null, pathImage = null, descrizione = null, citta = null, data = null, prezzo = null, biglietti = null;
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
					outServer.println("4");
					while(!(in.readLine().equals("ok")));
					outServer.println(ricerca); //passo la categoria sport al server
					//il server mi manda 'si' perchè sta ad indicare che ci sono eventi da ricevere ancora
					while(in.readLine().equals("si")){
						count++;
						codice = in.readLine(); //codice dello spettacolo
						titoloEvento = in.readLine(); //titolo spettacolo
						descrizione = in.readLine(); //descrizione
						citta = in.readLine(); //citta
						data = in.readLine(); //data
						prezzo = in.readLine(); //prezzo
						biglietti = in.readLine(); //biglietti
						pathImage = in.readLine(); //locandina spettacolo
					}
					if(count > 0) {
						evento.setCodice(Integer.parseInt(codice));
						evento.setNome(titoloEvento);
						evento.setDescr(descrizione);
						evento.setCitta(citta);
						evento.setData(Date.valueOf(data));
						evento.setPrezzo(Double.parseDouble(prezzo));
						evento.setBiglietti(Integer.parseInt(biglietti));
						evento.setNomeImmagine(pathImage);
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
			 	request.setAttribute("risultatoRicerca", evento);
			 	RequestDispatcher rd;
			 	if(count == 0) rd = request.getRequestDispatcher("ErroreRicerca.html");
			 	else rd = request.getRequestDispatcher("catalog-page-ResultSearch.jsp");
		 		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
