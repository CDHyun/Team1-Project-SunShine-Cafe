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
	private JLabel lblHomeImage;
	private JButton lblCafeStart;
	private JButton btnMenuUpdate;
	private JButton btnTableCondition;
	private JButton btnCloseCafe;
	private JButton lblCafeEnd;

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
		setBounds(100, 100, 625, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblLogoImage());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblHomeImage());
		contentPane.add(getLblCafeStart());
		contentPane.add(getLblCafeEnd());
		contentPane.add(getBtnMenuUpdate());
		contentPane.add(getBtnTableCondition());
		contentPane.add(getBtnCloseCafe());
	}

	private JLabel getLblLogoImage() {
		if (lblLogoImage == null) {
			lblLogoImage = new JLabel("로고로고");
			lblLogoImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblLogoImage.setBackground(new Color(242, 250, 63));
			lblLogoImage.setBounds(163, 63, 300, 300);
		}
		return lblLogoImage;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("관리자 님, 환영합니다! ");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lblNewLabel.setBounds(0, 390, 625, 50);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("수행하실 작업을 선택해 주세요");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lblNewLabel_1.setBounds(0, 438, 625, 50);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblHomeImage() {
		if (lblHomeImage == null) {
			lblHomeImage = new JLabel("홈화면 이미지 (관리자 로그인 페이지로 백)");
			lblHomeImage.setBounds(6, 0, 61, 16);
		}
		return lblHomeImage;
	}
	private JButton getLblCafeStart() {
		if (lblCafeStart == null) {
			lblCafeStart = new JButton("영업 시작");
			lblCafeStart.setBounds(110, 545, 180, 85);
		}
		return lblCafeStart;
	}
	private JButton getLblCafeEnd() {
		if (lblCafeEnd == null) {
			lblCafeEnd = new JButton("영업 종료");
			lblCafeEnd.setBounds(310, 545, 180, 85);
		}
		return lblCafeEnd;
	}
	private JButton getBtnMenuUpdate() {
		if (btnMenuUpdate == null) {
			btnMenuUpdate = new JButton("입력 및 수정");
			btnMenuUpdate.setBounds(110, 642, 117, 29);
		}
		return btnMenuUpdate;
	}
	private JButton getBtnTableCondition() {
		if (btnTableCondition == null) {
			btnTableCondition = new JButton("테이블 관리");
			btnTableCondition.setBounds(233, 642, 117, 29);
		}
		return btnTableCondition;
	}
	private JButton getBtnCloseCafe() {
		if (btnCloseCafe == null) {
			btnCloseCafe = new JButton("정산");
			btnCloseCafe.setBounds(372, 642, 117, 29);
		}
		return btnCloseCafe;
	}
	
}
