package Com.CarParkingManagement.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Com.DataBaseConnectivity.DataBaseConnection;

@WebServlet("/CParkingSotPage")
public class CParkingSotPage extends HttpServlet {
   
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			int NoOfFloor=0;
			ArrayList<Integer>arraylist=new ArrayList<>();
			 try {
	         	 Connection conn=DataBaseConnection.openConnection();
	 			String Query1="select * from parkingslot ";
				PreparedStatement preparedStatement1=conn.prepareStatement(Query1);
				
					  ResultSet rs=preparedStatement1.executeQuery();
					  while(rs.next())
					  {
						  NoOfFloor= rs.getInt(2);
						  arraylist.add(NoOfFloor);
						  						
					  }
					  request.setAttribute("data", arraylist);
					  RequestDispatcher rd = 
					             request.getRequestDispatcher("CparkingSlotPage.jsp");
					  rd.forward(request, response);
			 }
			
			 catch(Exception e)
			 {
				 e.printStackTrace();
			 }
			 finally {
				 DataBaseConnection.DbCOnnectioinClose();
			 }
			 
			 
			 for(Object o:arraylist)
			 {
				 System.out.println(o);
	 
			 }
			 System.out.println("ParkingSotPage----");
	}

}
