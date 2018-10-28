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
import javax.servlet.http.HttpSession;

import Model.Clienti;
import Model.Eventi;

/**
 * Servlet implementation class GenerazioneTicket
 */
@WebServlet("/GenerazioneTicket")
public class GenerazioneTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerazioneTicket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Clienti client = new Clienti(); 
		client = (Clienti) session.getAttribute("client");
		Eventi evento = new Eventi();
    	evento = (Eventi) session.getAttribute("ticketEventoAcquistare");
    	
    	//prendo i parametri che mi servono
    	String codiceUtente = String.valueOf(client.getCodice());
		String codiceEvento = String.valueOf(evento.getCodice());
		String numeroBiglietti = String.valueOf(session.getAttribute("numberTicket"));
		
		System.out.println("codice evento : " + codiceEvento);
		
		//immettere il controllo sulla scadenza
		String pathQRcode = null;	
			//connessione al server
			InetAddress addr;
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
				//indico l'operazione di acquisto al server
				outServer.println("2");
				while(!(in.readLine().equals("ok")));
				//passo i codici dell'utente e dell'evento da inserire nel db, con il numero di tickets acquistati
				outServer.println(codiceUtente);
				outServer.println(codiceEvento);
				outServer.println(numeroBiglietti);
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
			//setto il path del qr code come attributo della request
			pathQRcode = "QRCode\\"+codiceUtente+"_"+codiceEvento+".jpg";
			request.setAttribute("QRCODE", pathQRcode);
			RequestDispatcher rd = request.getRequestDispatcher("VisualizzaTicket.jsp");
	 		rd.forward(request, response);	
	 		}
}
