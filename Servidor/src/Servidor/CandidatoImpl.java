package Servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Interfaces.InterfaceCandidato;
import Interfaces.InterfaceCli;
import Objects.Curriculo;
import Objects.Vaga;

public class CandidatoImpl extends UnicastRemoteObject implements InterfaceCandidato {

    private static final long serialVersionUID = 2241569544740392197L;

    private Base base;

    protected CandidatoImpl(Base base) throws RemoteException {
        super();
        this.base = base;
    }

    @Override
    public void chamar(String msg, InterfaceCli interfaceCli) throws RemoteException {
        System.out.println("Recebido: " + msg);
        interfaceCli.echo(msg);
    }

    @Override
    public void cadastroCurriculo(InterfaceCli referenciaCli, Curriculo curriculo) throws RemoteException {
        this.base.addCuriculo(curriculo);
        this.base.notifyCandidatos(curriculo);
    }

    @Override
    public ArrayList<Vaga> consultaVagas(InterfaceCli referenciaCli, Vaga vaga) throws RemoteException {
        return this.base.consultaVaga(vaga);
    }

    @Override
    public void registrarInteresseVagas(InterfaceCli referenciaCli, String areaInteresse) throws RemoteException {
        this.base.addVagasSubscribers(areaInteresse, referenciaCli);
    }

}