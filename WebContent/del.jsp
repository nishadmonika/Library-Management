<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>
<%out.println(" header{\r\n" + 
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
		
//String id=request.getParameter("id");
Connection c1 = null;
		Statement s1=null;
		//HttpSession sess = request.getSession(false); //use false to use the existing session
		String id=request.getParameter("id");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/library" ,"root", "1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s1=c1.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//String userid="890068909066";
		ResultSet rs1 = null;
		try {//PreparedStatement ps = c1.prepareStatement("delete * from books  where ISBN='"+sess.getAttribute("ISBN")+"' ");
       // ps.setString(1, uEmail);

       

        PreparedStatement ps  = c1.prepareStatement("delete  from books  where ISBN="+id+" ");
			//out.print(sess.getAttribute('ISBN'));
 int i = ps.executeUpdate();

        if(i > 0) {
            out.println("User successfully removed...");
        }
			//out.print("deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rs = request.getRequestDispatcher("deletebooks.jsp");
        rs.forward(request, response);
%>

