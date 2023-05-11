package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

/* 스터디룸 키오스크에서 남은 시간을 보여줄 유저 메인 페이지 */
public class StudyUserMain extends JFrame {

	private JPanel contentPane;
	private JLabel lblLogoImage;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField;
	private JLabel lblNewLabel_2_1;
	private JButton btnNewButton;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton_1;
	private JPasswordField pfPassWord1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudyUserMain frame = new StudyUserMain();
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
	public StudyUserMain() {
		setTitle("스터디룸 로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblLogoImage());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getTextField());
		contentPane.add(getLblNewLabel_2_1());
		contentPane.add(getBtnNewButton());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getBtnNewButton_1());
		contentPane.add(getPfPassWord1());
	}

	private JLabel getLblLogoImage() {
		if (lblLogoImage == null) {
			lblLogoImage = new JLabel("New label");
			lblLogoImage.setBounds(100, 201, 233, 205);
		}
		return lblLogoImage;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("로그인");
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 50));
			lblNewLabel_1.setBounds(557, 123, 150, 60);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("ID  :");
			lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lblNewLabel_2.setBounds(430, 242, 61, 36);
		}
		return lblNewLabel_2;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(513, 241, 194, 37);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("PW :");
			lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lblNewLabel_2_1.setBounds(430, 324, 71, 36);
		}
		return lblNewLabel_2_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("LogIn");
			btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			btnNewButton.setBounds(739, 271, 117, 60);
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("아직 회원이 아니신가요?");
			lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel_3.setBounds(557, 431, 160, 28);
		}
		return lblNewLabel_3;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("회원 가입");
			btnNewButton_1.setBounds(577, 471, 117, 60);
		}
		return btnNewButton_1;
	}
	private JPasswordField getPfPassWord1() {
		if (pfPassWord1 == null) {
			pfPassWord1 = new JPasswordField();
			pfPassWord1.setBounds(513, 324, 194, 37);
		}
		return pfPassWord1;
	}
}
