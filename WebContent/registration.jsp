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
         <h1>Car Parking Management </h1>
           <form action="Registraction" method="post" >
           <table>
            <%
                String userEmail=(String)session.getAttribute("userEmail");
                if(userEmail !=null)
                {%>
                <h4 class="text-center text-danger">
							<%=userEmail%>
						</h4>
						<%
                	session.removeAttribute("userEmail");
                }
              %>
              
              
               <%
                String success=(String)session.getAttribute("success");
                if(success !=null)
                {%>
                <h4 class="text-center text-success">
							<%=success%>
						</h4>
						<%
                	session.removeAttribute("success");
                }
              %>
              
              
              
              
              
              
              
             <tr>
                <td>Enter Name</td>
                <td><input type="text" name="userName" placeholder="Enter Name" required></td>
                
             </tr>
              <tr>
                <td>Enter EmailAddress</td>
                
                <td><input type="email" name="useEmail" placeholder="Enter Email"required></td>
             </tr>
              <tr>
                <td>Enter Password</td>
                <td><input type="Password" name="userPassword" placeholder="Enter Password"required></td>
             </tr>
             
             <tr>
                <td>Choose Role </td>
                <td><select id="choice" name="userRole" required>
                  <option selected>Open this select menu</option>
                 <option value="Clint">Clint</option>
                 <option value="Admin">Admin</option>
                </select></td>
             </tr>
             <tr>
             <td align="" colspan="2"><input class="B" type="submit" value="Registration"></td>
            <td align="" colspan="2"><input class="B" type="reset" value="Cancel"></td>
            
             </tr>
             </table>
             </form>
         </center>
    </div>

</body >
</html>