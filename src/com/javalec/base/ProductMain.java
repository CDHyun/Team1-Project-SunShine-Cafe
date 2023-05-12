package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.javalec.dao.ProductDao;
import com.javalec.dto.ProductDto;
import com.javalec.function.ImageResize;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

/* 기본 키오스크에서 상품 메뉴들을 보여주는 페이지 */
public class ProductMain extends JFrame {

	private JPanel contentPane;
	private JLabel lblLeftBtn;
	private JLabel lblRightBtn;
	private JLabel lblItemSlot1;
	private JLabel lblItemSlot2;
	private JLabel lblItemSlot3;
	private JLabel lblItemSlot4;
	private JLabel lblItemSlot5;
	private JLabel lblItemSlot6;
	private JLabel lblProductName1;
	private JLabel lblProductPrice1;
	private JLabel lblProductName2;
	private JLabel lblProductPrice2;
	private JLabel lblProductName3;
	private JLabel lblProductPrice3;
	private JLabel lblProductName4;
	private JLabel lblProductPrice4;
	private JLabel lblProductName5;
	private JLabel lblProductPrice5;
	private JLabel lblProductName6;
	private JLabel lblProductPrice6;
	private JLabel lblTitle;
	private JLabel lblPayBtn;
	private JLabel lblTitle_1;
	private JLabel lblTitle_1_1;
	private JLabel lblQty;
	private JLabel lblCart;
	private JScrollPane scrollPane;
	private JTable innerTable;
	
	/* 전역 변수 */
	private ArrayList<ProductDto> beanList;
	
