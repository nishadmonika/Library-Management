
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out = response.getWriter();
		 response.setContentType("text/html");
			out.println("<head>");
			out.println("<title>Updatebook</title>");
			out.println("<style>"); 
			
			out.println(" header{\r\n" + 
					"      background-image: linear-gradient(to bottom right, red, yellow);\r\n" + 
					"      \r\n" + 
					"     box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);\r\n" + 
					"    color:#000000;\r\n" + 
					"    padding:15px;\r\n" + 
					"    border-top: 1px;   \r\n" + 
					"text-align: center;}footer{\r\n" + 
					"     background-image: linear-gradient(to bottom right, red, yellow);\r\n" + 
					"     box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);\r\n" + 
					"    text-align: right;\r\n" + 
					"    padding: 20px;\r\n" + 
					"    \r\n" + 
					"} ");
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
					"a {\r\n" + 
					"	display: block;\r\n" + 
					"	color: black;\r\n" + 
					"	\r\n" + 
					"	text-align: center;\r\n" + 
					"	padding: 15px 40px;\r\n" + 
					"	text-decoration: none;\r\n" + 
					"}");
					
			  out.println("body {				background-image: linear-gradient(to right, rgb(231, 231, 194), rgb(96, 231, 194));\r\n" + 
			  		"\r\n" + 
			  		"}\r\n" + 
			  		"");  
			  out.println("</style>"); 
			  
			  
			  out.println("<body>");
			  
out.println("<ul>\r\n" + 
		"<img class=\"logo\" src=\"image/logo7.png\" width=\"200px\" height=\"150px\" style=\"float: left; margin-top: 0px;\"></li>\r\n" + 
		"     <li><a href=\"adminHome.jsp\">Home</a></li>\r\n" + 
		"		</ul> ");
			  

	       
	        String n6 = request.getParameter("bookid");
	        String n7 = request.getParameter("ISBN");
	        String n8 = request.getParameter("Bname");
	        String n9 = request.getParameter("category");
	        String n10 = request.getParameter("book_author");
	        String n11 = request.getParameter("Edition");
	        String n12 = request.getParameter("publication");
	        String n13 = request.getParameter("quantity");

	        String n14 = request.getParameter("availability");
	      
	        Connection c1 = null;
			Statement s1=null;
		boolean notIssued=false;
		
		
		try {
			 Class.forName("com.mysql.jdbc.Driver");
				
				c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/library" ,"root", "1234");
				s1=c1.createStatement();
			
			
			
				 int result1 = s1.executeUpdate("update Books set bookid='"+n6+"',ISBN='"+n7+"',bookName='"+n8+"',category='"+n9+"',AuthorName='"+n10+"',Edition='"+n11+"',Publication='"+n12+"',Quantity='"+n13+"', Availablity='"+n14+"' where ISBN='"+n7+"'");			
			 out.println("<script type=\"text/javascript\">");
		       out.println("alert('Book Updated Succesfully');");
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
	
	
	
		

}
	
}

