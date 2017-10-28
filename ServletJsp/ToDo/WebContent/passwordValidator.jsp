
<%@ page import="java.sql.*"%>
<%
	String pass = request.getParameter("pass");

	//String pass=request.getParameter("pass");
	//  if(pass.matches("^[_A-Za-z0-9-] (\\.[_A-Za-z0-9-] )*@[A-Za-z0-9-] (\\.[A-Za-z0-9-] )*(\\.[_A-Za-z0-9-] )")) {  
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/To_Do", "root", "bridgeit");
		PreparedStatement ps = con.prepareStatement("select * from User_Details where password=? ");
		ps.setString(1, pass);
		/*  ps.setString(1,pass); */
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			// out.print(" password Available! <img src='unchecked.gif'/>");  

		} else {
			// out.print("Password Unavailable! <img src='/checked.gif'/>");  
			out.print("Incorrect Password!");
		}
	} catch (Exception e) {
		out.print(e);
	}
	/*  } 
	 else{  
	  out.print("Invalid Password!");  
	  }  */
%>
