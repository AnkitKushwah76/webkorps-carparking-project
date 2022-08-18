package Com.CarParkingManagement.Servlet;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.Beean.ClientDetails;
import Com.DataBaseConnectivity.DataBaseConnection;

@WebServlet("/Clientdetails")
public class CSlotBook extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
		int slot= Integer.parseInt(request.getParameter("Book"));
		int hours=0,price=0,BookSlotId =0;
		boolean user=false;;
		long differenceInHours=0,differenceInMinutes=0;
		
		String clientname=request.getParameter("clientname");
		String carnumber=request.getParameter("carnumber");
		String carcolor =request.getParameter("carcolor");
		String intime=request.getParameter("intime");
		String outtime=request.getParameter("outtime");
		ClientDetails cd=new ClientDetails(clientname,carnumber,carcolor,intime,outtime);
		
		try {
	  	        SimpleDateFormat simpleDateFormat
	            = new SimpleDateFormat("HH:mm");
	  
	        Date date1 = simpleDateFormat.parse(intime);
	        Date date2 = simpleDateFormat.parse(outtime);
	        long differenceInMilliSeconds
            = Math.abs(date2.getTime() - date1.getTime());
        differenceInHours
            = (differenceInMilliSeconds / (60 * 60 * 1000))
              % 24;
  
        differenceInMinutes
            = (differenceInMilliSeconds / (60 * 1000)) % 60;
  
        System.out.println(
            "Difference is " + differenceInHours + " hours "
            + differenceInMinutes + " minutes "
           );
		
	
			 Connection conn=DataBaseConnection.openConnection();	
			
			  PreparedStatement preparedStatment1=conn.prepareStatement("select * from bookinghour");
		  ResultSet rs1=preparedStatment1.executeQuery();
		  while(rs1.next())
		  {
			  hours=rs1.getInt(2);
			  if(hours==differenceInHours || differenceInMinutes==45)
			  {
				  price=rs1.getInt(3);
				  break;
			  }
		  }
		  System.out.println("price---->"+price);
		}
		catch(Exception e1)
		{
			
			e1.printStackTrace();
		}
		 HttpSession session=request.getSession();
			
		
			int  FloorId =  (int) session.getAttribute("FloorId");
				
		try {
			HttpSession sessionh= request.getSession();
			  String ueremail=  (String) sessionh.getAttribute("userId");
			Connection conn=DataBaseConnection.openConnection();
			PreparedStatement preparedstatementc=conn.prepareStatement("select *from clientdetails where useremail='"+ueremail+"'");
			ResultSet rsc=preparedstatementc.executeQuery();
			while(rsc.next())
			{
				
				if(rsc.getString(7).equals(ueremail))
				{
				
					user=true;
				}
				
			}
			
			
			 if(user!=true)
			 {	 
				 
			PreparedStatement preparedstatement2=conn.prepareStatement("Insert into clientdetails(ClientName,CarNumber,CarColor,InTime,OutTime,useremail) values(?,?,?,?,?,?)"); 
			
			preparedstatement2.setString(1, cd.getClientName());
			preparedstatement2.setString(2, cd.getCarNumber());
			preparedstatement2.setString(3, cd.getCarColor());
			preparedstatement2.setString(4, cd.getInTime());
			preparedstatement2.setString(5, cd.getOutTime());
			preparedstatement2.setString(6,ueremail );
			
			
			
			if(preparedstatement2.executeUpdate()>0)
			{
				PreparedStatement preparedStatement3=conn.prepareStatement("SELECT * FROM  bookslot WHERE  iSlotInEachFloor='"+slot+"' AND NoOfFloor='"+FloorId+"'");
					
						  ResultSet rs3=preparedStatement3.executeQuery();
						  while(rs3.next())
						  {
							  BookSlotId = rs3.getInt(1);
						  }
						  PreparedStatement  preparedStatement4=conn.prepareStatement("update  bookslot set Status='false' where BookSlotId='"+BookSlotId +"'");
						  preparedStatement4.executeUpdate();  
						  
						  
						  String emailid=  (String) sessionh.getAttribute("userId");
							
							String floorNo= String.valueOf(FloorId); 
							String slotj=String.valueOf(slot);
							String pricep=String.valueOf(price);
							String msg="Thanku you your slot booked successfully and your floor number :"+floorNo+"with slot number:"+slotj+"And price:"+pricep+"";
							String subject="Car Parking: Conformation ";
						String to=emailid; 
						String from="ankukushwah76@gmail.com";
					 ConfirmationEmail.sendEmail(msg,subject,to,from);
						response.sendRedirect("CParkingSotPage");
						  
						  System.out.println("Sucessfully");
							  
			}
			 }
			 else {
				 HttpSession session1= request.getSession();
				 session1.setAttribute("errormsg", "You are already slot booked");
				 response.sendRedirect("CParkingSotPage");
			 }
		
			
		}
		
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		int slot= Integer.parseInt(request.getParameter("Book"));
//		int hours=0,price=0;
//		boolean f=false,user=false;;
//		long differenceInHours=0,differenceInMinutes=0;
//		System.out.println("slotClientdetails--->"+slot);
//		
//		String clientname=request.getParameter("clientname");
//		String carnumber=request.getParameter("carnumber");
//		String carcolor =request.getParameter("carcolor");
//		String intime=request.getParameter("intime");
//		String outtime=request.getParameter("outtime");
//		ClientDetails cd=new ClientDetails(clientname,carnumber,carcolor,intime,outtime);
//		
//		try {
//		  String time1 = ""+intime;
//	        String time2 = ""+outtime;
//	  	        SimpleDateFormat simpleDateFormat
//	            = new SimpleDateFormat("HH:mm");
//	  
//	        Date date1 = simpleDateFormat.parse(time1);
//	        Date date2 = simpleDateFormat.parse(time2);
//	        long differenceInMilliSeconds
//            = Math.abs(date2.getTime() - date1.getTime());
//        differenceInHours
//            = (differenceInMilliSeconds / (60 * 60 * 1000))
//              % 24;
//  
//        differenceInMinutes
//            = (differenceInMilliSeconds / (60 * 1000)) % 60;
//  
//        System.out.println(
//            "Difference is " + differenceInHours + " hours "
//            + differenceInMinutes + " minutes "
//           );
//		
//	
//			 Connection conn=DataBaseConnection.openConnection();	
//			  String query="select * from bookinghour";
//			  PreparedStatement preparedStatment1=conn.prepareStatement(query);
//		  ResultSet rs1=preparedStatment1.executeQuery();
//		  while(rs1.next())
//		  {
//			  hours=rs1.getInt(2);
//			  if(hours==differenceInHours || differenceInMinutes==45)
//			  {
//				  price=rs1.getInt(3);
//				  break;
//			  }
//		  }
//		  System.out.println("price---->"+price);
//		}
//		catch(Exception e1)
//		{
//			
//			e1.printStackTrace();
//		}
//		 HttpSession session=request.getSession();
//			//session.setAttribute("userId",userEmail);
//		 int FloorNo=0;
//			int  FloorId =  (int) session.getAttribute("FloorId");
//			if (FloorId != 0) {
//				FloorNo=FloorId;
//				System.out.println("FloorId--->"+FloorId);
//			}
//		System.out.println("i--->"+FloorNo);
//		
//		int str=0;
//		try {
//			HttpSession sessionh= request.getSession();
//			  String ueremail=  (String) sessionh.getAttribute("userId");
//			Connection conn=DataBaseConnection.openConnection();
//		
//			String str1="";
//			String sql1="select *from clientdetails where useremail='"+ueremail+"'";
//		
//			PreparedStatement preparedstatementc=conn.prepareStatement(sql1);
//			ResultSet rsc=preparedstatementc.executeQuery();
//			while(rsc.next())
//			{
//				str1=rsc.getString(7);
//				if(str1.equals(ueremail))
//				{
//					System.out.println("equllllwlwljlwjww");
//					user=true;
//				}
//				
//			}
//			System.out.println("clientNamedd----->"+str1);
//			
//			 if(user!=true)
//			 {	 
//				 System.out.println("ljlksdkjdjskdjsdd"+user);
//			 String sql="Insert into clientdetails(ClientName,CarNumber,CarColor,InTime,OutTime,useremail) values(?,?,?,?,?,?)";
//			 
//			PreparedStatement preparedstatement2=conn.prepareStatement(sql); 
//			
//			preparedstatement2.setString(1, cd.getClientName());
//			preparedstatement2.setString(2, cd.getCarNumber());
//			preparedstatement2.setString(3, cd.getCarColor());
//			preparedstatement2.setString(4, cd.getInTime());
//			preparedstatement2.setString(5, cd.getOutTime());
//			preparedstatement2.setString(6,ueremail );
//			int insertResponse=preparedstatement2.executeUpdate();
//			
//			
//			if(insertResponse>0)
//			{
//				
//   		 String Query1="SELECT * FROM  bookslot WHERE  iSlotInEachFloor='"+slot+"' AND NoOfFloor='"+FloorNo+"'";
//				PreparedStatement preparedStatement3=conn.prepareStatement(Query1);
//					
//						  ResultSet rs3=preparedStatement3.executeQuery();
//						  while(rs3.next())
//						  {
//							  str= rs3.getInt(1);
//						  }
//						  String dml = "update  bookslot set Status='false' where BookSlotId='"+str+"'";
//						  PreparedStatement  preparedStatement4=conn.prepareStatement(dml);
//						  preparedStatement4.executeUpdate();  
//						  f=true;
//						  System.out.println("Sucessfully");
//							  
//			}
//			if(f)
//			{
//				
//				
//				  String emailid=  (String) sessionh.getAttribute("userId");
//				
//				String i= String.valueOf(FloorNo); 
//				String j=String.valueOf(slot);
//				String p=String.valueOf(price);
//				String msg="Thanku you your slot booked successfully and your floor number :"+i+"with slot number:"+j+"And price:"+price+"";
//				String subject="Car Parking: Conformation ";
//			String to=emailid; 
//			String from="ankukushwah76@gmail.com";
//			ConfirmationEmail.sendEmail(msg,subject,to,from);
//			response.sendRedirect("CParkingSotPage");
//			}
//			 }
//			 else {
//				 HttpSession session1= request.getSession();
//				 session1.setAttribute("errormsg", "You are already slot booked");
//				 response.sendRedirect("CSlotBook.jsp");
//				 System.out.println("nhi bokkkk");
//			 }
//		
//			
//		}
//		
//		catch(Exception e)
//		{
//			
//			e.printStackTrace();
//		}
//		
//	}
//}
//	
		
	

	

