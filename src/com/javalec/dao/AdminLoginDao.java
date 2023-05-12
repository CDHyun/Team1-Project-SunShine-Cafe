package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.util.ShareVar;

public class AdminLoginDao {
	
	// DB 연결하기 
	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;
	
	// 관리자가 로그인 할 때 입력할 데이터 초기화
	String adminId ; 			// 관리자는 staff 테이블에, 관리자 아이디는 스텝 넘버와 같음 
	String adminPassword; 
	
	
	// Constructor
	public AdminLoginDao() {
		// TODO Auto-generated constructor stub
	}


	// DB에 아이디가 있는지 확인해 줄 생성자 		: AdminLoginMain 에서 existAdminId()
	public AdminLoginDao(String adminId) {
		super();
		this.adminId = adminId;
	}


	// 관리자가 로그인 할 때 받아올 데이터(아이디, 패스워드) 생성자  
	public AdminLoginDao(String adminId, String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminPassword = adminPassword;
	}

	
	
	
	
	
	// Method
	
	// 관리자가 입력한 아이디가 DB에 있는지 존재여부 확인해 줄 메소드 
	public int existsAdminId(String adminId) { 		
		int count = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt = con.createStatement();
			
			String query = "select count(staffno) from staff where staffid = '" + adminId + "'";
			
	        ResultSet rs = stmt.executeQuery(query);
	        
	        while (rs.next()) {
	            count = rs.getInt(1); // count(userid) 결과 가져오기
	        }
			
		}catch(Exception e){
			
		}
		return count;
	}
	
	
	// 관리자가 입력한 아이디와 비밀번호가 DB에 존재하는지 확인해즐 메소드 -> 일치하면 로그인 완료되도록.
	public boolean loginCheck(String adminId, String adminPassword) {
		boolean result = false;
		int count = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt = con.createStatement();
			
			String query = "select count(staffno) from staff where staffno = '" + adminId + "'" + " and staffPassword = '" + adminPassword + "'";
			
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				count = rs.getInt(1);
			}
			if(count > 0) {
				result = true;
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return result;
	}
	
	
	
	
	
	
	
}
