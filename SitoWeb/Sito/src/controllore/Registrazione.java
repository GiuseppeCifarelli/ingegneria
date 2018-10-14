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
		String nome = request.getParameter("Nome");
		String cognome = request.getParameter("Cognome");
		String dataNascita = request.getParameter("DataNascita");
		String paeseNascita = request.getParameter("PaeseNatale");
		String comuneNascita = request.getParameter("ComuneNatale");
		String indirizzo = request.getParameter("Indirizzo");
		String username = request.getParameter("Username");
		String password = request.getParameter("Password");
		String email = request.getParameter("Email");
		String cellulare = request.getParameter("Cellulare");
		
		if(nome.equals("") || cognome.equals("") || dataNascita.equals("") || paeseNascita.equals("") || comuneNascita.equals("") || indirizzo.equals("") || username.equals("") || password.equals("") || cellulare.equals("") || email.equals("")) {
			System.out.println("nome is null");
			RequestDispatcher rd = request.getRequestDispatcher("CampiFormRegistrazioneVuoti.html");
	 		rd.forward(request, response);
		}else {
				System.out.println("nome = " + nome);
				//connessione al server
				InetAddress addr;
				//String jspFile = null;
				addr = InetAddress.getByName(null);
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
				 	}catch (UnknownHostException e) {
				 		System.err.println("Errore di connessione all'host : "+ addr);
				 		System.exit(1);
				 	}catch (IOException e) {
				 		System.err.println("Errore di ricezione/invio all'host : " + addr);
				 		System.exit(1);
				 	}
				 	while(!in.readLine().equals("ok"));
				 	outServer.close();//chiudo la connessione con il server in scrittura
				 	in.close();//chiudo la connessione con il servet in lettura
				 	socket.close();//chiudo la socket
				 	RequestDispatcher rd = request.getRequestDispatcher("okRegistrazione.html");
			 		rd.forward(request, response);
			}
	}

}
