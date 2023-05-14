package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdvertisementMain extends JFrame {

	private JPanel contentPane;
	private JLabel lblAD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdvertisementMain frame = new AdvertisementMain();
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
	public AdvertisementMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 900);
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
					NoticeMain noticeMain = new NoticeMain();
					noticeMain.setLocationRelativeTo(noticeMain);
					noticeMain.setVisible(true);
					dispose();
				}
			});
			lblAD.setIcon(new ImageIcon(AdvertisementMain.class.getResource("/com/javalec/image/Ad1.png")));
			lblAD.setBounds(0, 0, 625, 872);
		}
		return lblAD;
	}
}
