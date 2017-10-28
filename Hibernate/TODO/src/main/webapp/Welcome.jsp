<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>

		Welcome <%=session.getAttribute("name") %>

</head>
<body>

<form method="get" action="logout">	
<br>
					
<input type="submit" name="logout" value="LogOut">		
				
</form> 


</body>
</html>