package com.masai.main;


import java.util.List;

import com.masai.bean.Seller;
import com.masai.bean.SellingList;
import com.masai.dao.SellerDao;
import com.masai.dao.SellerImpl;
import com.masai.exceptions.SellerException;

public class SellerRegister {
	static SellerDao sd=new SellerImpl();
	public void registerSeller(String name,String email, String password) {
	    
	    
	    Seller seller=new Seller(name,email,password);
	    seller.setName(name);
	    seller.setEmail(email);   
	    seller.setPassword(password);
	    String result=sd.registerSeller(seller);
	    System.out.println(result);
	}
	
	public void itemRegister(int sellerid,int itemId,String product,int price,int quantity) {
		
		try {
			String result =sd.addItem(sellerid, itemId, product, price, quantity);
			System.out.println(result);
		} catch (SellerException e) {
			
			System.out.println(e.getMessage());
		}
		
	}
	
	public  void updateItem(String prop,int price,int quantity,int itemId) {
		
		
		try {
			String Result=sd.updateItem(prop, price, quantity, itemId);
			System.out.println(Result);
		} catch (SellerException e) {
			
			System.out.println(e.getMessage());
		}
		
		
	}
	
	
	public void removeItem(int num) {
		
		
		try {
			String result =sd.removeItem(num);
			System.out.println(result);
		} catch (SellerException e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	public void showSoldItem() {
		
		try {
			List<SellingList> list= sd.viewSolditemDetail();
			list.forEach(s-> System.out.println(s));
		} catch (SellerException e) {
			
			System.out.println(e.getMessage());
		}
	}
	


}
