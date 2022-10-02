package com.masai.bean;

public class SellingList {
     private int itemId;
     private String property;
     private int price;
     private int quntity;
     private int sellingId;
     private String status;
	
	public SellingList(int itemId, String property, int price, int quntity, int sellingId, String status) {
		this.itemId = itemId;
		this.property = property;
		this.price = price;
		this.quntity = quntity;
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
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuntity() {
		return quntity;
	}
	public void setQuntity(int quntity) {
		this.quntity = quntity;
	}

	public int getSellingId() {
		return sellingId;
	}
	public void setSellingId(int sellingId) {
		this.sellingId = sellingId;
	}
	@Override
	public String toString() {
		return "SellingList [itemId=" + itemId + ", property=" + property + ", price=" + price + ", quntity=" + quntity
				+  ", sellingId=" + sellingId + ", status=" + status + "]";
	}
	
	
	
	
}
