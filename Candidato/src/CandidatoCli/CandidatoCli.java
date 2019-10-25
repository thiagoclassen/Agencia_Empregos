package CandidatoCli;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

import Interfaces.InterfaceCandidato;
import Objects.Curriculo;
import Objects.Vaga;

public class CandidatoCli {
    public static void main(String[] args) throws Exception {

        int input;
        Curriculo curriculo;
        Vaga vaga;
        Scanner keyboard = new Scanner(System.in);

        // seta politicas de segurança
        System.setSecurityManager(null);

        // busca registro
        Registry registroServer = LocateRegistry.getRegistry(1337);

        // cria referencia do client
        InterfaceImplCli referenciaCli = new InterfaceImplCli();

        // recebe referencia do objeto e faz cast para interface
        InterfaceCandidato candRef = (InterfaceCandidato) registroServer.lookup("candidato");

        System.out.println("Server Running...");
        
        // menu de interação
        do {

            System.out.println("Selecione a opção desejada");
            System.out.println("1 - Para Cadastrar curriculo");
            System.out.println("2 - Para Consultar Vagas");
            System.out.println("3 - Para receber updates automaticos");

            input = keyboard.nextInt();
            keyboard.nextLine();

            switch (input) {
            case 1:
                // cadastrar curriculo
                curriculo = new Curriculo();
                curriculo.preencherCampos();
                candRef.cadastroCurriculo(referenciaCli, curriculo);
                break;
            case 2:
                // consultar vagas
                vaga = new Vaga();

                System.out.println("Qual a area de interesse?");
                vaga.setArea(keyboard.nextLine());

                System.out.println("Qual o salario minimo?");
                vaga.setSalario(keyboard.nextInt());
                keyboard.nextLine();

                ArrayList<Vaga> resp = candRef.consultaVagas(referenciaCli, vaga);
                if (!resp.isEmpty()) {
                    resp.forEach((x) -> {
                        x.print();
                    });
                } else {
                    System.out.println("Nenhuma vaga Encontrada");
                }

                break;
            case 3:
                // receber updates
                System.out.println("Qual a area de interesse?");
                candRef.registrarInteresseVagas(referenciaCli, keyboard.nextLine());
                break;
            case 9:
                // sair
                break;
            default:
                System.out.println("Apenas valores entre 1 e 3");
            }
        } while (input != 9);

        keyboard.close();
    }
}