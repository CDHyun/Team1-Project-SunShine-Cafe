package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.CartDao;
import com.javalec.dao.ProductDao;
import com.javalec.dto.CartDto;
import com.javalec.dto.ProductDto;
import com.javalec.function.ImageResize;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/* 기본 키오스크에서 상품 옵션을 선택하는 페이지 (핫, 아이스, 연하게 등 ) */
public class ProductOptionMain extends JFrame {

	private JPanel contentPane;
	private JLabel lblTitle;
	private JLabel lblTitle_1;
	private JLabel lblBack;
	private JLabel lblProductImage;
	private JLabel lblProductName;
	private JLabel lblShot;
	private JLabel lblSyrup;
	private JLabel lblSugar;
	private JLabel lblOption;
	private JLabel lblCartBtn;
	private JLabel lblCancle;
	private JLabel lblContent;
	private JLabel lblPrice;
	private JLabel lblAddShot;
	private JLabel lblAddSyrup;
	private JLabel lblAddSugar;
	private JLabel lblAddShot2;
	private JLabel lblAddSyrup2;
	private JLabel lblAddSugar2;
	private JLabel lblAddSugar3;
	private JLabel lblAddSyrup3;
	private JLabel lblAddShot3;
	private JLabel lblResetBtn;
	
	
	
	/* Field */
	private int categoryNo;
	private int itemNo;
	private String itemName;
	private int itemPrice;
	private String itemContent;
	private String itemImageName;
	/* 기존 가격 저장 */
	private int total;
	/* 메소드에서 돌아가는 가격 */
	private int cartOptionPrice;
	private int shotCount = 0;
	private int syrupCount = 0;
	private int sugarCount = 0;
	private String userid = "donghyun";
	private String wkItemName = "";
	private JLabel lblWon;

	

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemContent() {
		return itemContent;
	}

	public void setItemContent(String itemContent) {
		this.itemContent = itemContent;
	}

	public String getItemImageName() {
		return itemImageName;
	}

	public void setItemImageName(String itemImageName) {
		this.itemImageName = itemImageName;
	}

	public String getWkItemName() {
		return wkItemName;
	}

