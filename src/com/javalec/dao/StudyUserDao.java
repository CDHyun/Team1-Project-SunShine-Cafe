package com.javalec.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.ProductDto;
import com.javalec.dto.StudyUserDto;
import com.javalec.util.ShareVar;

public class StudyUserDao {

	
	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;
	
	String therdcount = "30분 시간 이용권";
	String sixteencount = "60분 시간 이용권";
	public static int tcount = 0;
	public static int scount = 0;
	public StudyUserDao() {
		// TODO Auto-generated constructor stub
	}
	
	
//	public void insertStudyUser() {
//		PreparedStatement ps = null;
//		Connection conn = null;
//		Statement stmt = null;
//	    try {
//	    	conn = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql); // DB 연결
//            stmt = conn.createStatement();
//			
//            Stirng query ="insert into item(tableNo, itemImageName, itemName,)";
//	    	pstmt = conn.prepareStatement("INSERT INTO product(name, price, image) VALUES (?, ?, ?)");
//            pstmt.setString(1, product.getName());
//            pstmt.setInt(2, product.getPrice());
//            pstmt.setBytes(3, product.getImage());
//            pstmt.executeUpdate();
//        
//	    
//	    } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
	    	

        	
        	public ArrayList<StudyUserDto> studyList(){
        		ArrayList<StudyUserDto> dtoList = new ArrayList<StudyUserDto>();
        		
        		String query = "select i.itemName, i.itemImageName, i.itemImage, p.purchasePrice " 
        				+ " from item i, purchase p "
        				+ " where i.itemNo = p.itemNo and p.userid = '" + ShareVar.userid + "'";
   

        		try {
        			Class.forName("com.mysql.cj.jdbc.Driver");
        			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
        			Statement stmt_mysql = conn_mysql.createStatement();
        			
        			ResultSet rs = stmt_mysql.executeQuery(query);
        				
        			
        			while(rs.next()) {
        				int wkPrice = rs.getInt(4);
        				String wkName = rs.getString(1);
        				if(wkName.equals(therdcount)) {
        					tcount++;
        				}
        				if(wkName.equals(sixteencount)) {
        					scount++;
        				}
        				String wkImageName = rs.getString(2);
        				// 이미지 불러올 때 하는 방법
        				File file = new File("./" + wkImageName);
        				FileOutputStream output = new FileOutputStream(file);
            		  	InputStream input = rs.getBinaryStream(3);
            		  	byte[] buffer = new byte[1024];
            		  	
            		  	while(input.read(buffer)>0) {
            		  		output.write(buffer);
            		  	}
            		  	         		  	
        				StudyUserDto dto = new StudyUserDto(wkName, wkImageName, wkPrice);
        				dtoList.add(dto);
        			}
        		conn_mysql.close();
        		}catch(Exception e) {
        			
        	}
        		return dtoList;
        	}

        	//타이머 시간초 추가 데이터

}

        		

