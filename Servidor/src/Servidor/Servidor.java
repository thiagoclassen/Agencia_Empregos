package Servidor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) throws Exception {
        
        System.setSecurityManager(null);
        
        Registry referenciaServicoNomes = LocateRegistry.createRegistry(1337);
        
        ServImpl servImpl = new ServImpl();

        referenciaServicoNomes.bind("servis", servImpl);
        
        System.out.println("Hello Java");
    }
}