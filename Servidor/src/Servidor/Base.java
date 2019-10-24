package Servidor;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import Interfaces.InterfaceCli;
import Objects.Curriculo;
import Objects.Vaga;

public class Base {
    private ArrayList<Curriculo> curriculos;
    private ArrayList<Vaga> vagas;
    private HashMap<String, ArrayList<InterfaceCli>> subscribers;

    public Base() {
        this.curriculos = new ArrayList<>();
        this.vagas = new ArrayList<>();
        this.subscribers = new HashMap<>();
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
            if (oferta.getArea().equalsIgnoreCase(vaga.getArea()) && vaga.getSalario() >= oferta.getSalario())
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

    // para quem oferece
    public void addCandidatosSubscribers(String area, InterfaceCli cli) {
        ArrayList<InterfaceCli> subList = this.subscribers.get("canditato:" + area);

        if (subList == null) {
            this.subscribers.put("canditato:" + area, new ArrayList<InterfaceCli>());
            subList = this.subscribers.get("canditato:" + area);
        }

        subList.add(cli);
        this.subscribers.put("canditato:" + area, subList);
    }

    // para quem procura
    public void addVagasSubscribers(String area, InterfaceCli cli) {
        ArrayList<InterfaceCli> subList = this.subscribers.get("vaga:" + area);

        if (subList == null) {
            this.subscribers.put("vaga:" + area, new ArrayList<InterfaceCli>());
            subList = this.subscribers.get("vaga:" + area);
        }

        subList.add(cli);
        this.subscribers.put("vaga:" + area, subList);
    }

    public ArrayList<InterfaceCli> getVagasSubscribers(String area) {
        return this.subscribers.get("vaga:" + area);
    }

    public ArrayList<InterfaceCli> getCandidatosSubscribers(String area) {
        return this.subscribers.get("canditato:" + area);
    }

    public void notifyVagas(Vaga vaga) throws RemoteException {
        ArrayList<InterfaceCli> list = getVagasSubscribers(vaga.getArea());

        if (list != null) {
            for (InterfaceCli cli : list) {
                cli.echo("nova Vaga na area de:" + vaga.getArea());
            }
        }

    }

    public void notifyCandidatos(Curriculo curriculo) throws RemoteException {
        ArrayList<InterfaceCli> list = getCandidatosSubscribers(curriculo.getArea());
        if (list != null) {
            for (InterfaceCli cli : list) {
                cli.echo("novo Curriculo na area de:" + curriculo.getArea());
            }
        }

    }

    // #region Getters and Setters

    // #endregion
}