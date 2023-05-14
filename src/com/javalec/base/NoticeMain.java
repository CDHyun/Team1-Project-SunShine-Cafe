package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.function.ImageResize;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/* 기본 키오스크에 보여줄 안내문 페이지 */
public class NoticeMain extends JFrame {

	private JPanel contentPane;
	private JLabel lblNotice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NoticeMain frame = new NoticeMain();
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
	public NoticeMain() {
		setBackground(new Color(242, 212, 99));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 900);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNotice());
	}
	private JLabel getLblNotice() {
		if (lblNotice == null) {
			lblNotice = new JLabel("");
			lblNotice.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					LoginMain loginMain = new LoginMain();
					loginMain.setLocationRelativeTo(null);
					loginMain.setVisible(true);
				}
			});
			ImageIcon icon = new ImageIcon(NoticeMain.class.getResource("/com/javalec/image/notice.png"));
			int x = 625;
			int y = 900;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon notice = resize.imageResizing();
			lblNotice.setIcon(notice);
			lblNotice.setBounds(0, 0, 625, 900);
		}
		return lblNotice;
	}
}
