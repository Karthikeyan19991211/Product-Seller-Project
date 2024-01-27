package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.DAO_Product;
import dto.DTO_Product;


@WebServlet("/addProduct")
@MultipartConfig(maxFileSize=977567666)
public class Servlet_addProduct extends HttpServlet
{

protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
   int id=Integer.parseInt(req.getParameter("productId"));
   String name=req.getParameter("productName");
   String brand=req.getParameter("brandName");
   double disc=Double.parseDouble(req.getParameter("productDisc"));
   double mrp=Double.parseDouble(req.getParameter("productMrp"));
   
   Part image = req.getPart("addImage");
   
   DTO_Product p = new DTO_Product();
   p.setId(id);
   p.setName(name);
   p.setBrand(brand);
   p.setDisc(disc);
   p.setMrp(mrp);
   p.setImg(image.getInputStream().readAllBytes());
   
   DAO_Product product = new DAO_Product();
   try {
	HttpSession session = req.getSession();
	String logIn=(String)session.getAttribute("LogIn");
	
	if(logIn != null)
	{
		int result=product.insertProductDetails(p);
		if(result == 1)
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
