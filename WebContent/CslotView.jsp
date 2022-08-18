<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*"%>
    <%@include file="component/allcss.jsp"%>
    <%@include file="component/navbar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body id="index" >
<div id="index1">
<h1>All Slot list</h1>

<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">All Slot List...</th>
      <th scope="col">Slot Book</th>
    
    </tr>
  </thead>
 <%HashMap<Integer,String> std = 
            ( HashMap<Integer,String>)request.getAttribute("data");
     String str="true";
       for(Map.Entry m : std.entrySet()){    
		        
        %>
        <tbody>
         <tr>
             <form action="CSlotBook.jsp" method="post">
              <td  colspan="2"  class="B" type="submit" name="view" value="<%= m.getKey()%>"><%= m.getKey()%></td>
             
             <%if(!str.equals(m.getValue())){
            	 %>
            	 
            	
            	<td>  <button class="btn btn-danger"
				class="fa-solid fa-user">Booked </button></td>
            	
             <% }
             else{
            	 %>
            	 <td><button type="submit" class="btn btn-success btn-sm text-white"  name="Book" value="<%= m.getKey()%>">SlotBook</button></td>

             <% }%>
            
             
             
             </form>
           </tr>
   
        </tbody>
        
            <%}%>
        </table>
        
</body>
</html>