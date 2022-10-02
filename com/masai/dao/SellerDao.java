package com.masai.dao;

import java.util.List;

import com.masai.bean.Seller;
import com.masai.bean.SellingList;
import com.masai.exceptions.SellerException;

public interface SellerDao {
	public String registerSeller(Seller seller);
	
	
	public String addItem(int sellerid,int itemId,String product,int price,int quantity) throws  SellerException;
	
	
	public String updateItem(String pro,int price,int quantity,int itemId) throws SellerException;
    
	public String removeItem(int itemId) throws SellerException;

	
	public List<SellingList> viewSolditemDetail() throws SellerException;
	public  void updateQuantity(int itemId) throws SellerException;
	public  void updateStatus(int itemId) throws SellerException;
}
