package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.UserSingUpDao;
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
	
	private JLabel lblid;
	private JLabel lblpw;
	private JLabel lblTel;
	
	
	

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
	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setEditable(false);
			tfPhone.setHorizontalAlignment(SwingConstants.LEFT);
			tfPhone.setColumns(10);
			tfPhone.setBounds(263, 571, 217, 37);
			
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
	        btnJoin.setBounds(244, 681, 117, 46);
	        
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
			lblNewLabel_2_2_1.setBounds(132, 403, 73, 32);
		}
		return lblNewLabel_2_2_1;
	}
	private JLabel getLblPass() {
		if (lblPass == null) {
			lblPass = new JLabel("");
			lblPass.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
			lblPass.setBounds(273, 509, 198, 16);
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
			        } else {
			            lblPass.setForeground(Color.BLACK);
			            lblPass.setText("비밀번호가 일치합니다.");
			        }
				}
			});
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
					pfUserPassword.setEditable(true);
					pfUserPassword1.setEditable(true);
					tfPhone.setEditable(true);
					
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
		String insertID = tfUserId.getText();
		UserSingUpDao singupdao = new UserSingUpDao();
		boolean isDuplicated = singupdao.checkID(insertID) == 1; 
		// DB에서 아이디를 찾고 중복값을 라벨에 보여주려면 boolean을 사용  꼭 뒤에 == 1 값을 넣어야한다.
		
		
		// 라벨에 중복값을 체크하여 설정값을 나오게 하는 코드 
		if(isDuplicated) {
			tfUserId.requestFocus();                 // 중복된 값이면 아이디에 다시 포커스 맞춰주기 
			tfUserId.setText("");                    // 중복된 값이면 아이디에 적힌 글자 지워주기 
			lblCheck.setText("중복된 아이디입니다.");
			lblCheck.setForeground(Color.RED);
			
		}else {
			lblCheck.setText("사용 가능한 아이디 입니다.");
			lblCheck.setForeground(Color.GREEN);
			if(!"".equals(new String(pfUserPassword.getPassword()))) {
				 
			}
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
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}// End
