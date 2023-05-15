package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.LoginDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudyUserSing extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField tfUserId;
	private JLabel lblNewLabel_3;
	private JPasswordField pfPassword;
	private JButton btnSingIn;
	private JLabel lblNewLabel_4;
	private JButton btnSingUp;
	
	
	String message;
	String userid;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudyUserSing frame = new StudyUserSing();
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
	public StudyUserSing() {
		setTitle("스터디룸 로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getTfUserId());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getPfPassword());
		contentPane.add(getBtnSingIn());
		contentPane.add(getLblNewLabel_4());
		contentPane.add(getBtnSingUp());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("New label");
			lblNewLabel.setBounds(49, 182, 243, 249);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("로그인");
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 40));
			lblNewLabel_1.setBounds(587, 153, 153, 68);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("ID  :");
			lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 20));
			lblNewLabel_2.setBounds(445, 316, 51, 29);
		}
		return lblNewLabel_2;
	}
	private JTextField getTfUserId() {
		if (tfUserId == null) {
			tfUserId = new JTextField();
			tfUserId.setBounds(521, 313, 185, 41);
			tfUserId.setColumns(10);
		}
		return tfUserId;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("PW :");
			lblNewLabel_3.setFont(new Font("Lucida Grande", Font.BOLD, 20));
			lblNewLabel_3.setBounds(445, 422, 64, 29);
		}
		return lblNewLabel_3;
	}
	private JPasswordField getPfPassword() {
		if (pfPassword == null) {
			pfPassword = new JPasswordField();
			pfPassword.setBounds(521, 416, 185, 41);
		}
		return pfPassword;
	}
	private JButton getBtnSingIn() {
		if (btnSingIn == null) {
			btnSingIn = new JButton("Login");
			btnSingIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					loginAction();
				}
			});
			btnSingIn.setFont(new Font("Lucida Grande", Font.BOLD, 20));
			btnSingIn.setBounds(746, 355, 117, 79);
		}
		return btnSingIn;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("아직 회원이 아니신가요?");
			lblNewLabel_4.setBounds(553, 555, 131, 16);
		}
		return lblNewLabel_4;
	}
	private JButton getBtnSingUp() {
		if (btnSingUp == null) {
			btnSingUp = new JButton("회원 가입");
			btnSingUp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StudyUserSingUpMain studyUserSingUpMain = new StudyUserSingUpMain();
					studyUserSingUpMain.setVisible(true); // UserSignUp 페이지를 보여주도록 설정
	                dispose(); // 현재 로그인 페이지를 닫습니다.
				}
			});
			btnSingUp.setBounds(553, 616, 117, 41);
		}
		return btnSingUp;
	}
	
	//--------------- Function
	
	
	// 로그인 버튼 액션 설정 
	
		private void loginAction() {
		    boolean result = true;
		    
		    // id, password 체크 
		    if(result) {
		        int i_chk = insertFieldCheck();
		        if(i_chk != 0) {
		            JOptionPane.showMessageDialog(this, "확인해 주세요", "로그인 오류", JOptionPane.INFORMATION_MESSAGE);
		        } else {
		            boolean loginResult = loginCheck();   // DB에서 유저 id, password가 있는지 확인 
		            if (loginResult) { // 로그인 성공시 ProductMain으로 이동 
		                JOptionPane.showMessageDialog(this, tfUserId.getText() + "님, 환영합니다!", "로그인 성공", JOptionPane.INFORMATION_MESSAGE);
		                StudyProductMain studyProductMain = new StudyProductMain();
		                studyProductMain.setVisible(true);
		                dispose();
		            } else {
		                JOptionPane.showMessageDialog(this, "아이디 혹은 비밀번호를 확인해 주세요", "로그인 실패", JOptionPane.INFORMATION_MESSAGE);
		                pfPassword.setText(""); // 비밀번호 입력창 초기화 
		                tfUserId.requestFocus();
		            }
		        }
		    } else {
		        JOptionPane.showMessageDialog(this, "아이디가 존재하지 않습니다.");
		        tfUserId.requestFocus();
		    }
		}

		
		
		
		
		
		
		
		
		
		
		//  id, pw 확인하기 
		private int insertFieldCheck() {
			int i = 0;
			
			if (new String (pfPassword.getPassword()).trim().length() == 0) {
				i ++;
				message = "비밀번호를 ";
				pfPassword.requestFocus();
			}
			if (tfUserId.getText().trim().length() == 0) {
				i ++;
				message = "아이디를 ";
				tfUserId.requestFocus();
				
			}
			return i;
		}
		
		
		// password 체크
		
		private boolean existsUserPassword() {
			boolean result = false;
			userid = new String (pfPassword.getPassword());
			LoginDao loginDao = new LoginDao();
			int count = loginDao.existsUserID(userid);
			if(count == 0) {
				return result = false;
			}else {
				return result = true;
			}
		}
		
		
		
		private boolean loginCheck() {
			String id = tfUserId.getText();
			char[] pass = pfPassword.getPassword();
			String password = new String(pass);
			
			LoginDao loginDao = new LoginDao(id, password);
			boolean result = loginDao.loginCheck(id, password);
			
			if(result == true) {
				
				ProductMain pm = new ProductMain();
				dispose();
			}else {
				if(tfUserId.getText().length() != 0) {
					
					tfUserId.setText(""); // 아이디 입력값 초기화
		            pfPassword.setText(""); // 비밀번호 입력값 초기화
					tfUserId.requestFocus();
				}
			}
			return result;
		}
	
	
	
	
}// End
