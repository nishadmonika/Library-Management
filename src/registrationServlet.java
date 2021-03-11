

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

public class registrationServlet extends HttpServlet{
  public void doPost(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {
	  PrintWriter out = response.getWriter();
		boolean isMultipart = ServletFileUpload.isMultipartContent(request); 
		List<FileItem> items = null;
		try {
			items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList arr=new ArrayList();

		for (FileItem item : items) {
			if (item.isFormField()) {
				// Process regular form field (input type="text|radio|checkbox|etc", select, etc).
				String fieldname = item.getFieldName();
				String fieldvalue = item.getString();
				System.out.println(fieldvalue);
				arr.add(fieldvalue);
			} 
			else {
				// Process form file field (input type="file").
				String itemName = item.getName();
				Random generator = new Random();
			  int r = Math.abs(generator.nextInt());
			  String reg = "[.*]";
			  String replacingtext = "";
			  System.out.println("Text before replacing is:-" + 
			  itemName);
			  Pattern pattern = Pattern.compile(reg);
			  Matcher matcher = pattern.matcher(itemName);
			  StringBuffer buffer = new StringBuffer();

			  while (matcher.find()) {
			  matcher.appendReplacement(buffer, replacingtext);
			  }
			  int IndexOf = itemName.indexOf("."); 
			  String domainName = itemName.substring(IndexOf);
			  System.out.println("domainName: "+domainName);

			  String finalimage = buffer.toString()+"_"+r+domainName;
			  String[]arr1= finalimage.split("\\\\");
			  
			  System.out.println("Final Image=="+arr1[arr1.length-1]);
				// Process form file field (input type="file").
//				String fieldname = item.getFieldName();
//				String filename = FilenameUtils.getName(item.getName());
				InputStream filecontent = item.getInputStream();
			//	System.out.println(filename);    
				File savedFile = new File("C:\\UploadedFiles\\" +arr1[arr1.length-1]);
				String path="C:\\\\\\\\"+"UploadedFiles"+"\\\\\\\\"+arr1[arr1.length-1];
				arr.add(path);
				try {
					item.write(savedFile);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		Connection c = null;
		Statement s=null;
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
//		int result = s.executeUpdate("insert into RegisteredStudent  values('"+adhaar+"',"+"'"+name+"',"+"'"+fname+"','"+email+"','"+contact+"','"+psw+"','"+"pending"+"','"+gender+"')");
		try {
			int result = s.executeUpdate("insert into RegisteredStudent  values('"+arr.get(3)+"',"+"'"+arr.get(0)+"',"+"'"+arr.get(1)+"','"+arr.get(4)+"','"+arr.get(5)+"','"+arr.get(6)+"','"+"pending"+"','"+arr.get(2)+"','"+arr.get(8)+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rs = request.getRequestDispatcher("WelcomeStudent.html");
        rs.forward(request, response);
//String Path= "C:\\UploadedFiles\\" +arr[arr.length-1];
  }}
	

