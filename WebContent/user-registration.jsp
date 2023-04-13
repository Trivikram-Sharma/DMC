<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration Page</title>
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
	text-align : center;
}
section a:hover{
	background-color : yellow;
}
</style>
<script type="text/javascript">
	function validatePatientDetails() {
		var firstName = document.getElementById("fname");
		var lastName = document.getElementById("lname");
		var dob = document.getElementById("dob");
		var gender = document.getElementById("gender");
		var contactNumber = document.getElementById("contactNumber");
		var password = document.getElementById("Password");
		if (firstName.value == "") {
			alert("Please Enter your First Name!!");
			return false;
		}
		if (lastName.value == "") {
			alert("Please Enter your Last Name!!");
			return false;
		}
		if (dob.value == "") {
			alert("Please Enter your Date Of Birth");
			return false;
		}
		if (gender.value == "Select") {
			alert("Please Select your gender");
			return false;
		}
		if (contactNumber.value == "") {
			alert("Please Enter your Mobile Number!!");
			return false;
		}
		if (isNaN(contactNumber.value) || contactNumber.value.length > 10) {
			alert("Please Enter your 10 digit Mobile Numeber!!");
			return false;
		}
		if (password.value.length < 6) {
			alert("Password must be atleast 6 characters!!");
			return false;
		}
		//var pattern = /^([0-9]*[a-zA-Z_]*)*\W+([0-9]*[a-zA-Z_]*)*$/;
		var pattern = /^\w*\W+\w*$/;
		if (!pattern.test(password.value)) {
			alert("Password must have atleast one special chatacter(s),besides alphabets,digits!!");
			return;
		}
		return true;
	}
	function validateDoctorDetails() {
		var firstName = document.getElementById("fname");
		var lastName = document.getElementById("lname");
		var dob = document.getElementById("dob");
		var gender = document.getElementById("gender");
		var contactNumber = document.getElementById("contactNumber");
		var password = document.getElementById("Password");
		var doctorQualification = document
				.getElementById("doctorQualification");
		var address = document.getElementById("address");
		var speciality = document.getElementById("speciality");
		if (firstName.value == "") {
			alert("Please Enter your First Name");
			return false;
		}
		if (lastName.value == "") {
			alert("Please Enter your Last Name");
			return false;
		}
		if (dob.value == "") {
			alert("Please Enter your Date Of Birth");
			return false;
		}
		if (gender.value == "Select") {
			alert("Please Select your Gender");
			return false;
		}
		if (contactNumber.value == "") {
			alert("Please Enter your 10 digit Mobile number!!");
			return false;
		}
		if (isNaN(contactNumber.value)) {
			alert("Please Enter your 10 digit Mobile Number!! It has only digits");
			return false;
		}
		if (contactNumber.value.length<10 || contactNumber.value.length>10) {
			alert("Mobile number has 10 digits. Please Enter your Mobile Number!!");
			return false;
		}
		if (password.value == "") {
			alert("Please Enter Password");
			return false;
		}
		if (password.value.length < 6) {
			alert("The Password must be atleast 6 characters");
			return false;
		}
		//var pattern = /^([0-9]*[a-zA-Z_]*)*\W+([0-9]*[a-zA-Z_]*)*$/;
		var pattern = /^\w*\W+\w*$/;
		if (!pattern.test(password.value)) {
			alert("Password must have atleast one special chatacter(s), besides alphabets,digits!!");
			return false;
		}
		if (doctorQualification.value == "") {
			alert("Please Enter your Qualifications");
			return false;
		}
		if (address.value == "") {
			alert("Please Enter your address");
			return false;
		}
		if (speciality.value == "") {
			alert("Please enter your doctor's speciality!!");
			return false;
		}
		return true;

	}
</script>
</head>
<body>
	<c:if test="${param.user == 'patient' }">
		<header><h1>Hello, Patient! Register by filling the details shown below.</h1></header>
		<section>
		<form action="PatientRegistrationServlet"
			method="post" onsubmit="return validatePatientDetails()">
			<label for="fname">First Name</label> &nbsp;&nbsp; <input type="text"
				name="firstName" id="fname" required><br> <br> <label
				for="lname">Last Name</label> &nbsp;&nbsp; <input type="text"
				name="lastName" id="lname" required><br> <br> <label
				for="dob">Date Of Birth</label> &nbsp;&nbsp; <input type="date"
				name="dob" id="dob" required><br> <br> <label
				for="gender">Gender</label> &nbsp;&nbsp; <select name="gender"
				id="gender">
				<option value="Select" selected>Select Gender</option>
				<option value="Male">Male</option>
				<option value="Female">Female</option>
				<option value="Other">Other</option>
			</select><br> <br> <label for="contactNumber">Contact number</label>
			&nbsp;&nbsp; <input type="number" name="contactNumber"
				id="contactNumber" maxlength="10" required><br> <br>
			<label for="Password">Password</label> &nbsp;&nbsp; <input
				type="password" name="Password" id="Password" required><br>
			<br> <input type="submit" name="Submit" value="Submit">
		</form></section>
	</c:if>
	<c:if test="${param.user == 'doctor' }">
		<header><h1>Hello, Doctor! Register by filling the details shown below.</h1></header>
		<section>
		<form action="DoctorRegistrationServlet"
			method="post" onsubmit="return validateDoctorDetails()">
			<label for="fname">First Name</label> &nbsp;&nbsp; <input type="text"
				name="firstName" id="fname" required><br> <br> <label
				for="lname">Last Name</label> &nbsp;&nbsp; <input type="text"
				name="lastName" id="lname" required><br> <br> <label
				for="dob">Date Of Birth</label> &nbsp;&nbsp; <input type="date"
				name="dob" id="dob" required><br> <br> <label
				for="gender">Gender</label> &nbsp;&nbsp; <select id="gender"
				name="gender">
				<option value="Select" selected>Select Gender</option>
				<option value="Male">Male</option>
				<option value="Female">Female</option>
				<option value="Other">Other</option>
			</select><br> <br> <label for="contactNumber">Contact number</label>
			&nbsp;&nbsp; <input type="number" name="contactNumber"
				id="contactNumber" maxlength="10" required><br> <br>
			<label for="Password">Password</label> &nbsp;&nbsp; <input
				type="password" name="Password" id="Password" required><br>
			<br> <label for="doctorQualification">Doctor
				Qualification</label> &nbsp;&nbsp;
			<textarea id="doctorQualification" name="doctorQualification"
				required>
			</textarea>
			<label for="address">Address</label> &nbsp;&nbsp;
			<textarea id="address" name="address" required></textarea>
			<label for="speciality">Doctor's Speciality</label> <input
				type="text" id="speciality" name="speciality" required><br>
			<br> <input type="submit" id="Submit" value="Submit">
		</form></section>
	</c:if>
<footer>@ copyright, all rights reserved</footer>
</body>
</html>