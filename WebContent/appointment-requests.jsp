<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Appointment Requests</title>

<style>
span {
	font-weight: 2 em;
	background-color: blue;
	color: white;
}

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
	border: 1px solid black;
	border-spacing: 1 px;
}
</style>
</head>

<body>
<header><h1>Appointment Requests</h1></header>
	<nav>
		<a href='Login-register.jsp'>Home</a> <a
			href='diagnostic-services.jsp'>Services</a>
	</nav>
	<section>
	<%@ page import="java.util.*"%>
	<%@ page import="java.sql.*"%>
	<%@ page import="com.model.*"%>
	<%@ page import="com.dao.*"%>
	<%
		if (session != null && session.getAttribute("patientId") != null && session.getAttribute("patientPassword") != null) {
		AppointmentDao ad = new AppointmentDaoImpl();
		ArrayList<Appointment> appointments = ad.getAppointmentDetailsByPatient((int) session.getAttribute("patientId"));
		out.println("<table border='1 px' cell-spacing='1 px'>");
		out.println(
		"<tr><th>Appointment ID</th><th>Patient ID</th><th>Doctor ID</th><th>Diagnostic Service ID</th><th>Diagnostic Service Name</th><th>Appointment Date</th><th>Appointment Time</th><th>Criticality</th><th>Status</th><th>Remarks</th></tr>");
		for (Appointment appointment : appointments) {

			out.println("<tr>");
			String status = "";
			if (appointment.isStatus()) {
		status = "Accepted";
			} else {
		status = "Rejected";
			}
			out.println("<td>" + appointment.getAppointmentId() + "</td><td>" + appointment.getPatientId() + "</td><td>"
			+ appointment.getDoctorId() + "</td><td>" + appointment.getTestId() + "</td><td>"
			+ appointment.getDiagnosticServiceName() + "</td><td>" + appointment.getAppointmentDate() + "</td><td>"
			+ appointment.getAppointmentTime() + "</td><td>" + appointment.getCriticality() + "</td><td><span>"
			+ status + "</span></td><td>" + appointment.getRemarks() + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");

	} else {
		out.println("<h2>Your session has timed out</h2>");
		out.println("click <a href='LogoutServlet'>Here</a> to go Home Page");
	}
	%>
	</section>
	<footer>@copyright, all rights reserved</footer>
</body>
</html>