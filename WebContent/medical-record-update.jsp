<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Medical Record Update</title>
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
	form{
		text-align:center;
		background-color : darkcyan;
		border-left: 30%;
		border-right : 30%;
	}
</style>
<script type="text/javascript">
function validateMRdetails(){
	var patientId = document.getElementById("patientId");
	var serviceId = document.getElementById("serviceId");
	var serviceName = document.getElementById("serviceName");
	var prescription = document.getElementById("prescription");
	
	if(patientId.value== "" || isNaN(patientId.value) || patientId.value=="select"){
		alert("Please select the valid patient ID");
		return false;
	}
	if(serviceId.value== "" || isNaN(serviceId.value) || serviceId.value=="select"){
		alert("Please select the valid service ID");
		return false;
	}
	if(serviceName.value == "" || serviceName.value == "select"){
		alert("Please Enter service Name");
		return false;
	}
	if(prescription == ""){
		alert("Please Enter prescription");
		return false;
	}
	return true;
	
	}
</script>
</head>
<body>
	<%@ page import="java.util.*" %>
	<%@ page import="java.sql.*" %>
	<%@ page import="com.model.*" %>
	<%@ page import="com.dao.*" %>
	<header><h1>Update medical records by filling details below.</h1></header>
	<nav>
		<a href='Login-register.jsp'>Home</a>
		 <a href='diagnostic-services.jsp'>Services</a>
	</nav>
	<section>
	<form action="MedicalRecordUpdateServlet" method="get"onsubmit="return validateMRdetails()">
		<label for="patientId">PatientId:</label>
		<select id="patientId" name="patientId" required>
			<option value="select" selected>Select Patient Id</option>
			<%
			int doctorId = 0;
			if(session!=null && session.getAttribute("doctorId")!=null && session.getAttribute("doctorPassword")!=null){
				doctorId = (int)session.getAttribute("doctorId");	
			}
				AppointmentDao ad = new AppointmentDaoImpl();
				ArrayList<Appointment> aList = ad.getAppointmentDetailsByDoctorId((int) session.getAttribute("doctorId"));
				for(Appointment appointment : aList){
					out.println("<option value='"+appointment.getPatientId()+"'>"+appointment.getPatientId()+"</option>");
				}
			%>
		</select><br>
		<label for="serviceId">Diagnostic Service Id:</label>
		<select id="serviceId" name="serviceId" required>
			<%
				for(Appointment appointment : aList){
					out.println("<option value='"+appointment.getTestId()+"'>"+appointment.getTestId()+"</option>");
				}
			%>
		</select><br>
		<label for="serviceName">Service Name</label>
		<select id="serviceName" name="serviceName" required>
		<option value="select" selected>Select Diagnostic Service</option>
			<option value="Clinical Diagnosis">Clinical Diagnosis</option>
			<option value="Laboratory Diagnosis">Laboratory Diagnosis</option>
			<option value="Radiology Diagnosis">Radiology Diagnosis</option>
			<option value="Tissue Diagnosis">Tissue Diagnosis</option>
			<option value="Principal Diagnosis">Principal Diagnosis</option>
			<option value="Admitting Diagnosis">Admitting Diagnosis</option>
			<option value="Differential Dianosis">Differential Dianosis</option>
			<option value="Diagnostic Criteria">Diagnostic Criteria</option>
			<option value="Prenatal Diagnosis">Prenatal Diagnosis</option>
			<option value="Diagnosis work done before birth">Diagnosis work done before birth</option>
			<option value="Diagnosis of exclusion">Diagnosis of exclusion</option>
			<option value="Dual Diagnosis">Dual Diagnosis</option>
			<option value="Remote Diagnosis">Remote Diagnosis</option>
			<option value="Nursing Diagnosis">Nursing Diagnosis</option>
			<option value="Computer-aided Diagnosis">Computer-aided Diagnosis</option>
			<option value="Retrospective Diagnosis">Retrospective Diagnosis</option>
		</select><br>
		<label for="prescription">Prescription</label>
		<textarea id="prescription" name="prescription" placeholder="Enter the prescription here" required></textarea>
		<br><input type="submit" id="Submit" value="Submit">
	</form>
	</section>
	<footer>@ copyright, all rights reserved</footer>
</body>
</html>