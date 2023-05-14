package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.function.ImageResize;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/* 관리자가 전력사용 가능한 좌석과 관련된 작업을(좌석 사용 가능,불가능 설정) 하는 페이지 
 * 좌석 사용자가 없을 때 - 테이블 선택시 -> 상세정보 텍필 나띵 +  좌석 사용 불가 처리 (예약때문이든 뭐든) 버튼 + 좌석 사용 가능 처리 버튼 
 * 좌석 사용자가 있을 때 - 테이블 선택시 -> 현재 사용자에 대한 상세정보 텍필 자동완성 + 좌석 사용 불가능 처리 버튼 + 좌석 사용 가능 처리 버튼 */
public class AdminTableMain extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblBackImage;
	private JButton btnTable1;
	private JButton btnTable2;
	private JButton btnTable3;
	private JButton btnTable4;
	private JButton btnTable5;
	private JButton btnTable6;
	private JButton btnTable7;
	private JButton btnTable8;
	private JLabel lblUserName;
	private JTextField tfUserId;
	private JLabel lblPurchaseHistory;
	private JTextField tfPurchaseHistory;
	private JLabel lblStartTime;
	private JTextField tfStartTime;
	private JLabel lblUserId;
	private JTextField tfUserName;
	private JLabel lblEndTime;
	private JTextField tfEndTime;
	private JLabel lblUserPhone;
	private JTextField tfUserPhone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminTableMain frame = new AdminTableMain();
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
	public AdminTableMain() {
		setTitle("좌석 관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(248, 211, 72));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblBackImage());
		contentPane.add(getLblNewLabel());
		contentPane.add(getBtnTable1());
		contentPane.add(getBtnTable2());
		contentPane.add(getBtnTable3());
		contentPane.add(getBtnTable4());
		contentPane.add(getBtnTable5());
		contentPane.add(getBtnTable6());
		contentPane.add(getBtnTable7());
		contentPane.add(getBtnTable8());
		contentPane.add(getLblUserName());
		contentPane.add(getTfUserId());
		contentPane.add(getLblPurchaseHistory());
		contentPane.add(getTfPurchaseHistory());
		contentPane.add(getLblStartTime());
		contentPane.add(getTfStartTime());
		contentPane.add(getLblUserId());
		contentPane.add(getTfUserName());
		contentPane.add(getLblEndTime());
		contentPane.add(getTfEndTime());
		contentPane.add(getLblUserPhone());
		contentPane.add(getTfUserPhone());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("좌석 현황");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(0, 0, 625, 50);
		}
		return lblNewLabel;
	}
	private JLabel getLblBackImage() {
		if (lblBackImage == null) {
			lblBackImage = new JLabel("");
			lblBackImage.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					redirectAdminMain();
				}
			});
			ImageIcon icon = new ImageIcon(AdminCalculateMain.class.getResource("/com/javalec/image/back.png"));
			int x = 50;
			int y = 50;
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backPage = resize.imageResizing();
			
			lblBackImage.setIcon(backPage);
			lblBackImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblBackImage.setBounds(5, 0, 70, 70);
		}
		return lblBackImage;
	}
	private JButton getBtnTable1() {
		if (btnTable1 == null) {
			btnTable1 = new JButton("No.1");
			btnTable1.setHorizontalAlignment(SwingConstants.LEADING);
			btnTable1.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
			btnTable1.setBounds(24, 82, 100, 100);
		}
		return btnTable1;
	}
	private JButton getBtnTable2() {
		if (btnTable2 == null) {
			btnTable2 = new JButton("No.2");
			btnTable2.setHorizontalAlignment(SwingConstants.LEADING);
			btnTable2.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
			btnTable2.setBounds(155, 82, 100, 100);
		}
		return btnTable2;
	}
	private JButton getBtnTable3() {
		if (btnTable3 == null) {
			btnTable3 = new JButton("No.3");
			btnTable3.setHorizontalAlignment(SwingConstants.LEADING);
			btnTable3.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
			btnTable3.setBounds(298, 82, 100, 100);
		}
		return btnTable3;
	}
	private JButton getBtnTable4() {
		if (btnTable4 == null) {
			btnTable4 = new JButton("No.4");
			btnTable4.setHorizontalAlignment(SwingConstants.LEADING);
			btnTable4.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
			btnTable4.setBounds(439, 82, 100, 100);
		}
		return btnTable4;
	}
	private JButton getBtnTable5() {
		if (btnTable5 == null) {
			btnTable5 = new JButton("No.5");
			btnTable5.setHorizontalAlignment(SwingConstants.LEADING);
			btnTable5.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
			btnTable5.setBounds(24, 221, 100, 100);
		}
		return btnTable5;
	}
	private JButton getBtnTable6() {
		if (btnTable6 == null) {
			btnTable6 = new JButton("No.6");
			btnTable6.setHorizontalAlignment(SwingConstants.LEADING);
			btnTable6.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
			btnTable6.setBounds(155, 221, 100, 100);
		}
		return btnTable6;
	}
	private JButton getBtnTable7() {
		if (btnTable7 == null) {
			btnTable7 = new JButton("No.7");
			btnTable7.setHorizontalAlignment(SwingConstants.LEADING);
			btnTable7.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
			btnTable7.setBounds(298, 221, 100, 100);
		}
		return btnTable7;
	}
	private JButton getBtnTable8() {
		if (btnTable8 == null) {
			btnTable8 = new JButton("No.8");
			btnTable8.setHorizontalAlignment(SwingConstants.LEADING);
			btnTable8.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
			btnTable8.setBounds(439, 221, 100, 100);
		}
		return btnTable8;
	}
	private JLabel getLblUserName() {
		if (lblUserName == null) {
			lblUserName = new JLabel("사용 고객 : ");
			lblUserName.setBounds(24, 428, 110, 16);
		}
		return lblUserName;
	}
	private JTextField getTfUserId() {
		if (tfUserId == null) {
			tfUserId = new JTextField();
			tfUserId.setBounds(202, 385, 130, 26);
			tfUserId.setColumns(10);
		}
		return tfUserId;
	}
	private JLabel getLblPurchaseHistory() {
		if (lblPurchaseHistory == null) {
			lblPurchaseHistory = new JLabel("주문 내역 : ");
			lblPurchaseHistory.setBounds(24, 508, 61, 16);
		}
		return lblPurchaseHistory;
	}
	private JTextField getTfPurchaseHistory() {
		if (tfPurchaseHistory == null) {
			tfPurchaseHistory = new JTextField();
			tfPurchaseHistory.setColumns(10);
			tfPurchaseHistory.setBounds(202, 503, 130, 26);
		}
		return tfPurchaseHistory;
	}
	private JLabel getLblStartTime() {
		if (lblStartTime == null) {
			lblStartTime = new JLabel("이용 시작 시간 : ");
			lblStartTime.setBounds(24, 561, 146, 16);
		}
		return lblStartTime;
	}
	private JTextField getTfStartTime() {
		if (tfStartTime == null) {
			tfStartTime = new JTextField();
			tfStartTime.setColumns(10);
			tfStartTime.setBounds(202, 556, 130, 26);
		}
		return tfStartTime;
	}
	private JLabel getLblUserId() {
		if (lblUserId == null) {
			lblUserId = new JLabel("사용 중인 고객ID  : ");
			lblUserId.setBounds(24, 390, 166, 16);
		}
		return lblUserId;
	}
	private JTextField getTfUserName() {
		if (tfUserName == null) {
			tfUserName = new JTextField();
			tfUserName.setColumns(10);
			tfUserName.setBounds(202, 423, 130, 26);
		}
		return tfUserName;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//------------ functions-----------
	
	private void redirectAdminMain() {
		AdminMain main = new AdminMain();
		main.setVisible(true);
		dispose();
	}
	private JLabel getLblEndTime() {
		if (lblEndTime == null) {
			lblEndTime = new JLabel("이용 종료 예정 시간 : ");
			lblEndTime.setBounds(24, 615, 130, 16);
		}
		return lblEndTime;
	}
	private JTextField getTfEndTime() {
		if (tfEndTime == null) {
			tfEndTime = new JTextField();
			tfEndTime.setColumns(10);
			tfEndTime.setBounds(202, 610, 130, 26);
		}
		return tfEndTime;
	}
	private JLabel getLblUserPhone() {
		if (lblUserPhone == null) {
			lblUserPhone = new JLabel("사용 고객 전화번호 : ");
			lblUserPhone.setBounds(24, 470, 130, 16);
		}
		return lblUserPhone;
	}
	private JTextField getTfUserPhone() {
		if (tfUserPhone == null) {
			tfUserPhone = new JTextField();
			tfUserPhone.setColumns(10);
			tfUserPhone.setBounds(202, 465, 130, 26);
		}
		return tfUserPhone;
	}
}
