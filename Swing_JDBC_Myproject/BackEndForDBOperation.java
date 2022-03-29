package Swing_JDBC_Myproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
create table logindetails
(
   userid varchar(20),
   password varchar(15)
);

insert into logindetails(userid,password) values('admin','pass');


create table userdetails
(
    name varchar(25),
    email varchar(25),
    mobile varchar(25),
    address varchar(25),
    city varchar(25),
    gender varchar(25),
    interests varchar(25),
    dob varchar(25)
);
*/

public class BackEndForDBOperation 
{
	public boolean loginCheck(String uid, String pass)
	{
	   PreparedStatement pst =null;
	   ResultSet rs = null;
	   Connection mysqlconnection = null;
	   
	   boolean status = false;
	   
	   try
	   {
		  mysqlconnection = DBMySQLConnect.getMySQLConnection();
		   	   
	      String logincheckquery = "select * from logindetails where userid=? and password=?";
		  	   
		  pst = mysqlconnection.prepareStatement(logincheckquery);
		  pst.setString(1, uid);
		  pst.setString(2, pass);
				   
		  rs = pst.executeQuery();
			
		  if(rs.next())
		  {
			status= true;
		  }
		}catch(SQLException e) 
		 {
		     e.printStackTrace();
		   	 //System.out.println("Can't Insert Record - Database Problem");
		 }
		 finally 
		 {
		    try 
		    {
			   if (pst != null)
			      pst.close();
			   if(rs != null)
				  rs.close();
			   if(mysqlconnection != null)
			      mysqlconnection.close();
			} catch (SQLException e) {e.printStackTrace();}
		  } 	
		  
		  return status;
     }
	
	public int insertRecord(UserModel userobj)
	{
	  PreparedStatement pst =null;
      Connection mysqlconnection = null;
      try
      {
   	     mysqlconnection = DBMySQLConnect.getMySQLConnection();
   	   
   	   //Step 3 PREPARE QUERY
   	     String insertquery = "insert into userdetails(name,email,mobile,address,city,gender,interests,dob) values(?,?,?,?,?,?,?,?)";
  	   
   	     pst = mysqlconnection.prepareStatement(insertquery);
		 pst.setString(1, userobj.getName());
		 pst.setString(2, userobj.getEmail());
		 pst.setString(3, userobj.getMobile());
		 pst.setString(4, userobj.getAddress());
		 pst.setString(5, userobj.getCity());
		 pst.setString(6, userobj.getGender());
		 pst.setString(7, userobj.getInterests());
		 pst.setString(8, userobj.getDob());
		   
		 int replycountfromdb = pst.executeUpdate();
		 
		 return replycountfromdb;
  
   	 }catch(SQLException e) 
      {
   		e.printStackTrace();
   		System.out.println("Can't Insert Record - Database Problem");
      }
      finally 
      {
       	try 
       	{
		  if (pst != null)
		    pst.close();
		  if(mysqlconnection != null)
		    mysqlconnection.close();
		} catch (SQLException e) {e.printStackTrace();}
	   } 
	return 0;
    }
		
	public int deleteRecord(String email)
    {
	   PreparedStatement pst =null;
	   Connection mysqlconnection = null;
	   try
	   {
	      mysqlconnection = DBMySQLConnect.getMySQLConnection();
	   	   
	      //Step 3 PREPARE QUERY
	      String delquery = "delete from userdetails where email =?";
	  	   
	   	  pst = mysqlconnection.prepareStatement(delquery);
		  pst.setString(1, email);
			 
		  int replycountfromdb = pst.executeUpdate();
			 
		  return replycountfromdb;
	  
	   	 }catch(SQLException e) 
	      {
	   		e.printStackTrace();
	   		System.out.println("Can't Delete Record - Database Problem");
	      }
	      finally 
	      {
	       	try 
	       	{
			  if (pst != null)
			    pst.close();
			  if(mysqlconnection != null)
			    mysqlconnection.close();
			} catch (SQLException e) {e.printStackTrace();}
		   } 
		return 0;
		
    }
	
