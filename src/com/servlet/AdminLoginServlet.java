package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.model.Admin;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int adminId = Integer.parseInt(request.getParameter("adminId"));
		String password = request.getParameter("Password");
		AdminDao ado = new AdminDaoImpl();
		Admin found = ado.findAdminById(adminId);
		if(adminId == found.getAdminId() && password.equals(found.getPassword())) {
			HttpSession session = request.getSession(true);
			session.setAttribute("adminId",adminId );
			session.setAttribute("adminPassword", password);
			request.setAttribute("status", "Login Successful!");
			request.getRequestDispatcher("admin-home-page.jsp").forward(request, response);
			
		}
		else {
			request.setAttribute("status", "Login unsuccessful.Invalid Username, or Password");
			request.getRequestDispatcher("admin-home-page.jsp").forward(request, response);
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
