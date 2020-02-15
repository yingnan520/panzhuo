package com.NEU.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.NEU.model.Disease;
import com.NEU.model.Patient;
import com.NEU.service.DiagnosisService;
import com.NEU.service.PatientService;
import com.NEU.tool.DiseaseIO;
import com.NEU.tool.ShowList;

import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class DiseaseDiagnosis extends JFrame {       //疾病诊断界面

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
	private JTextField textField_5;
	private JTextField textField_6;
	private static JTextField textField_7;
	private JTextField textField_8;
	
	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public DiseaseDiagnosis() throws ClassNotFoundException, IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1087, 714);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 240, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JPanel panel = new JPanel();
		panel.setBounds(203, -6, 865, 51);
		panel.setBackground(new Color(224, 255, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("门（急）诊病历信息");
		lblNewLabel.setBounds(8, 20, 135, 20);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 100, 0));
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
		
		JButton btnNewButton = new JButton("清除");
		btnNewButton.setBounds(566, 13, 113, 27);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("退出");
		btnNewButton_1.setBounds(719, 13, 113, 27);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_11 = new JLabel("病历号");
		lblNewLabel_11.setBounds(214, 22, 72, 18);
		panel.add(lblNewLabel_11);
		
		textField_7 = new JTextField();
		textField_7.setBounds(273, 14, 113, 26);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(204, 61, 864, 238);
		panel_1.setBackground(new Color(224, 255, 255));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("主  诉");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 15));
		lblNewLabel_2.setBounds(9, 9, 72, 18);
		panel_1.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(61, 6, 796, 24);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("现病史");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 15));
		lblNewLabel_3.setBounds(10, 42, 72, 18);
		panel_1.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(62, 40, 794, 52);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("既往史");
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 15));
		lblNewLabel_4.setBounds(10, 106, 72, 18);
		panel_1.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(63, 103, 794, 54);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("个人史");
		lblNewLabel_5.setFont(new Font("宋体", Font.BOLD, 15));
		lblNewLabel_5.setBounds(10, 172, 72, 18);
		panel_1.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(63, 168, 794, 59);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("病史内容");
		lblNewLabel_1.setBounds(1006, 45, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_6 = new JLabel("检查及结果");
		lblNewLabel_6.setBounds(990, 299, 87, 18);
		contentPane.add(lblNewLabel_6);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(204, 316, 864, 111);
		panel_2.setBackground(new Color(224, 255, 255));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("体格检查");
		lblNewLabel_7.setFont(new Font("宋体", Font.BOLD, 15));
		lblNewLabel_7.setBounds(10, 12, 72, 18);
		panel_2.add(lblNewLabel_7);
		
		textField_4 = new JTextField();
		textField_4.setBounds(79, 7, 779, 47);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("辅助检查");
		lblNewLabel_8.setFont(new Font("宋体", Font.BOLD, 15));
		lblNewLabel_8.setBounds(10, 61, 72, 18);
		panel_2.add(lblNewLabel_8);
		
		textField_5 = new JTextField();
		textField_5.setBounds(79, 60, 778, 47);
		panel_2.add(textField_5);
		textField_5.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(204, 51, 804, 1);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(205, 309, 792, 1);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_9 = new JLabel("评估/诊断");
		lblNewLabel_9.setBounds(998, 430, 72, 18);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("患者查询");
		lblNewLabel_10.setBounds(0, 5, 72, 18);
		contentPane.add(lblNewLabel_10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(65, 3, 126, 24);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 61, 206, 2);
		contentPane.add(separator_2);
		
		Object[] columnNames = {"疾病编码","疾病名称","诊断医生"};
		Object[][] rowData = new Object[10][columnNames.length];
		JTable table = new JTable(rowData,columnNames);
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
        

		JScrollPane iff= new JScrollPane(table);
		iff.setBounds(202, 457, 866, 162);
		table.setBounds(52, 52, 306, 100);
		
		contentPane.add(iff);
		 table.getColumnModel().getColumn(1).setPreferredWidth(80);
	     table.getColumnModel().getColumn(2).setPreferredWidth(120);
	     table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(203, 440, 796, 1);
		contentPane.add(separator_3);
		
		JLabel label = new JLabel("待诊病人信息");
		label.setBounds(0, 71, 90, 18);
		contentPane.add(label);
		
		@SuppressWarnings("unused")
		Object[] columnNames_1 = {"病历号","姓名","年龄"};
		List<Patient> patientList = PatientService.getSingletonInstance().showPatientList();
		List<Patient> list = new ArrayList<Patient>();
		Queue<Patient> patientQueue = new PriorityQueue<Patient>(11, Patient.OrderIsdn);
		
		for (int i = 0;i < patientList.size();i ++) {
			patientQueue.add(patientList.get(i));
		}
		
		while (!patientQueue.isEmpty()) {
			list.add(patientQueue.poll());
		}
		
		DefaultTableModel model = new DefaultTableModel(null,columnNames_1);
		JTable table_1 = new JTable(model);
				
		ShowList.showList(list, model);
		
		table_1.setRowSelectionInterval(0, 0);
		
		table_1.setForeground(Color.BLACK);                 
		table_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));   
		table_1.setSelectionForeground(Color.RED);      
		table_1.setSelectionBackground(SystemColor.inactiveCaption);  
		table_1.setGridColor(Color.GRAY);                   

		table_1.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 15));  
		table_1.getTableHeader().setForeground(Color.BLACK);             
		table_1.getTableHeader().setResizingAllowed(false);             
		table_1.getTableHeader().setReorderingAllowed(false); 
		table_1.getTableHeader().setBackground(SystemColor.activeCaption);
        contentPane.setLayout(null);
        
		JScrollPane iff_1 = new JScrollPane(table_1);
		iff_1.setBounds(0, 102, 200, 217);
		table_1.setBounds(52, 52, 306, 100);
		
		getContentPane().add(iff_1);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(80);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(120);
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		
		JButton button_2 = new JButton("下一个");
		button_2.setBounds(99, 67, 91, 27);
		
		button_2.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			public void actionPerformed(ActionEvent e) {
				int rowCount = 0;
				if (rowCount < table_1.getRowCount()) {
					rowCount ++;		
					table_1.setRowSelectionInterval(rowCount, rowCount);
				}
			}
		});
		contentPane.add(button_2);
		
		JLabel label_1 = new JLabel("已诊病人信息");
		label_1.setBounds(0, 332, 90, 18);
		contentPane.add(label_1);

		
		JButton button_3 = new JButton("下一个");
		button_3.setBounds(99, 328, 91, 27);
		contentPane.add(button_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(0, 632, 206, 2);
		contentPane.add(separator_4);
		
		Object[] columnNames_2 = {"病历号","姓名","年龄"};
		DefaultTableModel model_1 = new DefaultTableModel(null,columnNames_2);
		JTable table_2 = new JTable(model_1);
		
		List<Patient> delList = DiagnosisService.getSingletonInstance().showPatientList();
		ShowList.showList(delList, model_1);
		
		table_2.setForeground(Color.BLACK);                 
		table_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));   
		table_2.setSelectionForeground(Color.RED);      
		table_2.setSelectionBackground(SystemColor.inactiveCaption);  
		table_2.setGridColor(Color.GRAY);                   

  
		table_2.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 15));  
		table_2.getTableHeader().setForeground(Color.BLACK);             
		table_2.getTableHeader().setResizingAllowed(false);             
		table_2.getTableHeader().setReorderingAllowed(false); 
		table_2.getTableHeader().setBackground(SystemColor.activeCaption);
        contentPane.setLayout(null);
        

		JScrollPane iff_2 = new JScrollPane(table_2);
		iff_2.setBounds(0, 361, 200, 258);
		table_2.setBounds(52, 52, 306, 100);
		
		contentPane.add(iff_2);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(80);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(120);
		table_2.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		JButton btnNewButton_3 = new JButton("诊毕");
		btnNewButton_3.setBounds(416, 13, 113, 27);
		panel.add(btnNewButton_3);
		
		JButton button_1 = new JButton("查看所有疾病信息");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Disease d = DiseaseIO.read("disease.txt");
					TreeBuild.searchTree(d);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.setBounds(691, 632, 166, 27);
		contentPane.add(button_1);
		
		JLabel label_2 = new JLabel("输入疾病名称");
		label_2.setBounds(212, 632, 126, 18);
		contentPane.add(label_2);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(317, 629, 166, 26);
		contentPane.add(textField_8);
		
		table.setValueAt(textField_8.getText(), 0, 1);
		
		btnNewButton_3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				List<Patient> delList = new ArrayList<Patient>();
				try {
					delList = DiagnosisService.getSingletonInstance().showPatientList();
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				String s = textField.getText() + " " + textField_1.getText() + " " +textField_2.getText() + " "
						+textField_3.getText() + " "+textField_4.getText()+ " "+textField_5.getText();
				
				for (Patient p : patientList) {
					String code = p.getPatientCode();
					
					if (code != null && code.equals(textField_7.getText())) {
						p.setDiagnosisRecod(s);
						delList.add(p);
					}
				}
				patientList.removeAll(delList);
				
				PatientService.getSingletonInstance().writePatientList_2(patientList);
				DiagnosisService.getSingletonInstance().writePatientList_2(delList);
				
				try {
					List<Patient> list = PatientService.getSingletonInstance().showPatientList();
					List<Patient> list_1 = DiagnosisService.getSingletonInstance().showPatientList();
					model.setRowCount(0); 
					model_1.setRowCount(0); 
					ShowList.showList(list, model);
					ShowList.showList(list_1, model_1);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Disease d = null;
				try {
					d = DiseaseIO.read("disease.txt");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				searchTree(d, textField_8.getText());
				try {
					DiseaseIO.Write(d, "disease.txt");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		
		});
		
		JButton button = new JButton("查询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					@SuppressWarnings("unused")
					List<Patient> list = DiagnosisService.getSingletonInstance().showPatientList();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Hashtable<String, Patient> table = new Hashtable<String, Patient>();
				for (Patient p : list) {
					table.put(p.getPatientCode(), p);
				}
				Iterator<String> iter = table.keySet().iterator();
				while (iter.hasNext()) {
					String k = iter.next();
					if (k.equals(textField_6.getText())) {
		                if (!table.get(k).getDiagnosisRecod().equals(null)) {
		                	String[] s = table.get(k).getDiagnosisRecod().split(" ");
							textField.setText(s[0]);
							textField_1.setText(s[1]);
							textField_2.setText(s[2]);
							textField_3.setText(s[3]);
							textField_4.setText(s[4]);
							textField_5.setText(s[5]);
							System.out.println(table.get(k).getPatientCode() +" "+ table.get(k).getPatientName() +" "+ table.get(k).getDiagnosisRecod());
		                }else {
		                	System.out.println("无就诊记录");
		                }
					}
				}
			}
		});
		button.setBounds(20, 31, 70, 27);
		contentPane.add(button);
		
		JButton button_4 = new JButton("排序");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientOrder.main(null);
			}
		});
		button_4.setBounds(117, 31, 72, 27);
		contentPane.add(button_4);
		
	}
	
	public static void searchTree(Disease disease, String str) {
		Iterator<Disease> iterator = disease.subDisease.iterator();
		while (iterator.hasNext()) {
			Disease d = iterator.next();
			if (str.equals(d.getDiseaseName())) {
				d.patientsList.add(textField_7.getText());
			}else {
				searchTree(d, str);
			}
		}
	}
}
