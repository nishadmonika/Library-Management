import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
import java.sql.*;  
//class Verification{
//	public static boolean validate(String name)
//	{ String id="123456789123";
//		if(name.equals(id))
//		{System.out.println("yes");
//			
//			
//			return true;
//		}
//		else
//			return false;
//	}
//}
public class VerificationServlet extends HttpServlet  
{    
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
	{  Connection c = null;
	Statement s=null;
	PreparedStatement ps = null;
	PrintWriter out = res.getWriter();  
	res.setContentType("text/html");
	out.println("<head>");
	out.println("<title>verfication</title>");
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
	
	  out.println(" body {\r\n" + 
	  		"	\r\n" + 
	  		"	\r\n" + 
	  		"	background-image: linear-gradient(to right, rgb(231, 231, 194), rgb(96, 231, 194));\r\n" + 
	  		"	color: black;\r\n" + 
	  		"	\r\n" + 
	  		"}");  
	  out.println("h3 {");        // note leading brace
	  out.println("margin-left:10px;}");
	  out.println("table{");
	  out.println(" border-collapse: collapse;");       
	  out.println("}"); 
	 out.println(" table, td, th {");
	 out.println(" border: 1px solid black;");
	 out.println("}"); 
	 out.println("  th {");
	 out.println(" color:black"
	 		+ ";"
			 );
	 out.println("}");
		

out.println("footer{\r\n" + 
		"     background-image: linear-gradient(to bottom right, white,brown);;\r\n" + 
		"     box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);\r\n" + 
		"    text-align: right;\r\n" + 
		"    padding: 20px;\r\n" + 
		"    \r\n" + 
		"}");
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
			"  </div>\r\n" + 
			"\r\n" + 
			"</div><br><br><br><br><br><br><br>");
	out.println("<h3 style=\"text-align:center; margin-right:350px\"> <u>Details Of Pending Users</u></h3>");
	

	try 
	{  
		Class.forName("com.mysql.jdbc.Driver");
		c=DriverManager.getConnection("jdbc:mysql://localhost:3306/library" ,"root", "1234");
		s=c.createStatement();
		ResultSet rs = s.executeQuery("select * from RegisteredStudent where status='pending'");  
		out.println("<table height=50% width=100% >"); 
		
		out.print("<tr><th>Adhaar</th><th>Name</th><th>FathersName</th><th>email</th><th>Contact</th><th>password</th><th>Gender</th><th>Status</th><tr>");  
		while (rs.next()) 
		{  
			String n = rs.getString("adhaar");  
			String n1 = rs.getString("Name");  
			String n2 = rs.getString("FName");  
			String n3 = rs.getString("email");  
			String n4 = rs.getString("contact");  
			String n5 = rs.getString("password");  
			String n6 = rs.getString("status");
			String n7 = rs.getString("gender");  
			//String n8 = rs.getString("adhaarImg");  



			out.print("<tr><td>" + n + "</td><td>" + n1 + "</td><td>" + n2 + "</td><td>" + n3 + "</td><td>" + n4+ "</td><td>" + n5 + "</td><td>" + n7 + "</td><td>" + n6 + "</td></tr>");   
		} 

		out.println("</table>"); 
		out.println("<form >"); 
		out.println("<label>Enter Adhaar no. to verify:</label>"); 
		out.println("<input type='text' id='adhaar1' name='adhaar1' required>"); 
		out.println("<br>");

		out.println(" <label style='color:'black;' for=gender><b>Please Provide Gender </b></label>");
		out.println("<br>");
		out.println(" <input type='radio' id='male' name='gender' value='MALE'>");
		
		out.println("<label for='male'>Male</label>");
		out.println("<br>");
		out.println("<input type='radio' id='female' name='gender' value='FEMALE'>");
		out.println("<label for='female'>Female</label>");
		out.println("<br>");
	
		out.println("<br>"); 

		out.println("<input type='submit' value='Verify' >");
		 out.println("<input type=\"button\"  value=\"Back\" onclick=\"location.href='AdminHomepage.jsp';\" class=\"btn-bottom\">");

		String userid = req.getParameter("adhaar1");	
		String gen = req.getParameter("gender");	
String path="";

String path1="";
//Connection c = null;
//Statement s=null;
try {
	Class.forName("com.mysql.jdbc.Driver");
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
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
//String userid="890068909066";
ResultSet rs1 = null;
try {
	rs1 = s.executeQuery("select * from RegisteredStudent  where adhaar='"+userid+"' ");
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


try {if(rs1.next()){
	path1=rs1.getString(9);}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
System.out.println(path1);
//String path2="C:\\UploadedFiles\\deepuAdhaar_114373363.jpg" ;
//String []p=path2.split("\\\\");
		//System.out.println(path);

//out.println("<img src='p[0]+'\\\\'+p[1]+'\\\\'+p[2]' alt='Mountain' style='width:300px';>");

//
//		
//		//System.out.println(ps);
my_main n= new my_main();
boolean result=n.validate(userid, gen, path1);
		if(result==true)
		 {String str ="accepted" ;
		
				 ps = c.prepareStatement("update RegisteredStudent set status='"+str+"' where adhaar='"+userid+"' ");
				
				 ps.executeUpdate();
				 out.println("<html><head></head><body onload=\"alert('Request Approved Successfully')\"></body></html>");
				 //out.println(userid+"accepted");
				
				 //req.getRequestDispatcher("VerificationServlet").include(req, res);;
				 out.println("<script>");
					//out.println("console.log('Hello world!')");
					 out.println("</script>");

		 }
		 else
		 {
			 String str ="rejected" ;	

				 
					
					 ps = c.prepareStatement("update RegisteredStudent set status='"+str+"' where adhaar='"+userid+"' ");
					
					 ps.executeUpdate(); 
					 out.println("<html><head></head><body onload=\"alert('Request Rejected')\"></body></html>");
					// out.println(userid+"rejected");
					
		 }
		 out.flush();
			s.close();
			c.close();
		out.println("</form>");
		

		out.println("</body>");  
		out.println("<footer>Copyright &copy; Library Management System </footer>	");		
		c.close();  
	}  
	catch (Exception e) 
	{  
		
	}  
	}  
}