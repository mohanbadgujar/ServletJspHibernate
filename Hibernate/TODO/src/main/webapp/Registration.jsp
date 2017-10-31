<!DOCTYPE html>
<html lang="en">
<head>
<title>Registration Page</title>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="regstyle.css">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="Validate.js"></script>
</head>

<body>

	<div class="container">

		<div class="row">

			<div class="col-md-5 col-lg-4 col-sm-6 col-xs-10" id="form">
				<center>
					<b class="registration">Sign Up Here</b>
				</center>


				<form method="post" action="RegistrationServlet">

					<br>

					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-user"
							style="width: 18px;"></i></span> <input class="form-control"
							onkeyup="ValidateRegistration()" type="text" name="name"
							id="name" placeholder="Full Name">

					</div>
					<p id="userNameError"></p>

					<br>

					<div class="input-group margin-bottom-sm">
						<span class="input-group-addon"><i
							class="fa fa-envelope-o fa-fw"></i></span> <input class="form-control"
							type="text" id="Email" name="email" placeholder="Email address"
							onkeyup="ValidateRegistration()">

					</div>
					<p id="userEmailError"></p>

					<br>

					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
						<input class="form-control" type="password" id="Pass"
							name="password" placeholder="Password"
							onkeyup="ValidateRegistration()">

					</div>
					<p id="userPassError"></p>

					<br>

					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
						<input class="form-control" type="password" id="RePass"
							name="repassword" placeholder="Re-Enter Password"
							onkeyup="ValidateRegistration()">

					</div>
					<p id="userRepassError"></p>

					<br>

					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-mobile"
							style="font-size: 1.4em; width: 18px;"></i></span> <input
							class="form-control" type="number" name="mobile" id="mobile"
							placeholder="Mobile Number" onkeyup="ValidateRegistration()">

					</div>
					<p id="userMobileError"></p>


					<br> <label>Date of Birth:</label>

					<div class="form-group">

						<input type="date" class="form-control text" name="birth"
							placeholder="Date of Birth"> <span><i
							class="fa fa-calendar" aria-hidden="true"></i></span>

					</div>


					<div class="form-group">
						<label>Select Gender :</label> <select class="form-control text"
							name="sex">
							<option value="Male">Male</option>
							<option value="Male">Female</option>
						</select>
					</div>

					<br>

					<div class="form-group">
						<input type="submit" class="btn btn-primary" name="Login"
							value="Register"
							onclick="javascript:return ValidateRegistration(document.getElementById('name').value,document.getElementById('Email').value,document.getElementById('Pass').value,document.getElementById('RePass').value,document.getElementById('mobile').value)">
						<input type="reset" class="btn btn-danger" name="SignIn"
							value="Reset">
					</div>


					<div class="form-group">
						<center>
							<a href="index.jsp">Already Registered!! Login Here</a>
						</center>
					</div>
					<br>

					<%
							String reg_msg=(String)request.getAttribute("regerror");  
							if(reg_msg!=null)
							out.println("<center><font color=red size=4px>"+reg_msg+"</font></center>");
					%>

				</form>

			</div>

		</div>
	</div>

</body>
</html>

