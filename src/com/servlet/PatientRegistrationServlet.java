package com.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PatientDao;
import com.dao.PatientDaoImpl;
import com.model.Patient;

/**
 * Servlet implementation class PatientRegistrationServlet
 */
@WebServlet("/PatientRegistrationServlet")
public class PatientRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		System.out.println(request.getParameter("dob"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dob;
		try {
			dob = sdf.parse(request.getParameter("dob"));
			
			System.out.println(dob);
			String gender = request.getParameter("gender");
			long contactNumber = Long.parseLong(request.getParameter("contactNumber"));
			String password = request.getParameter("Password");
			
			Patient patient = new Patient();
			patient.setFirstName(firstName);
			patient.setLastName(lastName);
			patient.setDob(dob);
			patient.setGender(gender);
			patient.setContactNumber(contactNumber);
			patient.setPassword(password);
			
			PatientDao pdao = new PatientDaoImpl();
			boolean inserted = pdao.addPatientDetails(patient);
			
			if(inserted) {
				request.setAttribute("role","Patient");
				request.setAttribute("status", "Registration Successful!!");
				ArrayList<Patient> patientList = pdao.findAllPatientDetails();
				int patientId = patientList.get(patientList.size()-1).getPatientId();
				request.setAttribute("referenceId", patientId);
				request.getRequestDispatcher("/registration-status.jsp").forward(request, response);
			}
			else {
				request.setAttribute("role","Patient");
				request.setAttribute("status", "Registration Unsuccessful!! Please Enter valid details and try again!!");
				request.getRequestDispatcher("/registration-status.jsp").forward(request, response);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
