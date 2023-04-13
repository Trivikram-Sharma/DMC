<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Diagnostic Services</title>
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
	text-align : center;
}
section details
{
	float: center;
	background-color : yellow;
	color : blue;
	text-align: center;
}
section summary{
	background-color : blue;
	color : white;
}
table{
	border: 1px solid black;
	border-spacing: 1 px;
}
	
	a{
		background-color: white;
	}
</style>
</head>
<body>
	<header><h1>Available Diagnostic Services</h1></header>
	<br>
	<%@ page import="java.util.ArrayList"%>
	<%@ page import="com.model.*"%>
	<%@ page import="com.dao.*"%>
	<nav>
		<a href='Login-register.jsp'>Home</a> <a
			href='diagnostic-services.jsp'>Services</a>
	</nav>
	<section>
	<%
	
		DiagnosticServiceDao dsdo = new DiagnosticServiceDaoImpl();
		ArrayList<DiagnosticService> dsList = dsdo.getAllDiagnosticServices();
		out.println("List of Diagnostic Services IDs.Click on each of them for more details<br>");%>
		
		<% 
		
		for(DiagnosticService ds : dsList){
			out.println("<details>");
			out.println("<summary>Diagnostic Id:"+ds.getDiagnosticServiceId()+"</summary>");
			out.println("<ul>");
			out.println("<li><big>Diagnosis Name : </big>"+ds.getDiagnosticServiceName()+"</li>");
			out.println("<li><big>Brief on the Diagnostic Service : </big>"+ds.getBriefOnDiagnosticCenter()+"</li>");
			out.println("<li><big>Facilities Available : </big>"+ds.getFacilitiesAvailable()+"</li>");
			out.println("<li><big>Speciality : </big>"+ds.getSpeciality()+"</li>");
			out.println("<li><big>Address : </big>"+ds.getAddress()+"</li>");
			out.println("<li><big><a href='view-doctors.jsp?serviceName="+ds.getDiagnosticServiceName()+"&id="+ds.getDiagnosticServiceId()+"&speciality="+ds.getSpeciality()+"' target='_blank'>View Doctors</a></big></li>");
			out.println("</details>");
			out.println("</ul><br>");
	} 
	%></section>
	<footer>@ copyright, all rights reserved</footer>
</body>
</html>