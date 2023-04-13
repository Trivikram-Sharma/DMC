package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DoctorDao;
import com.dao.DoctorDaoImpl;
import com.model.Doctor;

/**
 * Servlet implementation class DoctorLoginServlet
 */
@WebServlet("/DoctorLoginServlet")
public class DoctorLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int doctorId = Integer.parseInt(request.getParameter("doctorId"));
		String password = request.getParameter("Password");
		DoctorDao dao = new DoctorDaoImpl();
		Doctor doctor = dao.findDoctorDetailsById(doctorId);
		if(doctorId==doctor.getDoctorId() && password.equals(doctor.getPassword())) {
			HttpSession session = request.getSession(true);
			session.setAttribute("doctorId", doctorId);
			session.setAttribute("doctorPassword", password);
			request.setAttribute("status", "Login Successful!");
			request.getRequestDispatcher("doctor-home-page.jsp").forward(request, response);
		}
		else {
			request.setAttribute("status", "Login Unsuccessful!Invalid Username or password");
			request.getRequestDispatcher("doctor-home-page.jsp").forward(request, response);
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
