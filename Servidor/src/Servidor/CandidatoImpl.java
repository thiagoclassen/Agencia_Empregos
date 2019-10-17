package Servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Interfaces.InterfaceCandidato;
import Interfaces.InterfaceCli;
import Objects.Curriculo;
import Objects.Vaga;
import Servidor.Base;

public class CandidatoImpl extends UnicastRemoteObject implements InterfaceCandidato {
    
    private static final long serialVersionUID = 2241569544740392197L;

    protected CandidatoImpl() throws RemoteException {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void chamar(String msg, InterfaceCli interfaceCli) throws RemoteException {
        System.out.println("Recebido: " + msg);
        interfaceCli.echo(msg);
    }

    @Override
    public void cadastroCurriculo(InterfaceCli referenciaCli, Curriculo curriculo) throws RemoteException {
        Base.addCuriculo(curriculo);
    }

    @Override
    public void consultaVagas(InterfaceCli referenciaCli, Vaga vaga) throws RemoteException {
        // TODO Auto-generated method stub

    }

    @Override
    public void registrarInteresseVagas(InterfaceCli referenciaCli, String areaInteresse) throws RemoteException {
        // TODO Auto-generated method stub

    }

}