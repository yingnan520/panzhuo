package com.NEU.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.NEU.model.Patient;
import com.NEU.service.PatientService;
import com.NEU.tool.ShowList;

import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;

public class TheRegistrationBack extends JFrame {     //退号

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	Object[] columnNames = {"病历号","姓名","年龄","出生日期","性别","身份证号","发票号","结算类别","挂号级别","挂号日期",
			"是否收取病历本","实收费用","看诊科室","看诊医生"};
	List<Patient> patientList = PatientService.getSingletonInstance().showPatientList();
	DefaultTableModel model = new DefaultTableModel(null,columnNames);


	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public TheRegistrationBack() throws ClassNotFoundException, IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1087, 714);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

	    // 创建一个表格，指定 所有行数据 和 表头
		JTable table = new JTable(model);
			
		ShowList.showList(patientList, model);
		
        table.setForeground(Color.BLACK);                 
        table.setFont(new Font("微软雅黑", Font.PLAIN, 15));   
        table.setSelectionForeground(Color.RED);      
        table.setSelectionBackground(SystemColor.inactiveCaption);  
        table.setGridColor(Color.GRAY);                   

  
        table.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 15));  
        table.getTableHeader().setForeground(Color.BLACK);             
        table.getTableHeader().setResizingAllowed(false);             
        table.getTableHeader().setReorderingAllowed(false); 
        table.getTableHeader().setBackground(SystemColor.activeCaption);
		contentPane.setLayout(null);
        

		JScrollPane iff = new JScrollPane(table);
		iff.setBounds(10, 349, 1059, 427);
		table.setBounds(52, 52, 306, 141);
		
		getContentPane().add(iff);
		 table.getColumnModel().getColumn(1).setPreferredWidth(80);
	     table.getColumnModel().getColumn(2).setPreferredWidth(120);
	     table.getColumnModel().getColumn(3).setPreferredWidth(460);
	     table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		
	    JSeparator separator = new JSeparator();
		separator.setBounds(0, 40, 1069, 2);
		contentPane.add(separator);
		
		JLabel label = new JLabel("门诊普通发票");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label.setBackground(SystemColor.inactiveCaption);
		label.setBounds(24, 11, 90, 31);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("退出");
		btnNewButton.setBounds(949, 0, 120, 38);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			};
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("输入发票号");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel.setBounds(24, 64, 90, 31);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(105, 68, 194, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("输入病历号");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(368, 71, 95, 18);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(448, 68, 194, 24);
		contentPane.add(textField_1);
		
		JButton btnNewButton_1 = new JButton("查询");
		btnNewButton_1.setBounds(709, 67, 113, 27);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("清空");
		button.setBounds(862, 67, 113, 27);
		contentPane.add(button);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 108, 1069, 1);
		contentPane.add(separator_1);
		
		JLabel label_1 = new JLabel("姓        名");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_1.setBackground(SystemColor.inactiveCaption);
		label_1.setBounds(24, 141, 90, 31);
		contentPane.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(105, 145, 166, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_2 = new JLabel("身份证号");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_2.setBackground(SystemColor.inactiveCaption);
		label_2.setBounds(339, 141, 90, 31);
		contentPane.add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(414, 145, 228, 24);
		contentPane.add(textField_3);
		
		JLabel label_3 = new JLabel("号        别");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_3.setBackground(SystemColor.inactiveCaption);
		label_3.setBounds(24, 182, 90, 31);
		contentPane.add(label_3);
		
		String[] listData2 = new String[]{"普通号", "专家号", "急诊号"};
		JComboBox<Object> LevelcomboBox = new JComboBox<Object>(listData2);
		LevelcomboBox.setBounds(105, 185, 166, 26);
		LevelcomboBox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		contentPane.add(LevelcomboBox);
		
		JLabel label_4 = new JLabel("挂号科室");
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_4.setBackground(SystemColor.inactiveCaption);
		label_4.setBounds(339, 185, 90, 31);
		contentPane.add(label_4);
		
		String[] listData3 = new String[]{"临床科室", "医技科室"};
		JComboBox<Object> DepartmentcomboBox = new JComboBox<Object>(listData3);
		DepartmentcomboBox.setBounds(414, 185, 151, 26);
		DepartmentcomboBox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		contentPane.add(DepartmentcomboBox);
		
		JLabel label_5 = new JLabel("应收金额");
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_5.setBackground(SystemColor.inactiveCaption);
		label_5.setBounds(624, 182, 90, 31);
		contentPane.add(label_5);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBackground(Color.LIGHT_GRAY);
		textField_4.setBounds(700, 185, 151, 26);
		contentPane.add(textField_4);
		
		JLabel label_6 = new JLabel("已挂号人员信息");
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("微软雅黑", Font.BOLD, 15));
		label_6.setBackground(SystemColor.inactiveCaption);
		label_6.setBounds(24, 318, 109, 31);
		contentPane.add(label_6);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(new Color(224, 255, 255));
		editorPane.setBounds(10, 318, 1069, 31);
		contentPane.add(editorPane);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 318, 1059, 1);
		contentPane.add(separator_2);
		
		JButton btnNewButton_2 = new JButton("退号");
		btnNewButton_2.setBounds(469, 262, 113, 43);
		btnNewButton_2.addActionListener(new ActionListener() {
			@SuppressWarnings("unlikely-arg-type")
			public void actionPerformed(ActionEvent e) {
				
				List<Patient> delList = new ArrayList<Patient>();
				
				for (Patient p : patientList) {
					
					String code = p.getPatientCode();
					
					if (code != null && code.equals(textField_1.getText())) {
						delList.add(p);
					}
				}
				
				patientList.removeAll(delList);
				
				PatientService.getSingletonInstance().writePatientList_2(patientList);
				
				List<Patient> list;
				
				try {
					list = PatientService.getSingletonInstance().showPatientList();
					model.setRowCount(0);
					ShowList.showList(list, model);
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
		});
		contentPane.add(btnNewButton_2);
	}
		
		public void showTableList() {
			
			try {
				List<Patient> list = PatientService.getSingletonInstance().showPatientList();
				model.setRowCount(0);
				ShowList.showList(list, model);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}

  
