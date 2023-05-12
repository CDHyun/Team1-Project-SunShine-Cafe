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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/* 기본 키오스크에서 상품 메뉴들을 보여주는 페이지 */
public class ProductMain extends JFrame {

	private JPanel contentPane;
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
	private JLabel lblPriviousBtn;
	private JLabel lblNextBtn;
	private JLabel lblProductImage1;
	private JLabel lblProductImage2;
	private JLabel lblProductImage3;
	private JLabel lblProductImage4;
	private JLabel lblProductImage5;
	private JLabel lblProductImage6;
	
	/* 전역 변수 */
	private ArrayList<ProductDto> beanList;
	private ImageIcon icon;
	private ImageIcon productIcon;
	private int currentPage = 0;
	private int categoryNo = 0;
	private int total = 0;
	
	/* JLabel 배열 생성 */
	
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
					frame.setResizable(false);
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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				lblBackGround1.setVisible(true);
				lblBackGround2.setVisible(false);
				lblBackGround3.setVisible(false);
				lblBackGround4.setVisible(false);
				lblBackGround5.setVisible(false);
				lblBackGround6.setVisible(false);
				lblPriviousBtn.setVisible(false);
				inIt();
				queryDrinkAction();
			}
		});
		setTitle("상품 페이지");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 900);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 211, 72));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblAll());
		contentPane.add(getLblProductImage6());
		contentPane.add(getLblProductImage5());
		contentPane.add(getLblProductImage4());
		contentPane.add(getLblProductImage3());
		contentPane.add(getLblProductImage2());
		contentPane.add(getLblProductImage1());
		contentPane.add(getLblProductName1());
		contentPane.add(getLblProductPrice1());
		contentPane.add(getLblProductName2());
		contentPane.add(getLblProductPrice2());
		contentPane.add(getLblProductName3());
		contentPane.add(getLblProductPrice3());
		contentPane.add(getLblProductName4());
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
		contentPane.add(getLblPriviousBtn());
		contentPane.add(getLblNextBtn());
		contentPane.add(getLblIce());
		contentPane.add(getLblJuice());
		contentPane.add(getLblTea());
		contentPane.add(getLblDessert());
		contentPane.add(getLblHot());
		contentPane.add(getLblBackGround1());
		contentPane.add(getLblBackGround2());
		contentPane.add(getLblBackGround3());
		contentPane.add(getLblBackGround4());
		contentPane.add(getLblBackGround5());
		contentPane.add(getLblBackGround6());
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
			lblItemSlot1.setBounds(66, 162, 120, 200);

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
			lblItemSlot2.setBounds(247, 162, 120, 200);
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
			lblItemSlot3.setBounds(436, 162, 120, 200);
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
			lblItemSlot4.setBounds(66, 393, 120, 200);
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
			lblItemSlot5.setBounds(251, 393, 120, 200);
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
			lblItemSlot6.setBounds(434, 393, 120, 200);
			
		}
		return lblItemSlot6;
	}
	

	private JLabel getLblProductName1() {
		if (lblProductName1 == null) {
			lblProductName1 = new JLabel("");
			lblProductName1.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductName1.setBounds(66, 317, 114, 16);
		}
		return lblProductName1;
	}
	private JLabel getLblProductPrice1() {
		if (lblProductPrice1 == null) {
			lblProductPrice1 = new JLabel("");
			lblProductPrice1.setForeground(new Color(208, 65, 58));
			lblProductPrice1.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductPrice1.setBounds(66, 339, 114, 16);
		}
		return lblProductPrice1;
	}
	private JLabel getLblProductName2() {
		if (lblProductName2 == null) {
			lblProductName2 = new JLabel("");
			lblProductName2.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductName2.setBounds(253, 317, 114, 16);
		}
		return lblProductName2;
	}
	private JLabel getLblProductPrice2() {
		if (lblProductPrice2 == null) {
			lblProductPrice2 = new JLabel("");
			lblProductPrice2.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductPrice2.setForeground(new Color(208, 65, 58));
			lblProductPrice2.setBounds(253, 339, 114, 16);
		}
		return lblProductPrice2;
	}
	private JLabel getLblProductName3() {
		if (lblProductName3 == null) {
			lblProductName3 = new JLabel("");
			lblProductName3.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductName3.setBounds(436, 317, 114, 16);
		}
		return lblProductName3;
	}
	private JLabel getLblProductPrice3() {
		if (lblProductPrice3 == null) {
			lblProductPrice3 = new JLabel("");
			lblProductPrice3.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductPrice3.setForeground(new Color(208, 65, 58));
			lblProductPrice3.setBounds(436, 339, 114, 16);
		}
		return lblProductPrice3;
	}
	private JLabel getLblProductName4() {
		if (lblProductName4 == null) {
			lblProductName4 = new JLabel("");
			lblProductName4.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductName4.setBounds(66, 549, 114, 16);
		}
		return lblProductName4;
	}
	
	private JLabel getLblProductPrice4() {
		if (lblProductPrice4 == null) {
			lblProductPrice4 = new JLabel("");
			lblProductPrice4.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductPrice4.setForeground(new Color(208, 65, 58));
			lblProductPrice4.setBounds(66, 571, 114, 16);
		}
		return lblProductPrice4;
	}
	private JLabel getLblProductName5() {
		if (lblProductName5 == null) {
			lblProductName5 = new JLabel("");
			lblProductName5.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductName5.setBounds(253, 549, 114, 16);
		}
		return lblProductName5;
	}
	private JLabel getLblProductPrice5() {
		if (lblProductPrice5 == null) {
			lblProductPrice5 = new JLabel("");
			lblProductPrice5.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductPrice5.setForeground(new Color(208, 65, 58));
			lblProductPrice5.setBounds(253, 571, 114, 16);
		}
		return lblProductPrice5;
	}
	private JLabel getLblProductName6() {
		if (lblProductName6 == null) {
			lblProductName6 = new JLabel("");
			lblProductName6.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductName6.setBounds(436, 549, 114, 16);
		}
		return lblProductName6;
	}
	private JLabel getLblProductPrice6() {
		if (lblProductPrice6 == null) {
			lblProductPrice6 = new JLabel("");
			lblProductPrice6.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductPrice6.setForeground(new Color(208, 65, 58));
			lblProductPrice6.setBounds(436, 571, 114, 16);
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
	
	/* 상품 메뉴 페이지 뒤로 가기 버튼 */
	private JLabel getLblPriviousBtn() {
		if (lblPriviousBtn == null) {
			lblPriviousBtn = new JLabel("");
			lblPriviousBtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					priviousPage();
				}
			});
			ImageIcon icon = new ImageIcon(ProductMain.class.getResource("/com/javalec/image/previousPageBtn.png"));
			int x = 120;
			int y = 170;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon privousBtn = resize.imageResizing();
			lblPriviousBtn.setIcon(privousBtn);
			lblPriviousBtn.setBounds(0, 316, 54, 116);
		}
		return lblPriviousBtn;
	}
	
	/* 상품 메뉴 페이지 앞으로 가기 버튼 */
	private JLabel getLblNextBtn() {
		if (lblNextBtn == null) {
			lblNextBtn = new JLabel("");
			lblNextBtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					nextPage();
				}
			});
			ImageIcon icon = new ImageIcon(ProductMain.class.getResource("/com/javalec/image/nextPageBtn.png"));
			int x = 120;
			int y = 170;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon nextBtn = resize.imageResizing();
			lblNextBtn.setIcon(nextBtn);
			lblNextBtn.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNextBtn.setBounds(571, 316, 54, 116);
		}
		return lblNextBtn;
	}
	private JLabel getLblProductImage1() {
		if (lblProductImage1 == null) {
			lblProductImage1 = new JLabel("");
			ImageIcon icon = new ImageIcon(ProductMain.class.getResource("/com/javalec/image/IceWaterMelon.png"));
			int x = 100;
			int y = 120;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon productImage1 = resize.imageResizing();
			lblProductImage1.setIcon(null);
			lblProductImage1.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductImage1.setBounds(66, 183, 120, 124);
		}
		return lblProductImage1;
	}
	private JLabel getLblProductImage2() {
		if (lblProductImage2 == null) {
			lblProductImage2 = new JLabel("");
			lblProductImage2.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductImage2.setBounds(247, 183, 120, 124);
		}
		return lblProductImage2;
	}
	private JLabel getLblProductImage3() {
		if (lblProductImage3 == null) {
			lblProductImage3 = new JLabel("");
			lblProductImage3.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductImage3.setBounds(434, 183, 120, 124);
		}
		return lblProductImage3;
	}
	private JLabel getLblProductImage4() {
		if (lblProductImage4 == null) {
			lblProductImage4 = new JLabel("");
			lblProductImage4.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductImage4.setBounds(66, 413, 120, 124);
		}
		return lblProductImage4;
	}
	private JLabel getLblProductImage5() {
		if (lblProductImage5 == null) {
			lblProductImage5 = new JLabel("");
			lblProductImage5.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductImage5.setBounds(251, 413, 120, 124);
		}
		return lblProductImage5;
	}
	private JLabel getLblProductImage6() {
		if (lblProductImage6 == null) {
			lblProductImage6 = new JLabel("");
			lblProductImage6.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductImage6.setBounds(434, 413, 120, 124);
		}
		return lblProductImage6;
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
	
	private JLabel getLblAll() {
		if (lblAll == null) {
			lblAll = new JLabel("전체 메뉴");
			lblAll.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblIce.setForeground(Color.BLACK);
					lblHot.setForeground(Color.BLACK);
					lblJuice.setForeground(Color.BLACK);
					lblTea.setForeground(Color.BLACK);
					lblDessert.setForeground(Color.BLACK);
					lblBackGround1.setVisible(true);
					lblBackGround2.setVisible(false);
					lblBackGround3.setVisible(false);
					lblBackGround4.setVisible(false);
					lblBackGround5.setVisible(false);
					lblBackGround6.setVisible(false);
					lblAll.setForeground(Color.WHITE);
					queryDrinkAction();
				}
			});
			lblAll.setForeground(Color.WHITE);
			lblAll.setHorizontalAlignment(SwingConstants.CENTER);
			lblAll.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 14));
			lblAll.setBounds(49, 65, 83, 47);
		}
		return lblAll;
	}
	private JLabel getLblIce() {
		if (lblIce == null) {
			lblIce = new JLabel("커피(ICE)");
			lblIce.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					categoryNo = 1;
					lblAll.setForeground(Color.BLACK);
					lblHot.setForeground(Color.BLACK);
					lblJuice.setForeground(Color.BLACK);
					lblTea.setForeground(Color.BLACK);
					lblDessert.setForeground(Color.BLACK);
					lblBackGround1.setVisible(false);
					lblBackGround2.setVisible(true);
					lblBackGround3.setVisible(false);
					lblBackGround4.setVisible(false);
					lblBackGround5.setVisible(false);
					lblBackGround6.setVisible(false);
					lblIce.setForeground(Color.WHITE);
					conditionDrinkQueryAciton();
					updateLabelVisibility();
				}
			});
			lblIce.setHorizontalAlignment(SwingConstants.CENTER);
			lblIce.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 14));
			lblIce.setBounds(144, 65, 77, 47);
		}
		return lblIce;
	}
	private JLabel getLblJuice() {
		if (lblJuice == null) {
			lblJuice = new JLabel("에이드&주스");
			lblJuice.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					categoryNo = 3;
					lblAll.setForeground(Color.BLACK);
					lblIce.setForeground(Color.BLACK);
					lblHot.setForeground(Color.BLACK);
					lblJuice.setForeground(Color.WHITE);
					lblTea.setForeground(Color.BLACK);
					lblDessert.setForeground(Color.BLACK);
					lblBackGround1.setVisible(false);
					lblBackGround2.setVisible(false);
					lblBackGround3.setVisible(false);
					lblBackGround4.setVisible(true);
					lblBackGround5.setVisible(false);
					lblBackGround6.setVisible(false);
					conditionDrinkQueryAciton();
				}
			});
			lblJuice.setHorizontalAlignment(SwingConstants.CENTER);
			lblJuice.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 14));
			lblJuice.setBounds(309, 65, 94, 47);
		}
		return lblJuice;
	}
	private JLabel getLblTea() {
		if (lblTea == null) {
			lblTea = new JLabel("티(Tea)");
			lblTea.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					categoryNo = 4;
					lblAll.setForeground(Color.BLACK);
					lblIce.setForeground(Color.BLACK);
					lblHot.setForeground(Color.BLACK);
					lblJuice.setForeground(Color.BLACK);
					lblTea.setForeground(Color.WHITE);
					lblDessert.setForeground(Color.BLACK);
					lblBackGround1.setVisible(false);
					lblBackGround2.setVisible(false);
					lblBackGround3.setVisible(false);
					lblBackGround4.setVisible(false);
					lblBackGround5.setVisible(true);
					lblBackGround6.setVisible(false);
					conditionDrinkQueryAciton();
				}
			});
			lblTea.setHorizontalAlignment(SwingConstants.CENTER);
			lblTea.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 14));
			lblTea.setBounds(400, 65, 71, 47);
		}
		return lblTea;
	}
	private JLabel getLblDessert() {
		if (lblDessert == null) {
			lblDessert = new JLabel("디저트");
			lblDessert.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					categoryNo = 5;
					lblAll.setForeground(Color.BLACK);
					lblIce.setForeground(Color.BLACK);
					lblHot.setForeground(Color.BLACK);
					lblJuice.setForeground(Color.BLACK);
					lblTea.setForeground(Color.BLACK);
					lblDessert.setForeground(Color.WHITE);
					lblBackGround1.setVisible(false);
					lblBackGround2.setVisible(false);
					lblBackGround3.setVisible(false);
					lblBackGround4.setVisible(false);
					lblBackGround5.setVisible(false);
					lblBackGround6.setVisible(true);
					conditionDessertQueryAciton();
				}
			});
			lblDessert.setHorizontalAlignment(SwingConstants.CENTER);
			lblDessert.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 14));
			lblDessert.setBounds(483, 66, 71, 47);
		}
		return lblDessert;
	}
	private JLabel getLblHot() {
		if (lblHot == null) {
			lblHot = new JLabel("커피(HOT)");
			lblHot.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					categoryNo = 2;
					lblAll.setForeground(Color.BLACK);
					lblIce.setForeground(Color.BLACK);
					lblHot.setForeground(Color.WHITE);
					lblJuice.setForeground(Color.BLACK);
					lblTea.setForeground(Color.BLACK);
					lblDessert.setForeground(Color.BLACK);
					lblBackGround1.setVisible(false);
					lblBackGround2.setVisible(false);
					lblBackGround3.setVisible(true);
					lblBackGround4.setVisible(false);
					lblBackGround5.setVisible(false);
					lblBackGround6.setVisible(false);
					conditionDrinkQueryAciton();
				}
			});
			lblHot.setHorizontalAlignment(SwingConstants.CENTER);
			lblHot.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 14));
			lblHot.setBounds(227, 65, 77, 47);
		}
		return lblHot;
	}
	private JLabel getLblBackGround1() {
		if (lblBackGround1 == null) {
			lblBackGround1 = new JLabel("");
			ImageIcon icon = new ImageIcon(ProductMain.class.getResource("/com/javalec/image/backGround.png"));
			int x = 80;
			int y = 60;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backGround = resize.imageResizing();
			lblBackGround1.setIcon(backGround);
			lblBackGround1.setHorizontalAlignment(SwingConstants.CENTER);
			lblBackGround1.setForeground(Color.WHITE);
			lblBackGround1.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 14));
			lblBackGround1.setBounds(49, 65, 83, 47);
		}
		return lblBackGround1;
	}
	private JLabel getLblBackGround2() {
		if (lblBackGround2 == null) {
			lblBackGround2 = new JLabel("");
			ImageIcon icon = new ImageIcon(ProductMain.class.getResource("/com/javalec/image/backGround.png"));
			int x = 80;
			int y = 60;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backGround = resize.imageResizing();
			lblBackGround2.setIcon(backGround);
			lblBackGround2.setHorizontalAlignment(SwingConstants.CENTER);
			lblBackGround2.setForeground(Color.WHITE);
			lblBackGround2.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 14));
			lblBackGround2.setBounds(141, 65, 83, 47);
			lblBackGround2.setVisible(false);
		}
		return lblBackGround2;
	}
	private JLabel getLblBackGround3() {
		if (lblBackGround3 == null) {
			lblBackGround3 = new JLabel("");
			ImageIcon icon = new ImageIcon(ProductMain.class.getResource("/com/javalec/image/backGround.png"));
			int x = 80;
			int y = 60;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backGround = resize.imageResizing();
			lblBackGround3.setIcon(backGround);
			lblBackGround3.setHorizontalAlignment(SwingConstants.CENTER);
			lblBackGround3.setForeground(Color.WHITE);
			lblBackGround3.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 14));
			lblBackGround3.setBounds(226, 65, 78, 47);
		}
		return lblBackGround3;
	}
	private JLabel getLblBackGround4() {
		if (lblBackGround4 == null) {
			lblBackGround4 = new JLabel("");
			ImageIcon icon = new ImageIcon(ProductMain.class.getResource("/com/javalec/image/backGround.png"));
			int x = 80;
			int y = 60;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backGround = resize.imageResizing();
			lblBackGround4.setIcon(backGround);
			lblBackGround4.setHorizontalAlignment(SwingConstants.CENTER);
			lblBackGround4.setForeground(Color.WHITE);
			lblBackGround4.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 14));
			lblBackGround4.setBounds(309, 65, 91, 47);
		}
		return lblBackGround4;
	}
	private JLabel getLblBackGround5() {
		if (lblBackGround5 == null) {
			lblBackGround5 = new JLabel("");
			ImageIcon icon = new ImageIcon(ProductMain.class.getResource("/com/javalec/image/backGround.png"));
			int x = 60;
			int y = 60;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backGround = resize.imageResizing();
			lblBackGround5.setIcon(backGround);
			lblBackGround5.setHorizontalAlignment(SwingConstants.CENTER);
			lblBackGround5.setForeground(Color.WHITE);
			lblBackGround5.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 14));
			lblBackGround5.setBounds(402, 65, 70, 47);
		}
		return lblBackGround5;
	}
	private JLabel getLblBackGround6() {
		if (lblBackGround6 == null) {
			lblBackGround6 = new JLabel("");
			ImageIcon icon = new ImageIcon(ProductMain.class.getResource("/com/javalec/image/backGround.png"));
			int x = 60;
			int y = 60;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backGround = resize.imageResizing();
			lblBackGround6.setIcon(backGround);
			lblBackGround6.setHorizontalAlignment(SwingConstants.CENTER);
			lblBackGround6.setForeground(Color.WHITE);
			lblBackGround6.setFont(new Font("Noto Sans KR Medium", Font.BOLD, 14));
			lblBackGround6.setBounds(484, 65, 70, 47);
		}
		return lblBackGround6;
	}
	
	
	
	
	
	
	/********************** Functions **********************/
	private ArrayList<JLabel> lblProductImageList = new ArrayList<JLabel>();
	private ArrayList<JLabel> lblProductNameList = new ArrayList<JLabel>();
	private ArrayList<JLabel> lblProductPriceList = new ArrayList<JLabel>();
	private ArrayList<JLabel> lblItemStotList = new ArrayList<JLabel>();
	private JLabel lblAll;
	private JLabel lblIce;
	private JLabel lblJuice;
	private JLabel lblTea;
	private JLabel lblDessert;
	private JLabel lblHot;
	private JLabel lblBackGround1;
	private JLabel lblBackGround2;
	private JLabel lblBackGround3;
	private JLabel lblBackGround4;
	private JLabel lblBackGround5;
	private JLabel lblBackGround6;

