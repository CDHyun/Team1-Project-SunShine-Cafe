package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.UserSingUpDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserSingUp extends JFrame {

	private JPanel contentPane;
	private JLabel lblLogoImage;
	private JLabel lblHome;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField tfUserId;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_2;
	private JLabel lblNewLabel_2_3;
	private JLabel lblNewLabel_2_4;
	private JTextField tfPhon;
	private JButton btnJoin;
	private JLabel lblNewLabel_2_2_1;
	private JLabel lblPass;
	private JPasswordField pfUserPassword;
	private JPasswordField pfUserPassword1;
	private JButton btnCheckID;
	private JLabel lblCheck;
	
	
	private String userid;
	private String userPassword;
	private String userPhone;
	private JLabel lblid;
	private JLabel lblpw;
	private JLabel lblTel;
	private String register;
	
	

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
		contentPane.add(getTfUserId());
		contentPane.add(getLblNewLabel_2_1());
		contentPane.add(getLblNewLabel_2_2());
		contentPane.add(getLblNewLabel_2_3());
		contentPane.add(getLblNewLabel_2_4());
		contentPane.add(getTfPhon());
		contentPane.add(getBtnJoin());
		contentPane.add(getLblNewLabel_2_2_1());
		contentPane.add(getLblPass());
		contentPane.add(getPfUserPassword());
		contentPane.add(getPfUserPassword1());
		contentPane.add(getBtnCheckID());
		contentPane.add(getLblCheck());
		contentPane.add(getLblCheck());
		contentPane.add(getLblid());
		contentPane.add(getLblpw());
		contentPane.add(getLblTel());
	}

	private JLabel getLblLogoImage() {
		if (lblLogoImage == null) {
			lblLogoImage = new JLabel("New label");
			lblLogoImage.setBounds(283, 25, 61, 16);
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
			lblNewLabel_1.setBounds(228, 136, 194, 82);
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
	private JTextField getTfUserId() {
		if (tfUserId == null) {
			tfUserId = new JTextField();
			tfUserId.setHorizontalAlignment(SwingConstants.LEFT);
			tfUserId.setBounds(263, 306, 222, 37);
			tfUserId.setColumns(10);
		}
		return tfUserId;
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
			lblNewLabel_2_2.setBounds(120, 428, 92, 32);
		}
		return lblNewLabel_2_2;
	}
	private JLabel getLblNewLabel_2_3() {
		if (lblNewLabel_2_3 == null) {
			lblNewLabel_2_3 = new JLabel("비밀번호 확인");
			lblNewLabel_2_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_2_3.setBounds(120, 472, 117, 32);
		}
		return lblNewLabel_2_3;
	}
	private JLabel getLblNewLabel_2_4() {
		if (lblNewLabel_2_4 == null) {
			lblNewLabel_2_4 = new JLabel("전화 번호(Tel)");
			lblNewLabel_2_4.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_2_4.setBounds(120, 573, 126, 27);
		}
		return lblNewLabel_2_4;
	}
	private JTextField getTfPhon() {
		if (tfPhon == null) {
			tfPhon = new JTextField();
			tfPhon.setEditable(false);
			tfPhon.setHorizontalAlignment(SwingConstants.LEFT);
			tfPhon.setColumns(10);
			tfPhon.setBounds(263, 571, 217, 37);
		}
		return tfPhon;
	}
	private JButton getBtnJoin() {
		if (btnJoin == null) {
			btnJoin = new JButton("가입");
			btnJoin.setEnabled(false);
			btnJoin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i_chk = JoinCheck();
					if (i_chk == 0) {
						String userRePass = registerAction();
						if(userRePass != null && userRePass.equals(userPassword)) {
							lblPass.setForeground(Color.BLACK);
							lblPass.setText("비밀 번호가 일치합니다.");
							register();
						}else {
							lblPass.setForeground(Color.RED);
							lblPass.setText("비밀 번호가 일치하지 않습니다.");
						}
					}
				}
			});
			btnJoin.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			btnJoin.setBounds(244, 681, 117, 46);
		}
		return btnJoin;
	}
	protected void register() {
		// TODO Auto-generated method stub
		
	}

	private JLabel getLblNewLabel_2_2_1() {
		if (lblNewLabel_2_2_1 == null) {
			lblNewLabel_2_2_1 = new JLabel("비밀번호");
			lblNewLabel_2_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_2_2_1.setBounds(132, 403, 73, 32);
		}
		return lblNewLabel_2_2_1;
	}
	private JLabel getLblPass() {
		if (lblPass == null) {
			lblPass = new JLabel("");
			lblPass.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
			lblPass.setBounds(273, 509, 141, 16);
		}
		return lblPass;
	}
	private JPasswordField getPfUserPassword() {
		if (pfUserPassword == null) {
			pfUserPassword = new JPasswordField();
			pfUserPassword.setEditable(false);
			pfUserPassword.setBounds(263, 404, 217, 37);
		}
		return pfUserPassword;
	}
	private JPasswordField getPfUserPassword1() {
		if (pfUserPassword1 == null) {
			pfUserPassword1 = new JPasswordField();
			pfUserPassword1.setEditable(false);
			pfUserPassword1.setBounds(263, 473, 217, 37);
		}
		return pfUserPassword1;
	}
	private JButton getBtnCheckID() {
		if (btnCheckID == null) {
			btnCheckID = new JButton("중복 확인");
			btnCheckID.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkID();
					tfU
				}
			});
			btnCheckID.setBounds(504, 311, 92, 29);
		}
		return btnCheckID;
	}
	
	private JLabel getLblCheck() {
		if (lblCheck == null) {
			lblCheck = new JLabel("");
			lblCheck.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
			lblCheck.setBounds(263, 346, 208, 16);
		}
		return lblCheck;
	}

	private JLabel getLblid() {
		if (lblid == null) {
			lblid = new JLabel("");
			lblid.setBounds(263, 292, 194, 16);
		}
		return lblid;
	}
	private JLabel getLblpw() {
		if (lblpw == null) {
			lblpw = new JLabel("");
			lblpw.setBounds(263, 381, 194, 27);
		}
		return lblpw;
	}
	private JLabel getLblTel() {
		if (lblTel == null) {
			lblTel = new JLabel("");
			lblTel.setBounds(263, 556, 208, 16);
		}
		return lblTel;
	}

	// --------------- Function ------------------
	
	private int JoinCheck() {
		int i = 0;
		String message = "";
		
	
		if(lblid.getText().trim().length() == 0){
			i++;
			message = "아이디(는)";
			lblid.requestFocus();
		}
		if(lblpw.getText().trim().length() == 0){
			i++;
			message = "비밀 번호(는)";
			lblpw.requestFocus();
		}
		if(lblTel.getText().trim().length() == 0){
			i++;
			message = "전화 번호(는)";
			lblTel.requestFocus();
		}
		if(i>0) {
			JOptionPane.showMessageDialog(null, message + "필수 입력사항입니다.");
		}
		return i;
	}
	
	
	
	
	
	
	
	
	
	
	private void checkID() {
		String insertID = tfUserId.getText();
		UserSingUpDao singupdao = new UserSingUpDao();
		boolean isDuplicated = singupdao.checkID(insertID) == 1; 
		// DB에서 아이디를 찾고 중복값을 라벨에 보여주려면 boolean을 사용  꼭 뒤에 == 1 값을 넣어야한다.
		
		
		// 라벨에 중복값을 체크하여 설정값을 나오게 하는 코드 
		if(isDuplicated) {
			lblCheck.setText("중복된 아이디입니다.");
			lblCheck.setForeground(Color.RED);
		}else {
			lblCheck.setText("사용 가능한 아이디 입니다.");
			lblCheck.setForeground(Color.GREEN);
		
		}
	}		
	
	
	private String registerAction() {
		userid = tfUserId.getText();
		
		char[] Pass= pfUserPassword.getPassword();
		userPassword = new String(Pass);
		char[] rePass = pfUserPassword1.getPassword();
		return new String(rePass);
	
		
	}

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}// End
