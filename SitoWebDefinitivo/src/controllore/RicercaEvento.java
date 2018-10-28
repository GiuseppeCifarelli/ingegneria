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
		LinkedList<Eventi> result = Search(request.getParameter("search"));
		for(Eventi i : result) System.out.println(i.getNome());
		request.setAttribute("risultatoRicerca", result);
		RequestDispatcher rd;
		if(result == null) rd = request.getRequestDispatcher("ErroreRicerca.html");
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
	
	public LinkedList<Eventi> Search(String ricerca) {
		if(controlloForm(ricerca)) return null;
		LinkedList<Eventi> result = new LinkedList<>();
		Eventi evento = null;
		//connessione al server
			InetAddress addr = null;
			try {
				addr = InetAddress.getByName(null);
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Socket socket=null;
			BufferedReader in=null;
			PrintWriter outServer=null; //comunicare con il server
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
						evento = new Eventi();
						evento.setCodice(Integer.parseInt(in.readLine())); //codice dello spettacolo
						evento.setNome(in.readLine()); //titolo spettacolo
						evento.setDescr(in.readLine()); //descrizione
						evento.setCitta(in.readLine()); //citta
						evento.setData(Date.valueOf(in.readLine())); //data
						evento.setPrezzo(Double.parseDouble(in.readLine())); //prezzo
						evento.setBiglietti(Integer.parseInt(in.readLine())); //biglietti
						evento.setNomeImmagine(in.readLine()); //locandina spettacolo
						System.out.println(evento.getNome());
						result.add(evento);
						//codice = in.readLine();
						//titoloEvento = in.readLine();
						//descrizione = in.readLine();
						//citta = in.readLine();
						//data = in.readLine();
						//prezzo = in.readLine();
						//biglietti = in.readLine();
						//pathImage = in.readLine();
					}
					System.out.println(result.size());
			 	}catch (UnknownHostException e) {
			 		System.err.println("Don’t know about host "+ addr);
			 		System.exit(1);
			 	}catch (IOException e) {
			 		System.err.println("Couldn’t get I/O for the connection to: " + addr);
			 		System.exit(1);
			 	}
			 	outServer.close();//chiudo la connessione con il server in scrittura
			 	try {
					in.close();
					socket.close();//chiudo la socket
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//chiudo la connessione con il servet in lettura
			 	if(result.size() == 0) return null;
		return result;
	}
	
	public boolean controlloForm(String form) {
		return form.contains("#") || form.contains("\\") || form.contains("SELECT") || form.equals("");
	}

}
