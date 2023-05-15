package com.javalec.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.javalec.util.ShareVar;

public class LoginDao {
	// Database
	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;

	// 변수명
	private String userid;
	private String userPassWord;
	private String userName;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// Constructor
	public LoginDao() {
	}

	public int countUser(String id, String string) {
		return 0;
	}

	// DB에서 id 체크
	public LoginDao(String userid) {
		this.userid = userid;
	}

	// id, pw 생성자
	public LoginDao(String userid, String userPassWord) {
		this.userid = userid;
		this.userPassWord = userPassWord;
	}

	// --------- Function

	public int existsUserID(String userid) {
		int count = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
					PreparedStatement stmt = con.prepareStatement("SELECT COUNT(userid) FROM user WHERE userid = ?")) {
				stmt.setString(1, userid);
				ResultSet rs = stmt.executeQuery();

				if (rs.next()) {
					count = rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return count;
	}

	public boolean loginCheck(String userid, String userPassword) {
		boolean result = false;
		PreparedStatement ps = null;
		try {
			String query = "SELECT COUNT(userName) FROM user WHERE userid = ? AND userPassword = ?";
			Connection conn = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);

			ps = conn.prepareStatement(query);
			ps.setString(1, userid);
			ps.setString(2, userPassword);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				if (count > 0) {
					result = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
