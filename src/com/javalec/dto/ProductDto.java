package com.javalec.dto;


public class ProductDto {

	
	/*** Field ***/
	/* category */
	int categoryNo;
	String categoryName;
	
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
	
	
	/*** Constructor ***/
	public ProductDto() {
		// TODO Auto-generated constructor stub
	}

	public ProductDto(int itemNo, String itemName, int itemPrice, String itemImageName, int categoryNo) {
		super();
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemImageName = itemImageName;
		this.categoryNo = categoryNo;
	}
	
	/* 음료(디저트) 리스트를 띄우기 위한 생성자 */
	public ProductDto(int categoryNo, int itemNo, String itemName, int itemPrice, String itemImageName) {
		super();
		this.categoryNo = categoryNo;
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemImageName = itemImageName;
	}

	/* 음료(디저트) 상세 페이지를 띄우기 위한 생성자 */
	public ProductDto(String itemName, int itemPrice, String itemImageName, String itemContent) {
		super();
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemImageName = itemImageName;
		this.itemContent = itemContent;
	}
	
	/* Cart 역할을 해주는 생성자 */
	public ProductDto(int itemNo, String itemName, int itemPrice) {
		super();
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}

	
	/*** getter&setter ***/
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



	
	
	

	
	
	
	
	
}	// End Class
