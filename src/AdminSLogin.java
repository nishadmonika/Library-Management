

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

class Validate1 {
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
            PreparedStatement ps = (PreparedStatement) c.prepareStatement("select * from admin where userid=? and password=?");
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
public class AdminSLogin extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        PrintWriter out = response.getWriter();
        
        String userid = request.getParameter("UserId");
        String pswd = request.getParameter("password");
        //request.getRequestDispatcher("AdminLogin.html").include(request, response);  
        //request.getRequestDispatcher("l.html").include(request, response);  

        if(Validate1.checkUser(userid, pswd))
        {    //  out.print("Welcome, "+userid);  
        HttpSession session=request.getSession();  
        session.setAttribute("name",userid); 
        request.getRequestDispatcher("adminHome.jsp").include(request, response);  

        }  
        else{  
        	String message = "Incorrect UserId or password";
        	request.setAttribute("message", message);
            request.getRequestDispatcher("AdminLogin.jsp").forward(request, response);  
        }  
        out.close();  
    }  
	}

	
