package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/productlogOut")
public class Log_Out extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		session.invalidate();
		
		req.setAttribute("message", "Log-Out SuccessFully Done..!");
		RequestDispatcher dispatcher = req.getRequestDispatcher("LoginPage.jsp");
		dispatcher.include(req, resp);
	}
}