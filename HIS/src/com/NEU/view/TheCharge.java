package com.NEU.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.NEU.model.Patient;
import com.NEU.service.DiagnosisService;
import com.NEU.service.PatientPayService;
import com.NEU.tool.ShowList;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JSpinner.DateEditor;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class TheCharge extends JFrame {       /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//门诊收费管理

	JPanel contentPane;
	private JTextField textField;
	private JTextField patientCode;
	private JTextField patientName;
	private JTextField patientAge;
	private JTextField idCard;
	private JTextField textField_1;

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TheCharge frame = new TheCharge();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public TheCharge() throws ClassNotFoundException, IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1087, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(0, 0, 1069, 667);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 51, 1069, 2);
		panel.add(separator);
		
		JLabel lblNewLabel = new JLabel("门诊普通发票");
		lblNewLabel.setBounds(27, 23, 120, 18);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(127, 19, 184, 26);
		textField.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		textField.setColumns(10);
		panel.add(textField);
		
		JButton button = new JButton("更新发票号");
		button.setBounds(325, 20, 113, 26);
		panel.add(button);
		
		SpinnerDateModel model = new SpinnerDateModel();
		//获得JSPinner对象
		JSpinner year = new JSpinner(model);
		year.setBounds(580, 162, 151, 29);
		year.setValue(new Date());
		//设置时间格式
		DateEditor editor = new JSpinner.DateEditor(year,
		           "yyyy-MM-dd");
		year.setEditor(editor);
		panel.add(year);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 103, 1069, 2);
		panel.add(separator_1);
		
		JLabel label = new JLabel("病人信息");
		label.setBounds(10, 66, 147, 31);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("宋体", Font.BOLD, 30));
		panel.add(label);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 377, 1069, 2);
		panel.add(separator_2);
		
		JLabel label_2 = new JLabel("病  历  号");
		label_2.setBounds(32, 118, 90, 31);
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_2.setBackground(SystemColor.inactiveCaption);
		panel.add(label_2);
		
		patientCode = new JTextField();
		patientCode.setBounds(98, 120, 151, 26);
		patientCode.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		patientCode.setColumns(10);
		panel.add(patientCode);
		
		JLabel label_3 = new JLabel("*");
		label_3.setBounds(248, 125, 72, 18);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("姓        名");
		label_4.setBounds(269, 118, 90, 31);
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_4.setBackground(SystemColor.inactiveCaption);
		panel.add(label_4);
		
		patientName = new JTextField();
		patientName.setBounds(336, 120, 151, 26);
		patientName.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		patientName.setColumns(10);
		panel.add(patientName);
		
		JLabel label_5 = new JLabel("*");
		label_5.setBounds(487, 125, 72, 18);
		panel.add(label_5);
		
		JRadioButton man = new JRadioButton("男");
		man.setBounds(580, 120, 47, 26);
		JRadioButton woman = new JRadioButton("女");
		woman.setBounds(622, 122, 47, 22);
		man.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		woman.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel.add(woman);
		panel.add(man);
		ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(man);
        btnGroup.add(woman);
        man.setSelected(true);
        
        JLabel label_6 = new JLabel("性       别");
        label_6.setBounds(510, 118, 90, 31);
        label_6.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        label_6.setBackground(SystemColor.inactiveCaption);
        panel.add(label_6);
        
        JLabel label_7 = new JLabel("出生日期");
        label_7.setBounds(510, 162, 90, 31);
        label_7.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        label_7.setBackground(SystemColor.inactiveCaption);
        panel.add(label_7);
        
        JLabel label_8 = new JLabel("年        龄");
        label_8.setBounds(32, 162, 90, 31);
        label_8.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        label_8.setBackground(SystemColor.inactiveCaption);
        panel.add(label_8);
        
        patientAge = new JTextField();
        patientAge.setBounds(98, 164, 151, 26);
        patientAge.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        patientAge.setColumns(10);
        panel.add(patientAge);
        
        JLabel label_9 = new JLabel("身份证号");
        label_9.setBounds(269, 162, 90, 31);
        label_9.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        label_9.setBackground(SystemColor.inactiveCaption);
        panel.add(label_9);
        
        idCard = new JTextField();
        idCard.setBounds(336, 162, 151, 26);
        idCard.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        idCard.setColumns(10);
        panel.add(idCard);
        
        JLabel label_10 = new JLabel("*");
        label_10.setBounds(487, 169, 72, 18);
        panel.add(label_10);
        
        JLabel label_11 = new JLabel("结算类别");
        label_11.setBounds(510, 203, 90, 31);
        label_11.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        label_11.setBackground(SystemColor.inactiveCaption);
        panel.add(label_11);
		
        String[] listData1 = new String[]{"自费", "医保", "新农合"};
		JComboBox<Object> PricetypecomboBox = new JComboBox<Object> (listData1);
		PricetypecomboBox.setBounds(580, 205, 151, 26);
		PricetypecomboBox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel.add(PricetypecomboBox);
		
		JLabel label_12 = new JLabel("执行科室");
		label_12.setBounds(32, 206, 90, 31);
		label_12.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_12.setBackground(SystemColor.inactiveCaption);
		panel.add(label_12);
		
		String[] listData2 = new String[]{"临床科室", "医技科室"};
		JComboBox<Object> DepartmentcomboBox = new JComboBox<Object>(listData2);
		DepartmentcomboBox.setBounds(98, 208, 151, 26);
		DepartmentcomboBox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel.add(DepartmentcomboBox);
		
		JLabel label_13 = new JLabel("出诊医生");
		label_13.setBounds(269, 206, 90, 31);
		label_13.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_13.setBackground(SystemColor.inactiveCaption);
		panel.add(label_13);
		
		textField_1 = new JTextField();
		textField_1.setBounds(336, 206, 151, 26);
		textField_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		textField_1.setColumns(10);
		panel.add(textField_1);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.setBounds(246, 282, 151, 47);
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("清空");
		btnNewButton_1.setBounds(667, 282, 147, 47);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		panel.add(btnNewButton_1);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(0, 267, 1069, 2);
		panel.add(separator_3);
		
		JButton btnNewButton_2 = new JButton("退出");
		btnNewButton_2.setBounds(949, 13, 120, 33);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("刷新");
		btnNewButton_4.setBounds(481, 506, 90, 33);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("清空");
		btnNewButton_5.setBounds(481, 583, 90, 31);
		panel.add(btnNewButton_5);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(0, 340, 1069, 2);
		panel.add(separator_4);
		
		JLabel lblNewLabel_2 = new JLabel("未缴费人员信息");
		lblNewLabel_2.setBounds(0, 340, 184, 39);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("已缴费人员信息");
		lblNewLabel_1.setBounds(607, 342, 151, 37);
		panel.add(lblNewLabel_1);
		
		Object[] columnNames_1 = {"病历号","姓名","年龄"};
		
		List<Patient> newList = PatientPayService.getSingletonInstance().showPatientList();
		
		DefaultTableModel model_1 = new DefaultTableModel(null,columnNames_1);
		JTable table_1 = new JTable(model_1);
		
		ShowList.showList(newList, model_1);
		
		table_1.setForeground(Color.BLACK);                 
		table_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));   
		table_1.setSelectionForeground(Color.RED);      
		table_1.setSelectionBackground(SystemColor.inactiveCaption);  
		table_1.setGridColor(Color.GRAY);                   
		
		  
		table_1.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 15));  
		table_1.getTableHeader().setForeground(Color.BLACK);             
		table_1.getTableHeader().setReorderingAllowed(false); 
		table_1.getTableHeader().setBackground(SystemColor.activeCaption);
		
		JScrollPane iff_1 = new JScrollPane(table_1);
		iff_1.setBounds(607, 377, 462, 277);
		panel.add(iff_1);
		table_1.setBounds(606, 378, 463, 276);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(80);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(120);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		
		Object[] columnNames_2 = {"病历号","姓名","年龄"};
	
		DefaultTableModel model_2 = new DefaultTableModel(null,columnNames_2);
		
		List<Patient> delList = DiagnosisService.getSingletonInstance().showPatientList();
		
		JTable table_2 = new JTable(model_2);
		
		ShowList.showList(delList, model_2);
		
		table_2.setForeground(Color.BLACK);                 
		table_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));   
		table_2.setSelectionForeground(Color.RED);      
		table_2.setSelectionBackground(SystemColor.inactiveCaption);  
		table_2.setGridColor(Color.GRAY);                   
		
		table_2.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 15));  
		table_2.getTableHeader().setForeground(Color.BLACK);             
		table_2.getTableHeader().setReorderingAllowed(false); 
		table_2.getTableHeader().setBackground(SystemColor.activeCaption);
		
		JScrollPane iff_2 = new JScrollPane(table_2);
		iff_2.setBounds(0, 377, 441, 277);
		panel.add(iff_2);
		table_2.setBounds(606, 378, 463, 276);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(80);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(120);
		table_2.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("缴费");
		btnNewButton_3.setBounds(481, 426, 90, 33);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<Patient> newList = new ArrayList<Patient>();
				try {
					newList = PatientPayService.getSingletonInstance().showPatientList();
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				for (Patient p : delList) {
					String code = p.getPatientCode();
					
					if (code != null && code.equals(patientCode.getText())) {
						newList.add(p);
					}
				}
				delList.removeAll(newList);
				
				DiagnosisService.getSingletonInstance().writePatientList_2(delList);
				PatientPayService.getSingletonInstance().writePatientList_2(newList);
				
				try {
					List<Patient> list = DiagnosisService.getSingletonInstance().showPatientList();
					List<Patient> list_1 = PatientPayService.getSingletonInstance().showPatientList();
					model_1.setRowCount(0); 
					model_2.setRowCount(0); 
					ShowList.showList(list, model_2);
					ShowList.showList(list_1, model_1);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton_3);
	}
}
