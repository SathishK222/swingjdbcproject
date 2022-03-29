package Swing_JDBC_Myproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DeleteUser extends JFrame implements ActionListener 
{
	private JTextField tf1;
	
	public DeleteUser()
	{
		super("DELETE EMPLOYEE FRAME");
		setLayout(null);
		
		Font f1 = new Font("Arial", Font.BOLD, 15);
		
		JLabel lheading = new JLabel("DELETE");
		lheading.setBounds(180, 40, 200, 30);
		Font f2 = new Font("Arial", Font.BOLD, 25);
		lheading.setFont(f2);
		Color c1 = new Color(150,100,220);
		lheading.setForeground(c1);
		
		JLabel l1 = new JLabel("EMAIL ID");
		l1.setBounds(70, 90, 100, 20);
		l1.setFont(f1);
		l1.setForeground(Color.BLUE);
		
		tf1 = new JTextField();
		tf1.setBounds(170, 90, 200, 20);
		tf1.setFont(f1);
				
		JButton bsearch = new JButton("DELETE");
		bsearch.setBounds(180, 125, 120, 25);
		bsearch.addActionListener(this);
		
		add(lheading);
		add(l1); add(tf1);
		add(bsearch);
				
		setSize(450, 250);
		setLocation(500,250);
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

/*	public static void main(String[] args) {
		new DeleteUser();
	}*/

	@Override
	public void actionPerformed(ActionEvent e) 
	{
       BackEndForDBOperation dbobj = new BackEndForDBOperation();
		
       String email = tf1.getText();
	   
       int respfordboperation = dbobj.deleteRecord(email);
		
	   if (respfordboperation > 0)
	   {
		 JOptionPane.showMessageDialog(null, "DEL SUCCESS");
		 tf1.setText("");
	   }
  	   else
  	   {
  	    	JOptionPane.showMessageDialog(null, "INVALID EMAIL ID");
  	   }
	}

}
