package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.LoginDao;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginMain frame = new LoginMain();
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
					loginAcion();
				}
			});
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
			btnSingUp.setBounds(257, 672, 117, 54);
		}
		return btnSingUp;
	}
	private JPasswordField getPfUserPassWord() {
		if (pfUserPassWord == null) {
			pfUserPassWord = new JPasswordField();
			pfUserPassWord.setHorizontalAlignment(SwingConstants.RIGHT);
			pfUserPassWord.setBounds(221, 522, 205, 31);
		}
		return pfUserPassWord;
	}
	
	// -------------  Function ----------
	
	
	// 로그인 버튼 액션 설정 
	
	private void loginAcion() {
		boolean result = true;
		
		// id, password 체크 
		if(result) {
			int i_chk = insertFieldCheck();
			if(i_chk != 0) {
				JOptionPane.showMessageDialog(this, "로그인 오류", "확인해 주세요", JOptionPane.INFORMATION_MESSAGE);
			}else {
				loginCheck();   // DB에서 유저 id, password가 있는지 확인 
			}
		}else {
			JOptionPane.showMessageDialog(this, "아이디가 존재하지 않습니다.");
			tfUserId.requestFocus();
		}
	}
	
	
	
	
	
	
	
	
	
	
	//  id, pw 확인하기 
	private int insertFieldCheck() {
		int i = 0;
		
		if (new String (pfUserPassWord.getPassword()).trim().length() == 0) {
			i ++;
			message = "비밀번호를 ";
			pfUserPassWord.requestFocus();
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
		userid = new String (pfUserPassWord.getPassword());
		LoginDao loginDao = new LoginDao();
		int count = loginDao.existsUserID(userid);
		if(count == 0) {
			return result = false;
		}else {
			return result = true;
		}
	}
	
	
	
	private void loginCheck() {
		String id = tfUserId.getText();
		char[] pass = pfUserPassWord.getPassword();
		String password = new String(pass);
		
		LoginDao loginDao = new LoginDao(id, password);
		boolean result = loginDao.loginCheck(id, password);
		
		if(result == true) {
			JOptionPane.showMessageDialog(this, id, " 님, 환영합니다!", JOptionPane.INFORMATION_MESSAGE);
			ProductMain pm = new ProductMain();
			dispose();
		}else {
			if(tfUserId.getText().length() != 0) {
				JOptionPane.showMessageDialog(this, "로그인 실패", "아이디 혹은 비밀번호를 확인해 주세요", JOptionPane.INFORMATION_MESSAGE);
				tfUserId.requestFocus();
			}
		}
	}
	
/*
	// SQL Injection 방어용 코드 (root, sql문의 변수 이름들)
	String sql = "SELECT * FROM users WHERE user_id = ? AND password = ?";
	try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
	    PreparedStatement stmt = conn.prepareStatement(sql)) {
	    stmt.setString(1, tfUserId.getText());
	    stmt.setString(2, new String (pfUserPassWord.getPassword()));
	    ResultSet rs = stmt.executeQuery();
	    if (rs.next()) {
	        // 로그인 성공
	    } else {
	        // 로그인 실패
	    }
	} catch (SQLException ex) {
	    // 예외 처리
	}
}
*/
	
	
	
	
}// End
