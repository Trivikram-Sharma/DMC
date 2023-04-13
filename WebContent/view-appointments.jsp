<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Appointments</title>
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
	border: 1px solid black;
	border-spacing: 1 px;
}
</style>
</head>
<body>
	<%@ page import="java.util.*"%>
	<%@ page import="java.sql.*"%>
	<%@ page import="com.model.*"%>
	<%@ page import="com.dao.*"%>
	<header><h1>Appointments List</h1></header>
	<section>
	<%
		if(session!=null && session.getAttribute("doctorId")!=null && session.getAttribute("doctorPassword")!=null){
		AppointmentDao ad = new AppointmentDaoImpl();
		ArrayList<Appointment> appointments = ad.getAppointmentDetailsByDoctorId((int)session.getAttribute("doctorId"));
		out.println("<table>");
		out.println("<tr><th>Appointment ID</th><th>Patient ID</th><th>Doctor ID</th><th>Diagnostic Service ID</th><th>Diagnostic Service Name</th><th>Appointment Date</th><th>Appointment Time</th><th>Criticality</th><th>Status</th><th>Remarks</th><th colspan='2'>Action</th></tr>");
			for(Appointment appointment: appointments){
				
				out.println("<tr>");
				out.println("<td>"+appointment.getAppointmentId()+"</td><td>"+appointment.getPatientId()+"</td><td>"+appointment.getDoctorId()+"</td><td>"+appointment.getTestId()+"</td><td>"+appointment.getDiagnosticServiceName()+"</td><td>"+appointment.getAppointmentDate()+"</td><td>"+appointment.getAppointmentTime()+"</td><td>"+appointment.getCriticality()+"</td><td>"+appointment.isStatus()+"</td><td>"+appointment.getRemarks()+"</td><td><a href='AcceptServlet?appointmentId="+appointment.getAppointmentId()+"'>Accept</a></td><td><a href='RejectServlet?appointmentId="+appointment.getAppointmentId()+"'>Reject</a></td>");
				out.println("</tr>");
			}
			out.println("</table>");
		
		
		}
		else{
			out.println("<h2>Your session has timed out</h2>");
			out.println("click <a href='LogoutServlet'>Here</a> to go back to Home Page");
		}
	%>
</section>
<footer>@ copyright, all rights reserved</footer>
</body>
</html>