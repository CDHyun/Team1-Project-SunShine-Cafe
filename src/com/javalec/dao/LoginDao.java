package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
	
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
		try (Connection conn = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
		         PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM user WHERE userid = ? AND userPassWord = ?")) {
		        stmt.setString(1, userid);
		        stmt.setString(2, userPassWord);
		        ResultSet rs = stmt.executeQuery();
		        if (rs.next()) {
		            count = rs.getInt(1);
		        }
		        if (count > 0) {
		            result = true;
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return result;
		}
	
	
	
	
	
	
	
}// End
