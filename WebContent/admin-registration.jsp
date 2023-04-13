<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Registration Page</title>
<style>
	body {
	background-image: url("images/medical-background.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	text-align: center;
}
header{
	background-color : darkblue;
	color:white;
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
form{
background-color:darkcyan;
}

</style>
<script>
	function validateAdminDetails(){
		var role = document.getElementById("role");
		//var adminId = document.getElementById("admin-id");
		var password = document.getElementById("Password");
		//var testId = document.getElementById("test-id");
		if(role.value!="Admin"){
			alert("Please select your role as Admin.");
			return false;
		}
		/*if(isNaN(adminId.value)){
			alert("Please Enter numerical Id for admin Id");
			return false;
		}*/
		if(password.value==""){
			alert("Please Enter Password");
			password.style.borderColor = "red";
			return false;
		}
		if(password.value.length<6){
			alert("The Password must be atleast 6 characters");
			password.style.borderColor = "red";
			return false;
		}
		//var pattern = /^([0-9]*[a-zA-Z_]*)\W+([0-9]*[a-zA-Z_]*)*$/;
		var pattern = /^\w*\W+\w*$/;
		if(!pattern.test(password.value)){
			alert("Password must have atleast one special chatacter(s), besides alphabets,digits!!");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<header><h1>Hello Admin! Register by filling the details as shown below.</h1></header>
	<nav>
		<a href='Login-register.jsp'>Home</a>
		 <a href='diagnostic-services.jsp'>Services</a>
		<a>Appointments</a>
		<a>Test Results</a>
	</nav>
	<section>
	<form action="RegisterAdminServlet" method="post" onsubmit="return validateAdminDetails()">
	<label for="role">Please Select Role:</label>
	&nbsp;&nbsp;
	<select id="role" name="role" required>
		<option value="Admin">Admin</option>
		<option value="Patient">Patient</option>
		<option value="Doctor">Doctor</option>
	</select><br><br>
	<!-- 
	<label for="admin-id">Admin Id</label>
	&nbsp;&nbsp;
	<input type="text" id="admin-id" name="adminId" pattern="[0-9]+"> -->
	<br><br>
	<label for="Password">Password</label>
	&nbsp;&nbsp;
	<input type="password" name="Password" id="Password" required><br><br>
	<input type="submit" id="submit" value="Submit">
	</form>
	</section>
	<footer>@ copyright, all rights reserved</footer>
</body>
</html>