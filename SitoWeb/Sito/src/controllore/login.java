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
import javax.servlet.http.HttpSession;

import Model.Clienti;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		String paswd = request.getParameter("password");
		System.out.println("username : " + user + " password : " + paswd);
		//connessione al server
		InetAddress addr;
		//String jspFile = null;
		addr = InetAddress.getByName(null);
		Socket socket=null;
		BufferedReader in=null;
		PrintWriter outServer=null; //comunicare con il server
		String Risultato = null; //risultato della ricerca per il login dell'utente
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
				outServer.println("3");
				while(!(in.readLine().equals("ok")));
				//gli passo username e password che l'utente ha appena digitato
				outServer.println(user);//passo username al server
				outServer.println(paswd);//passo la password al server
				//ora aspetto il risultato della ricerca
				Risultato = in.readLine();
		 	}catch (UnknownHostException e) {
		 		System.err.println("Don’t know about host "+ addr);
		 		System.exit(1);
		 	}catch (IOException e) {
		 		System.err.println("Couldn’t get I/O for the connection to: " + addr);
		 		System.exit(1);
		 	}
		 	if( Risultato.equals("true")) {
		 		Clienti clienteLoggato = new Clienti();
		 		
		 		clienteLoggato.setCodice(Integer.parseInt(in.readLine())); //leggo il codice dell'utente che mi servirà per possibili operazioni future
		 		clienteLoggato.setNome(in.readLine()); //leggo il nome dell'utente appena loggato
		 		clienteLoggato.setCognome(in.readLine());
		 		clienteLoggato.setUsr(in.readLine());
		 		clienteLoggato.setPaswd(in.readLine());
		 		clienteLoggato.setCell(in.readLine());
		 		clienteLoggato.setPaeseNatale(in.readLine());
		 		clienteLoggato.setComuneNatale(in.readLine());
		 		clienteLoggato.setIndirizzo(in.readLine());
		 		clienteLoggato.setEmail(in.readLine());
		 		clienteLoggato.setNascita(Date.valueOf(in.readLine()));
		 		HttpSession session = request.getSession();
		 		session.setAttribute("client", clienteLoggato);
		 		RequestDispatcher rd = request.getRequestDispatcher("indexLog.jsp");
		 		rd.forward(request, response);
		 	}
		 	if(Risultato.equals("false")) {
		 		//utente non trovato, login non ha vauto successo
		 		RequestDispatcher rd = request.getRequestDispatcher("ErroreLogin.html");
		 		rd.forward(request, response);
		 	}
		 	outServer.close();//chiudo la connessione con il server in scrittura
		 	in.close();//chiudo la connessione con il servet in lettura
		 	socket.close();//chiudo la socket
	}

}
