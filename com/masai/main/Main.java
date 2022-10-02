package com.masai.main;

import java.util.Scanner;

public class Main {
	static Scanner sc=new Scanner(System.in);
	static AdminPage ap= new AdminPage();
	static SellerRegister se= new SellerRegister();
	static BuyerRegister bd= new BuyerRegister();
    public static void printResults() {
    	System.out.println("SELECT FROM THE FOLLOWING OPTIONs");
        System.out.println("Enter 1 :- For Admin Page ");
        System.out.println("Enter 2 :- For Seller Page ");
        System.out.println("Enter 3 :- For Buyer Page ");
         
        int No=sc.nextInt();
        switch(No) {
        case 1:
        	    
        	    System.out.println("Admin Login");
        	    System.out.println("Enter Admin Username");
        	    String username=sc.next();
        	    System.out.println("Enter Password");
        	   String password=sc.next();
        	   
        	    if(username.equals("Admin")&&password.equals("012345")) 
        	    {
	        	System.out.println("Welcome.. Admin...");
	                System.out.println("Enter 1 for View the registered Seller list");
					System.out.println("Enter 2 for View the registered buyer list ");
	                System.out.println("Enter 3 for see daily dispute report");
	                System.out.println("Enter 4 for see daily selling report");
	                System.out.println("Enter 5 to solve dispute");
	                 int aNo=sc.nextInt();
		                switch(aNo) 
		                {
		                    case 1:  ap.showSellerList();
							         printResults();
							         break;
			                 
						    case 2:  ap.showBuyerList(); 
									 printResults();
									 break;
			                case 3:  ap.viewDisputeReport();
			                          printResults();
			                          break;
			                case 4:  ap.viewsellingReport();
			                            printResults();
			                            break;
			                case 5:  System.out.println("Write name of person whose dispute will be solved");
			                           String nd= sc.next();
			                           ap.solvedispute(nd);
			                           printResults();
			                           break;
			                 default: printResults();
			                          break;
		                }
                  
        	    }else{
        	    	System.out.println("OOPss!.....WRONG PASSWORD ENTERED");
        	    	
        	    }
        	    printResults();
        	    break;
        case 2:
        	     System.out.println("Chosee options From the following");
        	     System.out.println("Enter 1 For Register Seller");
        		System.out.println("Enter 2 for Add Item on the Selling List");
        		System.out.println("Enter 3 for Update Item on the Selling List"); 
        		System.out.println("Enter 4 for Delete Item on the Selling List"); 
        		System.out.println("Enter 5 for View sold Item on the Selling List"); 
        		System.out.println("Enter 6 for Create a issue of dispute"); 
        	       int sNo=sc.nextInt();
        	      switch(sNo) {
        	      case 1:
	        	    	    System.out.println("Enter name of Seller");
			              	String n=sc.next();
			            	System.out.println("Enter email ");
			            	String e=sc.next();
			            	System.out.println("Enter password");
			            	String p=sc.next();
			            	
			            	se.registerSeller(n, e, p);
			            	
			            	printResults();
			            	break;
        	      case 2:
        	    	       boolean a=true;
        	    	        while(a){
        	    	        	System.out.println("Enter your sellerId");
            	    	        int sId=sc.nextInt();
            	    	        System.out.println("Enter your itemId");
            	    	        int iId=sc.nextInt();
            	    	        System.out.println("Enter your product");
            	    	        String prod=sc.next();
            	    	        
            	    	        System.out.println("Price of product");
            	    	        int price=sc.nextInt();
            	    	        System.out.println("Quntity of product");
            	    	        int quntity=sc.nextInt();
            	    	      
            	    	        
            	    	        se.itemRegister(sId, iId,prod, price, quntity);
            	    	        
            	    	        boolean f=true;
            	    	        while(f) {
            	    	        	System.out.println("Want to ADD more product? Press 1" + "For Exit Press 0");
                	    	        int s=sc.nextInt();
                	    	        if(s==0) {
                	    	        	a=false;
                	    	        	f=false;
                	    	        }else if(s==1) {
                	    	        	a=true;
                	    	        	f=false;
                	    	        }else {
                	    	        	System.out.println("Sorry Wrong Input.........!" + "Try Again........!");
                	    	        	f=true;
                	    	        }
            	    	        }
        	    	        }
        	    	        printResults();
        	    	        break;
        	    	        
        	      case 3: 
        	    	       boolean b=true;
                            while(b) {
                              System.out.println("Enter the product");
               	              String pro=sc.next();
               	              System.out.println("Enter the price");
               	              int pri=sc.nextInt();
               	              System.out.println("Enter the quantity");
               	              int pr=sc.nextInt();
               	              System.out.println("Enter item id you want to update");
               	              int id=sc.nextInt();
               	              se.updateItem(pro, pri, pr, id);
               	             System.out.println("Update more ?   Enter 1 for Yes....0 Exit");
               	             int chck=sc.nextInt();
               	             if(chck==1) {
               	            	 b=true;
               	             }else b=false;
                            }
        	             printResults();
        	              break;
        	      case 4:
        	    	 boolean c=true;
        	    	  while(c) {
        	    		  System.out.println("Enter the Item id to delete from selling list");
        	    	      int cNO=sc.nextInt();
        	    	      se.removeItem(cNO);
        	    	      
        	    	      System.out.println("Delete more? " + "Enter 1 for yes" + "Press 0 for exit");
        	    	      int nc=sc.nextInt();
        	    	      if(nc!=1) {
        	    	    	 c=false;
        	    	      }else {
        	    	    	  c=true;
        	    	      }
        	    	     
        	    	      
        	    	  }
        	    	  printResults();
        	    	  break;
        	          
        	       case 5: 
        	        	 System.out.println("Total item sold");
        	        	   se.showSoldItem();
        	        	   printResults();
        	        	   break;
        	       case 6: 
        	    	        System.out.println("Enter your name");
			      	        String na=sc.next();
			      	        System.out.println("Enter your issue");
			      	        String iss= sc.next();
			      	          bd.createDispute(na, iss);
			      	        		 printResults();
      	                    break; 	   
        	    default:System.out.println("Please choose correct option....!");
        	    	    printResults();
        	            break;
        	      }
        	
        	
        	
        case 3:
        	System.out.println("Enter 1 for Regiester Buyer");
        	System.out.println("Enter 2 for view the buying list by category");
        	System.out.println("Enter 3 for Purchase the item");
        	System.out.println("Enter 4 for show Buyer list with item");
        	System.out.println("Enter 5 for Create a issue of dispute"); 
        	int bNo=sc.nextInt();
        	switch(bNo) {
        	 case 1:
        		    System.out.println("Enter name of Buyer");
		 	    	String name=sc.next();
		 	    	System.out.println("Enter email ");
		 	    	String email=sc.next();
		 	    	System.out.println("Enter password");
		 	    	String pass=sc.next();
		 	    	
		 	    	bd.registerBuyer(name, email, pass);
		 	    	break;
        	 case 2: System.out.println("Enter the product");
        	          String cate=sc.next();
        	          
        	          bd.showList(cate);
        	          printResults();
        	          break;
        	 case 3: System.out.println("Enter the Buyer id");
        	         int byid=sc.nextInt();
        	         System.out.println("Enter the item id");
        	         int Itid=sc.nextInt();
        	         bd.buyItem(byid, Itid);
        	         printResults();
        	         break;
        	 case 4: bd.showbuyers();
        	          printResults();
        	          break;
        		 
        	 case 5: System.out.println("Enter your name");
        	         String na=sc.next();
        	         System.out.println("Enter your issue");
        	         String iss= sc.next();
        	        		 bd.createDispute(na, iss);
        	        		 printResults();
        	        break;		 
        	 default: System.out.println("Please choose correct option....!");
        		      printResults();
        	           break;
        	}
                  
        	
	    	        break;
         default: System.out.println("Invalid option !....You need to choose correct option...");
                   break;
                   
         
        
        }
 
        
        }
       
        
        
   
	public static void main(String[] args) {
		System.out.println("****************************************");
		System.out.println("Welcome to Automated Auction System System !!");
		System.out.println("****************************************");
        printResults();
	
		System.out.println("Thank you...");

	}
}


