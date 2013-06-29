package com.ulab.myTicTacToe;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Test extends JFrame implements ActionListener{

	private JPanel contentPane;
	JButton btn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
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
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		 btn= new JButton("");
		 btn.setName("button");
		contentPane.add(btn, BorderLayout.WEST);
		btn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		int counter=0;
		JComponent eve = (JComponent) e.getSource();
		JButton btn=(JButton) eve;
		System.out.println(eve.getClass().getName());
		btn.setText("qqqqq");
		/*if (event.getName().equals(btn.getName()))*/
		System.out.println(btn.getText());
			JOptionPane.showMessageDialog(null,eve.getName());
		/*while(counter <3){
			JButton dummy=new JButton();
			dummy.setName("Button");
			actionPerformed(new ActionEvent(dummy, 0, "none"));
			
		}*/
	}

}
