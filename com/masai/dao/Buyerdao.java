package com.masai.dao;

import java.util.List;

import com.masai.bean.Buyer;
import com.masai.bean.Buyerlist;
import com.masai.bean.SellingList;
import com.masai.exceptions.BuyerException;
import com.masai.exceptions.SellerException;

public interface Buyerdao {

	public String registerBuyer(Buyer buyer);
	
	public List<SellingList> viewbuyingList(String prop) throws SellerException;
	
	
	public String buyItem(int buyerid, int itemid) throws SellerException, BuyerException;
	
	public List<Buyerlist> viewBuyerList() throws BuyerException;
	
	public void createDispute(String name , String issue) ;
}
