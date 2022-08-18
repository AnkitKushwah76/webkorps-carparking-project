package Com.CarParkingManagement.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.DataBaseConnectivity.DataBaseConnection;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userEmail=request.getParameter("useEmail");
		String userPassword=request.getParameter("userPassword");
		
		String userName="";
		HttpSession session=request.getSession();
		try {
			Connection conn=DataBaseConnection.openConnection();
			String Query1="select * from registration where email='"+userEmail+"'and password='"+userPassword+"'";
			PreparedStatement preparedStatement1=conn.prepareStatement(Query1);
			ResultSet rs1=preparedStatement1.executeQuery();
			while(rs1.next())
			{
				 userName=rs1.getNString(1);
			}
			session=request.getSession();
			session.setAttribute("userName",userName );
			
			System.out.println("String userName--->"+userName);
			String Query="select * from registration where email='"+userEmail+"'and password='"+userPassword+"'";
			PreparedStatement preparedStatement=conn.prepareStatement(Query);
			ResultSet rs=preparedStatement.executeQuery();
			if(rs.next()) {
				if(rs.getString(2).equals(userEmail)&& rs.getString(3).equals("Admin")&&rs.getString(4).equals(userPassword)) {
					
				
				 session=request.getSession();
					session.setAttribute("userId",userEmail);
					///session.getAttribute("userId");
					
					response.sendRedirect("AdminProfile.jsp");
				}
				else {
				 session=request.getSession();
					session.setAttribute("userId",userEmail);
					///session.getAttribute("userId");
					
					response.sendRedirect("CParkingSotPage");
				}
			}
			else {
				session.setAttribute("invalidMsg", "Invalid Email or Password");
				/* response.sendRedirect("login.jsp"); */
				response.sendRedirect("login.jsp");
			}
			
		}
      catch(Exception e)
		{
    	  e.printStackTrace();
		}
	}

}
