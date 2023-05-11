package com.javalec.base;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class StudyUserSingUpMain extends JFrame {

	private JPanel contentPane;
	private JLabel lblHome;
	private JLabel lblLogo;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField tfId1;
	private JLabel lblNewLabel_1_1;
	private JTextField tfPassWord1;
	private JLabel lblNewLabel_1_2;
	private JTextField tfPassWordPass;
	private JLabel lblNewLabel_1_3;
	private JTextField tfTel1;
	private JButton btnJoin1;
	private JLabel lblNewLabel_1_4;
	private JLabel lblNewLabel_1_1_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudyUserSingUpMain frame = new StudyUserSingUpMain();
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
	public StudyUserSingUpMain() {
		setTitle("스터디룸 회원가입");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblHome());
		contentPane.add(getLblLogo());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getTfId1());
		contentPane.add(getLblNewLabel_1_1());
		contentPane.add(getTfPassWord1());
		contentPane.add(getLblNewLabel_1_2());
		contentPane.add(getTfPassWordPass());
		contentPane.add(getLblNewLabel_1_3());
		contentPane.add(getTfTel1());
		contentPane.add(getBtnJoin1());
		contentPane.add(getLblNewLabel_1_4());
		contentPane.add(getLblNewLabel_1_1_1());
	}

	private JLabel getLblHome() {
		if (lblHome == null) {
			lblHome = new JLabel("New label");
			lblHome.setBounds(18, 27, 61, 16);
		}
		return lblHome;
	}
	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("New label");
			lblLogo.setBounds(416, 27, 61, 16);
		}
		return lblLogo;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("회원 가입");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 50));
			lblNewLabel.setBounds(357, 118, 194, 71);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("회원 아이디");
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_1.setBounds(242, 244, 91, 16);
		}
		return lblNewLabel_1;
	}
	private JTextField getTfId1() {
		if (tfId1 == null) {
			tfId1 = new JTextField();
			tfId1.setBounds(380, 244, 214, 33);
			tfId1.setColumns(10);
		}
		return tfId1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("비밀번호");
			lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_1_1.setBounds(255, 312, 97, 21);
		}
		return lblNewLabel_1_1;
	}
	private JTextField getTfPassWord1() {
		if (tfPassWord1 == null) {
			tfPassWord1 = new JTextField();
			tfPassWord1.setColumns(10);
			tfPassWord1.setBounds(380, 312, 214, 33);
		}
		return tfPassWord1;
	}
	private JLabel getLblNewLabel_1_2() {
		if (lblNewLabel_1_2 == null) {
			lblNewLabel_1_2 = new JLabel("비밀번호 확인");
			lblNewLabel_1_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_1_2.setBounds(239, 384, 118, 21);
		}
		return lblNewLabel_1_2;
	}
	private JTextField getTfPassWordPass() {
		if (tfPassWordPass == null) {
			tfPassWordPass = new JTextField();
			tfPassWordPass.setColumns(10);
			tfPassWordPass.setBounds(380, 381, 214, 33);
		}
		return tfPassWordPass;
	}
	private JLabel getLblNewLabel_1_3() {
		if (lblNewLabel_1_3 == null) {
			lblNewLabel_1_3 = new JLabel("전화번호(Tel)");
			lblNewLabel_1_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_1_3.setBounds(239, 446, 118, 21);
		}
		return lblNewLabel_1_3;
	}
	private JTextField getTfTel1() {
		if (tfTel1 == null) {
			tfTel1 = new JTextField();
			tfTel1.setColumns(10);
			tfTel1.setBounds(380, 443, 214, 33);
		}
		return tfTel1;
	}
	private JButton getBtnJoin1() {
		if (btnJoin1 == null) {
			btnJoin1 = new JButton("가입");
			btnJoin1.setBounds(391, 518, 117, 51);
		}
		return btnJoin1;
	}
	private JLabel getLblNewLabel_1_4() {
		if (lblNewLabel_1_4 == null) {
			lblNewLabel_1_4 = new JLabel("ID");
			lblNewLabel_1_4.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_1_4.setBounds(279, 261, 26, 16);
		}
		return lblNewLabel_1_4;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("Password");
			lblNewLabel_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_1_1_1.setBounds(249, 331, 97, 26);
		}
		return lblNewLabel_1_1_1;
	}
}
