import java.rmi.*;
import java.rmi.server.*;

public class RemoteCmdImpl extends UnicastRemoteObject
	implements RemoteCmdIntf {
	
	public RemoteCmdImpl() throws RemoteException {
	}

	public int cmd(String cmdstr) throws RemoteException {
		int result = 0;

		Runtime r = Runtime.getRuntime();
		Process p = null;
		
		try {
			p = r.exec(cmdstr);
		} catch (Exception e) {
			result = 1;
		}
		
		return result;
	}
}