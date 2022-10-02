package com.masai.dao;

import java.util.List;

import com.masai.bean.Buyer;
import com.masai.bean.Seller;
import com.masai.exceptions.BuyerException;
import com.masai.exceptions.SellerException;

public interface AdminDao {

	public List<Seller> sellerList() throws SellerException;
	
	public List<Buyer> buyerList() throws BuyerException;
	
	public int DisputeReport();
	public int sellingReport();
	public String solveDispute(String name);
	
}
