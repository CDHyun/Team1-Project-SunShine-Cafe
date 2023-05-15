package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.PurchaseMainDao;
import com.javalec.dto.PurchaseMainDto;
import com.javalec.function.ImageResize;
import com.javalec.util.ShareVar;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

/* 기본 키오스크에서 주문 세부 내역 확인하고 결제 옵션 페이지로 보내주는 페이지. */
public class StudyPurchaseMain extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblCount;
	private JLabel lblNewLabel_2_2;
	private JLabel lblPay;
	private JLabel lblNewLabel_2_3;
	private JLabel lblback;
	private JLabel lblHere;
	private JScrollPane scrollPane;
	private JTable innerTable;
	
	int sum = 0;		// 계산 합계
	int count =0;		// 총 수량

	
	private final DefaultTableModel outerTable = new DefaultTableModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudyPurchaseMain frame = new StudyPurchaseMain();
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
	public StudyPurchaseMain() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tableInit();
				searchAction();
			}
		});
		setTitle("주문 내역");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 750);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblNewLabel_2_1());
		contentPane.add(getLblCount());
		contentPane.add(getLblNewLabel_2_2());
		contentPane.add(getLblPay());
		contentPane.add(getLblNewLabel_2_3());
		contentPane.add(getLblback());
		contentPane.add(getLblHere());
		contentPane.add(getScrollPane());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Sunshine Cafe");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			lblNewLabel.setBounds(305, 6, 282, 69);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("주문 세부내역을 다시 한번 확인해 주세요");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
			lblNewLabel_1.setBounds(173, 64, 531, 39);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("총 수량");
			lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lblNewLabel_2.setBounds(204, 586, 92, 39);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("개");
			lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lblNewLabel_2_1.setBounds(441, 586, 42, 39);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblCount() {
		if (lblCount == null) {
			lblCount = new JLabel("");
			lblCount.setHorizontalAlignment(SwingConstants.TRAILING);
			lblCount.setForeground(Color.RED);
			lblCount.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lblCount.setBounds(398, 586, 42, 39);
		}
		return lblCount;
	}
	private JLabel getLblNewLabel_2_2() {
		if (lblNewLabel_2_2 == null) {
			lblNewLabel_2_2 = new JLabel("총 결재금액");
			lblNewLabel_2_2.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lblNewLabel_2_2.setBounds(522, 586, 148, 39);
		}
		return lblNewLabel_2_2;
	}
	private JLabel getLblPay() {
		if (lblPay == null) {
			lblPay = new JLabel("");
			lblPay.setHorizontalAlignment(SwingConstants.TRAILING);
			lblPay.setForeground(Color.RED);
			lblPay.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lblPay.setBounds(700, 586, 148, 39);
		}
		return lblPay;
	}
	private JLabel getLblNewLabel_2_3() {
		if (lblNewLabel_2_3 == null) {
			lblNewLabel_2_3 = new JLabel("원");
			lblNewLabel_2_3.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lblNewLabel_2_3.setBounds(852, 586, 42, 39);
		}
		return lblNewLabel_2_3;
	}
	private JLabel getLblback() {
		if (lblback == null) {
			lblback = new JLabel("");
		
			ImageIcon icon = new ImageIcon(PurchaseMain.class.getResource("/com/javalec/image/스크린샷_2023-05-15_오후_12.25.59-removebg-preview 복사본.png"));
			int x = 150;
			int y = 65;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backArrow = resize.imageResizing();
			
			lblback.setIcon(backArrow);
			lblback.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					redirecProductMain();
				}
			});
			lblback.setBounds(20, 647, 184, 69);
		}
		return lblback;
	}
	private JLabel getLblHere() {
		if (lblHere == null) {
			lblHere = new JLabel("");

			ImageIcon icon = new ImageIcon(PurchaseMain.class.getResource("/com/javalec/image/KakaoTalk_Photo_2023-05-15-14-46-58.png"));
			int x = 230;
			int y = 110;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backArrow = resize.imageResizing();
			
			lblHere.setIcon(backArrow);
			lblHere.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					StudyPaymentMain main = new StudyPaymentMain();
					main.setSum(sum);
					ShareVar.diningNo = 0;
					main.setVisible(true);
					dispose();
					
				}
			});
			lblHere.setBounds(698, 647, 185, 69);
		}
		return lblHere;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 115, 888, 459);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}
	private JTable getInnerTable() {
		if (innerTable == null) {
			innerTable = new JTable();
			innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTable.setModel(outerTable);
			innerTable.setRowHeight(50);
		}
		return innerTable;
	}
	
	private void tableInit() {
		int vColIndex = 0;
		int width = 0;
		
		outerTable.addColumn("No");
		outerTable.addColumn("메뉴");
		outerTable.addColumn("수량");
		outerTable.addColumn("가격");
		outerTable.setColumnCount(4);
		
		int i = outerTable.getColumnCount();
		
		innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF);
		
		// no
		vColIndex = 0;
		TableColumn col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);
		
		vColIndex = 1;
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 230;
		col.setPreferredWidth(width);
		
		vColIndex = 2;
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
		
		vColIndex = 3;
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 225;
		col.setPreferredWidth(width);
		
	}
	
	
	private void searchAction() {
		ArrayList<PurchaseMainDto> list = new ArrayList<PurchaseMainDto>();
		PurchaseMainDao dao = new PurchaseMainDao();
		list = dao.purchaseList();
		int num = 0;
		sum = 0;
		count = list.size();
		
		for(int i = 0 ; i < count ; i ++) {
			num++;
			String menuName = list.get(i).getItemName();
			int menuQty = list.get(i).getCartQty();
			int menuPrice = list.get(i).getCartOptionPrice();
			sum += menuPrice;
			
			Object[] tempData = {num, menuName, menuQty, menuPrice};
			outerTable.addRow(tempData);
		}
			lblCount.setText(Integer.toString(count));
			lblPay.setText(Integer.toString(sum));
		
	}

	
	private void redirecProductMain() {
		StudyProductMain main = new StudyProductMain();
		main.setVisible(true);
		dispose();
		
	}
	
}// end

