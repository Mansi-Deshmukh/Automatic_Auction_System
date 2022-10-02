package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.Buyer;
import com.masai.bean.Buyerlist;
import com.masai.bean.SellingList;
import com.masai.exceptions.BuyerException;
import com.masai.exceptions.SellerException;
import com.masai.utility.DBUtil;


public class BuyerImpl implements Buyerdao {

	@Override
	public String registerBuyer(Buyer buyer) {
		String message="Not Registerd........!";
		
		Connection conn=DBUtil.provideConnection();
		try {
			PreparedStatement ps= conn.prepareStatement
					("insert into Buyer(name,email,password) values(?,?,?)");
			
			ps.setString(1,buyer.getName());
			ps.setString(2,buyer.getEmail());
			ps.setString(3, buyer.getPassword());
		int x=	ps.executeUpdate();
		if(x>0) message="Buyer Registerd Succesfully";
		
			
		} catch (SQLException e) {
			
			message=e.getMessage();
		}
		
		
		
		
		
		return message;
	}

	@Override
	public  List<SellingList> viewbuyingList(String prop) throws SellerException {
		List<SellingList> list = new ArrayList<>();
		
	try(Connection conn= DBUtil.provideConnection()){
		
	             PreparedStatement ps =conn.prepareStatement("select * from sellItem where product=?");
		 
	             ps.setString(1, prop);
                  ResultSet rs= ps.executeQuery();
                  
                  while(rs.next()) {
                	  int itemId= rs.getInt("itemId");
               	   String product=rs.getString("product");
               	   int price=rs.getInt("price");
               	   int quantity=rs.getInt("quantity");            
               	   int sellingId=rs.getInt("sellingId");
               	   String status= rs.getString("status");
               	   
               	   
               	   SellingList sl= new SellingList(itemId,product,price,quantity,sellingId,status);
                  list.add(sl);
                	  
                  }
                 if(list.size()==0) throw new SellerException("No Record Found");
		
	} catch (SQLException e) {
		
	     throw new SellerException(e.getMessage());
	}		
		return list;
	}

	@Override
	public String buyItem(int buyerid, int itemid) throws SellerException, BuyerException {
		String message= "Not inserted yet...";
		
		try(Connection conn= DBUtil.provideConnection()){
		PreparedStatement ps1=	conn.prepareStatement("select * from buyer where bid=? ");
			ps1.setInt(1, buyerid);
			
			ResultSet rs =ps1.executeQuery();
			if(rs.next())
			{				
					PreparedStatement ps2=conn.prepareStatement("select * from  sellItem where Itemid=?");
					ps2.setInt(1, itemid);
				    ResultSet rs1=	ps2.executeQuery();
				    SellerDao sd= new SellerImpl();
				     if(rs1.next()) 
				     {
				    	 if(rs1.getInt("quantity")>0) 
				    	 {
				    	   PreparedStatement ps3=conn.prepareStatement("insert into buylist values(?,?)");
							ps3.setInt(1, buyerid);
							ps3.setInt(2, itemid);
							
							int x=ps3.executeUpdate();
							if(x>0) message="Item Purchased";
						   sd.updateQuantity(itemid);
				         }else {
				        	 sd.updateStatus(itemid);
				         }
				   
				}else throw new BuyerException("Technical Error Occur!");
				
			}else throw new SellerException("Item not exist..!!") ;
			
		} catch (SQLException e) {
			
		   throw new BuyerException(e.getMessage());
		
		}
		
		return message;
	}

	@Override
	public List<Buyerlist> viewBuyerList()
			throws BuyerException {
		List<Buyerlist> list =new ArrayList<>();
		
		
		try(Connection conn= DBUtil.provideConnection()){
			
	    PreparedStatement ps =conn.prepareStatement("select b.bid, b.name,b.email, s.product, s.price  "
					+ " from  Buyer b INNER JOIN sellItem s INNER JOIN"
					+ " buylist bl ON b.bid = bl.buyerid AND s.itemid = bl.itemid");
			
	     ResultSet rs =ps.executeQuery();
	     while(rs.next()) {
	    	 
	    	 int buyId= rs.getInt("bid");
	    	String buyname= rs.getString("name");
	    	 String buyemail= rs.getString("email");
	    	 String spro= rs.getString("product");
	    	 int sprice= rs.getInt("price");
	    	 
	    	 Buyerlist by= new Buyerlist(buyId,buyname,buyemail,spro,sprice);
	    	 list.add(by);
 	 
	     }
	     if(list.size()==0) throw new BuyerException("No Record Found");
			
		} catch (SQLException e) {
			
			throw new BuyerException(e.getMessage());
		}
		
		return list;
	}

	@Override
	public void createDispute(String name, String issue) {
		
		
		
		try(Connection conn= DBUtil.provideConnection()){
			
		PreparedStatement ps =conn.prepareStatement("Insert into dispute values(?,?)");
		ps.setString(1, name);
		ps.setString(2, issue);
		  int x= ps.executeUpdate();
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		
	}

}
