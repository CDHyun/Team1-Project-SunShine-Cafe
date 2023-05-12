package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;


/* 관리자가 전력사용 가능한 좌석과 관련된 작업을(좌석 사용 가능,불가능 설정) 하는 페이지 
 * 좌석 사용자가 없을 때 - 테이블 선택시 -> 상세정보 텍필 나띵 +  좌석 사용 불가 처리 (예약때문이든 뭐든) 버튼 + 좌석 사용 가능 처리 버튼 
 * 좌석 사용자가 있을 때 - 테이블 선택시 -> 현재 사용자에 대한 상세정보 텍필 자동완성 + 좌석 사용 불가능 처리 버튼 + 좌석 사용 가능 처리 버튼 */
public class AdminTableMain extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblHomeButton;
	private JButton btnTable1;
	private JButton btnTable2;
	private JButton btnTable3;
	private JButton btnTable4;
	private JButton btnTable5;
	private JButton btnTable6;
	private JButton btnTable7;
	private JButton btnTable8;
	private JLabel lblUserId;
	private JTextField tfUserId;
	private JLabel lblUserId_1;
	private JTextField textField;
	private JLabel lblUserId_2;
	private JTextField textField_1;
	private JLabel lblUserId_3;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminTableMain frame = new AdminTableMain();
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
	public AdminTableMain() {
		setTitle("좌석 관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblHomeButton());
		contentPane.add(getLblNewLabel());
		contentPane.add(getBtnTable1());
		contentPane.add(getBtnTable2());
		contentPane.add(getBtnTable3());
		contentPane.add(getBtnTable4());
		contentPane.add(getBtnTable5());
		contentPane.add(getBtnTable6());
		contentPane.add(getBtnTable7());
		contentPane.add(getBtnTable8());
		contentPane.add(getLblUserId());
		contentPane.add(getTfUserId());
		contentPane.add(getLblUserId_1());
		contentPane.add(getTextField());
		contentPane.add(getLblUserId_2());
		contentPane.add(getTextField_1());
		contentPane.add(getLblUserId_3());
		contentPane.add(getTextField_2());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("좌석 관리");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(0, 0, 625, 50);
		}
		return lblNewLabel;
	}
	private JLabel getLblHomeButton() {
		if (lblHomeButton == null) {
			lblHomeButton = new JLabel("홈화면");
			lblHomeButton.setBounds(0, 0, 50, 50);
		}
		return lblHomeButton;
	}
	private JButton getBtnTable1() {
		if (btnTable1 == null) {
			btnTable1 = new JButton("No.1");
			btnTable1.setHorizontalAlignment(SwingConstants.LEADING);
			btnTable1.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
			btnTable1.setBounds(24, 82, 100, 100);
		}
		return btnTable1;
	}
	private JButton getBtnTable2() {
		if (btnTable2 == null) {
			btnTable2 = new JButton("No.2");
			btnTable2.setHorizontalAlignment(SwingConstants.LEADING);
			btnTable2.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
			btnTable2.setBounds(155, 82, 100, 100);
		}
		return btnTable2;
	}
	private JButton getBtnTable3() {
		if (btnTable3 == null) {
			btnTable3 = new JButton("No.3");
			btnTable3.setHorizontalAlignment(SwingConstants.LEADING);
			btnTable3.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
			btnTable3.setBounds(298, 82, 100, 100);
		}
		return btnTable3;
	}
	private JButton getBtnTable4() {
		if (btnTable4 == null) {
			btnTable4 = new JButton("No.4");
			btnTable4.setHorizontalAlignment(SwingConstants.LEADING);
			btnTable4.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
			btnTable4.setBounds(439, 82, 100, 100);
		}
		return btnTable4;
	}
	private JButton getBtnTable5() {
		if (btnTable5 == null) {
			btnTable5 = new JButton("No.5");
			btnTable5.setHorizontalAlignment(SwingConstants.LEADING);
			btnTable5.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
			btnTable5.setBounds(24, 221, 100, 100);
		}
		return btnTable5;
	}
	private JButton getBtnTable6() {
		if (btnTable6 == null) {
			btnTable6 = new JButton("No.6");
			btnTable6.setHorizontalAlignment(SwingConstants.LEADING);
			btnTable6.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
			btnTable6.setBounds(155, 221, 100, 100);
		}
		return btnTable6;
	}
	private JButton getBtnTable7() {
		if (btnTable7 == null) {
			btnTable7 = new JButton("No.7");
			btnTable7.setHorizontalAlignment(SwingConstants.LEADING);
			btnTable7.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
			btnTable7.setBounds(298, 221, 100, 100);
		}
		return btnTable7;
	}
	private JButton getBtnTable8() {
		if (btnTable8 == null) {
			btnTable8 = new JButton("No.8");
			btnTable8.setHorizontalAlignment(SwingConstants.LEADING);
			btnTable8.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
			btnTable8.setBounds(439, 221, 100, 100);
		}
		return btnTable8;
	}
	private JLabel getLblUserId() {
		if (lblUserId == null) {
			lblUserId = new JLabel("사용 고객 : ");
			lblUserId.setBounds(24, 441, 61, 16);
		}
		return lblUserId;
	}
	private JTextField getTfUserId() {
		if (tfUserId == null) {
			tfUserId = new JTextField();
			tfUserId.setBounds(90, 436, 130, 26);
			tfUserId.setColumns(10);
		}
		return tfUserId;
	}
	private JLabel getLblUserId_1() {
		if (lblUserId_1 == null) {
			lblUserId_1 = new JLabel("주문 번호 : ");
			lblUserId_1.setBounds(24, 503, 61, 16);
		}
		return lblUserId_1;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(90, 498, 130, 26);
		}
		return textField;
	}
	private JLabel getLblUserId_2() {
		if (lblUserId_2 == null) {
			lblUserId_2 = new JLabel("이용 시작 시간 : ");
			lblUserId_2.setBounds(24, 561, 61, 16);
		}
		return lblUserId_2;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(90, 556, 130, 26);
		}
		return textField_1;
	}
	private JLabel getLblUserId_3() {
		if (lblUserId_3 == null) {
			lblUserId_3 = new JLabel("사용 고객 : ");
			lblUserId_3.setBounds(24, 390, 61, 16);
		}
		return lblUserId_3;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(90, 385, 130, 26);
		}
		return textField_2;
	}
}
