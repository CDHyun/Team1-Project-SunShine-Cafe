package com.javalec.dto;

public class AdminCalculateDto {

	// Constructor
	int purchaseNo;
	String LocalDateTime ; 		// 사용자가 구매한 일시 
	int price ; 		// 사용자 구매 총 금액
	String productName;
	int userId; 
	
	public AdminCalculateDto() {
		// TODO Auto-generated constructor stub
	}

	// Dao에게 초기 tableInit() 정보 전달받아 메인에 주기위한 생성자
	public AdminCalculateDto(int purchaseNo, String localDateTime, int price, String productName, int userId) {
		super();
		this.purchaseNo = purchaseNo;
		LocalDateTime = localDateTime;
		this.price = price;
		this.productName = productName;
		this.userId = userId;
	}

	public int getPurchaseNo() {
		return purchaseNo;
	}

	public void setPurchaseNo(int purchaseNo) {
		this.purchaseNo = purchaseNo;
	}

	public String getLocalDateTime() {
		return LocalDateTime;
	}

	public void setLocalDateTime(String localDateTime) {
		LocalDateTime = localDateTime;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	
	
	
}
