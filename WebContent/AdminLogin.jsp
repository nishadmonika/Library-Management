<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Admin Login</title>
<style>



button {  background-image: linear-gradient(to right, #ff1a8c ,  #cce6ff
);

	background-color: #296d98;
	width: 50%;
	align: center;
	font-size: 20px;
	color: black;
	padding: 15px;
	border: none;
	cursor: pointer;
	border-radius: 15px;
}

form {
	align: center;
	margin-top: 0px;
	margin-right: auto;
	margin-down: 10px;
	margin-left: auto;
}

input[type=text], input[type=password] {
	width: 100%;
	margin: 8px 0;
	padding: 12px 20px;
	display: inline-block;
	border: 1.5px solid grey;
	box-sizing: border-box;
	border-radius: 12px;
	font-size: 17px;
	  background-image: linear-gradient(to right, white ,  #3399ff
);
	
}

button:hover {
	opacity: 0.7;
}

.container img {
	display: block;
	margin-left: auto;
	margin-right: auto;
	height: 100px;
	width: 100px;
}

body {	background-image: url("image/admin.jpg");
background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
  background-image: linear-gradient(to right, white , lemon);
}


.input-icons i {
	position: absolute;
}

.link-box {
	float: right;
	margin-top: 0px;
	margin-right: 0px;
	background-color: black;
	align: center;
	font-size: 20px;
	color: blue;
	padding: 10px;
	border: none;
	cursor: pointer;
	border-radius: 6px;
}

.input-icons {
	width: 100%;
	margin-bottom: 0px;
}

.icon {
	padding: 10px;
	min-width: 50px;
}

.input-field {
	width: 100%;
	padding: 5px;
	text-align: center;
}

.btn {
	width: 40%;
	margin-left: 70px;
	background-color: grey;
}



h3 {
	text-align: center;
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

a {
	display: block;
	color: black;
	
	text-align: center;
	padding: 15px 40px;
	text-decoration: none;
}
a:hover {
	color: red;
}
.hlo a{
color: blue;}
</style>
</head>

		<header > 
		
		</header>
	
<body align:center>
	<ul>
<img class="logo" src="image/logo7.png" width="200px" height="150px" style="float: left; margin-top: 0px;"></li>
     <li><a href="Homepage1.html">Home</a></li>
		</ul>
	<form action=AdminSLogin method=post>
		<div class="container">

			<img src="image/admin1.png">
			<div
				style=" max-width: 300px; margin: auto; color: black; ">
				<h3>ADMIN LOGIN</h3>
				<p style=" color: red;margin: auto;">${message}</p>
			</div>
			
			<div style="max-width: 300px; margin: auto">
				<div class="input-icons">
					<i class="fa fa-user icon"></i> <input class="input-field"
						type="text" placeholder="Enter AdminId " name="UserId" required> <i
						class="fa fa-key icon"></i> <input class="input-field"
						type="password" placeholder="Enter Password" name="password" required><br>
					<button class="btn" type="submit">Login</button>
				<div class="hlo">	<a   href="ResetAdmin.html"> <b>Forgot password?</b></a></div>
					<br >
					<br />
				</div>
				<div class="cl"></div>
			</div>
		</div>
	</form>
</body>

</html>