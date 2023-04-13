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

import com.dao.DoctorDao;
import com.dao.DoctorDaoImpl;
import com.model.Doctor;

/**
 * Servlet implementation class DoctorRegistrationServlet
 */
@WebServlet("/DoctorRegistrationServlet")
public class DoctorRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorRegistrationServlet() {
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
		java.util.Date dob;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				dob = sdf.parse(request.getParameter("dob"));
				String gender = request.getParameter("gender");
				long contactNumber = Long.parseLong(request.getParameter("contactNumber"));
				String password = request.getParameter("Password");
				String doctorQualification = request.getParameter("doctorQualification");
				String address = request.getParameter("address");
				String speciality = request.getParameter("speciality");
				
				Doctor doctor = new Doctor();
				doctor.setFirstName(firstName);
				doctor.setLastName(lastName);
				doctor.setDob(dob);
				doctor.setGender(gender);
				doctor.setContactNumber(contactNumber);
				doctor.setPassword(password);
				doctor.setDoctorQualification(doctorQualification);
				doctor.setAddress(address);
				doctor.setDoctorSpeciality(speciality);
				
				DoctorDao dao = new DoctorDaoImpl();
				boolean inserted = dao.addDoctorDetails(doctor);
				if(inserted) {
					request.setAttribute("role", "Doctor");
					request.setAttribute("status", "Registration Successful!");
					ArrayList<Doctor> doctorList = dao.findAllDoctorDetails();
					int index  = 0;
					if(doctorList.size()<=1) {
						index = 0;
					}
					else {
						index = doctorList.size()-1;
					}
					int doctorId = doctorList.get(index).getDoctorId();
					request.setAttribute("referenceId", doctorId);
					request.getRequestDispatcher("/registration-status.jsp").forward(request, response);
				}
				else {
					request.setAttribute("role", "Doctor");
					request.setAttribute("status", "Registration Unsuccessful! Please Enter valid details and try again!!");
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
