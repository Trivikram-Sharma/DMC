<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test Result Update Page</title>
<style type="text/css">
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
</style>
<script type="text/javascript">
	function validateTestResults(){
	var patientId = document.getElementById("patientId");
	var serviceId = document.getElementById("serviceId");
	var testName = document.getElementById("testName");
	var result = document.getElementById("result");
	var baseLine = document.getElementById("baseLine");
	
	if(patientId.value == "select" || patientId.value=="" || isNaN(patientId.value)){
		alert("Please select valid patient Id");
		return false;
	}
	if(serviceId.value == "select" || serviceId.value == "" || isNaN(serviceId.value)){
		alert("Please select valid service id");
		return false;
	}
	if(testName.value == "" || result.value=="" || baseLine.value==""){
		alert("Please fill the missing fields!!");
		return false;
	}
	return true;
	}
</script>
</head>
<body>
<header>
	<h2>Update Test Results by filling details below.</h2></header>
	<%@ page import="java.util.*" %>
	<%@ page import="java.sql.*" %>
	<%@ page import="com.model.*" %>
	<%@ page import="com.dao.*" %>
	
					<!-- RETRIEVING THE PATIENT AND DIAGNOSTIC SERVICE DETAILS FROM THE DATABASE  -->
	<%
	ArrayList<Integer> patientIdList = new ArrayList<Integer>();
	ArrayList<Integer> serviceIdList = new ArrayList<Integer>();
	if(session!=null && session.getAttribute("adminId")!=null && session.getAttribute("adminPassword")!=null){
	String sql1 = "select distinct patientId from appointment";
		String sql2 = "select DiagnosticServiceId from diagnosticservice";
		Connection connection = ConnectionHandler.getDbConnection();
		
		if(connection!=null){
			try{
			PreparedStatement psmt1 = connection.prepareStatement(sql1);
			
			ResultSet rs1 = psmt1.executeQuery();
			
			while(rs1.next()){
				
				int patientId = rs1.getInt("patientId");
				patientIdList.add(patientId);
			}
			PreparedStatement psmt2 = connection.prepareStatement(sql2);
			
			ResultSet rs2 = psmt2.executeQuery();
			
			while(rs2.next()){
				int serviceId = rs2.getInt("DiagnosticServiceId");
				serviceIdList.add(serviceId);
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		}
	}
	else{
		out.println("<h1>Your Session has expired.</h1>");
		out.println("<a href='LogoutServlet'>Back To Home Page</a>");
	}
	%>
	<nav>
		<a href='Login-register.jsp'>Home</a>
		 <a href='diagnostic-services.jsp'>Services</a>
	</nav>
	<section>
	<form action="TestResultServlet" method="get" onsubmit="return validateTestResults()">
			<label for="patientId">PatientId</label>
			<select id="patientId" name="patientId" required>
				<option value="select" selected>Select Patient Id</option>
				<%
					for(Integer patientId : patientIdList){
						out.println("<option value='"+patientId+"'>"+patientId+"</option>");
					}
				%>
			</select>
			<br>
			<label for="serviceId">Diagnostic Service Id</label>
			<select id="serviceId" name="serviceId" required>
				<option value="select" selected>Select Service Id</option>
				<%
					for(Integer serviceId : serviceIdList){
						out.println("<option value='"+serviceId+"'>"+serviceId+"</option>");
					}
				%>
			</select>
			<br>
			<label for="testName">Test Name:</label>
			<input type="text" name="testName" id="testName" placeholder="Enter test name here:" required><br>
			<label for="result">Test Result:</label>
			<input type="text" name="result" id="result" placeholder="Enter test result here:" required><br>
			<label for="baseLine">Test BaseLine</label>
			<textarea id="baseLine" name="baseLine" placeholder="Enter the Test Baseline values here"></textarea><br>
			<!--  <p><em>If you wish to <strong>Add new test details,</strong>click <strong>Add</strong>. <br>On the other Hand,
			If you wish to <strong>update the existing test details,</strong>click <strong>Update.</strong></em></p>
			<input type="radio" name="Action" id="add" value="Add"><label for="add">Add</label>
			<input type="radio" name="Action" id="update" value="Update"><label for="update">Update</label><br>-->
			<input type="submit" value="Submit">
	</form>
	</section>
	<footer>@ copyright, all rights reserved</footer>
</body>
</html>