	public void setWkItemName(String wkItemName) {
		this.wkItemName = wkItemName;
	}

	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductOptionMain frame = new ProductOptionMain();
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
	public ProductOptionMain() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				itemDetail();
			}
		});
		setTitle("상품 옵션 페이지");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 900);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 210, 84));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblWon());
		contentPane.add(getLblAddShot());
		contentPane.add(getLblTitle());
		contentPane.add(getLblTitle_1());
		contentPane.add(getLblProductImage());
		contentPane.add(getLblProductName());
		contentPane.add(getLblShot());
		contentPane.add(getLblSyrup());
		contentPane.add(getLblSugar());
		contentPane.add(getLblCartBtn());
		contentPane.add(getLblCancle());
		contentPane.add(getLblContent());
		contentPane.add(getLblPrice());
		contentPane.add(getLblBack());
		contentPane.add(getLblAddSyrup());
		contentPane.add(getLblAddSugar());
		contentPane.add(getLblAddShot2());
		contentPane.add(getLblAddSyrup2());
		contentPane.add(getLblAddSugar2());
		contentPane.add(getLblAddSugar3());
		contentPane.add(getLblAddSyrup3());
		contentPane.add(getLblAddShot3());
		contentPane.add(getLblResetBtn());
		contentPane.add(getLblOption());
	}

	private JLabel getLblTitle() {
		if (lblTitle == null) {
			lblTitle = new JLabel("SunShine Cafe");
			lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
			lblTitle.setBounds(118, 6, 394, 47);
		}
		return lblTitle;
	}
	private JLabel getLblTitle_1() {
		if (lblTitle_1 == null) {
			lblTitle_1 = new JLabel("선택하신 상품의 옵션을 선택해주세요.");
			lblTitle_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitle_1.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 24));
			lblTitle_1.setBounds(118, 65, 394, 35);
		}
		return lblTitle_1;
	}
	private JLabel getLblBack() {
		if (lblBack == null) {
			lblBack = new JLabel("");
			lblBack.setIcon(new ImageIcon(ProductOptionMain.class.getResource("/com/javalec/image/whiteBoard.png")));
			lblBack.setForeground(Color.WHITE);
			lblBack.setBackground(Color.WHITE);
			lblBack.setBounds(0, 112, 625, 229);
		}
		return lblBack;
	}
	private JLabel getLblProductImage() {
		if (lblProductImage == null) {
			lblProductImage = new JLabel("");
			ImageIcon icon = new ImageIcon(ProductOptionMain.class.getResource("/com/javalec/image/IceWaterMelon.png"));
			int x = 140;
			int y = 180;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon productIcon = resize.imageResizing();
			lblProductImage.setIcon(productIcon);
			lblProductImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductImage.setBounds(0, 112, 150, 215);
		}
		return lblProductImage;
	}
	private JLabel getLblProductName() {
		if (lblProductName == null) {
			lblProductName = new JLabel("");
			lblProductName.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 24));
			lblProductName.setBounds(160, 119, 352, 56);
		}
		return lblProductName;
	}
	private JLabel getLblShot() {
		if (lblShot == null) {
			lblShot = new JLabel("");
			lblShot.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					addOption(e);
				}
			});
			lblShot.setHorizontalAlignment(SwingConstants.CENTER);
			ImageIcon icon = new ImageIcon(ProductOptionMain.class.getResource("/com/javalec/image/shot.png"));
			int x = 200;
			int y = 200;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon addShot = resize.imageResizing();
			lblShot.setIcon(addShot);
			lblShot.setBounds(19, 378, 189, 172);
		}
		return lblShot;
	}
	private JLabel getLblSyrup() {
		if (lblSyrup == null) {
			lblSyrup = new JLabel("");
			lblSyrup.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					addOption(e);
				}
			});
			ImageIcon icon = new ImageIcon(ProductOptionMain.class.getResource("/com/javalec/image/syrup.png"));
			int x = 200;
			int y = 200;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon syrup = resize.imageResizing();
			lblSyrup.setIcon(syrup);
			lblSyrup.setHorizontalAlignment(SwingConstants.CENTER);
			lblSyrup.setBounds(220, 378, 189, 172);
		}
		return lblSyrup;
	}
	private JLabel getLblSugar() {
		if (lblSugar == null) {
			lblSugar = new JLabel("");
			lblSugar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					addOption(e);
				}
			});
			ImageIcon icon = new ImageIcon(ProductOptionMain.class.getResource("/com/javalec/image/sugar.png"));
			int x = 200;
			int y = 200;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon sugar = resize.imageResizing();
			lblSugar.setIcon(sugar);
			lblSugar.setHorizontalAlignment(SwingConstants.CENTER);
			lblSugar.setBounds(421, 378, 189, 172);
		}
		return lblSugar;
	}
	private JLabel getLblOption() {
		if (lblOption == null) {
			lblOption = new JLabel("");
			ImageIcon icon = new ImageIcon(ProductOptionMain.class.getResource("/com/javalec/image/option.png"));
			int x = 700;
			int y = 170;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon option = resize.imageResizing();
			lblOption.setIcon(option);
			lblOption.setHorizontalAlignment(SwingConstants.CENTER);
			lblOption.setBounds(0, 600, 625, 172);
		}
		return lblOption;
	}
	private JLabel getLblCartBtn() {
		if (lblCartBtn == null) {
			lblCartBtn = new JLabel("");
			lblCartBtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					createPurchaseList();
				}
			});
			ImageIcon icon = new ImageIcon(ProductOptionMain.class.getResource("/com/javalec/image/cartBtn.png"));
			int x = 200;
			int y = 70;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon cart = resize.imageResizing();
			lblCartBtn.setIcon(cart);
			lblCartBtn.setHorizontalAlignment(SwingConstants.CENTER);
			lblCartBtn.setBounds(372, 784, 189, 82);
		}
		return lblCartBtn;
	}
	private JLabel getLblCancle() {
		if (lblCancle == null) {
			lblCancle = new JLabel("");
			lblCancle.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ProductMain productMain = new ProductMain();
					productMain.setLocationRelativeTo(null);
					productMain.setVisible(true);
					dispose();
				}
			});
			ImageIcon icon = new ImageIcon(ProductOptionMain.class.getResource("/com/javalec/image/cancle.png"));
			int x = 200;
			int y = 70;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon cancle = resize.imageResizing();
			lblCancle.setIcon(cancle);
			lblCancle.setHorizontalAlignment(SwingConstants.CENTER);
			lblCancle.setBounds(103, 784, 189, 82);
		}
		return lblCancle;
	}
	private JLabel getLblContent() {
		if (lblContent == null) {
			lblContent = new JLabel("");
			lblContent.setForeground(Color.LIGHT_GRAY);
			lblContent.setVerticalAlignment(SwingConstants.TOP);
			lblContent.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 14));
			lblContent.setBounds(160, 169, 352, 56);
		}
		return lblContent;
	}
	private JLabel getLblPrice() {
		if (lblPrice == null) {
			lblPrice = new JLabel("");
			lblPrice.setForeground(Color.RED);
			lblPrice.setHorizontalAlignment(SwingConstants.TRAILING);
			lblPrice.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
			lblPrice.setBounds(399, 263, 182, 47);
		}
		return lblPrice;
	}
	
	private JLabel getLblAddShot() {
		if (lblAddShot == null) {
			lblAddShot = new JLabel("");
			lblAddShot.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 14));
			lblAddShot.setBounds(19, 649, 68, 24);
		}
		return lblAddShot;
	}
	private JLabel getLblAddSyrup() {
		if (lblAddSyrup == null) {
			lblAddSyrup = new JLabel("");
			lblAddSyrup.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 14));
			lblAddSyrup.setBounds(19, 685, 68, 24);
		}
		return lblAddSyrup;
	}
	private JLabel getLblAddSugar() {
		if (lblAddSugar == null) {
			lblAddSugar = new JLabel("");
			lblAddSugar.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 14));
			lblAddSugar.setBounds(19, 721, 68, 24);
		}
		return lblAddSugar;
	}
	private JLabel getLblAddShot2() {
		if (lblAddShot2 == null) {
			lblAddShot2 = new JLabel("");
			lblAddShot2.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
			lblAddShot2.setForeground(Color.RED);
			lblAddShot2.setBounds(99, 649, 30, 24);
		}
		return lblAddShot2;
	}
	private JLabel getLblAddSyrup2() {
		if (lblAddSyrup2 == null) {
			lblAddSyrup2 = new JLabel("");
			lblAddSyrup2.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
			lblAddSyrup2.setForeground(Color.RED);
			lblAddSyrup2.setBounds(99, 685, 30, 24);
		}
		return lblAddSyrup2;
	}
	private JLabel getLblAddSugar2() {
		if (lblAddSugar2 == null) {
			lblAddSugar2 = new JLabel("");
			lblAddSugar2.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
			lblAddSugar2.setForeground(Color.RED);
			lblAddSugar2.setBounds(99, 721, 30, 24);
		}
		return lblAddSugar2;
	}
	private JLabel getLblAddSugar3() {
		if (lblAddSugar3 == null) {
			lblAddSugar3 = new JLabel("");
			lblAddSugar3.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 14));
			lblAddSugar3.setBounds(120, 721, 30, 24);
		}
		return lblAddSugar3;
	}
	private JLabel getLblAddSyrup3() {
		if (lblAddSyrup3 == null) {
			lblAddSyrup3 = new JLabel("");
			lblAddSyrup3.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 14));
			lblAddSyrup3.setBounds(120, 685, 30, 24);
		}
		return lblAddSyrup3;
	}
	private JLabel getLblAddShot3() {
		if (lblAddShot3 == null) {
			lblAddShot3 = new JLabel("");
			lblAddShot3.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 14));
			lblAddShot3.setBounds(120, 649, 30, 24);
		}
		return lblAddShot3;
	}
	private JLabel getLblResetBtn() {
		if (lblResetBtn == null) {
			lblResetBtn = new JLabel("");
			lblResetBtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					resetAction();
				}
			});
			lblResetBtn.setBounds(464, 609, 161, 47);
		}
		return lblResetBtn;
	}
	
	
	
	
	
	/************** Functions **************/
	/* 01. 창이 열릴 때 데이터를 띄워주는 메소드 */
	private void itemDetail() {
		ArrayList<ProductDto> beanList = new ArrayList<ProductDto>();
		ProductDao productDao = new ProductDao();
		beanList = productDao.itemDetail(categoryNo, itemNo);
		
		for(int i=0; i<beanList.size(); i++) {
			total = beanList.get(i).getItemPrice();
			cartOptionPrice = beanList.get(i).getItemPrice();
			wkItemName = beanList.get(i).getItemName();
			lblProductName.setText(wkItemName);
			lblPrice.setText(Integer.toString(cartOptionPrice));
			ImageIcon icon = new ImageIcon("./" + beanList.get(i).getItemImageName());
			int x = 150;
			int y = 200;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon productIcon = resize.imageResizing();
			lblProductImage.setIcon(productIcon);
			lblContent.setText(beanList.get(i).getItemContent());
		}
		
	}
	
	/* 02. 옵션을 선택 했을 때 반응하는 메소드 */
	private void addOption(MouseEvent e) {

		cartOptionPrice = cartOptionPrice + 500;
		lblPrice.setText(Integer.toString(cartOptionPrice));
		lblWon.setText("원");
		JLabel clickedLabel = (JLabel) e.getSource();
	    if (clickedLabel == lblShot) {
	    	shotCount++;
	    	lblAddShot.setText("샷 추가 : ");
	    	lblAddShot2.setText(Integer.toString(shotCount));
	    	lblAddShot3.setText("개");
	    } else if (clickedLabel == lblSyrup) {
	    	syrupCount++;
	    	lblAddSyrup.setText("시럽 추가 : ");
	    	lblAddSyrup2.setText(Integer.toString(syrupCount));
	    	lblAddSyrup3.setText("개");
	    } else if (clickedLabel == lblSugar) {
	    	sugarCount++;
	    	lblAddSugar.setText("설탕 추가 : ");
	    	lblAddSugar2.setText(Integer.toString(sugarCount));
	    	lblAddSugar3.setText("개");
	    }
	}
	
	/* 03. 초기화 버튼을 눌렀을 때 실행되는 메소드 */
	private void resetAction() {
		cartOptionPrice = total;
		lblPrice.setText(Integer.toString(cartOptionPrice));
		shotCount = 0;
		lblAddShot.setText("");
		lblAddShot2.setText("");
		lblAddShot3.setText("");
		syrupCount = 0;
		lblAddSyrup.setText("");
		lblAddSyrup2.setText("");
		lblAddSyrup3.setText("");
		sugarCount = 0;
		lblAddSugar.setText("");
		lblAddSugar2.setText("");
		lblAddSugar3.setText("");
		lblWon.setText("");
	}

	/* 04. 주문 담기 버튼을 눌렀을 때 실행되는 메소드 */
	private void createPurchaseList() {
		CartDao cartDao = new CartDao(itemNo, userid, cartOptionPrice);
//		boolean result = false;
//		if(categoryNo == 5) {
//			result = cartDao.dessertAddToCart();
//		} else {
//			result = cartDao.drinkAddToCart();
//		}
		boolean result = cartDao.itemAddToCart();
		if(!result) {
			cartErrorDialog cartErrorDialog = new cartErrorDialog();
			cartErrorDialog.setLocationRelativeTo(null);
			cartErrorDialog.setVisible(true);
		} else {
			ProductMain productMain = new ProductMain();
			productMain.setLocationRelativeTo(null);
			productMain.setVisible(true);
			dispose();
		}
	}

	private JLabel getLblWon() {
		if (lblWon == null) {
			lblWon = new JLabel("");
			lblWon.setHorizontalAlignment(SwingConstants.TRAILING);
			lblWon.setForeground(Color.BLACK);
			lblWon.setFont(new Font("Noto Sans KR Medium", Font.PLAIN, 32));
			lblWon.setBounds(559, 263, 51, 47);
		}
		return lblWon;
	}
}	// End Class
