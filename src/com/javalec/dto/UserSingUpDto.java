package com.javalec.dto;

public class UserSingUpDto {
	
	
	// Field
	
	String name;
	String password;
	String phone;
	
	
	// Constructor
	public UserSingUpDto() {
		// TODO Auto-generated constructor stub
	}


	public UserSingUpDto(String name, String password, String phone) {
		super();
		this.name = name;
		this.password = password;
		this.phone = phone;
	}

	
	// Method
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
	
	
	
	

}// End
