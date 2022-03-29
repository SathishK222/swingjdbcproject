package Swing_JDBC_Myproject;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBMySQLConnect 
{
	public static Connection getMySQLConnection()
    {
   	   Connection mysqlconnection = null;
		
       try 
       {
    		//STEP 1 LOAD DRIVER CLASS
    	   Class.forName("com.mysql.cj.jdbc.Driver");
    	   
    	   //STEP 2
    	   mysqlconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/edubridge_advjava","root","Sathish123");
    	      
    	   System.out.println("DATABASE CONNECTION SUCCESS.....");
       }catch (ClassNotFoundException e) {}
        catch (SQLException e) {}
       
       if (mysqlconnection != null)
    	   return mysqlconnection;
       else
       {
    	   System.out.println("DB CONNECTION ERROR SO TERMINATE THE APPLICATION");
    	   System.exit(0);
    	   return null;
       }
	
    }
}