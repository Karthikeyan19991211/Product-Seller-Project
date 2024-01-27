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
import javax.servlet.http.HttpSession;

import dao.DAO_Product;
import dto.DTO_Product;

@WebServlet("/edit")
public class Servlet_Edit extends HttpServlet 
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id = Integer.parseInt(req.getParameter("id"));
		
		DAO_Product product = new DAO_Product();
		try {
			HttpSession session = req.getSession();
			String lonIn=(String)session.getAttribute("LogIn");
			
			if(lonIn != null)
			{
				DTO_Product p = product.findDetails(id);
				
				
				if(p != null)
				{
					req.setAttribute("productUpdate", p);
					
					RequestDispatcher dispatcher = req.getRequestDispatcher("updateProduct.jsp");
					dispatcher.include(req, resp);
				}
			}
			else
			{
				req.setAttribute("message", "Acess Denied...!");
				RequestDispatcher dispatcher = req.getRequestDispatcher("LoginPage.jsp");
				dispatcher.include(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
