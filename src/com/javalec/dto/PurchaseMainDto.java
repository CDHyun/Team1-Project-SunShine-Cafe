package com.javalec.dto;

public class PurchaseMainDto {

	int cartNo;
	String itemName;
	int cartQty;
	int cartOptionPrice;
	

	
	public PurchaseMainDto() {
		// TODO Auto-generated constructor stub
	}


	// 카트 데이터 가져오기

	public PurchaseMainDto(String itemName, int cartQty, int cartOptionPrice) {
		super();
		this.itemName = itemName;
		this.cartQty = cartQty;
		this.cartOptionPrice = cartOptionPrice;
	}



	public int getCartNo() {
		return cartNo;
	}




	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}





	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
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
