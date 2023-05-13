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
	
	/* user */
	String userid = ShareVar.userid;
	
	public CartDao(int drinkNo, String userid) {
		super();
		this.drinkNo = drinkNo;
		this.userid = userid;
	}
	
	/* Constructor */
	public CartDao() {
		// TODO Auto-generated constructor stub
	}

	/* 01. 선택한 상품을 카트에 담아주는 메소드 */
	public boolean drinkAddToCart() {
		String query = "insert into cart(drinkNo, userid) values(?, ?)";
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt = con.createStatement();
			ps = con.prepareStatement(query);
			ps.setInt(1, drinkNo);
			ps.setString(2, userid);
			ps.executeUpdate();
			con.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/* 02. 카트 리스트를 불러오는 메소드 */
	public ArrayList<CartDto> cartList(String userid){
		ArrayList<CartDto> beanList = new ArrayList<CartDto>();
		String query = "SELECT c.cartNo, c.cartQty, d.drinkNo, d.drinkName, d.drinkPrice, ds.dessertNo, ds.dessertName, ds.dessertPrice " +
		        "FROM cart c " +
		        "JOIN drink d ON c.drinkNo = d.drinkNo " +
		        "JOIN dessert ds ON c.dessertNo = ds.dessertNo " +
		        "JOIN user u ON c.userid = u.userid " +
		        "WHERE c.userid = '" + userid + "'";
		
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int wkCartNo = rs.getInt(1);
                if (rs.wasNull()) {
                    wkCartNo = 0;
                }

                int wkCartQty = rs.getInt(2);
                if (rs.wasNull()) {
                    wkCartQty = 0;
                }

                int wkDrinkNo = rs.getInt(3);
                if (rs.wasNull()) {
                    wkDrinkNo = 0;
                }

                String wkDrinkName = rs.getString(4);
                if(rs.wasNull()) {
                	wkDrinkName = "";
                }

                int wkDrinkPrice = rs.getInt(5);
                if (rs.wasNull()) {
                    wkDrinkPrice = 0;
                }

                int wkDessertNo = rs.getInt(6);
                if (rs.wasNull()) {
                    wkDessertNo = 0;
                }

                String wkDessertName = rs.getString(7);
                if(rs.wasNull()) {
                	wkDessertName = "";
                }

                int wkDessertPrice = rs.getInt(8);
                if (rs.wasNull()) {
                    wkDessertPrice = 0;
                }

                CartDto cartDto = new CartDto(wkCartNo, wkCartQty, wkDessertNo, wkDessertName, wkDessertPrice, wkDrinkNo, wkDrinkName, wkDrinkPrice);
                beanList.add(cartDto);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return beanList;
    }





	
	
	
}
