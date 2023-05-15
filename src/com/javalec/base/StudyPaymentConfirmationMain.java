package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.PaymentDao;
import com.javalec.function.ImageResize;

/* 스터디룸 키오스크에서 보여줄 결제 정보 확인(승인요청) 페이지 */
public class StudyPaymentConfirmationMain extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblPay;
	private JLabel lblPay_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;

	int sum;	// 총 구매내역

	private JLabel lblPay_2;
	
	


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
					StudyPaymentConfirmationMain frame = new StudyPaymentConfirmationMain();
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
	public StudyPaymentConfirmationMain() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				lblPay.setText(String.format("%,3d",sum));
			}
		});
		setTitle("카드결제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblPay());
		contentPane.add(getLblPay_1());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_1_1());
		contentPane.add(getLblPay_2());
		contentPane.add(getLblNewLabel());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(PaymentConfirmationMain.class.getResource("/com/javalec/image/payment.png")));
			lblNewLabel.setBounds(30, 30, 438, 476);
		}
		return lblNewLabel;
	}
	private JLabel getLblPay() {
		if (lblPay == null) {
			lblPay = new JLabel("");
			lblPay.setHorizontalAlignment(SwingConstants.TRAILING);
			lblPay.setForeground(new Color(255, 0, 0));
			lblPay.setFont(new Font("Lucida Grande", Font.BOLD, 25));
			lblPay.setBounds(240, 413, 196, 36);
		}
		return lblPay;
	}
	private JLabel getLblPay_1() {
		if (lblPay_1 == null) {
			lblPay_1 = new JLabel("일시불");
			lblPay_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPay_1.setForeground(new Color(0, 0, 0));
			lblPay_1.setFont(new Font("Lucida Grande", Font.BOLD, 25));
			lblPay_1.setBounds(319, 461, 138, 36);
		}
		return lblPay_1;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");

			ImageIcon icon = new ImageIcon(PurchaseMain.class.getResource("/com/javalec/image/cancle.png"));
			int x = 150;
			int y = 65;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backArrow = resize.imageResizing();
			
			lblNewLabel_1.setIcon(backArrow);
			
			lblNewLabel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					backpaymentMain();
				}
			});
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
			lblNewLabel_1.setBounds(30, 571, 150, 65);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("");
			
			ImageIcon icon = new ImageIcon(PurchaseMain.class.getResource("/com/javalec/image/KakaoTalk_Photo_2023-05-15-14-31-19 001.png"));
			int x = 250;
			int y = 100;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backArrow = resize.imageResizing();
			
			lblNewLabel_1_1.setIcon(backArrow);
			
			lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					purchaseAtcion();
				}
			});
			lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
			lblNewLabel_1_1.setBounds(252, 571, 216, 78);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblPay_2() {
		if (lblPay_2 == null) {
			lblPay_2 = new JLabel("원");
			lblPay_2.setForeground(Color.RED);
			lblPay_2.setFont(new Font("Lucida Grande", Font.BOLD, 25));
			lblPay_2.setBounds(435, 413, 22, 36);
		}
		return lblPay_2;
	}
	//
	
	private void backpaymentMain() {
		StudyPaymentMain main = new StudyPaymentMain();
		main.setSum(sum);
		dispose();
	}
	
	private void nextPaymentSuccessMain() {
		StudyPaymentSuccessMain main = new StudyPaymentSuccessMain();
		main.setVisible(true);
		dispose();
	}
	
	private void purchaseAtcion() {
		PaymentDao dao = new PaymentDao();
		boolean result = dao.addToPurchase();
		
		if(result) {
			nextPaymentSuccessMain();
			dao.deleteCart();
		}else {
			JOptionPane.showMessageDialog(this,"승인실패\n" +  "승인 중 문제가 발생했습니다. \n관리자에게 문의하세요!", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}
	
}// end

