import java.rmi.*;
import java.rmi.server.*;

public class RemoteCmdImpl extends UnicastRemoteObject
	implements RemoteCmdIntf {
	
	private static int client = 0;

	public RemoteCmdImpl() throws RemoteException {
	}

	public int cmd(String cmdstr) throws RemoteException {
		client++;
		System.out.println("Client " + client + " connected!");
		while(!cmdstr.equals("end"));		
		return 0;
	}
}