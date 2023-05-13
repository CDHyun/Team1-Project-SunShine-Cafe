package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.AdminMenuDao;
import com.javalec.dto.AdminMenuDto;
import com.javalec.function.ImageResize;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.swing.ListSelectionModel;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/* 관리자가 메뉴와 관련된 작업(메뉴 추가, 수정, 품절처리) 하는 페이지 */
public class AdminMenuMain extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JRadioButton rbInsert;
	private JRadioButton rbUpdate;
	private JComboBox cbSearch;
	private JTextField tfSearch;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JTable innerTable;
	private JLabel lblimage;
	private JLabel lblNewLabel_3;
	private JTextField tfimage;
	private JButton btnimage;
	private JLabel lblNewLabel_4;
	private JTextField tfNumber;
	private JLabel lblNewLabel_4_1;
	private JTextField tfName;
	private JLabel lblNewLabel_4_2;
	private JTextField tfPrice;
	private JLabel lblNewLabel_4_4;
	private JComboBox cbWhether;
	private JButton btnInsrut;

	String message = "";
	int count = 0;
	
	
	
	
	/**
	 * 상품 입력, 수정
	 */
	
	// 테이블

	
	private final DefaultTableModel outerTable = new DefaultTableModel();
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblNewLabel_4_2_1;
	private JTextField tfQty;
	private JLabel lblNewLabel_4_2_1_1;
	private JTextField tfCategory;
	private JComboBox cbCategory;
	private JLabel lblNewLabel_4_2_1_1_1;
	private JTextField tfImageName;
	private JLabel lblBack;
	private JLabel lblNewLabel_2;
	private JTextField tfContent;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMenuMain frame = new AdminMenuMain();
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
	
	
	public AdminMenuMain() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tableInit();	// table 정리
				searchAction();	// table 데이터
				screenPartition();
				
						
			}
		});
		setTitle("관리자 입력, 수정");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		
		contentPane.add(getRbInsert());
		contentPane.add(getRbUpdate());
		contentPane.add(getCbSearch());
		contentPane.add(getTfSearch());
		contentPane.add(getBtnSearch());
		contentPane.add(getScrollPane());
		contentPane.add(getLblimage());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getTfimage());
		contentPane.add(getBtnimage());
		contentPane.add(getLblNewLabel_4());
		contentPane.add(getTfNumber());
		contentPane.add(getLblNewLabel_4_1());
		contentPane.add(getTfName());
		contentPane.add(getLblNewLabel_4_2());
		contentPane.add(getTfPrice());
		contentPane.add(getLblNewLabel_4_4());
		contentPane.add(getCbWhether());
		contentPane.add(getBtnInsrut());
		contentPane.add(getLblNewLabel_4_2_1());
		contentPane.add(getTfQty());
		contentPane.add(getLblNewLabel_4_2_1_1());
		contentPane.add(getTfCategory());
		contentPane.add(getCbCategory());
		contentPane.add(getLblNewLabel_4_2_1_1_1());
		contentPane.add(getTfImageName());
		contentPane.add(getLblBack());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getTfContent());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("입력/ 수정");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
			lblNewLabel.setBounds(257, 23, 117, 50);
		}
		return lblNewLabel;
	}

	private JRadioButton getRbInsert() {
		if (rbInsert == null) {
			rbInsert = new JRadioButton("입력");
			rbInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cbSearch.setSelectedIndex(0);
					screenPartition();
				}
			});
			rbInsert.setSelected(true);
			buttonGroup.add(rbInsert);
			rbInsert.setBounds(24, 73, 54, 23);
		}
		return rbInsert;
	}
	private JRadioButton getRbUpdate() {
		if (rbUpdate == null) {
			rbUpdate = new JRadioButton("수정");
			rbUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cbSearch.setSelectedIndex(0);
					screenPartition();
				}
			});
			buttonGroup.add(rbUpdate);
			rbUpdate.setBounds(90, 73, 54, 23);
		}
		return rbUpdate;
	}
	private JComboBox getCbSearch() {
		if (cbSearch == null) {
			cbSearch = new JComboBox();
			cbSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						tableInit();	
						searchAction();
						screenPartition();
				}
			});
			cbSearch.setModel(new DefaultComboBoxModel(new String[] {"음료", "디저트", "카테고리"}));
			cbSearch.setBounds(19, 105, 108, 27);
		}
		return cbSearch;
	}
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setBounds(339, 104, 156, 26);
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("검색");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					conditionQuery();
				}
			});
			btnSearch.setBounds(493, 103, 106, 29);
		}
		return btnSearch;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(26, 138, 573, 407);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}
	private JTable getInnerTable() {
		if (innerTable == null) {
			innerTable = new JTable();
			innerTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
						//clearColumn();
						tableClick();
						if(rbInsert.isSelected()) {
							btnInsrut.setEnabled(false);
						}
				}
			});
			innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		
			innerTable.setModel(outerTable);		// table 셋팅
			innerTable.setRowHeight(20);
		}
		return innerTable;
	}
	private JLabel getLblimage() {
		if (lblimage == null) {
			lblimage = new JLabel("");
			lblimage.setBounds(24, 557, 262, 174);
		}
		return lblimage;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Image");
			lblNewLabel_3.setBounds(26, 754, 43, 16);
		}
		return lblNewLabel_3;
	}
	private JTextField getTfimage() {
		if (tfimage == null) {
			tfimage = new JTextField();
			tfimage.setEditable(false);
			tfimage.setBounds(72, 749, 156, 26);
			tfimage.setColumns(10);
		}
		return tfimage;
	}
	private JButton getBtnimage() {
		if (btnimage == null) {
			btnimage = new JButton("Load");
			btnimage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					filePath();
				}
			});
			btnimage.setBounds(230, 749, 75, 29);
		}
		return btnimage;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("NO. :");
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_4.setBounds(312, 557, 61, 16);
		}
		return lblNewLabel_4;
	}
	private JTextField getTfNumber() {
		if (tfNumber == null) {
			tfNumber = new JTextField();
			tfNumber.setEditable(false);
			tfNumber.setHorizontalAlignment(SwingConstants.RIGHT);
			tfNumber.setBounds(385, 552, 61, 26);
			tfNumber.setColumns(10);
		}
		return tfNumber;
	}
	private JLabel getLblNewLabel_4_1() {
		if (lblNewLabel_4_1 == null) {
			lblNewLabel_4_1 = new JLabel("이름 :");
			lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_4_1.setBounds(311, 590, 61, 16);
		}
		return lblNewLabel_4_1;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setColumns(10);
			tfName.setBounds(384, 585, 215, 26);
		}
		return tfName;
	}
	private JLabel getLblNewLabel_4_2() {
		if (lblNewLabel_4_2 == null) {
			lblNewLabel_4_2 = new JLabel("가격 :");
			lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_4_2.setBounds(311, 628, 61, 16);
		}
		return lblNewLabel_4_2;
	}
	private JTextField getTfPrice() {
		if (tfPrice == null) {
			tfPrice = new JTextField();
			tfPrice.setHorizontalAlignment(SwingConstants.TRAILING);
			tfPrice.setColumns(10);
			tfPrice.setBounds(384, 623, 108, 26);
		}
		return tfPrice;
	}
	private JLabel getLblNewLabel_4_4() {
		if (lblNewLabel_4_4 == null) {
			lblNewLabel_4_4 = new JLabel("판매여부 :");
			lblNewLabel_4_4.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_4_4.setBounds(314, 725, 61, 16);
		}
		return lblNewLabel_4_4;
	}
	private JComboBox getCbWhether() {
		if (cbWhether == null) {
			cbWhether = new JComboBox();
			cbWhether.setModel(new DefaultComboBoxModel(new String[] {"Y", "N"}));
			cbWhether.setBounds(384, 722, 88, 27);
		}
		return cbWhether;
	}
	private JButton getBtnInsrut() {
		if (btnInsrut == null) {
			btnInsrut = new JButton("입력");
			btnInsrut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						actionPartition(); 
				}
			});
			btnInsrut.setBounds(482, 826, 117, 29);
		}
		return btnInsrut;
	}
	
	// function
	
	
	// 화면 테이블 정리
	private void tableInit() {
		int vColIndex = 0;
		int width = 0;
		// 음료
		if(cbSearch.getSelectedIndex() == 0) {
			outerTable.setRowCount(0);
			outerTable.setColumnCount(0);
			outerTable.addColumn("No.");	// 타이틀 네임
			outerTable.addColumn("메뉴");
			outerTable.addColumn("가격");
			outerTable.addColumn("카테고리");
			outerTable.addColumn("판매");		
			outerTable.setColumnCount(5);
			
			
			
			int i = outerTable.getColumnCount();
			
			innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF);
			
			// No. 사이즈
			vColIndex = 0;
			TableColumn col = innerTable.getColumnModel().getColumn(vColIndex);
			width = 50;
			col.setPreferredWidth(width);
			
			// 매뉴 사이즈
			vColIndex = 1;
			col = innerTable.getColumnModel().getColumn(vColIndex);
			width = 200;
			col.setPreferredWidth(width);
			
			// 가격 사이즈
			vColIndex = 2;
			col = innerTable.getColumnModel().getColumn(vColIndex);
			width = 90;
			col.setPreferredWidth(width);
			
			// 카테고리 사이즈
			vColIndex = 3;
			col = innerTable.getColumnModel().getColumn(vColIndex);
			width = 150;
			col.setPreferredWidth(width);
			
			// 판매 사이즈
			vColIndex =4;
			col = innerTable.getColumnModel().getColumn(vColIndex);
			width = 80;
			col.setPreferredWidth(width);
			

		// 디저트
		}else if(cbSearch.getSelectedIndex() == 1) {
				outerTable.setRowCount(0);
				outerTable.setColumnCount(0);
				outerTable.addColumn("No.");	// 타이틀 네임
				outerTable.addColumn("메뉴");
				outerTable.addColumn("수량");
				outerTable.addColumn("가격");
				outerTable.addColumn("카테고리");
				outerTable.addColumn("판매");		
				outerTable.setColumnCount(6);
				
				int i = outerTable.getColumnCount();
				
				innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF);
				
				// No. 사이즈
				vColIndex = 0;
				TableColumn col = innerTable.getColumnModel().getColumn(vColIndex);
				width = 50;
				col.setPreferredWidth(width);
				
				// 매뉴 사이즈
				vColIndex = 1;
				col = innerTable.getColumnModel().getColumn(vColIndex);
				width = 170;
				col.setPreferredWidth(width);
				
				// 수량 사이즈
				vColIndex = 2;
				col = innerTable.getColumnModel().getColumn(vColIndex);
				width = 50;
				col.setPreferredWidth(width);
				
				// 가격 사이즈
				vColIndex = 3;
				col = innerTable.getColumnModel().getColumn(vColIndex);
				width = 80;
				col.setPreferredWidth(width);
				
				// 카테고리 사이즈
				vColIndex = 4;
				col = innerTable.getColumnModel().getColumn(vColIndex);
				width = 140;
				col.setPreferredWidth(width);
				
				// 판매 사이즈
				vColIndex = 5;
				col = innerTable.getColumnModel().getColumn(vColIndex);
				width = 80;
				col.setPreferredWidth(width);

			// 카테고리
			}else {
				outerTable.setRowCount(0);
				outerTable.setColumnCount(0);
				outerTable.addColumn("No.");	// 타이틀 네임
				outerTable.addColumn("카테고리");	
				outerTable.setColumnCount(2);
				int i = outerTable.getColumnCount();
				
				innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF);
				
				// No. 사이즈
				vColIndex = 0;
				TableColumn col = innerTable.getColumnModel().getColumn(vColIndex);
				width = 285;
				col.setPreferredWidth(width);
				
				// 카테고리 사이즈
				vColIndex = 1;
				col = innerTable.getColumnModel().getColumn(vColIndex);
				width = 285;
				col.setPreferredWidth(width);
				
			
			}
		
		
	}
	
	// 테이블 데이터
	private void searchAction() {
		ArrayList<AdminMenuDto> menuList = new ArrayList<AdminMenuDto>();
		AdminMenuDao dao = new AdminMenuDao();
		ArrayList<AdminMenuDto> nameList = new ArrayList<AdminMenuDto>();
		nameList = dao.cetagoryNameList();
		int namecount = nameList.size();
		int num = 0;
		
		cbCategory.removeAllItems();
		// 카테고리 자동 추가
		for(int c = 0; c < namecount ; c++ ) {
			String categoryName = nameList.get(c).getCategoryName();
			cbCategory.addItem(categoryName);
		}
		// 음료가 선택 되어있을때
		if(cbSearch.getSelectedIndex() == 0) {
			
			menuList = dao.drinkList();
			count = menuList.size();
			tfNumber.setText(Integer.toString(count + 1));
			for(int i = 0; i < count; i++) {
				num++;
				String drinkName = menuList.get(i).getDrinkName();
				int drinkPrice =  menuList.get(i).getDrinkPrice();
				String categoryName = menuList.get(i).getCategoryName();
				int drinkStatus = menuList.get(i).getDrinkStatus();
				
				Object[] tempData = {num, drinkName, drinkPrice, categoryName , drinkStatus};
				
				outerTable.addRow(tempData);
			}
		// 디저트가 선택 되어 있을때
		}else if(cbSearch.getSelectedIndex() == 1) {
			menuList = dao.dessertList();
			count = menuList.size();
			tfNumber.setText(Integer.toString(count + 1));
			for(int i = 0; i < count; i++) {
				num++;
				String dessertName = menuList.get(i).getDessertName();
				int dessertPrice = menuList.get(i).getDessertPrice();
				int dessertStock = menuList.get(i).getDessertStock();
				String categoryName = menuList.get(i).getCategoryName();
				int dessertStatus = menuList.get(i).getDrinkStatus();
				
				Object[] tempData = {num, dessertName,  dessertStock, dessertPrice, categoryName, dessertStatus};
				outerTable.addRow(tempData);
							
			}
		// 카테고리가 선택 되어 있을때
		}else {

		
			menuList = dao.cetagoryList();
			count =menuList.size();
			tfNumber.setText(Integer.toString(count + 1));
			for(int i =0; i < count; i++) {
				int categoryNo = menuList.get(i).getCategoryNo();
				String categoryName = menuList.get(i).getCategoryName();
				
				Object[] tempData = {categoryNo,categoryName};
				outerTable.addRow(tempData);
				
			}
			
		}	
		
	}
	
	// drink 데이터 등록
	private void drinkInsert() {
		String categoryName = tfCategory.getText().trim();
		String drinkName = tfName.getText().trim();
		int drinkPrice = Integer.parseInt(tfPrice.getText().trim());
		String drinkImage = tfImageName.getText().trim();
		int drinkStatus =  cbWhether.getSelectedIndex();
		String drinkContent = tfContent.getText().trim();
		
		FileInputStream input = null;
		File file = new File(tfimage.getText());
		try {

			input = new FileInputStream(file);
		}catch (Exception e) {
			// TODO: handle exception
		}
	
		AdminMenuDao dao = new AdminMenuDao(categoryName, drinkName, drinkPrice, drinkImage, input, drinkStatus, drinkContent);
		boolean result = dao.drinkAction();
		
		if(result) {
			JOptionPane.showMessageDialog(this, "제품 등록이 정상적으로 처리되었습니다.", "제품 등록", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "제품 입력에 오류가 발생했습니다. \n관리자에게 문의하세요.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	// dessert 데이터 등록
	private void dessertInsert() {
		String categoryName = tfCategory.getText().trim();
		String dessertName = tfName.getText().trim();
		int dessertStock = Integer.parseInt(tfQty.getText());
		int dessertPrice = Integer.parseInt(tfPrice.getText());
		String dessertImage = tfImageName.getText().trim();
		int dessertStatus = cbWhether.getSelectedIndex();
		String dessertContent = tfContent.getText();
		
		FileInputStream input = null;
		File file = new File(tfimage.getText());
		try {

			input = new FileInputStream(file);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		AdminMenuDao dao = new AdminMenuDao(categoryName, dessertName, dessertStock, dessertPrice, dessertImage, input, dessertStatus, dessertContent);
		boolean result = dao.dessertAction();
		
		if(result) {
			JOptionPane.showMessageDialog(this, "제품 등록이 정상적으로 처리되었습니다.", "제품 등록", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "제품 입력에 오류가 발생했습니다. \n관리자에게 문의하세요.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	// category 데이터 등록
	
	private void categoryInsert() {
		String categoryName = tfCategory.getText().trim();
		
		AdminMenuDao dao = new AdminMenuDao(categoryName);
		boolean result = dao.categoryAction();
		
		if(result) {
			JOptionPane.showMessageDialog(this, "카테고리 등록이 정상적으로 처리되었습니다.", "카테고리 등록", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "카테고리 입력에 오류가 발생했습니다. \n관리자에게 문의하세요.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	
	// 입력, 수정이 선택 되었을때 변경사항
	
	private void screenPartition() {
		
		// 입력
		if(rbInsert.isSelected()) {
			clearColumn();
			tableInit();
			searchAction();
			tfSearch.setText("");
			// 음료 입력
			if(cbSearch.getSelectedIndex() == 0) {
				tfName.setEnabled(true);
				tfPrice.setEnabled(true);
				tfCategory.setEnabled(false);
				tfQty.setEnabled(false);
				tfImageName.setEnabled(true);
				tfContent.setEnabled(true);
				cbWhether.setEnabled(true);
				btnInsrut.setEnabled(true);
				btnimage.setEnabled(true);
				cbCategory.setEnabled(true);
				lblimage.setIcon(null);
				tfCategory.setText((String)cbCategory.getSelectedItem());
				cbCategory.setSelectedIndex(0);
			// 디저트 입력	
			}else if(cbSearch.getSelectedIndex() == 1) {
				tfName.setEnabled(true);
				tfPrice.setEnabled(true);
				tfCategory.setEnabled(false);
				tfQty.setEnabled(true);
				tfImageName.setEnabled(true);
				tfContent.setEnabled(true);
				cbWhether.setEnabled(true);
				btnInsrut.setEnabled(true);
				btnimage.setEnabled(true);
				cbCategory.setEnabled(true);
				lblimage.setIcon(null);
				tfCategory.setText((String)cbCategory.getSelectedItem());
				cbCategory.setSelectedIndex(4);
			// 카테고리 입력
			}else {
				tfName.setEnabled(false);
				tfPrice.setEnabled(false);
				tfCategory.setEnabled(true);
				tfImageName.setEnabled(false);
				tfQty.setEnabled(false);
				tfContent.setEnabled(false);
				cbWhether.setEnabled(false);
				btnInsrut.setEnabled(true);
				btnimage.setEnabled(false);	
				cbCategory.setEnabled(false);
				lblimage.setIcon(null);
				cbCategory.setSelectedIndex(0);
				tfCategory.setText("");
			}
			
		}
		// 수정
		if(rbUpdate.isSelected()){
			clearColumn();
			tfSearch.setText("");
			tfName.setEnabled(false);
			tfPrice.setEnabled(false);
			tfCategory.setEnabled(false);
			tfImageName.setEnabled(false);
			tfQty.setEnabled(false);
			tfContent.setEnabled(false);
			cbWhether.setEnabled(false);
			btnInsrut.setEnabled(false);
			btnimage.setEnabled(false);	
			cbCategory.setEnabled(false);
			lblimage.setIcon(null);
		}
			
	}
	
	private void screenPartitionClick() {
		if(cbSearch.getSelectedIndex() == 0) {
			tfName.setEnabled(true);
			tfPrice.setEnabled(true);
			tfCategory.setEnabled(false);
			tfQty.setEnabled(false);
			tfImageName.setEnabled(true);
			tfContent.setEnabled(true);
			cbWhether.setEnabled(true);
			btnInsrut.setEnabled(true);
			btnimage.setEnabled(true);
			cbCategory.setEnabled(true);

		// 디저트 입력	
		}else if(cbSearch.getSelectedIndex() == 1) {
			tfName.setEnabled(true);
			tfPrice.setEnabled(true);
			tfCategory.setEnabled(false);
			tfQty.setEnabled(true);
			tfImageName.setEnabled(true);
			tfContent.setEnabled(true);
			cbWhether.setEnabled(true);
			btnInsrut.setEnabled(true);
			btnimage.setEnabled(true);
			cbCategory.setEnabled(true);

		// 카테고리 입력
		}else {
			tfName.setEnabled(false);
			tfPrice.setEnabled(false);
			tfCategory.setEnabled(true);
			tfImageName.setEnabled(false);
			tfQty.setEnabled(false);
			tfContent.setEnabled(false);
			cbWhether.setEnabled(false);
			btnInsrut.setEnabled(true);
			btnimage.setEnabled(false);	
			cbCategory.setEnabled(false);
			
		
			
		}
		
	}
		

	// 화면에 데이터 지우기
	private void clearColumn() {
		tfNumber.setText("");
		tfName.setText("");
		tfPrice.setText("");
		tfQty.setText("");
		tfCategory.setText("");
		tfImageName.setText("");
		tfimage.setText("");
		tfContent.setText("");
		cbWhether.setSelectedIndex(0);
		lblimage.setIcon(null);
	}
	
	
	// 입력할때 빠진 데이터가 없는지 확인
	private int insertFieldChack() {
		int i =0;
		if(cbSearch.getSelectedIndex() == 0) {
			if(tfName.getText().length() == 0) {
				i++;
				message = "제품 이름";
				tfName.requestFocus();
			}		
			if(tfPrice.getText().length() == 0) {
				i++;
				message = "가격";
				tfPrice.requestFocus();
			}
			if(tfImageName.getText().length() == 0) {
				i++;
				message = "이미지 이름";
				tfNumber.requestFocus();
			}
			if(rbInsert.isSelected()) {
				if(tfimage.getText().length() == 0) {
					i++;
					message = "이미지";
					tfimage.requestFocus();
				}				
			}
			if(tfContent.getText().length() == 0) {
				i ++;
				message = "상품상세";
				tfContent.requestFocus();
			}
			
					
		}else if(cbSearch.getSelectedIndex() == 1) {
			if(tfName.getText().length() == 0) {
				i++;
				message = "제품 이름";
				tfName.requestFocus();
			}		
			if(tfPrice.getText().length() == 0) {
				i++;
				message = "가격";
				tfPrice.requestFocus();
			}
			if(tfQty.getText().length() == 0) {
				i++;
				message = "수량";
				tfQty.requestFocus();
			}
			
			if(tfImageName.getText().length() == 0) {
				i++;
				message = "이미지 이름";
				tfImageName.requestFocus();
			}
			if(rbInsert.isSelected()) {
				if(tfimage.getText().length() == 0) {
					i++;
					message = "이미지";
					tfimage.requestFocus();
				}				
			}
			if(tfContent.getText().length() == 0) {
				i ++;
				message = "상품상세";
				tfContent.requestFocus();
			}
		}else {
			if(tfCategory.getText().length() == 0) {
				i++;
				message = "카테고리";
				tfCategory.requestFocus();
			}
		}

		return i;	
	}
	
	// 입력 빈칸 체크
	private void actionPartition() {
		// 상품 입력
		if(rbInsert.isSelected()) {
			int i_chk = insertFieldChack();
			if(i_chk == 0) {
				if(cbSearch.getSelectedIndex() == 0) {
					drinkInsert();						
				}else if(cbSearch.getSelectedIndex() == 1) {
					dessertInsert();
				}else {
					categoryInsert();
				}
				tableInit();
				searchAction();
				clearColumn();
			}else {
				JOptionPane.showMessageDialog(this, message + " 입력정보를 확인하세요!", "제품등록", JOptionPane.INFORMATION_MESSAGE );
			}
		}
		if(rbUpdate.isSelected()) {
			int i_chk = insertFieldChack();
			if(i_chk == 0) {
				if(cbSearch.getSelectedIndex() == 0) {
					drinkUpdate();						
				}else if(cbSearch.getSelectedIndex() == 1) {
					dessertUpdate();
				}else {
					categoryUpdate();
				}
				tableInit();
				searchAction();
				clearColumn();
			}else {
				JOptionPane.showMessageDialog(this, message + " 입력정보를 확인하세요!", "제품등록", JOptionPane.INFORMATION_MESSAGE );
			}
		}
			
		}
		
	
	
	// 테이블 클릭 했을때 데이터 보이기
	private void tableClick() {
		int i = innerTable.getSelectedRow();
		String wkSequence = String.valueOf(innerTable.getValueAt(i, 0));
		AdminMenuDao dao = new AdminMenuDao();
		AdminMenuDto dto = null;
		int wkSeqno = Integer.parseInt(wkSequence);
		
		if(cbSearch.getSelectedIndex() == 0) {
			dto = dao.drinkClick(wkSeqno);
			
			tfNumber.setText(Integer.toString(dto.getDrinkNo()));
			tfName.setText(dto.getDrinkName());
			tfPrice.setText(Integer.toString(dto.getDrinkPrice()));
			tfCategory.setText(dto.getCategoryName());
			cbCategory.setSelectedItem(dto.getCategoryName());
			tfImageName.setText(dto.getDrinkImageName());
			cbWhether.setSelectedItem(dto.getDrinkStatus());
			tfContent.setText(dto.getDrinkContent());
			
			ImageIcon icon = new ImageIcon("./" + dto.getDrinkImageName());
			int x = 280;
			int y = 200;
			ImageResize resize = new ImageResize(icon,x,y);
			ImageIcon productIcon = resize.imageResizing();
			
			lblimage.setIcon(productIcon);
			lblimage.setHorizontalAlignment(SwingConstants.CENTER);
			
		}else if(cbSearch.getSelectedIndex() ==1) {
			dto = dao.dessertClick(wkSeqno);
			
			tfNumber.setText(Integer.toString(dto.getDessertNo()));
			tfName.setText(dto.getDessertName());
			tfQty.setText(Integer.toString(dto.getDessertStock()));
			tfPrice.setText(Integer.toString(dto.getDessertPrice()));
			tfCategory.setText(dto.getCategoryName());
			cbCategory.setSelectedItem(dto.getCategoryName());
			tfImageName.setText(dto.getDessertImageName());
			cbWhether.setSelectedItem(dto.getDessertStatus());
			tfContent.setText(dto.getDessertContent());
			
			ImageIcon icon = new ImageIcon("./" + dto.getDessertImageName());
			int x = 280;
			int y = 200;
			ImageResize resize = new ImageResize(icon,x,y);
			ImageIcon productIcon = resize.imageResizing();
			
			lblimage.setIcon(productIcon);
			lblimage.setHorizontalAlignment(SwingConstants.CENTER);
			
		}else {
			dto = dao.categoryClick(wkSeqno);
			
			tfNumber.setText(Integer.toString(dto.getCategoryNo()));
			tfCategory.setText(dto.getCategoryName());
			
		}
	
			screenPartitionClick();
	}
	
	// 음료 수정
	private void drinkUpdate() {
		String categoryName = tfCategory.getText().trim();
		String drinkName = tfName.getText().trim();
		int drinkPrice = Integer.parseInt(tfPrice.getText().trim());
		String drinkImage = tfImageName.getText().trim();
		int drinkStatus =  cbWhether.getSelectedIndex();
		int drinkNo = Integer.parseInt(tfNumber.getText().trim());
		String drinkContent = tfContent.getText().trim();
		
		FileInputStream input = null;
		File file = new File(tfimage.getText());
		try {
			input = new FileInputStream(file);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		AdminMenuDao dao = new AdminMenuDao(categoryName, drinkName, drinkPrice, drinkImage, input, drinkStatus, drinkContent);
		boolean result = dao.updateDrink(drinkNo);
		if(result) {
			JOptionPane.showMessageDialog(this, "제품 수정이 정상적으로 처리되었습니다.", "제품 수정", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "제품 입력에 오류가 발생했습니다. \n관리자에게 문의하세요.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	// 디저트 수정
	private void dessertUpdate() {
		String categoryName = tfCategory.getText().trim();
		String dessertName = tfName.getText().trim();
		int dessertQty = Integer.parseInt(tfQty.getText().trim());
		int dessertPrice = Integer.parseInt(tfPrice.getText().trim());
		String dessertImage = tfImageName.getText().trim();
		int dessertStatus =  cbWhether.getSelectedIndex();
		int dessertNo = Integer.parseInt(tfNumber.getText().trim());
		String dessertContent = tfContent.getText();
		
		FileInputStream input = null;
		File file = new File(tfimage.getText());
		try {
			input = new FileInputStream(file);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		AdminMenuDao dao = new AdminMenuDao(categoryName, dessertName, dessertQty, dessertPrice, dessertImage, input, dessertStatus, dessertContent);
		boolean result = dao.updateDessert(dessertNo);
		if(result) {
			JOptionPane.showMessageDialog(this, "제품 수정이 정상적으로 처리되었습니다.", "제품 수정", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "제품 입력에 오류가 발생했습니다. \n관리자에게 문의하세요.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	// 카테고리 수정
	private void categoryUpdate() {
		String categoryName = tfCategory.getText().trim();
		int categoryNo = Integer.parseInt(tfNumber.getText().trim());
		
		
		AdminMenuDao dao = new AdminMenuDao(categoryName);
		boolean result = dao.updateCategory(categoryNo);
		if(result) {
			JOptionPane.showMessageDialog(this, "제품 수정이 정상적으로 처리되었습니다.", "제품 수정", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "제품 입력에 오류가 발생했습니다. \n관리자에게 문의하세요.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	// 이미지 로드
	private void filePath() {
		JFileChooser chooser = new JFileChooser();
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, PNG, BMP", "jpg", "png", "bmp");
		chooser.setFileFilter(filter);
		int ret = chooser.showOpenDialog(null);
		// 파일을 아무것도 선택하지 않았을 경우 -> 불필요한 듯.
		if(ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		// 어디에 있는 누구인지 가져온다.
		String filePath = chooser.getSelectedFile().getPath();
		// 경로 출력해주기
		tfimage.setText(filePath);
		// 경로 이미지 가져오기
		ImageIcon icon = new ImageIcon(filePath);
		int x = 320;
		int y = 200;
		ImageResize resize = new ImageResize(icon,x,y);
		ImageIcon productIcon = resize.imageResizing();
		
		lblimage.setIcon(productIcon);
		lblimage.setHorizontalAlignment(SwingConstants.CENTER);
		
		
	}
	
	// 검색어 입력할 때
	private void conditionQuery() {
		int i = cbSearch.getSelectedIndex();
		String conditionQueryColumn = "";
		switch(i) {
		case 0 :
			conditionQueryColumn = "drinkName";
			break;
		case 1 :
			conditionQueryColumn = "dessertName";
			break;
		case 2 :
			conditionQueryColumn = "categoryName";
			break;
		default :
			break;	
		
		}
		tableInit();	// 테이블정리
		clearColumn();	// 컬럼 내용 삭제
		conditionQueryAction(conditionQueryColumn);
		
	}
	
	// 관리자가 입력한 조건 검색
	private void conditionQueryAction(String conditionQueryColumn) {
		AdminMenuDao dao = new AdminMenuDao(conditionQueryColumn, tfSearch.getText());
		ArrayList<AdminMenuDto> menuList = new ArrayList<AdminMenuDto>();
				

		int num = 0;
		
		if(cbSearch.getSelectedIndex() == 0) {
			menuList = dao.drinkconditionList();
			for(int i = 0; i < count; i++) {
				tfNumber.setText(Integer.toString(count + 1));
				num++;
				String drinkName = menuList.get(i).getDrinkName();
				int drinkPrice =  menuList.get(i).getDrinkPrice();
				String categoryName = menuList.get(i).getCategoryName();
				int drinkStatus = menuList.get(i).getDrinkStatus();
				
				Object[] tempData = {num, drinkName, drinkPrice, categoryName , drinkStatus};
				
				outerTable.addRow(tempData);
			}	
		}else if(cbSearch.getSelectedIndex() == 1) {
			menuList = dao.dessertconditionList();
			for(int i = 0; i < count; i++) {
				tfNumber.setText(Integer.toString(count + 1));
				num++;
				String dessertName = menuList.get(i).getDessertName();
				int dessertPrice = menuList.get(i).getDessertPrice();
				int dessertStock = menuList.get(i).getDessertStock();
				String categoryName = menuList.get(i).getCategoryName();
				int dessertStatus = menuList.get(i).getDrinkStatus();
				
				Object[] tempData = {num, dessertName,  dessertStock, dessertPrice, categoryName, dessertStatus};
				outerTable.addRow(tempData);
							
			}
			
		}else {
			menuList = dao.cetagoryconditionList();
			for(int i =0; i < count; i++) {
				int categoryNo = menuList.get(i).getCategoryNo();
				String categoryName = menuList.get(i).getCategoryName();
				
				Object[] tempData = {categoryNo,categoryName};
				outerTable.addRow(tempData);
				
			}
			
		}
		
		
	}
	
	// Main 버튼
	private void redirecAdminMain() {
		AdminMain main = new AdminMain();
		main.setVisible(true);
		dispose();
	}
	
	
	
	private JLabel getLblNewLabel_4_2_1() {
		if (lblNewLabel_4_2_1 == null) {
			lblNewLabel_4_2_1 = new JLabel("수량 :");
			lblNewLabel_4_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_4_2_1.setBounds(311, 661, 61, 16);
		}
		return lblNewLabel_4_2_1;
	}
	private JTextField getTfQty() {
		if (tfQty == null) {
			tfQty = new JTextField();
			tfQty.setHorizontalAlignment(SwingConstants.TRAILING);
			tfQty.setColumns(10);
			tfQty.setBounds(384, 656, 108, 26);
		}
		return tfQty;
	}
	private JLabel getLblNewLabel_4_2_1_1() {
		if (lblNewLabel_4_2_1_1 == null) {
			lblNewLabel_4_2_1_1 = new JLabel("카테고리 :");
			lblNewLabel_4_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_4_2_1_1.setBounds(321, 694, 54, 16);
		}
		return lblNewLabel_4_2_1_1;
	}
	private JTextField getTfCategory() {
		if (tfCategory == null) {
			tfCategory = new JTextField();
			tfCategory.setHorizontalAlignment(SwingConstants.TRAILING);
			tfCategory.setColumns(10);
			tfCategory.setBounds(387, 689, 108, 26);
		}
		return tfCategory;
	}
	private JComboBox getCbCategory() {
		if (cbCategory == null) {
			cbCategory = new JComboBox();
			cbCategory.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tfCategory.setText((String)cbCategory.getSelectedItem());
				}
			});
		
			cbCategory.setBounds(499, 690, 100, 27);
		}
		return cbCategory;
	}
	private JLabel getLblNewLabel_4_2_1_1_1() {
		if (lblNewLabel_4_2_1_1_1 == null) {
			lblNewLabel_4_2_1_1_1 = new JLabel("이미지 이름 :");
			lblNewLabel_4_2_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_4_2_1_1_1.setBounds(298, 757, 77, 16);
		}
		return lblNewLabel_4_2_1_1_1;
	}
	private JTextField getTfImageName() {
		if (tfImageName == null) {
			tfImageName = new JTextField();
			tfImageName.setHorizontalAlignment(SwingConstants.TRAILING);
			tfImageName.setColumns(10);
			tfImageName.setBounds(387, 752, 212, 26);
		}
		return tfImageName;
	}
	private JLabel getLblBack() {
		if (lblBack == null) {
			lblBack = new JLabel("");
			lblBack.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					redirecAdminMain();
				}
			});
			ImageIcon icon = new ImageIcon(PaymentMain.class.getResource("/com/javalec/image/back.png"));
			int x = 30;
			int y = 30;
			
			ImageResize resize = new ImageResize(icon, x, y);
			ImageIcon backArrow = resize.imageResizing();
			
			lblBack.setIcon(backArrow);
			lblBack.setBounds(19, 6, 43, 38);
		}
		return lblBack;
	}
	
	
	
	
	
	
	
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("상품상세");
			lblNewLabel_2.setBounds(24, 796, 44, 16);
		}
		return lblNewLabel_2;
	}
	private JTextField getTfContent() {
		if (tfContent == null) {
			tfContent = new JTextField();
			tfContent.setBounds(72, 791, 527, 26);
			tfContent.setColumns(10);
		}
		return tfContent;
	}
} // end

