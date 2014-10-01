
import java.rmi.*;
import java.rmi.server.*;

import pkginterface.Cliente;

class ClienteImpl extends UnicastRemoteObject implements Cliente {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ClienteImpl() throws RemoteException {
		super();
    }
    public void notificacion(String apodo, String m) throws RemoteException {
        System.out.println("\n" + apodo + "> " + m);
    }
}