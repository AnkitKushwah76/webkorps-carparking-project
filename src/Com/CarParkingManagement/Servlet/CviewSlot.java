package Com.CarParkingManagement.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.DataBaseConnectivity.DataBaseConnection;


@WebServlet("/CparkingSlot")
public class CviewSlot extends HttpServlet {
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                int slot= Integer.parseInt(request.getParameter("CView"));
			
			HttpSession session1=request.getSession();
			session1.setAttribute("FloorId",slot);
			  HashMap<Integer,String> map=new HashMap<Integer,String>();
			 System.out.println("floor number--->"+slot);
			
			// list.add(slot);
			int  SlotInEachFloor = 0;
			String 	Status="";
			try {
				 Connection conn=DataBaseConnection.openConnection();				 
				 HttpSession session=request.getSession();
					//session.setAttribute("userId",userEmail);
					String invalidMsg = (String) session.getAttribute("userId");
					
					PreparedStatement preparedStatement1=conn.prepareStatement("SELECT * FROM  bookslot WHERE NoOfFloor='"+slot+"'");
					
						  ResultSet rs=preparedStatement1.executeQuery();
						  while(rs.next())
						  {
							  SlotInEachFloor= rs.getInt(3);
								Status=rs.getString(4);
			                map.put(SlotInEachFloor,	Status);
							
						  }
						  
						 
						  for(Entry<Integer, String> m : map.entrySet()){    
							    System.out.println(m.getKey()+" "+m.getValue());    
						  }
						
				  request.setAttribute("data", map);
						  RequestDispatcher rd = 
						             request.getRequestDispatcher("CslotView.jsp");
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
		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			//int slot= Integer.parseInt(request.getParameter("CView"));
//			
//			HttpSession session1=request.getSession();
//			session1.setAttribute("FloorId",slot);
//			  HashMap<Integer,String> map=new HashMap<Integer,String>();
//			 System.out.println("floor number--->"+slot);
//			
//			// list.add(slot);
//			int  str = 0;
//			String str1="";
//			try {
//				 Connection conn=DataBaseConnection.openConnection();
////				 String Query2="SELECT * FROM  bookslot WHERE NoOfFloor='"+slot+"'";
////					PreparedStatement preparedStatement2=conn.prepareStatement(Query2);
////					
////						  ResultSet rs1=preparedStatement2.executeQuery(); 
////						  while(rs1.next())
////						  {
////							  BookSlotId=rs1.getInt(1);
////							  break;
////						  }
////						  System.out.println("BookSlotId---->>"+BookSlotId);
//				 HttpSession session=request.getSession();
//					//session.setAttribute("userId",userEmail);
//					String invalidMsg = (String) session.getAttribute("userId");
//					if (invalidMsg != null) {
//						System.out.println("email--->"+invalidMsg);
//					}
//								 
//		 			String Query1="SELECT * FROM  bookslot WHERE NoOfFloor='"+slot+"'";
//					PreparedStatement preparedStatement1=conn.prepareStatement(Query1);
//					
//						  ResultSet rs=preparedStatement1.executeQuery();
//						  while(rs.next())
//						  {
//							  str= rs.getInt(3);
//							 str1=rs.getString(4);
//			                map.put(str,str1);
//							
//						  }
//						  
//						 
//						  for(Entry<Integer, String> m : map.entrySet()){    
//							    System.out.println(m.getKey()+" "+m.getValue());    
//						  }
//						
//						  System.out.println("Cview----->>>>"+  str);
//				  request.setAttribute("data", map);
//						  RequestDispatcher rd = 
//						             request.getRequestDispatcher("CslotView.jsp");
//						  rd.forward(request, response);
//						  
//	     }
//			catch(Exception e)
//			{
//				e.printStackTrace();
//			}
//			finally {
//				DataBaseConnection.DbCOnnectioinClose();
//			}
//
//}
//}
