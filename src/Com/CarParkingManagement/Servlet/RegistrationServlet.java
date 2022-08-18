package Com.CarParkingManagement.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import Com.DataBaseConnectivity.DataBaseConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.Beean.User;
@WebServlet("/Registraction")
public class RegistrationServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("userName");
		String userEmail=request.getParameter("useEmail");
		String userPassword=request.getParameter("userPassword");
		String userRole=request.getParameter("userRole");
		

		HttpSession session=request.getSession();
		User user=new User(userName,userEmail,userRole,userPassword);
		try {
			Connection conn=DataBaseConnection.openConnection();
		PreparedStatement preparedStatement=conn.prepareStatement("Insert into registration values(?,?,?,?)");
		preparedStatement.setString(1,user.getName());
		preparedStatement.setString(2,user.getEmail());
		preparedStatement.setString(3,user.getRole());
		preparedStatement.setString(4,user.getPassword());
				
		if(preparedStatement.executeUpdate()>0) {
			session=request.getSession();
			session.setAttribute("success", "Registration Successfully..");
			response.sendRedirect("registration.jsp");}
		
		else {response.sendRedirect("registration.jsp");
		
		}
		}
		catch(Exception e)
		{
			session=request.getSession();
			  session.setAttribute("userEmail","userEmail Id already exists");
			response.sendRedirect("registration.jsp");
		  e.printStackTrace();
		}
		finally {
			DataBaseConnection.DbCOnnectioinClose();
		}
		
	}

}

	
	
	
	
	
	
	
	//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String userName=request.getParameter("userName");
//		String userEmail=request.getParameter("useEmail");
//		String userPassword=request.getParameter("userPassword");
//		String userRole=request.getParameter("userRole");
//		
//
//		HttpSession session=request.getSession();
//		User user=new User(userName,userEmail,userRole,userPassword);
//		try {
//			Connection conn=DataBaseConnection.openConnection();
//		String Query="Insert into registration values(?,?,?,?)";
//		
//		
//		PreparedStatement preparedStatement=conn.prepareStatement(Query);
//		preparedStatement.setString(1,user.getName());
//		preparedStatement.setString(2,user.getEmail());
//		preparedStatement.setString(3,user.getRole());
//		preparedStatement.setString(4,user.getPassword());
//		int insertResponse=preparedStatement.executeUpdate();
//		System.out.println("insertResponse-->"+insertResponse);
//		if(insertResponse>0) {
//			session=request.getSession();
//			session.setAttribute("success", "Registration Successfully..");
//			response.sendRedirect("registration.jsp");}
//		
//		else {response.sendRedirect("registration.jsp");
//		System.out.println("hhdhhddd");
//		}
//		}
//		catch(Exception e)
//		{
//			session=request.getSession();
//			  session.setAttribute("userEmail","userEmail Id already exists");
//			response.sendRedirect("registration.jsp");
//		  e.printStackTrace();
//		}
//		finally {
//			DataBaseConnection.DbCOnnectioinClose();
//		}
//		
//	}
//
//}
