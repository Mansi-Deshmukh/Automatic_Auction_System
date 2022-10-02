package com.masai.bean;

public class Buyer {

	private int bId;
	private String name;
	private String email;
	private String password;
	public Buyer(String name, String email, String password) {
		
		this.name = name;
		this.email = email;
		this.password = password;
	}
    public Buyer() {
		
	}
	public int getsId() {
		return bId;
	}
	public void setsId(int bId) {
		this.bId = bId;
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
		return "Buyer [bId=" + bId + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
	
	
	
	
	
	
}
