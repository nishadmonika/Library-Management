


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ReturnBookServlet extends HttpServlet {
	
	public void	QuantityInDatabase(String isbn) throws ClassNotFoundException, SQLException{
		Connection c = null;
		Statement s=null;
			Class.forName("com.mysql.jdbc.Driver");
	    c=DriverManager.getConnection("jdbc:mysql://localhost:3306/library" ,"root", "1234");
	    s=c.createStatement();
	    int res=0;
	    ResultSet rs;
		rs= s.executeQuery("select * from Books where ISBN='"+isbn+"'   ");
		while (rs.next())
		{ res=rs.getInt("Quantity");
			
		}
		Connection c1 = null;
		Statement s1=null;
			Class.forName("com.mysql.jdbc.Driver");
	    c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/library" ,"root", "1234");
	    s1=c1.createStatement();
	    int result1 = s1.executeUpdate("update Books set Quantity='"+(++res)+"', Availablity='YES' where ISBN='"+isbn+"'");
		
		
	}
	 public void Deletefromissue(String id, String isbn) throws ClassNotFoundException, SQLException
	 {		Connection c = null;
		Statement s=null;
		Class.forName("com.mysql.jdbc.Driver");
    c=DriverManager.getConnection("jdbc:mysql://localhost:3306/library" ,"root", "1234");
    s=c.createStatement();
    
    int result1 = s.executeUpdate("delete from issue  where ISBN='"+isbn+"' AND studentid='"+id+"'");
	
	
		 
	 }
	 public void ReduceIssuedBook(String id) throws ClassNotFoundException, SQLException {
		 Connection c = null;
			Statement s=null;
				Class.forName("com.mysql.jdbc.Driver");
		    c=DriverManager.getConnection("jdbc:mysql://localhost:3306/library" ,"root", "1234");
		    s=c.createStatement();
		    int res=0;
		    ResultSet rs;
			rs= s.executeQuery("select * from bookcount where studentid='"+id+"'   ");
			while (rs.next())
			{ res=rs.getInt("Bookissued");
				
			}
			Connection c1 = null;
			Statement s1=null;
				Class.forName("com.mysql.jdbc.Driver");
		    c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/library" ,"root", "1234");
		    s1=c1.createStatement();
		    int result1 = s1.executeUpdate("update bookcount set Bookissued='"+(--res)+"' where studentid='"+id+"'");
			
			
	}
//	 public int daysBetween(java.util.Date date, java.util.Date date2){
//        return (int)( (date2.getTime() - date.getTime()) / (1000 * 60 * 60 * 24));
//}
//	 
	 
	 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// PrintWriter out = response.getWriter();
		 PrintWriter out = response.getWriter();
		 response.setContentType("text/html");
			out.println("<head>");
			out.println("<title>Return</title>");
			out.println("<style>"); 
			
					
			out.println("body {				background-image: linear-gradient(to right, rgb(231, 231, 194), rgb(96, 231, 194));\r\n" + 
			  		"\r\n" + 
			  		"}\r\n" + 
			  		"}");  
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
			  		"a { background-image: linear-gradient(to bottom right, white,brown);;\r\n" + 
			  		"	display: block;\r\n" + 
			  		"	color: black;\r\n" + 
			  		"	\r\n" + 
			  		"	text-align: center;\r\n" + 
			  		"	padding: 0px ;\r\n" + 
			  		"	text-decoration: none;\r\n" + 
			  		"}");
			  out.println("</style>");
			 
			  out.println("<body>");
out.println("<ul>\r\n" + 
		"\r\n" + 
		"       <img class=\"logo\" src=\"image/logo7.png\" width=\"200px\" height=\"150px\" style=\"float: left; margin-top: 0px;\"></li>\r\n" + 
		
		"        <li><a href=\"LibraryHome.jsp\">Home</a></li>\r\n" + 
		"        \r\n" + 
		"        \r\n" + 
		"       \r\n" + 
		"       <!--  <li><a href=\"#\">Staff Details</a></li>-->\r\n" + 
		"       \r\n" + 
		"          \r\n" + 
		"	</ul>");
			  String n = request.getParameter("student_id");
	        String n1 = request.getParameter("student_name");
	        String n2 = request.getParameter("student_father_name");
	        String n3 = request.getParameter("student_gender");
	        String n4 = request.getParameter("student_email");
	        String n5 = request.getParameter("student_contact");
	        String n6 = request.getParameter("bookid");
	        String n7 = request.getParameter("ISBN");
	        String n8 = request.getParameter("Bname");
	        String n9 = request.getParameter("category");
	        String n10 = request.getParameter("book_author");
	        String n11 = request.getParameter("Edition");
	        String n12 = request.getParameter("publication");
	        String n13 = request.getParameter("Issue_date");
	        String n14 = request.getParameter("book_return_date");
	        String n15 = request.getParameter("ActualReturn");
	        String n16 = request.getParameter("penalty");
//System.out.println(n15);
	        Connection c1 = null;
			Statement s1=null;
		
		
		
		try { int pen=0;
			 Class.forName("com.mysql.jdbc.Driver");
				
				c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/library" ,"root", "1234");
				s1=c1.createStatement();
			 	//System.out.println(n13);
					
			 
			int result = s1.executeUpdate("insert into returnBook  values('"+n+"',"+"'"+n1+"',"+"'"+n2+"','"+n3+"','"+n4+"','"+n5+"','"+n6+"','"+n7+"','"+n8+"','"+n9+"','"+n10+"','"+n11+"','"+n12+"','"+n13+"','"+n14+"','"+n15+"','"+n16+"')");
			 QuantityInDatabase(n7);
			Deletefromissue(n,n7);
	        ReduceIssuedBook(n);
	        out.println("<script type=\"text/javascript\">");
		       out.println("alert('Book Returned Succesfully');");
		       out.println("</script>");
		      
	}
	
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       out.println("</body>");

}
	
}
