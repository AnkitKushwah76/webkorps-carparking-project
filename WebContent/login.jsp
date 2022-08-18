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
  <!--  <ul>
  
  <li ><a href="login.jsp">Login</a></li> 
  <li><a href="registration.jsp">registration</a></li>
</ul> -->

</div>
    <div id="data">
    <center>
    <h4>Login Here</h4>
      <%
						String invalidMsg = (String) session.getAttribute("invalidMsg");
						if (invalidMsg != null) {
						%>
						<h4 class="text-center text-danger">
							<%=invalidMsg%>
						</h4>
						<%
						session.removeAttribute("invalidMsg");
						}
						%>
    
         
                      
           <form action="login"  method="post">
           <table>
           
                <td>Enter EmailAddress</td>
                <td><input type="email" name="useEmail" placeholder="Enter Email" required></td>
             </tr>
              <tr>
                <td>Enter Password</td>
                <td><input type="Password" name="userPassword" placeholder="Enter Password" required></td>
             </tr>
             
            
             <tr>
             <td align="center" colspan="2"><input class="B" type="submit" value="Login"></td>
             
             </tr>
             </table>
             </form>
         </center>
    </div>

</body >
</html>