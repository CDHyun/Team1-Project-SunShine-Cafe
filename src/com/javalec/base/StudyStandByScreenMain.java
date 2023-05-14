package com.javalec.base;

import java.awt.EventQueue;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Time;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

	public class StudyStandByScreenMain extends JFrame {
//	public class ImageSlide extends JPanel implements ActionListener{

		
			
	
		

	Timer timer = new Timer();
	 
	private JPanel contentPane;
	private JPanel panel; 
//	private JLabel adMessage;
//	private JLabel adImage;
	private String[] messages = {"광고 메시지 1", "광고 메시지 2", "광고 메시지 3"};
//	private ImageIcon[] images = {new ImageIcon("image1.jpg"), new ImageIcon("image2.jpg"), new ImageIcon("image3.jpg")};
	private int currentAdIndex = 0;
	private int adInterval = 5000;
	private static final int TICKET_MINUTES = 60; // 이용권 시간(분)
	private static final int TICKET_SECONDS = TICKET_MINUTES * 60; // 이용권 시간(초)
	private static LocalDateTime startTime; // 이용 시작 시간
	private static int remainingSeconds; // 남은 시간(초)
	int count = 0;
	final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudyStandByScreenMain frame = new StudyStandByScreenMain();
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
	public StudyStandByScreenMain() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
			windowopen();
			
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 100, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 634, 749);
		contentPane.add(panel_1);
		
		JButton btnNewButton_1 = new JButton("30분");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//			remainingSeconds += 30*60;				버튼 누르면 30분 추가되면서 시간 연장가능
			}
		});
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("1시간");
		panel_1.add(btnNewButton);
	}
	


	public void windowopen() {
 
	 Timer timer = new Timer();
	 TimerTask task = new TimerTask() {
		 @Override
		 public void run() {
			 // TODO Auto-generated method stub
			 if(count <= 1) {
				 System.out.println("Image1");
				 count++;
			 }
			 else if(count <=2){
				 System.out.println("Image2");
				 count++;
			 }
			 else if(count <=3){
				 System.out.println("Image3");
				 count++;
				 
			 }else {
				 
			 }
		 }
	 };
	 timer.schedule(task, 1000, 2000);
		 }
	}
		 
	 // 설정 시간 값에서 떨어지는 데이터 값
	
//	final Runnable runnable = new Runnable() {
//	int countdownStarter = 15;
//	
//		@Override
//		public void run() {
//			// TODO Auto-generated method stub
//			System.out.println(countdownStarter);
//			countdownStarter--;
//			
//			if(countdownStarter < 0) {
//				System.out.println("Time Over!");
//				scheduler.shutdown();
//			}
//		}
//	};
//	scheduler.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);	
//	
	
//	public class HangeulClock{
//		HangeulClock hangeulClock = new HangeulClock();
//		Timer scheduler = new Timer();
//		TimerTask task = new TimerTask() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				String[][] clockResult = hangeulClock.showHourMinute();
//			hangeulClock.printHangeulClock(clockResult);
//			scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);
//			}
//		};
//	}








	
	
	
