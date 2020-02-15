package com.NEU.view;

import java.awt.Font;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;


public class Diagnosis extends JFrame {

	private JTabbedPane bb;
	private JPanel Jp01;
	private JPanel Jp02;
	
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		@SuppressWarnings("unused")
		Diagnosis d = new Diagnosis();
		
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public Diagnosis() throws ClassNotFoundException, IOException {
		
		this.setTitle("东软云医院诊断");
        //
        this.setSize(1087, 730);

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
        
        bb = new JTabbedPane(JTabbedPane.TOP);
        //给JTabbedPane设置大小
        bb.setBounds(0, 0, 1076, 705);
        
        Jp01 = new DiseaseDiagnosis().contentPane;
        Jp02 = new Prescribing().contentPane;
        
        Jp01.setBounds(0, 0, 500, 300);
        Jp02.setBounds(0, 0, 500, 300);
        
        bb.addTab("疾病诊断", Jp01);
        bb.addTab("医生开药", Jp02);
        
        bb.setFont(new Font("宋体", 0, 18));
        
        this.getContentPane().add(bb);
  
        bb.setSelectedIndex(0);

	}

}
