package com.NEU.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.NEU.model.Patient;
import com.NEU.service.PatientService;
import com.NEU.tool.ShowList;

import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class PatientOrder extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientOrder frame = new PatientOrder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public PatientOrder() throws ClassNotFoundException, IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1087, 714);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] listData = new String[]{"全部病人", "本科室病人"};
		JComboBox<Object> comboBox = new JComboBox<Object>(listData);
		comboBox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		comboBox.setBounds(161, 60, 151, 26);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("选择待排序病人");
		lblNewLabel.setBounds(42, 56, 105, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("病人排序");
		lblNewLabel_1.setBounds(14, 13, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(1068, 29, 1, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(73, 29, 996, 2);
		contentPane.add(separator_1);
		
		JLabel label = new JLabel("选择排序类型");
		label.setBounds(363, 56, 105, 37);
		contentPane.add(label);
		
		String[] listData2 = new String[]{"按病历号排序", "按姓名排序"};
		JComboBox<Object> comboBox_1 = new JComboBox<Object>(listData2);
		comboBox_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		comboBox_1.setBounds(471, 60, 151, 26);
		contentPane.add(comboBox_1);
		
		JLabel label_1 = new JLabel("选择排序类方式");
		label_1.setBounds(671, 56, 105, 37);
		contentPane.add(label_1);
		
		String[] listData3 = new String[]{"升序", "降序"};
		JComboBox<Object> comboBox_2 = new JComboBox<Object>(listData3);
		comboBox_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		comboBox_2.setBounds(790, 60, 151, 26);
		contentPane.add(comboBox_2);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 106, 1069, 3);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(0, 122, 1069, 3);
		contentPane.add(separator_3);
		
		Object[] columnNames = {"病历号","姓名","年龄","挂号类型"
				};	
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
        

		JScrollPane iff = new JScrollPane(table);
		iff.setBounds(0, 137, 1069, 463);
		table.setBounds(52, 52, 306, 141);
		
		getContentPane().add(iff);
		 table.getColumnModel().getColumn(1).setPreferredWidth(80);
	     table.getColumnModel().getColumn(2).setPreferredWidth(120);
	     table.getColumnModel().getColumn(3).setPreferredWidth(460);
	     table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
	     
	     List<Patient> patientList = PatientService.getSingletonInstance().showPatientList();
	     JButton btnNewButton = new JButton("确定");
	     btnNewButton.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
                List<Patient> newList = new ArrayList<Patient>();
                int count = 0;
	     		if (comboBox_1.getSelectedItem().equals("按病历号排序")) {
	     			while (count <= patientList.size()) {
	     				for (int i = 0;i < patientList.size() - 1;i ++) {
		     				int j = Integer.parseInt(patientList.get(i).getPatientCode());
		     				int k = Integer.parseInt(patientList.get(i+1).getPatientCode());
		     				if (j > k) {
		     					Patient p = patientList.get(i);
		     					patientList.set(i, patientList.get(i + 1));
		     					patientList.set(i + 1, p);
		     				}
		     			}
	     				count ++;
	     			}
	     		}
	     		for (Patient p : patientList) {
     				newList.add(p);
     			}
	     		ShowList.showList(newList, model);
	     	}
	     });
	     btnNewButton.setBounds(199, 613, 113, 41);
	     contentPane.add(btnNewButton);
	     
	     JButton button = new JButton("返回");
	     button.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     	}
	     });
	     button.setBounds(742, 613, 113, 41);
	     contentPane.add(button);
	}
}
