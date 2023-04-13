<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Doctors</title>
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
</style>
</head>
<body>
	<header><h1>Doctors Related to the <%=request.getParameter("serviceName") %></h1></header>
	<%@ page import="com.model.*" %>
	<%@ page import="com.dao.*" %>
	<%@ page import="java.util.ArrayList" %>
	<%@ page import="java.util.*" %>
	<%@ page import="java.sql.*" %>	
	<nav>
		<a href='Login-register.jsp'>Home</a> <a
			href='diagnostic-services.jsp'>Services</a>
	</nav>
	<section>
	<%
	if(session!=null && session.getAttribute("patientId")!=null){
		Connection connection = ConnectionHandler.getDbConnection();
		String sql = "select DoctorId,firstName,lastName,Gender,contactNumber,"+
		"doctorQualifications,d.address as address,doctorSpeciality from doctor d"+
		",diagnosticservice where diagnosticservice.speciality = doctorSpeciality "+
		"and diagnosticservice.speciality = ? and diagnosticServiceId = ?";
		ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
		
		PreparedStatement psmt = connection.prepareStatement(sql);
		psmt.setString(1,request.getParameter("speciality"));
		psmt.setInt(2,Integer.parseInt(request.getParameter("id")));
		ResultSet rs = psmt.executeQuery();
		
		while(rs.next()){
			Doctor doctor = new Doctor();
			doctor.setDoctorId(rs.getInt("DoctorId"));
			doctor.setFirstName(rs.getString("firstName"));
			doctor.setLastName(rs.getString("lastName"));
			doctor.setGender(rs.getString("Gender"));
			doctor.setContactNumber(Long.parseLong(rs.getString("contactNumber")));
			doctor.setDoctorQualification(rs.getString("doctorQualifications"));
			doctor.setAddress(rs.getString("address"));
			doctor.setDoctorSpeciality(rs.getString("doctorSpeciality"));
			
			doctorList.add(doctor);
			System.out.println(doctor);
		}
		
		
		for(Doctor doctor : doctorList){
			out.println("<details>");
			out.println("<summary>Doctor ID : "+doctor.getDoctorId()+"</summary>");
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
		
		out.println("<a href='patient-home-page.jsp'>Return to Dashboard</a>");
	}
	else{
		out.println("<a href='LogoutServlet'>Back To Home Page</a>");
	}
	%>
	</section>
	<footer>@ copyright, all rights reserved</footer>
</body>
</html>