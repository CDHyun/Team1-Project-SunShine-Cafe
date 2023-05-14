package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.javalec.dto.AdminCalculateDto;
import com.javalec.util.ShareVar;

public class AdminCalculateDao {
	
	// DB 연결하기 
	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;
	
	
	
	// 변수 초기화
	int purchaseNo; 			// 구매 번호 (주문순서) 	
	String purchaseDate; 		// 구매 날짜 및 시간 
	int purchasePrice;			// 계산 금액 (제품수량(주문내역) * 금액) 
	String itemName;			// 주문 내역 
	String userid;				// 회원 아이디 
	
	
	// Constructor 
	public AdminCalculateDao() {
		// TODO Auto-generated constructor stub
	}
	
	// searchAction() 위한 생성자 -> 주문내역 테이블에 띄워주고 영수증으로 출력도 하고 선택후 취소도 할 수 있는데..... 구현을 몬하넹 
	// 정산 화면에서 tableInit() 생성 후 테이블에 들어갈 데이터 생성자 (구매번호, 거래일시, 계산금액, 주문내역, 회원id)
	public AdminCalculateDao(int purchaseNo, String purchaseDate, int purchasePrice, String itemName, String userid) {
		super();
		this.purchaseNo = purchaseNo;
		this.purchaseDate = purchaseDate;
		this.purchasePrice = purchasePrice;
		this.itemName = itemName;
		this.userid = userid;
	}
	
	
	
	
	
	
	// printReceipt() 위한 생성자 
	
	
	
	
	
	//--------Method
	
	
	/*
	// *********** 데이터 타입들 확인한 뒤에 생성자 만들기! + SQL Query 확인하기 
	// total price는 아이템 가격* 아이템 수량 + 선택한 옵션*옵션당 가격 <<<<< 쿼리문 어떻게 작성할거니. 수량, 옵션 옵션당 가격 따로 불러와서 곱해?
	public ArrayList<AdminCalculateDto> selectList() {
		ArrayList<AdminCalculateDao> dtoList = new ArrayList<AdminCalculateDao>();

		String query = "SELECT pur.purchaseno, pur.purchasedate, pur.saleprice, p.productname, u.userid" 
				+ " FROM purchase pur, user u, product p"
				+ " where p.userid = u.userid and p.productid = pur.productid "
				+ " group by p.purchaseno DESC";
		
		"SELECT pur.purchaseNo, pur.purchaseInsertDate, "
		+ " FROM purchase pur,"
		+ " WHERE " 
		// purchaseNo : 게속 쌓이는 주문 번호, salesNo : 그날 당일마다 초기화되는 주문번호 .
		

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

				AdminCalculateDto dto = new AdminCalculateDto(purchaseNo, purchaseDate, purchasePrice, itemName, userid);
				//dtoList.add(dto); 		// 뭐야 왜 에러야 
			}

			conn_mysql.close();

		} catch (Exception e) {
//				e.printStackTrace();
		}

		return dtoList;
	}  */
	
	



/*

	// 영수증 출력시 전달해 줄 내용들 
	// 선택된 구매 내역에 해당하는 데이터 불러오기
	
	AdminCalculateDao selectedPurchase = AdminCalculateDao.getPurchase(purchaseNo);

	// 주문한 상품 정보들을 itemLists 리스트에 담기
	List<ItemDto> itemLists = itemDao.getItemLists(selectedPurchase.getPurchaseId());

*/
	
	
	// 관리자가 마감 버튼을 눌러 오늘의 구매 내역 합계 계산 
	public void calculatePurchase() {
		int total = 0;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	

}
