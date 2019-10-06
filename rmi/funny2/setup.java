import java.rmi.*;
import java.rmi.activation.*;
import java.util.Properties;

public class setup{ 

     public static void main(String[] args) throws Exception {
            Properties props = new Properties();
            props.put("java.security.policy", "F:/MyWork/java/rmi/funny2/policy");
            
            ActivationGroupDesc.CommandEnvironment ace = null; 
 	    ActivationGroupDesc exampleGroup = new ActivationGroupDesc(props, ace);
      
            ActivationGroupID agi = 
                         ActivationGroup.getSystem().registerGroup(exampleGroup);                	

            String location = "file:F:/MyWork/java/rmi/funny2/";

            MarshalledObject data = null;

	    ActivationDesc desc = new ActivationDesc 
	                 ("RemoteCmdImpl", location, data);
 
	    RemoteCmdIntf mri = (RemoteCmdIntf)Activatable.register(desc);

	    System.out.println("Got the stub for the ActivatableImplementation");
        
	    Naming.rebind("RemoteCmdImpl", mri);

	    System.out.println("Exported RemoteCmdImpl");

	    System.exit(0);

     }
}