<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>




<!DOCTYPE html>
<html>
<head>
<title>Admin</title>
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


h {
	color: blue;
}


* {box-sizing: border-box;}
body {font-family: Verdana, sans-serif;}
.mySlides {display: none;}
img {vertical-align: middle;}

/* Slideshow container */
.slideshow-container {
  max-width: 1000px;
  position: relative;
  margin: auto;
}

/* Caption text */
.text {
  color: #f2f2f2;
  font-size: 15px;
  padding: 8px 12px;
  position: absolute;
  bottom: 8px;
  width: 100%;
  text-align: center;
}

/* Number text (1/3 etc) */
.numbertext {
  color: #f2f2f2;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}

/* The dots/bullets/indicators */
.dot {
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.active {
  background-color: #717171;
}

/* Fading animation */
.fade {
  -webkit-animation-name: fade;
  -webkit-animation-duration: 1.5s;
  animation-name: fade;
  animation-duration: 1.5s;
}

@-webkit-keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

@keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

/* On smaller screens, decrease text size */
@media only screen and (max-width: 300px) {
  .text {font-size: 11px}
}
 

body {				background-image: linear-gradient(to right, rgb(231, 231, 194), rgb(96, 231, 194));

background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
  background-image: linear-gradient(to right, white , lemon);
}
footer{
     background-image: linear-gradient(to bottom right, white,brown);;
     box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
    text-align: right;
    padding: 20px;
    
}
</style>
</head>


<body align:center>

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
        <a href="deletebooks.jsp">Delete Book</a>
    
    <a href="Addbook.html">Add Book</a>
  </div></div>
  <br>  <br>
    <br>
    <br>
    <br><h1 style="color:blue; margin-left: 300px;" ><u>Admin DashBoard</u></h1>
<div class="slideshow-container">
<div class="mySlides fade">
  <div class="numbertext"></div>
  <img src="image/ad1.jpg" style="width:100%">
  
</div>

<div class="mySlides fade">
  <div class="numbertext"></div>
  <img src="image/ad2.jpg" style="width:100%">
 
</div>

<div class="mySlides fade">
  <div class="numbertext"></div>
  <img src="image/ad3.jpg" style="width:100%">
  
</div>

</div>
<br>

<div style="text-align:center">
  <span class="dot"></span> 
  <span class="dot"></span> 
  <span class="dot"></span> 
</div>

<script>
var slideIndex = 0;
showSlides();

function showSlides() {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";  
  }
  slideIndex++;
  if (slideIndex > slides.length) {slideIndex = 1}    
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
  setTimeout(showSlides, 2000); // Change image every 2 seconds
}
</script>
	</body>



<footer>Copyright &copy; Library Management System </footer>

</html>