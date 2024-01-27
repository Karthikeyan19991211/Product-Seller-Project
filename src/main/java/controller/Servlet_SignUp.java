package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO_Seller;
import dto.DTO_Seller;

@WebServlet("/signup")

public class Servlet_SignUp extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id=Integer.parseInt(req.getParameter("userId"));
		String name=req.getParameter("userName");
		String email=req.getParameter("userEmail");
		long contact=Long.parseLong(req.getParameter("userContact"));
		String password=req.getParameter("userPassword");
		
		DTO_Seller ds1=new DTO_Seller();
		ds1.setId(id);
		ds1.setName(name);
		ds1.setEmail(email);
		ds1.setContact(contact);
		ds1.setPassword(password);
		
		//PrintWriter pw=resp.getWriter();

		
		DAO_Seller s1=new DAO_Seller();
		try {
//			pw.println(s1.insertDetails(ds1)+" row is Affected Successfully..!");
			int res=s1.insertDetails(ds1);
			
			if(res==1)
			{
				req.setAttribute("message", "Signup Successfully Done...!");
				RequestDispatcher dispatcher= req.getRequestDispatcher("myIndex.jsp");
				dispatcher.include(req, resp);				
			}
			else
			{
				req.setAttribute("message", res+"Signup Failed...!");
				RequestDispatcher dispatcher= req.getRequestDispatcher("myIndex.jsp");
				dispatcher.include(req, resp);				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
