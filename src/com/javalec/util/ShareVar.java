package com.javalec.util;

public class ShareVar {


		public static final String DBName = "jdbc:mysql://127.0.0.1/sunshine?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
		/* 팀장 IP */
//		public static final String DBName = "jdbc:mysql://192.168.40.170/sunshine?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
		/* DB 계정 */
		public static final String DBUser = "root";
		/* DB 비밀번호 */
		public static final String DBPass = "qwer1234";
		
		/* Login User */
		public static String userid;
		
		public static int tableNo = 1;
		
		// 주문 번호
		public static int salesNo;
		
		// 매장, 포장
		public static int diningNo = 1;
	
}
