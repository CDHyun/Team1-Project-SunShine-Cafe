package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/* 스터디룸 키오스크에서 결제 수단을 선택하는 페이지 */
public class StudyPaymentMain extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
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
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("카드결제");
			lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_2.setBounds(68, 252, 75, 25);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("삼성페이/LG페이");
			lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
			lblNewLabel_2_1.setBounds(144, 255, 88, 25);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblcard() {
		if (lblcard == null) {
			lblcard = new JLabel("");
			lblcard.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					redirecPaymentConfirmationMain();
	
				}
			});
			lblcard.setBounds(87, 157, 126, 69);
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
	private JLabel getLblNewLabel_2_2() {
		if (lblNewLabel_2_2 == null) {
			lblNewLabel_2_2 = new JLabel("카카오페이");
			lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_2_2.setBounds(84, 473, 103, 25);
		}
		return lblNewLabel_2_2;
	}
	private JLabel getLblkakao() {
		if (lblkakao == null) {
			lblkakao = new JLabel("");
			lblkakao.setBounds(87, 392, 126, 69);
		}
		return lblkakao;
	}
	private JLabel getLblNewLabel_2_2_1() {
		if (lblNewLabel_2_2_1 == null) {
			lblNewLabel_2_2_1 = new JLabel("페이코");
			lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_2_2_1.setBounds(330, 473, 103, 25);
		}
		return lblNewLabel_2_2_1;
	}
	private JLabel getLblpayco() {
		if (lblpayco == null) {
			lblpayco = new JLabel("");
			lblpayco.setBounds(320, 392, 126, 69);
		}
		return lblpayco;
	}
	private JLabel getLblNewLabel_2_2_2() {
		if (lblNewLabel_2_2_2 == null) {
			lblNewLabel_2_2_2 = new JLabel("네이버페이");
			lblNewLabel_2_2_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_2_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_2_2_2.setBounds(583, 473, 103, 25);
		}
		return lblNewLabel_2_2_2;
	}
	private JLabel getLblnaver() {
		if (lblnaver == null) {
			lblnaver = new JLabel("");
			lblnaver.setBounds(573, 392, 126, 69);
		}
		return lblnaver;
	}
	private JLabel getLblNewLabel_2_2_3() {
		if (lblNewLabel_2_2_3 == null) {
			lblNewLabel_2_2_3 = new JLabel("제로페이");
			lblNewLabel_2_2_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_2_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_2_2_3.setBounds(84, 641, 103, 25);
		}
		return lblNewLabel_2_2_3;
	}
	private JLabel getLblzero() {
		if (lblzero == null) {
			lblzero = new JLabel("");
			lblzero.setBounds(87, 560, 126, 69);
		}
		return lblzero;
	}
	private JLabel getLblNewLabel_2_2_4() {
		if (lblNewLabel_2_2_4 == null) {
			lblNewLabel_2_2_4 = new JLabel("BC페이북");
			lblNewLabel_2_2_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_2_4.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_2_2_4.setBounds(327, 641, 103, 25);
		}
		return lblNewLabel_2_2_4;
	}
	private JLabel getLblpaybooc() {
		if (lblpaybooc == null) {
			lblpaybooc = new JLabel("");
			lblpaybooc.setBounds(320, 560, 126, 69);
		}
		return lblpaybooc;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("뒤로 가기");
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
		main.setVisible(true);
		dispose();
	}
	
	private void redirecPaymentConfirmationMain() {
		StudyPaymentConfirmationMain main = new StudyPaymentConfirmationMain();
		main.setSum(sum);
		main.setVisible(true);
		dispose();
	}
	
	
	
}// end
