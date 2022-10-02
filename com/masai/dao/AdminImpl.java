package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.Buyer;
import com.masai.bean.Seller;
import com.masai.exceptions.BuyerException;
import com.masai.exceptions.SellerException;
import com.masai.utility.DBUtil;


public class AdminImpl implements AdminDao  {

	@Override
	public List<Seller> sellerList() throws SellerException {
		List<Seller> seller= new ArrayList<>();
	   
	try(Connection conn=DBUtil.provideConnection()){
		
       PreparedStatement ps=conn.prepareStatement("Select * from seller");
		
      ResultSet rs= ps.executeQuery();
     
      while (rs.next()) {
    	  int sid= rs.getInt("sellerId");
    	  String name=rs.getString("name");
    	  String email=rs.getString("email");
    	  String password=rs.getString("password");
    	  
   	      Seller s= new Seller(sid,name,email,password);
   	      seller.add(s);
      }
		
	}catch(SQLException e) {
		throw new SellerException(e.getMessage());
	}
		
	if(seller.size()==0) {
		throw new SellerException("No Seller found.......!");
	}
	
	
		return seller;
	}

	@Override
	public List<Buyer> buyerList() throws BuyerException {
	     List<Buyer> buyer= new ArrayList<>();
	     
	    try(Connection conn= DBUtil.provideConnection()){
	    	
	    	
	    	PreparedStatement ps=conn.prepareStatement("Select * from buyer");
	    	
	    ResultSet rs=	ps.executeQuery();
	    	
	    while(rs.next()) {
	    	String name=rs.getString("name");
	    	String email=rs.getString("email");
	    	Buyer b=new Buyer();
	    	b.setName(name);
	    	b.setEmail(email);
	    	buyer.add(b);
	    }
	    	
	    } catch (SQLException e) {
			
			throw new BuyerException(e.getMessage());
		}
	    	if(buyer.size()==0) {
	    		throw new BuyerException("No Buyer found..........!");
	    	}
	    		
	    return buyer;
	}

	@Override
	public int DisputeReport() {
		int num=0;
		
		try(Connection conn= DBUtil.provideConnection()){
			
		PreparedStatement ps =conn.prepareStatement("select * from dispute");
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			num++;
		}
		
			
		} catch (SQLException e) {
	
			System.out.println(e.getMessage());
		}
		
		return num;
	}

	@Override
	public int sellingReport() {
		int num=0;
		try(Connection conn=DBUtil.provideConnection()){
			
			PreparedStatement ps	=conn.prepareStatement("select * from sellItem where status =?");
			ps.setString(1,"sold");
			ResultSet rs=	ps.executeQuery();
	           while(rs.next()) {
	        	   num++;
	           }
	           } catch (SQLException e) {
				
				e.printStackTrace();
			}
		return num;
	}

	@Override
	public String solveDispute(String name) {
		String msg="Not Solved yet.........!";

        try (Connection conn= DBUtil.provideConnection()) {
				PreparedStatement  ps = conn.prepareStatement("delete from dispute where name=?");
			     ps.setString(1,name);
			  int x= ps.executeUpdate() ; 
			  
			  if(x>0) msg= "Succesfully dispute solved..!!";
			 
			  
			  
        } catch (SQLException e) {
				
				System.out.println(e.getMessage());
			}
        
        return msg;
	}

}
