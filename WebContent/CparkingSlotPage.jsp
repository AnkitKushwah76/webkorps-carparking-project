<%@ page import="Com.DataBaseConnectivity. DataBaseConnection "%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@include file="component/navbar.jsp"%>
    <%@include file="component/allcss.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>CarParkingManagement</title>
</head>
<body id="index" >
<div id="index1">

<table align="center" class="table table-dark " style = "margin-left">
   <marquee width="60%" direction="right" height="100px"><h1 align="center" >All Floor list</h1></marquee>
  <thead>
    <tr>
      <th  align="center">All Floor List...</th>
      
    </tr>
  </thead>
 <%ArrayList<Integer> std = 
            (ArrayList<Integer>)request.getAttribute("data");
   
        for(Object s:std){%>
         
            <tr>
            <form action="CparkingSlot" method="post">

          <%-- <button type="submit" name="view" value="<%=s%>"> <%=s%> </button> --%>
          
           <tr>
            <%--  <td align="center" colspan="2"> <button class="B" type="submit" name="view" value="<%=s%>"/> <%=s%></td> --%>
            <td align="center" colspan="2"  class="B" type="submit" name="Cview" value="<%=s%>"/> <%=s%></td>
               <td align="center" colspan="2"> <button style= "background-color: #4CAF50" type="submit" name="CView" value="<%=s%>"/> Click On</td>  
            
             </tr>
          </form>
          
               <%--  <button type="submit"> <%=s%></button> --%>
              
             
            </tr>
            <%}%>
      
	 </table>
    
</body >
</html>