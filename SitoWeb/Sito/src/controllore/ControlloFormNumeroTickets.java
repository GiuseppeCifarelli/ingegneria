package controllore;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Eventi;

/**
 * Servlet implementation class ControlloFormNumeroTickets
 */
@WebServlet("/ControlloFormNumeroTickets")
public class ControlloFormNumeroTickets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlloFormNumeroTickets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		HttpSession session = request.getSession();
		Eventi temp = new Eventi();
		temp = (Eventi)session.getAttribute("ticketEventoAcquistare");
		if(request.getParameter("numeroTickets").equals("") || Integer.parseInt(request.getParameter("numeroTickets")) <= 0 || Integer.parseInt(request.getParameter("numeroTickets")) > temp.getBiglietti()) {
			request.setAttribute("eventoSelezionato", session.getAttribute("ticketEventoAcquistare"));
			request.setAttribute("errore", true);
			rd = request.getRequestDispatcher("product-page.jsp");
		} else {
			rd = request.getRequestDispatcher("payment-page.jsp");
			request.setAttribute("numeroTickets", request.getParameter("numeroTickets"));
		}
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
