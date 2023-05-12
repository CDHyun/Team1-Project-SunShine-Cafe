package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.util.ShareVar;

public class LoginDao {

	// Database
	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBPass;
	private final String pw_mysql = ShareVar.DBUser;
			
	
	// 변수명 
	String userid;
	String userPassWord;
	
	
	// Constructor
	public LoginDao() {
		// TODO Auto-generated constructor stub
	}


	
	
	// DB에서 id체크 
	
	public LoginDao(String userid) {
		super();
		this.userid = userid;
	}

	
	
	// id, pw 생정자
	
	public LoginDao(String userid, String userPassWord) {
		super();
		this.userid = userid;
		this.userPassWord = userPassWord;
	}
	
	
	public int existsUserID(String userid) {
		int count = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt = con.createStatement();
			
			String query = "select count(userid) from user where userid = '" + userid + "'";
			
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				count = rs.getInt(1);
			}
		}catch (Exception e) {
			
		}
		return count;
	}
	
	
	// 로그인 할때 입력한 정보가 DB에 있는지 확인 
	public boolean loginCheck(String userid, String password) {
		boolean result = false;
		int count = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt = con.createStatement();
			
			String query = "select count(userPhon) from user where userid = '" + userid + "'" + "and userPassWord + '" + password + "'";
			
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				count = rs.getInt(1);
			}
			if(count > 0) {
				result = true;
			}
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	
	
	
}// End
