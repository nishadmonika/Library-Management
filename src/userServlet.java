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

public class userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection c = null;
		Statement s = null;
		PreparedStatement ps = null;
		PrintWriter out=response.getWriter();
		//PrintWriter out=request.getWriter();
		response.setContentType("text/html");
		out.println("<head>");
		out.println("<title> valid students</title>");

		out.println("<style>");
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
				"  min-width: 60px;\r\n" + 
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
				".dropdown:hover .dropbtn {background-image: linear-gradient(to bottom right, #0000ff, white);}");
		
		out.println("body {\r\n" + 
				"	\r\n" + 
				"	\r\n" + 
				"	background-image: linear-gradient(to right, rgb(231, 231, 194), rgb(96, 231, 194));\r\n" + 
				"	color: black;\r\n" + 
				"	\r\n" + 
				"}");

		out.println("}");  
		out.println("table{");
		out.println(" border-collapse: collapse;");   
		out.println(" margin:10px;");
		out.println("}"); 
		out.println(" table, td, th {");
		out.println(" border: 1px solid black;");
		out.println("}"); 
		out.println("  th,td {");
		out.println(" color:#000000;"
		 		+ "padding:15px;"
		 		+ "transition:all 0.3s ease;");
		out.println("}");
		out.println("  th{");
		out.println(" background:lightgray;");
		out.println("}");
		out.println("  th:hover,td:hover {");
		out.println(" background:darkgray;"
				+ "color:white;");
		out.println("}");
		out.println(".transbox {"
				+ "  display:inline-block;"
				+ "  margin: 30px;"
				+ "  background-color: #ffffff;"
				+ "  border: 1px solid black;"
				+ "  opacity: 0.9;"
				+ "}");
		out.println(".back-btn{");
		out.println("  padding:10px;"
				+ "     background: gray;"
				+ "     border: 1px solid white;");
		out.println("}"); 
		out.println("</style>"); 
		
		
		out.println("<body> "
				+ "<img class=\"logo\" src=\"image/logo7.png\" width=\"200px\" height=\"150px\" style=\"float: left; margin-top: 0px;\">\r\n" + 
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
				"  </div>\r\n" + 
				"\r\n" + 
				"</div>");
		out.println("<br><br> <br><br><br>"
				+ "<h1 style=\"text-align:center;\"><u>Details Of Valid Students</u></h1>" );
		
		
		out.println("<div class='transbox'>");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s = c.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs;
		try {
			rs = s.executeQuery("select * from RegisteredStudent where status='accepted'");
			out.println("<table>");  
			out.println("<tr><th>Adhaar</th><th>Name</th><th>Father's Name</th><th>Email</th><th>Contact</th><th>Password</th><th>Gender</th><th>Status</th><tr>");  
			
			while (rs.next()) {
				String n = rs.getString("adhaar");
				String n1 = rs.getString("Name");
				String n2 = rs.getString("FName");
				String n3 = rs.getString("email");
				String n4 = rs.getString("contact");
				String n5 = rs.getString("password");
				String n6 = rs.getString("status");
				String n7 = rs.getString("gender");
				// String n8 = rs.getString("adhaarImg");
				out.print("<tr><td>" + n + "</td><td>" + n1 + "</td><td>" + n2 + "</td><td>" + n3 + "</td><td>" + n4
						+ "</td><td>" + n5 + "</td><td>" + n7 + "</td><td>" + n6 + "</td></tr>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		out.println("</table>");
		out.println("</div>");
		out.println("</body>");
		out.println("<br>");
		out.println("<br>");
		out.println("<br>");
		out.println("<br>");
		out.println("<br>");
		out.println("<br>");out.println("<br>");out.println("<br>");out.println("<br>");out.println("<br>");

		out.println("<footer>Copyright &copy; Library Management System </footer>"); 
		out.println("</html>");
	}
}