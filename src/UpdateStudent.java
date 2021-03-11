

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.util.regex.*;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
//import org.apache.commons.io.FilenameUtils;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class UpdateStudent extends HttpServlet{
  public void doGet(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {
	  PrintWriter out = response.getWriter();
	 
		 response.setContentType("text/html");
			out.println("<head>");
			out.println("<title>UpdateDetails</title>");
			out.println("<style>"); 
			
			out.println(" footer{\r\n" + 
					"     background-image: linear-gradient(to bottom right, white,brown);;\r\n" + 
					"     box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);\r\n" + 
					"    text-align: right;\r\n" + 
					"    padding: 20px;\r\n" + 
					"    \r\n" + 
					"}\r\n" + 
					"");
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
					".dropdown:hover .dropbtn {background-image: linear-gradient(to bottom right, #0000ff, white);}");
					
			  out.println("body {\r\n" + 
			  		"		background-image: linear-gradient(to right, rgb(231, 231, 194), rgb(96, 231, 194));\r\n" + 
			  		"\r\n" + 
			  		"	text-align: center;\r\n" + 
			  		"	padding: 10px;\r\n" + 
			  		"	 \r\n" + 
			  		"}\r\n" + 
			  		"");  
			  out.println("</style>"); 
			  
			  out.println("<body>");
			  
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
		"  </div> ");
			  

	       
	        String n6 = request.getParameter("student_id");
	        String n7 = request.getParameter("student_name");
	        String n8 = request.getParameter("student_father_name");
	        String n9 = request.getParameter("student_gender");
	        String n10 = request.getParameter("student_email");
	        String n11 = request.getParameter("student_contact");
	        String n12 = request.getParameter("pass");
	        Connection c1 = null;
			Statement s1=null;
		boolean notIssued=false;
		
		
		try {
			 Class.forName("com.mysql.jdbc.Driver");
				
				c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/library" ,"root", "1234");
				s1=c1.createStatement();
			
			
			
				 int result1 = s1.executeUpdate("update registeredstudent set adhaar='"+n6+"',Name='"+n7+"',FName='"+n8+"',email='"+n10+"',contact='"+n11+"',password='"+n12+"',gender='"+n9+"' where adhaar='"+n6+"'");			
			 out.println("<script type=\"text/javascript\">");
		       out.println("alert('Details Updated Succesfully');");
		       out.println("</script>");
		      
		
	        		
	}	catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
			 
			 out.println("</body>");  
		      // out.println("<footer>Copyright &copy; Library Management System </footer>");  
	
  }}
	

