package com.javalec.dto;

import java.io.FileInputStream;



public class AdminMenuDto {

	int itemNo;
	int categoryNo;					// 카테고리 프키
	int drinkNo;					// 음료 프키
	int dessertNo;					// 디저트 프키
	String drinkName;				// 음료네임
	String dessertName;				// 디저트네임
	int drinkPrice;					// 음료가격
	int dessertPrice;				// 디저트가격
	int drinkStatus;				// 음료 판매여부
	int dessertStatus;				// 디저트 판매여부
	int dessertStock;				// 디저트 수량
	String drinkImageName;			// 음료 사진 이름
	FileInputStream drinkImage;		// 음료 사진
	String dessertImageName;		// 디저트 사진 이름
	FileInputStream dessertImage;	// 디저트 사진
	String drinkContent;			// 음료 상품상세
	String dessertContent;			// 디저트 상품상세
	
	String menuName;
	int menuPrice;
	String categoryName;			// 카테고리네임
	int menuStatus;
	
	
	
	
	
	
	// 메뉴 화면 데이터
	public AdminMenuDto(int itemNo, String menuName, int menuPrice, String categoryName, int menuStatus) {
		super();
		this.itemNo = itemNo;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.categoryName = categoryName;
		this.menuStatus = menuStatus;
	}
	
	public AdminMenuDto(String menuName, int menuPrice, String categoryName, int menuStatus) {
		super();
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.categoryName = categoryName;
		this.menuStatus = menuStatus;
	}
	
	
	
	// 디저트 데이터 생성자
	
	public AdminMenuDto(String dessertName, int dessertStock, int dessertPrice , String categoryName,  int dessertStatus) {
		super();
		this.categoryName = categoryName;
		this.dessertName = dessertName;
		this.dessertPrice = dessertPrice;
		this.dessertStatus = dessertStatus;
		this.dessertStock = dessertStock;
	}
	
	
	
	// 카테고리 콤보박스 데이터	
	
	public AdminMenuDto(String categoryName) {
		super();
		this.categoryName = categoryName;
	}

	// 카테고리 데이터 생성자


	public AdminMenuDto(int categoryNo, String categoryName) {
		super();
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
	}
	
	
	// 음료 table 데이터 가져오기
	public AdminMenuDto(int drinkNo, String drinkName, int drinkPrice, String categoryName,  
			String drinkImageName, int drinkStatus, String drinkContent) {
		super();
		this.drinkNo = drinkNo;
		this.categoryName = categoryName;
		this.drinkName = drinkName;
		this.drinkPrice = drinkPrice;
		this.drinkStatus = drinkStatus;
		this.drinkImageName = drinkImageName;
		this.drinkContent = drinkContent;

	}

		
	// 디저트 table 데이터 가져오기
	
	public AdminMenuDto(int dessertNo, String dessertName, int dessertStock, int dessertPrice, String categoryName,
			 String dessertImageName, int dessertStatus , String dessertContent) {
		super();
		this.dessertNo = dessertNo;
		this.categoryName = categoryName;
		this.dessertName = dessertName;
		this.dessertPrice = dessertPrice;
		this.dessertStatus = dessertStatus;
		this.dessertStock = dessertStock;
		this.dessertImageName = dessertImageName;
		this.dessertContent = dessertContent;
	}


	
	
	
	
	
	
	
	
	

	public String getMenuName() {
		return menuName;
	}



	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}



	public int getMenuPrice() {
		return menuPrice;
	}



	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}



	public int getMenuStatus() {
		return menuStatus;
	}



	public void setMenuStatus(int menuStatus) {
		this.menuStatus = menuStatus;
	}



	public String getDrinkContent() {
		return drinkContent;
	}



	public void setDrinkContent(String drinkContent) {
		this.drinkContent = drinkContent;
	}



	public String getDessertContent() {
		return dessertContent;
	}



	public void setDessertContent(String dessertContent) {
		this.dessertContent = dessertContent;
	}



	public int getDessertStock() {
		return dessertStock;
	}
	
	


	public void setDessertStock(int dessertStock) {
		this.dessertStock = dessertStock;
	}
	
	public int getCategoryNo() {
		return categoryNo;
	}


	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}


	public int getDrinkNo() {
		return drinkNo;
	}


	public void setDrinkNo(int drinkNo) {
		this.drinkNo = drinkNo;
	}




	public int getDessertNo() {
		return dessertNo;
	}



	public void setDessertNo(int dessertNo) {
		this.dessertNo = dessertNo;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public String getDrinkName() {
		return drinkName;
	}


	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}


	public String getDessertName() {
		return dessertName;
	}


	public void setDessertName(String dessertName) {
		this.dessertName = dessertName;
	}


	public int getDrinkPrice() {
		return drinkPrice;
	}


	public void setDrinkPrice(int drinkPrice) {
		this.drinkPrice = drinkPrice;
	}


	public int getDessertPrice() {
		return dessertPrice;
	}


	public void setDessertPrice(int dessertPrice) {
		this.dessertPrice = dessertPrice;
	}


	public int getDrinkStatus() {
		return drinkStatus;
	}


	public void setDrinkStatus(int drinkStatus) {
		this.drinkStatus = drinkStatus;
	}


	public int getDessertStatus() {
		return dessertStatus;
	}


	public void setDessertStatus(int dessertStatus) {
		this.dessertStatus = dessertStatus;
	}


	public String getDrinkImageName() {
		return drinkImageName;
	}


	public void setDrinkImageName(String drinkImageName) {
		this.drinkImageName = drinkImageName;
	}


	public FileInputStream getDrinkImage() {
		return drinkImage;
	}


	public void setDrinkImage(FileInputStream drinkImage) {
		this.drinkImage = drinkImage;
	}


	public String getDessertImageName() {
		return dessertImageName;
	}


	public void setDessertImageName(String dessertImageName) {
		this.dessertImageName = dessertImageName;
	}


	public FileInputStream getDessertImage() {
		return dessertImage;
	}


	public void setDessertImage(FileInputStream dessertImage) {
		this.dessertImage = dessertImage;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	
	
	
	
	
}
