<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 

<!DOCTYPE html>
<html>
<head>
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

a { background-image: linear-gradient(to bottom right, white,brown);;
	display: block;
	color: black;
	
	text-align: center;
	padding: 0px ;
	text-decoration: none;
}
section {
	padding-left: 80px;
	height: 488px;
	width: 450px;
	font-size: large;
}

h2 {
	color: blue;
}

body {background-image: linear-gradient(to right, rgb(231, 231, 194), rgb(96, 231, 194));

}

.centered {
  position: absolute;
  top: 50%;
  left: 50%;
  background-color:black;
  color:white;
  transform: translate(-50%, -50%);
}

a:hover {
	color: white;
	background-image: linear-gradient(to bottom right, white,blue);;
}
* {box-sizing: border-box;}
body {font-family: Verdana, sans-serif;}
.mySlides {display: none;}
img {vertical-align: middle;}

/* Slideshow container */
.slideshow-container {
  max-width:800px;
  height:300px;
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
</style>
<title>LibHome</title>
</head>
<body>

	<ul>

       <img class="logo" src="image/logo7.png" width="200px" height="150px" style="float: left; margin-top: 0px;"></li>
		<li id="lst"><a href= "libLogin.html">Logout</a></li>
		  <li><a href="LibReturnstatus">Check Return status</a></li>
		   <li><a href="bookreturn.jsp">Return Book </a></li>
		   <li><a href="issuebook.jsp">Issue Book </a></li>
		
        <li><a href="LibSearch.jsp">Search Book</a></li>
        <li><a href="Homepage1.html">Home</a></li>
        
        
       
       <!--  <li><a href="#">Staff Details</a></li>-->
       
          
	</ul>
 
    <h1 style="color: #b30059; margin-left: 300px;" ><u>Librarian DashBoard</u></h1>
<div class="slideshow-container">
<div class="mySlides fade">
  <div class="numbertext"></div>
  <img src="image/l1.jpg" style="width:100%">
  
</div>

<div class="mySlides fade">
  <div class="numbertext"></div>
  <img src="image/l2.jpg" style="width:100%">
 
</div>

<div class="mySlides fade">
  <div class="numbertext"></div>
  <img src="image/l3.jpg" style="width:100%">
  
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
 
 <br>
</body>



</html>