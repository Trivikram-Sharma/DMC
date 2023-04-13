<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Medical Records</title>
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
table{
	border: 1px solid yellow;
	border-spacing: 1 px;
	text-align : center;
}
table th,td{
	border : 1px solid yellow;
	font-size : 5 px;
}
</style>
</head>
<body>
<%@ page import="com.dao.*" %>
<%@ page import="com.model.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<header><h1>Medical Records List</h1></header>
	<nav>
		<a href='Login-register.jsp'>Home</a> <a
			href='diagnostic-services.jsp'>Services</a>
	</nav>
<section>
	<table>
	<tr><th>Record ID</th><th>Patient ID</th><th>Doctor ID</th><th>Diagnostic Service ID</th><th>Diagnostic Service Name</th><th>Prescription</th></tr>
	<% 
		MedicalRecordDao md = new MedicalRecordDaoImpl();
		ArrayList<MedicalRecord> mrList = md.getAllMedicalRecords();
		for(MedicalRecord mr : mrList){
			out.println("<tr>");
			out.println("<td>"+mr.getRecordId()+"</td>");
			out.println("<td>"+mr.getPatientId()+"</td>");
			out.println("<td>"+mr.getDoctorId()+"</td>");
			out.println("<td>"+mr.getServiceId()+"</td>");
			out.println("<td>"+mr.getServiceName()+"</td>");
			out.println("<td>"+mr.getPrescription()+"</td>");
			out.println("</tr>");
		}
	%>
	</table>
	</section>
	<footer>@ copyright, all rights reserved</footer>
</body>
</html>