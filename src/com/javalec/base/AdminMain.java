package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

/* 기본 키오스크에서 어드민이 로그인 한 뒤 나오는 메인 페이지 */
public class AdminMain extends JFrame {

	private JPanel contentPane;
	private JLabel lblLogoImage;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMain frame = new AdminMain();
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
		setBounds(100, 100, 375, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblLogoImage());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getBtnNewButton());
	}

	private JLabel getLblLogoImage() {
		if (lblLogoImage == null) {
			lblLogoImage = new JLabel("로고로고");
			lblLogoImage.setBackground(new Color(242, 250, 63));
			lblLogoImage.setBounds(225, 100, 300, 300);
		}
		return lblLogoImage;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("관리자 님, 환영합니다! ");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lblNewLabel.setBounds(0, 450, 750, 50);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("수행하실 작업을 선택해 주세요");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lblNewLabel_1.setBounds(0, 500, 750, 50);
		}
		return lblNewLabel_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New button");
			btnNewButton.setBounds(50, 585, 650, 175);
		}
		return btnNewButton;
	}
}
