package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;


/* 기본 키오스크에서 어드민이 로그인하는 페이지 */
public class AdminLoginMain extends JFrame {

	private JPanel contentPane;
	private JLabel lblLogoImage;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField tfUserId;
	private JLabel lblNewLabel_1_1;
	private JTextField textField;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLoginMain frame = new AdminLoginMain();
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
	public AdminLoginMain() {
		setTitle("관리자 로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblLogoImage());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getTfUserId());
		contentPane.add(getLblNewLabel_1_1());
		contentPane.add(getTextField_1());
		contentPane.add(getBtnNewButton());
	}
	private JLabel getLblLogoImage() {
		if (lblLogoImage == null) {
			lblLogoImage = new JLabel("로고로고");
			lblLogoImage.setBackground(new Color(242, 250, 63));
			lblLogoImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblLogoImage.setBounds(139, 56, 354, 350);
		}
		return lblLogoImage;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("관리자 로그인");
			lblNewLabel.setBounds(289, 448, 61, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("ID : ");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel_1.setBounds(64, 515, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JTextField getTfUserId() {
		if (tfUserId == null) {
			tfUserId = new JTextField();
			tfUserId.setBounds(149, 510, 261, 26);
			tfUserId.setColumns(10);
		}
		return tfUserId;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("PW : ");
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNewLabel_1_1.setBounds(64, 564, 61, 16);
		}
		return lblNewLabel_1_1;
	}
	private JTextField getTextField_1() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(149, 559, 261, 26);
		}
		return textField;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Log In");
			btnNewButton.setBounds(461, 510, 117, 100);
		}
		return btnNewButton;
	}
}
