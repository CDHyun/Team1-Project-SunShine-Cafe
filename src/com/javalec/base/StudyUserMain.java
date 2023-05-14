package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.function.ImageResize;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;

/* 스터디룸 키오스크에서 남은 시간을 보여줄 유저 메인 페이지 */
public class StudyUserMain extends JFrame {

	private static final int TICKET_MINUTES = 60; // 이용권 시간(분)
	private static final int TICKET_SECONDS = TICKET_MINUTES * 60; // 이용권 시간(초)
	private static LocalDateTime startTime; // 이용 시작 시간
	private static int remainingSeconds; // 남은 시간(초)
	private static int timeElapasd = 0;
	
	
	
	private JPanel contentPane;
	private JLabel lblStudyImage;
	private JLabel lblName;
	private JButton btnNewButton;
	private JLabel lblStopWatch;
	private JLabel lblBackground;
	private JLabel lblStudyContent;
	private JLabel lblStudyProductEx;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudyUserMain frame = new StudyUserMain();
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
	public StudyUserMain() {
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowOpened(WindowEvent e) {
			timeCheck();
			}
		});
		setTitle("남은시간 및 주문내역");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblStudyContent());
		contentPane.add(getLblStudyImage());
		contentPane.add(getLblName());
		contentPane.add(getBtnNewButton());
		
		JLabel lblNewLabel_1_1 = new JLabel("남은시간");
		lblNewLabel_1_1.setBounds(175, 97, 154, 60);
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 25));
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnaddOrder = new JButton("추가주문");
		btnaddOrder.setBounds(719, 356, 117, 60);
		btnaddOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null,"추가주문하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_NO_OPTION){
				}else {
					int result2 = JOptionPane.showConfirmDialog(null,"취소하시겠습니까?", "확인", JOptionPane.CLOSED_OPTION);
					if (result2 == JOptionPane.CLOSED_OPTION){		      	
					
					}
					}
			}
		});
		btnaddOrder.setFont(new Font("Dialog", Font.PLAIN, 20));
		contentPane.add(btnaddOrder);
		contentPane.add(getLblStopWatch());
		
		JLabel lblStudyPrice = new JLabel("2,000원");
		lblStudyPrice.setBounds(731, 157, 106, 42);
		contentPane.add(lblStudyPrice);
		lblStudyPrice.setForeground(new Color(255, 0, 0));
		lblStudyPrice.setFont(new Font("Dialog", Font.PLAIN, 30));
		contentPane.add(getLblBackground());
		contentPane.add(getLblStudyProductEx());
	}

	private JLabel getLblStudyImage() {
		if (lblStudyImage == null) {
			lblStudyImage = new JLabel("");
			lblStudyImage.setBounds(0, 157, 271, 139);
			ImageIcon icon = new ImageIcon(StudyUserMain.class.getResource("/com/javalec/image/IceWaterMelon.png"));
			int x = 140;
			int y = 180;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon productIcon = resize.imageResizing();
			lblStudyImage.setIcon(productIcon);
			lblStudyImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblStudyImage.setBounds(-2, 84, 150, 215);
		}
		return lblStudyImage;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Sunshine Cafe");
			lblName.setBounds(226, 27, 411, 60);
			lblName.setFont(new Font("Lucida Grande", Font.BOLD, 50));
		}
		return lblName;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("종료하기");
			btnNewButton.setBounds(719, 36, 117, 60);
			btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		}
		return btnNewButton;
	}

	private void timeCheck() {
	

		
		startTime = LocalDateTime.now(); // 이용 시작 시간 설정
        remainingSeconds = TICKET_SECONDS; // 남은 시간 초기화
        // 1초마다 타이머 갱신
     
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
        	public void run() {
                remainingSeconds--;
                
                // 시간 종료되면 타이머 종료
                if (remainingSeconds == 0) {
                    timer.cancel();
                }
                
                // 화면에 남은 시간 출력
                int hour = remainingSeconds / 7200;
                int minutes = remainingSeconds / 60;
                int seconds = remainingSeconds % 60;
//              System.out.printf("남은 시간: %d분 %d초\n", minutes, seconds);
                lblStopWatch.setFont(new Font("Diglog",Font.BOLD, 18));
                lblStopWatch.setText(String.format("남은 시간: %d시 %d분 %d초\n", hour, minutes, seconds));
        	}
        }, 0, 1000);
    }
	
	private JLabel getLblStopWatch() {
		if (lblStopWatch == null) {
			lblStopWatch = new JLabel("");
			lblStopWatch.setBounds(341, 132, 223, 16);
		}
		return lblStopWatch;
	}
	private JLabel getLblBackground() {
		if (lblBackground == null) {
			lblBackground = new JLabel("");
			lblBackground.setIcon(new ImageIcon(StudyUserMain.class.getResource("/com/javalec/image/whiteBoard.png")));
			lblBackground.setForeground(new Color(255, 255, 255));
			lblBackground.setBackground(new Color(240, 240, 240));
			lblBackground.setBounds(0, 157, 884, 139);
		}
		return lblBackground;
	}
	private JLabel getLblStudyContent() {
		if (lblStudyContent == null) {
			lblStudyContent = new JLabel("New label");
			lblStudyContent.setBounds(293, 172, 271, 24);
		}
		return lblStudyContent;
	}
	private JLabel getLblStudyProductEx() {
		if (lblStudyProductEx == null) {
			lblStudyProductEx = new JLabel("아메리카노란");
			lblStudyProductEx.setBounds(293, 212, 271, 24);
		}
		return lblStudyProductEx;
	}
}


		
	

