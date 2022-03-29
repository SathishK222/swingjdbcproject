package Swing_JDBC_Myproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class AfterLoginFrame  extends JFrame implements ActionListener
{
	JMenuItem addmenuitemobj;
	JMenuItem delmenuitemobj;
	JMenuItem updatemenuitemobj;
	
	JMenuItem searchmenuitemobj;
	JMenuItem viewallmenuitemobj;
	
	JMenuItem exitmenuitemobj;
	
	public AfterLoginFrame()
	{
		super("AFTER LOGIN FRAME");
		setLayout(null);
		
		// 1. CREATE MENUBAR
		JMenuBar mbrobj = new JMenuBar();
		
		// 2. CREATE MENU
		JMenu ummenuobj = new JMenu("File Employee");
				
		//3. CREATE MENU ITEM
		addmenuitemobj = new JMenuItem("New Employee");
		addmenuitemobj.addActionListener(this);
		
		delmenuitemobj = new JMenuItem("Delete Employee");
		delmenuitemobj.addActionListener(this);
		
		updatemenuitemobj = new JMenuItem("Update Employee");
		updatemenuitemobj.addActionListener(this);
				
		//4. ADD MENU ITEM INTO MENU
		ummenuobj.add(addmenuitemobj);
		ummenuobj.add(delmenuitemobj);
		ummenuobj.add(updatemenuitemobj);
		
		//5. ADD MENU TO MENUBAR
		mbrobj.add(ummenuobj);
		
		//FOR VIEW MENU AND SEARCH USER,VIEW ALL USER MENU ITEM
		JMenu viewmenuobj = new JMenu("View");
		
		searchmenuitemobj = new JMenuItem("Search Employee");
		searchmenuitemobj.addActionListener(this);
		
		viewallmenuitemobj = new JMenuItem("View All Employees");
		viewallmenuitemobj.addActionListener(this);
		
		viewmenuobj.add(searchmenuitemobj);
		viewmenuobj.add(viewallmenuitemobj);
		
		mbrobj.add(viewmenuobj);
		
		//FOR CLOSE MENU AND EXIT MENU ITEM
		JMenu closemenuobj = new JMenu("Close");
		
		exitmenuitemobj = new JMenuItem("Exit");
		exitmenuitemobj.addActionListener(this);
		
		closemenuobj.add(exitmenuitemobj);
		
		mbrobj.add(closemenuobj);
		
		//6. TO VIEW MENUBAR ON THE FRAME
		setJMenuBar(mbrobj);
			
		setSize(650, 425);
		setLocation(500,250);
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) 
	{
		new AfterLoginFrame();

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == addmenuitemobj)
		{
			 new RegistrationFrame();
		}
		else if(e.getSource() == delmenuitemobj)
		 {
			 new DeleteUser();
		 }
		else if(e.getSource() == updatemenuitemobj)
		 {
			 new UpdateUser();
		 }
		else if(e.getSource() == viewallmenuitemobj)
		 {
			 new ShowAllUser();
		 }
		else if(e.getSource() == exitmenuitemobj)
		 {
			 System.exit(0);
		 }
		
	}

}