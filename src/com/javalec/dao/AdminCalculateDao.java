package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import com.javalec.dto.AdminCalculateDto;
import com.javalec.util.ShareVar;

public class AdminCalculateDao {
	
	// DB 연결하기 
	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;
	
	
	
	// 구매 내역을 불러오기 위한 생성자들 
	// salesNo, purchaseInsertDate, purchasePrice, itemName, userName
	
	// Field 
	private int salesNo;
	private Date purchaseInsertDate;
	private int purchasePrice;
	private String itemName; 		// 사용자가 주문한 상품들을 한번에 보여주기 위한 아이템 리스트
	private String userid;
	private String userName;
	
	// Constructor 
	public AdminCalculateDao() {
		// TODO Auto-generated constructor stub
	}
	
	// searchAction() 위한 생성자  - 주문서 재출력, 정산 등 모두 구매 내역들 보고 할 수 있을거같다. 아마도? 
	// 정산 화면에서 tableInit() 생성 후 테이블에 들어갈 데이터 생성자 (구매번호, 거래일시, 계산금액, 주문내역, 회원id)
	public AdminCalculateDao(int salesNo, Date purchaseInsertDate, int purchasePrice,
			String itemName, String userName) {
		super();
		this.salesNo = salesNo;
		this.purchaseInsertDate = purchaseInsertDate;
		this.purchasePrice = purchasePrice;
		this.itemName = itemName;
		this.userName = userName;
	}
	
	
	
	
	
	

	
	

	
	//--------Method
	
	
	// 1. 정산테이블에 띄워줄 구매내역 리스트 메소드 
	public ArrayList<AdminCalculateDto> getPurchaseList(String purchaseDate) {
        ArrayList<AdminCalculateDto> purchaseList = new ArrayList<>();

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			
			// 구매 내역 리스트에 들어갈 데이터 불러오는 쿼리문 
			String query = "SELECT p.salesNo, p.purchaseInsertDate, GROUP_CONCAT(i.itemName SEPARATOR ', '), SUM(p.purchasePrice), u.userName, u.userid  "
					+ " FROM purchase p"
					+ " INNER JOIN item i ON p.itemNo = i.itemNo "
					+ " INNER JOIN user u ON p.userid = u.userid "
					+ " WHERE DATE(purchaseInsertDate) = ?"
					+ " GROUP BY p.salesNo, p.purchaseInsertDate, u.userName, u.userid "; 		// 불러오고 싶은 데이터들 기반 sql 쿼리 작성 
			
			PreparedStatement ps = null;
			ps = conn_mysql.prepareStatement(query);
			
			 // 입력된 날짜를 형식에 맞게 변환
	        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        SimpleDateFormat queryDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        Date date = inputDateFormat.parse(purchaseDate);
	        String formattedDate = queryDateFormat.format(date);

	        ps.setString(1, formattedDate);

			//ps.setString(1, purchaseDate);
			
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int wkSaleNo = rs.getInt(1);
				String purchaseTimestamp = rs.getString(2);	// 시간 불러오는 형태 : 일 + 시:분:초 형태로 불러오도록 시키기 
//				SimpleDateFormat dateForm = new SimpleDateFormat("dd일 HH:mm:ss");
//				dateForm.setTimeZone(TimeZone.getTimeZone("UTC"));
//				Timestamp wkPurchaseDate = purchaseTimestamp;
				
				String wkItemName = rs.getString(3);
				int wkPurchasePrice = rs.getInt(4) ;
				String wkUserName = rs.getString(5);
				String wkUserId = rs.getString(6);
				
				AdminCalculateDto dto = new AdminCalculateDto(wkSaleNo, purchaseTimestamp, wkPurchasePrice, wkItemName, wkUserName, wkUserId);
				
				purchaseList.add(dto);
				//System.out.println("purchaseList Size : " + purchaseList.size());
			}
	
        } catch(Exception e) {
			e.printStackTrace();
		}
		return purchaseList;
	} 

	
	
	
	
	
	// 관리자가 마감 버튼을 눌러 오늘의 구매 내역 합계 계산 
	public void calculatePurchase() {
		int total = 0;
		
		
	

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	

}
