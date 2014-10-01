
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import pkginterface.Constant;
import pkginterface.RemoteImpl;

class ServidorChat{
	
	/**
	* @param args the command line arguments
	* @throws java.rmi.RemoteException
	* @throws AlreadyBoundException
	*/
    @SuppressWarnings("deprecation")
    
    
	static public void main (String args[]) throws RemoteException, AlreadyBoundException {
    	
    	
    	RemoteImpl impl = new RemoteImpl();
        Registry reg = LocateRegistry.createRegistry(Constant.RMI_PORT);
        reg.bind(Constant.RMI_ID, impl);
        System.out.println("Server is ready!");
    	
    	System.setSecurityManager(new RMISecurityManager());
        try {
        	ServicioChatImpl srv = new ServicioChatImpl ();
            Naming.rebind("rmi://localhost:222/chat", srv);
        }
        catch (RemoteException e) {
            System.err.println("Error de comunicacion: " + e.toString());
            System.exit(1);
        }
        catch (Exception e) {
            System.err.println("Excepcion en Servidor:");
            e.printStackTrace();
            System.exit(1);
        }
    }
}