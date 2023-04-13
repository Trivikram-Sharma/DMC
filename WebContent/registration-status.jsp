<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Status</title>
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
section{
	background-color : darkcyan;
	color : yellow;
}
section a:hover{
	background-color : yellow;
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
</style>
</head>
<body>
	<header><h1>${status }</h1></header>
	<nav>
		<a href='Login-register.jsp'>Home</a>
		 <a href='diagnostic-services.jsp'>Services</a>
	</nav>
	<section>
	<%if(request.getAttribute("role")=="Admin"){ 
		 out.println("Your Admin ID is "+request.getAttribute("referenceId")+". Please note it down for future reference");}%>
	
	<%if(request.getAttribute("role")=="Patient") {
		 out.println("Your Patient ID is "+request.getAttribute("referenceId")+". Please note it down for future reference");}%>
	
	<%if(request.getAttribute("role")=="Doctor"){
		 out.println("Your Doctor ID is "+request.getAttribute("referenceId")+". Please note it down for future reference");}%>
	<a href="LogoutServlet">Back to Home Page</a></section>
	<footer>@ copyright, all rights reserved</footer>
</body>
</html>