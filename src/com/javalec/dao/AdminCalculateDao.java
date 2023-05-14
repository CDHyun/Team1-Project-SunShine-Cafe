package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.AdminCalculateDto;
import com.javalec.util.ShareVar;

public class AdminCalculateDao {
	
	// DB 연결하기 
	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;
	
	
	
	// 변수 초기화
	int purchaseNo;
	String date ; 		// 사용자가 구매한 일시 
	int price ; 		// 사용자 구매 총 금액
	String productName;
	int userId; 
	
	
	// Constructor 
	public AdminCalculateDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	// searchAction() 위한 생성자 
	// 정산 화면에서 tableInit() 생성 후 테이블에 들어갈 데이터 생성자 (구매번호, 거래일시, 계산금액, 주문내역, 회원id)
	public AdminCalculateDao(int purchaseNo, String date, int price, String productName, int userId) {
		super();
		this.purchaseNo = purchaseNo;
		this.date = date;
		this.price = price;
		this.productName = productName;
		this.userId = userId;
	}	
	
	
	
	
	
	//--------Method
	
	// *********** 데이터 타입들 확인한 뒤에 생성자 만들기! + SQL Query 확인하기 
	public ArrayList<AdminCalculateDao> selectList() {
		ArrayList<AdminCalculateDao> dtoList = new ArrayList<AdminCalculateDao>();

		String query = "SELECT pur.purchaseno, pur.purchasedate, pur.saleprice, p.productname, u.userid" 
				+ " FROM purchase pur, user u, product p"
				+ " where p.userid = u.userid and p.productid = pur.productid "
				+ " group by p.purchaseno DESC";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(query);

			while (rs.next()) {
				int wkpurchaseno = rs.getInt(1);
				String wkdate = rs.getString(2); 		// 날짜 데이터 타입 확인!
				int wkprice = rs.getInt(3);
				String wkproductName = rs.getString(4);
				int userid= rs.getInt(5);

				AdminCalculateDto dto = new AdminCalculateDto(purchaseNo, date, price, productName, userid);
				//dtoList.add(dto); 		// 뭐야 왜 에러야 
			}

			conn_mysql.close();

		} catch (Exception e) {
//				e.printStackTrace();
		}

		return dtoList;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	

}
