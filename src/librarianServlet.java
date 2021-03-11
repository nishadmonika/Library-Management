

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
 class Validate2 {
    public static boolean checkUser(String userid,String pswd) 
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
            PreparedStatement ps = (PreparedStatement) c.prepareStatement("select * from librarian where userid=? and password=?");
            ps.setString(1, userid);
            ps.setString(2, pswd);
            ResultSet rs =ps.executeQuery();
            st = rs.next();
            

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;                 
    }   
}
public class librarianServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String userid = request.getParameter("UserId");
        String pswd = request.getParameter("password");
        
        if(Validate2.checkUser(userid, pswd))
        {HttpSession session=request.getSession();  
        session.setAttribute("name",userid); 
        request.getRequestDispatcher("LibraryHome.jsp").include(request, response);  
            
        }
        else
        {
        	String message = "Incorrect UserId or password";
        	request.setAttribute("message", message);
        	
             request.getRequestDispatcher("LibLogin.jsp").forward(request, response);  
        }
    }  
	}