	public UserModel searchRecord(String emailid)
	{
	   PreparedStatement pst =null;
	   Connection mysqlconnection = null;
	   ResultSet rs = null;
	   UserModel uobj = new UserModel();
	   try
	   {
	      mysqlconnection = DBMySQLConnect.getMySQLConnection();
		   	   
	      String searchquery = "select * from userdetails where email =?";
		  	   
		  pst = mysqlconnection.prepareStatement(searchquery);
		  pst.setString(1, emailid);
				 
		  rs = pst.executeQuery();
		  
		  
		  if(rs.next())
		  {
			 uobj.setName(rs.getString(1));  
			 uobj.setEmail(rs.getString(2));
			 uobj.setMobile(rs.getString(3));  
			 uobj.setAddress(rs.getString(4));
			 uobj.setCity(rs.getString(5));
			 uobj.setGender(rs.getString(6));  
			 uobj.setInterests(rs.getString(7));
			 uobj.setDob(rs.getString(8));
		  }
		  else
		  {
			  uobj = null;
		  }
		}catch(SQLException e){e.printStackTrace();}
		 finally 
		 {
		  	try 
		   	{
			  if (pst != null)
			    pst.close();
			  if(rs != null)
				rs.close();
			  if(mysqlconnection != null)
			    mysqlconnection.close();
			} catch (SQLException e) {e.printStackTrace();}
		  } 
	   return uobj;
		
	}
		
	public int updateRecord(UserModel userobj)
	{
	   PreparedStatement pst =null;
	   Connection mysqlconnection = null;
	   try
	   {
	      mysqlconnection = DBMySQLConnect.getMySQLConnection();
	   	   
	   	  String updatequery = "update userdetails set name=?,mobile=?,address=? where email = ?";
	  	   
	   	  pst = mysqlconnection.prepareStatement(updatequery);
		  pst.setString(1, userobj.getName());
		  pst.setString(2, userobj.getMobile());
		  pst.setString(3, userobj.getAddress());
		  pst.setString(4, userobj.getEmail());
			 
		  int replycountfromdb = pst.executeUpdate();
			 
		  return replycountfromdb;
	  
	   	 }catch(SQLException e) 
	      {
	   		e.printStackTrace();
	   		System.out.println("Can't Insert Record - Database Problem");
	      }
	      finally 
	      {
	       	try 
	       	{
			  if (pst != null)
			    pst.close();
			  if(mysqlconnection != null)
			    mysqlconnection.close();
			} catch (SQLException e) {e.printStackTrace();}
		   } 
		return 0;
    }
	
	public ArrayList<UserModel> fetchAllRecord()
	{
	  PreparedStatement pst =null;
	  ResultSet rs = null;
	  Connection mysqlconnection = null;
	  
	  ArrayList<UserModel> emplist = new ArrayList<UserModel>();
	  
	  try
	  {
	    mysqlconnection = DBMySQLConnect.getMySQLConnection();
	   	   
        String fetchallquery = "select * from userdetails";
	  	   
		pst = mysqlconnection.prepareStatement(fetchallquery);
			   
		rs = pst.executeQuery();
		
		while(rs.next())
		{
			UserModel uobj = new UserModel();
			uobj.setName(rs.getString(1));
			uobj.setEmail(rs.getString(2));
			uobj.setMobile(rs.getString(3));
			uobj.setAddress(rs.getString(4));
			uobj.setCity(rs.getString(5));
			uobj.setGender(rs.getString(6));
			uobj.setInterests(rs.getString(7));
			uobj.setDob(rs.getString(8));
			
			//ADD Obj into ArrayList
			emplist.add(uobj);
		}
	  }catch(SQLException e){e.printStackTrace();}
	   finally 
	   {
	     try 
	     {
		   if (pst != null)
		    pst.close();
		   if (rs != null)
			rs.close();
		   if(mysqlconnection != null)
		    mysqlconnection.close();
		 } catch (SQLException e) {e.printStackTrace();}
	   } 	
	  return emplist;
	}
}