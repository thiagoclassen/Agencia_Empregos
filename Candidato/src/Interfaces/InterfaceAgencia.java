package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Objects.Curriculo;
import Objects.Vaga;

public interface InterfaceAgencia extends Remote {
    public void chamar(String msg, InterfaceCli interfaceCli) throws RemoteException;

    public void cadastroVagas(InterfaceCli referenciaCli, Vaga vaga) throws RemoteException;

    public void consultaCurriculos(InterfaceCli referenciaCli, Curriculo curriculo) throws RemoteException;

    public void registrarInteresseProfissionais(InterfaceCli referenciaCli, String areaOferta) throws RemoteException;

}