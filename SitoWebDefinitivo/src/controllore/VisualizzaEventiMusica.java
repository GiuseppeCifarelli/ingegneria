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
 * Servlet implementation class VisualizzaEventiMusica
 */
@WebServlet("/VisualizzaEventiMusica")
public class VisualizzaEventiMusica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaEventiMusica() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LinkedList<Eventi> lista = new LinkedList<>();
		HttpSession session = request.getSession();
		lista = (LinkedList<Eventi>) session.getAttribute("eventiMusica");
		request.setAttribute("lista", lista);
		request.setAttribute("categoria", "Musica");
		RequestDispatcher rd = request.getRequestDispatcher("catalog-page-Category.jsp");
 		rd.forward(request, response);
	}

}
