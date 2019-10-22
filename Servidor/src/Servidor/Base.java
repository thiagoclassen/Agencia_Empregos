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
        this.vagas.forEach((oferta) -> {
            if (oferta.getArea().equalsIgnoreCase(vaga.getArea()) && oferta.getSalario() >= vaga.getSalario())
                temp.add(vaga);
        });

        return temp;
    }

    public ArrayList<Curriculo> consultaCurriculo(String area) {
        ArrayList<Curriculo> temp = new ArrayList<>();
        this.curriculos.forEach((curriculo) -> {
            if (curriculo.getArea().equalsIgnoreCase(area))
                temp.add(curriculo);
        });

        return temp;
    }

    // #region Getters and Setters

    // #endregion
}