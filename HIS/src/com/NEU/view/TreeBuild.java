package com.NEU.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.NEU.model.Disease;
import com.NEU.tool.DiseaseIO;

import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class TreeBuild extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	
	Disease root = null;
	private JTextField textField_2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TreeBuild frame = new TreeBuild();
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
	public TreeBuild() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1087, 714);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 34, 1069, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("创 建 树");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel.setBounds(28, 0, 98, 32);
		contentPane.add(lblNewLabel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 49, 1069, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_1 = new JLabel("输入节点名称");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(54, 71, 137, 26);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(191, 64, 231, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 116, 1069, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(0, 174, 1069, 2);
		contentPane.add(separator_3);
		
		JLabel lblNewLabel_2 = new JLabel("！如果是根节点，则不需要填下项");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 18));
		lblNewLabel_2.setBounds(31, 131, 356, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("输入父节点名称");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(54, 206, 154, 26);
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(212, 201, 210, 39);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("添    加");
		btnNewButton.setBackground(new Color(224, 255, 255));
		
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			public void actionPerformed(ActionEvent e) {
					
					String str1 = textField.getText();
					String str2 = textField_1.getText();
					
					if (str2.equals("")) {
						root = new Disease(str1);
					}else {
						addTree(str1, str2, root);
					}
					System.out.println(root);
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 20));
		btnNewButton.setBounds(138, 300, 154, 48);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("清    除");
		btnNewButton_1.setBackground(new Color(224, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.BOLD, 20));
		btnNewButton_1.setBounds(450, 300, 154, 48);
		contentPane.add(btnNewButton_1);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(0, 380, 1069, 2);
		contentPane.add(separator_4);
		
		JButton btnNewButton_2 = new JButton("创 建 完 成");
		btnNewButton_2.setBackground(new Color(224, 255, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(root.getDiseaseName());
				searchTree(root);
				try {
					DiseaseIO.Write(root, "disease.txt");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setFont(new Font("微软雅黑", Font.BOLD, 20));
		btnNewButton_2.setBounds(756, 300, 154, 48);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("返      回");
		btnNewButton_3.setBackground(new Color(224, 255, 255));
		btnNewButton_3.setFont(new Font("微软雅黑", Font.BOLD, 20));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(212, 577, 145, 59);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("退      出");
		btnNewButton_4.setBackground(new Color(224, 255, 255));
		btnNewButton_4.setFont(new Font("微软雅黑", Font.BOLD, 20));
		btnNewButton_4.setBounds(718, 577, 145, 59);
		contentPane.add(btnNewButton_4);
		
		JLabel label = new JLabel("输入要查找节点名称");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(54, 476, 180, 26);
		contentPane.add(label);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(248, 472, 174, 39);
		contentPane.add(textField_2);
		
		JButton button = new JButton("查     询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				searchTree(d, textField_2.getText());
			}
		});
		button.setFont(new Font("微软雅黑", Font.BOLD, 20));
		button.setBackground(new Color(224, 255, 255));
		button.setBounds(718, 464, 145, 48);
		contentPane.add(button);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(0, 551, 1069, 2);
		contentPane.add(separator_5);
		
		JLabel label_1 = new JLabel("查 询 树");
		label_1.setFont(new Font("宋体", Font.BOLD, 20));
		label_1.setBounds(28, 391, 98, 32);
		contentPane.add(label_1);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(0, 427, 1069, 2);
		contentPane.add(separator_6);
		
	}
	
	public static void searchTree(Disease disease) {
		Iterator<Disease> iterator = disease.subDisease.iterator();
		while (iterator.hasNext()) {
			Disease d = iterator.next();
			System.out.println(d.getDiseaseName());
			searchTree(d);
		}
	}
	
	public void addTree(String str1, String str2, Disease disease) {
		
		Disease d = new Disease(str1);
		
		if (str2.equals(disease.getDiseaseName())) {
			disease.subDisease.add(d);
		}else {
			Iterator<Disease> iterator = disease.subDisease.iterator();
			while (iterator.hasNext()) {
				Disease d0 = iterator.next();
				addTree(str1, str2, d0);
			}
		}
	}
	
	public static void searchTree(Disease disease, String str) {
		Iterator<Disease> iterator = disease.subDisease.iterator();
		while (iterator.hasNext()) {
			Disease d = iterator.next();
			if (str.equals(d.getDiseaseName())) {
				System.out.println(d);
			}else {
				searchTree(d, str);
			}
		}
	}
}
