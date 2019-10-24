package Servidor;

import java.util.ArrayList;

import Objects.Curriculo;
import Objects.Vaga;

public class Base {
    private ArrayList<Curriculo> curriculos;
    private ArrayList<Vaga> vagas;

    public Base() {
        this.curriculos = new ArrayList<>();
        this.vagas = new ArrayList<Vaga>();
    }

    public void addCuriculo(Curriculo curriculo) {
        this.curriculos.add(curriculo);
    }

    public void removeCuriculo(Curriculo curriculo) {
        this.curriculos.remove(curriculo);
    }

    public void addVaga(Vaga vaga) {
        this.vagas.add(vaga);
    }

    public void removeVaga(Vaga vaga) {
        this.vagas.remove(vaga);
    }

    public String listVagas() {
        return this.vagas.toString();
    }

    public String listCurriculos() {
        return this.curriculos.toString();
    }

    public ArrayList<Vaga> consultaVaga(Vaga vaga) {
        ArrayList<Vaga> temp = new ArrayList<>();
        
        for (Vaga oferta : this.vagas) {
            if (oferta.getArea().equalsIgnoreCase(vaga.getArea())
                    && vaga.getSalario() >= oferta.getSalario())
                temp.add(oferta);
        }

        return temp;
    }

    public ArrayList<Curriculo> consultaCurriculo(Curriculo curriculo) {
        ArrayList<Curriculo> temp = new ArrayList<>();

        for (Curriculo candidato : this.curriculos) {
            if (candidato.getArea().equalsIgnoreCase(curriculo.getArea())
                    && curriculo.getSalario() >= candidato.getSalario())
                temp.add(candidato);
        }

        return temp;
    }

    // #region Getters and Setters

    // #endregion
}