import java.rmi.*;

public interface RemoteCmdIntf extends Remote {
	int cmd(String cmdstr) throws RemoteException;
}

