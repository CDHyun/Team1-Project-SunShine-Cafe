package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.PurchaseMainDto;
import com.javalec.util.ShareVar;

public class PurchaseMainDao {
	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;
	
	int cartNo;
	int dessertNo;
	int drinkNo;
	String userid = "donghyun";
	int cartQty;
	
	
	public ArrayList<PurchaseMainDto> purchaseList(){
		ArrayList<PurchaseMainDto> dtoList = new ArrayList<PurchaseMainDto>();
		
		String query = "select ds.dessertNo, d.drinkNo, c.cartQty, c.cartOptionPrice from cart ";
		String query1 = " where userid = " + "'" + userid + "'";
		
		String query2 = "select dessertName from dessert where dessertNo = ";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query+query1);
				
			while(rs.next()) {
				String wkDessertName = rs.getString(1);
				System.out.println(wkDessertName);
				String wkDrinkName = rs.getString(2);
				System.out.println(wkDrinkName);
				int wkCartQty = rs.getInt(3);
				System.out.println(wkCartQty);
				int wkPrice = rs.getInt(4);
				System.out.println(wkPrice);
				
				PurchaseMainDto dto = new PurchaseMainDto(wkDrinkName, wkDessertName, wkCartQty, wkPrice);
				dtoList.add(dto);
				
				
			}
			conn_mysql.close();
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			
		}
		
		return dtoList;
		
	}
	
	
	
	
	
	
}
