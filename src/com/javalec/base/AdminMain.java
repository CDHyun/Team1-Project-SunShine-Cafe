package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.function.ImageResize;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/* 기본 키오스크에서 어드민이 로그인 한 뒤 나오는 메인 페이지 */
public class AdminMain extends JFrame {

	private JPanel contentPane;
	private JLabel lblLogoImage;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblHomeImage;
	private JLabel lblCafeStart;
	private JLabel lblCafeEnd;
	private JLabel btnMenuUpdate;
	private JLabel btnCloseCafe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMain frame = new AdminMain();
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
	public AdminMain() {
		setTitle("관리자 작업");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(248, 211, 72));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblLogoImage());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblHomeImage());
		contentPane.add(getLblCafeStart());
		contentPane.add(getLblCafeEnd());
		contentPane.add(getBtnMenuUpdate());
		contentPane.add(getBtnCloseCafe());
	}

	private JLabel getLblLogoImage() {
		if (lblLogoImage == null) {
			lblLogoImage = new JLabel("");
			ImageIcon icon = new ImageIcon(AdminMain.class.getResource("/com/javalec/image/SunShineTeamLogo.png"));
			int x = 200;
			int y = 200;
			ImageResize resize = new ImageResize(icon, x, y); 		// 이미지 리사이즈 메소드 생성자 통해 호출해서 필요한 값 주기  
			ImageIcon logo = resize.imageResizing();				// 로고에 할당.
			
			lblLogoImage.setIcon(new ImageIcon(AdminMain.class.getResource("/com/javalec/image/SunShineTeamLogoWhiteBackGround.png")));
			
			lblLogoImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblLogoImage.setBackground(new Color(242, 250, 63));
			lblLogoImage.setBounds(130, 30, 365, 365);
		}
		return lblLogoImage;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("관리자 님, 환영합니다! ");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lblNewLabel.setBounds(0, 390, 625, 50);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("수행하실 작업을 선택해 주세요");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lblNewLabel_1.setBounds(0, 440, 625, 50);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblHomeImage() {
		if (lblHomeImage == null) {
			lblHomeImage = new JLabel("");
			lblHomeImage.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					redirectAdminLoginMain();
				}
			});
			ImageIcon icon = new ImageIcon(AdminCalculateMain.class.getResource("/com/javalec/image/back.png"));
			int x = 50;
			int y = 50;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backPage = resize.imageResizing();
			
			lblHomeImage.setIcon(backPage);
			lblHomeImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblHomeImage.setBounds(5, 0, 70, 70);
			
		}
		return lblHomeImage;
	}
	
	private JLabel getLblCafeStart() {
		if (lblCafeStart == null) {
			lblCafeStart = new JLabel("");
			lblCafeStart.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					redirectAdvertisementMain();
				}
			});
			lblCafeStart.setHorizontalAlignment(SwingConstants.CENTER);
			ImageIcon icon = new ImageIcon(AdminMain.class.getResource("/com/javalec/image/영업시작.png"));
			int x = 200;
			int y = 150;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon startBtn = resize.imageResizing();
			lblCafeStart.setIcon(startBtn);
			lblCafeStart.setBounds(110, 545, 200, 114);
		}
		return lblCafeStart;
	}
	private JLabel getLblCafeEnd() {
		if (lblCafeEnd == null) {
			lblCafeEnd = new JLabel("");
			lblCafeEnd.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int option = JOptionPane.showConfirmDialog(null, "종료하시겠습니까?", "종료 확인", JOptionPane.YES_NO_OPTION);
					
					if(option == JOptionPane.YES_OPTION) {
						dispose();
					} 
					
				}
			});
			ImageIcon icon = new ImageIcon(AdminMain.class.getResource("/com/javalec/image/영업종료.png"));
			int x = 200;
			int y = 150;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon endBtn = resize.imageResizing();
			lblCafeEnd.setIcon(endBtn);
			lblCafeEnd.setHorizontalAlignment(SwingConstants.CENTER);
			lblCafeEnd.setBounds(310, 545, 200, 114);
		}
		return lblCafeEnd;
	}
	private JLabel getBtnMenuUpdate() {
		if (btnMenuUpdate == null) {
			btnMenuUpdate = new JLabel("");
			btnMenuUpdate.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					directAdminMenuMain();
				}
			});
			ImageIcon icon = new ImageIcon(AdminMain.class.getResource("/com/javalec/image/제품관리.png"));
			int x = 200;
			int y = 150;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon menuUpdateBtn = resize.imageResizing();
			btnMenuUpdate.setIcon(menuUpdateBtn);
			btnMenuUpdate.setHorizontalAlignment(SwingConstants.CENTER);
			btnMenuUpdate.setBounds(110, 660, 200, 114);
		}
		return btnMenuUpdate;
	}
	private JLabel getBtnCloseCafe() {
		if (btnCloseCafe == null) {
			btnCloseCafe = new JLabel("");
			btnCloseCafe.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					directAdminCalculateMain();
				}
			});
			ImageIcon icon = new ImageIcon(AdminMain.class.getResource("/com/javalec/image/정산.png"));
			int x = 200;
			int y = 150;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon CloseCafeBtn = resize.imageResizing();
			btnCloseCafe.setIcon(CloseCafeBtn);
			btnCloseCafe.setHorizontalAlignment(SwingConstants.CENTER);
			btnCloseCafe.setBounds(310, 660, 200, 114);
		}
		return btnCloseCafe;
	}
	
	/* Functions */
	private void redirectAdvertisementMain() {
		AdvertisementMain main = new AdvertisementMain();
		main.setLocationRelativeTo(null);
		main.setVisible(true);
		dispose();
	}
	
	private void redirectAdminMain() {
		AdminMain main = new AdminMain();
		main.setLocationRelativeTo(null);
		main.setVisible(true);
		dispose();
	}
	
	private void redirectAdminLoginMain() {
		AdminLoginMain main = new AdminLoginMain();
		main.setLocationRelativeTo(null);
		main.setVisible(true);
		dispose();	
	}
	
	private void directAdminMenuMain() {
		AdminMenuMain main = new AdminMenuMain();
		main.setLocationRelativeTo(null);
		main.setVisible(true);
		dispose();
	}
	

	
	private void directAdminCalculateMain() {
		AdminCalculateMain main = new AdminCalculateMain();
		main.setLocationRelativeTo(null);
		main.setVisible(true);
		dispose();
	}
	
	
}	// End Class

