<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Role Selection Page</title>
<style>
	body {
	background-image: url("images/medical-background.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	text-align: center;
}
header{
	background-color : darkblue;
	color:white;
}
nav {
	background-color: green;
	height : 5 %;
	
}
nav a{
	float: center;
	font-size: larger;
	background-color : #ff1a75;
	padding-left : 1em;
	padding-right : 1em;
	
}
nav a:hover{
	background-color : blue;
}
form{
background-color:darkcyan;
}


</style>
</head>
<body>
	<header><h1>Are you a Patient or Doctor?</h1></header>
	<section>
	<form action="user-registration.jsp" method="get">
	<h4>Select "Patient" if you are a patient</h4>
	<input type="radio" name="user" value="patient" id="u1">
	<label for="u1">Patient</label>
	<h4>Select "Doctor" if you are a doctor</h4>
	<input type="radio" name="user" value="doctor" id="u2">
	<label for="u2">Doctor</label>
	<br>
	<input type="submit" name="Submit" value="Submit">
	</form>
	</section>
	<footer>@ copyright, all rights reserved.</footer>
</body>
</html>