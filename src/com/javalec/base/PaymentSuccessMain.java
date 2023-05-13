package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;

/* 기본 키오스크에서 주문 완료가 뜨면서 주문번호 알려주는 페이지 */
public class PaymentSuccessMain extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_1_1;
	private JLabel lblNewLabel_1_1_1_1;
	private JLabel lblNewLabel_1_1_1_1_1;
	private JLabel lblNewLabel_1_1_1_1_1_1;
	private JLabel lblNewLabel_1_1_1_1_1_1_1;
	private JLabel lblNewLabel_1_1_1_1_1_2;
	private JLabel lblNewLabel_1_1_1_1_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentSuccessMain frame = new PaymentSuccessMain();
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
	public PaymentSuccessMain() {
	    addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowOpened(WindowEvent e) {
	            Timer timer = new Timer();			// 5초 뒤 종료
	            TimerTask task = new TimerTask() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						dispose();
					}
				};
	            timer.schedule(task, 5000);

	        }
	    });
		setTitle("결제 완료");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_1_1());
		contentPane.add(getLblNewLabel_1_1_1());
		contentPane.add(getLblNewLabel_1_1_1_1());
		contentPane.add(getLblNewLabel_1_1_1_1_1());
		contentPane.add(getLblNewLabel_1_1_1_1_1_1());
		contentPane.add(getLblNewLabel_1_1_1_1_1_1_1());
		contentPane.add(getLblNewLabel_1_1_1_1_1_2());
		contentPane.add(getLblNewLabel_1_1_1_1_2());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Sunshine Cafe");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			lblNewLabel.setBounds(164, 17, 282, 69);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("주문 완료");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 67));
			lblNewLabel_1.setBounds(164, 112, 282, 69);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("주문 번호");
			lblNewLabel_1_1.setForeground(Color.RED);
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			lblNewLabel_1_1.setBounds(164, 338, 282, 69);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("주문 번호");
			lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
			lblNewLabel_1_1_1.setBounds(6, 226, 282, 69);
		}
		return lblNewLabel_1_1_1;
	}
	private JLabel getLblNewLabel_1_1_1_1() {
		if (lblNewLabel_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1 = new JLabel("결제가 완료되었습니다.");
			lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
			lblNewLabel_1_1_1_1.setBounds(153, 565, 302, 45);
		}
		return lblNewLabel_1_1_1_1;
	}
	private JLabel getLblNewLabel_1_1_1_1_1() {
		if (lblNewLabel_1_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1_1 = new JLabel("카드리더기에서");
			lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1_1_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
			lblNewLabel_1_1_1_1_1.setBounds(114, 597, 170, 45);
		}
		return lblNewLabel_1_1_1_1_1;
	}
	private JLabel getLblNewLabel_1_1_1_1_1_1() {
		if (lblNewLabel_1_1_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1_1_1 = new JLabel("카드를 제거하세요.");
			lblNewLabel_1_1_1_1_1_1.setForeground(Color.RED);
			lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_1_1_1_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
			lblNewLabel_1_1_1_1_1_1.setBounds(293, 597, 250, 45);
		}
		return lblNewLabel_1_1_1_1_1_1;
	}
	private JLabel getLblNewLabel_1_1_1_1_1_1_1() {
		if (lblNewLabel_1_1_1_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1_1_1_1 = new JLabel("영수증");
			lblNewLabel_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_1_1_1_1_1_1_1.setForeground(Color.RED);
			lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
			lblNewLabel_1_1_1_1_1_1_1.setBounds(190, 633, 72, 45);
		}
		return lblNewLabel_1_1_1_1_1_1_1;
	}
	private JLabel getLblNewLabel_1_1_1_1_1_2() {
		if (lblNewLabel_1_1_1_1_1_2 == null) {
			lblNewLabel_1_1_1_1_1_2 = new JLabel("을 찾아가세요.");
			lblNewLabel_1_1_1_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_1_1_1_1_1_2.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
			lblNewLabel_1_1_1_1_1_2.setBounds(262, 633, 170, 45);
		}
		return lblNewLabel_1_1_1_1_1_2;
	}
	private JLabel getLblNewLabel_1_1_1_1_2() {
		if (lblNewLabel_1_1_1_1_2 == null) {
			lblNewLabel_1_1_1_1_2 = new JLabel("이용해주셔서 감사합니다.");
			lblNewLabel_1_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_1_1_2.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
			lblNewLabel_1_1_1_1_2.setBounds(153, 701, 302, 45);
		}
		return lblNewLabel_1_1_1_1_2;
	}
	
	
	
	
	
}// end

