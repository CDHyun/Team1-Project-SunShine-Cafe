package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class UserSingUp extends JFrame {

	private JPanel contentPane;
	private JLabel lblLogoImage;
	private JLabel lblHome;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField tfId;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_2;
	private JTextField tfPassWord;
	private JLabel lblNewLabel_2_3;
	private JTextField tfPassWordPass;
	private JLabel lblNewLabel_2_4;
	private JTextField tfTel;
	private JButton btnJoin;
	private JLabel lblNewLabel_2_2_1;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserSingUp frame = new UserSingUp();
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
	public UserSingUp() {
		setTitle("유저 회원가입");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblLogoImage());
		contentPane.add(getLblHome());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getTfId());
		contentPane.add(getLblNewLabel_2_1());
		contentPane.add(getLblNewLabel_2_2());
		contentPane.add(getTfPassWord());
		contentPane.add(getLblNewLabel_2_3());
		contentPane.add(getTfPassWordPass());
		contentPane.add(getLblNewLabel_2_4());
		contentPane.add(getTfTel());
		contentPane.add(getBtnJoin());
		contentPane.add(getLblNewLabel_2_2_1());
		contentPane.add(getLblNewLabel());
	}

	private JLabel getLblLogoImage() {
		if (lblLogoImage == null) {
			lblLogoImage = new JLabel("New label");
			lblLogoImage.setBounds(263, 25, 61, 16);
		}
		return lblLogoImage;
	}
	private JLabel getLblHome() {
		if (lblHome == null) {
			lblHome = new JLabel("New label");
			lblHome.setBounds(18, 25, 61, 16);
		}
		return lblHome;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("회원 가입");
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 50));
			lblNewLabel_1.setBounds(204, 139, 194, 82);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("회원 아이디");
			lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_2.setBounds(120, 305, 97, 32);
		}
		return lblNewLabel_2;
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setBounds(258, 313, 222, 37);
			tfId.setColumns(10);
		}
		return tfId;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("ID");
			lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_2_1.setBounds(155, 334, 22, 16);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblNewLabel_2_2() {
		if (lblNewLabel_2_2 == null) {
			lblNewLabel_2_2 = new JLabel("PassWord");
			lblNewLabel_2_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_2_2.setBounds(120, 416, 92, 32);
		}
		return lblNewLabel_2_2;
	}
	private JTextField getTfPassWord() {
		if (tfPassWord == null) {
			tfPassWord = new JTextField();
			tfPassWord.setColumns(10);
			tfPassWord.setBounds(258, 402, 222, 39);
		}
		return tfPassWord;
	}
	private JLabel getLblNewLabel_2_3() {
		if (lblNewLabel_2_3 == null) {
			lblNewLabel_2_3 = new JLabel("비밀번호 확인");
			lblNewLabel_2_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_2_3.setBounds(120, 491, 117, 32);
		}
		return lblNewLabel_2_3;
	}
	private JTextField getTfPassWordPass() {
		if (tfPassWordPass == null) {
			tfPassWordPass = new JTextField();
			tfPassWordPass.setColumns(10);
			tfPassWordPass.setBounds(258, 486, 222, 37);
		}
		return tfPassWordPass;
	}
	private JLabel getLblNewLabel_2_4() {
		if (lblNewLabel_2_4 == null) {
			lblNewLabel_2_4 = new JLabel("전화 번호(Tel)");
			lblNewLabel_2_4.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_2_4.setBounds(120, 573, 126, 27);
		}
		return lblNewLabel_2_4;
	}
	private JTextField getTfTel() {
		if (tfTel == null) {
			tfTel = new JTextField();
			tfTel.setColumns(10);
			tfTel.setBounds(263, 571, 217, 37);
		}
		return tfTel;
	}
	private JButton getBtnJoin() {
		if (btnJoin == null) {
			btnJoin = new JButton("가입");
			btnJoin.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			btnJoin.setBounds(244, 681, 117, 46);
		}
		return btnJoin;
	}
	private JLabel getLblNewLabel_2_2_1() {
		if (lblNewLabel_2_2_1 == null) {
			lblNewLabel_2_2_1 = new JLabel("비밀번호");
			lblNewLabel_2_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_2_2_1.setBounds(132, 391, 73, 32);
		}
		return lblNewLabel_2_2_1;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("비밀번호가 불일치합니다.");
			lblNewLabel.setBounds(268, 523, 141, 16);
		}
		return lblNewLabel;
	}
}
