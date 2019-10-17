package Servidor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) throws Exception {
        
        System.setSecurityManager(null);
        
        Registry referenciaServicoNomes = LocateRegistry.createRegistry(1337);
        
        AgenciaImpl agencia = new AgenciaImpl();

        CandidatoImpl candidato = new CandidatoImpl();

        referenciaServicoNomes.bind("candidato", candidato);

        referenciaServicoNomes.bind("agencia", agencia);
        
        System.out.println("Server Running...");
    }
}