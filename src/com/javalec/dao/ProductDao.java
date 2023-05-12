package com.javalec.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.ProductDto;
import com.javalec.util.ShareVar;

public class ProductDao {

	/* Field */
	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;

	/* category */
	int categoryNo;
	String categoryName;
	
	/* dessert */
	int dessertNo;
	String dessertNane;
	int dessertStock;
	int dessertPrice;
	String dessertInsertDate;
	String dessertImageName;
	FileInputStream dessertImage;
	boolean dessertStatus;
	
	/* drink */
	int drinkNo;
	String drinkName;
	int drinkPrice;
	String drinkInsertDate;
	String drinkImageName;
	FileInputStream drinkImage;
	boolean drinkStatus;
	
	
	/* 01. 전체 상품을 검색하는 메소드 */
	public ArrayList<ProductDto> selectDrinkList(){
		ArrayList<ProductDto> beanList = new ArrayList<ProductDto>();
		
		String query = "select drinkNo, drinkName, drinkPrice, drinkImageName, drinkImage, categoryNo from drink";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				int wkNo = rs.getInt(1);
				String wkName = rs.getString(2);
				int wkPrice = rs.getInt(3);
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
				ProductDto productDto = new ProductDto(categoryNo, wkNo, wkName, wkPrice, wkImageName);
				beanList.add(productDto);
			}
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return beanList;
	}
	
	/* 02. 선택한 Drink Category 데이터를 검색하는 메소드 */
	public ArrayList<ProductDto> conditionDrinkQuery(int categoryNo){
		ArrayList<ProductDto> beanList = new ArrayList<ProductDto>();
		String query = "select drinkNo, drinkName, drinkPrice, drinkImageName, drinkImage from drink where categoryNo = ";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query + categoryNo);
			
			while(rs.next()) {
				int wkNo = rs.getInt(1);
				String wkName = rs.getString(2);
				int wkPrice = rs.getInt(3);
				String wkImageName = rs.getString(4);
				/*** Image 파일 생성 ***/
				File file = new File("./" + wkImageName);
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(5);
				byte[] buffer = new byte[1024];
				
				while(input.read(buffer) > 0) {
					output.write(buffer);
				}
				ProductDto productDto = new ProductDto(wkNo, wkName, wkPrice, wkImageName);
				beanList.add(productDto);
			}
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return beanList;
		
	}
	
	/* 03. 선택한 Dessert Category 데이터를 검색하는 메소드 */
	public ArrayList<ProductDto> conditionDessertQuery(int categoryNo){
		ArrayList<ProductDto> beanList = new ArrayList<ProductDto>();
		String query = "select dessertNo, dessertName, dessertPrice, dessertImageName, dessertImage from dessert where categoryNo = ";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query + categoryNo);
			
			while(rs.next()) {
				int wkNo = rs.getInt(1);
				String wkName = rs.getString(2);
				int wkPrice = rs.getInt(3);
				String wkImageName = rs.getString(4);
				/*** Image 파일 생성 ***/
				File file = new File("./" + wkImageName);
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(5);
				byte[] buffer = new byte[1024];
				
				while(input.read(buffer) > 0) {
					output.write(buffer);
				}
				ProductDto productDto = new ProductDto(wkNo, wkName, wkPrice, wkImageName);
				beanList.add(productDto);
			}
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return beanList;
	}
	
	public ArrayList<ProductDto> itemDetail(int categoryNo, int itemNo){
		ArrayList<ProductDto> beanList = new ArrayList<ProductDto>();
		String query = "";
		if(categoryNo == 5) {
			query = "select dessertName, dessertPrice, dessertImageName, dessertContent from dessert where dessertNo = ";
		} else {
			query = "select drinkName, drinkPrice, drinkImageName, drinkContent from drink where drinkNo = ";
		}
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query + itemNo);
			
			while(rs.next()) {
				String wkName = rs.getString(1);
				int wkPrice = rs.getInt(2);
				String wkImageName = rs.getString(3);
				String wkContent = rs.getString(4);
				ProductDto productDto = new ProductDto(wkName, wkPrice, wkImageName, wkContent);
				beanList.add(productDto);
				}
			
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return beanList;
		
	}
	
	
	
}	// End Class
