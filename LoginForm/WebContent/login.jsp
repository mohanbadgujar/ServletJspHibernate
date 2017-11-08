<!DOCTYPE html>
<html lang="en">
<head>
<title>Login Page</title>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="loginstyle.css">
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

			<div class="col-md-5 col-lg-5 col-sm-7 col-xs-11" id="form">


				<center>
					<b class="registration">LogIn</b>
				</center>


				<form method="post" action="loginpage" name="vinform">


					<br>

					<div class="form-group">
						<label class="control-label">Email</label> <span><i
							class="fa fa-user" aria-hidden="true"></i></span> <input type="text"
							class="form-control" name="email" id="email"
							placeholder="UserName">

					</div>

					<br>

					<div class="form-group">
						<label class="control-label">Password</label> <span><i
							class="fa fa-lock" aria-hidden="true"></i></span> <input type="password"
							class="form-control" name="password" id="password" placeholder="Password">

					</div>

					<!-- #messages is where the messages are placed inside -->
					<div class="form-group">
						<div class="col-md-9 col-md-offset-2">
							<div id="messages"></div>

						</div>

					</div>

					<div class="form-group">
						<a href="reg.jsp">Forgot Password?</a>
					</div>

					<br>

					<div class="form-group">
						<input type="submit" class="btn btn-primary" name="SignIn"
							value="Sign In" onclick="sendInfo()" onclick="sendInform()">
						 <button formaction="RegistrationPage" class="btn btn-danger"
							id="signupbtn">SignUp</button> 
						
				<!--  	 <input type="button" value="S" onclick="window.location='Welcome.jsp'"> -->	
					
						<!-- <input type="button" class="btn btn-danger" name="SignUp"
							value="Sign Up" onclick="window.location='registration.jsp'"> -->
						
					
					</div>

					<br>

					<div class="col-sm-12 col-sm-offset-1 controls">
						<a id="btn-fblogin" href="#" class="btn btn-facebook">Login
							with Facebook</a> <a id="btn-googlelogin" href="#"
							class="btn btn-google">Login with Google+</a>
					</div>
					<br>

					<%-- <p>${error}</p>	 --%>
					<%
							String login_msg = (String)request.getAttribute("error");  
							if(login_msg!=null)
							out.println("<center><font color=red size=4px>"+login_msg+"</font></center>");
					%> 

				</form>

			</div>

		</div>
	</div>

</body>
</html>