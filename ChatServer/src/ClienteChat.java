
import java.rmi.*;
import java.util.*;

import pkginterface.*;

class ClienteChat {
    private static Scanner ent;

	static public void main (String args[]) throws RemoteException, AlreadyBoundException, NotBoundException  {
		
        System.setSecurityManager(new SecurityManager());

        try {
            ServicioChat srv = (ServicioChat) Naming.lookup("rmi://localhost:222/chat");
            ClienteImpl c = new ClienteImpl();
            srv.alta(c);
            ent = new Scanner(System.in);
            String apodo = "Edmundo" + (Math.random()*1000);
            System.out.print(apodo + "> ");
            while (ent.hasNextLine()) {
                srv.envio(c, apodo, ent.nextLine());
                System.out.print(apodo + "> ");
            }
            srv.baja(c);
            System.exit(0);
        }
        catch (RemoteException e) {
            System.err.println("Error de comunicacion: " + e.toString());
        }
        catch (Exception e) {
            System.err.println("Excepcion en ClienteChat:");
            e.printStackTrace();
        }
    }
}