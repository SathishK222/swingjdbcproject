package Swing_JDBC_Myproject;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UpdateUser extends JFrame implements ActionListener 
{
	private JTextField temail;
	private JTextField tname;
	private JTextField tmobile;
	private JTextArea taddr;
	private JButton bsearch;
	private JButton bupdate;
	UserModel tempobj = null;
	
	public UpdateUser()
	{
		super("UPDATE EMPLOYEE FRAME");
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(6,2));
		
		Font fobj1 = new Font("Chiller",Font.BOLD,27);
		JLabel ltitle = new JLabel("UPDATE");
		ltitle.setFont(fobj1);
		ltitle.setForeground(Color.BLUE);
		
		Font fobj2 = new Font("comic sans ms",Font.BOLD,15);
		JLabel lemail = new JLabel("Email");
		lemail.setForeground(Color.RED);
		lemail.setFont(fobj2);
		temail = new JTextField();
				
		JLabel lname = new JLabel("NAME");
		lname.setForeground(Color.RED);
		lname.setFont(fobj2);
		tname = new JTextField();
				
		JLabel lmobile = new JLabel("MOBILE");
		lmobile.setForeground(Color.RED);
		lmobile.setFont(fobj2);
		tmobile = new JTextField();
		
		JLabel laddr = new JLabel("ADDRESS");
		laddr.setForeground(Color.RED);
		laddr.setFont(fobj2);
		taddr = new JTextArea(5,20);
		JScrollPane tapan=new JScrollPane(taddr);
		
		bsearch = new JButton("SEARCH");
		bsearch.addActionListener(this);
		
		bupdate = new JButton("UPDATE");
		bupdate.addActionListener(this);
		bupdate.setEnabled(false);
		
		c.add(ltitle);c.add(new JLabel("  "));
		c.add(lemail);c.add(temail);
		c.add(lname);c.add(tname);
		c.add(lmobile);c.add(tmobile);
		c.add(laddr);c.add(tapan);
		c.add(bsearch);c.add(bupdate);
				
		setSize(450, 250);
		setLocation(500,250);
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	/*public static void main(String[] args) 
	{
		new UpdateUser();

	}*/

	@Override
	public void actionPerformed(ActionEvent e) 
	{
	   BackEndForDBOperation bobj = new BackEndForDBOperation();
	   if(e.getSource() == bsearch)
	   {
    	   UserModel uobj = bobj.searchRecord(temail.getText().trim());
		   
		   if(uobj != null)
		   {
		      temail.setText(uobj.getEmail());
		      temail.setEditable(false);
		   
		      tname.setText(uobj.getName());
		      tmobile.setText(uobj.getMobile());
		      taddr.setText(uobj.getAddress());
		      
		      bupdate.setEnabled(true);
		      bsearch.setEnabled(false);
		   }
		   else
		   {
			   JOptionPane.showMessageDialog(null, "INVALID EMAIL ID");
			   temail.setText("");
		   }
			   
	   }
	   else if(e.getSource() == bupdate)
	   {
		   UserModel tempobj = new UserModel();
			 
		   //UPDATE TEMP OBJCET WITH NEW/UPDATED VALUE
		   tempobj.setEmail(temail.getText());
		   tempobj.setName(tname.getText());
		   tempobj.setMobile(tmobile.getText());
		   tempobj.setAddress(taddr.getText());
		   
		   int noofrecoedupdated = bobj.updateRecord(tempobj);
		   
		   if (noofrecoedupdated > 0)
			{
				JOptionPane.showMessageDialog(null, "UPDATE SUCCESS");
			}
	  	    else
	  	    {
	  	    	JOptionPane.showMessageDialog(null, "TRY AGAIN");
	  	    }
	 		dispose();
			new UpdateUser(); 
		}
	 }

}
