<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="container">

		<div class="row">

			<div class="col-md-5 col-lg-4 col-sm-6 col-xs-10" id="form">
				<center>
					<b class="registration">Sign Up Here</b>
				</center>


				<form method="post" action="UserControllerServlet">

					<br>

					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-user" style="width: 18px;"></i></span>
						<input class="form-control" type="text" name="name" placeholder="Full Name">

					</div>
					
					<br>

					<div class="input-group margin-bottom-sm">
						<span class="input-group-addon"><i
							class="fa fa-envelope-o fa-fw"></i></span>
						 <input class="form-control" type="text" name="email" placeholder="Email address">
						
					</div>
						

					<br>

					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
						<input class="form-control" type="password" name="pass"
							placeholder="Password" >
						
					</div>
						
					<br>

					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
						<input class="form-control" type="password" name="repass"
							placeholder="Re-Enter Password">
						
					</div>
						<p id="userRepassError"></p>

					<br>

					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-mobile"
							style=" font-size: 1.4em; width: 18px;"></i></span> <input 
							type="number" name="mobile" 
							placeholder="Mobile Number" >
						
					</div>
					
					<br>

					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-user" style="width: 18px;"></i></span>
						<input class="form-control" type="text" name="city" placeholder="city">

					</div>
					
					<br>

					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Register">
						
					</div>
				
					<br>

				</form>

			</div>

		</div>
	</div>

</body>
</html>