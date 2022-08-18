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

@WebServlet("/AddParkingSlot")
public class AddParkingSlot extends HttpServlet {
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		//int update= Integer.parseInt(request.getParameter("update"));
    		int NoOfFloor=Integer.parseInt(request.getParameter("NoOfFloor"));
            int  SlotInEachFloor= Integer.parseInt( request.getParameter("SlotinEachfloor"));
         HttpSession session =request.getSession();
         boolean updateNoOfFloor=false,updatef=false;          
         try {
         	
 			Connection conn=DataBaseConnection.openConnection();
 		
 			int iSlotInEachFloor=0,totalSlotInEachFloor=0,update=0,updateslot=0;
 			
				PreparedStatement preparedStatement=conn.prepareStatement("select * from parkingslot ");
				  ResultSet rs=preparedStatement.executeQuery();
				  while(rs.next())
				  {
					  
					  
					//update  data in data base.....		
					    if(rs.getInt(2)==NoOfFloor)
					    {
					    	System.out.println("update  data in data base.....	");
					    	PreparedStatement preparedStatement1=conn.prepareStatement("SELECT * FROM  parkingslot WHERE NoOfFloor='"+NoOfFloor+"'");
							
							  ResultSet rs1=preparedStatement1.executeQuery();
							  while(rs1.next())
							  {
								
									iSlotInEachFloor=rs1.getInt(3);
							  } 
							
							  totalSlotInEachFloor=iSlotInEachFloor+SlotInEachFloor;
							  
							  System.out.println("iSlotInEachFloor+SlotInEachFloor-->"+iSlotInEachFloor+SlotInEachFloor);
							  System.out.println("totalSlotInEachFloor---->"+totalSlotInEachFloor);
							  if(iSlotInEachFloor+SlotInEachFloor<=10)
							  {
						 
							 
							  PreparedStatement  preparedStatement2=conn.prepareStatement("update  parkingslot set iSlotInEachFloor='"+totalSlotInEachFloor+"' where NoOfFloor='"+NoOfFloor+"'");
							  int insertResponse=preparedStatement2.executeUpdate();
			  					if(insertResponse>0) {

			  						response.sendRedirect("AddParkingSlot.jsp");
			  					  session.setAttribute("sucess","Successfully");							 
			  					}	
							  }	
							  
							  else
							  {
								  session.setAttribute("Addslot", "Floor And Slot is not more than 10");
								  System.out.println("jhdkjdhskhdskdhkshdskhdhs--->");
				          	    	response.sendRedirect("AddParkingSlot.jsp");
							  } 
							  updateNoOfFloor=true;
							  break;
							  
				       }
						 
					    }
				  				
			  if(updateNoOfFloor)
			  {
					PreparedStatement preparedStatement6=conn.prepareStatement("select * from bookslot ");
					  ResultSet rs6=preparedStatement6.executeQuery();
					  while(rs6.next())
					  {
						    if(rs6.getInt(2)==NoOfFloor)
						    {
//						    	updateslot=rs6.getInt(2);
						    	updatef=true;
						    }
						      
					  }
					 
					
	    			if(updatef)
	    			{		
					PreparedStatement preparedStatement5=conn.prepareStatement("SELECT * FROM  bookslot WHERE NoOfFloor='"+NoOfFloor+"'");    						
						  ResultSet rsupdate=preparedStatement5.executeQuery();
						  while(rsupdate.next())
						  {
							  
							  update=rsupdate.getInt(3);
						  } 	
	    			
	    			if(update+SlotInEachFloor<=10)
	    			{		
    	    	for(int m=++update;m<update+SlotInEachFloor;m++)
    	    	{
    	    		PreparedStatement preparedStatement3=conn.prepareStatement("Insert into bookslot(NoOfFloor,iSlotInEachFloor,Status)values(?,?,?)");
    	    		preparedStatement3.setInt(1,NoOfFloor );
  	    		preparedStatement3.setInt(2, m);
    	    		preparedStatement3.setString(3, "true");
    	    		preparedStatement3.executeUpdate();
    	    	}
	    			}
	    			else {
	    				session.setAttribute("Addslot", "Floor And Slot is not more than 10");
	          	    	response.sendRedirect("AddParkingSlot.jsp");
	    			}
	    	
	    		}
				  }
				  else {
					    
		//insert data in data base.....			  
					  
         	if(NoOfFloor<=10&&SlotInEachFloor<=10)
 			{
         		System.out.println("insert data in data base.....");
   				PreparedStatement preparedStatement2=conn.prepareStatement("Insert into parkingslot(NoOfFloor,iSlotInEachFloor)values(?,?)");
   				
   					preparedStatement2.setInt(1,NoOfFloor);
     	    		preparedStatement2.setInt(2,SlotInEachFloor);
     	    		
     	    		//insert data in booking table 
     	    		for(int m=1;m<=SlotInEachFloor;m++)
          	    	{
          	    		PreparedStatement preparedStatement3=conn.prepareStatement("Insert into bookslot(NoOfFloor,iSlotInEachFloor,Status)values(?,?,?)");
          	    		preparedStatement3.setInt(1,NoOfFloor );
          	    		preparedStatement3.setInt(2, m);
         	    		preparedStatement3.setString(3, "true");
          	    		preparedStatement3.executeUpdate();
          	    	}
     	    		
      	    		if(preparedStatement2.executeUpdate()>0) {
      	    			response.sendRedirect("AddParkingSlot.jsp");
      	    		session.setAttribute("sucess","Successfully");
      	    		}
       	    		else response.sendRedirect("registration.jsp");
      	    		
     			}	
         	else {
         		 session.setAttribute("Addslot", "Floor And Slot is not more than 10");
       	    	response.sendRedirect("AddParkingSlot.jsp");
         	}
 				  }	
				  	
      	    }
         
