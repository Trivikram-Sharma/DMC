<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
section a:hover{
	background-color : yellow;
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
<%@ page import="java.util.*" %>
	<%@ page import="java.sql.*" %>
	<%@ page import="com.model.*" %>
	<%@ page import="com.dao.*" %>
	<header><h1>Test Results List</h1></header>
	<section>
	<%
		if(session!=null && session.getAttribute("patientId")!=null && session.getAttribute("patientPassword")!=null){
			int patientId = (int) session.getAttribute("patientId");
			TestDao td = new TestDaoImpl();
			PatientDao pd = new PatientDaoImpl();
			ArrayList<Test> testList = td.getTestDetailsByPatientId(patientId);
			Patient patient = pd.findPatientDetailsById(patientId);
			out.println("Patient ID:"+patient.getPatientId()+"<br>");
			out.println("First Name:"+patient.getFirstName()+"<br>");
			out.println("Last Name:"+patient.getLastName()+"<br>");
			out.println("DOB:"+patient.getDob()+"<br>");
			out.println("Gender :"+patient.getGender()+"<br>");
			out.println("Contact Number : "+patient.getContactNumber()+"<br>");
			out.println("Address : "+patient.getAddress()+"<br>");
			for(Test test : testList){
				out.println("<details>");
				out.println("<summary>");
				out.println("Test Id:"+test.getTestId());
				out.println("</summary>");
				out.println("Diagnostic Service Id:"+test.getServiceId()+"<br>");
				out.println("Admin Id:"+test.getAdminId()+"<br>");
				out.println("Patient Id:"+test.getPatientId()+"<br>");
				out.println("Test Name:"+test.getTestName()+"<br>");
				out.println("Test Results:"+test.getResult()+"<br>");
				out.println("Test Base Line values:"+test.getBaseLine()+"<br>");
				out.println("</details>");
			}
		}
		else{
			out.println("<h2>Your session has expired.</h2>");
			out.println("<a href='LogoutServlet'>Back To Home Page</a>");
		}
	%>
	</section>
	<footer>@ copyright, all rights reserved</footer>
</body>
</html>