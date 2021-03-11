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
             //String id=null;%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>searchbook</title>
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

button:hover {
	opacity: 0.7;
}

form {
	align: center;
	margin-top: 50px;
	margin-right: auto;
	margin-down: 10px;
	margin-left: auto;
}

input[type=text] {
	width: 30%;
	margin: 8px 0;
	padding: 12px 20px;
	display: inline-block;
	border: 1.5px solid grey;
	box-sizing: border-box;
	border-radius: 12px;
	font-size: 17px;
}

body {
	
	background-image: linear-gradient(to right, rgb(231, 231, 194), rgb(96, 231, 194));
	
	font-size: 100%;
	width: 100%;
	height: 100%;
	height: 100%;
	
}
#btn{margin-right: 50px;
	background-color: black;
	align: center;
	font-size: 20px;
	color: white;
	padding: 10px;
	border: none;
	cursor: pointer;
	border-radius: 6px;
}

table {
	border-collapse: collapse;
}

table, td, th {
	font-size: 20px;
	border: 1px solid grey;
}
</style>

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
  <br><br><br><br><br><br><br><br>
	<h1
		style="color: black; font-size: 200%; font-weight: bold; text-align: center;"><u>Search
		Book</u></h1>


	<form method=get>


		<label for="isbn"
			style="color: black; font-size: 100%; font-weight: bold;">Search
			By ISBN </label> <input id="isbn" type="text" name="isbn"
			placeholder="Type ISBN Here...." required> <input type="submit"
			id="btn" value="Search book">

	</form>


	<%  
try{ 
	isbn=request.getParameter("isbn");
	Class.forName("com.mysql.jdbc.Driver");
    c=DriverManager.getConnection("jdbc:mysql://localhost:3306/library" ,"root", "1234");
    s=c.createStatement();
	ResultSet rs;
	rs= s.executeQuery("select * from books where ISBN='"+isbn+"'  ");
	//ResultSet rs1 = s.executeQuery("select * from RegisteredStudent where adhaar='"+id+"'  ");
	
    while(rs.next())
    { %>
	<table height=100% width=70%>
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


	</table>



	<%  }
			}
			 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} %>





	
</body>
