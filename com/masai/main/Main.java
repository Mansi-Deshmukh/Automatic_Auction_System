package com.masai.main;

import java.util.Scanner;

import com.masai.usecase.AddProduct;
import com.masai.usecase.BuyItem;
import com.masai.usecase.DeleteProduct;
import com.masai.usecase.GetBuyerUseCase1;
import com.masai.usecase.GetSellerUseCase1;
import com.masai.usecase.ProductList;
import com.masai.usecase.RegisterBuyer;
import com.masai.usecase.RegisterSeller;
import com.masai.usecase.SellerByCategory;
import com.masai.usecase.SoldHistory;
import com.masai.usecase.UpdateProduct;
import com.masai.usecase.ViewItemBycategory;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Welcome to Automated Auction System");
		
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("a. Administrator");
		System.out.println("b. Seller");
		System.out.println("c. Buyer");
		System.out.println("d. Exit");
		
		System.out.println("Enter Choice");
		String s = sc.next();
	
		switch (s) {

			case "a":

			
			System.out.println("Enter Username");
			String login = sc.next();
			
			System.out.println("Enter Admin Password");
			String pass = sc.next();
			
			if(login.equals("Admin") && pass.equals("Admin@1234")) 
			{
				System.out.println("1. View Buyer List");
				System.out.println("2. View Seller List");
				System.out.println("3. Exit");
				
				System.out.println("Enter Choice");
				int c3 = sc.nextInt();
				
				if(c3==1) {
					new GetBuyerUseCase1();
					GetBuyerUseCase1.main(args);
				} else if(c3==2) {
					new GetSellerUseCase1();
					GetSellerUseCase1.main(args);
				} else
					return;
			}
			else{
				System.out.println("Invalid usename or password");
			}
			break;
		
		case "b":
			System.out.println("1. Register as seller.");
			System.out.println("2. Create list of items to sell.");
			System.out.println("3. Update Item price, quantity, etc.");
			System.out.println("4. Add new Item in the list.");
			System.out.println("5. View the sold Item history.");
			System.out.println("6. Remove items from the list.");

			
			System.out.println("Enter Choice");
			int c4 = sc.nextInt();
			
			if(c4==1) {
				new RegisterSeller();
				RegisterSeller.main(args);
			} else if(c4==2) {
				new ProductList();
				ProductList.main(args);
			} else if(c4==3) {
				new UpdateProduct();
				UpdateProduct.main(args);
			} else if(c4==4) {
				new AddProduct();
				AddProduct.main(args);
			} else if(c4==5) {
				new SoldHistory();
				SoldHistory.main(args);
			} else if(c4 == 6) {
				new DeleteProduct();
				DeleteProduct.main(args);
			} else
				return;
		break;
		case "c":
			System.out.println("1. Register as Buyer.");
			System.out.println("2. Search and view Items by category.");
			System.out.println("3. Select and view all the seller and also their Items category wise.");
			System.out.println("4. Selects Items to buy.");
			
			System.out.println("Enter Choice");
			int c5 = sc.nextInt();
			
			if(c5==1) {
				new RegisterBuyer();
				RegisterBuyer.main(args);
			} else if(c5==2) {
				new ViewItemBycategory();
				ViewItemBycategory.main(args);
			} else if(c5==3) {
				new SellerByCategory();
				SellerByCategory.main(args);
			} else if(c5==4) {
				new BuyItem();
				BuyItem.main(args);
			} else 
				return;
			
	    	break;
		
		    default:
		         System.out.println("Invalid optio....Please select correct option");
		
	

        }
		
	// }		
	// if(s=="d")  System.out.println("Invalid option....Please select correct option");

    System.out.println("Thank You!...");
  
}
}
