package Servidor;

import java.util.List;

import Objects.Curriculo;
import Objects.Vaga;

public class Base {
    private static List<Curriculo> curriculos;
    private static List<Vaga> vagas;

    public Base(){  }

    public static void addCuriculo(Curriculo curriculo){
        curriculos.add(curriculo);
    }

    public static void removeCuriculo(Curriculo curriculo){
        curriculos.remove(curriculo);
    }

    public static void addVaga(Vaga vaga){
        vagas.add(vaga);
    }

    public static void removeVaga(Vaga vaga){
        vagas.remove(vaga);
    }

    //#region Getters and Setters
   
    //#endregion
}