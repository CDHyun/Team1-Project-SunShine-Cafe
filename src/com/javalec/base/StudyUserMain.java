package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.StudyUserDao;
import com.javalec.dto.StudyUserDto;
import com.javalec.function.ImageResize;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/* 스터디룸 키오스크에서 남은 시간을 보여줄 유저 메인 페이지 */
public class StudyUserMain extends JFrame {

	private static final int TICKET_MINUTES = 60; // 이용권 시간(분)
	private static final int TICKET_SECONDS = TICKET_MINUTES * 60; // 이용권 시간(초)
	private static LocalDateTime startTime; // 이용 시작 시간
	private static int remainingSeconds; // 남은 시간(초)
	private static int timeElapasd = 0;
	private final DefaultTableModel outerTable = new DefaultTableModel();
	
	
	private JPanel contentPane;
	private JLabel lblStudyImage;
	private JLabel lblMainName;
	private JLabel lblStopWatch;
	private JButton btnNewButton;
	private JTable innerTable;

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
			tableInit();
			searchAction();
			timeCheck();
			}
		});
		setTitle("남은시간 및 주문내역");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 750);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
//		contentPane.add(getLblStudyImage());
		contentPane.add(getLblMainName());
		
		JLabel lblNewLabel_1_1 = new JLabel("남은시간");
		lblNewLabel_1_1.setBounds(173, 62, 154, 60);
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 25));
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnaddOrder = new JButton("추가주문");
		btnaddOrder.setBounds(719, 656, 117, 60);
		btnaddOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null,"추가주문하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_NO_OPTION){
				}
					StudyProductMain main = new StudyProductMain();
					main.setVisible(true);
			
			}
		});
		btnaddOrder.setFont(new Font("Dialog", Font.PLAIN, 20));
		contentPane.add(btnaddOrder);
		contentPane.add(getLblStopWatch());
		contentPane.add(getBtnNewButton());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 153, 886, 491);
		contentPane.add(scrollPane);
		
		innerTable = new JTable(){									// 테이블 데이터 지정
			public Class getColumnClass(int column) {				// 속성을 바꿔준다.
				return (column == 0) ? Icon.class : Object.class;	// 0번째 컬럼은 이미지 나머지는 오브젝트로 넣는다
			}
			
		};
		innerTable.setModel(outerTable);	
		innerTable.setRowHeight(150);
		innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(innerTable);
	}

//	private JLabel getLblStudyImage() {
//		if (lblStudyImage == null) {
//			lblStudyImage = new JLabel("");
//			lblStudyImage.setBounds(0, 111, 150, 160);
//			ImageIcon icon = new ImageIcon(StudyUserMain.class.getResource("/com/javalec/image/IceWaterMelon.png"));
//			int x = 100;
//			int y = 100;
//			ImageResize resize = new ImageResize(icon, x, y);
//			ImageIcon productIcon = resize.imageResizing();
//			lblStudyImage.setIcon(productIcon);
//			lblStudyImage.setHorizontalAlignment(SwingConstants.CENTER);
//			lblStudyImage.setBounds(-2, 84, 150, 220);
//}
//		return lblStudyImage;
//	}
	private JLabel getLblMainName() {
		if (lblMainName == null) {
			lblMainName = new JLabel("Sunshine Cafe");
			lblMainName.setBounds(226, 27, 411, 60);
			lblMainName.setFont(new Font("Lucida Grande", Font.BOLD, 50));
		}
		return lblMainName;
	}

private void searchAction() {
	ArrayList<StudyUserDto> list = new ArrayList<StudyUserDto>();
	StudyUserDao dao = new StudyUserDao();
	list = dao.studyList();
	int count = list.size();

	for(int i = 0; i < count; i++) {	
	int wkPrice = list.get(i).getPurchasePrice();
	String wkName = list.get(i).getItemName();
	String wkImageName = list.get(i).getItemImageName();
	
	ImageIcon icon = new ImageIcon("./" + wkImageName);
	int x = 180;
	int y = 130;
	ImageResize resize = new ImageResize(icon, x, y);
	ImageIcon Image = resize.imageResizing();

	
	Object[] tempData = {Image, wkName, wkPrice};
	outerTable.addRow(tempData);
}
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
	
	
				private void tableInit() {
					outerTable.addColumn("상품사진");	// 타이틀 네임
					outerTable.addColumn("상품명");
					outerTable.addColumn("가격");		
					outerTable.setColumnCount(3);		// 타이틀이 몇개냐
				
					int i = outerTable.getRowCount();	// 테이블에 데이터가 몇개 있는지
					
					for(int j=0; j<i;j++) {
						outerTable.removeRow(0);		// 지워주기
					}
					
					innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF); // 사이즈 조절 안한다
					
					// 상품이미지 사이즈
					int vColIndex = 0;					// 데이터 크기 조절 
					TableColumn col = innerTable.getColumnModel().getColumn(vColIndex);
					int width = 380;
					col.setPreferredWidth(width);
					
					// 상품명 사이즈
					vColIndex =1;
					col = innerTable.getColumnModel().getColumn(vColIndex);
					width = 350;
					col.setPreferredWidth(width);
					
					// 가격
					vColIndex = 2;
					col = innerTable.getColumnModel().getColumn(vColIndex);
					width = 150;
					col.setPreferredWidth(width);

				}
				
				
				
				
				
				
	private JLabel getLblStopWatch() {
		if (lblStopWatch == null) {
			lblStopWatch = new JLabel("");
			lblStopWatch.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblStopWatch.setBounds(274, 82, 363, 29);
		}
		return lblStopWatch;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("종료하기");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(null,"종료하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION){
							StudyAdvertisementMain main = new StudyAdvertisementMain();
							main.setVisible(true);
							dispose();
					}else if (result == JOptionPane.NO_OPTION){
					}
				}
			});
			btnNewButton.setBackground(new Color(255, 255, 255));
			btnNewButton.setBounds(730, 27, 106, 60);
		}
		return btnNewButton;
	}
}


		
	

