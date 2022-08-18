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
<ul>
 <!--  <li ><a href="registration.jsp">Home</a></li> -->
  </ul>
  </div>
    <div id="data">
         <center>
           <h1>UpdateParkingSlot</h1>
            <%
			    String sucess1=(String) session.getAttribute("sucess");
			    if(sucess1!=null){
			    	%>
			    	<h4 class="text-center text-Success">
							<%=sucess1%>
						</h4>
				<%	
				session.removeAttribute("sucess");
			    }
			%>		
           <form action="AddParkingSlot" method="post" >
          	
       <%--  <%
        int value= Integer.parseInt(request.getParameter("update"));
        out.println("value--->"+value);
        %>
 --%>           <table>   
             <tr>
                <td>No Of Floor</td>
                <td><input type="number" name="NoOfFloor" placeholder="Enter No Of Floor" required></td>
             </tr>
              <tr>
                <td>Slot in Each floor</td>
                <td><input type="number" name="SlotinEachfloor" placeholder="Slot in Each floor" required></td>
             </tr>
              
             <tr>
             <td align="center" colspan="2"><button class="btn btn-success ml-2" type="submit"  name="update" value="<%=1%>"">Update</button></td>
             
             </tr>
             </table>
             </form>
         </center>
    </div>

</body >
</html>