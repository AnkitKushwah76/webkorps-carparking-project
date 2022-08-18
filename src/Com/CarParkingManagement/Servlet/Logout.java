package Com.CarParkingManagement.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   HttpSession session=request.getSession();
		   
		   session.removeAttribute("userName");
			response.sendRedirect("registration.jsp");
			HttpSession session2= request.getSession();
			session2.setAttribute("logMsg","Logout Successfully...");
		
		
	}

}
