package com.javalec.dao;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.javalec.dto.AdminMenuDto;
import com.javalec.util.ShareVar;


public class AdminMenuDao {
	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;

	int categoryNo;
	String categoryName;
	
	// 검색
	String conname;
	String condata;
	// drink
	String drinkName;
	int drinkPrice;
	String drinkImageName;
	FileInputStream drinkImage;
	int drinkStatus;
	int drinkNo;
	String drinkContent;

	
	
	// 검색
	public AdminMenuDao(String conname, String condata) {
		super();
		this.conname = conname;
		this.condata = condata;
	}


	// drink 입력을 위한 생성자
	public AdminMenuDao(String categoryName, String drinkName, int drinkPrice, String drinkImageName,
			FileInputStream drinkImage, int drinkStatus, String drinkContent) {
		super();
		this.categoryName = categoryName;
		this.drinkName = drinkName;
		this.drinkPrice = drinkPrice;
		this.drinkImageName = drinkImageName;
		this.drinkImage = drinkImage;
		this.drinkStatus = drinkStatus;
		this.drinkContent = drinkContent;
	}



	// category 입력
	public AdminMenuDao(String categoryName) {
		super();
		this.categoryName = categoryName;
	}
	public AdminMenuDao() {
		// TODO Auto-generated constructor stub
	}
	

	
	
	
	// 메뉴 데이터
	public ArrayList<AdminMenuDto> meunList(){
		ArrayList<AdminMenuDto> dtoList = new ArrayList<AdminMenuDto>();
		
		String query = "select i.itemName, i.itemPrice, c.categoryName, i.itemStatus from category c, item i";
		String query1 = " where c.categoryNo = i.categoryNo";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query+query1);
			
