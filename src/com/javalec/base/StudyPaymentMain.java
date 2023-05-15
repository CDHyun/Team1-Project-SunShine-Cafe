package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.function.ImageResize;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

/* 스터디룸 키오스크에서 결제 수단을 선택하는 페이지 */
public class StudyPaymentMain extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1_1;
	private JLabel lblcard;
	private JLabel lblNewLabel_1_1_1;
	private JLabel lblkakao;
	private JLabel lblpayco;
	private JLabel lblnaver;
	private JLabel lblzero;
	private JLabel lblpaybooc;
	private JLabel lblNewLabel_1;

	int sum = 0;

	

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudyPaymentMain frame = new StudyPaymentMain();
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
	public StudyPaymentMain() {
		setTitle("결제 수단 선택");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 750);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1_1());
		contentPane.add(getLblcard());
		contentPane.add(getLblNewLabel_1_1_1());
		contentPane.add(getLblkakao());
		contentPane.add(getLblpayco());
		contentPane.add(getLblnaver());
		contentPane.add(getLblzero());
		contentPane.add(getLblpaybooc());
		contentPane.add(getLblNewLabel_1());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Sunshine Cafe");
			lblNewLabel.setBounds(320, 21, 276, 48);
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("카드결제");
			lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
			lblNewLabel_1_1.setBounds(68, 87, 119, 48);
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
			lblcard.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					redirecPaymentConfirmationMain();
	
				}
			});
			lblcard.setBounds(48, 147, 165, 137);
		}
		return lblcard;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("간편결제");
			lblNewLabel_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
			lblNewLabel_1_1_1.setBounds(68, 317, 119, 48);
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
			lblkakao.setBounds(48, 377, 150, 154);
		}
		return lblkakao;
	}
	private JLabel getLblpayco() {
		if (lblpayco == null) {
			lblpayco = new JLabel("");
			ImageIcon icon = new ImageIcon(PaymentMain.class.getResource("/com/javalec/image/paycopay.png"));
			int x = 150;
			int y = 150;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backArrow = resize.imageResizing();
			
			lblpayco.setIcon(backArrow);
			lblpayco.setBounds(340, 377, 150, 154);
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
			lblnaver.setBounds(634, 377, 165, 154);
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
			lblzero.setBounds(48, 543, 150, 156);
		}
		return lblzero;
	}
	private JLabel getLblpaybooc() {
		if (lblpaybooc == null) {
			lblpaybooc = new JLabel("");
			ImageIcon icon = new ImageIcon(PaymentMain.class.getResource("/com/javalec/image/payboocpay.png"));
			
			int x = 150;
			int y = 150;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backArrow = resize.imageResizing();
			
			lblpaybooc.setIcon(backArrow);
			lblpaybooc.setBounds(340, 543, 158, 156);
		}
		return lblpaybooc;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			ImageIcon icon = new ImageIcon(PaymentMain.class.getResource("/com/javalec/image/back.png"));
			int x = 50;
			int y = 50;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backArrow = resize.imageResizing();
			
			lblNewLabel_1.setIcon(backArrow);
			lblNewLabel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					redirecPurchaseMain();
					
				}
			});
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
			lblNewLabel_1.setBounds(26, 16, 119, 69);
		}
		return lblNewLabel_1;
	}
	
	
	private void redirecPurchaseMain() {
		StudyPurchaseMain main = new StudyPurchaseMain();
		main.setLocationRelativeTo(null);
		main.setVisible(true);
		dispose();
	}
	
	private void redirecPaymentConfirmationMain() {
		StudyPaymentConfirmationMain main = new StudyPaymentConfirmationMain();
		main.setLocationRelativeTo(null);
		main.setSum(sum);
		main.setVisible(true);
		dispose();
	}
	
	
	
}// end
