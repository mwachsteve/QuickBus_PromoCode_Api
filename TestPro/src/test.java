import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.QuickBus.PromcodeApi.Promocode;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println();
		//method for generating random or promo codes 
		// d = 2 no of codes
		//for(int d=0; d<2;d++) {
		//System.out.println(Promocode.generateRandomChars(
	    //        "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890", 8));
		//}
		Scanner input3 = new Scanner(System.in);
		System.out.print("Enter code: ");
		String code = input3.next();
		Scanner input4 = new Scanner(System.in);
		System.out.print("Enter Origin: ");
    	String orig = input4.next();
    	Scanner input5 = new Scanner(System.in);
    	System.out.print("Enter destination: ");
    	String dest = input5.next();
		Promocode.getvalid(dest,code);
    	//getvalid(dest,code);
		
		//Promocode.getdata();
    	
    	
	}
	
}
