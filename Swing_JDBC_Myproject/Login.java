package Swing_JDBC_Myproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener
{
	private JTextField tf1;
	private JPasswordField pf1;
	
	public Login()
	{
		super("LOGIN FRAME");
		setLayout(null);
		
		Font f1 = new Font("Arial", Font.BOLD, 15);
		
		JLabel lheading = new JLabel("LOGIN");
		lheading.setBounds(125, 35, 100, 30);
		Font f2 = new Font("Arial", Font.BOLD, 25);
		lheading.setFont(f2);
		Color c1 = new Color(150,100,220);
		lheading.setForeground(c1);
		
		JLabel l1 = new JLabel("USER ID");
		l1.setBounds(70, 90, 100, 20);
		l1.setFont(f1);
		l1.setForeground(Color.BLUE);
		
		tf1 = new JTextField();
		tf1.setBounds(170, 90, 100, 20);
		tf1.setFont(f1);
				
		JLabel l2 = new JLabel("PASSWORD");
		l2.setBounds(70, 130, 100, 20);
		l2.setFont(f1);
		l2.setForeground(Color.BLUE);
		
		pf1 = new JPasswordField();
		pf1.setBounds(170, 130, 100, 20);
		pf1.setFont(f1);
		
		JButton b1 = new JButton("LOGIN");
		b1.setBounds(110, 170, 100, 25);
		b1.addActionListener(this);
		
		add(lheading);
		add(l1); add(tf1);
		add(l2); add(pf1);
		add(b1);
				
		setSize(350, 250);
		setLocation(500,250);
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String uid = tf1.getText();
		String pass = pf1.getText();
		
		BackEndForDBOperation dbobj = new BackEndForDBOperation();
		boolean status = dbobj.loginCheck(uid, pass);
		
		if (status)
		{
			
			new AfterLoginFrame();
			
			dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "INVALID UID OR PASSWORD");
		    tf1.setText("");
		    pf1.setText("");
		}
		
	}

/*	public static void main(String[] args) 
	{
	   new Login();	

	}*/
}