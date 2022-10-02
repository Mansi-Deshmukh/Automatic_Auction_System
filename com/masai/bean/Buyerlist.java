package com.masai.bean;

public class Buyerlist {
  private int bid;
  private String name;
  private String email;
  private String product;
  private int price;
  
public Buyerlist(int bid, String name, String email, String product, int price) {
	super();
	this.bid = bid;
	this.name = name;
	this.email = email;
	this.product = product;
	this.price=price;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public Buyerlist() {
	
}

public int getBid() {
	return bid;
}


public void setBid(int bid) {
	this.bid = bid;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getProduct() {
	return product;
}


public void setProduct(String product) {
	this.product = product;
}

@Override
public String toString() {
	return "Buyerlist [bid=" + bid + ", name=" + name + ", email=" + email + ", product=" + product + ", price="
			+ price + "]";
}



  
  
  
  
}

