package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.util.ShareVar;

public class UserSingUpDao {
	
	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;
	
	// Field
	String userid;
	String userPassword;
	String userPhone;
	
	
	
	// Constructor
	
	public UserSingUpDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	// Method
	
	
	
	// 입력된 ID가 DB에 있는지 확인
	public int checkID(String insertID) {
		String query = "select count(userid) from user where userid = " + "'" + insertID + "'";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				int wkCount = rs.getInt(1);
				return wkCount;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	// 사용자 등록 처리 
	
	public boolean register(String userId, String userPassword, String userPhon) {
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			String query = "insert into user(userid, userPassword, userPhone) values(?, ?, ?)";
			
			ps = conn_mysql.prepareStatement(query);
			
			ps.setString(1, userId);
			ps.setString(2, userPassword);
			ps.setString(3, userPhone);
			ps.executeUpdate();
			conn_mysql.close();
			
			return true;
			
		} catch (Exception e) {
			
		}return false;
	}



	
	
	
	
	

}// End
