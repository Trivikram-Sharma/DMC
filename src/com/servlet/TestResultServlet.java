package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.dao.TestDao;
import com.dao.TestDaoImpl;
import com.model.Appointment;
import com.model.Test;

/**
 * Servlet implementation class TestResultServlet
 */
@WebServlet("/TestResultServlet")
public class TestResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestResultServlet() {
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
		if (session != null && session.getAttribute("adminId") != null
				&& session.getAttribute("adminPassword") != null) {
			int serviceId = Integer.parseInt(request.getParameter("serviceId"));
			int patientId = Integer.parseInt(request.getParameter("patientId"));
			int adminId = (int) session.getAttribute("adminId");
			String testName = request.getParameter("testName");
			String result = request.getParameter("result");
			//String action = request.getParameter("Action");
			String baseLine = request.getParameter("baseLine");
			Test test = new Test();
			test.setServiceId(serviceId);
			test.setPatientId(patientId);
			test.setAdminId(adminId);
			test.setTestName(testName);
			test.setResult(result);
			test.setBaseLine(baseLine);

			TestDao td = new TestDaoImpl();

			// CHECKING VALIDITY OF DATA
			AppointmentDao ad = new AppointmentDaoImpl();
			ArrayList<Appointment> appointmentList = ad.getAppointmentDetailsByPatient(patientId);
			int i = 0;
			for (Appointment appointment : appointmentList) {
				if (appointment.getTestId() != serviceId) {
					i++;
				}
				if (appointment.getTestId() == serviceId) {
					break;
				}
			}
			// CHECKING VALIDITY IN APPOINTMENT TABLE
			if (i == appointmentList.size()) {
				out.println("Please enter valid test details and try again.");
				out.println("Click <a href='admin-home-page.jsp'>Here</a> to go back to dashboard");
			}
			if (i < appointmentList.size()) {
				//if (action == "Add") {//}
					boolean inserted = td.addTestDetails(test);
					if (inserted) {
						out.println("<h2>The test details are updated successfully!!</h2>");
						out.println("<a href='admin-home-page.jsp'>Back to Dashboard</a>");
					} else {
						out.println(
								"<h2>The test details are NOT updated!! Please,check the details and try again.</h2>");
						out.println("<a href='admin-home-page.jsp'>Back to Dashboard</a>");
					}
				
				/*if (action == "update") {
					boolean updated = td.updateTestDetails(test);
					if (updated) {
						out.println("<h2>The test details are updated successfully!!</h2>");
						out.println("<a href='admin-home-page.jsp'>Back to Dashboard</a>");
					} else {
						out.println(
								"<h2>The test details are NOT updated!! Please,check the details and try again.</h2>");
						out.println("<a href='admin-home-page.jsp'>Back to Dashboard</a>");
					}
				}*/
			}
		} else {
			out.println("<h1>Your Session has expired.</h1>");
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
