package com.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Home" , urlPatterns = {"/home"})

public class Home extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(request.getParameter("userName")!=null) {
			session.setAttribute("userName", request.getParameter("userName"));
			session.setAttribute("password",  request.getParameter("password"));
		}
		if(session.getAttribute("userName") == null ) {
			response.sendRedirect("login.html");
		}else{
			String name = (String) session.getAttribute("userName");
			response.getWriter().print("<h1> Hello "+ name);
			response.getWriter().print("<form action =\"logout\" method = \"POST\">\r\n"
					+ "         <input type = \"submit\" value = \"Logout\" />\r\n"
					+ "      </form> ");
		}
	}
}