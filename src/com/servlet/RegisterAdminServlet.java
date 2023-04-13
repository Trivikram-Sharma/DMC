package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.model.Admin;

/**
 * Servlet implementation class RegisterAdminServlet
 */
@WebServlet("/RegisterAdminServlet")
public class RegisterAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int adminId = Integer.parseInt(request.getParameter("adminId"));
		String password = request.getParameter("Password");
		/*int testId = 0;
		if(request.getParameter("testId")!="") {
			testId = Integer.parseInt(request.getParameter("testId"));
		}*/
		Admin admin = new Admin();
		//admin.setAdminId(adminId);
		admin.setPassword(password);
		//admin.setTestId(testId);
		AdminDao ado = new AdminDaoImpl();
		boolean inserted = ado.addAdminDetails(admin);
		if(inserted) {
			request.setAttribute("role", "Admin");
			//Retrieve the inserted details and display ID to the registered admin
			ArrayList<Admin> adminList = ado.findAllAdminDetails();
			int adminId =adminList.get(adminList.size()-1).getAdminId();
			request.setAttribute("referenceId", adminId);
			request.setAttribute("status", "Registration Successful!");
			request.getRequestDispatcher("registration-status.jsp").forward(request, response);
		}
		else {
			request.setAttribute("role", "Admin");
			request.setAttribute("status", "Registration Failed! Please Enter valid details and try again");
			request.getRequestDispatcher("registration-status.jsp").forward(request, response);
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
