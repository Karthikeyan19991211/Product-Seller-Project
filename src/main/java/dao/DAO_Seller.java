package dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.DTO_Seller;

public class DAO_Seller 
{
	
	public int insertDetails(DTO_Seller s) throws ClassNotFoundException, SQLException
	{
		//Class.forName("com.mysql.cj.jdbc.Driver");
		
		Driver diver= new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(diver);
		
		Connection con=DriverManager.getConnection("jdbc:mysql:///myproject?user=root&password=root");
		
		
		PreparedStatement pst=con.prepareStatement("insert into seller values(?,?,?,?,?);");
		
		pst.setInt(1, s.getId());
		pst.setString(2,s.getName());
		pst.setString(3, s.getEmail());
		pst.setLong(4, s.getContact());
		pst.setString(5, s.getPassword());
		
		int res=pst.executeUpdate();
		con.close();
		
		return res;
	}
	
	public DTO_Seller findDetails(String email) throws ClassNotFoundException, SQLException 
	{
		
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql:///myproject?user=root&password=root");
		
		PreparedStatement pst=con.prepareStatement("select * from seller where email=?;");
		
		pst.setString(1,email);
		
		ResultSet rs=pst.executeQuery();	
		
		DTO_Seller seller=new DTO_Seller();
		
		rs.next();
		seller.setId(rs.getInt(1));
		seller.setName(rs.getString(2));
		seller.setEmail(rs.getString(3));
		seller.setContact(rs.getLong(4));
		seller.setPassword(rs.getString(5));
		
		con.close();
		
		return seller;

	}
}
