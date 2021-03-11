<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Librarian Login</title>
	<style>
		header {
			background-color: #c2d6d6;
			background-image: linear-gradient(to bottom right, red, yellow);
			box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
			color: blue;
			padding: 5px;
			border-top: 1px;
		}

		.logo {
			margin-left: 30px;
			margin-top: 30px;
			width: 150px;
			height: 110px;
		}

		body {
			font-family: Calibri, Helvetica, sans-serif;
			background-image: linear-gradient(to right, rgb(231, 231, 194), rgb(96, 231, 194));
		}

		button {
			background-color: #296d98;
			width: 50%;
			text-align: center;
			font-size: 20px;
			color: white;
			padding: 15px;
			border: none;
			cursor: pointer;
			border-radius: 15px;
		}

		form {
			text-align: center;
			margin-top: 50px;
			margin-right: auto;
			margin-bottom: 10px;
			margin-left: auto;
		}

		input[type=text],
		input[type=password] {
			width: 100%;
			margin: 8px 0;
			padding: 12px 20px;
			display: inline-block;
			border: 1.5px solid grey;
			box-sizing: border-box;
			border-radius: 12px;
			font-size: 17px;
			  background-image: linear-gradient(to right, white , #0080ff);
			
		}

		button:hover {
			opacity: 0.7;
		}

		.cancelbtn {
			width: auto;
			padding: 10px 18px;
			margin: 10px 5px;
			font-size: 15px;
		}

		.container {
			position: center;
			margin: auto;
			text-align: center;
			max-width: 400px;
			padding: 15px;
						  background-image: linear-gradient(to right, #0080ff, #ecb3ff );
			
			border-radius: 25px;
			box-shadow: 2px 2px 3px 5px grey;
		}

		.top-nav {
			position: fixed;
			right: 20px;
			
		}

		li,
		ul {
			float: left;
			list-style-type: none;
		}

		ul>a {
			text-decoration: none;
			font-size: 20px;
			 background-image: linear-gradient(to bottom right, white,brown);;
			color: black;
			font-weight:bold;
			transition: all 0.3s ease;
			transition: all 0.3s ease;
			font-weight:bold;
			 font-style: italic;
	font-family: georgia,garamond,serif;
		}ul>a:hover{
color:red;}

		.heading {
			position: fixed;
			top: 10px;
			text-align: center;
			color: white;
			width: 100%;
		}
	</style>
</head>

<body align:center>
	<div class="top-nav">
		<li>
			
			<ul><a href="Homepage1.html">Home</a></ul>
		</li>
	</div>
	<div id="first">
<img class="logo" src="image/logo7.png" width="200px" height="200px" style="float: left; margin-top: 0px;"></li>
	</div>

	

	<form action=librarianServlet method=get>
		<div class="container">
			<img src="image/lib.png" style="width:100px;height:100px;">
			<center>
				<h2 style="color: #00264d;">Librarian login</h2>
				<p style=" color: red;margin: auto;">${message}</p>
			</center>

			<input type="text" placeholder="Enter username " name="UserId" required> <br /> <input type="password"
				placeholder="Enter Password" name="password" required>
			<button type="submit">Login</button>
			<br />
			<br /> <input type="checkbox" checked="checked"> Remember me
			&nbsp; &nbsp;&nbsp;
			<a href="ResetLib.html"> <b>Forgot password?</b></a>
			<br />
			<br />
		</div>
	</form>
</body>

</html>