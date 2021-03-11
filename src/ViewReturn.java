

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewReturn extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Connection c = null;
			Statement s=null;
			PreparedStatement ps = null;
			PrintWriter out = response.getWriter();  
			response.setContentType("text/html");
			out.println("<head>");
			out.println("<title>detailsOfReturn</title>");
			out.println("<style>"); 
			out.println("body {\r\n" + 
			  		"		background-image: linear-gradient(to right, rgb(231, 231, 194), rgb(96, 231, 194));\r\n" + 
			  		"\r\n" + 
			  		"	text-align: center;\r\n" + 
			  		"	padding: 10px;\r\n" + 
			  		"	 \r\n" + 
			  		"}");

		  out.println("h3 {");        // note leading brace
		  out.println("margin-left:10px;}");
		  out.println("table{");
		  out.println(" border-collapse: collapse;");       
		  out.println("}"); 
		 out.println(" table, td, th {");
		 out.println(" height :20px;border: 1px solid grey;");
		 out.println("}"); 
		 out.println("  th {");
		 out.println(" color:black;"
		 		+ ";");
		 out.println("}");
			out.println(".dropbtn {\r\n" + 
					"  background-image: linear-gradient(to bottom right, white,brown);\r\n" + 
					"  color: white;\r\n" + 
					"  padding: 16px;\r\n" + 
					" font-size: 20px;\r\n" + 
					"	  font-style: italic;\r\n" + 
					"font-weight:bold;\r\n" + 
					"	font-family: georgia,garamond,serif;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					".dropdown {\r\n" + 
					" float:right;\r\n" + 
					" margin-right:5px;\r\n" + 
					"  display: inline-block;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					".dropdown-content {overflow: hidden;\r\n" + 
					"	font-size: 15px;\r\n" + 
					"	  font-style: italic;\r\n" + 
					"		color: red;\r\n" + 
					"font-weight:bold;\r\n" + 
					"	font-family: georgia,garamond,serif;\r\n" + 
					"  display: none;\r\n" + 
					"  position: absolute;\r\n" + 
					"  background-color: #f1f1f1;\r\n" + 
					"  min-width: 100px;\r\n" + 
					"  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);\r\n" + 
					"  z-index: 1;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					".dropdown-content a {\r\n" + 
					"  color: black;\r\n" + 
					"  padding: 12px 16px;\r\n" + 
					"  text-decoration: none;\r\n" + 
					"  display: block;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					".dropdown-content a:hover {background-image: linear-gradient(to bottom right, red, yellow);}\r\n" + 
					"\r\n" + 
					".dropdown:hover .dropdown-content {display: list-item;}\r\n" + 
					"\r\n" + 
					".dropdown:hover .dropbtn {background-image: linear-gradient(to bottom right, #0000ff, white);}\r\n" + 
					"");
			
			out.println("footer{\r\n" + 
					"     background-image: linear-gradient(to bottom right, white,brown);;\r\n" + 
					"     box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);\r\n" + 
					"    text-align: right;\r\n" + 
					"    padding: 20px;\r\n" + 
					"    \r\n" + 
					"}\r\n" + 
					" ");


			  out.println("</style>");  
			 
			out.println("<body > ");
			out.println("<img class=\"logo\" src=\"image/logo7.png\" width=\"200px\" height=\"150px\" style=\"float: left; margin-top: 0px;\">\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"<div class=\"dropdown\">\r\n" + 
					"  <h class=\"dropbtn\">Logout</h>\r\n" + 
					"   <div class=\"dropdown-content\">\r\n" + 
					"    <a href=\"AdminLogoutServlet\">Logout</a>\r\n" + 
					"  </div></div>\r\n" + 
					"\r\n" + 
					"<div class=\"dropdown\">\r\n" + 
					"   <h class=\"dropbtn\">Book Statistics</h>\r\n" + 
					"  <div class=\"dropdown-content\">\r\n" + 
					"    <a href=\"ViewAllBooks\">View All Books</a>\r\n" + 
					"    <a href=\"ViewIssueBook\">View\r\n" + 
					"				Issued Books</a>\r\n" + 
					"    <a href=\"ViewReturn\">View Returned Book</a>\r\n" + 
					"  </div>\r\n" + 
					"  \r\n" + 
					"  \r\n" + 
					"</div>\r\n" + 
					"\r\n" + 
					"  <div class=\"dropdown\">\r\n" + 
					"   <h class=\"dropbtn\">Manage Users</h>\r\n" + 
					"  <div class=\"dropdown-content\">\r\n" + 
					"    <a href=\"userServlet\">View User</a>\r\n" + 
					"    <a href=\"VerificationServlet\">View\r\n" + 
					"				Pending User</a>\r\n" + 
					"    <a href=\"updateStudent.jsp\">Update\r\n" + 
					"				 User </a>\r\n" + 
					"  </div>\r\n" + 
					"  \r\n" + 
					"</div>\r\n" + 
					"<div class=\"dropdown\">\r\n" + 
					"  <h class=\"dropbtn\">Manage Books</h>\r\n" + 
					"  <div class=\"dropdown-content\">\r\n" + 
					"    <a href=\"bookadmin.jsp\">Search Book </a>\r\n" + 
					"    <a href=\"Updatebook.jsp\">Update Book</a>\r\n" + 
					"    <a href=\"Addbook.html\">Add Book</a>\r\n" + 
					"     <a href=\"deletebooks.jsp\">Delete Book</a>\r\n" + 
					"  </div></div><br><br><br><br><br><br><br><br>");
			
			out.println("<h3 style=\"margin-right:200px; color:blue;\" > <u>Details Of Returned Book</u></h3>");
			

			try 
			{  
				Class.forName("com.mysql.jdbc.Driver");
				try {
					c=DriverManager.getConnection("jdbc:mysql://localhost:3306/library" ,"root", "1234");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					s=c.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ResultSet rs = s.executeQuery("select * from returnbook");  
				out.println("<table height=50% width=50% >");  
				out.println("<tr><th>studentid</th><th>Name</th><th>Email</th><th>contact</th><th>Bookid</th><th>ISBN</th><th>BookName</th><th>Category</th><th>AuthorName</th><th>Edition</th><th>DateOfIssue</th><th>ReturnDate</th><th>ActualReturnDate</th><th>Penalty</th><tr>");  
				while (rs.next()) 
				{  					String s1 = rs.getString("studentid");  
				String s2= rs.getString("Name");  
				String s3 = rs.getString("Fname");  
				String s4 = rs.getString("gender");  
				String s5 = rs.getString("email");  
				String s6 = rs.getString("contact");  

					String n = rs.getString("bookid");  
					String n1 = rs.getString("ISBN");  
					String n2 = rs.getString("bookName");  
					String n3 = rs.getString("category");  
					String n4 = rs.getString("AuthorName");  
					String n5 = rs.getString("Edition");
					String n6 = rs.getString("Publication");  

					String n7 = rs.getString("dateOfIssue");
					String n8 = rs.getString("returnDate");  
					String n9= rs.getString("ActualReturnDate");  
					String n10 = rs.getString("penalty");  
					//String n8 = rs.getString("adhaarImg");  



					out.print("<tr><td>" + s1 + "</td><td>" + s2 + "</td><td>" + s5 + "</td><td>" + s6 + "</td><td>" + n + "</td><td>" + n1 + "</td><td>" + n2 + "</td><td>" + n3 + "</td><td>" + n4+ "</td><td>" + n5 + "</td><td>" + n7 + "</td><td>" + n8 + "</td><td>" + n9+ "</td><td>" + n10 + "</td></tr>");   
				} 

				out.println("</table>"); 
				out.println("<form >"); 
				
	}
			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.println("</body><br><br><br><br><br><br><br><br><br><br><br><br><br>");
			out.println("<footer>Copyright &copy; Library Management System </footer>	");			
	}

	
}

