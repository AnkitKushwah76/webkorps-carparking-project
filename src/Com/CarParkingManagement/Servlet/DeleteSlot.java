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

import Com.DataBaseConnectivity.DataBaseConnection;

@WebServlet("/DeleteSlot")
public class DeleteSlot extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int value= Integer.parseInt(request.getParameter("delete"));
		System.out.println("value--->"+value);

		int iSlotInEachFloor = 0,BookSlotId=0;
		try {
              
			Connection conn=DataBaseConnection.openConnection();
			
			PreparedStatement preparedStatement1=conn.prepareStatement("SELECT * FROM  parkingslot WHERE NoOfFloor='"+value+"'");		
				  ResultSet rs1=preparedStatement1.executeQuery();
				  while(rs1.next())
				  {
					  
					  iSlotInEachFloor	=rs1.getInt(3);
				  } 
				  System.out.println("str-vvcvcvvcvcvc---->"+iSlotInEachFloor);
			
				 
				
				  PreparedStatement  preparedStatement2=conn.prepareStatement("update  parkingslot set iSlotInEachFloor='"+ --iSlotInEachFloor+"' where NoOfFloor='"+value+"'");
				   
				    PreparedStatement preparedStatement3=conn.prepareStatement("select*from bookslot where NoOfFloor='"+value+"'");		
					  ResultSet rs3=preparedStatement3.executeQuery();
					  while(rs3.next())
					  {
						  BookSlotId=rs3.getInt(1); 
					  }
				    
					 
					  PreparedStatement  preparedStatement4=conn.prepareStatement("DELETE FROM bookslot WHERE BookSlotId='"+BookSlotId+"'");
					    preparedStatement4.executeUpdate();
					  
				    
				    
  					if(preparedStatement2.executeUpdate()>0) {response.sendRedirect("AdminProfile.jsp");}
  	  	    		else response.sendRedirect("ViewSlot");
				  
				 
			
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

		
		
		
		
		
		
		
		
		
		
		
		//		int value= Integer.parseInt(request.getParameter("delete"));
//		int str = 0,i=0,BookSlotId=0;
//		try {
//              System.out.println("value--->"+value);
//			Connection conn=DataBaseConnection.openConnection();
//			String Query="SELECT * FROM  parkingslot WHERE NoOfFloor='"+value+"'";
//			PreparedStatement preparedStatement1=conn.prepareStatement(Query);		
//				  ResultSet rs1=preparedStatement1.executeQuery();
//				  while(rs1.next())
//				  {
//					  str= rs1.getInt(3);
//				  } 
//				  System.out.println("str-vvcvcvvcvcvc---->"+str);
//				i= --str;
//				 System.out.println("ankit kushwah->"+i);
//				  String dml = "update  parkingslot set iSlotInEachFloor='"+i+"' where NoOfFloor='"+value+"'";
//				  PreparedStatement  preparedStatement2=conn.prepareStatement(dml);
//				    int insertResponse=preparedStatement2.executeUpdate();
//				    
//				    String dml1="select*from bookslot where NoOfFloor='"+value+"'";
//				    PreparedStatement preparedStatement3=conn.prepareStatement(dml1);		
//					  ResultSet rs3=preparedStatement3.executeQuery();
//					  while(rs3.next())
//					  {
//						  BookSlotId=rs3.getInt(1); 
//					  }
//				    
//					  String delete="DELETE FROM bookslot WHERE BookSlotId='"+BookSlotId+"'";
//					  
//					  PreparedStatement  preparedStatement4=conn.prepareStatement(delete);
//					    preparedStatement4.executeUpdate();
//					  
//				     System.out.println("BookSlotId---"+BookSlotId);
//				    
//  					if(insertResponse>0) {response.sendRedirect("AdminProfile.jsp");}
//  	  	    		else response.sendRedirect("ViewSlot");
//				  
//				  System.out.println("ankit kushwah->"+str);
//			
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		finally {
//			DataBaseConnection.DbCOnnectioinClose();
//		}
//		
//		
//	}
//
//}
