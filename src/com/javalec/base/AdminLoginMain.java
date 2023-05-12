package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.AdminLoginDao;
import com.javalec.function.ImageResize;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/* 기본 키오스크에서 어드민이 로그인하는 페이지 */
public class AdminLoginMain extends JFrame {

	private JPanel contentPane;
	private JLabel lblLogoImage;
	private JLabel lblNewLabel;
	private JLabel lblAdminId;
	private JTextField tfAdminId;
	private JLabel lblAdminPw;
	private JButton btnNewButton;
	private JPasswordField pfAdminPw;
	
	String message = ""; 		// 관리자가 필드 입력시 제대로 입력하지 않은 값 알려주는 메시지 
	String adminId = ""; 		// 관리자가 입력한 아이디가 DB에 있는지 확인하기 위해 텍스트필드의 값 할당받는 변수.
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLoginMain frame = new AdminLoginMain();
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
	public AdminLoginMain() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tfAdminId.requestFocus(); 		// 로그인 창 열리면 자동으로 아이디 입력창에 포커스 주도록 
			}
		});
		setTitle("관리자 로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblLogoImage());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblAdminId());
		contentPane.add(getTfAdminId());
		contentPane.add(getLblAdminPw());
		contentPane.add(getPfAdminPw());
		contentPane.add(getBtnNewButton());
	}
	private JLabel getLblLogoImage() {
		if (lblLogoImage == null) {
			lblLogoImage = new JLabel("");
			ImageIcon icon = new ImageIcon(AdminLoginMain.class.getResource("/com/javalec/image/SunShineTeamLogo.png"));
			int x = 325;
			int y = 325;
			ImageResize resize = new ImageResize(icon, x, y); 		// 이미지 리사이즈 메소드 생성자 통해 호출해서 필요한 값 주기  
			ImageIcon logo = resize.imageResizing();				// 로고에 할당.
			
			lblLogoImage.setIcon(logo);
			
			lblLogoImage.setBackground(Color.WHITE);
			lblLogoImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblLogoImage.setBounds(150, 120, 325, 325);
		}
		return lblLogoImage;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("관리자 로그인");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(0, 475, 625, 50);
		}
		return lblNewLabel;
	}
	private JLabel getLblAdminId() {
		if (lblAdminId == null) {
			lblAdminId = new JLabel("ID : ");
			lblAdminId.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
			lblAdminId.setHorizontalAlignment(SwingConstants.TRAILING);
			lblAdminId.setBounds(64, 555, 60, 40);
		}
		return lblAdminId;
	}
	private JTextField getTfAdminId() {
		if (tfAdminId == null) {
			tfAdminId = new JTextField();
			tfAdminId.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			tfAdminId.setBounds(149, 555, 260, 40);
			tfAdminId.setColumns(10);
		}
		return tfAdminId;
	}
	private JLabel getLblAdminPw() {
		if (lblAdminPw == null) {
			lblAdminPw = new JLabel("PW : ");
			lblAdminPw.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
			lblAdminPw.setHorizontalAlignment(SwingConstants.TRAILING);
			lblAdminPw.setBounds(64, 620, 60, 40);
		}
		return lblAdminPw;
	}
	private JPasswordField getPfAdminPw() {
		if (pfAdminPw == null) {
			pfAdminPw = new JPasswordField();
			pfAdminPw.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			pfAdminPw.setBounds(149, 620, 260, 40);
		}
		return pfAdminPw;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Log In");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					loginAction();
				}
			});
			btnNewButton.setBounds(450, 555, 120, 105);
		}
		return btnNewButton;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	// -----------------Functions-----------------------
	
	/* 로그인 제대로 했는지 여부 확인 단계
	 * 1. 필드에 입력하지 않았는지 확인 -> insertFieldCheck()
	 * 2. staff DB에 관리자 아이디 존재하는지 확인 -> existAdminId()
	 * 3. 관리자가 아이디와 패스워드를 제대로 입력했는지 확인해서 환영/거부 창 띄우기 -> loginCheck()
	 * */
	
	// 로그인 액션 취하기 
	private void loginAction() {
		int idCheck = insertFieldCheck(); 		// 1. 입력창에 뭔가 입력됐는지 확인 
		if (idCheck != 0) { 		// 입력창에 아무것도 입력되지 않았을 때 
			JOptionPane.showMessageDialog(this, message + "확인해 주세요", "입력 정보 오류", JOptionPane.INFORMATION_MESSAGE);
		} else { 		// 입력창에 뭔가 입력 됐을 때 
			boolean result = true;
			if (tfAdminId.getText().length() != 0) { 		// 2. 관리자가 입력한 아이디가 db에 존재하는지 여부 확인 
				result = existAdminId(); 		// 존재 여부 T/F 반환 
			}
			
			if (result) { 		// 아이디 존재 여부 확인해서 
				loginCheck();	// 로그인 가능한지 체크해. loginCheck() 메소드가 되면 환영메시지, 안되면 실패시 작업 해줄거야. 
			} 
		}
	}
	
	
	private int insertFieldCheck() { 		// 1. 관리자가 Id나 Pw 필드에 뭔가를 입력 했는지 여부 확인
		int i = 0;
		
		if (tfAdminId.getText().trim().length() == 0) {
			i ++;
			message = "아이디를 ";
			tfAdminId.requestFocus();
		} 
		
		if (pfAdminPw.getText().trim().length() == 0) {
			i ++;
			message = "비밀번호를 ";
			pfAdminPw.requestFocus(); 		// pw 입력하도록 커서 돌려줌.
		}
		return i;
	}
	
	
	private boolean existAdminId() { 		// 2. 관리자가 Staff DB에 존재하는 아이디인지 체크 
		boolean result = false;
		adminId = tfAdminId.getText();
		AdminLoginDao adminLoginDao = new AdminLoginDao(); 				// 어드민 로그인 다오에서 관리자 아이디 존재 여부 체크 
		int count = adminLoginDao.existsAdminId(adminId);		// 
		if(count == 0) {
			return result = false;
		} else {
			return result = true;
		}
		
	}
	
	
	// 관리자 아이디 패스워드 정해서 코드 수정하기 
	private void loginCheck() { 		// 3. (1) 관리자가 아이디와 패스워드 제대로 입력했는지 확인 : AdminLoginDao에서. (2) 환영/거부 창 띄우기  
		String adminId = tfAdminId.getText();
		char[] pass = pfAdminPw.getPassword();
		String password = new String(pass);
		
		AdminLoginDao adminLoginDao = new AdminLoginDao(adminId, password) ; 			// 관리자 로그인 다오 가서 존재하는 데이터인지 확인해보기 (return result T/F)
		boolean result = adminLoginDao.loginCheck(adminId, password); 		
		
		if (result == true) { 		// DB에 관리자 정보 존재 O
			JOptionPane.showMessageDialog(this, adminId + " 님, 환영합니다!", "로그인 성공!", JOptionPane.INFORMATION_MESSAGE); 
		} else { 					// DB에 관리자 정보 존재 X
			if((adminId.length() != 0) || (password.length() != 0)) {
				JOptionPane.showMessageDialog(this, "아이디 혹은 비밀번호를 확인해 주세요", "로그인 실패", JOptionPane.INFORMATION_MESSAGE);
				tfAdminId.setText("");
				pfAdminPw.setText("");
				tfAdminId.requestFocus();
			}
		}
	
		
	
	
		
		
		
		
		
		
		
		
	}
	
}
