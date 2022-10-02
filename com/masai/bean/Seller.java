package com.masai.bean;

public class Seller {

	private int sId;
	private String name;
	private String email;
	private String password;
	
	public Seller(String name, String email, String password) {
		
		this.name = name;
		this.email = email;
		this.password = password;
	}
    public Seller( int sid,String name, String email, String password) {
		this.sId=sid;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	

	public Seller() {
		
		
	}


	public int getsId() {
		return sId;
	}


	public void setsId(int sId) {
		this.sId = sId;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Seller [sId=" + sId + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
	
	
	
	
}
