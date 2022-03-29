package Swing_JDBC_Myproject;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RegistrationFrame extends JFrame implements ActionListener
{
	private JTextField tname;
	private JTextField temail;
	private JTextField tmobile;
	private JTextArea taddr;
	private JComboBox city;
	private JRadioButton rmale;
	private JRadioButton rfemale;
	private JComboBox day;
	private JComboBox month;
	private JComboBox year;
	private JCheckBox cmo;
	private JCheckBox cmu;
	private JCheckBox cco;
	private JButton bregister;
	private JButton bclear;
	
	public RegistrationFrame()
	{
		super("REGISTRATION FRAME");
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(11,2));
		
		Font fobj1 = new Font("Chiller",Font.BOLD,27);
		JLabel ltitle = new JLabel("REGISTRATION");
		ltitle.setFont(fobj1);
		ltitle.setForeground(Color.BLUE);
		
		Font fobj2 = new Font("comic sans ms",Font.BOLD,15);
		JLabel lname = new JLabel("NAME");
		lname.setForeground(Color.RED);
		lname.setFont(fobj2);
		tname = new JTextField();
		
		JLabel lemail = new JLabel("Email");
		lemail.setForeground(Color.RED);
		lemail.setFont(fobj2);
		temail = new JTextField();
		
		JLabel lmobile = new JLabel("MOBILE");
		lmobile.setForeground(Color.RED);
		lmobile.setFont(fobj2);
		tmobile = new JTextField();
		
		JLabel laddr = new JLabel("ADDRESS");
		laddr.setForeground(Color.RED);
		laddr.setFont(fobj2);
		taddr = new JTextArea(5,20);
		JScrollPane tapan=new JScrollPane(taddr);
		
		JLabel lcity = new JLabel("CITY");
		lcity.setForeground(Color.RED);
		lcity.setFont(fobj2);
		String ctvalue[]={"Kolkata","Delhi","Mumbai","Chennai","Hydrabad","Pune","Bangalore"};
		city=new JComboBox(ctvalue);
		
		JLabel lgender = new JLabel("GENDER");
		lgender.setForeground(Color.RED);
		lgender.setFont(fobj2);
		rmale=new JRadioButton("Male");
		rfemale=new JRadioButton("Female");
		rmale.setSelected(true);
			
		//FOR DISPLAY RADIO BUTTON
        JPanel gpanel=new JPanel();
		gpanel.add(rmale);
		gpanel.add(rfemale);
		
		//SELECT ONLY 1 OPTION
        ButtonGroup rgroup=new ButtonGroup();
		rgroup.add(rmale);
		rgroup.add(rfemale);
		
		JLabel lhob = new JLabel("HOBBY");
		lhob.setForeground(Color.RED);
		lhob.setFont(fobj2);
		cmo = new JCheckBox("Movie");
		cmu = new JCheckBox("Music");
		cco = new JCheckBox("Computer");
		
		JPanel hpanel=new JPanel();
		hpanel.add(cmo);
		hpanel.add(cmu);
		hpanel.add(cco);
		
		JLabel ldob = new JLabel("DOB");
		ldob.setForeground(Color.RED);
		ldob.setFont(fobj2);
		String dvalue[]=new String[31];
		for(int i=0;i<=30;i++)
		{
			dvalue[i]=String.valueOf(i+1);
		}
		day=new JComboBox(dvalue);
		
		String mvalue[]=new String[12];
		for(int i=0;i<=11;i++)
		{
			mvalue[i]=String.valueOf(i+1);
		}
		month=new JComboBox(mvalue);
		
		String yvalue[]=new String[12];
		int cnt=0;
		for(int i=2015;i<=2025;i++)
		{
			yvalue[cnt]=String.valueOf(i);
			cnt++;	
		}
		year=new JComboBox(yvalue);
		
		JPanel dobpanel=new JPanel();
		dobpanel.add(day);
		dobpanel.add(month);
		dobpanel.add(year);
		
		JLabel ldate = new JLabel("Date");
		ldate.setForeground(Color.RED);
		ldate.setFont(fobj2);
		LocalDate dt = LocalDate.now();
		JLabel ldate1 = new JLabel(""+dt);
		
		
		bregister = new JButton("Register");
		bregister.addActionListener(this);
		
		bclear = new JButton("Clear");
		bclear.addActionListener(this);
		
		c.add(ltitle);c.add(new Label("  "));
		c.add(lname);c.add(tname);
		c.add(lemail);c.add(temail);
		c.add(lmobile);c.add(tmobile);
		c.add(laddr);c.add(tapan);
		c.add(lcity);c.add(city);
		c.add(lgender);c.add(gpanel);
		c.add(lhob);c.add(hpanel);
		c.add(ldob);c.add(dobpanel);
		c.add(ldate);c.add(ldate1);
		c.add(bregister);c.add(bclear);
				
		
		setSize(450, 425);
		setLocation(500,250);
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	boolean mobileNoCheck()
	{
		boolean status = true;
		
		String mobno = tmobile.getText();
		if(mobno.length() == 10)
		{
		   for(int i = 0;i<mobno.length();i++)
		   {
		       if(mobno.charAt(i) >= '0' && mobno.charAt(i) <= '9') 
		       {}
		       else
		       {
		    	   JOptionPane.showMessageDialog(null, "NO CHARACTER Allowed");
		    	   tmobile.setText("");
		    	   status = false;
		    	   break;
		       }
		   }
		}
		else
		{
		   status = false;
		   JOptionPane.showMessageDialog(null, "Mobile No SHOULD BE 10 Digit");
		   tmobile.setText("");
		}
		return status; 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
	  if(e.getSource() == bregister)
	  {
		 if(mobileNoCheck())
		 {	 
		  	UserModel userobj = new UserModel();
		
		  	userobj.setName(tname.getText().trim());
		  	userobj.setEmail(temail.getText());
		  	userobj.setMobile(tmobile.getText());
		  	userobj.setAddress(taddr.getText());
		  	userobj.setCity((String)city.getSelectedItem());
			
		  	String gn="";
		  	if(rmale.isSelected())
		  	{
		  		gn="Male";
		  	}
		  	else if(rfemale.isSelected())
		  	{
		  		gn="Female";
		  	}
		  	userobj.setGender(gn);
			
		  	String ins="";
		  	if(cmo.isSelected())
		  	{
		  		ins="Movie ";
		  	}
		  	if(cmu.isSelected())
		  	{
		  		ins = ins + "Music ";
		  	}
		  	if(cco.isSelected())
		  	{
		  		ins = ins + "Computer";
		  	}
		  	userobj.setInterests(ins);
				
		  	String d=(String)day.getSelectedItem();
		  	String m=(String)month.getSelectedItem();
		  	String y=(String)year.getSelectedItem();
		  	String dob=d + "-" + m + "-" + y;
		  	userobj.setDob(dob);
		
		  	userobj.setDate("");
		
		  	//STORE RECORD INTO DATABASE
		  	BackEndForDBOperation dbobj = new BackEndForDBOperation();
		
		  	int respfordboperation = dbobj.insertRecord(userobj);
		
		  	if (respfordboperation > 0)
		  	{
		  		JOptionPane.showMessageDialog(null, "REGISTRATION SUCCESS");
		  	}
		  	else
		  	{
		  		JOptionPane.showMessageDialog(null, "TRY AGAIN");
		  	}
		  	dispose();
		  	new RegistrationFrame(); 
		 }
	  }//END IF FOR e.getSource
	  else if(e.getSource() == bclear) 
	  {
			 dispose();
			 new RegistrationFrame();
	  }
	 
	}
/*	
	public static void main(String[] args) 
	{
		new RegistrationFrame();//NO NAME OBJ CREATION

	}*/
}