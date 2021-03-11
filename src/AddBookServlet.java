import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
public class AddBookServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection c = null;
		Statement s=null;
		PrintWriter  obj= response.getWriter();
		obj.println("<head>");
		obj.println("<title>Addbook</title>");
		obj.println("<style>"); 
		
		 obj.println("body {\r\n" + 
		 		"background-image: linear-gradient(to right, rgb(231, 231, 194), rgb(96, 231, 194));}");  
		  obj.println("</style>"); 
		  
		  obj.println("<body>	<img class=\"logo\" src=\"image/logo7.png\" width=\"200px\" height=\"150px\" style=\"float: left; margin-top: 0px;\">\r\n" + 
		  		"");  
			obj.println("<a href='adminHome.jsp' style='float:right; color:black; margin:10px; border-radius: 20px; text-decoration:none;'><div class='back-btn'><b style='color:white;'>Back Home</b></div></a>");

		  
	//	String BookId=request.getParameter("BookId");
		String code=request.getParameter("code");

		String Title=request.getParameter("Title");
		String category=request.getParameter("category");

		String Author =request.getParameter("Author");
		String edition=request.getParameter("Edition");
		String publication=request.getParameter("Publish");

		String Quantity =request.getParameter("Quantity");
		String avail=request.getParameter("available");
 int no=1;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/library" ,"root", "1234");
			s=c.createStatement();
			int result =s.executeUpdate("insert into books  values(default,'"+code+"',"+"'"+Title+"',"+"'"+category+"',"+"'"+Author+"',"+"'"+edition+"',"+"'"+publication+"','"+Quantity+"',"+"'"+avail+"')");
			obj.println("<script type=\"text/javascript\">");
		       obj.println("alert('Book Added Succesfully');");
		       obj.println("</script>");
			obj.flush();
			s.close();
			c.close();
		} catch (ClassNotFoundException e) {
   
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();

		}  finally {
			if(obj != null)
				obj.close();
		}
		
		
		
	}

	
}