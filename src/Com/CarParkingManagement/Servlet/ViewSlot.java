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

@WebServlet("/ViewSlot")
public class ViewSlot extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int slot= Integer.parseInt(request.getParameter("view"));
		
		ArrayList<Integer>list=new ArrayList<>();
		 list.add(slot);
		int  	iSlotInEachFloor;
		try {
			 Connection conn=DataBaseConnection.openConnection();
	 			
				PreparedStatement preparedStatement1=conn.prepareStatement("SELECT * FROM  parkingslot WHERE NoOfFloor='"+slot+"'");
				
					  ResultSet rs=preparedStatement1.executeQuery();
					  while(rs.next())
					  {
							iSlotInEachFloor= rs.getInt(3);
						  list.add(	iSlotInEachFloor);
						  
						
					  }
					  request.setAttribute("data", list);
					  RequestDispatcher rd = 
					             request.getRequestDispatcher("SlotView.jsp");
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

	
	
	
	//		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			int slot= Integer.parseInt(request.getParameter("view"));
//			
//			ArrayList<Integer>list=new ArrayList<>();
//			 list.add(slot);
//			int  str;
//			try {
//				 Connection conn=DataBaseConnection.openConnection();
//		 			String Query1="SELECT * FROM  parkingslot WHERE NoOfFloor='"+slot+"'";
//					PreparedStatement preparedStatement1=conn.prepareStatement(Query1);
//					
//						  ResultSet rs=preparedStatement1.executeQuery();
//						  while(rs.next())
//						  {
//							  str= rs.getInt(3);
//							  list.add(str);
//							  System.out.println(str);
//							
//						  }
//						  request.setAttribute("data", list);
//						  RequestDispatcher rd = 
//						             request.getRequestDispatcher("SlotView.jsp");
//						  rd.forward(request, response);
//						
//			}
//			catch(Exception e)
//			{
//				e.printStackTrace();
//			}
//			finally {
//				DataBaseConnection.DbCOnnectioinClose();
//			}
//			
//	}
//
//}
