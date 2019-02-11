package com.Utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.testng.SkipException;

import com.Utility.ReadXml;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.Utility.ConfigReader;

public class DBConnectionNew {
	

	static Connection con;
	

	static ConfigReader config = new ConfigReader();
	
//Connecting to DB
	
	
	static String arr[]=new String[10];
	
	public static  int length;
	
	public static int j;
	
	static String query;

	public static String dbResult;
	
	public static String columnName;
	
	public ResultSetMetaData metadata;
	
	public static ArrayList<String> dbResultList;

	static String dbURL;static String username;static String password;
	
	public static void connectDB() throws SQLException
	{
		try
		{
		dbURL = new String(config.getDBUrl());
		
		}
		catch (NullPointerException e)
		{
			e.printStackTrace();
		}
		
      //Load mysql jdbc driver        
      try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}   
    //Create Connection to DB 
      try {
		  System.out.println("Connecting to DB....");
		  con = DriverManager.getConnection(dbURL);
		  System.out.println("Connected to DB Successfully.");
      	} catch (SQLException e){
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println("Connecting to DB Failed.....");

      	}
          
			     /* try {
					if(config.getAppUrl().contains("dev"))
					{
							System.out.println("Connecting to Dev URL");
						  con = DriverManager.getConnection(dbURL,username,password);
					}
					  else
					  {
						  System.out.println("Connecting to Stage/Test URL");
						  con = DriverManager.getConnection(dbURL);
					  }
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(e.getMessage());
			
				}*/
	}
	

	public static String retrieveQuery(String value,ExtentTest logger) throws SQLException, IOException
	{
		String os = System.getProperty("os.name").toLowerCase();
		System.out.println(os);
		
		if(os.equalsIgnoreCase("windows 10"))
		{
	 		logger.log(LogStatus.INFO, "Skipping this exception as DB is NOT Accessible On Local machine");
    		throw new SkipException("Skipping this exception as DB is NOT Accessible On Local machine"); 
		}
		
		connectDB();
   // Execute the SQL Query. Store results in ResultSet   
	
    	query=ReadXml.readXML(value, "Query");
   	
     	Statement stmt = con.createStatement();    

   	     	
   	     for(int i=0;i<length;i++)
	     {

   	    	long CurrentTime=System.currentTimeMillis(); 
   	    	

   	    	
	        ResultSet rs= stmt.executeQuery(arr[i]);
	        
	        long EndTime=System.currentTimeMillis(); 
	        
	        System.out.println("Time taken to execute the query " +(EndTime-CurrentTime)/1000 +" seconds");
	        
	        logger.log(LogStatus.PASS, "Time Taken to execute the query " +(EndTime-CurrentTime)/1000 +" seconds");
	  	        
	        logger.log(LogStatus.PASS, "Query value" +arr[i]);

	        while(rs.next())
	        {

	        	 dbResult=rs.getString(1);   
	        	 
	        	 logger.log(LogStatus.PASS, "Query Result" +rs.getString(1));

	    
	        	}	
	        }
   	     System.out.println(dbResult);
   	  System.out.println("Closing DB");
		 closeDB();
   		return dbResult;
	     }
	
     
     
	
	
	public static ArrayList<String> retrieveResult(String value,ExtentTest logger) throws SQLException, IOException
	{
		String os = System.getProperty("os.name").toLowerCase();
		System.out.println(os);
		
		if(os.equalsIgnoreCase("windows 10"))
		{
	 		logger.log(LogStatus.INFO, "Skipping this exception as DB is NOT Accessible On Local machine");
    		throw new SkipException("Skipping this exception as DB is NOT Accessible On Local machine"); 
		}
		
		System.out.println("Connecting DB");
		
		connectDB();
		
    	dbResultList = new ArrayList<String> ();


		// Execute the SQL Query. Store results in ResultSet   
	
		query=ReadXml.readXML(value, "Query");
     
		//Create Statement Object   
     
		Statement stmt = con.createStatement();    
  	
   	  
   	     //Length of xml
   	     	
   	     for(int i=0;i<length;i++)
	     {
	    	 
	        logger.log(LogStatus.PASS, "Query value" +arr[i]);
		
	    	 
	    	// Executes the given SQL statement, which returns a single ResultSet object.
	        ResultSet rs= stmt.executeQuery(arr[i]);
	        
	   	
			ResultSetMetaData metadata = rs.getMetaData();
	
			System.out.println("metadata" +metadata);
			
           //Number of columns
			metadata.getColumnCount();
	
        	
	        while(rs.next())
	        {
	        	       	
	        	for (j=1;j<=metadata.getColumnCount();j++)
	        	{	
	        		
	        	  	long CurrentTime=System.currentTimeMillis(); 
	        		
	        	 dbResultList.add(rs.getString(j));
	        	 
	        	 long EndTime=System.currentTimeMillis(); 
	 	        
	 	        System.out.println("Time taken to execute the query in seconds " +(EndTime-CurrentTime)/1000  + " and" + (EndTime-CurrentTime) + "  in milliseconds");
	 	        
	 	        logger.log(LogStatus.PASS, "Time taken to execute the query in seconds " +(EndTime-CurrentTime)/1000  + " and" + (EndTime-CurrentTime) + " in milliseconds");
	        	 
	        	 logger.log(LogStatus.PASS, "DB Result set List" +dbResultList.get(j-1));
	    		
	    	     System.out.println("dbResultList" +dbResultList.get(j-1));
	    
	        	}	
	        }
	     }
   	     
 		 System.out.println("Closing DB");
 		 closeDB();
   	     return dbResultList;

	     }	
	
public static void closeDB() throws SQLException
{
	
	con.close();
}
	}
	


