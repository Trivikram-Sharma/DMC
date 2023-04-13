package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.model.*;
import com.dao.ConnectionHandler;
import com.dao.MedicalRecordDao;
import com.dao.MedicalRecordDaoImpl;

/**
 * Servlet implementation class MedicalRecordUpdateServlet
 */
@WebServlet("/MedicalRecordUpdateServlet")
public class MedicalRecordUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MedicalRecordUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		if (session != null && session.getAttribute("doctorId") != null
				&& session.getAttribute("doctorPassword") != null) {
			int patientId = Integer.parseInt(request.getParameter("patientId"));
			int doctorId = (int) session.getAttribute("doctorId");
			int serviceId = Integer.parseInt(request.getParameter("serviceId"));
			String serviceName = request.getParameter("serviceName");
			String prescription = request.getParameter("prescription");

			String sql = "select * from appointment where patientId=? and doctorId=? and diagnosticServiceId=? and "
					+ " diagnosticServiceName=?";
			Connection connection = ConnectionHandler.getDbConnection();
			ArrayList<Appointment> aList = new ArrayList<Appointment>();
			if (connection != null) {
				try {
					PreparedStatement psmt = connection.prepareStatement(sql);
					// SET PARAMETERS
					psmt.setInt(1, patientId);
					psmt.setInt(2, doctorId);
					psmt.setInt(3, serviceId);
					psmt.setString(4, serviceName);

					ResultSet rs = psmt.executeQuery();
					while (rs.next()) {
						Appointment appointment = new Appointment();
						appointment.setAppointmentId(rs.getInt("appointmentId"));
						appointment.setPatientId(rs.getInt("patientId"));
						appointment.setDoctorId(rs.getInt("doctorId"));
						appointment.setTestId(rs.getInt("diagnosticServiceId"));
						appointment.setDiagnosticServiceName(rs.getString("diagnosticServiceName"));
						appointment.setRemarks(rs.getString("remarks"));
						if (rs.getDate("appointmentDate") == null) {
							appointment.setAppointmentDate(null);
						} else {
							appointment.setAppointmentDate(new java.util.Date(rs.getDate("appointmentDate").getTime()));
						}
						if (rs.getTime("appointmentTime") == null) {
							appointment.setAppointmentTime(null);
						} else {
							appointment.setAppointmentTime(rs.getTime("appointmentTime").toLocalTime());
						}
						appointment.setCriticality(rs.getString("Criticality"));
						appointment.setStatus(rs.getBoolean("status"));

						aList.add(appointment);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// RETRIVING DATA DONE
				// CHECKING VALIDITY
				if (aList.size() != 1) {
					out.println("<h1>Please enter valid details and try again!!</h1>");
					out.println("<a href='doctor-home-page.jsp'>Back to Dashboard</a>");
				}
				else {
					MedicalRecord mr =new MedicalRecord();
					mr.setPatientId(patientId);
					mr.setDoctorId(doctorId);
					mr.setServiceId(serviceId);
					mr.setServiceName(serviceName);
					mr.setPrescription(prescription);
					MedicalRecordDao md = new MedicalRecordDaoImpl();
					boolean inserted = md.addMedicalRecord(mr);
					if(inserted) {
						out.println("<h1>The Medical Record details are updated successfully!.</h1>");
						out.println("<a href='doctor-home-page.jsp'>Back to Dashboard</a>");
					}
					else {
						out.println("<h1>Please enter valid details and try again!!</h1>");
						out.println("<a href='doctor-home-page.jsp'>Back to Dashboard</a>");
					}
				}

			}
		} else {
			out.println("Your session has expired.");
			out.println("<a href='LogoutServlet'>Back To Home Page</a>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
