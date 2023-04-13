<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login and Registration Page</title>
<style>
body {
	background-image: url("images/medical-background.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	text-align: center;
}

h1 {
	text-align: center;
	color: blue;
}

#admin-reg {
	background-color: yellow;
}

#user-reg {
	background-color: white;
}

#admin-login {
	background-color: yellow;
}

#doctor-login {
	background-color: white;
}

#patient-login {
	background-color: cyan;
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

section {
	background-color: darkcyan;
}

</style>
</head>
<body>
	<header>
		<h1>Login and Registration</h1>
	</header>
	
	<nav>
		<a href='Login-register.jsp'>Home</a>
		 <a href='diagnostic-services.jsp'>Services</a>
	</nav>
	<section>
		<h4>Register as Admin Here</h4>
		<a id="admin-reg" href="admin-registration.jsp">Register as admin</a>

		<h4>Register as Patient or Doctor here</h4>
		<a id="user-reg" href="user-role.jsp">Register as Patient or
			Doctor</a>
		<h4>Already have Account? Sign In Below</h4>
		<figure>
		<img id="admin" src="images/admin-image.jpg" width="200 px" height="100 px">
		<figcaption>
		<a id="admin-login" href="admin-login.jsp"> Sign In as Admin</a></figcaption> 
		</figure>
		<figure>
		<img id="patient" src="images/patient-image.png" width="200 px" height="100 px">
		<figcaption>
		 <a
			id="patient-login" href="patient-login.jsp">Sign In as Patient</a>
			</figcaption></figure>
			<figure>
			<img id="doctor" src="images/doctor-image.png" width="200 px" height="100 px">
			<figcaption>
		<a id="doctor-login" href="doctor-login.jsp">Sign In as Doctor</a></figcaption></figure>	
	</section>
	<footer>@ copyright, all rights reserved</footer>
</body>
</html>