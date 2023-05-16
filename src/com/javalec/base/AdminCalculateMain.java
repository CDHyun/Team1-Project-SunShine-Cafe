package com.javalec.base;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import com.javalec.dao.AdminCalculateDao;
import com.javalec.dto.AdminCalculateDto;
import com.javalec.function.ImageResize;
import com.javalec.util.ShareVar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterJob;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

	LocalDate currentDate = LocalDate.now(); // 현재 날짜 받는 변수 초기화

	// 데이터 불러올 테이블 뼈대 초기화
	private final DefaultTableModel outerTable = new DefaultTableModel();

	// 초기 테이블 요약 정보 받아올 리스트
	ArrayList<AdminCalculateDto> beanList = null;

	static int salesNo; // 구매 번호 (주문순서)
	static Date purchaseDate; // 구매 날짜 및 시간
	static int purchasePrice; // 계산 금액 (제품수량(주문내역) * 금액)
	static String[] items; // 주문 내역
	static String userId; // 회원 아이디

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminCalculateMain frame = new AdminCalculateMain();
					frame.setLocationRelativeTo(null);
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
				searchAction();
			}
		});
		setTitle("관리자 페이지 - 매장 마감");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(248, 211, 72));

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

	private JLabel getLblBackImage() { // 관리자 홈 화면으로 돌아가는 이미지 레이블
		if (lblBackImage == null) {
			lblBackImage = new JLabel("");
			lblBackImage.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					redirectAdminMain();
				}
			});
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

	private JLabel getLblCalculate() { // 정산페이지 제목
		if (lblCalculate == null) {
			lblCalculate = new JLabel("정산");
			lblCalculate.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
			lblCalculate.setHorizontalAlignment(SwingConstants.CENTER);
			lblCalculate.setBounds(0, 10, 625, 50);
		}
		return lblCalculate;
	}

	private JLabel getLblDate() { // 정산페이지 현재 날짜
		if (lblDate == null) {
			lblDate = new JLabel("날짜");
			lblDate.setHorizontalAlignment(SwingConstants.CENTER);
			lblDate.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
			lblDate.setBounds(0, 65, 625, 40);
		}
		return lblDate;
	}

	private JButton getBtnYesterday() { // 전날 날짜로 넘겨주는 버튼
		if (btnYesterday == null) {
			btnYesterday = new JButton("");
			btnYesterday.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setDate();
					currentDate = currentDate.minusDays(1);
					lblDate.setText(currentDate.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일")));
					tableInit();
					searchAction();
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

	private JButton getBtnTomorrow() { // 다음날 날짜로 넘겨주는 버튼
		if (btnTomorrow == null) {
			btnTomorrow = new JButton("");
			btnTomorrow.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setDate();
					currentDate = currentDate.plusDays(1);
					lblDate.setText(currentDate.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일")));
					tableInit();
					searchAction();
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

	private JScrollPane getScrollPane() { // 매출 내역 보여줄 표의 뼈대 테이블
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 120, 585, 450);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}

	private JTable getInnerTable() { // 매출 내역 보여줄 내부 표
		if (innerTable == null) {
			innerTable = new JTable();
			innerTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableClick();
				}
			});
			innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTable.setModel(outerTable); // 뼈대와 데이터 불러올 테이블 결합
		}
		return innerTable;
	}

	private JButton getBtnBillReprint() { // 영수증 재출력 버튼
		if (btnBillReprint == null) {
			btnBillReprint = new JButton("영수증 재출력");
			btnBillReprint.setEnabled(false);
			btnBillReprint.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					reprintBill();
				}
			});
			btnBillReprint.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			btnBillReprint.setBounds(50, 600, 250, 60);
		}
		return btnBillReprint;
	}

	private JButton getBtnOrderCancel() { // 주문 취소 버튼 : 내부테이블에서 주문 내역 선택후 버튼 클릭시 확인창과 함께 취소 수행
		if (btnOrderCancel == null) {
			btnOrderCancel = new JButton("주문 취소");
			btnOrderCancel.setEnabled(false);
			btnOrderCancel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					cancelPurchase();
					tableInit();
					searchAction();
				}
			});
			btnOrderCancel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			btnOrderCancel.setBounds(325, 600, 250, 60);
		}
		return btnOrderCancel;
	}

	private JButton getBtnCalculate() { // 매장 마감 버튼 : 클릭시 데이터베이스에서 그 날 하루의 총 매출액을 뽑아주고 창을 종료함.
		if (btnCalculate == null) {
			btnCalculate = new JButton("마감");
			btnCalculate.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					 showTodayTotal();
				}
			});
			btnCalculate.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			btnCalculate.setBounds(170, 680, 255, 80);
		}
		return btnCalculate;
	}

	// -----------function----------------------------

	private void redirectAdminMain() { // 관리자 메인 화면으로 돌려보내주는 메소드
		AdminMain main = new AdminMain();
		main.setLocationRelativeTo(null);
		main.setVisible(true);
		dispose();
	}

	private void setDate() { // 날짜 세팅하는 메소드
		// 현재 날짜 가져오기
		LocalDate currentDate = LocalDate.now();

		// 포맷 정의
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");

		// 포맷 적용
		String date = currentDate.format(formatter);
		lblDate.setText(date);

	}

	private void tableInit() { // 매출 내역 테이블 초기화 - 구조 만들기
		outerTable.addColumn("No"); // 구매 번호
		outerTable.addColumn("거래 시간"); // 구매 날짜 & 시간 (일 + 시 분 초 형태)
		outerTable.addColumn("계산금액"); // 총 구매 금액
		outerTable.addColumn("주문내역"); // 주문한 음료들 내역
		outerTable.addColumn("회원 ID"); // 주문한 회원 아이디
		outerTable.setColumnCount(5);

		// 이전에 테이블에 추가된 데이터를 모두 지우고 빈 테이블 상태로 만들기
		int i = outerTable.getRowCount(); // 현재 행 개수(데이터 개수) 세기
		for (int j = 0; j < i; j++) {
			outerTable.removeRow(0); // 테이블 데이터 지우기
		}

		// Inner table : 데이터 보여주는 부분.
		innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF); // 데이터 크기에 따라 열 크기가 변하게 하지 않겠다(off)

		// 순서에 대한 데이터 들어감. (주문번호)
		int vColIndex = 0;
		TableColumn col = innerTable.getColumnModel().getColumn(vColIndex); // 제일 첫 번째 테이블 정의
		int width = 40;
		col.setPreferredWidth(width); // 첫번째 칼럼 폭 크기 정하기.

		// 거래 일시
		vColIndex = 1;
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 150;
		col.setPreferredWidth(width); // 두번째 칼럼 폭 크기 정하기. (칼럼 폭은 실행해보면서 자기가 맞춰보는걸로)

		// 계산 (결제) 금액
		vColIndex = 2;
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 80;
		col.setPreferredWidth(width);

		// 주문 내역
		vColIndex = 3;
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 220;
		col.setPreferredWidth(width);

		// 회원명(회원아이디)
		vColIndex = 4;
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 80;
		col.setPreferredWidth(width);

		// 테이블의 칼럼명 및 데이터들 중앙정렬 시키기
		// 테이블의 DefaultTableCellRenderer를 생성
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER); // 데이터를 중앙정렬

		// 테이블 칼럼의 DefaultTableCellRenderer를 생성
		DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) innerTable.getTableHeader()
				.getDefaultRenderer();
		headerRenderer.setHorizontalAlignment(JLabel.CENTER); // 칼럼명을 중앙정렬

		// 테이블에 DefaultTableCellRenderer를 적용
		innerTable.setDefaultRenderer(Object.class, centerRenderer); // Object.class는 데이터 모델의 타입에 맞게 설정해주세요.

		// 테이블 칼럼에 DefaultTableCellRenderer를 적용
		innerTable.getTableHeader().setDefaultRenderer(headerRenderer);

	}

	private void searchAction() { // 테이블에 입력할 데이터 다오에서 받아오기
		beanList = new ArrayList<AdminCalculateDto>();
		AdminCalculateDao dao = new AdminCalculateDao();
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String inputDateString = currentDate.format(inputFormatter);
		// System.out.println("입력 포맷: " + inputDateString);

		beanList = dao.getPurchaseList(inputDateString);

		int listCount = beanList.size();

		int seqno=0 ; // 테이블에 불러올 순서 
		for (int i = 0; i < listCount; i++) {
			
			seqno ++;
			String seq = Integer.toString(seqno);
			String salesNo = Integer.toString(beanList.get(i).getSalesNo());// db에서 데이터 불러오는 순서 (나중의 조건절 검색을 위해 추가함)
			try {
				String inserDate = beanList.get(i).getPurchaseInsertDate();
//				SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//				SimpleDateFormat outputFormat = new SimpleDateFormat("dd일 HH:mm:ss");
//				Date parsedDate = inputFormat.parse(date);
//				String formattedDate = outputFormat.format(parsedDate);
//				parsedDate = inputFormat.parse(date);

				String purchasePrice = Integer.toString(beanList.get(i).getPurchasePrice());
				String itemName = beanList.get(i).getItemName();
				String userName = beanList.get(i).getUserName();

				SimpleDateFormat dateForm = new SimpleDateFormat("dd일 HH:mm:ss");
				dateForm.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));

				String[] qTxt = { seq, inserDate, purchasePrice, itemName, userName };
				outerTable.addRow(qTxt);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void tableClick() {
		try {
			int i = innerTable.getSelectedRow();
			int selectNo = Integer.parseInt((String) innerTable.getValueAt(i, 0));
			btnBillReprint.setEnabled(true);
			btnOrderCancel.setEnabled(true);
		} catch (Exception e) {

		}
	}

	private void reprintBill() {
		try {
			int i = innerTable.getSelectedRow();
			AdminCalculateDao adminCalculateDao = new AdminCalculateDao();
			// 관리자가 데이터를 선택하지 않고 영수증재출력 버튼을 눌렀을 때
			if (i == -1) {
				JOptionPane.showMessageDialog(this, "재출력 할 구매 내역을 선택해주세요! ", "ERROR", JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			// 관리자가 데이터를 선택한 후 영수증 재출력 버튼을 눌렀을 때
			//salesNo = Integer.parseInt((String) innerTable.getValueAt(i, 0));
			//Locale locale = new Locale("ko", "KR");
			String insertDate = (String)innerTable.getValueAt(i, 1);
//			SimpleDateFormat inputFormat = new SimpleDateFormat("dd일 HH:mm:ss");
//			SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");
//
//			// 입력받은 문자열을 원래의 datetime 타입으로 파싱
//			Date parsedDate = inputFormat.parse(formattedDate);
//
//			// 원하는 형태로 포맷 지정하여 출력
//			String formattedOutputDate = outputFormat.format(parsedDate);
//			System.out.println("다시 포맷팅된 날짜: " + formattedOutputDate);
//
//			// 포맷팅된 날짜를 다시 원래 datetime 타입으로 파싱
//			Date originalDate = outputFormat.parse(formattedOutputDate);
//			System.out.println("원래 datetime 타입의 날짜: " + originalDate);
//			
//			//Date parsedDate = inputFormat.parse(formattedDate);
//			String date = outputFormat.format(parsedDate);
//			parsedDate = inputFormat.parse(date);

			ArrayList<AdminCalculateDto> beanList = adminCalculateDao.getSelectedPurchaseData(insertDate);
			int result = JOptionPane.showConfirmDialog(this, "영수증을 재출력 할까요?", "확인", JOptionPane.YES_NO_OPTION);

			if (result == 0) { // Yes 버튼을 눌렀을 때 수행할 코드 - ****** 구매 내역들 주르륵 나오게 하기
				
				adminCalculateDao.printReceipt(beanList);

			} else { // No 버튼을 눌렀을 때 수행할 코드 - 팝업 창 닫기
				JOptionPane.getRootFrame().setVisible(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	// 4. 주문 취소 버튼 : 내부테이블에서 주문 내역 선택후 버튼 클릭시 확인창과 함께 취소 수행
	private void cancelPurchase() {
		AdminCalculateDao dao = new AdminCalculateDao();		
		int i = innerTable.getSelectedRow();
		int salesNo = Integer.parseInt((String)innerTable.getValueAt(i, 0));
		String insertDate =  (String)innerTable.getValueAt(i, 1);
		String userid = beanList.get(i).getUserid();
		System.out.println(userid);
		
		try {

			// 관리자가 데이터를 선택하지 않고 주문취소 버튼을 눌렀을 때
			if (i == -1) {
				JOptionPane.showMessageDialog(this, "취소 할 구매 내역을 선택해주세요! ", "ERROR", JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			// 관리자가 데이터를 선택한 후 주문 취소 버튼을 눌렀을 때
			salesNo = Integer.parseInt((String) innerTable.getValueAt(i, 0));
			int result = JOptionPane.showConfirmDialog(this, "구매 내역을 취소 할까요?", "확인", JOptionPane.YES_NO_OPTION);

			if (result == JOptionPane.YES_OPTION) { // Yes 버튼을 눌렀을 때 수행할 코드 - ****** 구매 내역들 주르륵 나오게 하기
				int check = JOptionPane.showConfirmDialog(this, "정말 취소하십니까? 이 작업은 되돌릴 수 없습니다.", "WARNING", JOptionPane.YES_NO_OPTION);
				if (check == JOptionPane.YES_OPTION) {
					boolean wkResult = dao.getDeletedPurchaseData(insertDate, userid);
					if(!wkResult) {
						JOptionPane.showMessageDialog(this, "상품 삭제에 실패했습니다. ", "ERROR", JOptionPane.INFORMATION_MESSAGE);
					} else {
						tableInit();
						searchAction();
					}
					
				}
			} else { // No 버튼을 눌렀을 때 수행할 코드 - 팝업 창 닫기
				JOptionPane.getRootFrame().setVisible(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	// 매장 마감 버튼 : 클릭시 데이터베이스에서 그 날 하루의 총 매출액을 뽑아주고 창을 종료함. 
	private void showTodayTotal() {
		AdminCalculateDao dao = new AdminCalculateDao();
		
        // 날짜를 문자열로 변환
        String dateString = currentDate.toString();
        
        // 구매 내역을 가져옴
        ArrayList<AdminCalculateDto> purchaseList = dao.getPurchaseList(dateString);
        
        // 판매 금액 총 합을 계산
        int salesTotal = dao.calculateSalesTotal(purchaseList);
        
        // 정산 금액 출력
        JOptionPane.showMessageDialog(this,"========== 정 산 ==========\n출력일시 : " + currentDate + "\n오늘의 정산 금액 : " + salesTotal + "원\n========================") ;
        ShareVar.salesNo = 0;
        
        // 종료 여부 확인
        int confirm = JOptionPane.showConfirmDialog(this, "프로그램을 종료하시겠습니까?", "프로그램 종료", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            // 프로그램 종료
            dispose();
        }
		
	}
	

// END

}
