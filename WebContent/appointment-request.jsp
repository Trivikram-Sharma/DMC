<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Appointment Booking Page</title>
<style>
	body {
	background-image: url("images/medical-background.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	text-align: center;
}
	#doctor,#diagnosticService{
	width: 20em;
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
	float: left;
	background-color : yellow;
	color : blue;
}
section summary{
	background-color : blue;
	color : white;
}

</style>
<script type="text/javascript">
	 
</script>
</head>
<body>
	<%@ page import="java.util.*"%>
	<%@ page import="java.sql.*"%>
	<%@ page import="com.model.*"%>
	<%@ page import="com.dao.*"%>
	<header><h1>Book your Appointment by filling the details below</h1>
	
	<p align="center">
		Please select your Diagnostic Service first. <i><strong>Then,</strong>
			select the doctor based on the diagnostic service you have selected.</i>.
	</p></header>
	<nav>
		<a href='Login-register.jsp'>Home</a>
		 <a href='diagnostic-services.jsp'>Services</a>
	</nav>
	<section>
	<form action="AppointmentRequestServlet" method="get"
		onsubmit="return validateAppointmentDetails()">
		
							<!-- JSP CODE TO FILL DIAGNOSTIC SERVICE ID -->
		
		<%
	if(session!=null && session.getAttribute("patientId")!=null){
		DiagnosticServiceDao dsdo = new DiagnosticServiceDaoImpl();
		ArrayList<DiagnosticService> dsList = dsdo.getAllDiagnosticServices();
		out.println("List of Diagnostic Services IDs");
		
		for(DiagnosticService ds : dsList){
			out.println("<details>");
			out.println("<summary><input type='radio' id='service"+ds.getDiagnosticServiceId()+"' name='diagnosticServiceId' value='"+ds.getDiagnosticServiceId()+"' required><label for='service"+ds.getDiagnosticServiceId()+"'>Diagnostic Id:"+ds.getDiagnosticServiceId()+"</label>");
			out.println("<br>Click Here to view more details</summary>");
			out.println("<ul>");
			out.println("<li><big>Diagnosis Name : </big>"+ds.getDiagnosticServiceName()+"</li>");
			out.println("<li><big>Brief on the Diagnostic Service : </big>"+ds.getBriefOnDiagnosticCenter()+"</li>");
			out.println("<li><big>Facilities Available : </big>"+ds.getFacilitiesAvailable()+"</li>");
			out.println("<li><big>Speciality : </big>"+ds.getSpeciality()+"</li>");
			out.println("<li><big>Address : </big>"+ds.getAddress()+"</li>");
			//out.println("<li><big><a href='view-doctors.jsp?serviceName="+ds.getDiagnosticServiceName()+"&id="+ds.getDiagnosticServiceId()+"&speciality="+ds.getSpeciality()+"' target='_blank'>View Doctors</a></big></li>");
			out.println("</details>");
			out.println("</ul>");
	} 
		}	
		else{
		out.println("<a href='LogoutServlet'>Back To Home Page</a>");
	} 
	%>
	
	
										<!-- JSP CODE FOR FILLING DIAGNOSTIC SERVICE NAME -->
	
	
		<label for="diagnosticService">Diagnostic Service</label> <input
			type="text" id="diagnosticService" name="diagnosticServiceName"
			placeholder="Please select the diagnostic service" list="servicelist"
			required>
		<datalist id="servicelist">
			<option value="Clinical Diagnosis">Clinical Diagnosis</option>
			<option value="Laboratory Diagnosis">Laboratory Diagnosis</option>
			<option value="Radiology Diagnosis">Radiology Diagnosis</option>
			<option value="Tissue Diagnosis">Tissue Diagnosis</option>
			<option value="Principal Diagnosis">Principal Diagnosis</option>
			<option value="Admitting Diagnosis">Admitting Diagnosis</option>
			<option value="Differential Dianosis">Differential Dianosis</option>
			<option value="Diagnostic Criteria">Diagnostic Criteria</option>
			<option value="Prenatal Diagnosis">Prenatal Diagnosis</option>
			<option value="Diagnosis work done before birth">Diagnosis
				work done before birth</option>
			<option value="Diagnosis of exclusion">Diagnosis of
				exclusion</option>
			<option value="Dual Diagnosis">Dual Diagnosis</option>
			<option value="Remote Diagnosis">Remote Diagnosis</option>
			<option value="Nursing Diagnosis">Nursing Diagnosis</option>
			<option value="Computer-aided Diagnosis">Computer-aided
				Diagnosis</option>
			<option value="Retrospective Diagnosis">Retrospective
				Diagnosis</option>
		</datalist>
		 <br> 
			
											<!-- RETRIEVEING ALL DOCTOR DETAILS FROM DATABASE -->
		<%
			DoctorDao d = new DoctorDaoImpl();
			ArrayList<Doctor> doctorList = d.findAllDoctorDetails();
		%>
		
											<!-- JSP CODE TO SELECT DOCTOR ID -->
		
		<%
		for(Doctor doctor : doctorList){
			out.println("<details>");
			out.println("<summary><input type='radio' value='"+doctor.getDoctorId()+"' name='doctorId' id='doctor"+doctor.getDoctorId()+"'><br>");
			out.println("<label for='doctor"+doctor.getDoctorId()+"'>Doctor ID : "+doctor.getDoctorId()+"</label><br>");
			out.println("Click Here to view more details</summary>");
			out.println("<ul>");
			out.println("<li><big>First Name : </big>"+doctor.getFirstName()+"</li>");
			out.println("<li><big>Last Name : </big>"+doctor.getLastName()+"</li>");
			out.println("<li><big>Gender : </big>"+doctor.getGender()+"</li>");
			out.println("<li><big>Contact Number : </big>"+doctor.getContactNumber()+"</li>");
			out.println("<li><big>Doctor Qualification : </big>"+doctor.getDoctorQualification()+"</li>");
			out.println("<li><big>Address : </big>"+doctor.getAddress()+"</li>");
			out.println("<li><big>Doctor Speciality : </big>"+doctor.getDoctorSpeciality()+"</li>");
			out.println("</ul>");
			out.println("</details>");
		}
		%>
		
		
		
		
		<!-- Form ELEMENT TO SELECT DOCTOR NAME -->
		<br>
		<label for="doctor"> Doctor's Name based on
			your Diagnostic Service Selection : </label> <br> <span
			id="warning-message"></span>
		<input type="text" id="doctor" name="doctorName" placeholder="click once to select doctor" list="doctorList"
			required> <br>
		<%
			out.println("<datalist id='doctorList'>");
				for(Doctor doctor:doctorList){
					out.println("<option value='"+doctor.getFirstName()+" "+doctor.getLastName()+"'>"+doctor.getFirstName()+" "+doctor.getLastName()+"</option>");		
				}
				out.println("</datalist>");
			%>
			
		<br>
		<label for="remarks">Remarks/Symptoms:</label><br>
		<textarea id="remarks" name="remarks"
			placeholder="Enter your Remarks/symptoms here" required></textarea>
		<br> <label for="appointmentDate">Appointment Date:</label><br>
		<input type="date" id="appointmentDate" name="appointmentDate"
			width="100%" required><br> <label for="appointmentTime">
			Appointment Time</label> <input type="Time" id="appointmentTime"
			name="appointmentTime" width="100%" required><br>
		<p>
			<strong>Criticality/Medical Condition</strong>
		</p>
		<br> <input type="radio" id="criticality1" name="criticality"
			value="Low" required> <label for="criticality1"><small>Low</small></label>
		<input type="radio" id="criticality2" name="criticality"
			value="Medium" required> <label for="criticality2">Medium</label>
		<input type="radio" id="criticality3" name="criticality" value="High"
			required> <label for="criticality3">High</label><br> <input
			type="submit" value="Request Appointment">

	</form>
	</section>
	<footer>@copyright, all rights reserved</footer>
</body>
</html>