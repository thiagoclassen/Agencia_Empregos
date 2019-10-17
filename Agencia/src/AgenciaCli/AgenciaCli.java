package AgenciaCli;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AgenciaCli {
    public static void main(String[] args) throws Exception {
        
        System.setSecurityManager(null);
        
        Registry referenciaServicoNomes = LocateRegistry.createRegistry(1337);
        
        System.out.println("Server Running...");
    }
}