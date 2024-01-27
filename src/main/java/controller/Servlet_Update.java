package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.DAO_Product;
import dto.DTO_Product;

@WebServlet("/finalProduct")
@MultipartConfig(maxFileSize=977567666)
public class Servlet_Update extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id=Integer.parseInt(req.getParameter("productId"));
		   String name=req.getParameter("productName");
		   String brand=req.getParameter("brandName");
		   double disc=Double.parseDouble(req.getParameter("productDisc"));
		   double mrp=Double.parseDouble(req.getParameter("productMrp"));
		   
		   Part image = req.getPart("updateImage");
		  	   
		   DTO_Product pup = new DTO_Product();
		   pup.setId(id);
		   pup.setName(name);
		   pup.setBrand(brand);
		   pup.setDisc(disc);
		   pup.setMrp(mrp);

		   DAO_Product product = new DAO_Product();
		   try {
			   if(image.getSize() > 0) 
			   {
				   byte [] img = image.getInputStream().readAllBytes();
				   pup.setImg(img);
				   product.updateProductDetails(pup);
				   
				   RequestDispatcher dis = req.getRequestDispatcher("Home.jsp");
				   dis.include(req, resp);
			   }
			   else
			   {
				   DTO_Product prod = product.findDetails(id);
				   pup.setImg(prod.getImg());
				   product.updateProductDetails(pup);
				   
				   RequestDispatcher dis = req.getRequestDispatcher("Home.jsp");
				   dis.include(req, resp);
			   }

			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
