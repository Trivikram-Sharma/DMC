package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AppointmentDao;
import com.dao.AppointmentDaoImpl;
import com.dao.ConnectionHandler;
import com.model.Appointment;

/**
 * Servlet implementation class AppointmentRequestServlet
 */
@WebServlet("/AppointmentRequestServlet")
public class AppointmentRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppointmentRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		System.out.println((int)session.getAttribute("patientId"));
		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
		if(session!=null && session.getAttribute("patientId")!=null && session.getAttribute("patientPassword")!=null) {
			String diagnosticServiceName = request.getParameter("diagnosticServiceName");
			System.out.println(request.getParameter("diagnosticServiceId"));
			int diagnosticServiceId = Integer.parseInt(request.getParameter("diagnosticServiceId"));
			int doctorId = Integer.parseInt(request.getParameter("doctorId"));
			String doctorName = request.getParameter("doctorName");
			String firstName=doctorName.split(" ")[0];
			String lastName = doctorName.split(" ")[1];
			String remarks = request.getParameter("remarks");
			String appointmentDate = request.getParameter("appointmentDate");
			String appointmentTime = request.getParameter("appointmentTime");
			String criticality = request.getParameter("criticality");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			String sql = "select * from diagnosticService,doctor where doctorSpeciality=speciality"
					+ " and diagnosticServiceName=? "
					+ "and firstName=? and lastName= ? and diagnosticServiceId=? and doctorId=?";
			
			Connection connection = ConnectionHandler.getDbConnection();
			
			if(connection!=null) {
				try {
					PreparedStatement psmt = connection.prepareStatement(sql);
					psmt.setString(1,diagnosticServiceName );
					psmt.setString(2, firstName);
					psmt.setString(3, lastName);
					psmt.setInt(4, diagnosticServiceId);
					psmt.setInt(5, doctorId);
					ResultSet rs = psmt.executeQuery();
					while(rs.next()){
						Appointment appointment = new Appointment();
						//appointment.setPatientId(rs.getInt("patientId"));
						appointment.setDoctorId(rs.getInt("doctorId"));
						appointment.setDiagnosticServiceName(rs.getString("diagnosticServiceName"));
						appointment.setTestId(rs.getInt("diagnosticServiceId"));						
						appointmentList.add(appointment);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					try {
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			AppointmentDao adao = new AppointmentDaoImpl();
			
			if(appointmentList.size()!=1) {
				//PrintWriter out = response.getWriter();
				System.out.println(appointmentList.size());
				out.println("Please enter valid details, and Try again.");
				if(appointmentList.size()>1) {
				for(Appointment appointment : appointmentList) {
					System.out.println(appointment.toString());
				}}
				if(appointmentList.size()==0 ) {
					out.println("No such record found!!");
					out.println("Please Enter valid details and try again");
				}
				
				out.println("<a href='patient-home-page.jsp'>Back To Dashboard</a>");
			}
			else {
				Appointment appointment = appointmentList.get(0);
				appointment.setStatus(false);
				try {
					
					appointment.setPatientId(Integer.valueOf(session.getAttribute("patientId").toString()));
					appointment.setAppointmentDate(sdf.parse(appointmentDate));
					appointment.setAppointmentTime(LocalTime.parse(appointmentTime));
					appointment.setCriticality(criticality);
					appointment.setRemarks(remarks);
					
					boolean booked = adao.addAppointmentDetails(appointment);
					if(booked) {
						out.println("<h1>Your Appointment Request has been successfully sent.</h1>");
						out.println("Click <a href='patient-home-page.jsp'>Here</a> to go back to Dashboard");
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		else {
			out.println("<h1>Your session has timed out. Please try login again</h1>");
			out.println("<a href='LogoutServlet'>Back To Home Page</a>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
