package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.util.ShareVar;

public class PaymentDao {
	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;
	
	int salesNo = 1;
	
	
	
	public PaymentDao() {
		// TODO Auto-generated constructor stub
	} 
	
	
	// purchase 테이블에 구매데이터 넣기
	public boolean addToPurchase(int num) {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt = con.createStatement();
			
			String query = "select itemNo, userid, cartQty, cartOptionPrice from cart";
			String insert = "insert into purchase (itemNo, userid, salesNo, purchaseQty, purchaseDiningOption, purchasePrice)";
			String insert1 = " values( ?, ?, ?, ?, ? ,?)";
			ResultSet rs = stmt.executeQuery(query);
			ps = con.prepareStatement(insert+insert1);
			
			while(rs.next()) {
				ps.setInt(1, rs.getInt(1));
				ps.setString(2, rs.getString(2));
				ps.setInt(3, salesNo);
				ps.setInt(4, rs.getInt(3));
				ps.setInt(5, num);
				ps.setInt(6, rs.getInt(4) * rs.getInt(3));
				ps.executeUpdate();
			}
			salesNo = salesNo +1;
			
			con.close();
			return true;

		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	// 구매 후 카트 지우기
	public boolean deleteCart() {
		PreparedStatement ps = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			String query = "delete from cart";
			
			ps = conn_mysql.prepareStatement(query);

			ps.executeUpdate();
			conn_mysql.close();
						
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
	
	
	
}// end
