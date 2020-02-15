package com.NEU.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.NEU.model.Medicine;
import com.NEU.service.MedicineService;
import com.NEU.tool.ShowList;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Prescribing extends JFrame {       //医生开药

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

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public Prescribing() throws ClassNotFoundException, IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1087, 714);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 240, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("病历号");
		lblNewLabel.setBounds(14, 13, 53, 23);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(67, 12, 141, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("姓 名");
		lblNewLabel_1.setBounds(222, 15, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(268, 12, 86, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("年 龄");
		lblNewLabel_2.setBounds(368, 15, 72, 18);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(415, 12, 86, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 47, 1073, 2);
		contentPane.add(separator);
		
		JButton btnNewButton = new JButton("开药");
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 20));
		btnNewButton.setBounds(872, 3, 113, 41);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("门诊诊断");
		lblNewLabel_3.setBounds(6, 57, 72, 18);
		contentPane.add(lblNewLabel_3);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(1, 81, 1071, 1);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_6 = new JLabel("药品编号");
	     lblNewLabel_6.setBounds(515, 15, 72, 18);
	     contentPane.add(lblNewLabel_6);
	     
	     textField_5 = new JTextField();
	     textField_5.setBounds(586, 12, 104, 24);
	     contentPane.add(textField_5);
	     textField_5.setColumns(10);
	     
	    Object[] columnNames = {"药品编号","药品名称","药品价格","备注","库存"};
			
		List<Medicine> medicineList = MedicineService.getSingletonInstance().showMedicineList();

		// 创建一个表格，指定 所有行数据 和 表头
	    DefaultTableModel model = new DefaultTableModel(null,columnNames);
		JTable table = new JTable(model);
			
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
	    iff.setBounds(0, 131, 1069, 322);
	    table.setBounds(52, 52, 306, 100);
			
		contentPane.add(iff);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		     
		textField_4 = new JTextField();
	     textField_4.setFont(new Font("微软雅黑", Font.PLAIN, 15));
	     textField_4.setEditable(false);
	     textField_4.setColumns(10);
	     textField_4.setBackground(Color.LIGHT_GRAY);
	     textField_4.setBounds(904, 466, 151, 26);
	     textField_4.setText("0");
	     contentPane.add(textField_4);
		
		JButton btnNewButton_1 = new JButton("增药");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<Medicine> newList = new ArrayList<Medicine>();
				float sum = Float.parseFloat(textField_4.getText());
				for (Medicine m : medicineList) {
					
					String medicineCode = m.getMedicineCode();
					
					if (medicineCode.equals(textField_5.getText())) {
						float medicineFee = m.getMedicineFee();
						sum += medicineFee;
						int medicineNumber = m.getNumber();
						m.setNumber(medicineNumber - 1); 
						if (medicineNumber-1 == 0) {
							System.out.println("添加失败");
						}else {
							newList.add(m);
						}
					}
		
				}
				
				textField_4.setText(String.valueOf(sum));
			    ShowList.showMedicineList(newList, model);			    
			
			}
		});
		btnNewButton_1.setBounds(826, 53, 92, 27);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("删除");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(932, 53, 92, 27);
		contentPane.add(btnNewButton_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("微软雅黑", Font.BOLD, 18));
		textField_3.setText("门诊处方");
		textField_3.setBackground(new Color(204, 255, 255));
		textField_3.setBounds(0, 82, 1069, 49);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
	     
	     JLabel lblNewLabel_4 = new JLabel("总金额");
	     lblNewLabel_4.setBounds(851, 466, 72, 26);
	     contentPane.add(lblNewLabel_4);
	     
	     JButton btnNewButton_4 = new JButton("发送");
	     btnNewButton_4.setBounds(233, 466, 113, 27);
	     contentPane.add(btnNewButton_4);
	     
	     JSeparator separator_2 = new JSeparator();
	     separator_2.setBounds(0, 507, 1073, 2);
	     contentPane.add(separator_2);
	     
	     JSeparator separator_3 = new JSeparator();
	     separator_3.setBounds(0, 522, 1073, 2);
	     contentPane.add(separator_3);
	     
	     JButton btnNewButton_5 = new JButton("返回");
	     btnNewButton_5.setFont(new Font("微软雅黑", Font.BOLD, 20));
	     btnNewButton_5.setBounds(779, 567, 176, 59);
	     contentPane.add(btnNewButton_5);
	     
	     JButton btnNewButton_6 = new JButton("查看药品目录");
	     btnNewButton_6.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		try {
	     			java.awt.Desktop.getDesktop().open(new File("medicine.txt"));
	     		}catch(IOException e1) {
	     			e1.printStackTrace();
	     		}
	     	}
	     });
	     btnNewButton_6.setFont(new Font("微软雅黑", Font.BOLD, 20));
	     btnNewButton_6.setBounds(125, 567, 176, 59);
	     contentPane.add(btnNewButton_6);
	     
	     JButton btnNewButton_8 = new JButton("查看缴费情况");
	     btnNewButton_8.setFont(new Font("微软雅黑", Font.BOLD, 20));
	     btnNewButton_8.setBounds(440, 567, 176, 59);
	     btnNewButton_8.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		TheCharge.main(null);
		     	}
	     });
	     contentPane.add(btnNewButton_8);
	}
}
