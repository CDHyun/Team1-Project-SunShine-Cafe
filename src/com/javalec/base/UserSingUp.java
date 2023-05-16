package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.UserSingUpDao;
import com.javalec.function.ImageResize;

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
import javax.swing.ImageIcon;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



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
	private JTextField tfPhone;
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
	private JLabel lblNewLabel_2_5;
	private JTextField tfName;
	
	
	//

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserSingUp frame = new UserSingUp();
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
	public UserSingUp() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				btnJoin.setEnabled(false);
			}
		});
		setTitle("유저 회원가입");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(248, 211, 72));

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
		contentPane.add(getTfPhone());
		contentPane.add(getBtnJoin());
		contentPane.add(getLblNewLabel_2_2_1());
		contentPane.add(getLblPass());
		contentPane.add(getPfUserPassword());
		contentPane.add(getPfUserPassword1());
		contentPane.add(getBtnCheckID());
		contentPane.add(getLblCheck());
		contentPane.add(getLblCheck());
		contentPane.add(getLblNewLabel_2_5());
		contentPane.add(getTfName());
	}

	private JLabel getLblLogoImage() {
		if (lblLogoImage == null) {
			lblLogoImage = new JLabel("SunShine");
			lblLogoImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblLogoImage.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
			lblLogoImage.setBounds(184, 25, 299, 82);
		}
		return lblLogoImage;
	}
	private JLabel getLblHome() {
		if (lblHome == null) {
			lblHome = new JLabel("");
			lblHome.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					redirectLoginMain();
				}
			});
			lblHome.setIcon(new ImageIcon(UserSingUp.class.getResource("/com/javalec/image/back.png")));
			lblHome.setBounds(18, 25, 61, 16);
			
			ImageIcon icon = new ImageIcon(AdminCalculateMain.class.getResource("/com/javalec/image/back.png"));
			int x = 50;
			int y = 50;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backPage = resize.imageResizing();
			
			lblHome.setIcon(backPage);
			lblHome.setHorizontalAlignment(SwingConstants.CENTER);
			lblHome.setBounds(5, 0, 70, 70);
			
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
			lblNewLabel_2.setBounds(123, 320, 97, 32);
		}
		return lblNewLabel_2;
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
			tfUserId.setHorizontalAlignment(SwingConstants.LEFT);
			tfUserId.setBounds(266, 321, 222, 37);
			tfUserId.setColumns(10);
		}
		return tfUserId;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("ID");
			lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_2_1.setBounds(158, 349, 22, 16);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblNewLabel_2_2() {
		if (lblNewLabel_2_2 == null) {
			lblNewLabel_2_2 = new JLabel("PassWord");
			lblNewLabel_2_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_2_2.setBounds(123, 414, 92, 32);
		}
		return lblNewLabel_2_2;
	}
	private JLabel getLblNewLabel_2_3() {
		if (lblNewLabel_2_3 == null) {
			lblNewLabel_2_3 = new JLabel("비밀번호 확인");
			lblNewLabel_2_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_2_3.setBounds(123, 458, 117, 32);
		}
		return lblNewLabel_2_3;
	}
	private JLabel getLblNewLabel_2_4() {
		if (lblNewLabel_2_4 == null) {
			lblNewLabel_2_4 = new JLabel("전화 번호(Tel)");
			lblNewLabel_2_4.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_2_4.setBounds(123, 588, 126, 27);
		}
		return lblNewLabel_2_4;
	}
	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
		            if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
		                e.consume(); // 숫자 이외의 문자는 입력되지 않도록 함
		            }
					
				}
			});
			tfPhone.setEditable(false);
			tfPhone.setHorizontalAlignment(SwingConstants.LEFT);
			tfPhone.setColumns(10);
			tfPhone.setBounds(266, 586, 217, 37);
			
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
	        btnJoin.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
	        btnJoin.setBounds(244, 706, 117, 46);
	        
	    }
	    return btnJoin;
	}


	protected boolean register(String string, String string2, String string3) {
		// TODO Auto-generated method stub
		return false;
	}

	

	private JLabel getLblNewLabel_2_2_1() {
		if (lblNewLabel_2_2_1 == null) {
			lblNewLabel_2_2_1 = new JLabel("비밀번호");
			lblNewLabel_2_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_2_2_1.setBounds(135, 389, 73, 32);
		}
		return lblNewLabel_2_2_1;
	}
	private JLabel getLblPass() {
		if (lblPass == null) {
			lblPass = new JLabel("");
			lblPass.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
			lblPass.setBounds(276, 495, 198, 16);
		}
		return lblPass;
	}
	private JPasswordField getPfUserPassword() {
		if (pfUserPassword == null) {
			pfUserPassword = new JPasswordField();
			pfUserPassword.setEditable(false);
			pfUserPassword.setBounds(266, 390, 217, 37);
		}
		return pfUserPassword;
	}
	private JPasswordField getPfUserPassword1() {
		if (pfUserPassword1 == null) {
			pfUserPassword1 = new JPasswordField();
			pfUserPassword1.setEditable(false);
			pfUserPassword1.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					String pw = new String(pfUserPassword.getPassword());
			        String re_pw = new String(pfUserPassword1.getPassword());

			        
			     // 비밀번호 중복 체크 하면서 바로 라벨에 나오도록 하는 코드 
			        if (pw.equals("")) { // 비밀번호 TextField가 빈칸인 경우
			            lblPass.setForeground(Color.RED);
			            lblPass.setText("비밀번호를 입력해주세요.");
			            btnJoin.setEnabled(pfUserPassword.getPassword().equals(pfUserPassword1.getPassword()));
			        } else if (!pw.equals(re_pw)) {
			            lblPass.setForeground(Color.RED);
			            lblPass.setText("비밀번호가 일치하지 않습니다.");
			            btnJoin.setEnabled(pfUserPassword.getPassword().equals(pfUserPassword1.getPassword()));
			            pfUserPassword.requestFocus(); // 포커스 이동
			            pfUserPassword.setText("");    // 비밀번호 필드 값 지우기
			            pfUserPassword1.setText("");   // 비밀번호 확인 필드 값 지우기 
			        } else {
			            lblPass.setForeground(Color.BLACK);
			            lblPass.setText("비밀번호가 일치합니다.");
			        }
				}
			});
			pfUserPassword1.setBounds(266, 459, 217, 37);
		}
		return pfUserPassword1;
	}
	private JButton getBtnCheckID() {
		if (btnCheckID == null) {
			btnCheckID = new JButton("중복 확인");
			btnCheckID.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkID();
					pfUserPassword.setEditable(true);
					pfUserPassword1.setEditable(true);
					tfName.setEditable(true);
					tfPhone.setEditable(true);
					
				}
			});
			btnCheckID.setBounds(507, 326, 92, 29);
		}
		return btnCheckID;
	}
	
	private JLabel getLblCheck() {
		if (lblCheck == null) {
			lblCheck = new JLabel("");
			lblCheck.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
			lblCheck.setBounds(266, 361, 208, 16);
		}
		return lblCheck;
	}

	private JLabel getLblNewLabel_2_5() {
		if (lblNewLabel_2_5 == null) {
			lblNewLabel_2_5 = new JLabel("성함");
			lblNewLabel_2_5.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_2_5.setBounds(151, 538, 57, 32);
		}
		return lblNewLabel_2_5;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setEditable(false);
			tfName.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
			        if (Character.isDigit(c)) {
			            e.consume(); // 입력한 키를 무시함
			        }
				}
			});
			tfName.setHorizontalAlignment(SwingConstants.LEFT);
			tfName.setColumns(10);
			tfName.setBounds(266, 539, 222, 37);
		}
		return tfName;
	}
	
	
	// --------------- Function ------------------
	
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
	        lblCheck.setForeground(Color.BLACK);
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
			loginMain.setLocationRelativeTo(null);
			loginMain.setVisible(true);
			dispose();
		}
			
		return new String(rePass);
	}


	// TextField가 전부 적혀야 버튼 활성화 하는 메소드(전화 번호TestField에 글자 길이10~11자리까지만 적을수있게 변경) 
		private void checkButtonEnabled() {
			String phone = tfPhone.getText().replaceAll("[^0-9]", ""); // 입력된 전화번호에서 숫자만 추출
	        if (tfUserId.getText().isEmpty() || phone.length() < 10 || phone.length() > 11 || pfUserPassword.getPassword().length == 0 || pfUserPassword1.getPassword().length == 0) {
	            btnJoin.setEnabled(false);
	        } else {
	            btnJoin.setEnabled(true);
	        }
	    }
		
		private void redirectLoginMain() {
			LoginMain loginmain = new LoginMain();
			loginmain.setLocationRelativeTo(null);
			loginmain.setVisible(true);
			dispose();
		}
		
		//
		//
}// End