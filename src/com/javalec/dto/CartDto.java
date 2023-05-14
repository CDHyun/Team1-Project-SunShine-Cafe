package com.javalec.dto;


public class CartDto {

	/*** Field ***/
	/* category */
	int categoryNo;
	String categoryName;
	
	/* cart */
	int cartNo;
	int cartQty;
	int cartOptionPrice;
	
	
	/* item */
	int itemNo;
	String itemName;
	int itemPrice;
	String itemInsertDate;
	String itemImageName;
	boolean itemStatus;
	String itemContent;
	
	/* user */
	String userid;
	boolean userSecessionStatus;
	
	
	/* Constructor */
	public CartDto() {
		// TODO Auto-generated constructor stub
	}
	
	public CartDto(int cartNo, int cartQty, int cartOptionPrice, int itemNo, String itemName) {
		super();
		this.cartNo = cartNo;
		this.cartQty = cartQty;
		this.cartOptionPrice = cartOptionPrice;
		this.itemNo = itemNo;
		this.itemName = itemName;
	}

	/* 카트 리스트에 정보를 가져올 생성자 */
	public CartDto(int cartNo, int cartQty, int itemNo, String itemName, int itemPrice) {
		super();
		this.cartNo = cartNo;
		this.cartQty = cartQty;
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
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

	public int getCartNo() {
		return cartNo;
	}

	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}

	public int getCartQty() {
		return cartQty;
	}

	public void setCartQty(int cartQty) {
		this.cartQty = cartQty;
	}

	public int getCartOptionPrice() {
		return cartOptionPrice;
	}

	public void setCartOptionPrice(int cartOptionPrice) {
		this.cartOptionPrice = cartOptionPrice;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemInsertDate() {
		return itemInsertDate;
	}

	public void setItemInsertDate(String itemInsertDate) {
		this.itemInsertDate = itemInsertDate;
	}

	public String getItemImageName() {
		return itemImageName;
	}

	public void setItemImageName(String itemImageName) {
		this.itemImageName = itemImageName;
	}

	public boolean isItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(boolean itemStatus) {
		this.itemStatus = itemStatus;
	}

	public String getItemContent() {
		return itemContent;
	}

	public void setItemContent(String itemContent) {
		this.itemContent = itemContent;
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
	
	
	
	
	



	

	
	
	
	
}
