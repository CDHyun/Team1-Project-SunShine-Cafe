package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

/* 스터디룸 키오스크에서 남은 시간을 보여줄 유저 메인 페이지 */
public class StudyUserMain extends JFrame {

	private static final int TICKET_MINUTES = 60; // 이용권 시간(분)
	private static final int TICKET_SECONDS = TICKET_MINUTES * 60; // 이용권 시간(초)
	private static LocalDateTime startTime; // 이용 시작 시간
	private static int remainingSeconds; // 남은 시간(초)
	private static int timeElapasd = 0;
	
	
	
	private JPanel contentPane;
	private JLabel lblLogoImage;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JButton btnNewButton;
	private JLabel lblStopWatch;

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
		setBounds(100, 100, 900, 625);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblLogoImage());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblNewLabel_2_1());
		contentPane.add(getBtnNewButton());
		
		JLabel lblNewLabel_1_1 = new JLabel("남은시간");
		lblNewLabel_1_1.setBounds(75, 99, 233, 60);
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 50));
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("2,000원");
		lblNewLabel_2_1_1.setBounds(515, 157, 106, 36);
		lblNewLabel_2_1_1.setFont(new Font("Dialog", Font.PLAIN, 30));
		contentPane.add(lblNewLabel_2_1_1);
		
		JButton btnaddOrder = new JButton("추가주문");
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
		btnaddOrder.setBounds(719, 358, 117, 60);
		btnaddOrder.setFont(new Font("Dialog", Font.PLAIN, 20));
		contentPane.add(btnaddOrder);
		contentPane.add(getLblStopWatch());
	}

	private JLabel getLblLogoImage() {
		if (lblLogoImage == null) {
			lblLogoImage = new JLabel("");
			lblLogoImage.setBounds(12, 157, 198, 177);
		}
		return lblLogoImage;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Sunshine Cafe");
			lblNewLabel_1.setBounds(175, 27, 411, 60);
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 50));
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("(ICE) 아메리카노");
			lblNewLabel_2.setBounds(245, 157, 233, 36);
			lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("커피 설명");
			lblNewLabel_2_1.setBounds(245, 226, 471, 154);
			lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		}
		return lblNewLabel_2_1;
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
}


		
	

