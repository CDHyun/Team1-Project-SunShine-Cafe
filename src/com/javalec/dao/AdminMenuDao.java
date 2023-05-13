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
	// drink
	String drinkName;
	int drinkPrice;
	String drinkImageName;
	FileInputStream drinkImage;
	int drinkStatus;
	int drinkNo;
	// dessert
	String dessertName;
	int dessertStock;
	int dessertPrice;
	String dessertImageName;
	FileInputStream dessertImage;
	int dessertStatus;
	
	// dessert 입력을 위한 생성자
	public AdminMenuDao(String categoryName, String dessertName, int dessertStock, int dessertPrice, String dessertImageName,
			FileInputStream dessertImage, int dessertStatus) {
		super();
		this.categoryName = categoryName;
		this.dessertName = dessertName;
		this.dessertStock = dessertStock;
		this.dessertPrice = dessertPrice;
		this.dessertImageName = dessertImageName;
		this.dessertImage = dessertImage;
		this.dessertStatus = dessertStatus;
	}

	// drink 입력을 위한 생성자
	public AdminMenuDao(String categoryName, String drinkName, int drinkPrice, String drinkImageName,
			FileInputStream drinkImage, int drinkStatus) {
		super();
		this.categoryName = categoryName;
		this.drinkName = drinkName;
		this.drinkPrice = drinkPrice;
		this.drinkImageName = drinkImageName;
		this.drinkImage = drinkImage;
		this.drinkStatus = drinkStatus;
	}

	// drink 수정을 위한 생성자
	public AdminMenuDao(String categoryName, String drinkName, int drinkPrice, FileInputStream drinkImage,
			int drinkStatus) {
		super();
		this.categoryName = categoryName;
		this.drinkName = drinkName;
		this.drinkPrice = drinkPrice;
		this.drinkImage = drinkImage;
		this.drinkStatus = drinkStatus;
	}

	// category 입력
	public AdminMenuDao(String categoryName) {
		super();
		this.categoryName = categoryName;
	}
	public AdminMenuDao() {
		// TODO Auto-generated constructor stub
	}
	
	// 음료 데이터
	public ArrayList<AdminMenuDto> drinkList(){
		ArrayList<AdminMenuDto> dtoList = new ArrayList<AdminMenuDto>();
		
		String query = "select d.drinkName, d.drinkPrice, c.categoryName, d.drinkStatus from category c, drink d";
		String query1 = " where d.categoryNo = c.categoryNo";
		
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
	
	// 디저트 데이터
	public ArrayList<AdminMenuDto> dessertList(){
		ArrayList<AdminMenuDto> dtoList = new ArrayList<AdminMenuDto>();
		
		String query = "select d.dessertName, d.dessertPrice, d.dessertStock, c.categoryName, d.dessertStatus from category c, dessert d";
		String query1 = " where d.categoryNo = c.categoryNo";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query+query1);
			
			while(rs.next()) {
				String wkdessertName = rs.getString(1);
				int wkdessertPrice = rs.getInt(2);
				int wkdessertStock = rs.getInt(3);
				String wkcategoryName = rs.getString(4);
				int wkdessertStatus = rs.getInt(5);
				
				AdminMenuDto dto = new AdminMenuDto(wkdessertName, wkdessertPrice, wkdessertStock, wkcategoryName, wkdessertStatus);
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
			
			String query = "insert into drink(categoryNo, drinkName, drinkPrice, drinkImageName, drinkImage, drinkStatus)";
			String query1 = " values (?, ? , ?, ? , ?, ?)";
			
			if(rs.next()) {			// rs는 true, false 값
				ps  = conn_mysql.prepareStatement(query + query1);
				ps.setInt(1, rs.getInt(1));
				ps.setString(2, drinkName);
				ps.setInt(3, drinkPrice);
				ps.setString(4, drinkImageName);
				ps.setBlob(5, drinkImage);
				ps.setInt(6, drinkStatus);
				
				ps.executeUpdate();
				
			}
			conn_mysql.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
		
	}
	
	// 디저트 등록
	public boolean dessertAction() {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			String query2 = "select categoryNo "
					+ "from category "
					+ "where categoryName = " + "'" + categoryName +"'";
			ResultSet rs = stmt_mysql.executeQuery(query2);
			
			String query = "insert into dessert(categoryNo, dessertName, dessertStock, dessertPrice, dessertImageName, dessertImage, dessertStatus)";
			String query1 = " values (?, ? , ?, ? , ?, ?, ?)";
			
			if(rs.next()) {			// rs는 true, false 값
				ps  = conn_mysql.prepareStatement(query + query1);
				ps.setInt(1, rs.getInt(1));
				ps.setString(2, dessertName);
				ps.setInt(3, dessertStock);
				ps.setInt(4, dessertPrice);
				ps.setString(5, dessertImageName);
				ps.setBlob(6, dessertImage);
				ps.setInt(7, dessertStatus);
				
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
	
	// 음료 데이터 가져오기
	public AdminMenuDto drinkClick(int drinkNo) {
		AdminMenuDto dto = null;
		
		String whereDefault = "select d.drinkNo, d.drinkName, d.drinkPrice, c.categoryName, d.drinkImageName, d.drinkImage, d.drinkStatus from drink d, category c";
		String whereDefault1 = " where d.categoryNo = c.categoryNo and d.drinkNo = " + drinkNo;
		
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
				dto = new AdminMenuDto(wkSeq, wkName, wkPrice, wkCate, wkImage, wkStatus);
				
				
			}
			
			conn_mysql.close();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return dto;
	}
	
	// 디저트 데이터 가져오기
	public AdminMenuDto dessertClick(int dessertNo) {
		AdminMenuDto dto = null;
		
		String whereDefault = "select d.dessertNo, d.dessertName, d.dessertStock, d.dessertPrice, c.categoryName, d.dessertImageName, d.dessertImage, d.dessertStatus from dessert d, category c";
		String whereDefault1 = " where d.categoryNo = c.categoryNo and d.dessertNo = " + dessertNo;
		
		try {
			// DB 연결!!! 선언자
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();								// 불러올때 사용
			
			ResultSet rs = stmt_mysql.executeQuery(whereDefault + whereDefault1);
			
			if(rs.next()) {
				int wkSeq = rs.getInt(1);
				String wkName = rs.getString(2);
				int wkQty = rs.getInt(3);
				int wkPrice = rs.getInt(4);
				String wkCate = rs.getString(5);
				String wkImage = rs.getString(6);
				File file = new File("./" + wkImage);
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(7);
				byte[] buffer = new byte[1024];
				while(input.read(buffer) > 0) {
					output.write(buffer);
				}
				int wkStatus = rs.getInt(8);
				dto = new AdminMenuDto(wkSeq, wkName, wkQty, wkPrice, wkCate, wkImage, wkStatus);
				
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
	
	// 음료 데이터 업데이트
	public boolean updateDrink() {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			String query2 = "select c.categoryNo, d.drinkNo "
					+ "from category c, drink d "
					+ "where c.categoryNo = d.categoryNo and categoryName = " + "'" + categoryName +"' and "
							+ " drinkName = " + "'" + drinkName + "'";
			ResultSet rs = stmt_mysql.executeQuery(query2);
			
			String query = "update drink set categoryNo = ?, drinkName = ?, drinkPrice = ?, drinkImageName = ?, drinkImage =?, drinkStatus =?";
			String query1 = " where drinkNo = ?";
			ps = conn_mysql.prepareStatement(query+query1);
			
			if(rs.next()) {
				ps.setInt(1, rs.getInt(1));
				ps.setString(2, drinkName);
				ps.setInt(3, drinkPrice);
				ps.setString(4, drinkImageName);
				ps.setBlob(5, drinkImage);
				ps.setInt(6, drinkStatus);
				ps.setInt(7, rs.getInt(2));
				
				ps.executeUpdate();				
			}
				conn_mysql.close();

		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
		
	}
	
	
	
	
	

} //end