 		catch(Exception e)
 		{
 		  e.printStackTrace();
 		}
 		finally {
 			DataBaseConnection.DbCOnnectioinClose();
 		}   
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         //updateing ..............
//             boolean f=false,l=false,k=false;          
//            try {
//            	
//    			Connection conn=DataBaseConnection.openConnection();
//    			int i= NoOfFloor;
//    			int j1=SlotInEachFloor;
//    			int str = 0,str1=0,temp=0, str6=0,str5=0,updateslot=0;
//    			String Query1="select * from parkingslot ";
//				PreparedStatement preparedStatement=conn.prepareStatement(Query1);
//				  ResultSet rs=preparedStatement.executeQuery();
//				  while(rs.next())
//				  {
//					    str=rs.getInt(2);
//					    if(str==i)
//					    {
//					    	f=true;
//					    	break;
//					    }
//					    
//				  }
//				
//				  if(f)
//				  {
//						String Query2="SELECT * FROM  parkingslot WHERE NoOfFloor='"+str+"'";
//						PreparedStatement preparedStatement1=conn.prepareStatement(Query2);
//						
//							  ResultSet rs1=preparedStatement1.executeQuery();
//							  while(rs1.next())
//							  {
//								  str1= rs1.getInt(3);
//								  
//							  } 
//							  temp=j1+str1;
//							  if(temp<=10)
//							  {
//						 
//							  String dml = "update  parkingslot set iSlotInEachFloor='"+temp+"' where NoOfFloor='"+str+"'";
//							  PreparedStatement  preparedStatement2=conn.prepareStatement(dml);
//							  int insertResponse=preparedStatement2.executeUpdate();
//			  					if(insertResponse>0) {
////			  						if(update==1)
////			  						{
////			  							response.sendRedirect("update.jsp");
////			  						  session.setAttribute("sucess","Successfully");
////			  						}
////			  					else {
//			  						response.sendRedirect("AddParkingSlot.jsp");
//			  					  session.setAttribute("sucess","Successfully");
////									 } 
//			  					}
//			  					
//			  					
//							  }	
//							  else
//							  {
//								  session.setAttribute("Addslot", "Floor And Slot is not more than 10");
//				          	    	response.sendRedirect("AddParkingSlot.jsp");
//							  }
//							  str=0;
//							  temp=0;
//				  }
//				  else {
//            	if(i<=10&&j1<=10)
//    			{
//            		l=true;
//    				String Query3="Insert into parkingslot(NoOfFloor,iSlotInEachFloor)values(?,?)";
//      				PreparedStatement preparedStatement2=conn.prepareStatement(Query3);
//      				
//      					preparedStatement2.setInt(1,NoOfFloor);
//        	    		preparedStatement2.setInt(2,SlotInEachFloor);
//         	    		int insertResponse=preparedStatement2.executeUpdate();
//         	    		
//         	    		if(insertResponse>0) {
////         	    			if(update==1)
////	  						{
////	  							response.sendRedirect("update.jsp");
////	  						}
////         	    			else {
//         	    			
//         	    			response.sendRedirect("AddParkingSlot.jsp");
//         	    		session.setAttribute("sucess","Successfully");
//         	    		System.out.println("slot is booked...");
////						 } 
//         	    			
//         	    		}
//          	    		else response.sendRedirect("registration.jsp");
//         	    		
//         	    	
//         	    		
//        			}	
//            	else {
//            		 session.setAttribute("Addslot", "Floor And Slot is not more than 10");
//          	    	response.sendRedirect("AddParkingSlot.jsp");
//            	}
//    				  }	
//				  
//				  // bookslot.....table 
//				  
//				  
//        	    		if(l) {
//         	    		
//         	    		String Query4="Insert into bookslot(NoOfFloor,iSlotInEachFloor,Status)values(?,?,?)";
//         	    		//PreparedStatement preparedStatement3=conn.prepareStatement(Query4);
//         	    	for(int m=1;m<=SlotInEachFloor;m++)
//         	    	{
//         	    		PreparedStatement preparedStatement3=conn.prepareStatement(Query4);
//         	    		preparedStatement3.setInt(1,NoOfFloor );
//         	    		preparedStatement3.setInt(2, m);
//        	    		preparedStatement3.setString(3, "true");
//         	    		preparedStatement3.executeUpdate();
//         	    	}
//         	    		}
//      	    		else {
//         	    			
//         	    		
//         	    			String Query6="select * from bookslot ";
//         					PreparedStatement preparedStatement6=conn.prepareStatement(Query6);
//         					  ResultSet rs6=preparedStatement6.executeQuery();
//         					  while(rs6.next())
//         					  {
//         						    str6=rs6.getInt(2);
//         						    if(str6==NoOfFloor)
//         						    {
//         						    	updateslot=rs6.getInt(2);
//         						    	k=true;
//         						    }
//         						      
//         					  }
//         					 System.out.println("str6---"+str6);
//         					 System.out.println("updateslot--->"+updateslot);
//         	    			if(k)
//         	    			{		
//         	    			
//         	    			String Query5="SELECT * FROM  bookslot WHERE NoOfFloor='"+updateslot+"'";
//    						PreparedStatement preparedStatement5=conn.prepareStatement(Query5);    						
//   							  ResultSet r5=preparedStatement5.executeQuery();
//    							  while(r5.next())
//    							  {
//    								  str5= r5.getInt(3);    								  
//    							  } 	
//    							  System.out.println("str5....1--->"+str5);
//         	    			int o=str5+SlotInEachFloor;
//         	    			System.out.println("oooooo->>>"+o);
//
//         	    			str5++;
//      	    			String Query7="Insert into bookslot(NoOfFloor,iSlotInEachFloor,Status)values(?,?,?)";
//         	    			System.out.println("str5--->"+str5);
//         	    			if(o<=10)
//         	    			{		
//             	    	for(int m=str5;m<=o;m++)
//             	    	{
//             	    		PreparedStatement preparedStatement3=conn.prepareStatement(Query7);
//             	    		preparedStatement3.setInt(1,NoOfFloor );
//           	    		preparedStatement3.setInt(2, m);
//             	    		preparedStatement3.setString(3, "true");
//             	    		preparedStatement3.executeUpdate();
//             	    	}
//         	    			}
//         	    			else {
//         	    				session.setAttribute("Addslot", "Floor And Slot is not more than 10");
//         	          	    	response.sendRedirect("AddParkingSlot.jsp");
//         	    			}
//         	    	
//         	    		}
//         	    			str = 0;str1=0;temp=0; str6=0;str5=0;updateslot=0;
//         	    			
//         	    		}
//         	    	  				     		}
//            
//    		catch(Exception e)
//    		{
//    		  e.printStackTrace();
//    		}
//    		finally {
//    			DataBaseConnection.DbCOnnectioinClose();
//    		}   
	}

}
