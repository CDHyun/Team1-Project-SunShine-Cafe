package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.LoginDao;
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
	private JLabel lblIdCheck;
	private JLabel lblPassCheck;

	
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
		contentPane.add(getLblIdCheck());
		contentPane.add(getLblPassCheck());
	}
	private JLabel getLblLogo() {
		if (lblLogo == null) {
			lblLogo = new JLabel("New label");
			lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
			lblLogo.setBounds(169, 57, 284, 223);
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
				public void keyPressed(KeyEvent e) {
					
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
	
	private JLabel getLblIdCheck() {
		if (lblIdCheck == null) {
			lblIdCheck = new JLabel("");
			lblIdCheck.setBounds(148, 462, 223, 31);
		}
		return lblIdCheck;
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
	    	lblIdCheck.setText("아이디가 존재하지 않습니다.");
	    } else {
	    	lblIdCheck.setText("");
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
			lblIdCheck.setText("아이디를 입력해주세요.");
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
			ProductMain productMain = new ProductMain();
			productMain.setLocationRelativeTo(null);
			productMain.setVisible(true);
			dispose();
			} else {
			if(tfUserId.getText().length() != 0) {
				JOptionPane.showMessageDialog(this, "아이디 혹은 비밀번호를 확인해 주세요", "로그인 실패", JOptionPane.INFORMATION_MESSAGE);
				pfUserPassWord.setText("");
				tfUserId.requestFocus();
			}
		}
	}
	private JLabel getLblPassCheck() {
		if (lblPassCheck == null) {
			lblPassCheck = new JLabel("");
			lblPassCheck.setBounds(148, 566, 223, 31);
		}
		return lblPassCheck;
	}
}// End
