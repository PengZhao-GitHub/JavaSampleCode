import java.net.*;
import java.rmi.*;

public class RemoteCmdServer {
	public static void main(String args[]) {
		try{
			RemoteCmdImpl cmdImpl = new RemoteCmdImpl();
			Naming.rebind("RemoteCmdServer", cmdImpl);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
} 