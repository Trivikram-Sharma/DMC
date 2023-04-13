<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient Home Page</title>
<style>
	body {
	background-image: url("images/medical-background.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	text-align: center;
}
header{
	height : 20%;
	background-color : darkblue;
	color : white;
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
section{
	background-color : darkcyan;
	color : yellow;
}
section a:hover{
	background-color : yellow;
}
</style>
</head>
<body>
	<header><h1>${status }</h1>
	<h1>Hello, patient. Your Id is <%=session.getAttribute("patientId") %></h1></header>
	<nav>
		<a href='Login-register.jsp'>Home</a>
		 <a href='diagnostic-services.jsp'>Services</a>
	</nav>
	<section>
	<a href='diagnostic-services.jsp'>View Diagnostic Services</a><br>
	<a href="appointment-request.jsp">Book Appointment</a><br>
	<a href="appointment-requests.jsp">View Appointments</a><br>
	<a href='view-test-results.jsp'>View Test Results</a><br>
	<a href="LogoutServlet">Logout</a>
	</section>
	<footer>@ copyright, all rights reserved</footer>
</body>
</html>