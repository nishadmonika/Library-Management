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
             String cat=null;
             //String id=null;%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>search book</title>
<style>
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

body {				background-image: linear-gradient(to right, rgb(231, 231, 194), rgb(96, 231, 194));


	
}

#btn {
	background-image: linear-gradient(white, #e0e0d1);
	width: 10%;
	align: center;
	font-size: 14px;
	color: black;
	font-weight: bold;
	padding: 15px;
	border: none;
	cursor: pointer;
	border-radius: 15px;
}

form {
	align: center;
	margin-top: 50px;
	margin-right: auto;
	margin-down: 10px;
	margin-left: auto;
}

input[type=text] {
	width: 40%;
	margin: 8px 0;
	background-image: linear-gradient(to right, #99d6ff, #ffcce0);;
	padding: 12px 20px;
	display: inline-block;
	border: 1.5px solid grey;
	box-sizing: border-box;
	border-radius: 12px;
	font-size: 17px;
}




table {margin-left:auto;
margin-right:auto;
	border-collapse: collapse;
}

th {
	font-weight: bold;
}

table, td, th {
	border-collapse: collapse;
	border: 1px solid grey;
	padding:10px;
	background-image: linear-gradient(to right, white, #ffcce0);;
}


</style>

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
	<h1 style="color: blue; font-size: 200%; text-align: center;"><u>Search
		Book</u></h1>


	<form method=get>

		<label style="color: black; font-size: 150%; margin-left: 300px;">Select Category:
		</label> <select
			style="background-image: linear-gradient(to right, white, grey); font-size: 20px;"
			id="category" name="category">
			<option value=-1>Select</option>
			<option value="Computers">Computers</option>
			<option value="Chemistry">Chemistry</option>
			<option value="Biology">Biology</option>
			<option value="Physics">Physics</option>
			<option value="Mathematics">Mathematics</option>
			<br><br>
		</select> <input type="submit" id="btn" value="Search Book">

	</form>


	<%  
try{ 
	cat=request.getParameter("category");
	Class.forName("com.mysql.jdbc.Driver");
    c=DriverManager.getConnection("jdbc:mysql://localhost:3306/library" ,"root", "1234");
    s=c.createStatement();
	ResultSet rs;
	rs= s.executeQuery("select * from books where category='"+cat+"'  ");%>
	<br>
	<br>
	<br>
	<table height=80% width=80%>

		<tr>
			<th>Book_Id</th>
			<th>ISBN</th>
			<th>BookName</th>
			<th>Category</th>
			<th>AuthorName</th>
			<th>Edition</th>
			<th>Pulication</th>
			<th>Quantity</th>
			<th>Availablity</th>
		<tr>
			<%   while(rs.next())
    { %>
		
		<tr>
			<td><%=rs.getString("bookid")%></td>
			<td><%=rs.getString("ISBN")%></td>
			<td><%=rs.getString("bookName")%></td>
			<td><%=rs.getString("category")%></td>
			<td><%=rs.getString("AuthorName")%></td>
			<td><%=rs.getString("Edition")%></td>
			<td><%=rs.getString("Publication")%></td>
			<td><%=rs.getString("Quantity")%></td>
			<td><%=rs.getString("Availablity")%></td>
		</tr>






		<%  }
  
			}
			 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} %>
	</table>


	<br>
	<br>


	

</body>
