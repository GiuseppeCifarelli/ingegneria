package controllore;

import java.io.IOException;
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
 * Servlet implementation class InfoEventi
 */
@WebServlet("/InfoEventi")
public class InfoEventi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoEventi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LinkedList<Eventi> lista = new LinkedList<>();
		String categoriaEventoSelezionato = request.getParameter("categoriaEvento");
		HttpSession session = request.getSession();
		switch(categoriaEventoSelezionato) {
		case "Sport": 
			System.out.println("sport");
			lista = (LinkedList<Eventi>) session.getAttribute("eventiSportivi");
			break;
		case "Musica": lista = (LinkedList<Eventi>) session.getAttribute("eventiMusica");
			break;
		case "Spettacolo": lista = (LinkedList<Eventi>) session.getAttribute("eventiSpettacoli");
			break;
		}
		Integer indexEventoSelezionato = Integer.parseInt(request.getParameter("eventoScelto"));
		Eventi eventoSelezionato = new Eventi();
		for(Eventi i : lista) if (i.getCodice() == indexEventoSelezionato) eventoSelezionato = i;
		request.setAttribute("eventoSelezionato", eventoSelezionato);
		RequestDispatcher rd = request.getRequestDispatcher("product-page.jsp");
 		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