//	lblProductImages = {lblProductImage1, lblProductImage2, lblProductImage3, lblProductImage4, lblProductImage5, lblProductImage6};
//	private JLabel[] lblProductNames = {lblProductName1, lblProductName2, lblProductName3, lblProductName4, lblProductName5, lblProductName6};
//	private JLabel[] lblProductPrices = {lblProductPrice1, lblProductPrice2, lblProductPrice3, lblProductPrice4, lblProductPrice5, lblProductPrice6};
	
	/* 01. 라벨들 그룹화 하기 */
	private void inIt() {
		lblProductImageList.add(lblProductImage1);
		lblProductImageList.add(lblProductImage2);
		lblProductImageList.add(lblProductImage3);
		lblProductImageList.add(lblProductImage4);
		lblProductImageList.add(lblProductImage5);
		lblProductImageList.add(lblProductImage6);
		lblProductNameList.add(lblProductName1);
		lblProductNameList.add(lblProductName2);
		lblProductNameList.add(lblProductName3);
		lblProductNameList.add(lblProductName4);
		lblProductNameList.add(lblProductName5);
		lblProductNameList.add(lblProductName6);
		lblProductPriceList.add(lblProductPrice1);
		lblProductPriceList.add(lblProductPrice2);
		lblProductPriceList.add(lblProductPrice3);
		lblProductPriceList.add(lblProductPrice4);
		lblProductPriceList.add(lblProductPrice5);
		lblProductPriceList.add(lblProductPrice6);
		lblItemStotList.add(lblItemSlot1);
		lblItemStotList.add(lblItemSlot2);
		lblItemStotList.add(lblItemSlot3);
		lblItemStotList.add(lblItemSlot4);
		lblItemStotList.add(lblItemSlot5);
		lblItemStotList.add(lblItemSlot6);
		
		for (int i = 0; i < lblProductImageList.size(); i++) {
	        JLabel lblProductImage = lblProductImageList.get(i);
	        int index = i; // 인덱스 변수를 final 혹은 effectively final로 만들기 위해 별도로 선언

	        lblProductImage.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                itemClick(index); // 해당 라벨을 클릭했을 때 처리할 메소드 호출
	            }
	        });
	    }
		
	}
	
	/* 02. 첫 화면에 전체 메뉴 띄우기 (Drink 한정) */
	private void queryDrinkAction() {
		beanList = new ArrayList<ProductDto>();
		ProductDao productDao = new ProductDao();
		beanList = productDao.selectDrinkList();
		
		for(int i=0; i<6; i++) {
			icon = new ImageIcon("./" + beanList.get(i).getDrinkImageName());
			int x = 100;
			int y = 120;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon productIcon = resize.imageResizing();
			lblProductImageList.get(i).setIcon(productIcon);
			lblProductNameList.get(i).setText(beanList.get(i).getDrinkName());
			lblProductPriceList.get(i).setText(Integer.toString(beanList.get(i).getDrinkPrice()));
		}
		updateLabelVisibility();
	}

	/* 03. 메뉴 페이지 뒤로 가기 버튼  */
	private void priviousPage() {
		if (currentPage > 0) {
			currentPage--;
			updateLabelVisibility();
		}
	}

	/* 04. 메뉴 페이지 앞으로 가기 버튼  */
	private void nextPage() {
	    int maxPage = (int) Math.ceil(beanList.size() / 6.0);
	    if (currentPage < maxPage - 1) {
	        currentPage++;
	    }
	    updateLabelVisibility();
	}
	
	/* 05. 요청에 따라 라벨 정리하기 */
	private void updateLabelVisibility() {
	    int startIndex = currentPage * 6;
	    int endIndex = Math.min(startIndex + 6, beanList.size());
	    System.out.println(beanList.size());
	    DecimalFormat decimalFormat = new DecimalFormat("#,###");	
	    for (int i = startIndex; i < endIndex; i++) {
	        int labelIndex = i - startIndex; // 라벨의 인덱스를 계산
	        ProductDto product = beanList.get(i); // 해당 인덱스의 상품 가져오기

	        lblProductImageList.get(labelIndex).setVisible(true);
	        lblProductNameList.get(labelIndex).setVisible(true);
	        lblProductPriceList.get(labelIndex).setVisible(true);
	        lblItemStotList.get(labelIndex).setVisible(true);

	        icon = new ImageIcon("./" + product.getDrinkImageName());
	        int x = 100;
	        int y = 120;
	        ImageResize resize = new ImageResize(icon, x, y);
	        ImageIcon productIcon = resize.imageResizing();
	        lblProductImageList.get(labelIndex).setIcon(productIcon);
	        lblProductNameList.get(labelIndex).setText(product.getDrinkName());
	        lblProductPriceList.get(labelIndex).setText(decimalFormat.format(product.getDrinkPrice()) + "원");
	    }

	    // 나머지 라벨은 비활성화
	    for (int i = endIndex - startIndex; i < 6; i++) {
	        lblProductImageList.get(i).setVisible(false);
	        lblProductNameList.get(i).setVisible(false);
	        lblProductPriceList.get(i).setVisible(false);
	        lblItemStotList.get(i).setVisible(false);
	    }

	    lblPriviousBtn.setVisible(currentPage > 0);
	    lblNextBtn.setVisible(endIndex < beanList.size());
	}
	
	/* 06. 카테고리 검색 (Drink) */
	private void conditionDrinkQueryAciton() {
		currentPage = 0;
		beanList = new ArrayList<ProductDto>();
		ProductDao productDao = new ProductDao();
		beanList = productDao.conditionDrinkQuery(categoryNo);

		for (int i = 0; i < beanList.size(); i++) {
			icon = new ImageIcon("./" + beanList.get(i).getDrinkImageName());
			int x = 100;
			int y = 120;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon productIcon = resize.imageResizing();
			lblProductImageList.get(i).setIcon(productIcon);
			lblProductNameList.get(i).setText(beanList.get(i).getDrinkName());
			lblProductPriceList.get(i).setText(Integer.toString(beanList.get(i).getDrinkPrice()));
		}
		updateLabelVisibility();
	}
	
	/* 07. 카테고리 검색 (Dessert) */
	private void conditionDessertQueryAciton() {
		currentPage = 0;
		lblPriviousBtn.setVisible(false);
		beanList = new ArrayList<ProductDto>();
		ProductDao productDao = new ProductDao();
		beanList = productDao.conditionDessertQuery(categoryNo);

		for (int i = 0; i < beanList.size(); i++) {
			icon = new ImageIcon("./" + beanList.get(i).getDrinkImageName());
			int x = 100;
			int y = 120;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon productIcon = resize.imageResizing();
			lblProductImageList.get(i).setIcon(productIcon);
			lblProductNameList.get(i).setText(beanList.get(i).getDrinkName());
			lblProductPriceList.get(i).setText(Integer.toString(beanList.get(i).getDrinkPrice()));
		}
		updateLabelVisibility();
	}
	
	private int getItemNo(int index) {
	    int startIndex = currentPage * 6; // startIndex 계산
	    if (startIndex >= 0 && startIndex + index < beanList.size()) {
	        ProductDto selectedProduct = beanList.get(startIndex + index);

	        // 선택한 상품의 번호 가져오기
	        return selectedProduct.getDrinkNo();
	    }

	    return -1; // 유효하지 않은 인덱스이거나 선택한 상품이 없는 경우
	}
	
	private void itemClick(int index) {
	    int itemNo = getItemNo(index);
	    if (itemNo != -1) {
	        // 선택한 상품 데이터 활용
	        String itemName = beanList.get(currentPage * 6 + index).getDrinkName();
	        int itemPrice = beanList.get(currentPage * 6 + index).getDrinkPrice();
	        ProductOptionMain productOptionMain = new ProductOptionMain();
	        productOptionMain.setCategoryNo(categoryNo);
	        System.out.println(categoryNo);
	        productOptionMain.setItemNo(itemNo);
	        productOptionMain.setVisible(true);
	    }
	    
	    
	}
	

}	// End Class