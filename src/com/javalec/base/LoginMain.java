package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;


/* 기본 키오스크에서 로그인 하는 페이지 */
public class LoginMain extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField tfId;
	private JLabel lblNewLabel_2_1;
	private JTextField tfPassword;
	private JButton btnSingIn;
	private JLabel lblNewLabel_3;
	private JButton btnSingUp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginMain frame = new LoginMain();
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
	public LoginMain() {
		setTitle("유저 로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getTfId());
		contentPane.add(getLblNewLabel_2_1());
		contentPane.add(getTfPassword());
		contentPane.add(getBtnSingIn());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getBtnSingUp());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("New label");
			lblNewLabel.setBounds(169, 57, 284, 223);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("로그인");
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 45));
			lblNewLabel_1.setBounds(253, 305, 121, 62);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("ID  :");
			lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 25));
			lblNewLabel_2.setBounds(148, 421, 61, 31);
		}
		return lblNewLabel_2;
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setBounds(221, 421, 205, 33);
			tfId.setColumns(10);
		}
		return tfId;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("PW  :");
			lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.BOLD, 25));
			lblNewLabel_2_1.setBounds(136, 516, 73, 38);
		}
		return lblNewLabel_2_1;
	}
	private JTextField getTfPassword() {
		if (tfPassword == null) {
			tfPassword = new JTextField();
			tfPassword.setColumns(10);
			tfPassword.setBounds(221, 516, 205, 37);
		}
		return tfPassword;
	}
	private JButton getBtnSingIn() {
		if (btnSingIn == null) {
			btnSingIn = new JButton("LogIn");
			btnSingIn.setFont(new Font("Lucida Grande", Font.BOLD, 25));
			btnSingIn.setBounds(462, 444, 106, 92);
		}
		return btnSingIn;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("아직 회원이 아니신가요?");
			lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
			lblNewLabel_3.setBounds(253, 629, 148, 31);
		}
		return lblNewLabel_3;
	}
	private JButton getBtnSingUp() {
		if (btnSingUp == null) {
			btnSingUp = new JButton("회원 가입");
			btnSingUp.setBounds(257, 672, 117, 54);
		}
		return btnSingUp;
	}
}
