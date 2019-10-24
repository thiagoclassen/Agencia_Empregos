package Servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Interfaces.InterfaceAgencia;
import Interfaces.InterfaceCli;
import Objects.Curriculo;
import Objects.Vaga;

public class AgenciaImpl extends UnicastRemoteObject implements InterfaceAgencia {

    private Base base;

    protected AgenciaImpl(Base base) throws RemoteException {
        super();
        this.base = base;
    }

    private static final long serialVersionUID = 2241569544740392197L;

    @Override
    public void chamar(String msg, InterfaceCli interfaceCli) throws RemoteException {
        System.out.println("Recebido: " + msg);
        interfaceCli.echo(msg);
    }

    @Override
    public void cadastroVagas(InterfaceCli referenciaCli, Vaga vaga) throws RemoteException {
        this.base.addVaga(vaga);
        System.out.println("Vaga cadastrada");
    }

    @Override
    public ArrayList<Curriculo> consultaCurriculos(InterfaceCli referenciaCli, Curriculo curriculo)
            throws RemoteException {
        return this.base.consultaCurriculo(curriculo);

    }

    @Override
    public void registrarInteresseProfissionais(InterfaceCli referenciaCli, String areaOferta) throws RemoteException {
        // TODO Auto-generated method stub

    }

}