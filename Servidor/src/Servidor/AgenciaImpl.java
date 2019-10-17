package Servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Interfaces.InterfaceAgencia;
import Interfaces.InterfaceCli;
import Objects.Curriculo;
import Objects.Vaga;

public class AgenciaImpl extends UnicastRemoteObject implements InterfaceAgencia {

    protected AgenciaImpl() throws RemoteException {
        super();
        // TODO Auto-generated constructor stub
    }

    private static final long serialVersionUID = 2241569544740392197L;

    @Override
    public void chamar(String msg, InterfaceCli interfaceCli) throws RemoteException {
        System.out.println("Recebido: " + msg);
        interfaceCli.echo(msg);
    }

    @Override
    public void cadastroVagas(InterfaceCli referenciaCli, Vaga vaga) throws RemoteException {
        // TODO Auto-generated method stub

    }

    @Override
    public void consultaCurriculos(InterfaceCli referenciaCli, Curriculo curriculo) throws RemoteException {
        // TODO Auto-generated method stub

    }

    @Override
    public void registrarInteresseProfissionais(InterfaceCli referenciaCli, String areaOferta) throws RemoteException {
        // TODO Auto-generated method stub

    }

}