	/* Table */
	private final DefaultTableModel outerTable = new DefaultTableModel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductMain frame = new ProductMain();
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
	public ProductMain() {
		setTitle("상품 페이지");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 900);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 211, 72));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblProductName1());
		contentPane.add(getLblProductPrice1());
		contentPane.add(getLblProductName2());
		contentPane.add(getLblProductPrice2());
		contentPane.add(getLblProductName3());
		contentPane.add(getLblProductPrice3());
		contentPane.add(getLblProductName4());
		contentPane.add(getLblLeftBtn());
		contentPane.add(getLblRightBtn());
		contentPane.add(getLblProductPrice4());
		contentPane.add(getLblProductName5());
		contentPane.add(getLblProductPrice5());
		contentPane.add(getLblProductName6());
		contentPane.add(getLblProductPrice6());
		contentPane.add(getLblItemSlot5());
		contentPane.add(getLblItemSlot6());
		contentPane.add(getLblItemSlot4());
		contentPane.add(getLblItemSlot3());
		contentPane.add(getLblItemSlot2());
		contentPane.add(getLblItemSlot1());
		contentPane.add(getLblTitle());
		contentPane.add(getLblPayBtn());
		contentPane.add(getLblTitle_1());
		contentPane.add(getLblTitle_1_1());
		contentPane.add(getLblQty());
		contentPane.add(getLblCart());
		contentPane.add(getScrollPane());
	}
	private JLabel getLblLeftBtn() {
		if (lblLeftBtn == null) {
			lblLeftBtn = new JLabel("");
			ImageIcon icon = new ImageIcon(ProductMain.class.getResource("/com/javalec/image/leftBtn.png"));
			int x = 80;
			int y = 80;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon leftBtn = resize.imageResizing();
			lblLeftBtn.setIcon(leftBtn);
			lblLeftBtn.setBounds(6, 66, 91, 47);
		}
		return lblLeftBtn;
	}
	private JLabel getLblRightBtn() {
		if (lblRightBtn == null) {
			lblRightBtn = new JLabel("");
			ImageIcon icon = new ImageIcon(ProductMain.class.getResource("/com/javalec/image/rightBtn.png"));
			int x = 80;
			int y = 80;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon rightBtn = resize.imageResizing();
			lblRightBtn.setIcon(rightBtn);
			lblRightBtn.setBounds(534, 66, 91, 47);
		}
		return lblRightBtn;
	}
	

	/* ItemSlotLabel */
	private JLabel getLblItemSlot1() {
		if (lblItemSlot1 == null) {
			lblItemSlot1 = new JLabel("");
			ImageIcon icon = new ImageIcon(ProductMain.class.getResource("/com/javalec/image/itemSlot.png"));
			int x = 120;
			int y = 200;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon itemSlot = resize.imageResizing();
			lblItemSlot1.setIcon(itemSlot);
			lblItemSlot1.setHorizontalAlignment(SwingConstants.CENTER);
			lblItemSlot1.setVerticalAlignment(SwingConstants.CENTER);
			lblItemSlot1.setBounds(51, 168, 120, 200);

		}
		return lblItemSlot1;
	}
	private JLabel getLblItemSlot2() {
		if (lblItemSlot2 == null) {
			lblItemSlot2 = new JLabel("");
			ImageIcon icon = new ImageIcon(ProductMain.class.getResource("/com/javalec/image/itemSlot.png"));
			int x = 120;
			int y = 200;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon itemSlot = resize.imageResizing();
			lblItemSlot2.setIcon(itemSlot);
			lblItemSlot2.setHorizontalAlignment(SwingConstants.CENTER);
			lblItemSlot2.setVerticalAlignment(SwingConstants.CENTER);
			lblItemSlot2.setBounds(232, 168, 120, 200);
		}
		return lblItemSlot2;
	}
	private JLabel getLblItemSlot3() {
		if (lblItemSlot3 == null) {
			lblItemSlot3 = new JLabel("");
			ImageIcon icon = new ImageIcon(ProductMain.class.getResource("/com/javalec/image/itemSlot.png"));
			int x = 120;
			int y = 200;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon itemSlot = resize.imageResizing();
			lblItemSlot3.setIcon(itemSlot);
			lblItemSlot3.setHorizontalAlignment(SwingConstants.CENTER);
			lblItemSlot3.setVerticalAlignment(SwingConstants.CENTER);
			lblItemSlot3.setBounds(422, 168, 120, 200);
		}
		return lblItemSlot3;
	}
	private JLabel getLblItemSlot4() {
		if (lblItemSlot4 == null) {
			lblItemSlot4 = new JLabel("");
			ImageIcon icon = new ImageIcon(ProductMain.class.getResource("/com/javalec/image/itemSlot.png"));
			int x = 120;
			int y = 200;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon itemSlot = resize.imageResizing();
			lblItemSlot4.setIcon(itemSlot);
			lblItemSlot4.setHorizontalAlignment(SwingConstants.CENTER);
			lblItemSlot4.setVerticalAlignment(SwingConstants.CENTER);
			lblItemSlot4.setBounds(51, 399, 120, 200);
		}
		return lblItemSlot4;
	}
	private JLabel getLblItemSlot5() {
		if (lblItemSlot5 == null) {
			lblItemSlot5 = new JLabel("");
			ImageIcon icon = new ImageIcon(ProductMain.class.getResource("/com/javalec/image/itemSlot.png"));
			int x = 120;
			int y = 200;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon itemSlot = resize.imageResizing();
			lblItemSlot5.setIcon(itemSlot);
			lblItemSlot5.setHorizontalAlignment(SwingConstants.CENTER);
			lblItemSlot5.setVerticalAlignment(SwingConstants.CENTER);
			lblItemSlot5.setBounds(232, 399, 120, 200);
		}
		return lblItemSlot5;
	}
	private JLabel getLblItemSlot6() {
		if (lblItemSlot6 == null) {
			lblItemSlot6 = new JLabel("");
			ImageIcon icon = new ImageIcon(ProductMain.class.getResource("/com/javalec/image/itemSlot.png"));
			int x = 120;
			int y = 200;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon itemSlot = resize.imageResizing();
			lblItemSlot6.setIcon(itemSlot);
			lblItemSlot6.setHorizontalAlignment(SwingConstants.CENTER);
			lblItemSlot6.setVerticalAlignment(SwingConstants.CENTER);
			lblItemSlot6.setBounds(422, 399, 120, 200);
			
		}
		return lblItemSlot6;
	}
	

	private JLabel getLblProductName1() {
		if (lblProductName1 == null) {
			lblProductName1 = new JLabel("New label");
			lblProductName1.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductName1.setBounds(51, 323, 114, 16);
		}
		return lblProductName1;
	}
	private JLabel getLblProductPrice1() {
		if (lblProductPrice1 == null) {
			lblProductPrice1 = new JLabel("New label");
			lblProductPrice1.setForeground(new Color(208, 65, 58));
			lblProductPrice1.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductPrice1.setBounds(51, 345, 114, 16);
		}
		return lblProductPrice1;
	}
	private JLabel getLblProductName2() {
		if (lblProductName2 == null) {
			lblProductName2 = new JLabel("New label");
			lblProductName2.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductName2.setBounds(234, 323, 114, 16);
		}
		return lblProductName2;
	}
	private JLabel getLblProductPrice2() {
		if (lblProductPrice2 == null) {
			lblProductPrice2 = new JLabel("New label");
			lblProductPrice2.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductPrice2.setForeground(new Color(208, 65, 58));
			lblProductPrice2.setBounds(234, 345, 114, 16);
		}
		return lblProductPrice2;
	}
	private JLabel getLblProductName3() {
		if (lblProductName3 == null) {
			lblProductName3 = new JLabel("New label");
			lblProductName3.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductName3.setBounds(424, 323, 114, 16);
		}
		return lblProductName3;
	}
	private JLabel getLblProductPrice3() {
		if (lblProductPrice3 == null) {
			lblProductPrice3 = new JLabel("New label");
			lblProductPrice3.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductPrice3.setForeground(new Color(208, 65, 58));
			lblProductPrice3.setBounds(424, 345, 114, 16);
		}
		return lblProductPrice3;
	}
	private JLabel getLblProductName4() {
		if (lblProductName4 == null) {
			lblProductName4 = new JLabel("New label");
			lblProductName4.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductName4.setBounds(51, 555, 114, 16);
		}
		return lblProductName4;
	}
	
	private JLabel getLblProductPrice4() {
		if (lblProductPrice4 == null) {
			lblProductPrice4 = new JLabel("New label");
			lblProductPrice4.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductPrice4.setForeground(new Color(208, 65, 58));
			lblProductPrice4.setBounds(51, 577, 114, 16);
		}
		return lblProductPrice4;
	}
	private JLabel getLblProductName5() {
		if (lblProductName5 == null) {
			lblProductName5 = new JLabel("New label");
			lblProductName5.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductName5.setBounds(234, 555, 114, 16);
		}
		return lblProductName5;
	}
	private JLabel getLblProductPrice5() {
		if (lblProductPrice5 == null) {
			lblProductPrice5 = new JLabel("New label");
			lblProductPrice5.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductPrice5.setForeground(new Color(208, 65, 58));
			lblProductPrice5.setBounds(234, 577, 114, 16);
		}
		return lblProductPrice5;
	}
	private JLabel getLblProductName6() {
		if (lblProductName6 == null) {
			lblProductName6 = new JLabel("New label");
			lblProductName6.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductName6.setBounds(424, 555, 114, 16);
		}
		return lblProductName6;
	}
	private JLabel getLblProductPrice6() {
		if (lblProductPrice6 == null) {
			lblProductPrice6 = new JLabel("New label");
			lblProductPrice6.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductPrice6.setForeground(new Color(208, 65, 58));
			lblProductPrice6.setBounds(424, 577, 114, 16);
		}
		return lblProductPrice6;
	}
	private JLabel getLblTitle() {
		if (lblTitle == null) {
			lblTitle = new JLabel("SunShine Cafe");
			lblTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
			lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitle.setBounds(117, 6, 394, 47);
		}
		return lblTitle;
	}
	private JLabel getLblPayBtn() {
		if (lblPayBtn == null) {
			lblPayBtn = new JLabel("");
			lblPayBtn.setHorizontalAlignment(SwingConstants.CENTER);
			ImageIcon icon = new ImageIcon(ProductMain.class.getResource("/com/javalec/image/payBtn.png"));
			int x = 240;
			int y = 240;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon payBtn = resize.imageResizing();
			lblPayBtn.setIcon(payBtn);
			lblPayBtn.setBounds(424, 763, 182, 103);
		}
		return lblPayBtn;
	}
	private JLabel getLblTitle_1() {
		if (lblTitle_1 == null) {
			lblTitle_1 = new JLabel("선택한 상품");
			lblTitle_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitle_1.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 16));
			lblTitle_1.setBounds(424, 716, 91, 47);
		}
		return lblTitle_1;
	}
	private JLabel getLblTitle_1_1() {
		if (lblTitle_1_1 == null) {
			lblTitle_1_1 = new JLabel("개");
			lblTitle_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitle_1_1.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 16));
			lblTitle_1_1.setBounds(562, 716, 32, 47);
		}
		return lblTitle_1_1;
	}
	private JLabel getLblQty() {
		if (lblQty == null) {
			lblQty = new JLabel("0");
			lblQty.setForeground(new Color(255, 41, 0));
			lblQty.setHorizontalAlignment(SwingConstants.CENTER);
			lblQty.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
			lblQty.setBounds(509, 714, 61, 47);
		}
		return lblQty;
	}
	private JLabel getLblCart() {
		if (lblCart == null) {
			lblCart = new JLabel("");
			lblCart.setHorizontalAlignment(SwingConstants.TRAILING);
			lblCart.setVerticalAlignment(SwingConstants.BOTTOM);
			ImageIcon icon = new ImageIcon(ProductMain.class.getResource("/com/javalec/image/nemo.png"));
			int x = 420;
			int y = 200;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon cart = resize.imageResizing();
			lblCart.setIcon(cart);
			lblCart.setBounds(0, 648, 403, 224);
		}
		return lblCart;
	}
	

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 673, 394, 210);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}

	private JTable getInnerTable() {
		if (innerTable == null) {
			innerTable = new JTable();
			innerTable.setModel(outerTable);
		}
		return innerTable;
	}
	
	
	
	
	
	
	
	
	/********************** Functions **********************/
	private void queryDrinkAction() {
		beanList = new ArrayList<ProductDto>();
		ProductDao productDao = new ProductDao();
		beanList = productDao.selectDrinkList();
		
		int listCount = beanList.size();
		
		for(int i=0; i<listCount; i++) {
			ImageIcon icon = new ImageIcon("./" + beanList.get(i).getDrinkImageName());
			int x = 100;
			int y = 100;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon productIcon = resize.imageResizing();
			
		}
		
		
		
	}
	
	
	
	
}	// End Class
