import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/ResetPassword")
public class ResetPasswordAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<head>");
		out.println("<title>issuebook</title>");
		out.println("<style>"); 
		
		  out.println("body {				background-image: linear-gradient(to right, rgb(231, 231, 194), rgb(96, 231, 194));\r\n" + 
		  		"\r\n" + 
		  		"}");  
		  out.println("</style>"); 
		 
		  out.println("<a href=AdminLogin.jsp style='float:right; color:black; margin:10px; border-radius: 20px; text-decoration:none;'><div class='back-btn'><b style='color:white;'>Back Home</b></div></a>");
out.println("<img class=\"logo\" src=\"image/logo7.png\" width=\"200px\" height=\"150px\" style=\"float: left; margin-top: 0px;\">");
		String email = request.getParameter("email");
		System.out.println("Id received:"+email);
		if(email==null || email.equals("")) {
			response.sendRedirect("ResetAdmin.html");
			out.close();
			return;
		}

		String to = null;	//<---------need to be fetched from db
		String subject = "Request to reset password";
		String password = null; //<-----------need to be fetched from db
		Connection c1=null;
		Statement s1=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
try {
	c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/library" ,"root", "1234");
} catch (SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
try {
	s1=c1.createStatement();
} catch (SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
ResultSet rs1;
//rs= s.executeQuery("select * from books where ISBN='"+isbn+"'  ");
try {
	rs1 = s1.executeQuery("select * from admin where email='"+email+"' ");
	while (rs1.next())
	{
	   
	to=rs1.getString("email");
	password=rs1.getString("password");}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

		String msg = getContentFromPassword(password);
		try {
			sendMail(to, subject, msg);
			out.println("<script type=\"text/javascript\">");
		       out.println("alert('Password Sent Succesfully To Your Registered MailId');");
		       out.println("</script>");		}
		catch(Exception ex) {
			out.println(ex.getMessage());
		}finally {out.println("</body>");  
	      // out.println("<footer>Copyright &copy; Library Management System </footer>");  
		
			out.close();
		}
	}
	
	public String getContentFromPassword(String password) {
		return "<head>\r\n"
				+ "	<style>\r\n"
				+ "		.msgHead {\r\n"
				+ "			border: 5px solid white;\r\n"
				+ "			padding: 10px;\r\n"
				+ "			margin: 10px;\r\n"
				+ "			background-color: darkblue;\r\n"
				+ "			color: white;\r\n"
				+ "		}\r\n"
				+ "\r\n"
				+ "		body {\r\n"
				+ "			background-color: lightblue;\r\n"
				+ "		}\r\n"
				+ "\r\n"
				+ "		h1,\r\n"
				+ "		h2,\r\n"
				+ "		h3 {\r\n"
				+ "			text-align: center;\r\n"
				+ "		}\r\n"
				+ "\r\n"
				+ "		code {\r\n"
				+ "			background-color: white;\r\n"
				+ "			color: navy\r\n"
				+ "		}\r\n"
				+ "\r\n"
				+ "		.msgFoot {\r\n"
				+ "			border: 3px solid white;\r\n"
				+ "			padding: 10px;\r\n"
				+ "			margin: 10px;\r\n"
				+ "			background-color: darkblue;\r\n"
				+ "			color: white;\r\n"
				+ "		}\r\n"
				+ "	</style>\r\n"
				+ "</head>\r\n"
				+ "\r\n"
				+ "<body>\r\n"
				+ "	<div class=\"msgHead\">\r\n"
				+ "		<h1>Hello user...! Your request for password change has been accepted..!</h1>\r\n"
				+ "	</div>\r\n"
				+ "\r\n"
				+ "	<h2>Kindly use the below password to log back into the system:</h2>\r\n"
				+ "	<h2>Password: <code>"+ password +"</code></h2>\r\n"
				+ "	<h3 class=\"msgFoot\">Generated by Library Management System. All Rights Reserved.</h3>\r\n"
				+ "</body>";
	}
	
	public void sendMail(String to, String subject, String msg) {
		final String user = "librarymgmtproject@gmail.com";
		final String pass = "SheArises@123";

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, pass);
			}
		});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			message.setContent(msg, "text/html");

			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}
}