package CandidatoCli;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Interfaces.InterfaceCandidato;
import Objects.Curriculo;

public class CandidatoCli {
    public static void main(String[] args) throws Exception {
        
        System.setSecurityManager(null);
        
        Registry registroServer = LocateRegistry.getRegistry(1337);

        Curriculo cur = new Curriculo();

        cur.setArea("Teste");
        cur.setCargaHoraria(8);
        cur.setContato("jao");
        cur.setNome("Candi");
        cur.setSalario(700);

        InterfaceImplCli cand = new InterfaceImplCli();

        InterfaceCandidato candRef = (InterfaceCandidato) registroServer.lookup("candidato");

        candRef.cadastroCurriculo(cand, cur);

        int input = 1;

        do{
            switch(input) {
            case 0:
                // code block
                break;
            case 1:
                // code block
                break;
            default:
                // code block
            }
        }while(input != 9);


        System.out.println("Server Running...");
    }
}