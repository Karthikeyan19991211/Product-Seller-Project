package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO_Product;


@WebServlet("/delete")
public class Servlet_Delete extends HttpServlet 
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
				int res=product.deleteProductDetails(id);
				if(res==1)
				{
			    RequestDispatcher dispatcher = req.getRequestDispatcher("Home.jsp");
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
