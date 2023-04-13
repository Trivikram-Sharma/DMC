package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.PatientDao;
import com.dao.PatientDaoImpl;
import com.model.Patient;

/**
 * Servlet implementation class PatientLoginServlet
 */
@WebServlet("/PatientLoginServlet")
public class PatientLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int patientId = Integer.parseInt(request.getParameter("patientId"));
		String password = request.getParameter("Password");
		PatientDao patientDao = new PatientDaoImpl();
		Patient patient = patientDao.findPatientDetailsById(patientId);
		/*System.out.println(patient.getPatientId()+1);
		System.out.println(patient.getPassword());
		System.out.println(patientId+1);
		System.out.println(password);
		System.out.println(patientId==patient.getPatientId());
		System.out.println(password.equals(patient.getPassword()));*/
		if(patientId==patient.getPatientId() && password.equals(patient.getPassword())) {
			HttpSession session = request.getSession(true);
			session.setAttribute("patientId", patient.getPatientId());
			session.setAttribute("patientPassword", patient.getPassword());
			request.setAttribute("status", "Login Successful!");
			request.getRequestDispatcher("patient-home-page.jsp").forward(request, response);
		}
		else {
			request.setAttribute("status", "Login Unsuccessful!Invalid Username or password");
			request.getRequestDispatcher("patient-home-page.jsp").forward(request, response);
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
