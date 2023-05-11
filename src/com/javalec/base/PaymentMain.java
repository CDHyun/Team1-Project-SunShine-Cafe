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

/* 기본 키오스크에서 결제 수단을 선택하는 페이지 */
public class PaymentMain extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblback;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblcard;
	private JLabel lblNewLabel_1_1_1;
	private JLabel lblNewLabel_2_2;
	private JLabel lblkakao;
	private JLabel lblNewLabel_2_2_1;
	private JLabel lblpayco;
	private JLabel lblNewLabel_2_2_2;
	private JLabel lblnaver;
	private JLabel lblNewLabel_2_2_3;
	private JLabel lblzero;
	private JLabel lblNewLabel_2_2_4;
	private JLabel lblpaybooc;
	private JLabel lblWhite1;
	private JLabel lblWhite2;
	private JLabel lblWhite3;
	private JLabel lblWhite3_1;
	private JLabel lblWhite4;
	private JLabel lblWhite5;
	private JLabel lblWhite6;

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
		setBounds(100, 100, 750, 1200);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 224, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblback());
		contentPane.add(getLblNewLabel_1_1());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblNewLabel_2_1());
		contentPane.add(getLblcard());
		contentPane.add(getLblNewLabel_1_1_1());
		contentPane.add(getLblNewLabel_2_2());
		contentPane.add(getLblkakao());
		contentPane.add(getLblNewLabel_2_2_1());
		contentPane.add(getLblpayco());
		contentPane.add(getLblNewLabel_2_2_2());
		contentPane.add(getLblnaver());
		contentPane.add(getLblNewLabel_2_2_3());
		contentPane.add(getLblzero());
		contentPane.add(getLblNewLabel_2_2_4());
		contentPane.add(getLblpaybooc());
		contentPane.add(getLblWhite1());
		contentPane.add(getLblWhite2());
		contentPane.add(getLblWhite3());
		contentPane.add(getLblWhite4());
		contentPane.add(getLblWhite5());
		contentPane.add(getLblWhite6());
		
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Sunshine Cafe");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			lblNewLabel.setBounds(232, 6, 282, 69);
		}
		return lblNewLabel;
	}
	private JLabel getLblback() {
		if (lblback == null) {
			lblback = new JLabel("");
			ImageIcon icon = new ImageIcon(PaymentMain.class.getResource("/com/javalec/image/back.png"));
			int x = 50;
			int y = 50;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backArrow = resize.imageResizing();
			
			lblback.setIcon(backArrow);
			lblback.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
			lblback.setBounds(39, 6, 75, 69);
		}
		return lblback;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("카드결제");
			lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
			lblNewLabel_1_1.setBounds(56, 127, 119, 48);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("카드결제");
			lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_2.setBounds(56, 298, 75, 25);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("삼성페이/LG페이");
			lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			lblNewLabel_2_1.setBounds(132, 301, 88, 25);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblcard() {
		if (lblcard == null) {
			lblcard = new JLabel("");
		
			
			ImageIcon icon = new ImageIcon(PaymentMain.class.getResource("/com/javalec/image/card.png"));
			int x = 150;
			int y = 150;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backArrow = resize.imageResizing();
			
			lblcard.setIcon(backArrow);
			lblcard.setBounds(56, 196, 155, 90);
		}
		return lblcard;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("간편결제");
			lblNewLabel_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
			lblNewLabel_1_1_1.setBounds(56, 363, 119, 48);
		}
		return lblNewLabel_1_1_1;
	}
	private JLabel getLblNewLabel_2_2() {
		if (lblNewLabel_2_2 == null) {
			lblNewLabel_2_2 = new JLabel("카카오페이");
			lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_2_2.setBounds(84, 549, 103, 25);
		}
		return lblNewLabel_2_2;
	}
	private JLabel getLblkakao() {
		if (lblkakao == null) {
			lblkakao = new JLabel("");
			ImageIcon icon = new ImageIcon(PaymentMain.class.getResource("/com/javalec/image/kakao.png"));
			int x = 200;
			int y = 130;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backArrow = resize.imageResizing();
			
			lblkakao.setIcon(backArrow);
			lblkakao.setBounds(36, 426, 202, 128);
		}
		return lblkakao;
	}
	private JLabel getLblNewLabel_2_2_1() {
		if (lblNewLabel_2_2_1 == null) {
			lblNewLabel_2_2_1 = new JLabel("페이코");
			lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_2_2_1.setBounds(303, 549, 103, 25);
		}
		return lblNewLabel_2_2_1;
	}
	private JLabel getLblpayco() {
		if (lblpayco == null) {
			lblpayco = new JLabel("");
			lblpayco.setHorizontalAlignment(SwingConstants.CENTER);
			ImageIcon icon = new ImageIcon(PaymentMain.class.getResource("/com/javalec/image/payco.png"));
			int x = 300;
			int y = 300;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backArrow = resize.imageResizing();
			
			lblpayco.setIcon(backArrow);
			
			lblpayco.setBounds(278, 456, 155, 69);
		}
		return lblpayco;
	}
	private JLabel getLblNewLabel_2_2_2() {
		if (lblNewLabel_2_2_2 == null) {
			lblNewLabel_2_2_2 = new JLabel("네이버페이");
			lblNewLabel_2_2_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_2_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_2_2_2.setBounds(537, 547, 103, 25);
		}
		return lblNewLabel_2_2_2;
	}
	private JLabel getLblnaver() {
		if (lblnaver == null) {
			lblnaver = new JLabel("");
			ImageIcon icon = new ImageIcon(PaymentMain.class.getResource("/com/javalec/image/naver.png"));
			
			int x = 100;
			int y = 80;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backArrow = resize.imageResizing();
			
			lblnaver.setIcon(backArrow);
			
			
			lblnaver.setHorizontalAlignment(SwingConstants.CENTER);
			lblnaver.setBounds(522, 456, 126, 69);
		}
		return lblnaver;
	}
	private JLabel getLblNewLabel_2_2_3() {
		if (lblNewLabel_2_2_3 == null) {
			lblNewLabel_2_2_3 = new JLabel("제로페이");
			lblNewLabel_2_2_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_2_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_2_2_3.setBounds(84, 724, 103, 25);
		}
		return lblNewLabel_2_2_3;
	}
	private JLabel getLblzero() {
		if (lblzero == null) {
			lblzero = new JLabel("");
			ImageIcon icon = new ImageIcon(PaymentMain.class.getResource("/com/javalec/image/zero.png"));
			
			int x = 100;
			int y = 80;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backArrow = resize.imageResizing();
			
			lblzero.setIcon(backArrow);
			
			
			lblzero.setHorizontalAlignment(SwingConstants.RIGHT);
			lblzero.setBounds(61, 643, 126, 69);
		}
		return lblzero;
	}
	private JLabel getLblNewLabel_2_2_4() {
		if (lblNewLabel_2_2_4 == null) {
			lblNewLabel_2_2_4 = new JLabel("BC페이북");
			lblNewLabel_2_2_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_2_4.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_2_2_4.setBounds(303, 724, 103, 25);
		}
		return lblNewLabel_2_2_4;
	}
	private JLabel getLblpaybooc() {
		if (lblpaybooc == null) {
			lblpaybooc = new JLabel("");
			lblpaybooc.setHorizontalAlignment(SwingConstants.CENTER);
			ImageIcon icon = new ImageIcon(PaymentMain.class.getResource("/com/javalec/image/paybooc.png"));
			
			int x = 80;
			int y = 70;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backArrow = resize.imageResizing();
			
			lblpaybooc.setIcon(backArrow);
			lblpaybooc.setBounds(294, 643, 126, 69);
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
			
			
			lblWhite1.setBounds(18, 178, 260, 189);
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
			lblWhite2.setBounds(18, 426, 260, 189);
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
			lblWhite3.setBounds(240, 428, 260, 189);
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
			lblWhite4.setBounds(466, 426, 260, 189);
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
			lblWhite5.setBounds(18, 613, 260, 189);
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
			lblWhite6.setBounds(240, 613, 260, 189);
		}
		return lblWhite6;
	}
}
