<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%Connection c = null;
    Statement s = null; %>

<!DOCTYPE html>
<html>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<head>
<style>

table {height =50%;width =50%;
	border-collapse: collapse;
}

table, th, td {
	border: 1px solid grey;
	padding: 5px;
}

th{ font-weight:bold;
	color: blue;
}


body {
	
	
	background-image: linear-gradient(to right, rgb(231, 231, 194), rgb(96, 231, 194));
	color: black;
	
}

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
  min-width: 60px;
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
</style>
<title>Delete Book</title>
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
  </div>

</div><br><br>
<br><br><br><br><br><br>

	<h3 style="text-align:Center;">Books Details</h3>
	<table>
		<tr>

			<th>bookId</th>
			<th>ISBN</th>
			<th>bookName</th>
			<th>category</th>
			<th>AuthorName</th>
			<th>Edition</th>
			<th>Publication</th>
			<th>Quantity</th>
			<th>Availability</th>
			<th>Delete Book</th>


		</tr>
		<%
try{
	Class.forName("com.mysql.jdbc.Driver");
	c=DriverManager.getConnection("jdbc:mysql://localhost:3306/library" ,"root", "1234");
	s=c.createStatement();
	ResultSet rs = s.executeQuery("select * from books ");  
	//out.println("<table height=50% width=50% >");  
	//out.println("<tr><th>BOOKID</th><th>ISBN</th><th>BookName</th><th>Author</th><th>Edition</th><th>Publication</th><th>Quantity</th><th>Availablity</th><tr>");  
	while (rs.next()) 
	{  
%>

		<tr>
			<td><%=rs.getString("bookid") %></td>
			<td><%=rs.getString("ISBN") %></td>
			<td><%=rs.getString("bookName") %></td>
			<td><%=rs.getString("category") %></td>
			<td><%=rs.getString("AuthorName") %></td>
			<td><%=rs.getString("Edition") %></td>
			<td><%=rs.getString("Publication") %></td>
			<td><%=rs.getString("Quantity") %></td>
			<td><%=rs.getString("Availablity") %></td>
			<td><a href="del.jsp?id=<%=rs.getString("ISBN") %>">Delete</a></td>

		</tr>
		<%

}
c.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
	</table>
	<br><br><br><br>
</body>


</html>

