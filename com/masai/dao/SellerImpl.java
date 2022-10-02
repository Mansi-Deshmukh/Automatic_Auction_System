package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.Seller;
import com.masai.bean.SellingList;
import com.masai.exceptions.SellerException;
import com.masai.utility.DBUtil;

public class SellerImpl implements SellerDao  {

	@Override
	public String registerSeller(Seller seller) {
		String message="Not Regiesterd..............!";
		
		try(Connection conn= DBUtil.provideConnection();) {
			PreparedStatement ps=conn.prepareStatement("insert into seller (name,email,password) values(?,?,?)");
		
		         ps.setString(1,seller.getName());
		         ps.setString(2,seller.getEmail());
		         ps.setString(3, seller.getPassword());
		         
		         int x=ps.executeUpdate();

		         if(x>0) message="Succesfully regiestered Seller";

		} catch (SQLException e) {
			message=e.getMessage();
		}
		return message;
	}

	@Override
	public String addItem(int sellerid,int itemId,String product,int price,int quntity) throws SellerException{
		String message="Item Not Added";
		
		try(Connection conn= DBUtil.provideConnection()){
		PreparedStatement ps =conn.prepareStatement("select * from seller where sellerId=?");
		
		    ps.setInt(1, sellerid);
		    ResultSet rs=ps.executeQuery();
		    	    
		    if(rs.next()==true) {
		    			    
		    		PreparedStatement ps2=conn.prepareStatement("Insert into sellItem values(?,?,?,?,?,?)");
		    	    ps2.setInt(1, itemId);
		    	    ps2.setString(2, product);
		    	    ps2.setInt(3, price);
		    	    ps2.setInt(4, quntity);
		    	    ps2.setInt(5, sellerid);
		    	    ps2.setString(6, "Available");

		    	   int x= ps2.executeUpdate();
		    	   
		    	   if(x>0) {
		    		message="Item updated on item list";
		    	   }
		    	   
		    }else {
		    	throw new SellerException("Seller Record not found, To Add on selling list please add your correct selling id.....");
		    }
		    						
		} catch (Exception e) {
			
			throw new SellerException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public String updateItem(String product,int price,int quntity,int itemId) throws SellerException {
	    String message="Not updated yet......";

	    try(Connection conn=DBUtil.provideConnection()){
	    	PreparedStatement ps=conn.prepareStatement("update sellItem set product=?, price=?, quntity=?  where itemId=?");
	               
	                ps.setString(1, product);
	                ps.setInt(2, price);
	                ps.setInt(3, quntity);
	                ps.setInt(4, itemId);
	               int x= ps.executeUpdate();
	               if (x>0) message= "Succesfully Record updated";
	                
	    } catch (SQLException e) {	
			throw new SellerException(e.getMessage());
		}
 
		return message;
	}

	@Override
	public String removeItem(int itemid) throws SellerException {
		String message="Item not found";

	                   try (Connection conn= DBUtil.provideConnection()) {
							PreparedStatement  ps = conn.prepareStatement("delete from sellItem where itemid=?");
						     ps.setInt(1,itemid);
						  int x= ps.executeUpdate() ; 
						  
						  if(x>0) message= "Succesfully record deleted ";
						 
						  
						  
	                   } catch (SQLException e) {
							
							throw new SellerException(e.getMessage());
						}
		
		
		
		return message;
	}

	@Override
	public List<SellingList> viewSolditemDetail() throws SellerException {
		List<SellingList> list= new ArrayList<>();
		
		try(Connection conn=DBUtil.provideConnection()){
		
		PreparedStatement ps	=conn.prepareStatement("select * from sellItem where status =?");
		ps.setString(1,"sold");
		ResultSet rs=	ps.executeQuery();
           while(rs.next()) {
        	   int itemId= rs.getInt("itemId");
        	   String product=rs.getString("product");
        	   int price=rs.getInt("price");
        	   int quntity=rs.getInt("quntity");
        	   int sellingId=rs.getInt("sellingId");
        	   String status= rs.getString("status");
        	   
        	   SellingList sl= new SellingList(itemId,product,price,quntity,sellingId,status);
           list.add(sl);
           }
           if(list.size()==0) throw new SellerException("No Record Found");
		
		} catch (SQLException e) {
			
		    throw new SellerException(e.getMessage());
		}
		
		return list;
	}

	@Override
	public void updateQuntity(int itemid) throws SellerException {
		
		try(Connection conn=DBUtil.provideConnection()){
	    	PreparedStatement ps=conn.prepareStatement("update sellitem set quntity=quntity-1  where itemId=?");
	     
	                ps.setInt(1, itemid);
	               int x= ps.executeUpdate();
	                
	    } catch (SQLException e) {
			
			throw new SellerException(e.getMessage());
		}
		
		
	}

	@Override
	public void updateStatus(int itemid) throws SellerException {
		
		try(Connection conn=DBUtil.provideConnection()){
	    	PreparedStatement ps=conn.prepareStatement("update sellItem set status=?  where itemId=?");
	    	       
	                
	                
	                ps.setString(1, "Sold");
	                ps.setInt(2, itemid);
	               int x= ps.executeUpdate();
	                
	    } catch (SQLException e) {
			
			throw new SellerException(e.getMessage());
		}
		
		
	}

}
