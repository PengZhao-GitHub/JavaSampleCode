import java.rmi.*;
import java.rmi.activation.*;

public class RemoteCmdImpl extends Activatable 

	implements RemoteCmdIntf {
	
	public RemoteCmdImpl(ActivationID id, MarshalledObject data) 
            throws RemoteException {
            // Register the object with the activation system
            // then export it on an anonymous port
            super(id, 0); 
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