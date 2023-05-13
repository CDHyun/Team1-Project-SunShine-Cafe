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
	
	
	/* dessert */
	int dessertNo;
	String dessertName;
	int dessertStock;
	int dessertPrice;
	String dessertInsertDate;
	String dessertImageName;
	boolean dessertStatus;
	String dessertContent;
	
	/* drink */
	int drinkNo;
	String drinkName;
	int drinkPrice;
	String drinkInsertDate;
	String drinkImageName;
	boolean drinkStatus;
	String drinkContent;
	
	/* user */
	String userid;
	boolean userSecessionStatus;
	
	int wkItemNo;
	String wkItemName;
	int wkPrice;
	
	/* Constructor */
	public CartDto() {
		// TODO Auto-generated constructor stub
	}
	
	public CartDto(int wkItemNo, String wkItemName, int wkPrice) {
		super();
		this.wkItemNo = wkItemNo;
		this.wkItemName = wkItemName;
		this.wkPrice = wkPrice;
	}
	
	public CartDto(int cartNo, int cartQty, int drinkNo, String drinkName, int cartOptionPrice) {
		super();
		this.cartNo = cartNo;
		this.cartQty = cartQty;
		this.drinkNo = drinkNo;
		this.drinkName = drinkName;
		this.cartOptionPrice = cartOptionPrice;
	}

	/* 카트 리스트에 정보를 가져올 생성자 */
	public CartDto(int cartNo, int cartQty, int dessertNo, String dessertName, int dessertPrice, int drinkNo,
			String drinkName, int drinkPrice) {
		super();
		this.cartNo = cartNo;
		this.cartQty = cartQty;
		this.dessertNo = dessertNo;
		this.dessertName = dessertName;
		this.dessertPrice = dessertPrice;
		this.drinkNo = drinkNo;
		this.drinkName = drinkName;
		this.drinkPrice = drinkPrice;
	}
	
	
	
	
	
	/* getter & setter */
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


	public int getDessertNo() {
		return dessertNo;
	}


	public void setDessertNo(int dessertNo) {
		this.dessertNo = dessertNo;
	}

	public String getDessertName() {
		return dessertName;
	}


	public void setDessertName(String dessertName) {
		this.dessertName = dessertName;
	}


	public int getDessertStock() {
		return dessertStock;
	}

	public void setDessertStock(int dessertStock) {
		this.dessertStock = dessertStock;
	}


	public int getDessertPrice() {
		return dessertPrice;
	}


	public void setDessertPrice(int dessertPrice) {
		this.dessertPrice = dessertPrice;
	}


	public String getDessertInsertDate() {
		return dessertInsertDate;
	}


	public void setDessertInsertDate(String dessertInsertDate) {
		this.dessertInsertDate = dessertInsertDate;
	}


	public String getDessertImageName() {
		return dessertImageName;
	}


	public void setDessertImageName(String dessertImageName) {
		this.dessertImageName = dessertImageName;
	}


	public boolean isDessertStatus() {
		return dessertStatus;
	}


	public void setDessertStatus(boolean dessertStatus) {
		this.dessertStatus = dessertStatus;
	}


	public String getDessertContent() {
		return dessertContent;
	}


	public void setDessertContent(String dessertContent) {
		this.dessertContent = dessertContent;
	}


	public int getDrinkNo() {
		return drinkNo;
	}


	public void setDrinkNo(int drinkNo) {
		this.drinkNo = drinkNo;
	}


	public String getDrinkName() {
		return drinkName;
	}


	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}


	public int getDrinkPrice() {
		return drinkPrice;
	}


	public void setDrinkPrice(int drinkPrice) {
		this.drinkPrice = drinkPrice;
	}


	public String getDrinkInsertDate() {
		return drinkInsertDate;
	}


	public void setDrinkInsertDate(String drinkInsertDate) {
		this.drinkInsertDate = drinkInsertDate;
	}


	public String getDrinkImageName() {
		return drinkImageName;
	}


	public void setDrinkImageName(String drinkImageName) {
		this.drinkImageName = drinkImageName;
	}


	public boolean isDrinkStatus() {
		return drinkStatus;
	}


	public void setDrinkStatus(boolean drinkStatus) {
		this.drinkStatus = drinkStatus;
	}


	public String getDrinkContent() {
		return drinkContent;
	}


	public void setDrinkContent(String drinkContent) {
		this.drinkContent = drinkContent;
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

	public int getWkItemNo() {
		return wkItemNo;
	}

	public void setWkItemNo(int wkItemNo) {
		this.wkItemNo = wkItemNo;
	}

	public String getWkItemName() {
		return wkItemName;
	}

	public void setWkItemName(String wkItemName) {
		this.wkItemName = wkItemName;
	}

	public int getWkPrice() {
		return wkPrice;
	}

	public void setWkPrice(int wkPrice) {
		this.wkPrice = wkPrice;
	}



	

	
	
	
	
}
