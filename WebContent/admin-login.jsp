<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
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
		background-color: blue;
		color: white;
	}
</style>
<script type="text/javascript">
	function validateAdminDetails(){
		var adminId = document.getElementById("adminId");
		/*if(adminId.value=="" || isNaN(adminId)){
			alert("Please enter valid admin Id!!");
			return false;
		}*/
		return true;
	}
</script>
</head>
<body>
	<header><h1>Hello, Admin! Please Provide the details shown below in order to Sign In</h1></header>
	<nav>
		<a href='Login-register.jsp'>Home</a>
		 <a href='diagnostic-services.jsp'>Services</a>
	</nav>
	<section>
	<form action="AdminLoginServlet" method="post" onsubmit="return validateAdminDetails()">
		<label for="adminId">Admin ID</label>
		&nbsp;&nbsp;
		<input type="text" name="adminId" id="adminId" required><br><br>
		<label for="Password">Password</label>
		&nbsp;&nbsp;
		<input type="password" name="Password" id="Password" required><br><br>
		<input type="submit" id="signIn" value="Sign In">

		</form>
		</section>
		<footer>@ copyright, all rights reserved</footer>
</body>
</html>