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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registrazione
 */
@WebServlet("/Registrazione")
public class Registrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registrazione() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		boolean done = effettuaRegistrazione( request.getParameter("Nome"), request.getParameter("Cognome"), request.getParameter("DataNascita"), request.getParameter("PaeseNatale"), request.getParameter("ComuneNatale"), request.getParameter("Indirizzo"), request.getParameter("Username"), request.getParameter("Password"), request.getParameter("Email"), request.getParameter("Cellulare"));
		if(done) rd = request.getRequestDispatcher("okRegistrazione.html");
		else rd = request.getRequestDispatcher("ErroreRegistrazione.html");
		rd.forward(request, response);
	}
	
	public boolean effettuaRegistrazione(String nome, String cognome, String dataNascita, String paeseNascita, String comuneNascita, String indirizzo, 
			String username, String password, String email, String cellulare) {
		/*if(nome.equals("") || cognome.equals("") || dataNascita.equals("") || paeseNascita.equals("") || comuneNascita.equals("") || indirizzo.equals("") || username.equals("") || password.equals("") || cellulare.equals("") || email.equals("")) {
	 		return false;
		}else {*/
			if(!controlloFormattazione(nome) || !controlloFormattazione(cognome) || !controlloFormattazione(dataNascita) || !controlloFormattazione(paeseNascita)) {System.out.println("1");return false;}
			if(!controlloFormattazione(comuneNascita) || !controlloFormattazioneConNumeri(indirizzo) || !controlloFormattazioneConNumeri(username) || !controlloFormattazioneConNumeri(password)) {System.out.println("2");return false;}
			if(!controlloFormattazioneConNumeri(email) || !controlloNumero(cellulare)) {System.out.println("3");return false;}
			//if() {}
				//connessione al server
				InetAddress addr = null;
				//String jspFile = null;
				try {
					addr = InetAddress.getByName(null);
				} catch (UnknownHostException e1) {
					System.out.println("errore connessione socket...");
				}
				Socket socket=null;
				BufferedReader in=null;
				PrintWriter outServer=null; //comunicare con il server
				try {
					 // creazione socket
					 socket = new Socket(addr, 8081); //connessione al server java
					 // creazione stream di input da socket
					 InputStreamReader isr = new InputStreamReader( socket.getInputStream());
					 in = new BufferedReader(isr);
					 // creazione stream di output su socket
					 OutputStreamWriter osw = new OutputStreamWriter( socket.getOutputStream());
					 BufferedWriter bw = new BufferedWriter(osw);
					 outServer = new PrintWriter(bw, true);
					 		
					 	//specifico sito
						outServer.println("Sito");
						while(!(in.readLine().equals("ok")));
						//scelta operazione
						//quindi scegliamo la ricerca per effettuare il login dell'utente
						outServer.println("1");
						//quindi aspettiamo l'ok
						while(!(in.readLine().equals("ok")));
						//devo passare prima la data per farla processare al server
						outServer.println(dataNascita);
						//passo tutto il resto dei parametri
						//nome,cognome,username,password,data,cellulare,paeseNascita,comuneNascita,indirizzo,email
						outServer.println(nome);
						outServer.println(cognome);
						outServer.println(username);
						outServer.println(password);
						outServer.println(cellulare);
						outServer.println(paeseNascita);
						outServer.println(comuneNascita);
						outServer.println(indirizzo);
						outServer.println(email);
					 	while(!in.readLine().equals("ok"));
				 	}catch (UnknownHostException e) {
				 		System.err.println("Errore di connessione all'host : "+ addr);
				 		System.exit(1);
				 	}catch (IOException e) {
				 		System.err.println("Errore di ricezione/invio all'host : " + addr);
				 		System.exit(1);
				 	}
				 	
				 	try {
				 		outServer.close();//chiudo la connessione con il server in scrittura
						in.close();
					 	socket.close();//chiudo la socket
					} catch (IOException e) {
						System.out.println("errore chiusura socket...");
					}//chiudo la connessione con il servet in lettura
				 	return true;
				 	}
		//}
	
	public boolean controlloFormattazione(String input) {
		if(input == null) return false;
		boolean ret = false;
		if(input.equals("") || input.contains("#") || input.contains("\\") || input.contains("SELECT") || input.contains("AND") || input.contains("OR") || input.contains("NOT") || input.contains(".") || input.matches("[0-9]")) ret = false;
		else ret = true;
		return ret;
	}
	public boolean controlloFormattazioneConNumeri(String input) {
		if(input == null) return false;
		boolean ret = false;
		if(input.equals("") || input.contains("#") || input.contains("\\") || input.contains("SELECT") || input.contains("AND") || input.contains("OR") || input.contains("NOT")) ret = false;
		else ret = true;
		return ret;
	}
	public boolean controlloNumero(String input) {
		if(input == null) return false;
		boolean ret = true;
		if(input.equals("") || input.length() > 10 || input.length() < 10) ret = false;
		else {
			for(int i=0; i < input.length(); i++) if(java.lang.Character.isLetter(input.charAt(i))) ret = false;
		}
		return ret;
	}

}
