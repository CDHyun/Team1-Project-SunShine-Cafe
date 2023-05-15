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
	
	
	// 로그인 액션 수행
    public boolean loginAction(String userid, String userPassWord) {
        boolean loggedIn = false;
        if (existsUserID(userid)) { // 아이디가 존재하는 경우에만 로그인 체크 수행
            loggedIn = loginCheck(userid, userPassWord);
        }
        return loggedIn;
    }

    // 아이디가 존재하는지 확인
    public boolean existsUserID(String userid) {
        boolean exists = false;
        try (Connection conn = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
             PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM user WHERE userid = ?")) {
            stmt.setString(1, userid);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                exists = count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }

    // 로그인 체크
    public boolean loginCheck(String userid, String userPassword) {
        boolean loggedIn = false;
        try (Connection conn = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
             PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM user WHERE userid = ? AND userPassWord = ?")) {
            stmt.setString(1, userid);
            stmt.setString(2, userPassword);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                loggedIn = count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loggedIn;
    }

  
	
	
	
	
	
}// End
