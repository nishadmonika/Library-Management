

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class Student_login_servlet
 */
 class Validate {
    public static boolean checkUser(String adhaar1,String pswd) 
    { 
        boolean st =false;
        try {
        	Connection c = null;
    		Statement s=null;
            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database
            Class.forName("com.mysql.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/library" ,"root", "1234");
			s=c.createStatement();
            PreparedStatement ps = (PreparedStatement) c.prepareStatement("select * from RegisteredStudent where adhaar=? and password=? and status='accepted'");
            ps.setString(1, adhaar1);
            ps.setString(2, pswd);
            ResultSet rs =ps.executeQuery();
           // st = rs.next();
            if(rs.next()==false)
            
            {
            	return false;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return true;                 
    }   
}
public class Student_login_servlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//out.println("<a href='student_login.html' style='float:right; color:black;margin-right:10px '> <b style=' color:black;'>Logout</b> </a> &nbsp&nbsp"); 
				
        
        
        String adhaar = request.getParameter("UserId");
        String pswd = request.getParameter("password");
        
        if(Validate.checkUser(adhaar, pswd))
        { HttpSession session=request.getSession();  
        session.setAttribute("name",adhaar); 
        request.getRequestDispatcher("studhome.jsp").include(request, response);  
        	//RequestDispatcher rs = request.getRequestDispatcher("studentHome.jsp");
        //rs.forward(request, response);
        }
        else
        {
        	out.println("<script type=\"text/javascript\">");
		       out.println("alert('Not a valid student');");
		       out.println("</script>");
		       RequestDispatcher rs = request.getRequestDispatcher("student_login.html");
		        rs.include(request, response);
        }
    }  
	}

