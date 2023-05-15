package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.LoginDao;
import com.javalec.function.ImageResize;
import com.javalec.util.ShareVar;
import com.mysql.cj.protocol.Message;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/* 기본 키오스크에서 로그인 하는 페이지 */
public class LoginMain extends JFrame {

	private JPanel contentPane;
	private JLabel lblLogo;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField tfUserId;
	private JLabel lblNewLabel_2_1;
	private JButton btnSingIn;
	private JLabel lblNewLabel_3;
	private JButton btnSingUp;
	private JPasswordField pfUserPassWord;
	
	
	String message;
	String userid;
	private JLabel lblCheck;
	private JLabel lblPassCheck;

	//
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginMain frame = new LoginMain();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
//
	/**
	 * Create the frame.
	 */
	public LoginMain() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tfUserId.requestFocus();
			}
		});
		setTitle("유저 로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(248, 211, 72));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblLogo());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getTfUserId());
		contentPane.add(getLblNewLabel_2_1());
		contentPane.add(getBtnSingIn());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getBtnSingUp());
		contentPane.add(getPfUserPassWord());
		contentPane.add(getLblCheck());
		contentPane.add(getLblPassCheck());
	}
	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("New label");
			lblLogo.addMouseListener(new MouseAdapter() {
				int clickCount;
				@Override
				public void mouseClicked(MouseEvent e) {
					clickCount++;
					if(clickCount == 5) {
						AdminLoginMain adminLoginMain = new AdminLoginMain();
						adminLoginMain.setLocationRelativeTo(null);
						adminLoginMain.setVisible(true);
						dispose();
					}
					
				}
			});
			lblLogo.setIcon(new ImageIcon(LoginMain.class.getResource("/com/javalec/image/SunShineTeamLogoWhiteBackGround.png")));
			lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
			lblLogo.setBounds(62, 70, 148, 110);
			
			ImageIcon icon = new ImageIcon(AdminCalculateMain.class.getResource("/com/javalec/image/SunShineTeamLogoWhiteBackGround.png"));
			int x = 210;
			int y = 210;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backPage = resize.imageResizing();
			
			lblLogo.setIcon(backPage);
			lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
			lblLogo.setBounds(230, 70, 210, 210);
		}
		return lblLogo;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("로그인");
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 45));
			lblNewLabel_1.setBounds(253, 305, 121, 62);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("ID  :");
			lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 25));
			lblNewLabel_2.setBounds(148, 421, 61, 31);
		}
		return lblNewLabel_2;
	}
	private JTextField getTfUserId() {
		if (tfUserId == null) {
			tfUserId = new JTextField();
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
			tfUserId.setHorizontalAlignment(SwingConstants.RIGHT);
			tfUserId.setBounds(221, 421, 205, 33);
			tfUserId.setColumns(10);
		}
		return tfUserId;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("PW  :");
			lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.BOLD, 25));
			lblNewLabel_2_1.setBounds(136, 516, 73, 38);
		}
		return lblNewLabel_2_1;
	}
		private JButton getBtnSingIn() {
		if (btnSingIn == null) {
			btnSingIn = new JButton("LogIn");
			btnSingIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					userIdCheck();
					insertFieldCheck();
					loginCheck();
				}
			});//
			btnSingIn.setFont(new Font("Lucida Grande", Font.BOLD, 25));
			btnSingIn.setBounds(462, 444, 106, 92);
		}
		return btnSingIn;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("아직 회원이 아니신가요?");
			lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
			lblNewLabel_3.setBounds(253, 629, 148, 31);
		}
		return lblNewLabel_3;
	}
	private JButton getBtnSingUp() {
		if (btnSingUp == null) {
			btnSingUp = new JButton("회원 가입");
			btnSingUp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					UserSingUp userSingUp = new UserSingUp();
					userSingUp.setLocationRelativeTo(null);
					userSingUp.setVisible(true); // UserSignUp 페이지를 보여주도록 설정
	                dispose(); // 현재 로그인 페이지를 닫습니다.
				}
			});
			btnSingUp.setBounds(257, 672, 117, 54);
		}
		return btnSingUp;
	}
	private JPasswordField getPfUserPassWord() {
		if (pfUserPassWord == null) {
			pfUserPassWord = new JPasswordField();
			pfUserPassWord.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
				}
			});
			pfUserPassWord.setHorizontalAlignment(SwingConstants.RIGHT);
			pfUserPassWord.setBounds(221, 522, 205, 31);
		}
		return pfUserPassWord;
	}
	
	private JLabel getLblCheck() {
		if (lblCheck == null) {
			lblCheck = new JLabel("");
			lblCheck.setBounds(230, 455, 189, 31);
		}
		return lblCheck;
	}
	
	// -------------  Function ----------
	
	
	// 로그인 버튼 액션 설정 
	
	private void userIdCheck() {
		LoginDao loginDao = new LoginDao();
		
	    String userid = tfUserId.getText();
	    char[] pass = pfUserPassWord.getPassword();
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
		if (pfUserPassWord.getPassword().length == 0) {
			i ++;
			lblPassCheck.setText("비밀번호를 입력해주세요.");
			pfUserPassWord.requestFocus();
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
		char[] pass = pfUserPassWord.getPassword();
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
	
	private JLabel getLblPassCheck() {
		if (lblPassCheck == null) {
			lblPassCheck = new JLabel("");
			lblPassCheck.setBounds(230, 553, 189, 31);
		}
		return lblPassCheck;
	}
}