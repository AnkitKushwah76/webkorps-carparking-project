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
<body id="index"  mehtod="post">
<div id="index1">
   <ul>
  <!-- <li ><a href="registration.jsp">Home</a></li>  -->
  <!-- <li ><a href="AddParkingSlot.jsp">AddParkingSlot</a></li>  -->
  
  
  <a href="AddParkingSlot.jsp"
				class="btn btn-success ml-2"><i class="fa-solid fa-user-plus"></i>AddParkingSlot</a>
  <li>
  
  
  
  
  <form action="ViewParkingSlot" method="post">

  <button type="submit" class="btn btn-warning ml-2"> ViewParkingSlot </button></form></li>
  
  
  
  
  
  
  <!-- <li><a href="DeleteParkingSlot.jsp">DeleteParkingSlot </a></li>
<li><a href="EditParkingSlot.jsp">EditParkingSlot </a></li> -->
</ul>
</div>
    <div id="data">
         <center>
         
           <h1>AdminProfile</h1>
          </center>
    </div>

</body >
</html>