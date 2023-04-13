<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient Login</title>
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
		#signIn{
			size: 0.8 em;
			background-color: royalblue;
			font-weight: bold;
			color: white;
		}
</style>
<script type="text/javascript">
	function validatePatientDetails(){
		var patientId = document.getElementById("patientId");
		if(patientId.value == "" || isNaN(patientId.value)){
			alert("Please Enter your patient Id.\n[Please fill out the mandatory detail(s)]");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<header><h1>Hello, Patient! Please fill the Details below in order to Sign In</h1></header>
	<nav>
		<a href='Login-register.jsp'>Home</a>
		 <a href='diagnostic-services.jsp'>Services</a>
	</nav>
	<section>
	<form action="PatientLoginServlet" method="post" onsubmit="return validatePatientDetails()">
		<label for="patientId">PatientId</label>
		&nbsp;&nbsp;
		<input type="text" name="patientId" id="patientId" required>
		<br><br>
		<label for="Password">Password</label>
		&nbsp;&nbsp;
		<input type="password" name="Password" id="Password" required><br><br>
		<input type="submit" id="signIn" value="Sign In">
	</form>
	</section>
	<footer>@ copyright, all rights reserved</footer>
</body>
</html>