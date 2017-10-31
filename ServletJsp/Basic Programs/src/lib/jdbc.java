package lib;

import java.sql.*;
import java.util.Scanner;

public class jdbc {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("Select your choice=");
			System.out.println("1.Insert\n2.Delete\n3.Display\n4.Update\n5.Exit");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				insert();
				// create a sql date object so we can use it in our INSERT statement
				System.out.println("Data inserted Successfully");
				break;
			case 2:
				delete();
				System.out.println("Data Deleted Successfully");
				break;
			case 3:
				System.out.println("Your Data");
				display();
				break;
			case 4:
				update();
				System.out.println("Data Updated Successfully");
				break;
			default:
				System.out.println("You are out Successfully");
				System.exit(0);
				break;
			}
		}
	}
	

	static void insert() {

		try {
			// create a mysql database connection
			String myDriver = "com.mysql.jdbc.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/mohan";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "bridgeit");

			// the mysql insert statement
			String query = " insert into emp (id,name,age)" + " values (?, ?, ?)";

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, 10);
			preparedStmt.setString(2, "Rubble");
			preparedStmt.setInt(3, 20);

			// execute the preparedstatement
			preparedStmt.execute();

			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
	}

	static void delete() {

		try {
			// create a mysql database connection
			String myDriver = "com.mysql.jdbc.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/mohan";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "bridgeit");

			// // create a sql date object so we can use it in our INSERT statement
			// Calendar calendar = Calendar.getInstance();
			// java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

			String query = "delete from emp where id = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, 10);

			// execute the preparedstatement
			preparedStmt.execute();

			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
	}

	
	static void update() {

		try {
			// create a mysql database connection
			String myDriver = "com.mysql.jdbc.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/mohan";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "root", "bridgeit");

			// create the java mysql update preparedstatement
			String query = "update emp set name = ? where id = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, "rahul");
			preparedStmt.setInt(2, 10);

			// execute the preparedstatement
			preparedStmt.execute();

			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
	}
	
	
	static void display() {
		try {

			// Register the driver class
			Class.forName("com.mysql.jdbc.Driver");

			// Creating connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mohan", "root", "bridgeit");

			// Create the Statement object
			Statement stmt = con.createStatement();

			// Execute the query
			ResultSet rs = stmt.executeQuery("select * from emp");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			}

			// Close the connection object
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}	
}
