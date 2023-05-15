package com.javalec.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class AdminCalculateDto {
	
	// 구매 내역을 불러오기 위한 생성자들 
	// salesNo, purchaseInsertDate, purchasePrice, itemName, userName
	
	// Field 
	private int salesNo;
	private String purchaseInsertDate;
	private int purchasePrice;
	private String itemName; 		// 사용자가 주문한 상품들을 한번에 보여주기 위한 아이템 리스트
	private String userName;
	private String userid;
 	
	
	// Constructor
	public AdminCalculateDto() {
		// TODO Auto-generated constructor stub
	}

	public AdminCalculateDto(int salesNo, String wkPurchaseDate, int purchasePrice, String itemName, String userName, String userid) {
		super();
		this.salesNo = salesNo;
		this.purchaseInsertDate = wkPurchaseDate;
		this.purchasePrice = purchasePrice;
		this.itemName = itemName;
		this.userName = userName;
		this.userid = userid;
	}


	public int getSalesNo() {
		return salesNo;
	}


	public void setSalesNo(int salesNo) {
		this.salesNo = salesNo;
	}


	public String getPurchaseInsertDate() {
		return purchaseInsertDate;
	}


	public void setPurchaseInsertDate(String purchaseInsertDate) {
		this.purchaseInsertDate = purchaseInsertDate;
	}


	public int getPurchasePrice() {
		return purchasePrice;
	}


	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
	
	
	

}
