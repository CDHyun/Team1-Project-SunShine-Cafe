package com.javalec.dto;

public class StudyUserDto {

	// 유저
	String userid;
	
	// 스터디룸 
	int itemNo;
	int itemPrice;
	String tableNo;
	String itemName;
	String imageName;
	
	// 
	int categoryNo;
	String categoryName;
	
	public StudyUserDto() {
		// TODO Auto-generated constructor stub
	}

	
	
	public StudyUserDto(int itemNo, int itemPrice, String itemName, int categoryNo, String imageName) {
		super();
		this.categoryNo = categoryNo;
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.imageName = imageName;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getTableNo() {
		return tableNo;
	}

	public void setTableNo(String tableNo) {
		this.tableNo = tableNo;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
}
