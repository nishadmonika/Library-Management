<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>profile</title>
<style type="text/css">
body {
	background-color: #eeeeee;
	text-align: center;
	padding: 10px;
	background-image: linear-gradient(black, grey);
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

h1 {
	color: blue;
}

.table-main {
	box-shadow: 2px 2px 3px 5px grey;
	border-radius: 25px;
	position: center;
	margin: auto;
	background-color: #eeeeee;
}

td {
	padding: 10px;
}

.bottom-items {
	float: right;
	margin-top: 10px;
}

button:hover {
	opacity: 0.7;
}

.btn-bottom {
	margin-right: 120px;
	background-color: grey;
	align: center;
	font-size: 20px;
	color: black;
	padding: 10px;
	border: none;
	cursor: pointer;
	border-radius: 6px;
	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0
		rgba(0, 0, 0, 0.24);
}

header {
	background-color: #c2d6d6;
	background-image: linear-gradient(to bottom right, red, yellow);
	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0
		rgba(0, 0, 0, 0.24);
	color: blue;
	padding: 5px;
	border-top: 1px;
}

#first {
	color: #ff9933;
	top: 30px;
	right: 69px;
	animation-name: example;
	animation-duration: 5s;
	animation-iteration-count: infinite;
}

@
keyframes example {
	from {color: black;
}

to {
	background-color: #ff9933;
}

}
.link-box {
	float: right;
	margin-top: 0px;
	margin-right: 0px;
	background-color: black;
	align: center;
	font-size: 20px;
	color: white;
	padding: 10px;
	border: none;
	cursor: pointer;
	border-radius: 6px;
}body {				background-image: linear-gradient(to right, rgb(231, 231, 194), rgb(96, 231, 194));


	
}
ul {
	height: 150px;
	list-style-type: none;
	margin-top: 0px ;
	padding: 0;
	overflow: hidden;
	font-size: 20px;
	  font-style: italic;
		color: red;
font-weight:bold;
	font-family: georgia,garamond,serif;

}

li { margin-right:25px;
	float: right;
	border-right: 2px solid none;
}

a {background-image: linear-gradient(to bottom right, white,brown);;
	display: block;
	color: black;
	
	text-align: center;
	padding: 15px 40px;
	text-decoration: none;
}
</style>
</head>

<body>
	<ul>

       <img class="logo" src="image/logo7.png" width="200px" height="150px" style="float: left; margin-top: 0px;"></li>
		
		<li><a href="StudentLogout">Logout </a></li>
		<li><a href="studprofile.jsp">Profile</a></li>
		<li><a href="StudentIssueBook">View Issue Book</a></li>
		<li><a href="studentsearch.jsp">Search Book</a></li>
		
		
	</ul>
	<br>
	<br>
	<h1>
		<u>About Yours</u>
	</h1>
	<img src="images/book.jpg" alt="Smiley face"
		style="float: left; width: 350px; height: 250px; margin-top: 20px; margin-left: 20px;">

	<form action="#" method="get">
		<div class="form-container">
			<table class="table-main">

				<%try{	HttpSession session1=request.getSession();  
                         String id=(String) session1.getAttribute("name");
                         
					Connection c1=null;
				Statement s1=null;
				
				Class.forName("com.mysql.jdbc.Driver");
    c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/library" ,"root", "1234");
    s1=c1.createStatement();
	ResultSet rs1;
	
	//rs= s.executeQuery("select * from books where ISBN='"+isbn+"'  ");
	rs1 = s1.executeQuery("select * from RegisteredStudent where adhaar='"+id+"' AND status='accepted'");

	while(rs1.next())
    {%><tr>
					<td>Student ID</td>
					<td><input type="number" name="student_id"
						value="<%=rs1.getString("adhaar")%>" readonly></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="student_name"
						value="<%=rs1.getString("Name")%>" readonly></td>
				</tr>
				<tr>
					<td>Father's Name</td>
					<td><input type="text" name="student_father_name"
						value="<%=rs1.getString("FName")%>" readonly></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><input type="text" name="student_gender"
						value="<%=rs1.getString("gender")%>" readonly></td>
				</tr>
				<tr>
					<td>E-mail</td>
					<td><input type="email" name="student_email"
						value="<%=rs1.getString("email")%>" readonly></td>
				</tr>
				<tr>
					<td>Contact</td>
					<td><input type="number" name="student_contact"
						value="<%=rs1.getString("contact")%>" readonly></td>
				</tr>
			</table>


		</div>

	</form>


	<%  
    }
}
    catch (SQLException e) {
		e.printStackTrace();
	} 



%>

</body>


</html>