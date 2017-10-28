
<%@ page import="java.sql.*"%>
<%  
    String email=request.getParameter("email");
    
    //String pass=request.getParameter("pass");
    if(email.contains("@")&&email.contains(".")){  
    try{  
 		   Class.forName("com.mysql.jdbc.Driver");  
 		   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/To_Do", "root","bridgeit"); 
    	   PreparedStatement ps=con.prepareStatement("select * from User_Details where email=? ");  
   		   ps.setString(1,email);  
  	 		
   		   /*  ps.setString(1,pass); */
  		  ResultSet rs=ps.executeQuery();  
   		  if(rs.next()){  
  				//out.print(" Email Available!");  
    	  }else{  
    			out.print("Chouldn't find your ToDo account");  
   			   }  
   	    }catch(Exception e){out.print(e);}  
    }else{  
 		   out.print("Invalid Email Format!");  
    }  
    %>
