package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;



import dto.DTO_Product;

public class DAO_Product 
{
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql:///myproject?user=root&password=root");
	}
	
	public int insertProductDetails(DTO_Product p) throws ClassNotFoundException, SQLException
	{
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("insert into product values(?,?,?,?,?,?);");
		
		pst.setInt(1, p.getId());
		pst.setString(2, p.getName());
		pst.setString(3, p.getBrand());
		pst.setDouble(4,p.getDisc());
		pst.setDouble(5, p.getMrp());
		Blob img=new SerialBlob(p.getImg());
		pst.setBlob(6, img);
//		pst.setBytes(6, p.getImg());
		
		int res=pst.executeUpdate();
		con.close();
		
		return res;
	}
	
	public int updateProductDetails(DTO_Product p) throws ClassNotFoundException, SQLException
	{
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("update product set name=?, brand=?, discount=?, mrp=?, img=? where id=?");
		
		pst.setInt(6, p.getId());
		pst.setString(1, p.getName());
		pst.setString(2, p.getBrand());
		pst.setDouble(3,p.getDisc());
		pst.setDouble(4, p.getMrp());
		
//		Blob img=new SerialBlob(p.getImg());
//		pst.setBlob(5, img);
		
		if(p.getImg() != null) 
		{
			pst.setBytes(5, p.getImg());			
		}
		
		int res=pst.executeUpdate();
		con.close();
		
		return res;
	}
	
	public int deleteProductDetails(int id) throws ClassNotFoundException, SQLException
	{
		Connection con=getConnection();
		
		PreparedStatement pst=con.prepareStatement("delete from product where id=?;");
		
		pst.setInt(1, id);
		
		int res=pst.executeUpdate();
		con.close();
		
		return res;
	}
	
	public DTO_Product findDetails(int id) throws ClassNotFoundException, SQLException
	{
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("select * from product where id=?");
		
		pst.setInt(1, id);
		
		ResultSet res=pst.executeQuery();
		
		DTO_Product product=new DTO_Product();
		
		res.next();
		product.setId(res.getInt(1));
		product.setName(res.getString(2));
		product.setBrand(res.getString(3));
		product.setDisc(res.getDouble(4));
		product.setMrp(res.getDouble(5));
		
		Blob image=res.getBlob(6);
		byte[] img=image.getBytes(1,(int)image.length());
		product.setImg(img);
		
		con.close();
		
		return product;
	}
	
	public List<DTO_Product> findAll() throws ClassNotFoundException, SQLException
	{
		Connection con=getConnection();
		
		PreparedStatement pst=con.prepareStatement("select * from product;");
		
		ResultSet res=pst.executeQuery();
		
		List<DTO_Product> product = new ArrayList<DTO_Product>();
		
		while(res.next())
		{
			DTO_Product p=new DTO_Product();
			
			p.setId(res.getInt(1));
			p.setName(res.getString(2));
			p.setBrand(res.getString(3));
			p.setDisc(res.getDouble(4));
			p.setMrp(res.getDouble(5));
			
			Blob image=res.getBlob(6);
			byte[] img=image.getBytes(1,(int)image.length());
			p.setImg(img);
			
			product.add(p);
		}
		
		con.close();
		
		return product;
	}
}
