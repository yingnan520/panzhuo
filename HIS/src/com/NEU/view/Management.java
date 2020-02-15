package com.NEU.view;

import java.awt.Font;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Management extends JFrame {

	 private JTabbedPane aa;
	 private JPanel Jp01;
	 private JPanel Jp02;
	    
	 private static final long serialVersionUID = 1L;
	    
	 	public static void main(String[] args) throws ClassNotFoundException, IOException {
	        @SuppressWarnings("unused")
	        Management m = new Management();

	    }
	   
	    public Management() throws ClassNotFoundException, IOException {

	        
	        this.setTitle("东软云医院管理");
	       
	        this.setSize(1087, 705);

	        // 窗口自动居中
	        this.setLocationRelativeTo(null);

	        getContentPane().setLayout(null);

	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        // 保持Window窗体基本风格
	        try {
	            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	        } catch (Exception err) {
	            err.printStackTrace();
	        }
	   
	        // 不能最大化
	        this.setResizable(false);
	        this.init();
	        this.setVisible(true);
	        
	    }
	    
	    private void init() throws ClassNotFoundException, IOException{
	        
	        aa = new JTabbedPane(JTabbedPane.TOP);
	        //给JTabbedPane设置大小
	        aa.setBounds(0, 0, 1076, 705);
	        TheRegistration tr = new TheRegistration();
	        TheRegistrationBack trb = new TheRegistrationBack();
	        Jp01 = tr.contentPane;
	        Jp02 = trb.contentPane;
	        
	        aa.addChangeListener(new ChangeListener() {

				@Override
				public void stateChanged(ChangeEvent e) {
					JTabbedPane j = (JTabbedPane)e.getSource();
					if (j.getSelectedIndex() == 0) {
						tr.showTableList();
					}else if (j.getSelectedIndex() == 1) {
						trb.showTableList();
					}
				}
	        	
	        });
	    
	        Jp01.setBounds(0, 0, 500, 300);
	        Jp02.setBounds(0, 0, 500, 300);
	        //将四个面板加入到JTabbedPane上
	        aa.addTab("挂号管理", Jp01);
	        aa.addTab("退号管理", Jp02);
	        //设置字体为宋体，不加粗（加粗为1），字号18
	        aa.setFont(new Font("宋体", 0, 18));
	        //添加到JFrame内容面板上，也可以直接this.add(aa);
	        this.getContentPane().add(aa);
	        //初始显示面板一
	        aa.setSelectedIndex(0);
	        
	    }
	    
}
