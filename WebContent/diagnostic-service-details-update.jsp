<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Diagnostic Service Details Update Page</title>
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
	#submit{
		background-color: royalblue;
		color: white;
		font-size : 10 px;
	}
	
</style>
<script type="text/javascript">
	function validateDiagnosticDetails(){
		var diagnosticServiceName = document.getElementById("dname");
		var briefOnService = document.getElementById("brief");
		var facilities = document.getElementById("facilities");
		var address = document.getElementById("address");
		
		if(diagnosticServiceName.value == ""){
			alert("Please Select the diagnostic Service Name");
			return false;
		}
		if(address.value==""){
			alert("Please Enter the address including city,state,zip,contact number,email");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<header><h1>Please create new diagnostic service by updating the fields
		below</h1></header>
		<nav>
		<a href='Login-register.jsp'>Home</a> <a
			href='diagnostic-services.jsp'>Services</a>
	</nav>
		<section>
	<form action="DiagnosticServiceUpdateServlet" method="get" onsubmit="return validateDiagnosticDetails()">
	
		<label for="dname">Diagnostic Service Name</label>&nbsp;&nbsp;
		<input type="text" name="diagnosticServiceName" id="dname" placeholder="select diagnostic service name" list="servicelist" required>
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
			<option value="Diagnosis work done before birth">Diagnosis work done before birth</option>
			<option value="Diagnosis of exclusion">Diagnosis of exclusion</option>
			<option value="Dual Diagnosis">Dual Diagnosis</option>
			<option value="Remote Diagnosis">Remote Diagnosis</option>
			<option value="Nursing Diagnosis">Nursing Diagnosis</option>
			<option value="Computer-aided Diagnosis">Computer-aided Diagnosis</option>
			<option value="Retrospective Diagnosis">Retrospective Diagnosis</option>
		</datalist>
		<br>
		<label for="brief">Brief on the Service</label>
		<textarea name="briefOnTheService" id="brief" placeholder="Enter brief on the service"></textarea><br>
		<label for="facilities">Facilities Available</label>
		<input type="text" id="facilities" name="facilitiesAvailable" placeholder="Enter the facilities available"><br>
		<label for="speciality">Specaility</label>
		<input type="text" name="speciality" id="speciality" placeholder="Enter the speciality of the diagnostic service" required><br>
		<label for="address">Address</label>
		<textarea id="address" name="address" placeholder="Enter address of the diagnostic center here" required></textarea><br>
		<input type="submit" id="submit" value="Submit">
		
	</form>
	</section>
	<footer>@ copyright, all rights reserved</footer>
</body>
</html>