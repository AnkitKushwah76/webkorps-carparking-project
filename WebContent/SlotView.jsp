
<%@page import="java.util.ArrayList"%>
<%@include file="component/allcss.jsp"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="component/navbar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
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
      <th scope="col">Delete</th>
      <th scope="col">Edit</th>
    </tr>
  </thead>

 <%ArrayList<Integer> std = 
            (ArrayList<Integer>)request.getAttribute("data");
       int i=0,k=0;
      
       for(Integer s:std){
           k=s;
           break;
       }
       
        for(Integer s:std){
        i=s;
        }
        for(int j=1;j<=i;j++)
        { 	
       
        %>

          <tbody>
         <tr>
         
        
         

          <%-- <button type="submit" name="view" value="<%=s%>"> <%=s%> </button> --%>
          
             <form action="DeleteSlot" method="post">
              
              <td  colspan="2"  class="B" type="submit" name="view" value="<%= j%>"><%= j%></td>
             <td>
             
             
            <%--  <button  class="btn btn-success btn-sm text-white"  name="delete" value="<%= k%>">Delete</button> --%>
             
             <a data-toggle ="modal"
		data-target="#exampleModa2" class="btn btn-danger ml-2 text-white">Delete</a>
         
             
             </td> 
           <td><a href="update.jsp"  data-toggle ="modal" data-target="#exampleModa3" class="btn btn-success btn-sm text-white">Edit</a></td>
          
           </tr>
   
        </tbody>
        <div class="modal fade" id="exampleModa2" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body text-center">
				<h6> Do You want to Delete</h6>
				<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button class="btn btn-primary"  name="delete" value="<%= k%>">Delete </button></div>
				<div class="modal-footer">
					
				</div>
			</div>
		</div>
	</div>
	
	<!-- Edit..... -->
	<div class="modal fade" id="exampleModa3" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body text-center">
				<h6> Do You want to Update</h6>
				<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<a href="update.jsp" class="btn btn-primary"  >Update </a></div>
				<div class="modal-footer">
					
				</div>
			</div>
		</div>
	</div>
	
          </form>
               <%--  <button type="submit"> <%=s%></button> --%>
            <%}
            i=0;
            %>
      
	 
    </table>
</body >
</html>