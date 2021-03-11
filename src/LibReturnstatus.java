

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

public class LibReturnstatus extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Connection c = null;
			Statement s=null;
			PreparedStatement ps = null;
			PrintWriter out = response.getWriter();  
			response.setContentType("text/html");
			out.println("<head>");
			out.println("<title>Check return</title>");
			out.println("<style>"); 
			
			  out.println("body {background-image: linear-gradient(to right, rgb(231, 231, 194), rgb(96, 231, 194));}\r\n" + 
			  		"");  
			  
			  out.println("table{");
			  out.println(" border-collapse: collapse;");       
			  out.println("}"); 
			 out.println(" table, td, th {");
			 out.println(" height :20px;border: 1px solid black;");
			 out.println("}"); 
			 out.println("  th {");
			 out.println(" color:black"
			 		+ ";");
			 out.println("}");
				out.println("footer{\r\n" + 
						"     background-image: linear-gradient(to bottom right, white,brown);;\r\n" + 
						"     box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);\r\n" + 
						"    text-align: right;\r\n" + 
						"    padding: 20px;\r\n" + 
						"    \r\n" + 
						"}");

out.println("ul {\r\n" + 
		"	height: 150px;\r\n" + 
		"	list-style-type: none;\r\n" + 
		"	margin-top: 0px ;\r\n" + 
		"	padding: 0;\r\n" + 
		"	overflow: hidden;\r\n" + 
		"	font-size: 20px;\r\n" + 
		"	  \r\n" + 
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
		"a { background-image: linear-gradient(to bottom right, white,brown);;\r\n" + 
		"	display: block;\r\n" + 
		"	color: black;\r\n" + 
		"	\r\n" + 
		"	text-align: center;\r\n" + 
		"	padding: 0px ;\r\n" + 
		"	text-decoration: none;\r\n" + 
		"}\r\n" + 
		"a:hover {\r\n" + 
		"	color: white;\r\n" + 
		"	background-image: linear-gradient(to bottom right, white,blue);;\r\n" + 
		"}");
out.println("table { margin-left:auto;\r\n" + 
		"margin-right:auto;\r\n" + 
		"	border-collapse: collapse;\r\n" + 
		"}");
out.println("h3{ text-align:center; color:blue;}");
			  out.println("</style>");  
			  
			out.println("<body > ");
			out.println("<nav>\r\n" + 
					"\r\n" + 
					"   <ul>\r\n" + 
					"\r\n" + 
					"       <img class=\"logo\" src=\"image/logo7.png\" width=\"200px\" height=\"150px\" style=\"float: left; margin-top: 0px;\"></li>\r\n" + 
					"		<li id=\"lst\"><a href= \"LibLogin.jsp\">Logout</a></li>\r\n" + 
					"		  <li><a href=\"LibReturnstatus\">Check Return status</a></li>\r\n" + 
					"		   <li><a href=\"bookreturn.jsp\">Return Book </a></li>\r\n" + 
					"		   <li><a href=\"issuebook.jsp\">Issue Book </a></li>\r\n" + 
					"		\r\n" + 
					"        <li><a href=\"LibSearch.jsp\">Search Book</a></li>\r\n" + 
					"        <li><a href=\"Homepage1.html\">Home</a></li>\r\n" + 
					"        \r\n" + 
					"        \r\n" + 
					"       \r\n" + 
					"       <!--  <li><a href=\"#\">Staff Details</a></li>-->\r\n" + 
					"       \r\n" + 
					"          \r\n" + 
					"	</ul>\r\n" + 
					"    </nav>");
				
			out.println("<h3  > Check Book Returned Status:</h3>");
			out.println("<form action=\"#\" method=\"get\" >\r\n" + 
					"<div class=\"form-container\">\r\n" + 
					"			<table class=\"table-main\">\r\n" + 
					"				<tr>\r\n" + 
					"				<td>Student ID</td>\r\n" + 
					"					<td><input type=\"number\" name=\"student_id\"  required>\r\n" + 
					
					"						<td><input type=\"submit\" value=\"Check\" \"\r\n" + 
					"						style=\"margin-left: 10px; background-color: black; color:white;\"></td>\r\n" + 
					"				</tr>\r\n" + 
					"  \r\n" + 
					"</table></div></form>");
			
			try{  Connection c1=null;
			Statement s1=null;
			
				String id=request.getParameter("student_id");
		
			String isbn=request.getParameter("ISBN");
			Class.forName("com.mysql.jdbc.Driver");
		    c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/library" ,"root", "1234");
		    s1=c1.createStatement();
			ResultSet rs;
			rs= s1.executeQuery("select * from returnbook where  studentid='"+id+"' ");
			//ResultSet rs1 = s.executeQuery("select * from RegisteredStudent where adhaar='"+id+"'  ");
			out.println("<table height=50% width=50% >");  
			out.println("<tr><th>studentid</th><th>Name</th><th>Email</th><th>contact</th><th>Bookid</th><th>ISBN</th><th>BookName</th><th>Category</th><th>AuthorName</th><th>Edition</th><th>DateOfIssue</th><th>ReturnDate</th><th>ActualReturnDate</th><th>Penalty</th><tr>");  
		    

			 
				
				while (rs.next()) 
				{  					String s7 = rs.getString("studentid");  
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



					out.print("<tr><td>" + s7 + "</td><td>" + s2 + "</td><td>" + s5 + "</td><td>" + s6 + "</td><td>" + n + "</td><td>" + n1 + "</td><td>" + n2 + "</td><td>" + n3 + "</td><td>" + n4+ "</td><td>" + n5 + "</td><td>" + n7 + "</td><td>" + n8 + "</td><td>" + n9+ "</td><td>" + n10 + "</td></tr>");   
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

