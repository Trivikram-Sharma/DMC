package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AppointmentDao;
import com.dao.AppointmentDaoImpl;
import com.model.Appointment;

/**
 * Servlet implementation class AcceptServlet
 */
@WebServlet("/AcceptServlet")
public class AcceptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AcceptServlet() {
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
		if (session != null & session.getAttribute("doctorId") != null
				& session.getAttribute("doctorPassword") != null) {
			int appointmentId = Integer.parseInt(request.getParameter("appointmentId"));
			AppointmentDao ad = new AppointmentDaoImpl();
			Appointment appointment = ad.getAppointmentDetailsById(appointmentId);

			
			if (appointment.isStatus()) {
				out.println("<h1>This appointment is already accepted</h1>");
				out.println("click<a href='doctor-home-page.jsp'>Here</a> to go back to dashboard");
			} else {
				appointment.setStatus(true);

				boolean accepted = ad.updateAppointmentDetailsById(appointment);
				if (accepted) {
					out.println("<h1>The appointment is accepted successfully!!</h1>");
					out.println("click<a href='doctor-home-page.jsp'>Here</a> to go back to dashboard");
				} else {
					out.println("<h1>The appointment is not accepted. Please check the details and Try Again.</h1>");
					out.println("click<a href='doctor-home-page.jsp'>Here</a> to go back to dashboard");
				}
			}
		}
		else {
			out.println("<h1>Your session has expired</h1>");
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
