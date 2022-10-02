package com.masai.bean;

public class SellingList {
     private int itemId;
     private String product;
     private int price;
     private int quantity;
     private int sellingId;
     private String status;
	
	public SellingList(int itemId, String product, int price, int quantity, int sellingId, String status) {
		this.itemId = itemId;
		this.product = product;
		this.price = price;
		this.quantity = quantity;
		this.sellingId = sellingId;
		this.status = status;
	}
	
	public SellingList() {
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSellingId() {
		return sellingId;
	}
	public void setSellingId(int sellingId) {
		this.sellingId = sellingId;
	}
	@Override
	public String toString() {
		return "SellingList [itemId=" + itemId + ", product=" + product + ", price=" + price + ", quantity=" + quantity
				+  ", sellingId=" + sellingId + ", status=" + status + "]";
	}
	
	
	
	
}
