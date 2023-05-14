package com.javalec.dto;

public class AdminLoginDto {
	int adminId;
	String adminPassword;
	
	public AdminLoginDto() {
		// TODO Auto-generated constructor stub
	}

	
	// 관리자가 로그인할 때 필요한 아이디와 패스워드 받아오는 생성자 
	public AdminLoginDto(int adminId, String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminPassword = adminPassword;
	}


	public int getAdminId() {
		return adminId;
	}


	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}


	public String getAdminPassword() {
		return adminPassword;
	}


	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	

}
