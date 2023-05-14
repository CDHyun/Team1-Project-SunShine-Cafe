package com.javalec.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.StudyStandByScreenDto;
import com.javalec.util.ShareVar;

public class StudyStandByScreenDao {

	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;

	
	String StudyStandByScreenImageName;
	FileInputStream StudyStandByScreenImage;

	public StudyStandByScreenDao() {
		// TODO Auto-generated constructor stub
	}
	public StudyStandByScreenDao(String studyStandByScreenImageName, FileInputStream studyStandByScreenImage) {
		super();
		StudyStandByScreenImageName = studyStandByScreenImageName;
		StudyStandByScreenImage = studyStandByScreenImage;
	}
	

	public boolean insertAction() {
		PreparedStatement ps = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt = con.createStatement();
		
			
			String query1 = "INSERT INTO (StudyStandByScreenImageName, StudyStandByScreenImage) VALUES(?,?)";

			PreparedStatement ps1 = con.prepareStatement(query1);		
			ps1.setString(1, StudyStandByScreenImageName);
			ps1.setBlob(2, StudyStandByScreenImage);

			ps1.executeUpdate();
			
			con.close();
		
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	
}