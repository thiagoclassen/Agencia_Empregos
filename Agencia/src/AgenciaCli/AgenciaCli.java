package AgenciaCli;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

import Interfaces.InterfaceAgencia;
import Objects.Curriculo;
import Objects.Vaga;

public class AgenciaCli {
    public static void main(String[] args) throws Exception {

        System.setSecurityManager(null);

        Registry registroServer = LocateRegistry.getRegistry(1337);

        Curriculo curriculo;
        Vaga vaga;
        Scanner keyboard;

        InterfaceImplCli referenciaCli = new InterfaceImplCli();

        InterfaceAgencia candRef = (InterfaceAgencia) registroServer.lookup("agencia");

        System.out.println("Server Running...");

        int input;

        do {

            keyboard = new Scanner(System.in);

            // System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("Selecione a opção desejada");
            System.out.println("1 - Para Cadastrar vaga");
            System.out.println("2 - Para Consultar curriculos");
            System.out.println("3 - Para receber updates automaticos");

            input = keyboard.nextInt();
            keyboard.nextLine();

            switch (input) {
            case 1:
                // cadastrar vaga
                vaga = new Vaga();
                vaga.preencherCampos();
                candRef.cadastroVagas(referenciaCli, vaga);
                break;
            case 2:
                // consultar curriculos
                curriculo = new Curriculo();

                System.out.println("Qual a area de interesse?");
                curriculo.setArea(keyboard.nextLine());

                System.out.println("Qual o salario ofertado?");
                curriculo.setSalario(keyboard.nextInt());
                keyboard.nextLine();

                ArrayList<Curriculo> resp = candRef.consultaCurriculos(referenciaCli, curriculo);
                if (!resp.isEmpty()) {
                    resp.forEach((x) -> {
                        x.print();
                    });
                } else {
                    System.out.println("Nenhum curriculo encontrado");
                }

                break;
            case 3:
                // receber updates
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