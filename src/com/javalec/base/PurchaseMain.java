package com.javalec.base;

import java.awt.EventQueue;
import java.util.ArrayList;

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
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

/* 기본 키오스크에서 주문 세부 내역 확인하고 결제 옵션 페이지로 보내주는 페이지. */
public class PurchaseMain extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane;
	private JTable innerTable;
	private JLabel lblback;
	private JLabel lblHere;
	private JLabel lblTakeout;

	int sum = 0;		// 계산 합계
	int count =0;		// 총 수량

	/**
	 * Launch the application.
	 */
	
	private final DefaultTableModel outerTable = new DefaultTableModel();
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_2;
	private JLabel lblNewLabel_2_3;
	private JLabel lblPay;
	private JLabel lblCount;
	private JLabel lblNewLabel_3;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchaseMain frame = new PurchaseMain();
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
	public PurchaseMain() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tableInit();
				searchAction();
			}
		});
		setTitle("주문 내역");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 900);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getScrollPane());
		contentPane.add(getLblback());
		contentPane.add(getLblHere());
		contentPane.add(getLblTakeout());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblNewLabel_2_1());
		contentPane.add(getLblNewLabel_2_2());
		contentPane.add(getLblNewLabel_2_3());
		contentPane.add(getLblPay());
		contentPane.add(getLblCount());
		contentPane.add(getLblNewLabel_3());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Sunshine Cafe");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			lblNewLabel.setBounds(175, 19, 282, 69);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("주문 세부내역을 다시 한번 확인해 주세요");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
			lblNewLabel_1.setBounds(40, 88, 531, 39);
		}
		return lblNewLabel_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 139, 613, 516);
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
	private JLabel getLblback() {
		if (lblback == null) {
			lblback = new JLabel("");

			ImageIcon icon = new ImageIcon(PurchaseMain.class.getResource("/com/javalec/image/cancle.png"));
			int x = 150;
			int y = 50;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backArrow = resize.imageResizing();
			
			lblback.setIcon(backArrow);
			lblback.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					redirecProductMain();
				}
			});
			lblback.setBounds(6, 758, 148, 69);
		}
		return lblback;
	}
	private JLabel getLblHere() {
		if (lblHere == null) {
			lblHere = new JLabel("");
			lblHere.setHorizontalAlignment(SwingConstants.CENTER);
			ImageIcon icon = new ImageIcon(PurchaseMain.class.getResource("/com/javalec/image/KakaoTalk_Photo_2023-05-15-14-46-58.png"));
			int x = 280;
			int y = 90;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backArrow = resize.imageResizing();
			
			lblHere.setIcon(backArrow);
			lblHere.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				
					PaymentMain main = new PaymentMain();
					main.setSum(sum);
					ShareVar.diningNo = 0;
					main.setVisible(true);
					dispose();
					
				}
			});
			lblHere.setBounds(219, 758, 229, 69);
		}
		return lblHere;
	}
	private JLabel getLblTakeout() {
		if (lblTakeout == null) {
			lblTakeout = new JLabel("");
			lblTakeout.setHorizontalAlignment(SwingConstants.CENTER);

			ImageIcon icon = new ImageIcon(PurchaseMain.class.getResource("/com/javalec/image/스크린샷_2023-05-15_오후_12.28.03-removebg-preview.png"));
			int x = 150;
			int y = 50;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backArrow = resize.imageResizing();
			
			lblTakeout.setIcon(backArrow);
			
			lblTakeout.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					PaymentMain main = new PaymentMain();
					main.setSum(sum);
					ShareVar.diningNo = 1;
					main.setVisible(true);
					dispose();
				}
			});
			lblTakeout.setBounds(460, 758, 159, 69);
		}
		return lblTakeout;
	}
	
	// ------- function
	
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
		ProductMain main = new ProductMain();
		main.setVisible(true);
		dispose();
		
	}
	

	
	
	
	
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("총 수량");
			lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lblNewLabel_2.setBounds(6, 661, 92, 39);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("개");
			lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lblNewLabel_2_1.setBounds(206, 661, 42, 39);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblNewLabel_2_2() {
		if (lblNewLabel_2_2 == null) {
			lblNewLabel_2_2 = new JLabel("총 결재금액");
			lblNewLabel_2_2.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lblNewLabel_2_2.setBounds(277, 661, 148, 39);
		}
		return lblNewLabel_2_2;
	}
	private JLabel getLblNewLabel_2_3() {
		if (lblNewLabel_2_3 == null) {
			lblNewLabel_2_3 = new JLabel("원");
			lblNewLabel_2_3.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lblNewLabel_2_3.setBounds(577, 661, 42, 39);
		}
		return lblNewLabel_2_3;
	}
	private JLabel getLblPay() {
		if (lblPay == null) {
			lblPay = new JLabel("");
			lblPay.setHorizontalAlignment(SwingConstants.TRAILING);
			lblPay.setForeground(new Color(255, 0, 0));
			lblPay.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lblPay.setBounds(423, 661, 148, 39);
		}
		return lblPay;
	}
	private JLabel getLblCount() {
		if (lblCount == null) {
			lblCount = new JLabel("");
			lblCount.setForeground(new Color(255, 0, 0));
			lblCount.setHorizontalAlignment(SwingConstants.TRAILING);
			lblCount.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lblCount.setBounds(162, 661, 42, 39);
		}
		return lblCount;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("");
	
			ImageIcon icon = new ImageIcon(PurchaseMain.class.getResource("/com/javalec/image/SunShineTeamLogoWhiteBackGround.png"));
			int x = 50;
			int y = 50;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backArrow = resize.imageResizing();
			
			lblNewLabel_3.setIcon(backArrow);
			lblNewLabel_3.setBounds(564, 6, 55, 57);
		}
		return lblNewLabel_3;
	}
}// end

