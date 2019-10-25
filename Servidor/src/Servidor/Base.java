package Servidor;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import Interfaces.InterfaceCli;
import Objects.Curriculo;
import Objects.Vaga;

public class Base {

    // array para armazenamento de curriculos
    private ArrayList<Curriculo> curriculos;
    // array para armazenamento de vagas
    private ArrayList<Vaga> vagas;
    // array armazenamento e classificação de subscribers
    private HashMap<String, ArrayList<InterfaceCli>> subscribers;

    // inicia os arrays no construtor
    public Base() {
        this.curriculos = new ArrayList<>();
        this.vagas = new ArrayList<>();
        this.subscribers = new HashMap<>();
    }

    // adicionar curriculo
    public void addCuriculo(Curriculo curriculo) {
        this.curriculos.add(curriculo);
    }

    // remove curriculo
    public void removeCuriculo(Curriculo curriculo) {
        this.curriculos.remove(curriculo);
    }

    // adicionar vaga
    public void addVaga(Vaga vaga) {
        this.vagas.add(vaga);
    }

    // remove vaga
    public void removeVaga(Vaga vaga) {
        this.vagas.remove(vaga);
    }

    // retorna todas vagas
    public String listVagas() {
        return this.vagas.toString();
    }

    // retorna todos curriculos
    public String listCurriculos() {
        return this.curriculos.toString();
    }

    // consulta as vagas baseado nos parametros do objeto passado
    public ArrayList<Vaga> consultaVaga(Vaga vaga) {
        ArrayList<Vaga> temp = new ArrayList<>();

        for (Vaga oferta : this.vagas) {
            if (oferta.getArea().equalsIgnoreCase(vaga.getArea()) && vaga.getSalario() >= oferta.getSalario())
                temp.add(oferta);
        }

        return temp;
    }

    // consulta curriculos baseado nos parametros do objeto passado
    public ArrayList<Curriculo> consultaCurriculo(Curriculo curriculo) {
        ArrayList<Curriculo> temp = new ArrayList<>();

        for (Curriculo candidato : this.curriculos) {
            if (candidato.getArea().equalsIgnoreCase(curriculo.getArea())
                    && curriculo.getSalario() >= candidato.getSalario())
                temp.add(candidato);
        }

        return temp;
    }

    // adiciona o client para a lista de subscribers de novos candidatos
    public void addCandidatosSubscribers(String area, InterfaceCli cli) {
        ArrayList<InterfaceCli> subList = this.subscribers.get("canditato:" + area);

        if (subList == null) {
            this.subscribers.put("canditato:" + area, new ArrayList<InterfaceCli>());
            subList = this.subscribers.get("canditato:" + area);
        }

        subList.add(cli);
        this.subscribers.put("canditato:" + area, subList);
    }

    // adiciona o client para a lista de subscribers de novas vagas
    public void addVagasSubscribers(String area, InterfaceCli cli) {
        ArrayList<InterfaceCli> subList = this.subscribers.get("vaga:" + area);

        if (subList == null) {
            this.subscribers.put("vaga:" + area, new ArrayList<InterfaceCli>());
            subList = this.subscribers.get("vaga:" + area);
        }

        subList.add(cli);
        this.subscribers.put("vaga:" + area, subList);
    }

    // retorna os subscribers de vagas
    public ArrayList<InterfaceCli> getVagasSubscribers(String area) {
        return this.subscribers.get("vaga:" + area);
    }

    // retorna os subscribers de candidatos
    public ArrayList<InterfaceCli> getCandidatosSubscribers(String area) {
        return this.subscribers.get("canditato:" + area);
    }

    // notifica os subscribers de vagas
    public void notifyVagas(Vaga vaga) throws RemoteException {
        ArrayList<InterfaceCli> list = getVagasSubscribers(vaga.getArea());

        if (list != null) {
            for (InterfaceCli cli : list) {
                cli.echo("nova Vaga na area de:" + vaga.getArea());
            }
        }

    }

    // notifica os subscribers de candidatos
    public void notifyCandidatos(Curriculo curriculo) throws RemoteException {
        ArrayList<InterfaceCli> list = getCandidatosSubscribers(curriculo.getArea());
        if (list != null) {
            for (InterfaceCli cli : list) {
                cli.echo("novo Curriculo na area de:" + curriculo.getArea());
            }
        }

    }

}