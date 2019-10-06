import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import Bank.*;

public class Client {  
	public static void main(String[] args) {      
		// Initialize the ORB.      
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);      
	
		// Get the manager Id      
		byte[] managerId = "BankManager".getBytes();      
	
		// Locate an account manager. Give the full POA name and the servant ID.    
		Bank.AccountManager manager =            
			Bank.AccountManagerHelper.bind(orb, "/bank_agent_poa", managerId);

		// use args[0] as the account name, or a default.      
		String name = args.length > 0 ? args[0] : "Jack B. Quick";      
	
		// Request the account manager to open a named account.      
		Bank.Account account = manager.open(name);      
	
		// Get the balance of the account.      
		float balance = account.balance();      
	
		// Print out the balance.      
		System.out.println("The balance in " + name + "'s account is $" + balance);   
	
	}
}
