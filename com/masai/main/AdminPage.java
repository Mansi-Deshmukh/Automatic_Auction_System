package com.masai.main;

import java.util.List;

import com.masai.bean.Buyer;
import com.masai.bean.Seller;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminImpl;
import com.masai.exceptions.BuyerException;
import com.masai.exceptions.SellerException;

public class AdminPage {
	static AdminDao ad= new AdminImpl();
	public void showSellerList() {
	
		
		try {
			List<Seller> seller= ad.sellerList();
			
			seller.forEach(s->{
				System.out.println(s.getName());
				System.out.println(s.getEmail());
				System.out.println("---------------------");
			});
		} catch (SellerException e) {
			
			System.out.println(e.getMessage());
		}
	}	
		public void showBuyerList() {
			
			
			try {
				List<Buyer> buyer= ad.buyerList();
				
				buyer.forEach(s->{
					System.out.println(s.getName());
					System.out.println(s.getEmail());
					System.out.println("----------------------");
				});
			} catch (BuyerException e) {
				
				System.out.println(e.getMessage());
			}
		
	
}
		public void viewDisputeReport() {
			
			int n=ad.DisputeReport();
			System.out.println("Total dispute Report"+" "+ n);
		}

		public void viewsellingReport() {
			
			int n=ad.sellingReport();
			System.out.println("Total selling Report"+" "+ n);
			
		}
		
		public void solvedispute(String name) {
			
			String Result= ad.solveDispute(name);
			System.out.println(Result);
		}
}
