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
	
	String userid = "donghyun";
	
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
	    
        	public ArrayList<StudyUserDto> selectStudyUserDto(){
        		ArrayList<StudyUserDto> beanList = new ArrayList<StudyUserDto>();
        		
        		String query = "select itemNo, itemName, itemPrice, itemImageName, itemImage, categoryNo from item";

        		try {
        			Class.forName("com.mysql.cj.jdbc.Driver");
        			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
        			Statement stmt = con.createStatement();
        			ResultSet rs = stmt.executeQuery(query);
        			
        			while(rs.next()) {
        				int wkItemNo = rs.getInt(1);
        				String wkItemName = rs.getString(2);
        				int wkItemPrice = rs.getInt(3);
        				String wkImageName = rs.getString(4);
        				/*** Image 파일 생성 ***/
        				File file = new File("./" + wkImageName);
        				FileOutputStream output = new FileOutputStream(file);
        				InputStream input = rs.getBinaryStream(5);
        				byte[] buffer = new byte[1024];
        				int categoryNo = rs.getInt(6);
        				
        				while(input.read(buffer) > 0) {
        					output.write(buffer);
        				}
        				StudyUserDto studyUserDto = new StudyUserDto(categoryNo, wkItemNo, wkItemName, wkItemPrice, wkImageName);
        				beanList.add(studyUserDto);
        			}
        			con.close();
        		} catch(Exception e) {
        			e.printStackTrace();
        		}
        		return beanList;
        	}		

        	
        	public ArrayList<StudyUserDto> studyList(){
        		ArrayList<StudyUserDto> dtoList = new ArrayList<StudyUserDto>();
        		
        		String query = "select i.itemName, i.itemIamageName, i.itemImage, i.itemContent, p.purchasePrice, " 
        				+ " from item i, purchase p, "
        				+ " where i.itemNo = p.purchaseNo ";

        		try {
        			Class.forName("com.mysql.cj.jdbc.Driver");
        			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
        			Statement stmt_mysql = conn_mysql.createStatement();
        			
        			ResultSet rs = stmt_mysql.executeQuery(query);
        				
        			while(rs.next()) {
        				int wkPrice = rs.getInt(4);
        				String wkName = rs.getString(1);
        				String wkImageName = rs.getString(2);
        				String wkContent = rs.getString(3);
        				// 이미지 불러올 때 하는 방법
        				File file = new File("./" + wkImageName);
        				FileOutputStream output = new FileOutputStream(file);
            		  	InputStream input = rs.getBinaryStream(5);
            		  	byte[] buffer = new byte[1024];
            		  	
            		  	while(input.read(buffer)>0) {
            		  		output.write(buffer);
            		  	}
            		  	         		  	
        				StudyUserDto dto = new StudyUserDto(wkPrice, wkName, wkImageName, wkContent);
        				dtoList.add(dto);
        			}
        		conn_mysql.close();
        		}catch(Exception e) {
        			
        	}
        		return dtoList;
        	}
}
