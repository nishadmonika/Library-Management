<%@page import="com.sun.org.apache.xalan.internal.xsltc.compiler.sym"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.*,java.util.*"%>
	<%
	 Connection c = null;
             		Statement s=null;
             String isbn=null;
             String id=null;%>
             	
<!DOCTYPE html>
<html>
<head>
<title>Update Student</title>
<style>
.dropbtn {
  background-image: linear-gradient(to bottom right, white,brown);
  color: white;
  padding: 16px;
 font-size: 20px;
	  font-style: italic;
font-weight:bold;
	font-family: georgia,garamond,serif;
}

.dropdown {
 float:right;
 margin-right:5px;
  display: inline-block;
}

.dropdown-content {overflow: hidden;
	font-size: 15px;
	  font-style: italic;
		color: red;
font-weight:bold;
	font-family: georgia,garamond,serif;
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 100px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-image: linear-gradient(to bottom right, red, yellow);}

.dropdown:hover .dropdown-content {display: list-item;}

.dropdown:hover .dropbtn {background-image: linear-gradient(to bottom right, #0000ff, white);}

body {
		background-image: linear-gradient(to right, rgb(231, 231, 194), rgb(96, 231, 194));

	text-align: center;
	padding: 10px;
	 
}

h1 {
	align: center;
	margin-top: 0px;
	margin-right: auto;
	margin-down: 10px;
	margin-left: auto;
}

.form-container {
	display: inline-block;
}

.table-main {
	padding: 10px;
	box-shadow: 2px 2px 3px 5px grey;
	border-radius: 25px;
	position: center;
	margin: auto;
	align: center;
	background-color: #eeeeee;
}

td {
	padding: 10px;
}



.btn-bottom {
	
	margin-right: 50px;
	background-color: black;
	align: center;
	font-size: 20px;
	color: white;
	padding: 10px;
	border: none;
	cursor: pointer;
	border-radius: 6px;
}


.btn-bottom1 {
	background-color: grey;
	align: center;
	font-size: 20px;
	color: black;
	padding: 10px;
	border: none;
	cursor: pointer;
	border-radius: 6px;
}
footer{
     background-image: linear-gradient(to bottom right, white,brown);;
     box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
    text-align: right;
    padding: 20px;
    
}


</style>
</head>

<body>
<img class="logo" src="image/logo7.png" width="200px" height="150px" style="float: left; margin-top: 0px;">


<div class="dropdown">
  <h class="dropbtn">Logout</h>
   <div class="dropdown-content">
    <a href="AdminLogoutServlet">Logout</a>
  </div></div>

<div class="dropdown">
   <h class="dropbtn">Book Statistics</h>
  <div class="dropdown-content">
    <a href="ViewAllBooks">View All Books</a>
    <a href="ViewIssueBook">View
				Issued Books</a>
    <a href="ViewReturn">View Returned Book</a>
  </div>
  
  
</div>

  <div class="dropdown">
   <h class="dropbtn">Manage Users</h>
  <div class="dropdown-content">
    <a href="userServlet">View User</a>
    <a href="VerificationServlet">View
				Pending User</a>
    <a href="updateStudent.jsp">Update
				 User </a>
  </div>
  
</div>
<div class="dropdown">
  <h class="dropbtn">Manage Books</h>
  <div class="dropdown-content">
    <a href="bookadmin.jsp">Search Book </a>
    <a href="Updatebook.jsp">Update Book</a>
    <a href="Addbook.html">Add Book</a>
     <a href="deletebooks.jsp">Delete Book</a>
  </div></div>
  <br><br><br>
<br><br><br><br>
<div id ="is">
<h1 style="color:blue;"><u>Please Provide student id to Update details</u></h1>
<form action="#" method="post" >
<div class="form-container">
			<table class="table-main">
				<tr>
				
				<td>Student ID</td>
					<td><input type="number" name="student_id"  required>
						<td><input type="submit" value="Fetch_Details" "
						style="margin-left: 10px; background-color: black; color:white;"></td>
				</tr>
  
</table></div></form>

			<br><br><br><br>
<%  
try{ 
	id=request.getParameter("student_id");
	Class.forName("com.mysql.jdbc.Driver");
    c=DriverManager.getConnection("jdbc:mysql://localhost:3306/library" ,"root", "1234");
    s=c.createStatement();
	ResultSet rs1;
	rs1= s.executeQuery("select * from registeredstudent where adhaar='"+id+"'  ");
	//ResultSet rs1 = s.executeQuery("select * from RegisteredStudent where adhaar='"+id+"'  ");
    while(rs1.next())
    {%>
    	<form action="UpdateStudent" method="get">
		<div class="form-container">
			<table class="table-main" style="height:60%;">
				
				
				<tr>

					<td>Student ID</td>
					<td><input type="number" name="student_id" value="<%=rs1.getString("adhaar")%>"readonly  >
	              
	</td></tr>
	<tr><td>Name</td>
					<td><input type="text" name="student_name"  value="<%=rs1.getString("Name")%>" readonly></td>
					</tr>
					<tr>
					<td>Father's Name</td>
					<td><input type="text" name="student_father_name"  value="<%=rs1.getString("FName")%>"></td></tr>
	<tr><td>Gender</td>
					<td><input type="text" name="student_gender"  value="<%=rs1.getString("gender")%>" readonly></td></tr>
					<tr><td>E-mail</td>
					<td><input type="email" name="student_email"  value="<%=rs1.getString("email")%>"> </td></tr>
					<tr>
					<td>Contact</td>
					<td><input type="number" name="student_contact" value="<%=rs1.getString("contact")%>"></td></tr>
					<tr>
					<td>Password</td>
					<td><input type="text" name="pass" value="<%=rs1.getString("password")%>"></td></tr>
			</table>
			<br><br>
			<div class="bottom-items">
		        <input type="submit" value="update" class="btn-bottom1" >
				
				
				
			</div>
	
		</div>
		
	</form>
	
				<% 
}}
    catch (SQLException e) {
		e.printStackTrace();
	} 



%>

	
</body>
<br>
<br><br><br><br><br><br>


 <footer>Copyright &copy; Library Management System </footer>
</html>