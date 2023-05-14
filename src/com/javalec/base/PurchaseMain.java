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

	/**
	 * Launch the application.
	 */
	
	private final DefaultTableModel outerTable = new DefaultTableModel();
	
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getScrollPane());
		contentPane.add(getLblback());
		contentPane.add(getLblHere());
		contentPane.add(getLblTakeout());
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
			scrollPane.setBounds(6, 139, 613, 580);
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
			lblback = new JLabel("돌아가기");
			lblback.setBounds(16, 811, 61, 16);
		}
		return lblback;
	}
	private JLabel getLblHere() {
		if (lblHere == null) {
			lblHere = new JLabel("먹고가기");
			lblHere.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					redirecPaymentMain();
				}
			});
			lblHere.setBounds(259, 811, 61, 16);
		}
		return lblHere;
	}
	private JLabel getLblTakeout() {
		if (lblTakeout == null) {
			lblTakeout = new JLabel("포장하기");
			lblTakeout.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					redirecPaymentMain();
				}
			});
			lblTakeout.setBounds(558, 811, 61, 16);
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
		int count = list.size();
		System.out.println(count);
		
		for(int i = 0 ; i < count ; i ++) {
			num++;
			String menuName = list.get(i).getItemName();
			int menuQty = list.get(i).getCartQty();
			int menuPrice = list.get(i).getCartOptionPrice();

			
			Object[] tempData = {num, menuName, menuQty, menuPrice};
			outerTable.addRow(tempData);
		}
		
		
		
	}
	
	private void redirecPaymentMain() {
		PaymentMain main = new PaymentMain();
		main.setVisible(true);
		dispose();
		
	}
	
	
	
	
	
	
}// end

