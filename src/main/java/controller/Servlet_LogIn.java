package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO_Seller;
import dto.DTO_Seller;

@WebServlet("/login")
public class Servlet_LogIn extends HttpServlet
{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String email=req.getParameter("userEmail");
		String password=req.getParameter("userPassword");
		
//		PrintWriter pw=resp.getWriter();
		
		DAO_Seller seller=new DAO_Seller();
		try {
			DTO_Seller seller1=seller.findDetails(email);
			
//			pw.println(seller1.getEmail());
//			pw.println(seller1.getPassword());
			
			if(seller1 != null)
			{
				if(password.equals(seller1.getPassword()))
				{
					HttpSession session = req.getSession();
					session.setAttribute("LogIn", seller1.getName());
					RequestDispatcher dispatcher=req.getRequestDispatcher("Home.jsp");
					dispatcher.include(req, resp);
					//pw.println("Login Seccessfully...!");
				}
				else 
				{
					req.setAttribute("message", "Invalid Password");
					RequestDispatcher dispatcher=req.getRequestDispatcher("LoginPage.jsp");
					dispatcher.include(req, resp);
					//pw.println("Invalid Password...!");
					
				}								
			}
			else
			{
				req.setAttribute("message", "Email is Invalid...!");
				RequestDispatcher dispatcher=req.getRequestDispatcher("LoginPage.jsp");
				dispatcher.include(req, resp);
				//pw.println("Email is Invalid...!");
				
			}
				
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
