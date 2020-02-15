package com.NEU.view;

import java.awt.Color;

import javax.swing.JFrame;

import com.NEU.model.Patient;
import com.NEU.service.PatientService;
import com.NEU.tool.Autogeneration;
import com.NEU.tool.ShowList;

import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.SpinnerDateModel;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DateEditor;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class TheRegistration extends JFrame {    //门诊挂号管理

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField patientCode;
	private JTextField textField_7;
	private JTextField idCard;
	private JTextField patientName;
	private JTextField patientAge;
	private JTextField homeAddress;
	private JTextField cost;
	private JTextField textField_1;
	JPanel contentPane;
	List<Patient> patientList = PatientService.getSingletonInstance().showPatientList();
	Queue<Patient> patientQueue = new PriorityQueue<Patient>(11, Patient.OrderIsdn);
	Object[] columnNames = {"病历号","姓名","年龄","出生日期","性别","身份证号","发票号","结算类别","挂号级别","挂号日期",
			"是否收取病历本","实收费用","看诊科室","看诊医生"};	
	DefaultTableModel model = new DefaultTableModel(null,columnNames);

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public TheRegistration() throws ClassNotFoundException, IOException {

		
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
	     
		
		JLabel lblNewLabel = new JLabel("门诊普通发票");
		lblNewLabel.setBounds(20, 11, 90, 31);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel.setBackground(SystemColor.inactiveCaption);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(120, 13, 184, 26);
		textField.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("请输入要查找的病历号");
		label_1.setBounds(30, 55, 190, 31);
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_1.setBackground(SystemColor.inactiveCaption);
		getContentPane().add(label_1);
		
		patientCode = new JTextField();
		patientCode.setBounds(120, 108, 151, 26);
		patientCode.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		patientCode.setColumns(10);
		patientCode.setText(Autogeneration.generatePatientCode());
		getContentPane().add(patientCode);
		
		JButton searchButton = new JButton("查找");
		searchButton.setBounds(395, 56, 100, 29);
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		searchButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		getContentPane().add(searchButton);
		
		String[] listData2 = new String[]{"普通号", "专家号", "急诊号"};
		JComboBox<Object> LevelcomboBox = new JComboBox<Object> (listData2);
		LevelcomboBox.setBounds(120, 234, 151, 26);
		LevelcomboBox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		getContentPane().add(LevelcomboBox);
		
		JButton registrationButton = new JButton("挂号");
		registrationButton.setBounds(934, 161, 100, 31);
		registrationButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		registrationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Patient p = new Patient();
				p.setPatientCode(patientCode.getText());
				p.setPatientName(patientName.getText());
				String s = patientAge.getText();
				int i = Integer.parseInt(s);
				p.setPatientAge(i);
				p.setRegistrationCode((String)LevelcomboBox.getSelectedItem());
				if ((boolean)LevelcomboBox.getSelectedItem().equals("普通号")) {
					p.setPopulation(1);
				}else if ((boolean)LevelcomboBox.getSelectedItem().equals("专家号")) {
					p.setPopulation(2);
				}else if ((boolean)LevelcomboBox.getSelectedItem().equals("急诊号")) {
					p.setPopulation(3);
				}
				try {
					patientList.clear();
					patientList.addAll(PatientService.getSingletonInstance().writePatientList(p));
					for (int j = 0;j < patientList.size();j ++) {
						patientQueue.add(patientList.get(j));
					}
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				model.setRowCount(0);
				ShowList.showList(patientList,model);
			}
		});
		getContentPane().add(registrationButton);
		
		JButton button_1 = new JButton("补打");
		button_1.setBounds(934, 205, 100, 31);
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("重打");
		button_2.setBounds(934, 249, 100, 31);
		button_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		getContentPane().add(button_2);
		
		JLabel label_2 = new JLabel("已挂号人员信息");
		label_2.setBounds(52, 318, 109, 31);
		label_2.setForeground(new Color(0, 0, 0));
		label_2.setFont(new Font("微软雅黑", Font.BOLD, 15));
		label_2.setBackground(SystemColor.inactiveCaption);
		getContentPane().add(label_2);
		
		JEditorPane editorPane_2 = new JEditorPane();
		editorPane_2.setBounds(10, 318, 1069, 31);
		editorPane_2.setBackground(new Color(224, 255, 255));
		getContentPane().add(editorPane_2);
		
		JLabel label_4 = new JLabel("病  历  号");
		label_4.setBounds(52, 106, 90, 31);
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_4.setBackground(SystemColor.inactiveCaption);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("结算类别");
		label_5.setBounds(546, 232, 90, 31);
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_5.setBackground(SystemColor.inactiveCaption);
		getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("号        别");
		label_6.setBounds(52, 232, 90, 31);
		label_6.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_6.setBackground(SystemColor.inactiveCaption);
		getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("姓        名");
		label_7.setBounds(296, 106, 90, 31);
		label_7.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_7.setBackground(SystemColor.inactiveCaption);
		getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("身份证号");
		label_8.setBounds(546, 147, 90, 31);
		label_8.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_8.setBackground(SystemColor.inactiveCaption);
		getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("挂号科室");
		label_9.setBounds(296, 232, 90, 31);
		label_9.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_9.setBackground(SystemColor.inactiveCaption);
		getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("性       别");
		label_10.setBounds(546, 106, 90, 31);
		label_10.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_10.setBackground(SystemColor.inactiveCaption);
		getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("出生日期");
		label_11.setBounds(52, 147, 90, 31);
		label_11.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_11.setBackground(SystemColor.inactiveCaption);
		getContentPane().add(label_11);
		
		JLabel label_12 = new JLabel("年        龄");
		label_12.setBounds(296, 147, 90, 31);
		label_12.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_12.setBackground(SystemColor.inactiveCaption);
		getContentPane().add(label_12);
		
		textField_7 = new JTextField();
		textField_7.setBounds(181, 57, 184, 26);
		textField_7.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		textField_7.setColumns(10);
		getContentPane().add(textField_7);
		
		JLabel label_13 = new JLabel("应收金额");
		label_13.setBounds(546, 274, 90, 31);
		label_13.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_13.setBackground(SystemColor.inactiveCaption);
		getContentPane().add(label_13);
		
		JLabel label_14 = new JLabel("家庭住址");
		label_14.setBounds(52, 191, 90, 31);
		label_14.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_14.setBackground(SystemColor.inactiveCaption);
		getContentPane().add(label_14);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("是否需要病历本");
		chckbxNewCheckBox.setBounds(556, 195, 173, 22);
		chckbxNewCheckBox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		getContentPane().add(chckbxNewCheckBox);
		chckbxNewCheckBox.setSelected(true);
		
		idCard = new JTextField();
		idCard.setBounds(615, 149, 151, 26);
		idCard.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		idCard.setColumns(10);
		getContentPane().add(idCard);
		
		patientName = new JTextField();
		patientName.setBounds(368, 108, 151, 26);
		patientName.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		patientName.setColumns(10);
		getContentPane().add(patientName);
		
		patientAge = new JTextField();
		patientAge.setBounds(368, 150, 151, 26);
		patientAge.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		patientAge.setColumns(10);
		getContentPane().add(patientAge);
		
		homeAddress = new JTextField();
		homeAddress.setBounds(120, 193, 399, 26);
		homeAddress.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		homeAddress.setColumns(10);
		getContentPane().add(homeAddress);
		
		
		/**
		 * 
        // 添加条目选中状态改变的监听器
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // 只处理选中的状态
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("选中: " + comboBox.getSelectedIndex() + " = " + comboBox.getSelectedItem());
                }
            }
        });
		 */
		String[] listData1 = new String[]{"自费", "医保", "新农合"};
		JComboBox<Object> PricetypecomboBox = new JComboBox<Object> (listData1);
		PricetypecomboBox.setBounds(615, 234, 151, 26);
		PricetypecomboBox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		getContentPane().add(PricetypecomboBox);
		
		String[] listData3 = new String[]{"内科", "外科"};
		JComboBox<Object> DepartmentcomboBox = new JComboBox<Object> (listData3);
		DepartmentcomboBox.setBounds(368, 234, 151, 26);
		DepartmentcomboBox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		getContentPane().add(DepartmentcomboBox);
		
		JRadioButton man = new JRadioButton("男");
		man.setBounds(615, 108, 47, 26);
		JRadioButton woman = new JRadioButton("女");
		woman.setBounds(668, 110, 47, 22);
		man.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		woman.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		getContentPane().add(woman);
		getContentPane().add(man);
		ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(man);
        btnGroup.add(woman);
        man.setSelected(true);

		
		cost = new JTextField();
		cost.setBounds(615, 281, 151, 26);
		cost.setBackground(new Color(192, 192, 192));
		cost.setEditable(false);
		cost.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		cost.setColumns(10);
		getContentPane().add(cost);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(10, 323, 1057, 278);
		getContentPane().add(textArea_1);
		
		SpinnerDateModel date = new SpinnerDateModel();
		//获得JSPinner对象
		JSpinner year = new JSpinner(date);
		year.setBounds(120, 148, 151, 29);
		year.setValue(new Date());
		//设置时间格式
		DateEditor editor = new JSpinner.DateEditor(year,
		           "yyyy-MM-dd");
		year.setEditor(editor);
		getContentPane().add(year);
		
		JLabel label_15 = new JLabel("出诊医生");
		label_15.setBounds(52, 273, 90, 31);
		label_15.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_15.setBackground(SystemColor.inactiveCaption);
		getContentPane().add(label_15);
		
		JLabel label_16 = new JLabel("挂号日期");
		label_16.setBounds(296, 274, 90, 31);
		label_16.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_16.setBackground(SystemColor.inactiveCaption);
		getContentPane().add(label_16);
		
		SpinnerDateModel model2 = new SpinnerDateModel();
		JSpinner spinner = new JSpinner(model2);
		spinner.setBounds(368, 276, 151, 29);
		spinner.setValue(new Date());
		DateEditor editor2 = new JSpinner.DateEditor(spinner,
		           "yyyy-MM-dd");
		spinner.setEditor(editor2);
		getContentPane().add(spinner);
		
		textField_1 = new JTextField();
		textField_1.setBounds(120, 275, 151, 26);
		textField_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		textField_1.setColumns(10);
		getContentPane().add(textField_1);
		
		JLabel lblNewLabel_1 = new JLabel("病人信息");
		lblNewLabel_1.setBounds(907, 50, 147, 31);
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, -13, 1069, 55);
		lblNewLabel_2.setBackground(new Color(230, 230, 250));
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 99, 1069, 2);
		contentPane.add(separator);
		
		JButton btnNewButton_1 = new JButton("打印");
		btnNewButton_1.setBounds(328, 12, 113, 26);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(0, 52, 1069, 51);
		lblNewLabel_3.setForeground(new Color(240, 255, 255));
		contentPane.add(lblNewLabel_3);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 40, 1069, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_4 = new JLabel("*");
		lblNewLabel_4.setBounds(271, 113, 72, 18);
		contentPane.add(lblNewLabel_4);
		
		JLabel label = new JLabel("*");
		label.setBounds(519, 113, 72, 18);
		contentPane.add(label);
		
		JLabel label_3 = new JLabel("*");
		label_3.setBounds(769, 154, 72, 18);
		contentPane.add(label_3);
		
		JButton newInvoiceCode = new JButton("更新发票号");
		newInvoiceCode.setBounds(455, 11, 113, 26);
		newInvoiceCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(newInvoiceCode);
		
		JButton btnNewButton = new JButton("退出");
		btnNewButton.setBounds(948, 6, 113, 31);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginView.main(null);
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("更新");
		btnNewButton_2.setBounds(934, 117, 100, 31);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				patientCode.setText(Autogeneration.generatePatientCode());
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

    
