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
<title>Update BOOK</title>
<style>
input[type=text], input[type=email], input[type=file], input[type=number],
	input[type=text], input[type=number], input[type=text], input[type=password],
	input[type=password] {
	width: 100%;
	padding: 10px;
	
	margin-right:10px;
	border: none;
	background: #f1f1f1;
	border-radius: 20px;
	background-image: linear-gradient(180deg, white, #85adad);
}

body {background-image: linear-gradient(to right, rgb(231, 231, 194), rgb(96, 231, 194));

	background-color: #eeeeee;
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

.btn-bottom1{
	margin-right: 10px;
	background-color: black;
	
	font-size: 20px;
	color: white;
	padding: 10px;
	border: none;
	cursor: pointer;
	border-radius: 6px;

}
.form-container {
max-width: 1000px;}

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
.table-main{
width: 600px;
margin-right: 100px;
font-weight: bold;}


#is{
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

</div>
<br><br><br><br><br>
<h1 style="margin-right:250px; color: blue;"><u>Update Book</u></h1>
<h2 style="text-align: center;color: Blue;">Please Provide Book ISBN to update book</h2> 
<div id ="is">

<form action="#" method="post" >
<div class="form-container">
			<table class="table-main">
				<tr>
				
				<td>ISBN</td>
						<td><input type="text" name="ISBN"  placeholder="Enter ISBN...."></td>
						<td><input type="submit" value="Fetch_Details" "
						style="margin-left: 10px; background-color: black; color:white;"></td>
				</tr>
  
</table></div></form>

			<br><br><br><br>
<%  
try{ 
	isbn=request.getParameter("ISBN");
	Class.forName("com.mysql.jdbc.Driver");
    c=DriverManager.getConnection("jdbc:mysql://localhost:3306/library" ,"root", "1234");
    s=c.createStatement();
	ResultSet rs;
	rs= s.executeQuery("select * from books where ISBN='"+isbn+"'  ");
	//ResultSet rs1 = s.executeQuery("select * from RegisteredStudent where adhaar='"+id+"'  ");
    while(rs.next())
    {%>
    
   	<form action="UpdateServlet" method="get">
		<div class="form-container">
			<table class="table-main" style="height:60%;">
				
				
				<tr>
					
					<td>Book ID</td>
					<td><input type="number" name="bookid" value="<%=rs.getString("bookid")%>" >
			
				</tr>
				<tr>
					 <td>ISBN</td>
						<td><input type="text" name="ISBN" value="<%=rs.getString("ISBN")%>"></td>
					
					
				</tr>
				<tr>
					
					<td>BookName</td>
						<td><input type="text" name="Bname" value="<%=rs.getString("bookName")%>"></td>
					
				</tr>
				
				<tr>
				
				
                 <td>Category</td>
					<td><input type="text" name="category" value="<%=rs.getString("category")%>" ></td>
                    
					
				</tr>
				
				
				 <td>Author</td>
					<td><input type="text" name="book_author" value="<%=rs.getString("AuthorName")%>" ></td>
				
				</tr>
				<tr> 
				
					
					<td>Edition</td>
					<td><input type="text" name="Edition" value="<%=rs.getString("Edition")%>" ></td>
					
				</tr>
				
				<tr>
					
					<td>Publication</td>
					<td><input type="text" name="publication" value="<%=rs.getString("Publication")%>" ></td>
					
					
				</tr>
				<tr>
					
					<td>Quantity</td>
					<td><input type="text" name="quantity" value="<%=rs.getString("Quantity")%>" ></td>
					
					
				</tr>
				<tr>
					
					<td>Availability</td>
					<td><input type="text" name="availability" value="<%=rs.getString("Availablity")%>" ></td>
					
					
				</tr>
				
				
				
			</table>
			<br>
			<br>
			<div class="bottom-items">
		        <input type="submit" value="Update" class="btn-bottom1" >
				
				
				
			</div>
	
		</div>
		
	</form>
	
				</tr>
				<% 
}}
    catch (SQLException e) {
		e.printStackTrace();
	} 



%>

	
</body>


</html>