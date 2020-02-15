package com.NEU.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class LoginView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setResizable(false);
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
	public LoginView() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 956, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("账号：");
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("方正粗黑宋简体", Font.BOLD, 20));
		label.setBounds(569, 233, 74, 36);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("密码：");
		label_1.setFont(new Font("方正粗黑宋简体", Font.BOLD, 20));
		label_1.setBounds(569, 300, 78, 28);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBackground(new Color(224, 255, 255));
		textField.setBounds(629, 235, 241, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(224, 255, 255));
		passwordField.setBounds(629, 298, 241, 36);
		contentPane.add(passwordField);
		
		JLabel label_2 = new JLabel("*账号不能为空");
		label_2.setVisible(false);
		label_2.setForeground(Color.RED);
		label_2.setBounds(629, 282, 154, 18);
		contentPane.add(label_2);
		
		JLabel lblNewLabel_1 = new JLabel("*密码不能为空");
		lblNewLabel_1.setVisible(false);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(629, 341, 107, 18);
		contentPane.add(lblNewLabel_1);

		JLabel label_3 = new JLabel("*账号不正确");
		label_3.setVisible(false);
		label_3.setForeground(Color.RED);
		label_3.setBounds(629, 282, 107, 18);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("*密码不正确");
		label_4.setVisible(false);
		label_4.setForeground(Color.RED);
		label_4.setBounds(629, 341, 97, 18);
		contentPane.add(label_4);
		
		JButton button = new JButton("登陆");
		button.setForeground(new Color(65, 105, 225));
		button.setBackground(new Color(255, 255, 255));
		button.setFont(new Font("宋体", Font.BOLD, 20));
		button.setBounds(696, 405, 97, 36);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				if (textField.getText().length() == 0) {
					label_2.setVisible(true);
				}else if ((new String(passwordField.getPassword())).length() == 0) {
					label_2.setVisible(false);
					lblNewLabel_1.setVisible(true);
				}else {
					if (textField.getText().equals("guahao") && new String(passwordField.getPassword()).equals("123456")) {
						dispose();
						try {
							Management.main(null);
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else if (textField.getText().equals("zhenduan") && new String(passwordField.getPassword()).equals("123456")) {
						dispose();
						try {
							Diagnosis.main(null);
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}	
		});
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("欢迎登陆东软云医院系统");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("方正粗黑宋简体", Font.BOLD, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(81, 28, 789, 248);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Java\\Eclipse\\workspace\\HIS\\src\\com\\NEU\\view\\QQ图片20190723103917.jpg"));
		lblNewLabel_2.setBounds(-14, 0, 952, 553);
		contentPane.add(lblNewLabel_2);
	}

}
