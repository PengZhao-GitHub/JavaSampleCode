import java.rmi.*;

public class RemoteCmdClient {
	public static void main(String args[]) {
		if (args.length != 2) {
			System.out.println("usage: RemoteCmdClient RemoteServerName Command");
			return;
		}
	
		try {
			String serverURL = "rmi://" + args[0] + "/RemoteCmdServer";
			RemoteCmdIntf serverIntf = 
				(RemoteCmdIntf)Naming.lookup(serverURL);
			
			serverIntf.cmd(args[1]);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
}