			while(rs.next()) {
				String wkName = rs.getString(1);
				int wkdPrice = rs.getInt(2);
				String wkcategoryName = rs.getString(3);
				int wkdrinkStatus = rs.getInt(4);
				
				AdminMenuDto dto = new AdminMenuDto(wkName, wkdPrice, wkcategoryName, wkdrinkStatus);
				dtoList.add(dto);
				
			}
			conn_mysql.close();

						
		}catch (Exception e) {
			// TODO: handle exception

		}
		
		return dtoList;
			
	}
	

	
	// 카테고리 데이터
	public ArrayList<AdminMenuDto> cetagoryList(){
		ArrayList<AdminMenuDto> dtoList = new ArrayList<AdminMenuDto>();
		
		String query = "select categoryNo, categoryName from category ";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			while(rs.next()) {
				int wkCategory = rs.getInt(1);
				String wkCategoryName = rs.getString(2);
				
				AdminMenuDto dto = new AdminMenuDto(wkCategory, wkCategoryName);
				dtoList.add(dto);
			}
			conn_mysql.close();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return dtoList;
		
	}
	
	// 콤보박스에 카테고리 데이터 추가
	public ArrayList<AdminMenuDto> cetagoryNameList(){
		ArrayList<AdminMenuDto> dtoList = new ArrayList<AdminMenuDto>();
		
		String query = "select categoryName from category ";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			while(rs.next()) {
				
				String wkCategoryName = rs.getString(1);
				
				AdminMenuDto dto = new AdminMenuDto(wkCategoryName);
				dtoList.add(dto);
			}
			conn_mysql.close();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return dtoList;
		
	}
	
	// 음료 등록
	public boolean drinkAction() {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			String query2 = "select categoryNo "
					+ "from category "
					+ "where categoryName = " + "'" + categoryName +"'";
			ResultSet rs = stmt_mysql.executeQuery(query2);
			
			String query = "insert into item(categoryNo, itemName, itemPrice, itemImageName, itemImage, itemStatus, itemContent)";
			String query1 = " values (?, ? , ?, ? , ?, ?, ?)";
			
			if(rs.next()) {			// rs는 true, false 값
				ps  = conn_mysql.prepareStatement(query + query1);
				ps.setInt(1, rs.getInt(1));
				ps.setString(2, drinkName);
				ps.setInt(3, drinkPrice);
				ps.setString(4, drinkImageName);
				ps.setBlob(5, drinkImage);
				ps.setInt(6, drinkStatus);
				ps.setString(7, drinkContent);
				
				ps.executeUpdate();
				
			}
			conn_mysql.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
		
	}
	

	
	// 카테고리 데이터 등록
	public boolean categoryAction() {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			String query = "insert into category (categoryName) values (?)";
			ps = conn_mysql.prepareStatement(query);
			
			ps.setString(1, categoryName);
			
			ps.executeUpdate();
	
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}
	
	// 메뉴 데이터 가져오기
	public AdminMenuDto drinkClick(int itemNo) {
		AdminMenuDto dto = null;
		
		String whereDefault = "select i.itemNo, i.itemName, i.itemPrice, c.categoryName, i.itemImageName, i.itemImage, i.itemStatus, i.itemContent from item i, category c";
		String whereDefault1 = " where i.categoryNo = c.categoryNo and i.itemNo = " + itemNo;
		
		try {
			// DB 연결!!! 선언자
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();								// 불러올때 사용
			
			ResultSet rs = stmt_mysql.executeQuery(whereDefault + whereDefault1);
			
			if(rs.next()) {
				int wkSeq = rs.getInt(1);
				String wkName = rs.getString(2);
				int wkPrice = rs.getInt(3);
				String wkCate = rs.getString(4);
				String wkImage = rs.getString(5);
				File file = new File("./" + wkImage);
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(6);
				byte[] buffer = new byte[1024];
				while(input.read(buffer) > 0) {
					output.write(buffer);
				}
				int wkStatus = rs.getInt(7);
				String wkContent = rs.getString(8);
				dto = new AdminMenuDto(wkSeq, wkName, wkPrice, wkCate, wkImage, wkStatus, wkContent);
				
				
			}
			
			conn_mysql.close();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return dto;
	}
	
	// 카테고리 데이터 가져오기
	public AdminMenuDto categoryClick(int categoryNo) {
		AdminMenuDto dto = null;
		
		String whereDefault = "select categoryNo, categoryName from category where categoryNo = " + categoryNo;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();								// 불러올때 사용
			
			ResultSet rs = stmt_mysql.executeQuery(whereDefault);
			
			if(rs.next()) {
				int wkSeq = rs.getInt(1);
				String wkName = rs.getString(2);
				dto = new AdminMenuDto(wkSeq, wkName);
			}
			conn_mysql.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return dto;
	}
	
	// 음료 데이터 수정
	public boolean updateDrink(int drinkNo) {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			String query2 = "select c.categoryNo "
					+ "from category c  "
					+ "where categoryName = " + "'" + categoryName +"'";
						
			ResultSet rs = stmt_mysql.executeQuery(query2);
			
			String query = "update item set categoryNo = ?, itemName = ?, itemPrice = ?, itemImageName = ?, itemImage = ?, itemStatus = ?, itemContent = ?";
			String query1 = " where itemNo = ?";
			ps = conn_mysql.prepareStatement(query+query1);
		
			if(rs.next()) {
				ps.setInt(1, rs.getInt(1));
				ps.setString(2, drinkName);
				ps.setInt(3, drinkPrice);
				ps.setString(4, drinkImageName);
				ps.setBlob(5, drinkImage);
				ps.setInt(6, drinkStatus);
				ps.setString(7, drinkContent);
				ps.setInt(8, drinkNo);
				
				ps.executeUpdate();				
			}
				conn_mysql.close();

		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
		
	}

	
	// 카테고리 데이터 수정
	public boolean updateCategory(int categoryNo) {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			String query = "update category set categoryName = ? where categoryNo = ?";
	
			ps = conn_mysql.prepareStatement(query);
			
			ps.setString(1, categoryName);
			ps.setInt(2, categoryNo);
			
			ps.executeUpdate();
	
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	// 음료 데이터 검색
	public ArrayList<AdminMenuDto> drinkconditionList(){
		ArrayList<AdminMenuDto> dtoList = new ArrayList<AdminMenuDto>();
		
		String query = "select i.itemName, i.itemPrice, c.categoryName, i.itemStatus from category c, item i";
		String query1 = " where c.categoryNo = i.categoryNo and " + conname + " like '%" + condata + "%'" ;;
		
		System.out.println(conname);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query+query1);
			
			while(rs.next()) {
				String wkdrinkName = rs.getString(1);
				int wkdrinkPrice = rs.getInt(2);
				String wkcategoryName = rs.getString(3);
				int wkdrinkStatus = rs.getInt(4);
				
				AdminMenuDto dto = new AdminMenuDto(wkdrinkName, wkdrinkPrice, wkcategoryName, wkdrinkStatus);
				dtoList.add(dto);
				
			}
			conn_mysql.close();

						
		}catch (Exception e) {
			// TODO: handle exception

		}
		return dtoList;	
	}
	

	
	// 카테고리 데이터 검색
	
	public ArrayList<AdminMenuDto> cetagoryconditionList(){
		ArrayList<AdminMenuDto> dtoList = new ArrayList<AdminMenuDto>();
		
		String query = "select categoryNo, categoryName from category where "  + conname + " like '%" + condata + "%'" ;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			while(rs.next()) {
				int wkCategory = rs.getInt(1);
				String wkCategoryName = rs.getString(2);
				
				AdminMenuDto dto = new AdminMenuDto(wkCategory, wkCategoryName);
				dtoList.add(dto);
			}
			conn_mysql.close();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return dtoList;
		
	}
	
	

} //end

