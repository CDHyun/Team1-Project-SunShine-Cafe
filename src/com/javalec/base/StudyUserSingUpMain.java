package com.javalec.base;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.UserSingUpDao;
import com.javalec.dto.UserSingUpDto;

import java.util.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.lang.String;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StudyUserSingUpMain extends JFrame {

	private JPanel contentPane;
	private JLabel lblHome;
	private JLabel lblLogo;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField tfUserId;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_1_3;
	private JTextField tfPhone;
	private JButton btnJoin;
	private JLabel lblNewLabel_1_4;
	private JLabel lblNewLabel_1_1_1;
	private JLabel lblCheck;
	private JLabel lblPass;
	private JButton btnCheckID;

	UserSingUpDto userSingUpDto = new UserSingUpDto();
	
	private String userid;
	private String userPassword;
	private String userPhone;
	
	private JLabel lblid;
	private JLabel lblpw;
	private JLabel lblTel;
	private JPasswordField pfUserPassword;
	private JPasswordField pfUserPassword1;

	
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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				btnJoin.setEnabled(false);
			}
		});
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
		contentPane.add(getTfUserId());
		contentPane.add(getLblNewLabel_1_1());
		contentPane.add(getLblNewLabel_1_2());
		contentPane.add(getLblNewLabel_1_3());
		contentPane.add(getTfPhone());
		contentPane.add(getBtnJoin());
		contentPane.add(getLblNewLabel_1_4());
		contentPane.add(getLblNewLabel_1_1_1());
		contentPane.add(getLblCheck());
		contentPane.add(getLblPass());
		contentPane.add(getBtnCheckID());
		contentPane.add(getPfUserPassword());
		contentPane.add(getPfUserPassword1());
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
			lblNewLabel_1.setBounds(143, 227, 91, 16);
		}
		return lblNewLabel_1;
	}
	private JTextField getTfUserId() {
		if (tfUserId == null) {
			tfUserId = new JTextField();
			tfUserId.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					// 입력한 키가 한글인 경우
			        if (Character.getType(e.getKeyChar()) == Character.OTHER_LETTER) {
			            lblCheck.setText("영어와 숫자로만 입력할 수 있습니다.");
			            lblCheck.setForeground(Color.RED);
			            e.consume(); // 입력한 키 무시
			        } else {
			            lblCheck.setText("");
			        }
				}
			});
			tfUserId.setHorizontalAlignment(SwingConstants.CENTER);
			tfUserId.setBounds(284, 222, 255, 38);
			tfUserId.setColumns(10);
		}
		return tfUserId;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("비밀번호");
			lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_1_1.setBounds(149, 316, 97, 21);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblNewLabel_1_2() {
		if (lblNewLabel_1_2 == null) {
			lblNewLabel_1_2 = new JLabel("비밀번호 확인");
			lblNewLabel_1_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_1_2.setBounds(143, 394, 118, 21);
		}
		return lblNewLabel_1_2;
	}
	private JLabel getLblNewLabel_1_3() {
		if (lblNewLabel_1_3 == null) {
			lblNewLabel_1_3 = new JLabel("전화번호(Tel)");
			lblNewLabel_1_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_1_3.setBounds(143, 470, 118, 21);
		}
		return lblNewLabel_1_3;
	}
	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setEditable(false);
			tfPhone.setHorizontalAlignment(SwingConstants.CENTER);
			tfPhone.setColumns(10);
			tfPhone.setBounds(284, 464, 255, 38);
			
			// 전화번호 TextField까지 입력을 해야 가입버튼 활성화 
						tfPhone.getDocument().addDocumentListener(new DocumentListener() {
				            @Override
				            public void insertUpdate(DocumentEvent e) {
				                checkButtonEnabled();
				            }

				            @Override
				            public void removeUpdate(DocumentEvent e) {
				                checkButtonEnabled();
				            }

				            @Override
				            public void changedUpdate(DocumentEvent e) {
				                checkButtonEnabled();
				            }
				        });
		}
		return tfPhone;
	}
	private JButton getBtnJoin() {
		if (btnJoin == null) {
			btnJoin = new JButton("가입");
			btnJoin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i_chk = JoinCheck();
	                if (i_chk == 0) {
						registerAction();
	                }
				}
			});
			btnJoin.setBounds(601, 513, 117, 51);
			
			
		}
		return btnJoin;
	}
	private JLabel getLblNewLabel_1_4() {
		if (lblNewLabel_1_4 == null) {
			lblNewLabel_1_4 = new JLabel("ID");
			lblNewLabel_1_4.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_1_4.setBounds(180, 244, 26, 16);
		}
		return lblNewLabel_1_4;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("Password");
			lblNewLabel_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_1_1_1.setBounds(143, 335, 97, 26);
		}
		return lblNewLabel_1_1_1;
	}
	private JLabel getLblCheck() {
		if (lblCheck == null) {
			lblCheck = new JLabel("");
			lblCheck.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
			lblCheck.setBounds(294, 259, 201, 16);
		}
		return lblCheck;
	}
	private JLabel getLblPass() {
		if (lblPass == null) {
			lblPass = new JLabel("");
			lblPass.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
			lblPass.setBounds(294, 426, 201, 16);
		}
		return lblPass;
	}
	private JButton getBtnCheckID() {
		if (btnCheckID == null) {
			btnCheckID = new JButton("중복 확인");
			btnCheckID.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkID();
					pfUserPassword.setEditable(true);
					pfUserPassword1.setEditable(true);
					tfPhone.setEditable(true);
				}
			});
			btnCheckID.setBounds(575, 225, 91, 29);
		}
		return btnCheckID;
	}
	
	//------------- Function ---------
	
	
	private int JoinCheck() {     // 값을 입력하지 않으면 뜨는 팝업창 
		int i = 0;
		String message = "";
		
	
		if (tfUserId.getText().trim().length() == 0) {
	        i++;
	        message = "아이디(는)";
	        tfUserId.requestFocus();
	    }
	    if (tfPhone.getText().trim().length() == 0) {
	    	i++;
	        message = "전화 번호(는)";
	        tfPhone.requestFocus();
	    }
	    if (i > 0) {
	        JOptionPane.showMessageDialog(null, message + " 필수 입력사항입니다.");
	    }
	    return i;
	}
	
	
	
	
	
	
	
	
	
	
	private void checkID() {
		String insertID = tfUserId.getText().trim().replaceAll("\\s+", "");
		

		// 입력된 아이디가 빈 문자열인 경우
	    if (insertID.isEmpty()) {
	        tfUserId.requestFocus();      // 아이디 입력창에 포커스 맞추기
	        lblCheck.setText("아이디를 입력해주세요.");  // 안내 문자 설정하기
	        lblCheck.setForeground(Color.RED);
	        return;   // 메소드 종료
	    }
		
		
		
		UserSingUpDao singupdao = new UserSingUpDao();
		int checkResult = singupdao.checkID(insertID); 
		// DB에서 아이디를 찾고 중복값을 라벨에 보여주려면 boolean을 사용  꼭 뒤에 == 1 값을 넣어야한다.
		
		
		// 라벨에 중복값을 체크하여 설정값을 나오게 하는 코드 
		// 아이디 입력 할때 2글자 이상부터 쓸수있도록 제한
	    if (checkResult == -1) {
	        tfUserId.requestFocus();      // 아이디 입력창에 포커스 맞추기
	        tfUserId.setText("");         // 입력된 아이디 지우기
	        lblCheck.setText("아이디는 두 글자 이상 입력해주세요.");  // 안내 문자 설정하기
	        lblCheck.setForeground(Color.RED);
	    }
	     // 라벨에 중복값을 체크하여 설정값을 나오게 하는 코드 
	    // 아이디가 중복된 경우
	    else if (checkResult == 1) {
	        tfUserId.requestFocus();
	        tfUserId.setText("");
	        lblCheck.setText("중복된 아이디입니다.");
	        lblCheck.setForeground(Color.RED);
	    }
	    // 아이디가 사용 가능한 경우
	    else {
	        lblCheck.setText("사용 가능한 아이디입니다.");
	        lblCheck.setForeground(Color.GREEN);
	        btnCheckID.setEnabled(false);      // 사용 가능할시 중복확인 버튼 비활성화 
	    }
	}		
	
	
	
	
	
	
	
	
	
	
	
	private String registerAction() {
		userid = tfUserId.getText();
		userPhone = tfPhone.getText();
		
		
		char[] Pass= pfUserPassword.getPassword();
		userPassword = new String(Pass);
		char[] rePass = pfUserPassword1.getPassword();
	
		UserSingUpDao UpDao = new UserSingUpDao();
		boolean result = UpDao.register(userid, userPassword, userPhone);
		if(result == true) {
			JOptionPane.showMessageDialog(this, userid + "님 회원가입을 축하합니다.");
			LoginMain loginMain = new LoginMain();
			loginMain.setVisible(true);
			dispose();
		}
			
		return new String(rePass);
	}
	
	
	
	
	
	
	
	private void checkButtonEnabled() {
	    if (tfUserId.getText().isEmpty() || tfPhone.getText().isEmpty() || pfUserPassword.getPassword().length == 0 || pfUserPassword1.getPassword().length == 0) {
	        btnJoin.setEnabled(false);
	    } else {
	        btnJoin.setEnabled(true);
	    }
	}
	private JPasswordField getPfUserPassword() {
		if (pfUserPassword == null) {
			pfUserPassword = new JPasswordField();
			pfUserPassword.setBounds(284, 316, 255, 38);
		}
		return pfUserPassword;
	}
	private JPasswordField getPfUserPassword1() {
		if (pfUserPassword1 == null) {
			pfUserPassword1 = new JPasswordField();
			pfUserPassword1.setBounds(284, 388, 255, 38);
		}
		return pfUserPassword1;
	}
}// End
