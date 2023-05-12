package com.javalec.dto;

import java.io.FileInputStream;



public class AdminMenuDto {

	int categoryNo;					// 카테고리 프키
	int drinkNo;					// 음료 프키
	int dessertNo;					// 디저트 프키
	String categoryName;			// 카테고리네임
	String drinkName;				// 음료네임
	String dessertName;				// 디저트네임
	int drinkPrice;					// 음료가격
	int dessertPrice;				// 디저트가격
	int drinkStatus;				// 음료 판매여부
	int dessertStatus;				// 디저트 판매여부
	int dessertStock;					// 디저트 수량
	String drinkImageName;			// 음료 사진 이름
	FileInputStream drinkImage;		// 음료 사진
	String dessertImageName;		// 디저트 사진 이름
	FileInputStream dessertImage;	// 디저트 사진
	
	// 음료 데이터 생성자
	
	
	public AdminMenuDto(String drinkName, int drinkPrice, String categoryName, 
			int drinkStatus) {
		super();

		this.categoryName = categoryName;
		this.drinkName = drinkName;
		this.drinkPrice = drinkPrice;
		this.drinkStatus = drinkStatus;
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
	
	
	
	
	// 카테고리 데이터 생성자
	
	public AdminMenuDto(int categoryNo, String categoryName) {
		super();
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
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
	
	
}
