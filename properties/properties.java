
import java.util.*;
import java.io.*;

public class properties{ 
	public static void main(String args[]){
		try{

			/* Setting Up Properties Object */
			/********************************/
			// Create and load default properties
	       	Properties defaultProps = new Properties();
			FileInputStream in = new FileInputStream("defaultProperties");
	        defaultProps.load(in);
	        in.close();
			
			// Create program properties with default
			Properties applicationProps = new Properties(defaultProps);

			// Now load properties from last invocation
			in = new FileInputStream("appProperties");
			applicationProps.load(in);
			in.close();


			/* Writing Property Information */
			/********************************/
			applicationProps.setProperty("key1", "Peng Zhao");
			applicationProps.setProperty("key2", "Min Tai");
			applicationProps.setProperty("key3", "Baby");

			/* Get Property */
			System.out.println("key1 = " + applicationProps.getProperty("key1"));
			System.out.println("key2 = " + applicationProps.getProperty("key2"));
			System.out.println("key3 = " + applicationProps.getProperty("key3"));

			/* list */
			applicationProps.list(System.out);
			
			/* Saving Properties */
			/*********************/
			FileOutputStream out = new FileOutputStream("appProperties");
			applicationProps.store(out, "---No Comment---");
			out.close();
		
		} catch(Exception ex){
			System.out.println(ex);
		} 
  	}
}