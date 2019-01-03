package com.QuickBus.PromcodeApi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Promocode {
	
	
	public static String generateRandomChars(String candidateChars, int length)  {
	    //length=10;
		
		//Add this lines of Code when calling method for generating codes
		
		//System.out.println(generateRandomChars(
	    //        "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890", 8));
		
	   
	    String SEPARATOR = ",";
	    StringBuilder sb = new StringBuilder();
	   // String saltStr = null;
	    Random random = new Random();
	    
	    //set number of promo codes or create a loop where you call this method i.e for( int count=0; count< no. of promo codes (10); count++;)
	    
	    //for (int j=0;j<10;j++)
	//{
	    for (int i = 0; i < length; i++) {
	      
	        // int index = (int) (random.nextInt() * candidateChars.length());
	       
	        
	        sb.append(candidateChars.charAt(random.nextInt(candidateChars
	                .length())));
	        //sb.append("" + "\r");
	        //saltStr =sb.toString();
	        //if (j < i){
	        
	        // code for dividing many promo codes
	        /*for (int m=6; m<i; m++){
	           sb.append(SEPARATOR );
	           //sb.append("" +"\n" );
	           //j--;
	       }*/
	      
	        
	    }
	//}
	    //String[] dataString;
	    String saltStr=sb.toString();
	    String [] a = new String []{saltStr};
	    List<String> list = new ArrayList<String>( Arrays.asList(a));
	    String formattedValues = String.join(",", list).replaceAll("(\\w*,\\w*,\\w*,)", "$1" + System.lineSeparator());
	 
	   
	    //a=saltStr.split("|");
	   // dataString = saltStr.trim().split(" \\s+");
	   //ArrayList<String> scripts = new ArrayList<String>();
	    //return java.util.Arrays.toString(a);
	    //return list;
	    //System.out.println(list); 
	   
	    //saveAppraisal(
	    
	    
	     System.out.println(formattedValues);
	     //saveAppraisal(formattedValues); 
	     //saveAppraisal(list); 
	    //saveAppraisal(a); 
	     saveAppraisal(saltStr);
	   //return java.util.Arrays.toString(a);
	     return saltStr;
	    //count++;
	    //coont++;
	    
	}

	public static void saveAppraisal(String saltStr) {
		// TODO Auto-generated method stub
		int disamnt;
		int fare;
		String from,to, staus;
	     Scanner input = new Scanner(System.in);
	      System.out.print("Enter From: ");
	    	 from = input.next();
	    	System.out.println("Dep. Point entered = " + from);
		disamnt=100;
		fare = 1000;
		//from = "Nairobi";
		to="Mombasa";
		staus = "Active";
		try{
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/test";
		Connection con=DriverManager.getConnection(url, "root", "");
		con.setAutoCommit(false);
		  
		Calendar calendar = Calendar.getInstance();
		      java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
		       //java.sql.Date expiryDate = new java.sql.Date(calendar.getTime().getTime());
		        //id=b.id;
		      //Scanner input = new Scanner(System.in);
		      System.out.print("Enter Date: ");
		    	String expiryDate = input.next();
		    	System.out.println("Date entered = " + expiryDate);
		        //String expiryDate = "2019-01-31 " ;
		PreparedStatement pst=con.prepareStatement("insert into quickbus values(?,?,?,?,?,?,?,?,?)");
		
		pst.setString(1,null);
		pst.setString(2,saltStr); 
		pst.setInt(3,fare);
		pst.setInt(4,disamnt);
		pst.setString(5,from);
		pst.setString(6,to);
		pst.setString(7,staus);
		pst.setDate(8,startDate);
		pst.setString(9,expiryDate);
		//String s=result.get(0);

		    
		  
		pst.executeUpdate();
		
		System.out.println("Promo code Added");
		 
		//pst.close();
		con.commit();
		con.close();

		}
		catch(Exception e){
		e.printStackTrace();
		}
		
	}
	
	// get all promo codes
public static void getdata() {
	try{

		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/test";
		Connection con=DriverManager.getConnection(url, "root", "");
		con.setAutoCommit(false);
		// if you only need a few columns, specify them by name instead of using "*"
	      //String query = "SELECT * FROM quickbus";
	      PreparedStatement st = con.prepareStatement( "SELECT * FROM quickbus");
	      // create the java statement
	     // Statement st = con.createStatement();
	      
	      // execute the query, and get a java resultset
	     // ResultSet rs = st.executeQuery(query);
	      ResultSet rs = st.executeQuery();
	      
	      // iterate through the java resultset
	      while (rs.next())
	      {
	        int id = rs.getInt("id");
	        String code = rs.getString("code");
	        
	        
	        // print the results
	        System.out.format("%s, %s, %s, %s, %s, %s\n", id, code);
	      }
	      System.out.println("No Promo code");
	      st.close();
	    }
	    catch (Exception e)
	    {
	      //System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
	  }

// get Active promo codes
public static void getactivedata() {
	try{

		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/test";
		Connection con=DriverManager.getConnection(url, "root", "");
		con.setAutoCommit(false);
		// if you only need a few columns, specify them by name instead of using "*"
	      //String query = "SELECT * FROM quickbus where status = active";
	      PreparedStatement st = con.prepareStatement("SELECT * FROM quickbus where status = ?");
	      st.setString(1, "active"); 
	      
	      // execute the query, and get a java resultset
	     // ResultSet rs = st.executeQuery(query);
	      ResultSet rs = st.executeQuery();
	      
	      // iterate through the java resultset
	      while (rs.next())
	      {
	        int id = rs.getInt("id");
	        String code = rs.getString("code");
	        
	        
	        // print the results of active codes
	        System.out.println("Active Promo code");
	        System.out.format("Active Promo codes:");
	        System.out.format("%s, %s, %s, %s, %s, %s\n", id, code);
	      }
	      
	      System.out.println("Not Active Promo code");
	      st.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
	  }
//Deactivate promo codes
	public static void deactivate(int id) {
		 try
		    {
		      // create a java mysql database connection
			 Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/test";
				Connection con=DriverManager.getConnection(url, "root", "");
				con.setAutoCommit(false);
		      
		    
		      // create the java mysql update preparedstatement
				//enter id to be deactivated
				Scanner input = new Scanner(System.in);
				// Getting String input
		    	System.out.print("Enter text: ");
		    	String myString = input.next();
		    	System.out.println("Text entered = " + myString);
		      String query = "update quickbus set status = ? where id = ?";
		      PreparedStatement preparedStmt = con.prepareStatement(query);
		      preparedStmt.setString   (1,null);
		      preparedStmt.setString(2, "deactivated");

		      // execute the java preparedstatement
		      preparedStmt.executeUpdate();
		      
		      con.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }
	}
	
	//get valid code
	public static void getvalid(String dest, String code) {
		try{

			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test";
			Connection con=DriverManager.getConnection(url, "root", "");
			//con.setAutoCommit(false);
			
	    	System.out.println("Dest entered = " + dest);
			// if you only need a few columns, specify them by name instead of using "*"
		    //  String query = "SELECT * FROM quickbus WHERE dest=" +dest ;
	    	 // String query = "SELECT * FROM quickbus WHERE dest=?" ;
		      // create the java statement
	    	  PreparedStatement st = con.prepareStatement("SELECT * FROM quickbus WHERE dest=? and code=?");
	    			  
	    			  //con.createStatement();
	    	 st.setString(1, dest); 
	    	 st.setString(2, code); 
		      // execute the query, and get a java resultset
		     // ResultSet rs = st.executeQuery(query);
	    	 ResultSet rs = st.executeQuery();
		      // iterate through the java resultset
		      while (rs.next())
		      {
		        int id = rs.getInt("id");
		        String code1 = rs.getString("code");
		        String code_amount = rs.getString("code_amount");
		        String status = rs.getString("status");
		        String expiry_date = rs.getString("expiry_date");
		        
		        System.out.println("Valid code");
		        // print the results of active codes
		        System.out.format("Valid Promo codes:");
		        System.out.format("%s, %s, %s, %s, %s, %s\n", id, code1,code_amount,status,expiry_date);
		      }
		      st.close();
		      System.out.println("Invalid code");
		    }
		    catch (Exception e)
		    {
		      
		      System.err.println(e.getMessage());
		     // System.out.println("InValid code");
		      //System.err.println("Invalid Promo Code! ");
		    }
		  }
}
//}
