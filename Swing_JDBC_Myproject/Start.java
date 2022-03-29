package Swing_JDBC_Myproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Start extends JFrame 
{
	public Start()
	{
		super("WELCOME FRAME");
		setLayout(null);
		
		JLabel lprojname = new JLabel("HR MANAGEMENT SYSTEM");
		lprojname.setBounds(120,120,500,30);
		Font fobj1 = new Font("Arial",Font.BOLD,30);
		lprojname.setFont(fobj1);
		lprojname.setForeground(Color.DARK_GRAY);
		
		JButton bstart = new JButton("START");
		bstart.setBounds(220, 180, 150, 30);
		
		bstart.addActionListener(new ActionListener() 
		                         {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//System.out.println("HI");
				new Login();
				dispose();
			}
		}
		);
		
				
		add(lprojname);
		add(bstart);
		
		setSize(650, 425);
		setLocation(500,250);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) 
	{
			new Start();
	}

}