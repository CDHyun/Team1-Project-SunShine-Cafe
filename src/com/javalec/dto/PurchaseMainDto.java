package com.javalec.dto;

public class PurchaseMainDto {

	int cartNo;
	String drinkName;
	String dessertName;
	int cartQty;
	int cartOptionPrice;
	

	
	public PurchaseMainDto() {
		// TODO Auto-generated constructor stub
	}


	// 카트 데이터 가져오기
	public PurchaseMainDto(String drinkName, String dessertName, int cartQty, int cartOptionPrice) {
		super();
		this.drinkName = drinkName;
		this.dessertName = dessertName;
		this.cartQty = cartQty;
		this.cartOptionPrice = cartOptionPrice;
	}



	public int getCartNo() {
		return cartNo;
	}


	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
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

	
	









	
	
	
	
	
}
