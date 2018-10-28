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
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Clienti;
import Model.AcquistoStorico;

/**
 * Servlet implementation class StoricoUtente
 */
@WebServlet("/StoricoUtente")
public class StoricoUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoricoUtente() {
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
		LinkedList<AcquistoStorico> storico = new LinkedList<>();
		AcquistoStorico oggettoTemporaneo = new AcquistoStorico();
		String  codiceUtente = String.valueOf(client.getCodice());
		String titolo = null, tickets = null, totale = null, codiceEvento = null;
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
				
				outServer.println("8");
				while(!(in.readLine().equals("ok")));
				outServer.println(codiceUtente);//passo il codice utente al server
				String pathQRcode=null;
				while(in.readLine().equals("si")){
					oggettoTemporaneo = new AcquistoStorico();
					codiceEvento = in.readLine();
					titolo = in.readLine();
					System.out.println("codice evento : " + codiceEvento);
					tickets = in.readLine();
					totale = in.readLine();
					pathQRcode = "QRCode\\"+codiceUtente+"_"+codiceEvento+".jpg";
					oggettoTemporaneo.setCodiceEvento(Integer.parseInt(codiceEvento));
					oggettoTemporaneo.setNumeroTickets(Integer.parseInt(tickets));
					oggettoTemporaneo.setPathQRCode(pathQRcode);
					oggettoTemporaneo.setSpesaTotale(Double.parseDouble(totale));
					oggettoTemporaneo.setTitolo(titolo);
					storico.add(oggettoTemporaneo);
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
		 	request.setAttribute("storicoAcquisti", storico);
		 	RequestDispatcher rd = request.getRequestDispatcher("catalog-page-StoricoUtente.jsp");
	 		rd.forward(request, response);
	}

}
