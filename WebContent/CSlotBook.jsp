<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@include file="component/allcss.jsp"%>
   <%@include file="component/navbar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>CarParkingManagement</title>
</head>
<body id="index" >
<div id="index1">
   <!-- <ul>
  
  <li ><a href="login.jsp">Login</a></li> 
  <li><a href="registration.jsp">registration</a></li>
</ul> -->
</div>
    <div id="data">
         <center>
         <h1>Client Details </h1>
      
           <form action="Clientdetails" method="post" >
           
           <%
           String errormsg=(String)request.getAttribute("errormsg");
           if(errormsg!=null)
           {%>
        	   <h4 class="text-center text-danger">
				<%=errormsg%>
			</h4>
          <% }
           
           %>
           
           
           
            <%
           int slot= Integer.parseInt(request.getParameter("Book"));
		
		System.out.println("slot ankit iddd--->"+slot);
		 %>
          
           <table>
                         <tr>
                <td>ClientName</td>
                <td><input type="text" name="clientname" placeholder="Enter client name" required></td>
                
             </tr>
              <tr>
                <td>CarNumber</td>
                
                <td><input type="text" name="carnumber" placeholder="Enter car number"required></td>
             </tr>
              <tr>
                <td>CarColor</td>
                <td><input type="text" name="carcolor" placeholder="Enter car color"required></td>
             </tr>
             
             </tr>
              <tr>
                <td>InTime</td>
                <td><input type="time" name="intime" required></td>
             </tr>
             
              <tr>
                <td>OutTime</td>
                <td><input type="time" name="outtime" equired></td>
             </tr>
             
             <td align="" colspan="2"><button class="B" type="submit" name="Book" value= <%=slot%>>Submit</button></td>
            <td align="" colspan="2"><button class="B" type="reset" value="">Cancel </button></td>
            
             </tr>
             </table>
             </form>
         </center>
    </div>

</body >
</html>