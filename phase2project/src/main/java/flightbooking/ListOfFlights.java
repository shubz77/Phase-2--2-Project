package flightbooking;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListOfFlights
 */
@WebServlet("/ListOfFlights")
public class ListOfFlights extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String from=request.getParameter("from"); String to=request.getParameter("to");
	String departure=request.getParameter("departure");
	 
    ConnectionUtil dao = new ConnectionUtil(); List flights=dao.getAvailableFlights(from, to, departure); HttpSession session=request.getSession(); session.setAttribute("flights", flights);
	 
	try{

	} catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block e.printStackTrace();
	}
	response.sendRedirect("FlightList.jsp");
	}
}
