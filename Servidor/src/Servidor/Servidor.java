package Servidor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) throws Exception {
        
        // instancia nossa base de dados
        Base base = new Base();

        // seta politicas de segurança
        System.setSecurityManager(null);
        
        // cria o servidor de registro
        Registry referenciaRegistro = LocateRegistry.createRegistry(1337);

        /*
         * instancia a implementação da interface de candidatos, 
         * passando a base de dados como referencia
        */
        CandidatoImpl candidato = new CandidatoImpl(base);
        
        /*
         * instancia a implementação da interface de agencias, 
         * passando a base de dados como referencia
        */
        AgenciaImpl agencia = new AgenciaImpl(base);

        // registra a referencia do candidato
        referenciaRegistro.bind("candidato", candidato);

        // registra a referencia da agencia
        referenciaRegistro.bind("agencia", agencia);

        System.out.println("Server Running...");
    }
}