package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import com.javalec.util.ShareVar;

public class RentDao {

	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;

	int tableNo = ShareVar.tableNo;
	int rentNo;
	String userid = ShareVar.userid;
	String rentStartTime;
	String rentEndTime;

	public RentDao() {
		// TODO Auto-generated constructor stub
	}

	public boolean insertRent() {
		boolean result = false;
		try {
			String query = "INSERT INTO rent (tableNo, userid, rentStartTime, rentEndTime) VALUES (?, ?, NOW(), DATE_ADD(NOW(), INTERVAL 1 HOUR));";

			PreparedStatement ps = null;
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);

			ps = con.prepareStatement(query);
			ps.setInt(1, tableNo);
			ps.setString(2, userid);

			int count = ps.executeUpdate();

			if (count > 0) {
				result = true;
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

}
