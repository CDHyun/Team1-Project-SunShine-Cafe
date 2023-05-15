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

import com.javalec.dto.CartDto;
import com.javalec.dto.ProductDto;
import com.javalec.util.ShareVar;

public class CartDao {

	/* Field */
	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;

	/* Cart */
	int cartNo;
	int cartQty;
	
	/* category */
	int categoryNo;
	String categoryName;

	
	/* item */
	int itemNo;
	String itemName;
	int itemPrice;
	String itemInsertDate;
	String itemImageName;
	FileInputStream itemImage;
	boolean itemStatus;
	
	/* user */
	String userid = ShareVar.userid;

	/* Item */
	int wkItemNo;
	String wkItemName;
	int wkItemPrice;
	int cartOptionPrice;

	public CartDao(int itemNo, String userid, int cartOptionPrice) {
		super();
		this.itemNo = itemNo;
		this.userid = userid;
		this.cartOptionPrice = cartOptionPrice;
	}
	
	
	

	/* Constructor */
	public CartDao() {
		// TODO Auto-generated constructor stub
	}

	/* 01. 선택한 상품을 카트에 담아주는 메소드 */
	public boolean itemAddToCart() {
		String query = "insert into cart(itemNo, userid, cartOptionPrice) values(?, ?, ?)";
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt = con.createStatement();
			ps = con.prepareStatement(query);
			ps.setInt(1, itemNo);
			ps.setString(2, userid);
			ps.setInt(3, cartOptionPrice);
			ps.executeUpdate();
			con.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean dessertAddToCart() {
		String countQuery = "select count(itemNo) from cart where itemNo = ? and userid = ?";
		String insertQuery = "insert into cart(itemNo, userid, cartOptionPrice) values(?, ?, ?)";
		String updateQuery = "update cart set cartQty = cartQty + 1 where itemNo = ? and userid = ?";
	    PreparedStatement countPs = null;
	    PreparedStatement insertPs = null;
	    PreparedStatement updatePs = null;
	    
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
	        countPs = con.prepareStatement(countQuery);
	        countPs.setInt(1, itemNo);
	        countPs.setString(2, userid);
	        ResultSet countResult = countPs.executeQuery();
	        countResult.next();
	        int count = countResult.getInt(1);
	        
	        if (count == 0) {
	            insertPs = con.prepareStatement(insertQuery);
	            insertPs.setInt(1, itemNo);
	            insertPs.setString(2, userid);
	            insertPs.setInt(3, cartOptionPrice);
	            insertPs.executeUpdate();
	        } else {
	            // Update query
	            updatePs = con.prepareStatement(updateQuery);
	            updatePs.setInt(1, itemNo);
	            updatePs.setString(2, userid);
	            updatePs.executeUpdate();
	        }
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/* 02. 카트 리스트를 불러오는 메소드 */
	public ArrayList<CartDto> cartList(String userid) {
		ArrayList<CartDto> beanList = new ArrayList<CartDto>();
		String query = "select c.cartNo, c.cartQty, c.itemNo, i.itemName, c.cartOptionPrice, i.categoryNo from cart c, item i, category ct where c.itemNo = i.itemNo and i.categoryNo = ct.categoryNo and c.userid = '" + userid + "'";


		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				int wkCartNo = rs.getInt(1);
				int wkCartQty = rs.getInt(2);
				int wkItemNo = rs.getInt(3);
				String wkItem = rs.getString(4);
				int wkCartOptionPrice = rs.getInt(5);
				int wkCategoryNo = rs.getInt(6);
				CartDto cartDto = new CartDto(wkCartNo, wkCartQty, wkCartOptionPrice, wkItemNo, wkItem, wkCategoryNo);
				beanList.add(cartDto);
			}
			
			System.out.println(beanList.size());
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return beanList;
	}

	/* 카트 비우기 메소드 */
	public boolean deleteAllCartList(String userid) {
		String query = "delete from cart where userid = ?";

		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt = con.createStatement();
			ps = con.prepareStatement(query);
			ps.setString(1, userid);
			ps.executeUpdate();
			con.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateCartPlusQty(int cartNo, int itemNo, String userid) {
		String query = "update cart set cartQty = cartQty + 1 where cartNo = ? and itemNo = ? and userid = ?";
		
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt = con.createStatement();
			ps = con.prepareStatement(query);
			ps.setInt(1, cartNo);
			ps.setInt(2, itemNo);
			ps.setString(3, userid);
			ps.executeUpdate();
			con.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateCartMinusQty(int cartNo, int itemNo, String userid) {
		String query = "update cart set cartQty = cartQty - 1 where cartNo = ? and itemNo = ? and userid = ?";
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt = con.createStatement();
			ps = con.prepareStatement(query);
			ps.setInt(1, cartNo);
			ps.setInt(2, itemNo);
			ps.setString(3, userid);
			ps.executeUpdate();
			con.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteCartItem(int cartNo, int itemNo, String userid) {
		String query = "delete from cart where cartNo = ? and itemNo = ? and userid = ?";
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt = con.createStatement();
			ps = con.prepareStatement(query);
			ps.setInt(1, cartNo);
			ps.setInt(2, itemNo);
			ps.setString(3, userid);
			ps.executeUpdate();
			con.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
} // End Class
