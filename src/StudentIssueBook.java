

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
import javax.servlet.http.HttpSession;

public class StudentIssueBook extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Connection c = null;
			Statement s=null;
			PreparedStatement ps = null;
			PrintWriter out = response.getWriter();  
			response.setContentType("text/html");
			out.println("<head>");
			out.println("<title>detailsOfIssue</title>");
			out.println("<style>"); 
			
					out.println("ul {\r\n" + 
							"	height: 150px;\r\n" + 
							"	list-style-type: none;\r\n" + 
							"	margin-top: 0px ;\r\n" + 
							"	padding: 0;\r\n" + 
							"	overflow: hidden;\r\n" + 
							"	font-size: 20px;\r\n" + 
							"	  font-style: italic;\r\n" + 
							"		color: red;\r\n" + 
							"font-weight:bold;\r\n" + 
							"	font-family: georgia,garamond,serif;\r\n" + 
							"\r\n" + 
							"}\r\n" + 
							"\r\n" + 
							"li { margin-right:25px;\r\n" + 
							"	float: right;\r\n" + 
							"	border-right: 2px solid none;\r\n" + 
							"}\r\n" + 
							"\r\n" + 
							"a {background-image: linear-gradient(to bottom right, white,brown);;\r\n" + 
							"	display: block;\r\n" + 
							"	color: black;\r\n" + 
							"	\r\n" + 
							"	text-align: center;\r\n" + 
							"	padding: 15px 40px;\r\n" + 
							"	text-decoration: none;\r\n" + 
							"}\r\n" + 
							"\r\n" + 
							"body {				background-image: linear-gradient(to right, rgb(231, 231, 194), rgb(96, 231, 194));\r\n" + 
							"\r\n" + 
							"\r\n" + 
							"	\r\n" + 
							"}");  
			  out.println("h3 {");        // note leading brace
			  out.println("margin-left:500px; color:blue; }");
			  out.println("table{ margin-left:auto; margin-right:auto;");
			  out.println(" border-collapse: collapse;");       
			  out.println("}"); 
			 out.println(" table, td, th { padding:10px;");
			 out.println(" height :20px;border: 1px solid black;");
			 out.println("}"); 
			 out.println("  th {");
			 out.println(" color:black"
			 		+ ";");
			 out.println("}");
				out.println("footer{\r\n" + 
						"     background-color: #d1d1e0;\r\n" + 
						"     box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);\r\n" + 
						"    text-align: right;\r\n" + "margin-top:300px; "+"color:black; "+
						"    padding: 20px;\r\n" + 
						"    \r\n" + 
						"}  ");


			  out.println("</style>");  
			 
			out.println("<body > ");
out.println(" <ul>\r\n" + 
		"\r\n" + 
		"       <img class=\"logo\" src=\"image/logo7.png\" width=\"200px\" height=\"150px\" style=\"float: left; margin-top: 0px;\"></li>\r\n" + 
		"		\r\n" + 
		"		<li><a href=\"StudentLogout\">Logout </a></li>\r\n" + 
		"		<li><a href=\"studprofile.jsp\">Profile</a></li>\r\n" + 
		"		<li><a href=\"StudentIssueBook\">View Issue Book</a></li>\r\n" + 
		"		<li><a href=\"studentsearch.jsp\">Search Book</a></li>\r\n" + 
		"		\r\n" + 
		"		\r\n" + 
		"	</ul><br><br>");
			out.println("<h3 > Details Of IssuedBook</h3>");
			

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
				HttpSession session=request.getSession();  
				Object o= session.getAttribute("name");
		           String sw=(String)o;
		       out.println("Your UserId is "+o);
				ResultSet rs = s.executeQuery("select * from issue where studentid='"+sw+"'  ");  
				out.println("<table height=50% width=50% >");  
				out.println("<tr><th>studentid</th><th>Name</th><th>Fathers name</th><th>Gender</th><th>Email</th><th>contact</th><th>Bookid</th><th>ISBN</th><th>BookName</th><th>Category</th><th>AuthorName</th><th>Edition</th><th>Publication</th><th>DateOfIssue</th><th>ReturnDate</th><tr>");  
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
					//String n8 = rs.getString("adhaarImg");  



					out.print("<tr><td>" + s1 + "</td><td>" + s2 + "</td><td>" + s3 + "</td><td>" + s4 + "</td><td>" + s5 + "</td><td>" + s6 + "</td><td>" + n + "</td><td>" + n1 + "</td><td>" + n2 + "</td><td>" + n3 + "</td><td>" + n4+ "</td><td>" + n5 + "</td><td>" + n6 + "</td><td>" + n7 + "</td><td>" + n8 + "</td></tr>");   
				} 

				out.println("</table>"); 
				out.println("<form >"); 
				
	}
			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.println("</body>");
			out.println("<footer>Copyright &copy; Library Management System </footer>	");			
	}

	
}

