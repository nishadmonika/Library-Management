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
<title>ISSUE BOOK</title>
<style>

body {background-image: linear-gradient(to right, rgb(231, 231, 194), rgb(96, 231, 194));}

.table-main {
	padding: 10px;
	box-shadow: 2px 2px 3px 5px grey;
	border-radius: 25px;
	position: center;
	margin: auto;
	align: center;
	
}

td {
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

td {
	padding: 5px;
}



.btn-bottom {
	
	margin-right: 520px;
	background-color: black;
	align: center;
	font-size: 20px;
	color: white;
	padding: 10px;
	border: none;
	cursor: pointer;
	border-radius: 6px;
}
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
.btn-bottom1 {
	margin-left:500px;
		margin-right: 200px;
	 float:inherit;
	background-color: black;
	align: center;
	font-size: 20px;
	color: white;
	padding: 10px;
	border: none;
	cursor: pointer;
	border-radius: 6px;
	text-align: center;
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
    
<div id ="is">
<h2 style="color: blue; font-size: 200%; text-align: center;"><u>Provide details to issue book!!!!!!</u></h2></div>
<form action="#" method="post" >
<div class="form-container">
			<table class="table-main">
				<tr>
				<td>Student ID</td>
					<td><input type="number" name="student_id"  required>
				<td>ISBN</td>
						<td><input type="text" name="ISBN"  required></td>
						<td><input type="submit" value="Fetch_Details" "
						style="margin-left: 10px; background-color: black; color:white;"></td>
				</tr>
  
</table></div></form>
<div class="bottom-items">
		      
				
				
			</div>
			<br><br><br><br>
<%  
try{ id=request.getParameter("student_id");
isbn=request.getParameter("ISBN");
Class.forName("com.mysql.jdbc.Driver");
c=DriverManager.getConnection("jdbc:mysql://localhost:3306/library" ,"root", "1234");
s=c.createStatement();
ResultSet rs;
rs= s.executeQuery("select * from books where ISBN='"+isbn+"' ");
//ResultSet rs1 = s.executeQuery("select * from RegisteredStudent where adhaar='"+id+"'  ");


	//ResultSet rs1 = s.executeQuery("select * from RegisteredStudent where adhaar='"+id+"'  ");
    while(rs.next())
    {%>
    
   	<form action="IssueServlet" method="get">
		<div class="form-container">
			<table class="table-main" style="height:60%;">
				
				
				<tr>
					
					<td>Book ID</td>
					<td><input type="number" name="bookid" value="<%=rs.getString("bookid")%>" readonly>
			
				</tr>
				<tr>
					 <td>ISBN</td>
						<td><input type="text" name="ISBN" value="<%=rs.getString("ISBN")%>"readonly></td>
					
					
				</tr>
				<tr>
					
					<td>BookName</td>
						<td><input type="text" name="Bname" value="<%=rs.getString("bookName")%>"readonly></td>
					
				</tr>
				
				<tr>
				
				
                 <td>Category</td>
					<td><input type="text" name="category" value="<%=rs.getString("category")%>" readonly></td>
                    
					
				</tr>
				
				
				 <td>Author</td>
					<td><input type="text" name="book_author" value="<%=rs.getString("AuthorName")%>" readonly></td>
				
				</tr>
				<tr> 
				
					
					<td>Edition</td>
					<td><input type="text" name="Edition" value="<%=rs.getString("Edition")%>" readonly></td>
					
				</tr>
				
				<tr>
					
					<td>Publication</td>
					<td><input type="text" name="publication" value="<%=rs.getString("Publication")%>" readonly></td>
					
					
				</tr>
				<tr>
				<%java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy"); %>
				<td>Date Of Issue:</td>
				
				<td><input type="date" name="Issue_date" value="<%= df.format(new java.util.Date()) %> " ></td>
						
				</tr>
				<tr>
				<%Calendar c2 = Calendar.getInstance();
				c2.setTime(new java.util.Date()); // Now use today date.
				c2.add(Calendar.DATE, 15); // Adding 5 days
				String output = df.format(c2.getTime()); %>
				<td>Return Date:</td>
						<td><input type="date" name="book_return_date"   value="<%= output %> "></td>
				
				</tr>
				
				<% Connection c1=null;
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
					<td><input type="number" name="student_id" value="<%=rs1.getString("adhaar")%>" readonly >
	              
	</td></tr>
	<tr><td>Name</td>
					<td><input type="text" name="student_name"  value="<%=rs1.getString("Name")%>"readonly></td>
					</tr>
					<tr>
					<td>Father's Name</td>
					<td><input type="text" name="student_father_name"  value="<%=rs1.getString("FName")%>"readonly></td></tr>
	<tr><td>Gender</td>
					<td><input type="text" name="student_gender"  value="<%=rs1.getString("gender")%>" readonly></td></tr>
					<tr><td>E-mail</td>
					<td><input type="email" name="student_email"  value="<%=rs1.getString("email")%>"readonly> </td></tr>
					<tr>
					<td>Contact</td>
					<td><input type="number" name="student_contact" value="<%=rs1.getString("contact")%>"readonly></td></tr>
			</table><br>
			<div   class="bottom-items">
			
		        <input  type="submit" value="Issue Book" class="btn-bottom1" >
				
				
				
			</div>
	
		</div>
		
	</form>
	
   	  
   <%  
    }}
}
    catch (SQLException e) {
		e.printStackTrace();
	} 



%>

	
</body>
<br>
<br><br><br><br><br><br>

 <footer>Copyright &copy; Library Management System </footer>
</html>