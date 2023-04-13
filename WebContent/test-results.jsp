<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Test Results</title>
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
</style>
</head>
<body>
	<header><h2>Update Test Results by filling details below.</h2></header>
	<%@ page import="java.util.*"%>
	<%@ page import="java.sql.*"%>
	<%@ page import="com.model.*"%>
	<%@ page import="com.dao.*"%>
	<nav>
		<a href='Login-register.jsp'>Home</a> <a
			href='diagnostic-services.jsp'>Services</a>
	</nav>
<section>
	<%
		//ArrayList<Appointment> appointmentList = null;
	if (session != null && session.getAttribute("doctorId") != null && session.getAttribute("doctorPassword") != null) {
		int doctorId = (int) session.getAttribute("doctorId");
		AppointmentDao ad = new AppointmentDaoImpl();
		ArrayList<Appointment> appointmentList = ad.getAppointmentDetailsByDoctorId(doctorId);
		out.println("<form action='UpdateTestResultServlet' method='get' onsubmit='return true'>");
		for (Appointment appointment : appointmentList) {
			out.println("<details>");
			out.println("<summary>");
			//out.println("<input type='radio' name='patientId' id='" + appointment.getPatientId() + "' value='"
			//+ appointment.getPatientId() + "' required>");
			//out.println("<label for='" + appointment.getPatientId() + "'>Patient Id:" + appointment.getPatientId()
			//+ "</label>");
			out.println("Patient Id:"+appointment.getPatientId());
			out.println("Click Here for more details");
			out.println("</summary>");
			TestDao td = new TestDaoImpl();
			ArrayList<Test> testList = td.getTestDetailsByPatientId(appointment.getPatientId());
			for (Test test : testList) {
		out.println("<details>");
		out.println("<summary>");
		//out.println("<input type='radio' name='testId' id='" + test.getTestId() + "' value='" + test.getTestId()
			//	+ "' required>");
		//out.println("<label for='" + test.getTestId() + "'>Test Id:" + test.getTestId() + " </label>");
		out.println("Test ID:"+test.getTestId()+"<br>");
		out.println("Click Here for more details");
		out.println("</summary>");
		out.println("Admin Id:" + test.getAdminId()+"<br>");
		out.println("Service Id:" + test.getServiceId()+"<br>");
		out.println("Test name : " + test.getTestName()+"<br>");
		out.println("Test Result:"+test.getResult());
		out.println("Test baseline values:" + test.getBaseLine()+"<br>");
		/*request.setAttribute("adminId", test.getAdminId());
		request.setAttribute("serviceId", test.getServiceId());
		request.setAttribute("testName", test.getTestName());
		request.setAttribute("baseLine", test.getBaseLine());

		out.println("<label for='result'>Test Result:</label>");
		out.println("<input type='text' name='result' id='result' required><br>");*/
		out.println("</details>");
			}
			out.println("</details>");
		}
	} else {
		out.println("<h1>Your session has expired.</h1>");
		out.println("<a href='LogoutServlet'>Back To Home Page</a>");
	}
	%>
</section>
<footer>@ copyright, all rights reserved</footer>

</body>
</html>