package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.LoginDao;
import com.javalec.function.ImageResize;
import com.javalec.util.ShareVar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StudyLoginMain extends JFrame {

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
	private JLabel lblCheck;
	private JLabel lblPassCheck;
	
	////
//
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudyLoginMain frame = new StudyLoginMain();
					frame.setLocationRelativeTo(null);
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
	public StudyLoginMain() {
		setTitle("스터디룸 로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(248, 211, 72));

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
		contentPane.add(getLblCheck());
		contentPane.add(getLblPassCheck());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon(StudyLoginMain.class.getResource("/com/javalec/image/SunShineTeamLogoWhiteBackGround.png")));
			lblNewLabel.setBounds(49, 182, 243, 249);
			
			ImageIcon icon = new ImageIcon(AdminCalculateMain.class.getResource("/com/javalec/image/SunShineTeamLogoWhiteBackGround.png"));
			int x = 310;
			int y = 310;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backPage = resize.imageResizing();
			
			lblNewLabel.setIcon(backPage);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(80, 230, 310, 310);
			
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
			tfUserId.setHorizontalAlignment(SwingConstants.RIGHT);
			tfUserId.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					if (Character.getType(e.getKeyChar()) == Character.OTHER_LETTER) {
			            lblCheck.setText("영어와 숫자로만 입력할 수 있습니다.");
			            lblCheck.setForeground(Color.RED);
			            e.consume(); // 입력한 키 무시
			        } else {
			            lblCheck.setText("");
			        }
				}
			});
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
			pfPassword.setHorizontalAlignment(SwingConstants.RIGHT);
			pfPassword.setBounds(521, 416, 185, 41);
		}
		return pfPassword;
	}
		private JButton getBtnSingIn() {
		if (btnSingIn == null) {
			btnSingIn = new JButton("Login");
			btnSingIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    userIdCheck();
					insertFieldCheck();
					loginCheck();
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
					StudyRegisterMain studyUserSignUpMain = new StudyRegisterMain();
					studyUserSignUpMain.setLocationRelativeTo(null);
					studyUserSignUpMain.setVisible(true); // StudyUserSignUp 페이지를 보여주도록 설정
	                dispose(); // 현재 로그인 페이지를 닫습니다.
				}
			});
			btnSingUp.setBounds(553, 616, 117, 41);
		}
		return btnSingUp;
	}
	
	private JLabel getLblCheck() {
		if (lblCheck == null) {
			lblCheck = new JLabel("");
			lblCheck.setHorizontalAlignment(SwingConstants.CENTER);
			lblCheck.setBounds(511, 356, 209, 29);
		}
		return lblCheck;
	}
	private JLabel getLblPassCheck() {
		if (lblPassCheck == null) {
			lblPassCheck = new JLabel("");
			lblPassCheck.setBounds(531, 456, 175, 29);
		}
		return lblPassCheck;
	}
	
	
	
	//--------------- Function
	
	
	// 로그인 버튼 액션 설정 
	
	private void userIdCheck() {
		LoginDao loginDao = new LoginDao();
		
	    String userid = tfUserId.getText();
	    char[] pass = pfPassword.getPassword();
	    String password = new String(pass);

	    int userExists = loginDao.existsUserID(userid);
	    if (userExists == 0) {
	    	lblCheck.setText("아이디가 존재하지 않습니다.");
	    } else {
	    	lblCheck.setText("");
	    }
	    
	}

		
//  id, pw 확인하기 
	private int insertFieldCheck() {
		int i = 0;
		if (pfPassword.getPassword().length == 0) {
			i ++;
			lblPassCheck.setText("비밀번호를 입력해주세요.");
			pfPassword.requestFocus();
		}
		if (tfUserId.getText().trim().length() == 0) {
			i ++;
			message = "아이디를 ";
			lblCheck.setText("아이디를 입력해주세요.");
			tfUserId.requestFocus();
		}
		return i;
	}
		
		
	private void loginCheck() {
		String id = tfUserId.getText();
		char[] pass = pfPassword.getPassword();
		String password = new String(pass);
		
		LoginDao loginDao = new LoginDao(id, password) ;
		boolean result = loginDao.loginCheck(id, password);
		
		if (result == true) {
			JOptionPane.showMessageDialog(this, id + " 님, 환영합니다!", "로그인 성공!", JOptionPane.INFORMATION_MESSAGE);;
			ShareVar.userid = id;
			StudyProductMain studyProductMain = new StudyProductMain();
			studyProductMain.setLocationRelativeTo(null);
			studyProductMain.setVisible(true);
			dispose();
			} else {
				tfUserId.requestFocus();
			}
		}
		
	
		
		
		
	
}// End
