package com.javalec.dto;


public class ProductDto {

	
	/*** Field ***/
	/* category */
	int categoryNo;
	String categoryName;
	
	/* dessert */
	int dessertNo;
	String dessertNane;
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
	
	
	/*** Constructor ***/
	public ProductDto() {
		// TODO Auto-generated constructor stub
	}

	public ProductDto(int drinkNo, String drinkName, int drinkPrice, String drinkImageName) {
		super();
		this.drinkNo = drinkNo;
		this.drinkName = drinkName;
		this.drinkPrice = drinkPrice;
		this.drinkImageName = drinkImageName;
	}
	
	/* 음료(디저트) 리스트를 띄우기 위한 생성자 */
	public ProductDto(int categoryNo, int drinkNo, String drinkName, int drinkPrice, String drinkImageName) {
		super();
		this.categoryNo = categoryNo;
		this.drinkNo = drinkNo;
		this.drinkName = drinkName;
		this.drinkPrice = drinkPrice;
		this.drinkImageName = drinkImageName;
	}

	/* 음료(디저트) 상세 페이지를 띄우기 위한 생성자 */
	public ProductDto(String drinkName, int drinkPrice, String drinkImageName,
			String drinkContent) {
		super();
		this.drinkName = drinkName;
		this.drinkPrice = drinkPrice;
		this.drinkImageName = drinkImageName;
		this.drinkContent = drinkContent;
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


	public int getDessertNo() {
		return dessertNo;
	}


	public void setDessertNo(int dessertNo) {
		this.dessertNo = dessertNo;
	}


	public String getDessertNane() {
		return dessertNane;
	}


	public void setDessertNane(String dessertNane) {
		this.dessertNane = dessertNane;
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

	public String getDessertContent() {
		return dessertContent;
	}

	public void setDessertContent(String dessertContent) {
		this.dessertContent = dessertContent;
	}

	public String getDrinkContent() {
		return drinkContent;
	}

	public void setDrinkContent(String drinkContent) {
		this.drinkContent = drinkContent;
	}
	
	
	

	
	
	
	
	
}	// End Class
