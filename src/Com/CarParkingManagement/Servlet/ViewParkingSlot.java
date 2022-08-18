package Com.CarParkingManagement.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Com.DataBaseConnectivity.DataBaseConnection;

@WebServlet("/ViewParkingSlot")
public class ViewParkingSlot extends HttpServlet {
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int 	NoOfFloor;
		ArrayList<Integer>list=new ArrayList<>();
		 try {
         	 Connection conn=DataBaseConnection.openConnection();
			PreparedStatement preparedStatement1=conn.prepareStatement("select * from parkingslot ");
			
				  ResultSet rs=preparedStatement1.executeQuery();
				  while(rs.next())
				  {
						NoOfFloor= rs.getInt(2);
					  list.add(	NoOfFloor);
					 
					
				  }
				  request.setAttribute("data", list);
				  RequestDispatcher rd = 
				             request.getRequestDispatcher("ViewParkingSlot.jsp");
				  rd.forward(request, response);
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally {
			 DataBaseConnection.DbCOnnectioinClose();
		 }
	}

}

		
		
		//		int str;
//		ArrayList<Integer>list=new ArrayList<>();
//		 try {
//         	 Connection conn=DataBaseConnection.openConnection();
// 			String Query1="select * from parkingslot ";
//			PreparedStatement preparedStatement1=conn.prepareStatement(Query1);
//			
//				  ResultSet rs=preparedStatement1.executeQuery();
//				  while(rs.next())
//				  {
//					  str= rs.getInt(2);
//					  list.add(str);
//					 // System.out.println(str);
//					
//				  }
//				  request.setAttribute("data", list);
//				  RequestDispatcher rd = 
//				             request.getRequestDispatcher("ViewParkingSlot.jsp");
//				  rd.forward(request, response);
//		 }
//		 catch(Exception e)
//		 {
//			 e.printStackTrace();
//		 }
//		 finally {
//			 DataBaseConnection.DbCOnnectioinClose();
//		 }
//	}
//
//}
