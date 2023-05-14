package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.function.ImageResize;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/* 기본 키오스크에서 결제 수단을 선택하는 페이지 */
public class PaymentMain extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblback;
	private JLabel lblNewLabel_1_1;
	private JLabel lblcard;
	private JLabel lblNewLabel_1_1_1;
	private JLabel lblkakao;
	private JLabel lblpayco;
	private JLabel lblnaver;
	private JLabel lblzero;
	private JLabel lblpaybooc;
	private JLabel lblWhite1;
	private JLabel lblWhite2;
	private JLabel lblWhite3;
	private JLabel lblWhite3_1;
	private JLabel lblWhite4;
	private JLabel lblWhite5;
	private JLabel lblWhite6;
	private JLabel lblSun;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentMain frame = new PaymentMain();
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
	public PaymentMain() {
		setTitle("결제 수단 선택");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 900);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 224, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblback());
		contentPane.add(getLblNewLabel_1_1());
		contentPane.add(getLblcard());
		contentPane.add(getLblNewLabel_1_1_1());
		contentPane.add(getLblkakao());
		contentPane.add(getLblpayco());
		contentPane.add(getLblnaver());
		contentPane.add(getLblzero());
		contentPane.add(getLblpaybooc());
		contentPane.add(getLblWhite1());
		contentPane.add(getLblWhite2());
		contentPane.add(getLblWhite3());
		contentPane.add(getLblWhite4());
		contentPane.add(getLblWhite5());
		contentPane.add(getLblWhite6());
		contentPane.add(getLblSun());
		
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Sunshine Cafe");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			lblNewLabel.setBounds(169, 6, 282, 69);
		}
		return lblNewLabel;
	}
	private JLabel getLblback() {
		if (lblback == null) {
			lblback = new JLabel("");
			lblback.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					redirecPurchaseMain();
				}
			});
			ImageIcon icon = new ImageIcon(PaymentMain.class.getResource("/com/javalec/image/back.png"));
			int x = 50;
			int y = 50;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backArrow = resize.imageResizing();
			
			lblback.setIcon(backArrow);
			lblback.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
			lblback.setBounds(18, 6, 75, 69);
		}
		return lblback;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("카드결제");
			lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
			lblNewLabel_1_1.setBounds(18, 125, 119, 48);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblcard() {
		if (lblcard == null) {
			lblcard = new JLabel("");
		
			
			ImageIcon icon = new ImageIcon(PaymentMain.class.getResource("/com/javalec/image/cardPay.png"));
			int x = 150;
			int y = 150;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backArrow = resize.imageResizing();
			
			lblcard.setIcon(backArrow);
			lblcard.setBounds(28, 185, 155, 148);
		}
		return lblcard;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("간편결제");
			lblNewLabel_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
			lblNewLabel_1_1_1.setBounds(18, 361, 119, 48);
		}
		return lblNewLabel_1_1_1;
	}
	private JLabel getLblkakao() {
		if (lblkakao == null) {
			lblkakao = new JLabel("");
			ImageIcon icon = new ImageIcon(PaymentMain.class.getResource("/com/javalec/image/kakaopay.png"));
			int x = 150;
			int y = 150;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backArrow = resize.imageResizing();
			
			lblkakao.setIcon(backArrow);
			lblkakao.setBounds(28, 435, 155, 148);
		}
		return lblkakao;
	}
	private JLabel getLblpayco() {
		if (lblpayco == null) {
			lblpayco = new JLabel("");
			lblpayco.setHorizontalAlignment(SwingConstants.CENTER);
			ImageIcon icon = new ImageIcon(PaymentMain.class.getResource("/com/javalec/image/paycopay.png"));
			int x = 150;
			int y = 150;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backArrow = resize.imageResizing();
			
			lblpayco.setIcon(backArrow);
			
			lblpayco.setBounds(239, 435, 155, 148);
		}
		return lblpayco;
	}
	private JLabel getLblnaver() {
		if (lblnaver == null) {
			lblnaver = new JLabel("");
			ImageIcon icon = new ImageIcon(PaymentMain.class.getResource("/com/javalec/image/naverpay.png"));
			
			int x = 150;
			int y = 150;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backArrow = resize.imageResizing();
			
			lblnaver.setIcon(backArrow);
			
			
			lblnaver.setHorizontalAlignment(SwingConstants.CENTER);
			lblnaver.setBounds(441, 435, 162, 148);
		}
		return lblnaver;
	}
	private JLabel getLblzero() {
		if (lblzero == null) {
			lblzero = new JLabel("");
			ImageIcon icon = new ImageIcon(PaymentMain.class.getResource("/com/javalec/image/zeropay.png"));
			
			int x = 180;
			int y = 180;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backArrow = resize.imageResizing();
			
			lblzero.setIcon(backArrow);
			
			
			lblzero.setHorizontalAlignment(SwingConstants.CENTER);
			lblzero.setBounds(18, 616, 171, 148);
		}
		return lblzero;
	}
	private JLabel getLblpaybooc() {
		if (lblpaybooc == null) {
			lblpaybooc = new JLabel("");
			lblpaybooc.setHorizontalAlignment(SwingConstants.CENTER);
			ImageIcon icon = new ImageIcon(PaymentMain.class.getResource("/com/javalec/image/payboocpay.png"));
			
			int x = 150;
			int y = 150;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backArrow = resize.imageResizing();
			
			lblpaybooc.setIcon(backArrow);
			lblpaybooc.setBounds(234, 616, 171, 148);
		}
		return lblpaybooc;
	}
	private JLabel getLblWhite1() {
		if (lblWhite1 == null) {
			lblWhite1 = new JLabel("");
			lblWhite1.setHorizontalAlignment(SwingConstants.CENTER);
			ImageIcon icon = new ImageIcon(PaymentMain.class.getResource("/com/javalec/image/round.png"));
			int x = 300;
			int y = 250;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backArrow = resize.imageResizing();
			
			lblWhite1.setIcon(backArrow);
			
			
			lblWhite1.setBounds(-11, 179, 260, 189);
		}
		return lblWhite1;
	}
	private JLabel getLblWhite2() {
		if (lblWhite2 == null) {
			lblWhite2 = new JLabel("");
			lblWhite2.setHorizontalAlignment(SwingConstants.CENTER);
			ImageIcon icon = new ImageIcon(PaymentMain.class.getResource("/com/javalec/image/round.png"));
			int x = 300;
			int y = 250;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backArrow = resize.imageResizing();
			
			lblWhite2.setIcon(backArrow);
			lblWhite2.setBounds(-11, 426, 260, 189);
		}
		return lblWhite2;
	}
	private JLabel getLblWhite3() {
		if (lblWhite3 == null) {
			lblWhite3 = new JLabel("");
			lblWhite3.setHorizontalAlignment(SwingConstants.CENTER);
			ImageIcon icon = new ImageIcon(PaymentMain.class.getResource("/com/javalec/image/round.png"));
			int x = 300;
			int y = 250;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backArrow = resize.imageResizing();
			
			lblWhite3.setIcon(backArrow);
			lblWhite3.setBounds(201, 426, 260, 189);
		}
		return lblWhite3;
	}

	private JLabel getLblWhite4() {
		if (lblWhite4 == null) {
			lblWhite4 = new JLabel("");
			lblWhite4.setHorizontalAlignment(SwingConstants.CENTER);
			ImageIcon icon = new ImageIcon(PaymentMain.class.getResource("/com/javalec/image/round.png"));
			int x = 300;
			int y = 250;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backArrow = resize.imageResizing();
			
			lblWhite4.setIcon(backArrow);
			lblWhite4.setBounds(406, 426, 260, 189);
		}
		return lblWhite4;
	}
	private JLabel getLblWhite5() {
		if (lblWhite5 == null) {
			lblWhite5 = new JLabel("");
			lblWhite5.setHorizontalAlignment(SwingConstants.CENTER);
			ImageIcon icon = new ImageIcon(PaymentMain.class.getResource("/com/javalec/image/round.png"));
			int x = 300;
			int y = 250;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backArrow = resize.imageResizing();
			
			lblWhite5.setIcon(backArrow);
			lblWhite5.setBounds(-11, 613, 260, 189);
		}
		return lblWhite5;
	}
	private JLabel getLblWhite6() {
		if (lblWhite6 == null) {
			lblWhite6 = new JLabel("");
			lblWhite6.setHorizontalAlignment(SwingConstants.CENTER);
			ImageIcon icon = new ImageIcon(PaymentMain.class.getResource("/com/javalec/image/round.png"));
			int x = 300;
			int y = 250;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backArrow = resize.imageResizing();
			
			lblWhite6.setIcon(backArrow);
			lblWhite6.setBounds(201, 611, 260, 189);
		}
		return lblWhite6;
	}
	private JLabel getLblSun() {
		if (lblSun == null) {
			lblSun = new JLabel("");
			ImageIcon icon = new ImageIcon(PaymentMain.class.getResource("/com/javalec/image/SunShineTeamLogo.png"));
			int x = 80;
			int y = 80;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backArrow = resize.imageResizing();
			
			lblSun.setIcon(backArrow);
			lblSun.setBounds(515, 6, 88, 69);
		}
		return lblSun;
	}
	
	
	
	
	
	
	
	
	
	private void redirecPurchaseMain() {
		PurchaseMain main = new PurchaseMain();
		main.setVisible(true);
		dispose();
	}
	
	
	
	
}//end
