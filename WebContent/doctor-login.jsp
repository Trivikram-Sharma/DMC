<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Login Page</title>
</head>
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
		size:1em;
		background-color:royalblue;
		font-weight:bold;
		color:white;
	}
</style>
<script type="text/javascript">
	function validateDoctorDetails(){
		var doctorId = document.getElementById("doctorId");
		if(doctorId.value == ""){
			alert("Please Enter your Doctor ID!! \ n [Please fill out the mandatory field(s)]");
			return false;
		}
		return true;
	}
</script>
<body>
	<header><h1>Hello,Doctor! Please fill the details below in order to Sign In</h1></header>
	<nav>
		<a href='Login-register.jsp'>Home</a>
		 <a href='diagnostic-services.jsp'>Services</a>
	</nav>
	<section>
	<form action="DoctorLoginServlet" method="post" onsubmit="return validateDoctorDetails()">
		<label for="doctorId">Doctor ID</label>
		&nbsp;&nbsp;
		<input type="text" name="doctorId" id="doctorId" required><br><br>
		<label for="Password">Password</label>
		&nbsp;
		&nbsp;
		<input type="password" name="Password" id="Password" required><br><br>
		<input type="submit" id="signIn" value="Sign In">
	</form>
	</section>
	<footer>@ copyright, all rights reserved</footer>
</body>
</html>