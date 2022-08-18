<%@ page import="Com.DataBaseConnectivity. DataBaseConnection "%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%>
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

<table  class="table table-dark">
   <h1 align="center" >All Floor list</h1>
  <thead>
    <tr>
      <th scope="col">All Floor List...</th>
      
    </tr>
  </thead>
 <%ArrayList<Integer> std = 
            (ArrayList<Integer>)request.getAttribute("data");
     
        for(Object s:std){%>

            <tr>
            <form action="ViewSlot" method="post">

          <%-- <button type="submit" name="view" value="<%=s%>"> <%=s%> </button> --%>
          
           <tr>
            <%--  <td align="center" colspan="2"> <button class="B" type="submit" name="view" value="<%=s%>"/> <%=s%></td> --%>
            <td align="center" colspan="2"  class="B" type="submit" name="view" value="<%=s%>"/> <%=s%></td>
               <td align="center" colspan="2"> <button class="B" type="submit" name="view" value="<%=s%>"/> Click On</td> 
            
             </tr>
          </form>
          
               <%--  <button type="submit"> <%=s%></button> --%>
              
             
            </tr>
            <%}%>
      
	 </table>
    
</body >
</html>