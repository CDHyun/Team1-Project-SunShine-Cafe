package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.function.ImageResize;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/* 스터디룸 키오스크에서 광고를 보여줄 페이지 */
public class StudyAdvertisementMain extends JFrame {

	private JPanel contentPane;
	private JLabel lblAD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudyAdvertisementMain frame = new StudyAdvertisementMain();
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
	public StudyAdvertisementMain() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				changeAd();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblAD());
	}

	private JLabel getLblAD() {
		if (lblAD == null) {
			lblAD = new JLabel("");
			lblAD.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					StudyLoginMain studyLoginMain = new StudyLoginMain();
					studyLoginMain.setLocationRelativeTo(null);
					studyLoginMain.setVisible(true);
				}
			});
			ImageIcon icon = new ImageIcon(StudyAdvertisementMain.class.getResource("/com/javalec/image/Ad1.png"));
			int x = 900;
			int y = 750;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon ad = resize.imageResizing();
			
			lblAD.setIcon(ad);
			lblAD.setBounds(0, 0, 900, 750);
		}
		return lblAD;
	}
	
	private void changeAd() {
		Thread thread = new Thread(() -> {
	        while (true) {
	            try {
	            	Thread.sleep(3000);
	                ImageIcon icon = new ImageIcon(AdvertisementMain.class.getResource("/com/javalec/image/Ad2.png"));
	                int x = 900;
	                int y = 750;
	                ImageResize resize = new ImageResize(icon, x, y);
	                ImageIcon ad2 = resize.imageResizing();
	                lblAD.setIcon(ad2);
	                Thread.sleep(3000);
	                icon = new ImageIcon(AdvertisementMain.class.getResource("/com/javalec/image/Ad3.png"));
	                resize = new ImageResize(icon, x, y);
	                ImageIcon ad3 = resize.imageResizing();
	                lblAD.setIcon(ad3);
	                Thread.sleep(3000);
	                icon = new ImageIcon(AdvertisementMain.class.getResource("/com/javalec/image/Ad1.png"));
	                resize = new ImageResize(icon, x, y);
	                ImageIcon ad = resize.imageResizing();
	                lblAD.setIcon(ad);

	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    });
	    
	    thread.start();
	}
	
}	// End Class
