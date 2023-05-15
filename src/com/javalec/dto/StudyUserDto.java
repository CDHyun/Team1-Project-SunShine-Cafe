
package com.javalec.dto;

import java.io.FileInputStream;

public class StudyUserDto {

	
	
	
	
	// 유저
	String userid;
	boolean userSecessionStatus;
	
	// 스터디룸 
	int itemNo;
	int purchaseNo;
	int itemPrice;
	int purchasePrice;
	boolean itemStatus;
	String itemName;
	String itemImageName;
	String itemInsertDate;
	String itemContent;
	
	
	FileInputStream imageName;

	// 
	int categoryNo;
	String categoryName;
	int cartQty;
	
	public StudyUserDto() {
		// TODO Auto-generated constructor stub
	}

	
	

	public StudyUserDto(String itemName, String itemImageName, int purchasePrice ) {
		super();
		this.purchasePrice = purchasePrice;
		this.itemName = itemName;
		this.itemImageName = itemImageName ;
	}







	public StudyUserDto(int itemNo, int itemPrice, String itemName, String itemImageName, int categoryNo) {
		super();
		this.itemNo = itemNo;
		this.itemPrice = itemPrice;
		this.itemName = itemName;
		this.itemImageName = itemImageName;
		this.categoryNo = categoryNo;
	}


	




	public StudyUserDto(String itemName, int categoryNo, int cartQty) {
		super();
		this.itemName = itemName;
		this.categoryNo = categoryNo;
		this.cartQty = cartQty;
	}



	public StudyUserDto(int itemPrice, String itemImageName) {
		super();
		this.itemPrice = itemPrice;
		this.itemImageName = itemImageName;
	}



	public String getUserid() {
		return userid;
	}



	public void setUserid(String userid) {
		this.userid = userid;
	}



	public boolean isUserSecessionStatus() {
		return userSecessionStatus;
	}



	public void setUserSecessionStatus(boolean userSecessionStatus) {
		this.userSecessionStatus = userSecessionStatus;
	}



	public int getItemNo() {
		return itemNo;
	}



	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}



	public int getPurchaseNo() {
		return purchaseNo;
	}



	public void setPurchaseNo(int purchaseNo) {
		this.purchaseNo = purchaseNo;
	}



	public int getItemPrice() {
		return itemPrice;
	}



	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}



	public int getPurchasePrice() {
		return purchasePrice;
	}



	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}



	public boolean isItemStatus() {
		return itemStatus;
	}



	public void setItemStatus(boolean itemStatus) {
		this.itemStatus = itemStatus;
	}



	public String getItemName() {
		return itemName;
	}



	public void setItemName(String itemName) {
		this.itemName = itemName;
	}







	public String getItemImageName() {
		return itemImageName;
	}



	public void setItemImageName(String itemImageName) {
		this.itemImageName = itemImageName;
	}



	public String getItemInsertDate() {
		return itemInsertDate;
	}



	public void setItemInsertDate(String itemInsertDate) {
		this.itemInsertDate = itemInsertDate;
	}



	public String getItemContent() {
		return itemContent;
	}



	public void setItemContent(String itemContent) {
		this.itemContent = itemContent;
	}



	public int getCategoryNo() {
		return categoryNo;
	}



	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}



	public String getCategoryName() {
		return categoryName;
	}



	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}



	public int getCartQty() {
		return cartQty;
	}



	public void setCartQty(int cartQty) {
		this.cartQty = cartQty;
	}

	
}

