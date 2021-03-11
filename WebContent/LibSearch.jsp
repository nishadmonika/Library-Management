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
<title>Searchbook</title>
<style>
ul {
	height: 150px;
	list-style-type: none;
	margin-top: 0px ;
	padding: 0;
	overflow: hidden;
	font-size: 20px;
	  
		color: red;
font-weight:bold;
	font-family: georgia,garamond,serif;

}

li { margin-right:25px;
	float: right;
	border-right: 2px solid none;
}

a { background-image: linear-gradient(to bottom right, white,brown);;
	display: block;
	color: black;
	
	text-align: center;
	padding: 0px ;
	text-decoration: none;
}
a:hover {
	color: white;
	background-image: linear-gradient(to bottom right, white,blue);;
}
button:hover {
	opacity: 0.7;
}

body {background-image: linear-gradient(to right, rgb(231, 231, 194), rgb(96, 231, 194));}

button, #btn {
	background-image: linear-gradient(white, grey);
	width: 15%;
	align: center;
	font-size: 15px;
	color: black;
	font-weight: bold;
	padding: 10px 10px;
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
	width: 20%;
	margin: 8px 0;
	background-image: linear-gradient(to right, #99d6ff, #ffcce0);;
	padding: 12px 20px;
	display: inline-block;
	border: 1.5px solid grey;
	box-sizing: border-box;
	border-radius: 12px;
	font-size: 17px;
}

body {
	color: white;
	
}


table { margin-left:auto;
margin-right:auto;
	border-collapse: collapse;
}

table, td, th { color:black;
	border: 1px solid grey;
		padding: 10px ;
}
</style>
<body>
	<nav>

	<ul>

       <img class="logo" src="image/logo7.png" width="200px" height="150px" style="float: left; margin-top: 0px;"></li>
		<li id="lst"><a href= "LibLogin.jsp">Logout</a></li>
		  <li><a href="LibReturnstatus">Check Return status</a></li>
		   <li><a href="bookreturn.jsp">Return Book </a></li>
		   <li><a href="issuebook.jsp">Issue Book </a></li>
		
        <li><a href="LibSearch.jsp">Search Book</a></li>
        <li><a href="Homepage1.html">Home</a></li>
        
        
       
       <!--  <li><a href="#">Staff Details</a></li>-->
       
          
	</ul>
 
    </nav>
	
	<h1 style="color: blue; font-size: 200%; text-align: center;">Search
		Book</h1>


	<form method=get>


		<label for="isbn"
			style="color: black; font-size: 100%; font-weight: bold; margin-left: 300px;">Search
			By ISBN </label> <input id="isbn" type="text" name="isbn"
			placeholder="Type ISBN Here...."> <input type="submit"
			id="btn" value="Fetch_Book_Details">

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
	<table height=50% width=50%>
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
