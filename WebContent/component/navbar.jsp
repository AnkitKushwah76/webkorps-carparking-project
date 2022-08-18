
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			
		<%
		String  user = (String) session.getAttribute("userName");
		if (user!=null) {
		%>
			<form class="form-inline my-2 my-lg-0">
			<button class="btn btn-success"><%=user%>
			</button>
			<a data-toggle ="modal"
		data-target="#exampleModal" class="btn btn-danger ml-2 text-white">Logout</a>
		</form>
		<%
		
		} else {
		%>

		<form class="form-inline my-2 my-lg-0">
			<a href="login.jsp" class="btn btn-success"><i
				class="fa-solid fa-user"></i>Login</a> <a href="registration.jsp"
				class="btn btn-danger ml-2"><i class="fa-solid fa-user-plus"></i>Register</a>
		</form>
	
		<%
		}
		%>	
			</ul>
		<!-- logout popup -->
	<!-- Button trigger modal -->


	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
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
				<h6>Do You want to Logout</h6>
				<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<a href="Logout" class="btn btn-primary">Logout </a> </div>
				<div class="modal-footer">
					
				</div>
			</div>
		</div>
	</div>
	<!-- logout popup -->
	
	
</nav>