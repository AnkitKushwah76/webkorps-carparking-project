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
         
         
         
         
           <h1>AddParkingSlot</h1>
           
           <form action="AddParkingSlot" method="post" >
            <%
						String invalidMsg = (String) session.getAttribute("Addslot");
						if (invalidMsg != null) {
						%>
						<h4 class="text-center text-danger">
							<%=invalidMsg%>
						</h4>
						<%
						session.removeAttribute("Addslot");
						}
						%>
						
			<%
			    String sucess=(String) session.getAttribute("sucess");
			    if(sucess!=null){
			    	%>
			    	<h4 class="text-center text-Success">
							<%=sucess%>
						</h4>
				<%	
				session.removeAttribute("sucess");
			    }
			%>			
    
           <table>   
             <tr>
                <td>No Of Floor</td>
                <td><input type="number" name="NoOfFloor" placeholder="Enter No Of Floor" required ></td>
             </tr>
              <tr>
                <td>Slot in Each floor</td>
                <td><input type="number" name="SlotinEachfloor" placeholder="Slot in Each floor" required></td>
             </tr>
              
             <tr>
             <td align="center" colspan="2"><input class="B" type="submit" value="AddSlot"></td>
             
             </tr>
             </table>
             </form>
         </center>
    </div>

</body >
</html>