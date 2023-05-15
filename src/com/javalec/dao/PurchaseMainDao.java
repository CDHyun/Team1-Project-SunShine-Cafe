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
	
	String userid = ShareVar.userid;

	
	public PurchaseMainDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ArrayList<PurchaseMainDto> purchaseList(){
		ArrayList<PurchaseMainDto> dtoList = new ArrayList<PurchaseMainDto>();
		
		String query = "select i.itemName, c.cartQty, c.cartOptionPrice " 
				+ " from cart c, item i"
				+ " where i.itemNo = c.itemNo and c.userid = '" + userid + "'";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query);
				
			while(rs.next()) {
				String wkName = rs.getString(1);
				int wkCartQty = rs.getInt(2);
				int wkPrice = rs.getInt(3) * rs.getInt(2) ;

				
				PurchaseMainDto dto = new PurchaseMainDto(wkName, wkCartQty, wkPrice);
				dtoList.add(dto);
				
				
			}
			conn_mysql.close();
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			
		}
		
		return dtoList;
		
	}
	
	
	
	
	
	
}
