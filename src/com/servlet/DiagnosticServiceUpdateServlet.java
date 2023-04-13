package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DiagnosticServiceDao;
import com.dao.DiagnosticServiceDaoImpl;
import com.model.DiagnosticService;

/**
 * Servlet implementation class DiagnosticServiceUpdateServlet
 */
@WebServlet("/DiagnosticServiceUpdateServlet")
public class DiagnosticServiceUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiagnosticServiceUpdateServlet() {
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
		if(session!=null && session.getAttribute("adminId")!=null && session.getAttribute("adminPassword")!=null) {
		String diagnosticServiceName = request.getParameter("diagnosticServiceName");
		String briefOnDiagnosticCenter = request.getParameter("briefOnTheService");
		String facilitiesAvailable = request.getParameter("facilitiesAvailable");
		String speciality = request.getParameter("speciality");
		String address = request.getParameter("address");
		
		DiagnosticService ds = new DiagnosticService();
		
		ds.setDiagnosticServiceName(diagnosticServiceName);
		ds.setBriefOnDiagnosticCenter(briefOnDiagnosticCenter);
		ds.setSpeciality(speciality);
		ds.setFacilitiesAvailable(facilitiesAvailable);
		ds.setAddress(address);
		
		DiagnosticServiceDao dsd = new DiagnosticServiceDaoImpl();
		boolean inserted = dsd.addDiagnosticService(ds);
		
		
		if(inserted) {
			out.println("<h1>The Diagnostic service Details are updated Successfully</h1>");
			out.println("<a href='admin-home-page.jsp'>Back To Home Page</a>");
		}
		else {
			out.println("Data not inserted!! Please enter valid details and try again");
			out.println("<a href='admin-home-page.jsp'>Back To Home Page</a>");
		}}
		else {
			out.println("<h1>You Session has expired.Please Login again</h1>");
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
