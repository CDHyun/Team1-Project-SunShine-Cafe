package com.javalec.base;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import com.javalec.dto.AdminCalculateDto;
import com.javalec.function.ImageResize;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;

public class AdminCalculateMain extends JFrame {

	private JPanel contentPane;
	private JLabel lblBackImage;
	private JLabel lblCalculate;
	private JLabel lblDate;
	private JScrollPane scrollPane;
	private JTable innerTable;
	private JButton btnBillReprint;
	private JButton btnOrderCancel;
	private JButton btnCalculate;
	private JButton btnYesterday;
	private JButton btnTomorrow;
	
	
	LocalDate currentDate = LocalDate.now() ; 		// 현재 날짜 받는 변수 초기화 
	
	// 데이터 불러올 테이블 뼈대 초기화 
	private final DefaultTableModel outerTable = new DefaultTableModel();
	// 초기 테이블 요약 정보 받아올 리스트
	ArrayList<AdminCalculateDto> beanList = null; 		
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminCalculateMain frame = new AdminCalculateMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminCalculateMain() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				setDate();
				tableInit();
			}
		});
		setTitle("관리자 페이지 - 매장 마감");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblBackImage());
		contentPane.add(getLblCalculate());
		contentPane.add(getLblDate());
		contentPane.add(getBtnYesterday());
		contentPane.add(getBtnTomorrow());
		contentPane.add(getScrollPane());
		contentPane.add(getBtnBillReprint());
		contentPane.add(getBtnOrderCancel());
		contentPane.add(getBtnCalculate());
	}
	private JLabel getLblBackImage() { 		// 관리자 홈 화면으로 돌아가는 이미지 레이블 
		if (lblBackImage == null) {
			lblBackImage = new JLabel("");
			ImageIcon icon = new ImageIcon(AdminCalculateMain.class.getResource("/com/javalec/image/back.png"));
			int x = 50;
			int y = 50;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backPage = resize.imageResizing();
			
			lblBackImage.setIcon(backPage);
			lblBackImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblBackImage.setBounds(5, 0, 70, 70);
		}
		return lblBackImage;
	}
	private JLabel getLblCalculate() { 		// 정산페이지 제목 
		if (lblCalculate == null) {
			lblCalculate = new JLabel("정산");
			lblCalculate.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
			lblCalculate.setHorizontalAlignment(SwingConstants.CENTER);
			lblCalculate.setBounds(0, 10, 625, 50);
		}
		return lblCalculate;
	}
	private JLabel getLblDate() { 		// 정산페이지 현재 날짜 
		if (lblDate == null) {
			lblDate = new JLabel("날짜");
			lblDate.setHorizontalAlignment(SwingConstants.CENTER);
			lblDate.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
			lblDate.setBounds(0, 65, 625, 40);
		}
		return lblDate;
	}
	private JButton getBtnYesterday() { 		// 전날 날짜로 넘겨주는 버튼 
		if (btnYesterday == null) {
			btnYesterday = new JButton("");
			btnYesterday.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setDate();
					currentDate = currentDate.minusDays(1);
					lblDate.setText(currentDate.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일")));
				}
			});
			
			ImageIcon icon = new ImageIcon(AdminCalculateMain.class.getResource("/com/javalec/image/leftBtn.png"));
			int x = 70;
			int y = 70;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon yesterday = resize.imageResizing();
			
			btnYesterday.setIcon(yesterday);
			btnYesterday.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			btnYesterday.setBounds(70, 70, 70, 30);
		}
		return btnYesterday;
	}
	private JButton getBtnTomorrow() { 		// 다음날 날짜로 넘겨주는 버튼 
		if (btnTomorrow == null) {
			btnTomorrow = new JButton("");
			btnTomorrow.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setDate();
					currentDate = currentDate.plusDays(1);
					lblDate.setText(currentDate.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일")));
				}
			});
			ImageIcon icon = new ImageIcon(AdminCalculateMain.class.getResource("/com/javalec/image/rightBtn.png"));
			int x = 70;
			int y = 70;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon tomorrow = resize.imageResizing();
			
			btnTomorrow.setIcon(tomorrow);
			btnTomorrow.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			btnTomorrow.setBounds(485, 70, 70, 30);
		}
		return btnTomorrow;
	}
	private JScrollPane getScrollPane() { 		// 매출 내역 보여줄 표의 뼈대 테이블 
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 120, 585, 450);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}
	private JTable getInnerTable() { 		// 매출 내역 보여줄 내부 표 
		if (innerTable == null) {
			innerTable = new JTable();
			innerTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableClick();
				}
			});
			innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTable.setModel(outerTable); 		// 뼈대와 데이터 불러올 테이블 결합 
		}
		return innerTable;
	}
	private JButton getBtnBillReprint() { 		// 영수증 재출력 버튼 
		if (btnBillReprint == null) {
			btnBillReprint = new JButton("영수증 재출력");
			btnBillReprint.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			btnBillReprint.setBounds(50, 600, 250, 60);
		}
		return btnBillReprint;
	}
	private JButton getBtnOrderCancel() { 		// 주문 취소 버튼 : 내부테이블에서 주문 내역 선택후 버튼 클릭시 확인창과 함께 취소 수행 
		if (btnOrderCancel == null) {
			btnOrderCancel = new JButton("주문 취소");
			btnOrderCancel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			btnOrderCancel.setBounds(325, 600, 250, 60);
		}
		return btnOrderCancel;
	}
	private JButton getBtnCalculate() { 		// 매장 마감 버튼 : 클릭시 데이터베이스에서 그 날 하루의 총 매출액을 뽑아주고 창을 종료함. 
		if (btnCalculate == null) {
			btnCalculate = new JButton("마감");
			btnCalculate.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			btnCalculate.setBounds(170, 680, 255, 80);
		}
		return btnCalculate;
	}
	
	
	
	
	
	// -----------function----------------------------
	 
	private void setDate() { 		// 날짜 세팅하는 메소드 
		// 현재 날짜 가져오기 
		LocalDate currentDate = LocalDate.now();
		
		// 포맷 정의
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
		
		// 포맷 적용
		String date = currentDate.format(formatter);
		lblDate.setText(date);
		
	}
	
	private void tableInit() {		// 매출 내역 테이블 초기화하기 
		outerTable.addColumn("No"); 		// 구매 번호
		outerTable.addColumn("거래 시간");		// 구매 날짜 & 시간 (일 + 시 분 초 형태)
		outerTable.addColumn("계산금액"); 		// 총 구매 금액 
		outerTable.addColumn("주문내역"); 		// 주문한 음료들 내역 
		outerTable.addColumn("회원 ID"); 		// 주문한 회원 아이디 
		outerTable.setColumnCount(5);
		
		// 이전에 테이블에 추가된 데이터를 모두 지우고 빈 테이블 상태로 만들기 
		int i = outerTable.getRowCount(); 		// 현재 행 개수(데이터 개수) 세기
		for (int j=0; j<i; j++) {
			outerTable.removeRow(0); 		// 테이블 데이터 지우기
		} 
		
		// Inner table : 데이터 보여주는 부분.   
		innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF); 		// 데이터 크기에 따라 열 크기가 변하게 하지 않겠다(off)
		
		// 순서에 대한 데이터 들어감. (주문번호)
		int vColIndex = 0; 		
		TableColumn col = innerTable.getColumnModel().getColumn(vColIndex) ;		// 제일 첫 번째 테이블 정의 
		int width = 40; 
		col.setPreferredWidth(width); 		// 첫번째 칼럼 폭 크기 정하기. 
		
		// 거래 일시 
		vColIndex = 1; 			
		col = innerTable.getColumnModel().getColumn(vColIndex) ;
		width = 100; 
		col.setPreferredWidth(width); 		// 두번째 칼럼 폭 크기 정하기.  (칼럼 폭은 실행해보면서 자기가 맞춰보는걸로) 
		
		// 계산 (결제) 금액 
		vColIndex = 2; 				
		col =innerTable.getColumnModel().getColumn(vColIndex) ;
		width = 80; 
		col.setPreferredWidth(width); 	
		
		// 주문 내역 
		vColIndex = 3; 				
		col = innerTable.getColumnModel().getColumn(vColIndex) ;
		width = 280; 
		col.setPreferredWidth(width); 	
		
		// 회원명(회원아이디) 
		vColIndex = 4; 				
		col = innerTable.getColumnModel().getColumn(vColIndex) ;
		width = 80; 
		col.setPreferredWidth(width); 
	
		/* 테이블 칼럼들, 데이터들 중앙으로 정렬하고 싶었는데... 
		TableCellRenderer centerRenderer = new TableCellRenderer();
		centerRenderer.setHorizontalAlignment( SwingConstants.CENTER ); // 셀 가운데 정렬
		for(int j = 0; j < innerTable.getColumnCount(); j++){
		    innerTable.getColumnModel().getColumn(j).setCellRenderer(centerRenderer); 
		}	*/
	}
	
	
	/*
	private void searchAction() { 		// 테이블에 입력할 데이터 다오에서 받아오기 
		beanList = new ArrayList<AdminCalculateDto>();
		AdminCalculateDao dao = new AdminCalculateDao();
		beanList = dao.selectList();
		
		int listCount = beanList.size();
		
		for(int i = 0; i < listCount; i++) {
			String productCode = Integer.toString(beanList.get(i).getPurchaseNo());// db에서 데이터 불러오는 순서 (나중의 조건절 검색을 위해 추가함)
			String purchaseDate = beanList.get(i).getDate();
			int purchasePrice = beanList.get(i).getPrice();
			String productName = beanList.get(i).getProductName();
			String size = Integer.toString(beanList.get(i).getSize());
			String stock = Integer.toString(beanList.get(i).getProductStock());
			
			String[] qTxt = {productCode, brandName, productName, size, stock};
			outerTable.addRow(qTxt);
		}
	}*/
	
	
	
	private void tableClick() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
